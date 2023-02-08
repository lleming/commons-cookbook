package org.example;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import org.apache.commons.collections.IteratorUtils;
import org.apache.commons.digester.Digester;
import org.apache.commons.digester.xmlrules.DigesterLoader;
import org.apache.commons.io.IOUtils;
import org.apache.commons.jxpath.JXPathContext;
import org.example.xpath.League;
import org.example.xpath.Person;
import org.example.xpath.Team;
import org.junit.Assert;
import org.junit.Test;
import org.xml.sax.SAXException;

public class XPathTest {

  @Test
  public void testXpath() {
    League league = new League();
    Team team = new Team();
    league.getTeams().add(team);

    team.setCoach(new Person("Coach Bob"));
    team.getPlayers().add(new Person("Player Charly"));
    team.getPlayers().add(new Person("Player Ted"));
    team.getPlayers().add(new Person("Player Bart"));

    Team team1 = new Team();
    league.getTeams().add(team1);
    team1.setCoach(new Person("Coach Susan"));

    team1.getPlayers().add(new Person("Player Jim"));

    JXPathContext context = JXPathContext.newContext(league);

    String xpath = "teams/players[firstName='Player Ted']";

    Object value = context.getValue(xpath);

    Assert.assertEquals(new Person("Player Ted"), value);

    String xpathPlayers = "teams/coach[firstName='Coach Susan']/../players";
    Object players = context.getValue(xpathPlayers);
    Assert.assertTrue(players instanceof List);
    Assert.assertEquals(1, ((List) players).size());
  }

  @Test
  public void testQueryCollectionWithXpath() {
    List peoples = new ArrayList();
    peoples.add(new Person("Ahmad", "Russel", 28));
    peoples.add(new Person("Tom", "Russell", 35));
    peoples.add(new Person("Ahmad", "Abuzayedeh", 33));

    JXPathContext context = JXPathContext.newContext(peoples);

    Iterator iterator = context.iterate(".[@age > 30]");
    List found = IteratorUtils.toList(iterator);
    Assert.assertEquals(2, found.size());

    Object value = context.getValue(".[2]"); //xpath count starts from '1'
    Assert.assertEquals(new Person("Tom", "Russell", 35), value);
  }

  @Test
  public void testComplexObjectGraph() throws IOException, SAXException {
    List planets = new ArrayList();
    InputStream input = null;
    try {
      input = getClass().getClassLoader().getResourceAsStream("planets.xml");
      URL rules = getClass().getClassLoader().getResource("planet-digester-rules.xml");
      Digester digester = DigesterLoader.createDigester(rules);
      digester.push(planets);
      digester.parse(input);

      JXPathContext context = JXPathContext.newContext(planets);
      Iterator iterator = context.iterate(".[@radius>5000]/name");
      Collection names = IteratorUtils.toList(iterator);
      Assert.assertEquals(Arrays.asList("Venus", "Saturn"), names);

      context.getVariables().declareVariable("moonName", "Deimos");
      iterator = context.iterate("./moons[.=$moonName]/../name");
      Collection foundPlanets = IteratorUtils.toList(iterator);
      Assert.assertEquals(Arrays.asList("Mars"), foundPlanets);
    } finally {
      IOUtils.closeQuietly(input);
    }

  }
}








package org.example;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import org.junit.Test;

public class JexlExpressionTemplate {

  private String expected;

  @Test
  public void testSimpleJexlExpression() throws Exception {
    Opera opera = new Opera();
    opera.setName("The magic flute");
    opera.setComposer("Mozart");
    opera.setYear(1971);

    String expr = "${opera.name} was composed by ${opera.composer} in ${opera.year}.";

    // next part will fail to compile due expression error
    // jexl documentation doesn't clarify what expression it uses
    // stay away from jexl
    // use, `normal`, tools, those provide good documentation (free marker)

//    Expression expression = ExpressionFactory.createExpression(expr);
//    JexlContext context = JexlHelper.createContext();
//    context.getVars().put("opera", opera);
//
//    String actualMessage = (String) expression.evaluate(context);
//    String expected = "The magic flute was composed by Mozart in 1971";
//
//    Assert.assertEquals(expected, actualMessage);
  }

  @Test
  public void testLogicExpression() throws IOException {
    Properties props = new Properties();
    props.load(getClass().getClassLoader().getResourceAsStream("criteria.txt"));

    List balls = getBalls();

    Iterator ballIterator = balls.iterator();

    while(ballIterator.hasNext()){
      Ball ball = (Ball) ballIterator.next();
      // next part of code is not correct and will not compile
      // avoid using jexl in flavour of freemarker
      // Iterator binIter = binName.iterator();
    }
  }

  private List getBalls() {
    return new ArrayList();
  }
}

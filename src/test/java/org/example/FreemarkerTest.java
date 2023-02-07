package org.example;

import freemarker.cache.ClassTemplateLoader;
import freemarker.ext.dom.NodeModel;
import freemarker.template.Configuration;
import freemarker.template.ObjectWrapper;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import javax.xml.parsers.ParserConfigurationException;
import org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader;
import org.example.freemarker.Course;
import org.example.freemarker.Enrollment;
import org.example.freemarker.Exam;
import org.example.freemarker.Student;
import org.junit.Assert;
import org.junit.Test;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

public class FreemarkerTest {

  //@Test
  public void testSimpleMacro() throws IOException, TemplateException {
    StringWriter writer = new StringWriter();
    Configuration configuration = Configuration.getDefaultConfiguration();
    configuration.setLocale(Locale.ENGLISH);
    configuration.setTemplateLoader(new CustomClasspathLoader(getClass()));
    configuration.setObjectWrapper(ObjectWrapper.BEANS_WRAPPER);

    Map root = new HashMap();
    root.put("enrollment", testEnrollment());
    // original template is not parsable
    Template template = configuration.getTemplate("template.ftl");

    template.process(root, writer);
    String actual = writer.toString();
    String expected = "";
    Assert.assertEquals(expected, actual);
  }

  //@Test
  public void testXmlTemplate() throws IOException, ParserConfigurationException, SAXException, TemplateException {
    InputSource source = new InputSource(getClass().getClassLoader().getResourceAsStream("composers.xml"));
    NodeModel nodeModel = NodeModel.parse(source);
    Map root = new HashMap();

    Configuration configuration = Configuration.getDefaultConfiguration();
    configuration.setLocale(Locale.ENGLISH);
    configuration.setTemplateLoader(new CustomClasspathLoader(getClass()));
    configuration.setObjectWrapper(ObjectWrapper.BEANS_WRAPPER);

    Template template = configuration.getTemplate("composerTable.ftl");
    Writer writer = new StringWriter();
    template.process(root, writer);
    String actual = writer.toString();
    String expected = "";
    Assert.assertEquals(expected, actual);
  }

  static class CustomClasspathLoader extends ClassTemplateLoader {

    private final ClassLoader classLoader;

    public CustomClasspathLoader(Class clazz) {
      super(clazz);
      this.classLoader = clazz.getClassLoader();
    }

    @Override
    protected URL getURL(String name) {
      return classLoader.getResource(name);
    }
  }

  private Enrollment testEnrollment() {
    Enrollment enrollment = new Enrollment();
    enrollment.setSection("Introduction");
    List exams = new ArrayList();
    exams.add(new Exam("Understanding reasoning", new Date(2022, 3, 3), 77, 0.3d));
    exams.add(new Exam("History of reasoning", new Date(2022, 3, 14), 22, 0.05));
    exams.add(new Exam("The old part", new Date(2022, 3, 36), 80, 0.4));
    exams.add(new Exam("Types in reasoning", new Date(2022, 4, 8), 60, 0.25));
    enrollment.setExams(exams);
    enrollment.setStudent(new Student("Horhio", "Demetras"));
    Course course = new Course("Reasoning and proving", "Nijad Ahmadji", "Mathematical Statistics", 18_567);
    enrollment.setCourse(course);
    return enrollment;
  }
}

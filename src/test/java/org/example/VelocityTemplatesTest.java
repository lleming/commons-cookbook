package org.example;

import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import org.apache.commons.io.IOUtils;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;
import org.junit.Assert;
import org.junit.Test;

public class VelocityTemplatesTest {

  @Test
  public void testEmailTemplateGenerate() throws Exception {
    Velocity.init();
    VelocityContext context = new VelocityContext();
    context.put("subscription", testSubscription());

    Reader reader = new InputStreamReader(
        Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream("email-template.vm"),
            "Not found resource email-template.vm"));

    StringWriter writer = new StringWriter();
    Velocity.evaluate(context, writer, "test", reader);

    String actual = writer.toString();
    String expected = "\n" +
        "Alex\n" +
        "\n" +
        "You subscription to VSCODe real on\n" +
        "Tue Feb 01 00:00:00 ALMT 3921. If you are interested in renewing your subscription, please\n" +
        "click on the  following URL, and enter your password:\n" +
        "\n" +
        "http://vscode-real.io/renew?cust=12";
    Assert.assertEquals(expected, actual);
  }

  @Test
  public void testTemplateLoopsAndConditionals() throws Exception {
    Velocity.init();
    List airports = new ArrayList();
    airports.add(new Airtport(1, "ATL", "Hartsfield Atlanta", 76876128, "US"));
    airports.add(new Airtport(2, "ORD", "Chicago O'Hare", 6698282, "US"));
    airports.add(new Airtport(3, "LHR", "London Hitrow", 6330393, "UK"));
    airports.add(new Airtport(4, "HND", "Tokyo-Haneda", 61002384, "JP"));
    airports.add(new Airtport(6, "LAX", "Los Angeles", 560298847, "US"));
    airports.add(new Airtport(6, "DFW", "Dallas/Fort Worth", 529494, "US"));

    VelocityContext context = new VelocityContext();
    context.put("airports", airports);
    context.put("countryCode", "US");

    Reader reader = new InputStreamReader(
        Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream("airport-template.vm")));
    StringWriter writer = new StringWriter();
    Velocity.evaluate(context, writer, "test", reader);

    String actual  = writer.toString();

    String expected = new String(IOUtils.toByteArray(getClass().getClassLoader().getResourceAsStream("airport.html")));
    Assert.assertEquals(expected, actual);

  }

  private Subscription testSubscription() {
    Subscription subscription = new Subscription();
    Customer customer = new Customer();
    customer.setId(12L);
    customer.setFirstName("Alex");
    customer.setLastName("Gistki");
    subscription.setCustomer(customer);
    Magazine magazine = new Magazine();
    magazine.setTitle("VSCODe real");
    magazine.setBaseUrl("http://vscode-real.io");
    subscription.setMagazine(magazine);
    subscription.setEndDate(new Date(2021, 1, 1));
    return subscription;
  }
}

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
import org.apache.velocity.app.VelocityEngine;
import org.apache.velocity.runtime.RuntimeConstants;
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

    String actual = writer.toString();

    String expected = new String(IOUtils.toByteArray(getClass().getClassLoader().getResourceAsStream("airport.html")));
    Assert.assertEquals(expected, actual);
  }

  @Test
  public void testMacrosInTemplate() throws Exception {
    VelocityEngine engine = new VelocityEngine();
    engine.setProperty(RuntimeConstants.VM_CONTEXT_LOCALSCOPE, Boolean.TRUE);
    engine.init();

    Appointment appointment = newTestAppointment();
    VelocityContext context = new VelocityContext();
    context.put("appointment", appointment);

    StringWriter writer = new StringWriter();
    Reader reader = new InputStreamReader(
        Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream("macros-template.vm")));
    engine.evaluate(context, writer, "test", reader);

    String actual = writer.toString();
    String expected = new String(IOUtils.toByteArray(
        Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream("macros-test-result.txt"))));
    Assert.assertEquals(expected, actual);
  }

  private Appointment newTestAppointment() {
    Appointment appointment = new Appointment();
    Location location = new Location();
    location.setName("Guliver Plaza");
    location.setState("Alabama");
    location.setCity("Huntsville");
    location.setStreet1("Oakwood Ave NW");
    location.setStreet2("4226");
    location.setZipcode("35819");
    appointment.setLocation(location);

    Organization organization = new Organization();
    organization.setEmail("oakwood@huntsville.com");
    organization.setBaseUrl("https://oakwood-huntsville.com");
    organization.setPresident(new Individual("Jeremy", "Unkal"));
    appointment.setOrganization(organization);
    Location organizationAddress = new Location();
    organizationAddress.setStreet1("Dan Tibbs Rd NW");
    organizationAddress.setStreet2("201");
    organizationAddress.setZipcode("35806");
    organizationAddress.setState("Alabama");
    organizationAddress.setCity("Huntsville");
    organization.setAddress(organizationAddress);

    appointment.setDate(new Date(2021, 6, 9));
    appointment.setStartTime(new Date(2021, 6, 9, 16, 30));
    appointment.setEndTime(new Date(2021, 6, 9, 22, 45));
    appointment.setVolunteer(new Individual("Ameliya", "Silvert"));
    appointment.setId(45L);
    return appointment;
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

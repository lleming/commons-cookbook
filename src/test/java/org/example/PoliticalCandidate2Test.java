package org.example;

import java.math.BigDecimal;
import java.util.Date;

import org.junit.Test;

import junit.framework.Assert;

public class PoliticalCandidate2Test {
    @Test
    public void testToString() {
        String expected = "PoliticalCandate2(firstName=[Alberto],lastName=[Alvares])";
        PoliticalCandidate2 candidate = new PoliticalCandidate2();
        candidate.setFirstName("Alberto");
        candidate.setLastName("Alvares");
        candidate.setDateOfBirth(new Date());
        candidate.setMoneyRaised(new BigDecimal("10000.00"));
        Assert.assertEquals("Must match", expected, candidate.toString());
    }
}

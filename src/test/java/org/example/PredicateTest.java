package org.example;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.collections.Predicate;
import org.apache.commons.collections.functors.AndPredicate;
import org.apache.commons.collections.functors.EqualPredicate;
import org.apache.commons.collections.functors.IdentityPredicate;
import org.apache.commons.collections.functors.InstanceofPredicate;
import org.apache.commons.collections.functors.NotNullPredicate;
import org.apache.commons.collections.functors.OnePredicate;
import org.apache.commons.collections.functors.OrPredicate;
import org.apache.commons.collections.functors.UniquePredicate;
import org.junit.Assert;
import org.junit.Test;

public class PredicateTest {
    @Test
    public void testPredicate() {
        String name = "Tim";
        Predicate johnPredicate = new EqualPredicate("John");
        Predicate timPredicate = new EqualPredicate("Tim");

        Predicate instanceOfString = new InstanceofPredicate(String.class);
        Predicate instanceOfDouble = new InstanceofPredicate(Double.class);

        Assert.assertTrue(timPredicate.evaluate(name));
        Assert.assertFalse(johnPredicate.evaluate(name));
        Assert.assertTrue(instanceOfString.evaluate(name));
        Assert.assertFalse(instanceOfDouble.evaluate(name));
    }

    @Test
    public void testIdentityPredicate() {
        String name = "Roberto";
        Predicate roberto = new IdentityPredicate(name);
        Assert.assertTrue(roberto.evaluate(name));
        Assert.assertFalse(roberto.evaluate(new String("Roberto")));
    }

    @Test
    public void testUniquePredicate() {
        String say = "hello";
        Predicate unique = new UniquePredicate();
        Assert.assertTrue(unique.evaluate(say));
        Assert.assertFalse(unique.evaluate(say));
        Assert.assertTrue(unique.evaluate("world"));
    }

    @Test
    public void testOrPredicate() {
        Predicate tim = new EqualPredicate("tim");
        Predicate bert = new EqualPredicate("bert");
        Predicate timOrBert = new OrPredicate(tim, bert);
        Assert.assertTrue(timOrBert.evaluate("tim"));
        Assert.assertTrue(timOrBert.evaluate("bert"));
        Assert.assertFalse(timOrBert.evaluate("ocusa"));
    }

    @Test
    public void testAndPredicate() {
        Predicate alica = new EqualPredicate("alica");
        Predicate notNull = NotNullPredicate.INSTANCE;
        Predicate alicaNotNull = new AndPredicate(alica, notNull);

        Assert.assertTrue(alicaNotNull.evaluate("alica"));
        Assert.assertFalse(alicaNotNull.evaluate(null));
        Assert.assertFalse(alicaNotNull.evaluate("ortega"));
    }

    @Test
    public void testOneOfPredicate() {
        Predicate stringPredicate = new InstanceofPredicate(String.class);
        Predicate doublePredicate = new InstanceofPredicate(Double.class);
        Predicate listPredicate = new InstanceofPredicate(Collection.class);

        Predicate instancesAllowed = new OnePredicate(
                new Predicate[] { stringPredicate, doublePredicate, listPredicate });

        Assert.assertTrue(instancesAllowed.evaluate("gromvel"));
        Assert.assertTrue(instancesAllowed.evaluate(12.44D));
        Assert.assertTrue(instancesAllowed.evaluate(new ArrayList<>()));

        Assert.assertFalse(instancesAllowed.evaluate(new BigDecimal("22")));
    }
}

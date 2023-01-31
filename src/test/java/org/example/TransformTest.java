package org.example;

import org.apache.commons.collections.Predicate;
import org.apache.commons.collections.Transformer;
import org.apache.commons.collections.functors.ChainedTransformer;
import org.apache.commons.collections.functors.NotPredicate;
import org.apache.commons.collections.functors.SwitchTransformer;
import org.junit.Assert;
import org.junit.Test;

public class TransformTest {
    @Test
    public void testTransform() {
        Transformer square = new Transformer() {

            @Override
            public Object transform(Object input) {
                Long value = (Long) input;
                return value * value;
            }

        };
        double value = 7L;
        double actual = ((Long) square.transform(value)).doubleValue();
        Assert.assertEquals(49L, actual, 0.01);
    }

    @Test
    public void testChainTransformers() {
        Transformer increment = new Transformer() {

            @Override
            public Object transform(Object input) {
                return ((Long) input) + 1;
            }

        };
        Transformer stignify = new Transformer() {

            @Override
            public Object transform(Object input) {
                return "Number is " + input;
            }

        };

        Transformer chain = new ChainedTransformer(new Transformer[] { increment, stignify });
        String actual = (String) chain.transform(12L);
        Assert.assertEquals("Number is 13", actual);
    }

    @Test
    public void testSwitchTransformer() {
        Predicate isOdd = new Predicate() {

            @Override
            public boolean evaluate(Object object) {
                Integer number = (Integer) object;
                if(number < 0){
                    return false;
                }
                return number % 2 == 0;
            }
        };
        Predicate isEven = new Predicate (){
            Predicate not = new NotPredicate(isOdd);
            @Override
            public boolean evaluate(Object object) {
                Integer number = (Integer) object;
                if(number < 0){
                    return false;
                }
                return not.evaluate(object);
            }

        };

        Transformer square = new Transformer() {

            @Override
            public Object transform(Object input) {
                Integer value = ((Integer) input);
                return value * value;
            }

        };

        Transformer cube = new Transformer() {

            @Override
            public Object transform(Object input) {
                Integer value = ((Integer) input);
                return value * value * value;
            }

        };

        Transformer same = new Transformer() {

            @Override
            public Object transform(Object input) {
                return input;
            }
            
        };
        Transformer multiply = new SwitchTransformer(new Predicate[]{isOdd, isEven}, new Transformer[]{square, cube}, same);
        Assert.assertEquals(4, multiply.transform(2));
        Assert.assertEquals(27, multiply.transform(3));
        Assert.assertEquals(-12, multiply.transform(-12));
    }
}

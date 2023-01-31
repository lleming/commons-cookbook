package org.example;

import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.math.linear.RealMatrix;
import org.apache.commons.math.linear.RealMatrixImpl;
import org.junit.Assert;
import org.junit.Test;
public class EquationSolvingTest {
    @Test
    public void testEquation() {
        double[][] coefficients = new double[][] {
                { 3.0, 20.0, 89.0 },
                { 4.0, 40.0, 298.0 },
                { 7.0, 21.0, 0.42 }
        };

        double[] values = { 1324, 2999, 2038 };

        RealMatrix matrix = new RealMatrixImpl(coefficients);
        double[] solution = matrix.solve(values);
        Assert.assertEquals("{400.0490323983473,-36.49390809596285,9.592483873305788}", ArrayUtils.toString(solution));
    }
}

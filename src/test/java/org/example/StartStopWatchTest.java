package org.example;

import org.apache.commons.lang.time.StopWatch;
import org.junit.Test;

public class StartStopWatchTest {
    @Test
    public void testCheckCalculate() {
        StopWatch watch = new StopWatch();
        watch.start();
        double sum = 0;
        for (int i = 0; i < 1_000_000_000; i++) {
            sum += Math.sin(0.34);
        }
        watch.stop();
        System.out.println("Sum is " + sum);
        System.out.println("Total time to calculate sin of 1 000 000 times takes " + watch.getTime());
    }
}

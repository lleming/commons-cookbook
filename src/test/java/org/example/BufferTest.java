package org.example;

import java.io.File;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;

import org.apache.commons.collections.BoundedFifoBuffer;
import org.apache.commons.collections.Buffer;
import org.apache.commons.collections.BufferOverflowException;
import org.apache.commons.collections.BufferUnderflowException;
import org.apache.commons.collections.UnboundedFifoBuffer;
import org.apache.commons.collections.buffer.PriorityBuffer;
import org.junit.Test;

import junit.framework.Assert;

public class BufferTest {
    @Test
    public void testUnboundBuffer() {
        Buffer buffer = new UnboundedFifoBuffer(16);

        buffer.add(new String("Hello there"));
        buffer.add(new Object());
        buffer.add(new Integer(17));
        buffer.add(new File("smaple.txt"));

        Assert.assertEquals("Hello there", buffer.get());
        Assert.assertEquals("Hello there", buffer.remove());

        Assert.assertEquals(Object.class, buffer.remove().getClass());
        Assert.assertEquals(17, buffer.remove());
        Assert.assertEquals("smaple.txt", buffer.get().toString());
    }

    @Test
    public void testBoundBuffer() {
        Buffer buffer = new BoundedFifoBuffer(2);
        buffer.add(new String("shtainer"));
        buffer.add(new Object());
        try {
            buffer.add(new ArrayList<>());
        } catch (Exception e) {
            Assert.assertEquals(BufferOverflowException.class, e.getClass());
        }
        buffer.remove();
        buffer.remove();
        try {
            buffer.remove();
        } catch (Exception e) {
            Assert.assertEquals(BufferUnderflowException.class, e.getClass());
        }
    }

    @Test
    public void testPriorityBuffer() {
        Comparator patientComparator = new Comparator() {

            @Override
            public int compare(Object o1, Object o2) {
                int comparison = -1;
                if (o1 instanceof Patient && o2 instanceof Patient) {
                    Patient patient1 = (Patient) o1;
                    Patient patient2 = (Patient) o2;
                    Integer severinity1 = patient1.getSeverenity();
                    Integer severinity2 = patient2.getSeverenity();
                    comparison = severinity1.compareTo(severinity2);
                    if (comparison != 0) {
                        return comparison;
                    }
                    return patient1.getCheckIn().compareTo(patient2.getCheckIn());
                }
                return 0;
            }

        };
        Patient patient0 = new Patient();
        patient0.setName("Orna");
        patient0.setSeverenity(7);
        patient0.setCheckIn(new Date(2022, 3, 13));
        Patient patient1 = new Patient();
        patient1.setName("Viltzer");
        patient1.setSeverenity(1);
        patient1.setCheckIn(new Date(2022, 4, 17));
        Patient patient2 = new Patient();
        patient2.setName("Kristoff");
        patient2.setSeverenity(7);
        patient2.setCheckIn(new Date(2022, 3, 16));

        Buffer buffer = new PriorityBuffer(patientComparator);
        buffer.add(patient0);
        buffer.add(patient1);
        buffer.add(patient2);

        Assert.assertEquals("Viltzer", ((Patient) buffer.remove()).getName());
        Assert.assertEquals("Orna", ((Patient) buffer.remove()).getName());
        Assert.assertEquals("Kristoff", ((Patient) buffer.remove()).getName());
    }
}

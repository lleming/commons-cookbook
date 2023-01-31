package org.example;

import org.apache.commons.codec.language.Soundex;
import org.junit.Assert;
import org.junit.Test;

public class SoundexTest {
    @Test
    public void testSoundex() {
        Soundex soundex = new Soundex();
        String obrien = soundex.soundex("O'Brien");
        String obrian = soundex.soundex("O'Brian");
        String obryan = soundex.soundex("O'Bryan");
        Assert.assertEquals("O165", obrian);
        Assert.assertEquals("O165", obrien);
        Assert.assertEquals("O165", obryan);
    }
}

package com.ak.wars;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class IntToIpConverterTest {
    @Test
    public void sampleTest() {
        assertEquals("128.114.17.104", IntToIpConverter.longToIP(2154959208L));
        assertEquals("0.0.0.0", IntToIpConverter.longToIP(0));
        assertEquals("128.32.10.1", IntToIpConverter.longToIP(2149583361L));
    }
}
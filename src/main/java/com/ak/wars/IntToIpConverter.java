package com.ak.wars;

import java.util.stream.Collectors;
import java.util.stream.LongStream;

public class IntToIpConverter {
    static String longToIP(long ip) {
        int fullEightBits = (2 << 7) - 1;
        return LongStream.of(3,2,1,0)
                .map(i -> (ip & (fullEightBits<<i*8)) >> i*8)
                .mapToObj(String::valueOf)
                .map(number -> String.valueOf(Long.parseLong(number, 10)))
                .collect(Collectors.joining("."));
    }
}

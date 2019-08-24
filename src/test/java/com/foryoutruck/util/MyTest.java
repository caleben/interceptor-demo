package com.foryoutruck.util;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.Random;

@Slf4j
public class MyTest {

    @Test
    public void test1() {
        Random random = new Random();
        //[)前闭后开
        int index = random.nextInt(1);
        log.info(index + "");
    }

    @Test
    public void test2() {
        long time = System.currentTimeMillis();
        System.out.println(time);
    }

}

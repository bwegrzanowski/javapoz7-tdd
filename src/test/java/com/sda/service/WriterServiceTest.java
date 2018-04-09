package com.sda.service;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class WriterServiceTest {
    private WriterService writerService;

    @Before
    public void init() {

        this.writerService = new WriterService();
    }

    @Test
    public void testOneName() {
        //given
        String name = "Paul";
        //when
        String result = writerService.write((name));
        //then
        Assert.assertEquals("Hello, Paul.", result);
    }

    @Test
    public void testNullName() {
        String name = null;
        String result = writerService.write(name);
        Assert.assertEquals("Hello, my friend.", result);
    }
}

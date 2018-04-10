package com.sda.service;

import org.apache.commons.lang3.StringUtils;
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

    @Test
    public void testCapitaliseName() {
        String name = "PAUL";
        String result = writerService.write(name);
    }

    @Test
    public void testBlankName() {
        String name = "";
        StringUtils.isEmpty(name);
        String result = writerService.write(name);
        Assert.assertEquals("Hello, my friend.", result);
    }

    @Test
    public void testMultipleNames() {
        String name = "Szymon,Anna,Jan";
        StringUtils.isEmpty(name);
        String result = writerService.write(name);
        Assert.assertEquals("Hello, Szymon, Anna and Jan.", result);
    }

    @Test
    public void testMultipleCapitalisedNames() {
        String name = "SZYMON,ANNA,JAN";
        StringUtils.isEmpty(name);
        String result = writerService.write(name);
        Assert.assertEquals("HELLO, SZYMON, ANNA AND JAN!", result);
    }
}

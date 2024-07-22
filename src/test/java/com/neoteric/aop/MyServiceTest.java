package com.neoteric.aop;

import com.neoteric.Application;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

@SpringBootTest
@ContextConfiguration(classes = {Application.class})
public class MyServiceTest {

    @Autowired
    public Service service;

    @Test
    public void testServe() throws InterruptedException {
        service.serve();
    }
}


package com.xuyh.nms.modules.sys.web;

import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mockito;

import static org.junit.Assert.*;

public class LogControllerTest {

    @InjectMocks
    private LogController logControlle;

    @Test
    public void login() {
        Mockito.when(logControlle.logOut());
    }

    @Test
    public void userInfo() {
    }

    @Test
    public void logOut() {
    }

    @Test
    public void getArticle() {
    }

    @Test
    public void findOrder() {
    }

    @Test
    public void login1() {
    }
}
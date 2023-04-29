package com.example.demo.service;

import static org.mockito.Mockito.mock;
import static org.junit.jupiter.api.Assertions.*;

import com.example.demo.entity.Params;
import com.example.demo.entity.Result;
import org.junit.jupiter.api.Test;
public class ServiceTest {

    private Actions actions = mock(Actions.class);

    private Actions act = new Actions();

    @Test
    public void testAct1() {
        Params params = new Params(3,4);
        Result result = actions.act(params);
        assertEquals(result.getParam(),params);
        assertEquals(result.getSum(),7);
        assertEquals(result.getSub(),-1);
        assertEquals(result.getMul(),12);
        assertEquals(result.getDiv(),0.75);
    }

    @Test
    public void testAct2() {
        Params params = new Params(5,-2);
        Result result = actions.act(params);
        assertEquals(result.getParam(),params);
        assertEquals(result.getSum(),3);
        assertEquals(result.getSub(),-7);
        assertEquals(result.getMul(),-10);
        assertEquals(result.getDiv(),-2.5);
    }

    @Test
    public void testAct3() {
        Params params = new Params(5,0);
        Throwable thrown = assertThrows(RuntimeException.class,()->{
            actions.act(params);
        });
        assertNotNull(thrown.getMessage());
    }

}
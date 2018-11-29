package cn.fortrun.androidtestdemo.test.what;


import org.junit.Test;

import cn.fortrun.androidtestdemo.junit.Calculator;

import static junit.framework.Assert.assertEquals;

/**
 * Created by xiaochuang on 4/12/16.
 */
public class CalculatorTest {

    @Test
    public void testAdd() throws Exception {
        Calculator calculator = new Calculator();
        int sum = calculator.add(1, 2);
        assertEquals(3, sum);
    }

}
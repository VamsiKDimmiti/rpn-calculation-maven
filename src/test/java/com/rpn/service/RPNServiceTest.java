package com.rpn.service;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Stack;

public class RPNServiceTest {

    private RPNService rpnService = new RPNService();

    private Stack<String> resStack = new Stack();

    private String input;

    @Before
    public void init(){
        resStack.push("6");
        resStack.push("3");
    }

    @Test
    public void getAddOperatorTest() throws Exception{
        input = "+";
        Double res = rpnService.getOperator(input, resStack);
        Assert.assertEquals(9.0, res,0.0);
    }

    @Test
    public void getNegAddOperatorTest() throws Exception{
        input = "+";
        Double res = rpnService.getOperator(input, resStack);
        Assert.assertNotEquals(5.0, res,0.0);
    }

    @Test(expected = Exception.class)
    public void getExceptionOperatorTest() throws Exception{
        input = "+";
        resStack.pop();
        Double res = rpnService.getOperator(input, resStack);
    }

    @Test
    public void getSubOperatorTest() throws Exception{
        input = "-";
        Double res = rpnService.getOperator(input, resStack);
        Assert.assertEquals(3.0, res,0.0);
    }

    @Test
    public void getNegSubOperatorTest() throws Exception{
        input = "-";
        Double res = rpnService.getOperator(input, resStack);
        Assert.assertNotEquals(6.0, res,0.0);
    }

    @Test
    public void getMultiOperatorTest() throws Exception{
        input = "*";
        Double res = rpnService.getOperator(input, resStack);
        Assert.assertEquals(18.0, res,0.0);
    }

    @Test
    public void getNegMultiOperatorTest() throws Exception{
        input = "*";
        Double res = rpnService.getOperator(input, resStack);
        Assert.assertNotEquals(20.0, res,0.0);
    }
    @Test
    public void getDivOperatorTest() throws Exception{
        input = "/";
        Double res = rpnService.getOperator(input, resStack);
        Assert.assertEquals(2.0, res,0.0);
    }


    @Test
    public void getNegDivOperatorTest() throws Exception{
        input = "/";
        Double res = rpnService.getOperator(input, resStack);
        Assert.assertNotEquals(1.0, res,0.0);
    }

    @Test(expected = Exception.class)
    public void getExceptionDivOperatorTest() throws Exception{
        input = "/";
        resStack.pop();
        resStack.push("0");
        Double res = rpnService.getOperator(input, resStack);
    }

    @Test
    public void getNegSqrtOperatorTest() throws Exception{
        input = "sqrt";
        Double res = rpnService.getOperator(input, resStack);
        Assert.assertNotEquals(3.0, res,0.0);
    }
    @Test
    public void getSqrtOperatorTest() throws Exception{
        input = "sqrt";
        Double res = rpnService.getOperator(input, resStack);
        Assert.assertEquals(1.7320508075688772, res,0.0);
    }

    @Test
    public void getNoOperatorTest() throws Exception{
        input = "8.0";
        Double res = rpnService.getOperator(input, resStack);
        Assert.assertEquals(8.0, res,0.0);
    }

}

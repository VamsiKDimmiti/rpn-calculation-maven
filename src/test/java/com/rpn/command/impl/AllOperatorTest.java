package com.rpn.command.impl;


import com.rpn.command.Operator;
import com.rpn.controller.Operation;
import com.rpn.model.RPNParam;
import com.rpn.operator.StrOperator;
import com.rpn.operator.impl.*;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class AllOperatorTest {

    private RPNParam rpn;
    private Operator operator;


    @Before
    public void init() {
        rpn = new RPNParam();
        rpn.setFirstOperand(4.0);
        rpn.setSecondOperand(6.0);
    }

    @Test
    public void testAddCompute() {
        rpn.setOperator("+");
        operator = new AddOperator(rpn);
        Assert.assertEquals(10.0, operator.compute(), 0.0);
    }

    @Test
    public void testNegativeAddCompute() {
        rpn.setOperator("+");
        operator = new AddOperator(rpn);
        Assert.assertNotEquals(8.0, operator.compute(), 0.0);
    }

    @Test
    public void testSubCompute() {
        rpn.setOperator("-");
        operator = new SubOperator(rpn);
        Assert.assertEquals(2.0, operator.compute(), 0.0);
    }

    @Test
    public void testNegSubCompute() {
        rpn.setOperator("-");
        operator = new SubOperator(rpn);
        Assert.assertNotEquals(4.0, operator.compute(), 0.0);
    }

    @Test
    public void testMultipleCompute() {
        rpn.setOperator("*");
        operator = new MultiplicateOperator(rpn);
        Assert.assertEquals(24.0, operator.compute(), 0.0);
    }

    @Test
    public void testNegMultipleCompute() {
        rpn.setOperator("*");
        operator = new MultiplicateOperator(rpn);
        Assert.assertNotEquals(2.0, operator.compute(), 0.0);
    }

    @Test
    public void testDivisionCompute() {
        rpn.setOperator("/");
        operator = new DivisionOperator(rpn);
        Assert.assertEquals(1.5, operator.compute(), 0.0);
    }

    @Test
    public void testNegDivisionCompute() {
        rpn.setOperator("/");
        operator = new DivisionOperator(rpn);
        Assert.assertNotEquals(3.0, operator.compute(), 0.0);
    }

    @Test
    public void testSqrtCompute() {
        rpn.setOperator("sqrt");
        rpn.setFirstOperand(9.0);
        operator = new SqrtOperator(rpn);
        Assert.assertEquals(3.0, operator.compute(), 0.0);
    }

    @Test
    public void testNegSqrtCompute() {
        rpn.setOperator("sqrt");
        rpn.setFirstOperand(9.0);
        operator = new SqrtOperator(rpn);
        Assert.assertNotEquals(2.0, operator.compute(), 0.0);
    }
}

package com.rpn.operator.impl;

import com.rpn.command.Operator;
import com.rpn.command.impl.SqrtOperator;
import com.rpn.model.RPNParam;
import com.rpn.operator.StrOperator;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class AllStrOperatorTest {

    private StrOperator strOperator;


    private RPNParam rpn;

    @Before
    public void init(){
        rpn = new RPNParam();
        rpn.setFirstOperand(4.0);
        rpn.setSecondOperand(6.0);
    }

    @Test
    public void testStrAddOperatorResult(){
        rpn.setOperator("+");
        strOperator = new StrAddOperator();
        Operator op = strOperator.getResult(rpn);
        Assert.assertEquals(10.0, op.compute(),0.0);
    }

    @Test
    public void testNegStrAddOperatorResult(){
        rpn.setOperator("+");
        strOperator = new StrAddOperator();
        Operator op = strOperator.getResult(rpn);
        Assert.assertNotEquals(6.0, op.compute(),0.0);
    }

    @Test
    public void testStrSubOperatorResult(){
        rpn.setOperator("-");
        strOperator = new StrSubOperator();
        Operator op = strOperator.getResult(rpn);
        Assert.assertEquals(2.0, op.compute(),0.0);
    }

    @Test
    public void testNegStrSubOperatorResult(){
        rpn.setOperator("-");
        strOperator = new StrSubOperator();
        Operator op = strOperator.getResult(rpn);
        Assert.assertNotEquals(7.0, op.compute(),0.0);
    }

    @Test
    public void testStrDivOperatorResult(){
        rpn.setOperator("/");
        strOperator = new StrDivisionOperator();
        Operator op = strOperator.getResult(rpn);
        Assert.assertEquals(1.5, op.compute(),0.0);
    }

    @Test
    public void testNegStrDivOperatorResult(){
        rpn.setOperator("/");
        strOperator = new StrDivisionOperator();
        Operator op = strOperator.getResult(rpn);
        Assert.assertNotEquals(6.0, op.compute(),0.0);
    }

    @Test
    public void testStrMulOperatorResult(){
        rpn.setOperator("*");
        strOperator = new StrMultiplicateOperator();
        Operator op = strOperator.getResult(rpn);
        Assert.assertEquals(24.0, op.compute(),0.0);
    }

    @Test
    public void testNegMulOperatorResult(){
        rpn.setOperator("*");
        strOperator = new StrMultiplicateOperator();
        Operator op = strOperator.getResult(rpn);
        Assert.assertNotEquals(20.0, op.compute(),0.0);
    }

    @Test
    public void testStrSqrtOperatorResult(){
        rpn.setOperator("sqrt");
        rpn.setFirstOperand(9.0);
        strOperator = new StrSqrtOperator();
        Operator op = strOperator.getResult(rpn);
        Assert.assertEquals(3.0, op.compute(),0.0);
    }

    @Test
    public void testNegSqrtOperatorResult(){
        rpn.setOperator("sqrt");
        rpn.setFirstOperand(9.0);
        strOperator = new StrSqrtOperator();
        Operator op = strOperator.getResult(rpn);
        Assert.assertNotEquals(6.0, op.compute(),0.0);
    }
}

package com.rpn.model;
/*
 *
 * This is Model class (receiver) having the Operator and operands that work on Operator for a given Operation.
 *
 */

public class RPNParam {

    private String operator;
    private Double firstOperand;
    private Double secondOperand;

    public Double getFirstOperand() {
        return firstOperand;
    }

    public void setFirstOperand(Double firstOperand) {
        this.firstOperand = firstOperand;
    }

    public Double getSecondOperand() {
        return secondOperand;
    }

    public void setSecondOperand(Double secondOperand) {
        this.secondOperand = secondOperand;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

}

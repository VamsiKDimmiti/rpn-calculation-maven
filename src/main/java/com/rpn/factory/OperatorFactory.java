package com.rpn.factory;

import com.rpn.operator.StrOperator;
import com.rpn.operator.impl.*;
/*
 * Factory Class to identify and return required implementation
 */
public class OperatorFactory {
   public static StrOperator getOperator(String operator){
       if(operator.equals("+"))  return new StrAddOperator();
       if(operator.equals("-"))  return new StrSubOperator();
       if(operator.equals("*"))  return new StrMultiplicateOperator();
       if(operator.equals("/"))  return new StrDivisionOperator();
       if(operator.equals("sqrt")) return new StrSqrtOperator();
       return null;
   }
}
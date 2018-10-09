# rpn-calculation-maven
Description: This Maven project is to compute the basic RPN calculations  by accepting the input from command line.
Valid Input operators are +, -, *, /, undo, sqrt, clear

How to execute:

1. Run the RPNCalculation
2. Command Prompt will provide the Information that RPN Calculator started
3. Give the input with real numbers and operator mentioned above with space as delimiter
4. Result will be prompted as stack of values

Examples:

2 3 +
stack:5
undo
stack:
1
stack:1
2 *
stack:2
3
stack:2 3
-
stack:-1
7 + 3 / 2 -
stack:0
clear
stack:
1 2 3 * 5 + * * 6 5
operator * (position: 15): insufficient parameters
stack:11


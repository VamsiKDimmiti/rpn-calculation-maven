# Unbounded Knapsack
Description: This Maven project is to solve the Knapsack Problem  by accepting the input from command line.
Input would need to be given in below format.
1. Give the n number of test case
2. After the step 1 depending on the value given for n, we need to give 2 paris of n lines as input where
    a. first line should have size of the array and target sum with space delimited
    b. second line should have list of items (size should match the value we give in the first line above)

Result wil be prompted for all the test cases given.

Solution does have the algorithm implementation which has been implemented in 3 different ways considering the Time and Space complexity

By default program will run with first implementation. If we need to check the second and third implementation, we need to uncomment the required
case and comment out the others in the class - UknapsackService.java

How to execute:

1. Run the UnboundedKnapsack as maven project
2. Command Prompt will provide the Information that UnboundedKnapsack started
3. Give the input with real numbers with first line to be number of testcases (lets say t),
    and then need to give t pairs of lines with
        first line having target values and the length of the array
        second line having those many integers separated by space
4. Result will be prompted in the console

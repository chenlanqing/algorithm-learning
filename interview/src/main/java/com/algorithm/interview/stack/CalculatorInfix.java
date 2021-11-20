package com.algorithm.interview.stack;

import com.algorithm.datastructure.stack.ArrayStack;

/**
 * 中缀表达式简易版计算器：只支持4个操作运算符
 *
 * @author QingFan
 * @version 1.0.0
 * @date 2021年11月19日 13:37
 */
public class CalculatorInfix {

    public static void main(String[] args) {
        System.out.println("7*2*2-5+1-5+3-4=" + CalculatorInfix.calculate("7*2*2-5+1-5+3-4"));
    }

    // 存储数据的栈
    private static final ArrayStack<Integer> numStack = new ArrayStack<>();
    // 存储操作符的栈：+、-、*、/
    private static final ArrayStack<Character> operatorStack = new ArrayStack<>();

    public static int calculate(String expression) {
        int res = 0;
        if (expression == null || expression.trim().length() == 0 || expression.length() == 0) {
            return res;
        }
        int index = 0;
        int num1 = 0;
        int num2 = 0;
        char ch = ' ';
        String keepNum = "";
        while (true) {
            // 依次得到expression 的每一个字符
            ch = expression.charAt(index);
            index++;
            if (Calculator.isOperator(ch)) {
                // 如果是运算符
                // 如果符号栈有操作符，就进行比较,如果当前的操作符的优先级小于或者等于栈中的操作符,就需要从数栈中pop出两个数,
                // 在从符号栈中pop出一个符号，进行运算，将得到结果，入数栈，然后将当前的操作符入符号栈
                if (operatorStack.isEmpty()) {
                    operatorStack.push(ch);
                    continue;
                }
                int priority = Calculator.priority(ch);
                if (priority > Calculator.priority(operatorStack.peek())) {
                    // 如果当前的操作符的优先级大于栈中的操作符， 就直接入符号栈
                    operatorStack.push(ch);
                    continue;
                }
                num1 = numStack.pop();
                num2 = numStack.pop();
                int ope = operatorStack.pop();
                res = Calculator.calculate(num1, num2, ope);
                numStack.push(res);
                operatorStack.push(ch);
            } else {
                // 如果是数
                keepNum += ch;
                //1. 当处理多位数时，不能发现是一个数就立即入栈，因为他可能是多位数
                //2. 在处理数，需要向expression的表达式的index 后再看一位,如果是数就进行扫描，如果是符号才入栈
                //3. 因此我们需要定义一个变量 字符串，用于拼接
                while (index < expression.length() && !Calculator.isOperator(ch = expression.charAt(index))) {
                    keepNum += ch;
                    index++;
                }
                numStack.push(Integer.parseInt(keepNum));
                keepNum = "";
            }
            if (index >= expression.length()) {
                break;
            }
        }

        while (!operatorStack.isEmpty()) {
            num1 = numStack.pop();
            num2 = numStack.pop();
            int ope = operatorStack.pop();
            res = Calculator.calculate(num1, num2, ope);
            numStack.push(res);
        }
        return numStack.pop();
    }
}

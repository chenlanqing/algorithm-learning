package com.algorithm.interview.stack;

import java.util.Stack;

/**
 * 逆波兰表达式实现计算器
 *
 * @author QingFan
 * @version 1.0.0
 * @date 2021年11月19日 15:42
 */
public class CalculatorWithPoland {
    /**
     * 中缀表达式：(30+4)×5-6  => 后缀表达式：30 4 + 5 × 6 - => 164
     * <pre>
     * 1)从左至右扫描，将3和4压入堆栈；
     * 2)遇到+运算符，因此弹出4和3（4为栈顶元素，3为次顶元素），计算出3+4的值，得7，再将7入栈；
     * 3)将5入栈；
     * 4)接下来是×运算符，因此弹出5和7，计算出7×5=35，将35入栈；
     * 5)将6入栈；
     * 6)最后是-运算符，计算出35-6的值，即29，由此得出最终结果
     * </pre>
     */
    public static int calculate(String suffixExpression) {
        if (suffixExpression == null || suffixExpression.trim().length() == 0) {
            return 0;
        }
        String[] split = suffixExpression.split(" ");
        // 栈
        Stack<String> stack = new Stack<>();
        int res = 0;
        int num1 = 0;
        int num2 = 0;
        char op = ' ';
        for (String item : split) {
            // 如果匹配到的是数字，则直接压栈，考虑正整数和负整数
            if (item.matches("^-?\\d+$")) {
                stack.push(item);
                continue;
            }
            // 否则就是运算符，需要依次 pop 出两个数据
            num1 = Integer.parseInt(stack.pop());
            num2 = Integer.parseInt(stack.pop());
            op = item.charAt(0);
            res = Calculator.calculate(num1, num2, op);
            stack.push("" + res);
        }
        return Integer.parseInt(stack.pop());
    }
}

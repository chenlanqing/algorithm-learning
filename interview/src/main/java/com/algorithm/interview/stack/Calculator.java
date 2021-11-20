package com.algorithm.interview.stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author QingFan
 * @version 1.0.0
 * @date 2021年11月19日 17:49
 */
public class Calculator {

    public static void main(String[] args) {
        List<String> infixExpression = getInfixExpressionDecimal("1+((2.35+3.5)*4)-5");
        System.out.println(infixExpression);
        System.out.println(infixToSuffixExpressionDecimal("1+((2.35+3.5)*4)-5"));
    }

    /**
     * 判断是不是操作符
     */
    public static boolean isOperator(char operator) {
        return operator == '*'
                || operator == '×'
                || operator == 'x'
                || operator == '/'
                || operator == '÷'
                || operator == '+'
                || operator == '-';
    }

    /**
     * 操作符优先级
     */
    public static int priority(String str) {
        return priority(str.charAt(0));
    }

    /**
     * 操作符优先级
     */
    public static int priority(char ch) {
        switch (ch) {
            case '+':
            case '-':
                return 0;
            case '*':
            case '×':
            case 'x':
            case '÷':
            case '/':
                return 1;
            default:
                return -1;
        }
    }

    public static int calculate(int num1, int num2, int operator) {
        int res = 0;
        switch (operator) {
            case '*':
            case '×':
            case 'x':
                res = num1 * num2;
                break;
            case '/':
            case '÷':
                res = num2 / num1;
                break;
            case '+':
                res = num1 + num2;
                break;
            case '-':
                res = num2 - num1;
                break;
            default:
                break;
        }
        return res;
    }

    private static boolean isBlank(String str) {
        return str == null || str.trim().length() == 0;
    }

    private static boolean isEmpty(List<String> list) {
        return list == null || list.size() == 0;
    }

    /**
     * 将一个中缀表达式转换为后缀表达式
     *
     * @param str 中缀表达式
     * @param decimal 是否有小数，true-有小数、false-没有小数
     * @return 后缀表达式
     */
    public static List<String> infixToSuffixExpression(String str, boolean decimal) {
        if (!decimal) {
            // 没有小数的转换
            return infixToSuffixExpression(str);
        }
        // 有小数的转换
        return infixToSuffixExpressionDecimal(str);
    }

    /**
     * 将一个中缀表达式转换为后缀表达式：包含小数
     */
    public static List<String> infixToSuffixExpressionDecimal(String str) {
        List<String> infixExpression = getInfixExpressionDecimal(str);
        if (isEmpty(infixExpression)) {
            return null;
        }
        // 运算符栈
        Stack<String> stack = new Stack<>();
        // 最终结果数据
        ArrayList<String> res = new ArrayList<>(infixExpression.size());
        // [1, +, (, (, 2.35, +, 3.5, ), *, 4, ), -, 5]
        for (String item : infixExpression) {
            if ("(".equals(item)) {
                // 如果是左括号，直接入栈
                stack.push(item);
            } else if (item.matches("^-?\\d+$")) {
                // 数字，直接添加到集合中
                res.add(item);
            } else if (")".equals(item)) {
                // 如果是右括号，需要消除括号，则需要一直在栈中找到 (
                while (!stack.isEmpty() && !"(".equals(stack.peek())) {
                    res.add(stack.pop());
                }
                // 将左括号也消除掉
                stack.pop();
            } else {
                // 如果 s1 为空，或则栈顶运算符为 （，则压入符号栈 s1
                // 如果优先级比栈顶运算符 高，则压入符号栈 s1,否则，否则将 s1 栈顶的运算符弹出，压入 s2 中
                // 上面两句话，转换成下面的描述
                // 上面如果  s1 栈顶符号优先级比 当前符号高，则弹出加入到 s2 中。
                // 因为：如果栈顶符号是 （ 返回优先级为 -1.比当前符号低，则不会走该方法
                while (!stack.isEmpty() && (priority(stack.peek()) >= priority(item))) {
                    res.add(stack.pop());
                }
                stack.push(item);
            }
        }
        // 将栈中所有数据依次弹栈，转移到集合中；
        while (!stack.isEmpty()) {
            res.add(stack.pop());
        }
        return res;
    }

    /**
     * 将一个中缀表达式转换为后缀表达式：没有小数
     */
    public static List<String> infixToSuffixExpression(String str) {
        List<String> infixExpression = getInfixExpression(str);
        if (isEmpty(infixExpression)) {
            return null;
        }
        // 运算符栈
        Stack<String> stack = new Stack<>();
        // 最终结果数据
        ArrayList<String> res = new ArrayList<>(infixExpression.size());

        for (String item : infixExpression) {
            if ("(".equals(item)) {
                // 如果是左括号，直接入栈
                stack.push(item);
            } else if (item.matches("^-?\\d+$")) {
                // 数字，直接添加到集合中
                res.add(item);
            } else if (")".equals(item)) {
                // 如果是右括号，需要消除括号，则需要一直在栈中找到 (
                while (!stack.isEmpty() && !"(".equals(stack.peek())) {
                    res.add(stack.pop());
                }
                // 将左括号也消除掉
                stack.pop();
            } else {
                // 如果 s1 为空，或则栈顶运算符为 （，则压入符号栈 s1
                // 如果优先级比栈顶运算符 高，则压入符号栈 s1,否则，否则将 s1 栈顶的运算符弹出，压入 s2 中
                // 上面两句话，转换成下面的描述
                // 上面如果  s1 栈顶符号优先级比 当前符号高，则弹出加入到 s2 中。
                // 因为：如果栈顶符号是 （ 返回优先级为 -1.比当前符号低，则不会走该方法
                while (!stack.isEmpty() && (priority(stack.peek()) >= priority(item))) {
                    res.add(stack.pop());
                }
                stack.push(item);
            }
        }
        // 将栈中所有数据依次弹栈，转移到集合中；
        while (!stack.isEmpty()) {
            res.add(stack.pop());
        }
        return res;
    }

    /**
     * 将一个字符串转换为集合
     */
    private static List<String> getInfixExpression(String str) {
        if (isBlank(str)) {
            return null;
        }
        str = str.replaceAll(" ", "");
        int len = str.length();
        ArrayList<String> res = new ArrayList<>(len);
        int index = 0;
        String join = "";
        char ch;
        while (index < len) {
            // 数字的ASCII值为48~57
            if ((ch = str.charAt(index)) < 48 || ch > 57) {
                // 如果不是数字
                res.add(ch + "");
                index++;
            } else {
                while (index < len && (ch = str.charAt(index)) >= 48 && ch <= 57) {
                    join += ch;
                    index++;
                }
                res.add(join);
                join = "";
            }
        }
        return res;
    }

    private static List<String> getInfixExpressionDecimal(String str) {
        if (isBlank(str)) {
            return null;
        }
        str = str.replaceAll(" ", "");
        int len = str.length();
        ArrayList<String> res = new ArrayList<>(len);
        int index = 0;
        String join = "";
        char ch;
        while (index < len) {
            // 数字的ASCII值为48~57
            if ((ch = str.charAt(index)) < 48 || ch > 57) {
                // 如果不是数字
                res.add(ch + "");
                index++;
            } else {
                while (index < len && ((ch = str.charAt(index)) >= 48 && ch <= 57) || ch == '.') {
                    join += ch;
                    index++;
                }
                res.add(join);
                join = "";
            }
        }
        return res;
    }
}

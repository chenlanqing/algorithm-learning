package com.algorithm.leetcode.string;

import java.util.Stack;

/**
 * https://leetcode.com/problems/backspace-string-compare/
 *
 * @author QingFan
 * @version 1.0.0
 * @date 2022年07月24日 18:49
 */
public class _844_BackspaceCompare {

	public static void main(String[] args) {
		final _844_BackspaceCompare c = new _844_BackspaceCompare();
		System.out.println(c.backspaceCompare("ab##", "c#d#"));
	}

	public boolean backspaceCompare(String S, String T) {
		int sSkipNum = 0; // 记录S的#数量
		int tSkipNum = 0; // 记录T的#数量
		int i = S.length() - 1;
		int j = T.length() - 1;
		while (true) {
			while (i >= 0) { // 从后向前，消除S的#
				if (S.charAt(i) == '#') {
					sSkipNum++;
				} else {
					if (sSkipNum > 0) {
						sSkipNum--;
					} else {
						break;
					}
				}
				i--;
			}
			while (j >= 0) { // 从后向前，消除T的#
				if (T.charAt(j) == '#') {
					tSkipNum++;
				} else {
					if (tSkipNum > 0) {
						tSkipNum--;
					} else {
						break;
					}
				}
				j--;
			}
			// 后半部分#消除完了，接下来比较 S[i] != T[j]
			if (i < 0 || j < 0) {
				break; // S 或者T 遍历到头了
			}
			if (S.charAt(i) != T.charAt(j)) {
				return false;
			}
			i--;
			j--;
		}
		// 说明S和T同时遍历完毕
		if (i == -1 && j == -1) {
			return true;
		}
		return false;
	}

	public boolean doublePoint(String s, String t) {
		int sSkip = 0;
		int tSkip = 0;
		int i = s.length() - 1;
		int j = t.length() - 1;
		while (i >= 0 || j >= 0) {
			while (i >= 0) {
				if (s.charAt(i) == '#') {
					sSkip++;
					i--;
				} else if (sSkip > 0) {
					sSkip--;
					i--;
				} else {
					break;
				}
			}
			while (j >= 0) {
				if (t.charAt(j) == '#') {
					tSkip++;
					j--;
				} else if (tSkip > 0) {
					tSkip--;
					j--;
				} else {
					break;
				}
			}
			if (i >= 0 && j >= 0) {
				if (s.charAt(i) != t.charAt(j)) {
					return false;
				}
			} else {
				if (i >= 0 || j >= 0) {
					return false;
				}
			}
			i--;
			j--;
		}
		return true;
	}

	/**
	 * 使用StringBuilder 调用 api的方式
	 */
	public String build(String str) {
		StringBuilder sb = new StringBuilder();
		int len = str.length();
		for (int i = 0; i < len; i++) {
			char s = str.charAt(i);
			if (s != '#') {
				sb.append(s);
			} else {
				if (sb.length() > 0) {
					sb.deleteCharAt(sb.length() - 1);
				}
			}
		}
		return sb.toString();
	}

	/**
	 * 使用栈的方式
	 */
	public String buildByStack(String str) {
		if (str == null || str.length() == 0) {
			return "";
		}
		Stack<Character> stack = new Stack<>();
		int len = str.length();
		for (int i = 0; i < len; i++) {
			char s = str.charAt(i);
			if (s != '#') {
				stack.push(s);
			} else {
				if (stack.size() > 0) {
					stack.pop();
				}
			}
		}
		StringBuilder sb = new StringBuilder();
		while (!stack.isEmpty()) {
			sb.append(stack.pop());
		}
		return sb.toString();
	}

}

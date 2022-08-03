package com.algorithm.leetcode.string;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

/**
 * @author QingFan
 * @version 1.0.0
 * @date 2022年07月29日 20:49
 */
public class _76_MinStrWindow {

	public static void main(String[] args) {
		System.out.println(minWindow("ADOBECODEBANC", "ABC"));
	}

	static Map<Character, Integer> ori = new HashMap<Character, Integer>();
	static Map<Character, Integer> cnt = new HashMap<Character, Integer>();

	public static String minWindow(String s, String t) {
		int tLen = t.length();
		for (int i = 0; i < tLen; i++) {
			char c = t.charAt(i);
			ori.put(c, ori.getOrDefault(c, 0) + 1);
		}
		int l = 0, r = -1;
		int len = Integer.MAX_VALUE, ansL = -1, ansR = -1;
		int sLen = s.length();
		while (r < sLen) {
			++r;
			if (r < sLen && ori.containsKey(s.charAt(r))) {
				cnt.put(s.charAt(r), cnt.getOrDefault(s.charAt(r), 0) + 1);
			}
			while (check() && l <= r) {
				if (r - l + 1 < len) {
					len = r - l + 1;
					ansL = l;
					ansR = l + len;
				}
				if (ori.containsKey(s.charAt(l))) {
					cnt.put(s.charAt(l), cnt.getOrDefault(s.charAt(l), 0) - 1);
				}
				++l;
			}
		}
		return ansL == -1 ? "" : s.substring(ansL, ansR);
	}

	public static boolean check() {
		for (Entry<Character, Integer> entry : ori.entrySet()) {
			Character key = entry.getKey();
			Integer val = entry.getValue();
			if (cnt.getOrDefault(key, 0) < val) {
				return false;
			}
		}
		return true;
	}

}

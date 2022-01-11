package program.interview.gold.rule;

/**
 * @author QingFan
 * @version 1.0.0
 * @date 2021年12月24日 19:37
 */
public class _01_02_CheckPermutation {

    /**
     * 给定两个字符串 s1 和 s2，请编写一个程序，确定其中一个字符串的字符重新排列后，能否变成另一个字符串。
     * <pre>
     * 示例 1：
     *
     * 输入: s1 = "abc", s2 = "bca"
     * 输出: true
     * 示例 2：
     *
     * 输入: s1 = "abc", s2 = "bad"
     * 输出: false
     *
     * 来源：力扣（Leetcode）
     * 链接：https://leetcode-cn.com/problems/check-permutation-lcci
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * </pre>
     */
    public boolean checkPermutation(String s1, String s2) {
        if (s1 == null && s2 == null) {
            return true;
        }
        if (s1 == null || s2 == null) {
            return false;
        }
        if (s1.length() != s2.length()) {
            return false;
        }

        return false;
    }

}

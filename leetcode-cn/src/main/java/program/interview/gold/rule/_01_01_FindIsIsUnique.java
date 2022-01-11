package program.interview.gold.rule;

import java.util.HashMap;
import java.util.Map;

/**
 * 判定字符是否唯一
 *
 * @author QingFan
 * @version 1.0.0
 * @date 2021年12月24日 19:17
 */
public class _01_01_FindIsIsUnique {

    public static void main(String[] args) {
        System.out.println(isUnique("leetcode"));
        System.out.println(isUnique("abc"));
    }

    /**
     * 实现一个算法，确定一个字符串 s 的所有字符是否全都不同。
     * <pre>
     * 示例 1：
     * 输入: s = "leetcode"
     * 输出: false
     * 示例 2：
     *
     * 输入: s = "abc"
     * 输出: true
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/is-unique-lcci
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * </pre>
     */
    public static boolean isUnique(String str) {
        if (str == null || str.length() == 0) {
            return true;
        }
        Map<Character, Boolean> map = new HashMap<>(str.length());
        for (int i = 0; i < str.length(); i++) {
            final char c = str.charAt(i);
            if (map.containsKey(c)) {
                return false;
            }
            map.put(c, false);
        }
        return true;
    }
}

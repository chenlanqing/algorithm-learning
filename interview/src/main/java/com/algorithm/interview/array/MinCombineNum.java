package com.algorithm.interview.array;

/**
 * https://leetcode-cn.com/problems/ba-shu-zu-pai-cheng-zui-xiao-de-shu-lcof/
 *
 * @author QingFan
 * @version 1.0.0
 * @date 2022年01月04日 19:36
 */
public class MinCombineNum {

    public static void main(String[] args) {
        int[] arr = {3, 30, 34, 5, 9};
        System.out.println(new MinCombineNum().minNumber(arr));
    }

    public String minNumber(int[] nums) {
        // 先将 nums 转换为字符串数组的形式
        String[] strings = new String[nums.length];

        for (int i = 0; i < nums.length; i++) {
            strings[i] = String.valueOf(nums[i]);
        }
        // 通过快速排序的方式，将字符串数组的每个字符按照约定的顺序进行排序
        quickSort(strings, 0, strings.length - 1);

        // 再把字符串数组转字符串的形式
        StringBuilder ans = new StringBuilder();
        for (String s : strings) {
            ans.append(s);
        }
        return ans.toString();
    }

    // 函数传入待排序数组 nums
    // 排序区间的左端点 left
    // 排序区间的右端点 right
    private void quickSort(String[] strings, int left, int right) {
        // 如果 left 大于等于 right，说明该区间只有 1 个或者没有元素
        if (left >= right) {
            // 无需再递归划分后再排序，直接返回
            return;
        }

        // 调用函数 partition，将 left 和 right 之间的元素划分为左右两部分
        int mid = partition(strings, left, right);

        // 划分之后，再对 mid 左侧的元素进行快速排序
        quickSort(strings, left, mid - 1);

        // 划分之后，再对 mid 右侧的元素进行快速排序
        quickSort(strings, mid + 1, right);
    }

    // 直接套之前的快速排序的代码进行修改
    // 原先的小于的含义指的是数值上的小于，比如 1  < 10
    // 但现在的小于含义为：a + b 拼凑的字符串小于 b + a 拼凑的字符串
    // 比如 a = 1 ，b = 10
    // 那么 a + b = “110”，b + a = “101”
    // 显然，b + a < a + b
    // 也就是说 a 应该放到 b 的后面来拼凑字符串
    private int partition(String[] strings, int left, int right) {

        // 经典快速排序的写法
        // 设置当前区间的第一个元素为基准元素
        String pivot = strings[left];

        // left 向右移动，right 向左移动，直到 left 和 right 指向同一元素为止
        while (left < right) {

            // 当 pivot + strings[right] 的字符串小于 strings[right] + pivot 的字符串时
            // 说明 strings[right] 在正确的位置上，right 向左移动
            while (left < right && (pivot + strings[right]).compareTo(strings[right] + pivot) <= 0) {
                // right 不断的向左移动
                right--;
            }

            // 此时，跳出了上面这个 while 循环，说明 pivot + strings[right] 的字符串大于 strings[right] + pivot 的字符串了
            // 说明 strings[right] 不在正确的位置上
            // 将此时的 strings[left] 赋值为 strings[right]
            // 执行完这个操作，比 pivot 小的这个元素被移动到了左侧
            strings[left] = strings[right];

            // 当 strings[left] + pivot 的字符串小于 pivot + strings[left] 的字符串时
            // 说明 strings[left] 在正确的位置上，left 向右移动
            while (left < right && (strings[left] + pivot).compareTo(pivot + strings[left]) <= 0) {
                // left 不断的向右移动
                left++;
            }

            // 此时，跳出了上面这个 while 循环，说明 strings[left] + pivot 的字符串大于 pivot + strings[left] 的字符串了
            // 说明 strings[left] 不在正确的位置上
            // 将此时的 strings[right] 赋值为 strings[left]
            // 执行完这个操作，比 pivot 大的这个元素被移动到了右侧
            strings[right] = strings[left];
        }

        // 此时，left 和 right 相遇，那么需要将此时的元素设置为 pivot
        // 这个时候，pivot 的左侧元素都小于它，右侧元素都大于它
        strings[left] = pivot;

        // 返回 left
        return left;

    }
}

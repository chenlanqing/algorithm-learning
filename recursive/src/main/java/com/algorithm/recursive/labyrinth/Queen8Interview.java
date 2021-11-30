package com.algorithm.recursive.labyrinth;

/**
 * @author QingFan
 * @version 1.0.0
 * @date 2021年11月22日 21:29
 */
public class Queen8Interview {

    public static void main(String[] args) {
        int n = 8;
        int upperLim = (1 << n) - 1;
        System.out.println(process(upperLim, 0, 0, 0));
    }

    public static int process(int upperLim, int colLim, int leftDiaLim, int rightDiaLim) {
        if (colLim == upperLim) {
            return 1;
        }
        int pos = 0;
        int mostRightOne = 0;
        pos = upperLim & (~(colLim | leftDiaLim | rightDiaLim));
        int res = 0;
        while (pos != 0) {
            mostRightOne = pos & (~pos + 1);
            pos = pos - mostRightOne;
            res += process(upperLim, colLim | mostRightOne,
                    (leftDiaLim | mostRightOne) << 1, (rightDiaLim | mostRightOne) >>> 1);
        }
        return res;
    }
}

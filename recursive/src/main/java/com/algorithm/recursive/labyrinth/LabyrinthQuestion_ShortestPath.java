package com.algorithm.recursive.labyrinth;

import com.algorithm.common.utils.ArrayUtils;

/**
 * 迷宫问题的最短路径
 *
 * @author QingFan
 * @version 1.0.0
 * @date 2021年11月21日 19:08
 */
public class LabyrinthQuestion_ShortestPath {

    public static void main(String[] args) {
        int row = 8, col = 7;
        int[][] map = initMap(row, col);
        System.out.println("当前地图:");
        ArrayUtils.printMatrix(map, row, col);
        setWay(map, 1, 1, 4, 1);
        System.out.println("小球走过之后的地图:");
        ArrayUtils.printMatrix(map, row, col);
    }

    /**
     * 走迷宫问题，按照路径：下 -> 右 -> 上 -> 左 的顺序
     * <pre>
     *  思路说明：
     *  1. 从 startX,startY 开始走，到 endX,endY 结束
     *  2. 当走到 endX,endY 时，表示已经找到了路线
     *  3. 约定：map 中的含义：
     *      0：表示该点没有走过
     *      1：表示围墙，不能走
     *      2：表示改点已走过，并且可以走
     *      3：表示改点已走过，但是走不通
     *
     *  4. 走迷宫，约定一个寻找路线的策略，也就是当你站在一个点的时候，你从哪一个方向开始探索？
     *     这里规定探索的方向为：下 -> 右 -> 上 -> 左，如果该点走不通，再回溯
     * </pre>
     *
     * @param map 迷宫地图，一般是一个二维数组
     * @param startX 走迷宫起始点：x
     * @param startY 走迷宫起始点：y
     * @param endX 走迷宫终点位置：x
     * @param endY 走迷宫终点位置：y
     * @return 是否找到路径
     */
    public static boolean setWay(int[][] map, int startX, int startY, int endX, int endY) {
        // 如果当结束点已经走过，表示已经到达了出口
        if (map[endX][endY] == 2) {
            return true;
        }
        // 如果该点还没有走过，则可以尝试探索
        if (map[startX][startY] == 0) {
            // 先假定该点标可以通过，因为要去探索四周的点是否可以走
            map[startX][startY] = 2;
            // 根据策略：先往下走，如果可以走则返回 true
            if (setWay(map, startX + 1, startY, endX, endY)) {
                // 向下走
                return true;
            } else if (setWay(map, startX, startY + 1, endX, endY)) {
                // 如果走不通，则继续往右边探索
                // 向右走
                return true;
            } else if (setWay(map, startX - 1, startY, endX, endY)) {
                // 如果走不通，则继续往上边探索
                // 向上走
                return true;
            } else if (setWay(map, startX, startY + 1, endX, endY)) {
                // 向左走
                return true;
            } else {
                // 都走不通，表示改点是一个死点，四周都无法出去
                map[startX][startY] = 3;
                return false;
            }
        } else {
            // 如果不为 0，可能的情况是：1，2，3，这三种表示都表示不可以走
            return false;
        }
    }

    /**
     * 构建一个有挡板的地图
     * <pre>
     * 数字 1：表示挡板围墙，小球不可以经过
     * 数字 0：表示是路，小球可以经过
     * 起点：可以自定义起点
     * 出口：其实也可以自定义出口，但是本题规定，出口就是右下角的 0
     * 1 1 1 1 1 1 1
     * 1 0 0 0 0 0 1
     * 1 0 0 0 0 0 1
     * 1 1 1 0 0 0 1
     * 1 0 0 0 0 0 1
     * 1 0 0 0 0 0 1
     * 1 0 0 0 0 0 1
     * 1 1 1 1 1 1 1
     * </pre>
     *
     * @param row 行
     * @param col 列
     * @return 二维数组的迷宫
     */
    public static int[][] initMap(int row, int col) {
        int[][] map = new int[row][col];
        for (int i = 0; i < col; i++) {
            map[0][i] = 1;
            map[row - 1][i] = 1;
        }
        for (int i = 0; i < row; i++) {
            map[i][0] = 1;
            map[i][col - 1] = 1;
        }
        map[3][1] = 1;
        map[3][2] = 1;
        return map;
    }
}

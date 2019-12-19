package com.zxj.graph;

/**
 * 迪杰斯特拉算法求解最短路径
 */
public class Dijkstra {
    /*
     * 0 0 0 0 0 0 0
     * 0 0 -1 10 -1 30 100
     * 0 -1 0 5 -1 -1 -1
     * 0 -1 -1 0 50 -1 -1
     * 0 -1 -1 -1 0 -1 10
     * 0 -1 -1 -1 20 0 60
     * 0 -1 -1 -1 -1 -1 0
     */


    public static void main(String[] args) {
        //表示n个点，m条边，firstPoint点为起点
        int n = 6, m = 6, firstPoint = 1;
        /*
         * 图的加权邻接矩阵
         */
        int[][] map = {
                {0, 0, 0, 0, 0, 0, 0},
                {0, 0, -1, 10, -1, 30, 100},
                {0, -1, 0, 5, -1, -1, -1},
                {0, -1, -1, 0, 50, -1, -1},
                {0, -1, -1, -1, 0, -1, 10},
                {0, -1, -1, -1, 20, 0, 60},
                {0, -1, -1, -1, -1, -1, 0}};
        //初始化迪杰斯特拉数组
        int[] dis = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            if (map[1][i] <= 0) {
                dis[i] = Integer.MAX_VALUE;
            } else {
                dis[i] = map[1][i];
            }
        }
        dijkstra(map, dis, firstPoint, n);
    }

    /**
     * @param map 地图数组
     * @param dis 起点到每个点的最短路径
     * @param x   起点
     * @param n   点的个数
     */
    public static void dijkstra(int[][] map, int[] dis, int x, int n) {
        //标记是否走过
        boolean[] mark = new boolean[n + 1];
        //标记起点已经走过
        mark[x] = true;
        //到自己的位置长度为0
        dis[x] = 0;
        //遍历每一个点
        for (int i = 1; i <= n; i++) {
            int loc = 0;
            int min = Integer.MAX_VALUE;
            //采用贪心算法求解，局部最短推导出全局最短
            //求解dis数组里面的最小值，可以考虑使用小根堆
            for (int j = 1; j <= n; j++) {
                if (!mark[j] && dis[j] < min) {
                    min = dis[j];
                    loc = j;
                }
            }
            //没有点
            if (loc == 0) {
                break;
            }
            //标记下一个点已经查找
            mark[loc] = true;
            //判断下一个点到该点连接的其他各个点的最短路径
            for (int j = 1; j <= n; j++) {
                if (map[loc][j] != -1 && (dis[loc] + map[loc][j] < dis[j])) {
                    dis[j] = dis[loc] + map[loc][j];
                }
            }
        }
        //输出起点到其他点的最短路径
        for (int i = 1; i <= n; i++) {
            System.out.println(x + " to " + i + " min path = " + dis[i]);
        }
    }
}

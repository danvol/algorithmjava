package com.zxj.graph;

import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

/**
 * 0 0 1 0
 * 0 0 0 0
 * 0 0 1 0
 * 0 1 0 0
 * 0 0 0 1
 * 广度优先搜索
 * 从[0][0]开始
 *
 * @author littleboy
 */
public class BFS {
    int n;//地图行
    int m;//地图列
    int dx;//解救位置
    int dy;//解救位置
    int[][] data = new int[n][m];//地图集
    boolean[][] mark;//是否走过
    int next[][] = {{0, -1}, {1, 0}, {0, 1}, {-1, 0}};//下一步位置

    public BFS(int n, int m, int dx, int dy, int[][] data) {
        this.n = n;
        this.m = m;
        this.dx = dx;
        this.dy = dy;
        this.data = data;
        mark = new boolean[n][m];
    }

    public static void main(String[] args) {
        int[][] data = {{0, 0, 1, 0}, {0, 0, 0, 0}, {0, 0, 1, 0}, {0, 1, 0, 0}, {0, 0, 0, 1}};
        int dx = 3;
        int dy = 2;
        System.out.println(data.length + " " + data[0].length);
        BFS bfs = new BFS(data.length, data[0].length, dx, dy, data);
        bfs.bfs(0, 0);
    }

    /**
     * BFS广度优先搜索算法
     *
     * @param x 起点x
     * @param y 起点y
     */
    public void bfs(int x, int y) {
        //不在范围内
        if (x < 0 || x >= n || y < 0 || y >= m) {
            System.out.println("not here");
            return;
        }
        //起点和终点一样
        if (x == dx && y == dy) {
            System.out.println("find it");
            return;
        }
        //标记自身位置
        mark[x][y] = true;
        //创建队列
        Queue<Point> queue = new ArrayBlockingQueue<Point>(n * m);
        Point start = new Point(x, y);
        //添加自身到队列中
        queue.add(start);
        while (!queue.isEmpty()) {
            //取出队列中的点，向下遍历
            Point point = queue.poll();
            for (int i = 0; i < next.length; i++) {
                //获取下一个点的XY
                int nextX = point.x + next[i][0];
                int nextY = point.y + next[i][1];
                //超出边界
                if (nextX < 0 || nextX >= n || nextY < 0 || nextY >= m) {
                    continue;
                }
                //可以向下走
                if (data[nextX][nextY] == 0 && !mark[nextX][nextY]) {
                    //如果找到了，就返回
                    if (nextX == dx && nextY == dy) {
                        System.out.println("find it X = " + nextX + " Y = " + nextY);
                        return;
                    }
                    //没有找到，就添加下一个点到队列中，并且标记
                    Point newPoint = new Point(nextX, nextY);
                    mark[nextX][nextY] = true;
                    queue.add(newPoint);
                }

            }
        }
        System.out.println("not here");
        return;
    }
}

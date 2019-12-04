package com.zxj.graph;

import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

public class BFSTest {
    int n;
    int m;
    int dx;
    int dy;
    int[][] data;
    int[][] next = {{0, -1}, {1, 0}, {0, 1}, {-1, 0}};
    boolean[][] mark;
    int minStep = Integer.MAX_VALUE;

    public BFSTest(int n, int m, int dx, int dy, int[][] data) {
        this.n = n;
        this.m = m;
        this.dx = dx;
        this.dy = dy;
        this.data = data;
        this.mark = new boolean[n][m];
    }

    public static void main(String[] args) {
        int[][] data = {{0, 0, 1, 0}, {0, 0, 0, 0}, {0, 0, 1, 0}, {0, 1, 0, 0}, {0, 0, 0, 1}};
        int dx = 3;
        int dy = 2;
        BFSTest bfsTest = new BFSTest(data.length, data[0].length, dx, dy, data);
//        bfsTest.BFS(0, 0);
        bfsTest.DFS(0,0,0);
        System.out.println(bfsTest.minStep);

    }

    public void DFS(int x, int y, int step) {
        if (x == dx && y == dy) {
            if (step < minStep) {
                minStep = step;
            }
            return;
        }
        for (int i = 0; i < next.length; i++) {
            int nx = x + next[i][0];
            int ny = y + next[i][1];
            if (nx < 0 || nx >= n || ny < 0 || ny >= m) {
                continue;
            }
            if (data[nx][ny] == 0 && !mark[nx][ny]) {
                mark[nx][ny] = true;
                DFS(nx, ny, step + 1);
                mark[nx][ny] = false;
            }
        }
    }

    public void BFS(int x, int y) {
        if (x < 0 || x >= n || y < 0 || y >= m) {
            System.out.println("she is not here");
        }
        if (x == dx && y == dy) {
            System.out.println("she is here");
        }
        Point start = new Point(x, y);
        mark[x][y] = true;
        Queue<Point> queue = new ArrayBlockingQueue<>(n * m);
        queue.add(start);
        while (!queue.isEmpty()) {
            Point point = queue.poll();
            for (int i = 0; i < next.length; i++) {
                int nx = point.x + next[i][0];
                int ny = point.y + next[i][1];
                if (nx < 0 || nx >= n || ny < 0 || ny >= m) {
                    continue;
                }
                if (data[nx][ny] == 0 && !mark[nx][ny]) {
                    if (nx == dx && ny == dy) {
                        System.out.println("She is here");
                        return;
                    }
                    Point nextPoint = new Point(nx, ny);
                    mark[nx][ny] = true;
                    queue.add(nextPoint);
                }
            }
        }
    }
}

\* [图](#%E5%9B%BE)

 \* [1\. 什么是图](#1-%E4%BB%80%E4%B9%88%E6%98%AF%E5%9B%BE)

 \* [2\. 图的基本知识](#2-%E5%9B%BE%E7%9A%84%E5%9F%BA%E6%9C%AC%E7%9F%A5%E8%AF%86)

 \* [3\. 图的存取](#3-%E5%9B%BE%E7%9A%84%E5%AD%98%E5%8F%96)

  \* [（1）图里有x个点就是 x\*x的矩阵。](#1%E5%9B%BE%E9%87%8C%E6%9C%89x%E4%B8%AA%E7%82%B9%E5%B0%B1%E6%98%AF-xx%E7%9A%84%E7%9F%A9%E9%98%B5)

  \* [（2）数组加链表](#2%E6%95%B0%E7%BB%84%E5%8A%A0%E9%93%BE%E8%A1%A8)

  \* [（3）两种方式的有优缺点](#3%E4%B8%A4%E7%A7%8D%E6%96%B9%E5%BC%8F%E7%9A%84%E6%9C%89%E4%BC%98%E7%BC%BA%E7%82%B9)

 \* [4\. 图的遍历](#4-%E5%9B%BE%E7%9A%84%E9%81%8D%E5%8E%86)

 \* [5\. 图的应用](#5-%E5%9B%BE%E7%9A%84%E5%BA%94%E7%94%A8)

 \* [6\. BFS算法示例：](#6-bfs%E7%AE%97%E6%B3%95%E7%A4%BA%E4%BE%8B)

  \* [(1)变量说明](#1%E5%8F%98%E9%87%8F%E8%AF%B4%E6%98%8E)

  \* [(2)主要方法](#2%E4%B8%BB%E8%A6%81%E6%96%B9%E6%B3%95)

  \* [(3)<a href="\./src/com/zxj/graph/BFS\.java">BFS示例源码</a>](#3bfs%E7%A4%BA%E4%BE%8B%E6%BA%90%E7%A0%81)

 \* [7\. DFS算法示例](#7-dfs%E7%AE%97%E6%B3%95%E7%A4%BA%E4%BE%8B)

  \* [(1)主要方法](#1%E4%B8%BB%E8%A6%81%E6%96%B9%E6%B3%95)

  \* [(2)<a href="\./usr/com/zxj/graph/DFS\.java">DFS示例源码</a>](#2dfs%E7%A4%BA%E4%BE%8B%E6%BA%90%E7%A0%81)

 \* [8\. 图的最短路径](#8-%E5%9B%BE%E7%9A%84%E6%9C%80%E7%9F%AD%E8%B7%AF%E5%BE%84)

  \* [1\. 最短路径分析](#1-%E6%9C%80%E7%9F%AD%E8%B7%AF%E5%BE%84%E5%88%86%E6%9E%90)

  \* [2\.储存结构](#2%E5%82%A8%E5%AD%98%E7%BB%93%E6%9E%84)

  \* [3\.算法选择](#3%E7%AE%97%E6%B3%95%E9%80%89%E6%8B%A9)

  \* [4\.算法核心思路分析](#4%E7%AE%97%E6%B3%95%E6%A0%B8%E5%BF%83%E6%80%9D%E8%B7%AF%E5%88%86%E6%9E%90)

  \* [5\.算法讲解](#5%E7%AE%97%E6%B3%95%E8%AE%B2%E8%A7%A3)

  \* [6\.代码详解（<a href="\./src/com/zxj/graph/Dijkstra\.java">源代码示例</a>）](#6%E4%BB%A3%E7%A0%81%E8%AF%A6%E8%A7%A3%E6%BA%90%E4%BB%A3%E7%A0%81%E7%A4%BA%E4%BE%8B)

# 图

## 1. 什么是图

图（Graph）是一种非线性数据结构。可以说它是一种比较复杂的数据结构，它比树还要复杂。因为图没有层的概念，它们之间的任意元素都可能产生关系。

## 2. 图的基本知识

（1）顶点：即每个节点

（2）边：两个点连接的先

（3）顶点的度：一个顶点的度是指与该顶点相关联的边的条数，顶点v的度记作d(v)。

（4）出度、入度：对于有向图来说，一个顶点的度可细分为入度和出度。一个顶点的入度是指与其关联的各边之中，以其为终点的边数；出度则是相对的概念，指以该顶点为起点的边数。

（5）有向图/无向图：如果给图的每条边规定一个方向，那么得到的图称为有向图。在有向图中，与一个节点相关联的边有出边和入边之分。相反，边没有方向的图称为无向图。

![image-20191210192052839](Graph.assets/image-20191210192052839.png)

![image-20191210192112987](Graph.assets/image-20191210192112987.png)

## 3. 图的存取

### （1）图里有x个点就是 x*x的矩阵。

`A[1][1]`:表示从1到1的情况，`A[1][2]`就表示1到2的情况，有边的就是1,`A[1][2]`=1,没有的就是0 `A[1][3]`=0

### （2）数组加链表

### （3）两种方式的有优缺点

​	数组：浪费空间，但是速度块。数据不大 优先选用数组

​	链表：节省空间，但是速度慢

## 4. 图的遍历

搜索算法：

（1）深度优先遍历（DFS）：大家可以想象玩迷宫，是不是选择一个方向走到底，直到不能走了你在返回一步继续试其他的方向，没错这其实就是深度优先遍历。一条路走到底，递归，有回溯。也要标记走过的点

关键的优化:剪枝

![image-20191210192052839](Graph.assets/image-20191210192052839.png)

举个例子，从A节点出发，第一次深度优先搜索

A -> B -> C -> E - > D ->

此时，D指向了C，但是C已经走过了，D无路可走了，所以要回溯。

A -> B -> C -> E -> 此时E指向了B，B也已经走过了，所以继续回溯

A -> B -> C ->同理，C也没有路可以走，继续回溯

A -> B -> 此时B还指向了F，所以可以继续向F走

A -> B -> F -> G  这里就遍历完了所有的节点

（2）广度优先遍历（BFS）：类似于树结构的层次遍历，先找到一个点，然后把该点加入队列，依次找出该点的关联边加入队列，循环操作，一直到队列为空。

两个关键点：队列，标记数组，加过的点不能在加。

![image-20191210192052839](Graph.assets/image-20191210192052839.png)

* 还是从A出发

A -> B 这里A只能到B 

* 然后从B出发

B -> C B ->E B -> F 这里B可以到达三个点

* 然后从C出发

C ->   这里C可以到E，但是E已经被B遍历了，所以C没有可以走的节点

* 然后从E出发

E - > D

* 然后从F出发

F -> G

* 然后从D出发

D -> 这里D可以到C，但是C已经走过，所以没有路可以走

广度优先搜索遍历完成

启发式搜索，A* [简介百度百科](https://baike.baidu.com/item/%E5%90%AF%E5%8F%91%E5%BC%8F%E6%90%9C%E7%B4%A2/8944170?fr=aladdin)

## 5. 图的应用
社交网络:QQ推荐

知图谱:推荐算法，数据挖掘

图数据库:Neo4j

路径问题：（导航软件），迪杰斯特拉算法。

## 6. BFS算法示例：

![image-20191210195801841](Graph.assets/image-20191210195801841.png)

### (1)变量说明

都是类的属性变量

```java
    /**
     * 地图行
     */
    int n;
    /**
     * 地图列
     */
    int m;
    /**
     * 解救位置
     */
    int dx;
    /**
     * 解救位置
     */
    int dy;
    /**
     * 地图集
     */
    int[][] data = new int[n][m];
    /**
     * 是否走过
     */
    boolean[][] mark;
    /**
     * 下一步位置，分别对应了上右下左
     */
    int[][] next = {{0, -1}, {1, 0}, {0, 1}, {-1, 0}};
```

### (2)主要方法
x为初始的横坐标，y为初始的纵坐标
```java
public void bfs(int x, int y)
```
判断初始坐标是否在范围内
```java
if (x < 0 || x >= n || y < 0 || y >= m) {
	System.out.println("not here");
	return;

```
判断初始位置是否和终点一直，若一致就不需要在搜索
```java
if (x == dx && y == dy) {
		System.out.println("find it");
    return;
}
```

然后标记自身位置为true，表示这里已经走过

```
mark[x][y] = true;
```

创建优先队列，添加当前的点，先进先出队列

```java
//创建队列
Queue<Point> queue = new ArrayBlockingQueue<Point>(n * m);
Point start = new Point(x, y);
//添加自身到队列中
queue.add(start);
```

然后循环判断是否遍历了每个点

```java
while (!queue.isEmpty()) {
```
取出前面之前加入的点
```java
            //取出队列中的点，向下遍历
            Point point = queue.poll();
```
遍历该点的周围四个点
```java
            for (int i = 0; i < next.length; i++) {
                //获取下一个点的XY
                int nextX = point.x + next[i][0];
                int nextY = point.y + next[i][1];
```
判断周围的点是否在地图内部
```java
                //超出边界
                if (nextX < 0 || nextX >= n || nextY < 0 || nextY >= m) {
                    continue;
                }
```
如果已经在内部，判断是否可以继续向这个方向走，首先判断是否有障碍物，然后判断是否已经走过，data为0表示可以走，1表示有障碍物，mark为true表示已经走过
```java
                //可以向下走
                if (data[nextX][nextY] == 0 && !mark[nextX][nextY]) {
```
如果已经找到了重点，即可返回
```java
                    //如果找到了，就返回
                    if (nextX == dx && nextY == dy) {
                        System.out.println("find it X = " + nextX + " Y = " + nextY);
                        return;
                    }
```
如果没有找到，将这个点加入队列中，mark设置为true，表示走过，继续遍历下一个点
```java
                    //没有找到，就添加下一个点到队列中，并且标记
                    Point newPoint = new Point(nextX, nextY);
                    mark[nextX][nextY] = true;
                    queue.add(newPoint);
                }

            }
        }
```

### (3)[BFS示例源码](./src/com/zxj/graph/BFS.java)

## 7. DFS算法示例

### (1)主要方法
x 为遍历的当前位置的横坐标，y为当前位置的纵坐标，step为当前的步数
```java
    public void dfs(int x, int y, int step) {
```
递归设置结束条件，当起点等于终点，既可以回溯，如果最小的步数大于当前的步数，说明当前的路径比之前的都要短，所以记录最小的步数
```java
        //结束条件
        if (x == dx && y == dy) {
            //如果找到了，而且步数小于之前的最小步数
            if (minStep > step) {
                //更新步数
                minStep = step;
            }
            return;
        }
```
从该点的四个方向遍历，查找可以走的点
```java
        //查找四个方向
        for (int i = 0; i < next.length; i++) {
            //下一个点
            int nextX = x + next[i][0];
            int nextY = y + next[i][1];
```
判断该点周围的点是否超出了边界
```java
            //超出边界
            if (nextX < 0 || nextX >= n || nextY < 0 || nextY >= m) {
                continue;
            }
```
判断该店是否为障碍，而且是否已经走过，如果没有走过，既可以设置为true，继续从这个点搜索
```java
            //下一个点可以走
            if (data[nextX][nextY] == 0 && !mark[nextX][nextY]) {
                mark[nextX][nextY] = true;
```
从这个点继续搜索，并且步数加1，回溯的时候释放该点
```java
                dfs(nextX, nextY, step + 1);
                mark[nextX][nextY] = false;
            }
        }
    }
```

### (2)[DFS示例源码](./usr/com/zxj/graph/DFS.java)

## 8. 图的最短路径

### 1. 最短路径分析

高德地地图中最基础的功能就是最优路线：比如路径最短，时间最短等，首先解决这个问题需要的数据结构就是用图结构来表示最好了。可以把每个路口看成一个点，路口之间的路看作一条边。路的长度就是边的权重，既可以得到以下这个图形。

这里我们就将地图转化为我们熟悉的数据结构图，那么假设我们要从1点作为起点，则就变成求1到其他点的最短路径。

贪心算法：局部最优推出全局最优。

DFS：能解决问题，时间复杂度和路径数量之间相关。

![image-20191222112928788](Graph.assets/image-20191222112928788.png)

### 2.储存结构

大图一定要用邻接表，小图可以用邻接矩阵。

### 3.算法选择

经典算法 迪杰斯特拉（Dijkstra）算法，即单元最短路径算法，它是所有最短路径算法的基础，我们的地图软件最终使用的算法也是以他为基础进行的优化。

### 4.算法核心思路分析

求1到其他任意点的最短路径。<font color=red>**data为邻接矩阵,`data[3][4]`表示3到4的权重。**</font>

1. 开一个dis数组，用来表示起点到每个顶点的距离，最开始时赋值为无穷大。

2. 加变量loc，初始值为起点。

   贪心的策略：在dis数组里面找到里起点最近的那个点

3. 通过loc更新dis数组，因为加入一个点后就可以更新路径。核心步骤，求解**min(dis[x],`dis[y] + data[y][x]`)**，表示**起点到x点**的距离和**起点到y点的距离加上y到x点的距离和**比较，求解最小的（贪心策略）。
4. 在dis数组中找离起点最近的点，排除已经选择过的点，将之赋值给loc。
5. 重复执行3和4操作，知道所有的点加完

### 5.算法讲解

![image-20191222112928788](Graph.assets/image-20191222112928788.png)

* 第一步，初始化dis数组和mark数组，dis数组全部为无穷大，mark数组全为false，表示没有走过

  | 1   | 2   | 3   | 4   | 5| 6   |
| ---- | ---- | ---- | ---- | ---- | ---- |
| INT   | INT   | INT   | INT   | INT   | INT   |
| false | false | false | false | false | false |

* 第二步，loc=1，将该点和其他能到达的点加入到dis数组中，有图知，1能到3、5和6，自身的位置标记为0，mark标记为true，表示走过。

| 1   | 2   | 3   | 4   | 5| 6   |
| ---- | ---- | ---- | ---- | ---- | ---- |
| INT   | INT   | INT   | INT   | INT   | INT   |
| <font color=red>0</font> | INT  | 10   | INT  | 30   | 100  |
| <font color=red>true</font> | false | false | false | false | false |

* 第三步，选择dis数组中最小的，并且mark为false 的点，加进来，最小值的点为3，所以loc=3，这时发现3可以到4，所以就可以计算1到4的较短的距离，是dis[4]还是dis[3]+`data[3][4]`，所以只需求比较dis[4]和dis[3]+`data[3][4]`距离。谁比较小，就更新。由表格可以看出，dis[4]为无穷大，所以更新dis[4]为60，表示1到4的距离为60，同时标记3的位置已经加入。

| 1   | 2   | 3   | 4   | 5| 6   |
| ---- | ---- | ---- | ---- | ---- | ---- |
| INT   | INT   | INT   | INT   | INT   | INT   |
| <font color=red>0</font> | INT  | 10   | INT  | 30   | 100  |
| <font color=red>0</font> | INT  | <font color=red>10</font> | 60 | 30   | 100  |
| <font color=red>true</font> | false | <font color=red>true</font> | false | false | false |

* 第四步，继续寻找dis中最小的值，而且mark为false的点，即为5这个点，所以loc=5，发现5可以到4，也可以到6，所以要同时比较到4和到6的距离，比较dis[4]和dis[5]+`data[5][4]`，将小的更新到dis数组中，dis[6]和dis[5]+`data[5][6]`，将小的更新到dis数组中。

  5到4的距离为20，dis[4]=60，dis[5]+`data[5][6]`=50，所以更新dis[4]为50，同理更新dis[6]，标记5为加入的点，mark为true
| 1   | 2   | 3   | 4   | 5| 6   |
| ---- | ---- | ---- | ---- | ---- | ---- |
| INT   | INT   | INT   | INT   | INT   | INT   |
| <font color=red>0</font> | INT  | 10   | INT  | 30   | 100  |
| <font color=red>0</font> | INT  | <font color=red>10</font> | 60 | 30   | 100  |
| <font color=red>0</font> | INT  | <font color=red>10</font> | 50 | <font color=red>30</font> | 90 |
| <font color=red>true</font> | false | <font color=red>true</font> | false | <font color=red>true</font> | false |

* 第五步，继续寻找dis中最小的值，并且mark为false的值，即为4这个点，所以loc=4，发现4可以到6，比较dis[6]的值和dis[4]加上4到6的距离哪一个小，dis[6]=90，dis[4]+`data[4][6]`=60，所以更新dis[6]的值，标记4为走过的点。

| 1   | 2   | 3   | 4   | 5| 6   |
| ---- | ---- | ---- | ---- | ---- | ---- |
| INT   | INT   | INT   | INT   | INT   | INT   |
| <font color=red>0</font> | INT  | 10   | INT  | 30   | 100  |
| <font color=red>0</font> | INT  | <font color=red>10</font> | 60 | 30   | 100  |
| <font color=red>0</font> | INT  | <font color=red>10</font> | 50 | <font color=red>30</font> | 90 |
| <font color=red>0</font> | INT  | <font color=red>10</font> | <font color=red>50</font> | <font color=red>30</font> | 60 |
| <font color=red>true</font> | false | <font color=red>true</font> | <font color=red>true</font> | <font color=red>true</font> | false |

* 第六步，继续寻找dis中最小的值，且mark为false的值，即为6这个点，loc=6，发现6没有可以到达的点，直接标记为true

  | 1   | 2   | 3   | 4   | 5| 6   |
  | ---- | ---- | ---- | ---- | ---- | ---- |
  | INT   | INT   | INT   | INT   | INT   | INT   |
  | <font color=red>0</font> | INT  | 10   | INT  | 30   | 100  |
  | <font color=red>0</font> | INT  | <font color=red>10</font> | 60 | 30   | 100  |
  | <font color=red>0</font> | INT  | <font color=red>10</font> | 50 | <font color=red>30</font> | 90 |
  | <font color=red>0</font> | INT  | <font color=red>10</font> | <font color=red>50</font> | <font color=red>30</font> | <font color=red>60</font> |
  | <font color=red>true</font> | false | <font color=red>true</font> | <font color=red>true</font> | <font color=red>true</font> | <font color=red>true</font> |
* 第七步，继续寻找dis中最小的，且没有标记的点，即为2，发现1没有到2的路径，所以，算法结束

  | 1   | 2   | 3   | 4   | 5| 6   |
  | ---- | ---- | ---- | ---- | ---- | ---- |
  | INT   | INT   | INT   | INT   | INT   | INT   |
  | <font color=red>0</font> | INT  | 10   | INT  | 30   | 100  |
  | <font color=red>0</font> | INT  | <font color=red>10</font> | 60 | 30   | 100  |
  | <font color=red>0</font> | INT  | <font color=red>10</font> | 50 | <font color=red>30</font> | 90 |
  | <font color=red>0</font> | <font color=red>INT</font> | <font color=red>10</font> | <font color=red>50</font> | <font color=red>30</font> | <font color=red>60</font> |
  | <font color=red>true</font> | <font color=red>true</font> | <font color=red>true</font> | <font color=red>true</font> | <font color=red>true</font> | <font color=red>true</font> |

所以，最后的结果是，表示1到每个点的最短的路径：

| 1    | 2    | 3    | 4    | 5    | 6    |
| ---- | ---- | ---- | ---- | ---- | ---- |
| 0    | INT  | 10   | 50   | 30   | 60   |

### 6.代码详解（[源代码示例](./src/com/zxj/graph/Dijkstra.java)）

![image-20191222112928788](Graph.assets/image-20191222112928788.png)

图的邻接矩阵：

```java
/**
 * 迪杰斯特拉算法求解最短路径
 */
public class Dijkstra {
    /*
     * 图的邻接矩阵 下标从1开始，0代表本身到本身的距离，-1表示无穷大，其他表示权重
     * 0 0 0 0 0 0 0
     * 0 0 -1 10 -1 30 100
     * 0 -1 0 5 -1 -1 -1
     * 0 -1 -1 0 50 -1 -1
     * 0 -1 -1 -1 0 -1 10
     * 0 -1 -1 -1 20 0 60
     * 0 -1 -1 -1 -1 -1 0
     */
```
n表示有n个点，firstPoint为起点
```java

    public static void main(String[] args) {
        //表示n个点，firstPoint点为起点
        int n = 6, firstPoint = 1;
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
```
循环初始化dis数组，并且添加起点可以到达的点
```java
        int[] dis = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            if (map[1][i] <= 0) {
                dis[i] = Integer.MAX_VALUE;
            } else {
                //1到其他点的距离
                dis[i] = map[1][i];
            }
        }
        dijkstra(map, dis, firstPoint, n);
    }
    
```
寻找每个点的最短路径
```java

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
            //已经遍历完所有的点
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

```


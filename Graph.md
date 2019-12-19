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

## 8. 迪杰斯特拉算法



# heap(堆树)
[堆排序代码示例](src/com/zxj/heap/HeapSort.java)<br>
支持大根堆和小根度，递归建堆，堆的插入和删除

[求解topK问题](src/com/zxj/heap/TopK.java)<br>
给你1亿个不重复的数字（整数，1~2^32-1），求出top10。前10大的数字，还可动态添加新数字，但总个数不会超过1亿。

我的求解思路：每次运行前创建多个文件，顺序的添加数字，模拟动态添加，然后每次读取一个文件，依次插入到topK中，这样把所有的文件读取完后，即为全部数字的topK。

# graph(图)
[BFS广度优先搜索](src/com/zxj/graph/BFS.java)


[DFS深度优先搜索](src/com/zxj/graph/DFS.java)

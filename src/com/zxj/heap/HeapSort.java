package com.zxj.heap;

import java.util.Arrays;

/**
 * 堆的建立，插入删除，堆排序
 * @author littleboy
 */
public class HeapSort {
    public static void main(String[] args) {
        int[] data = {31,30,29,28,27,26,25,24,23,22,21,20,19,18,17,16,15,14,13,12,11,10,9,8,7,6,5,4,3,2,1};
        heapSort(data);
//        System.out.println("堆排序：" + Arrays.toString(data));
//        heap(data);//堆化一个数组
//        System.out.println("堆化：" + Arrays.toString(data));

//        int[] data = {};
//        data = insertElement(data, 19);
        System.out.println(Arrays.toString(data));
//        data = deleteElement(data, 0);//删除第0个元素
//        System.out.println("删除第0个元素：" + Arrays.toString(data));

    }

    /**
     * 堆排序
     *
     * @param data 数据集
     */
    public static void heapSort(int[] data) {
        int len = data.length;
        for (int i = len / 2 - 1; i >= 0; i--) {
            //从最后一个非叶子节点向前堆化，直到跟节点
//            maxHeap(data, i, len);
            minHeap(data, i, len);
        }
        //堆化后的结果
        System.out.println(Arrays.toString(data));
        //首尾交换，重新建堆
        for (int i = len - 1; i > 0; i--) {
            //交换首尾
            int temp = data[0];
            data[0] = data[i];
            data[i] = temp;
            //交换后需要从根节点进行堆化
            //从小到大排序
            //maxHeap(data, 0, i);
            //从大到小排序
            minHeap(data, 0, i);
        }
    }

    /**
     * 把一个数组变为一个堆
     *
     * @param data 数据集
     */
    public static void heap(int[] data) {
        int len = data.length;
        for (int i = len / 2 - 1; i >= 0; i--) {
            maxHeap(data, i, len);
        }
    }

    /**
     * 大根堆一次堆化过程 向下
     *
     * @param data  数据集
     * @param start 开始堆化下标
     * @param end   尾部
     */
    public static void maxHeap(int[] data, int start, int end) {
        //第最后一个非叶子节点
        int parent = start;
        //该节点的左孩子
        int leftSon = 2 * parent + 1;
        while (leftSon < end) {
            int temp = leftSon;
            //判断是否存在右孩子，并且右孩子的值是否比左孩子大
            if (leftSon + 1 < end && data[leftSon] < data[leftSon + 1]) {
                //保存左右孩子值大的节点下标
                temp = leftSon + 1;
            }
            //如果父节点比孩子节点都大，就不需要重新建堆
            if (data[parent] > data[temp]) {
                return;
            } else {
                //交换父节点和较大子节点的值
                int t = data[parent];
                data[parent] = data[temp];
                data[temp] = t;
                // 继续堆化
                parent = temp;
                leftSon = parent * 2 + 1;
            }
        }
    }

    /**
     * 小根堆一次堆化过程 向下
     *
     * @param data  数据集
     * @param start 开始堆化下标
     * @param end   尾部
     */
    public static void minHeap(int[] data, int start, int end) {
        int parent = start;
        int son = start * 2 + 1;
        while (son < end) {
            int temp = son;
            if (son + 1 < end && data[son] > data[son + 1]) {
                temp = son + 1;
            }

            if (data[temp] > data[parent]) {
                return;
            } else {
                data[temp] = data[temp] ^ data[parent];
                data[parent] = data[temp] ^ data[parent];
                data[temp] = data[temp] ^ data[parent];
                parent = temp;
                son = parent * 2 + 1;
            }
        }
    }

    /**
     * 大根堆一次堆化过程,递归方式 向下
     *
     * @param data  数据集
     * @param start 开始堆化下标
     * @param end   尾部
     */
    public static void maxHeapRecursion(int[] data, int start, int end) {
        int parent = start;
        int son = start * 2 + 1;
        if (son < end) {
            int temp = son;
            if (son + 1 < end && data[son] < data[son + 1]) {
                temp = son + 1;
            }

            if (data[temp] < data[parent]) {
                return;
            } else {
                data[temp] = data[temp] ^ data[parent];
                data[parent] = data[temp] ^ data[parent];
                data[temp] = data[temp] ^ data[parent];
                maxHeapRecursion(data, temp, end);
            }
        }
    }

    /**
     * 小根堆一次堆化过程 递归方式 向下
     *
     * @param data  数据集
     * @param start 开始堆化下标
     * @param end   尾部
     */
    public static void minHeapRecursion(int[] data, int start, int end) {
        int parent = start;
        int son = start * 2 + 1;
        if (son < end) {
            int temp = son;
            if (son + 1 < end && data[son] > data[son + 1]) {
                temp = son + 1;
            }

            if (data[temp] > data[parent]) {
                return;
            } else {
                data[temp] = data[temp] ^ data[parent];
                data[parent] = data[temp] ^ data[parent];
                data[temp] = data[temp] ^ data[parent];
                //开始下一个节点
                minHeapRecursion(data, temp, end);
            }
        }
    }

    /**
     * 大根堆删除
     *
     * @param data  数据集
     * @param index 删除的下标
     * @return 返回新的数据集
     */
    public static int[] deleteElement(int[] data, int index) {
        //如果为空返回空集合
        if (data.length == 0) {
            System.out.println("集合为空");
            return data;
        }
        int len = data.length;
        data[index] = data[index] ^ data[len - 1];
        data[len - 1] = data[index] ^ data[len - 1];
        data[index] = data[index] ^ data[len - 1];
        maxHeap(data, 0, len - 1);
        int[] temp = new int[len - 1];
        for (int i = 0; i < len - 1; i++) {
            temp[i] = data[i];
        }
        return temp;
    }

    /**
     * 大根堆插入一个数字
     *
     * @param data  数据集
     * @param value 插入的值
     * @return 返回一个新的数据集
     */
    public static int[] insertElement(int[] data, int value) {
        int[] temp = new int[data.length + 1];
        for (int i = 0; i < temp.length - 1; i++) {
            temp[i] = data[i];
        }
        temp[temp.length - 1] = value;
        upHeap(temp, temp.length - 1);
        return temp;
    }

    /**
     * 向上堆化
     *
     * @param data  数据集
     * @param start 开始的下标
     */
    public static void upHeap(int[] data, int start) {
        int son = start;//子节点
        int parent = (son - 1) / 2;//父节点
        while (parent > 0) {
            if (data[parent] > data[son]) {//如果父节点大于子节点，堆化完成
                return;
            } else {
                //交换父子节点的值
                data[parent] = data[parent] ^ data[son];
                data[son] = data[parent] ^ data[son];
                data[parent] = data[parent] ^ data[son];
                //继续堆化，这里可以改为递归
                son = parent;
                parent = (son - 1) / 2;
            }
        }
    }

}

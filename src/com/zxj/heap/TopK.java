package com.zxj.heap;

import java.io.*;
import java.util.Arrays;

/**
 * 求解topK，每次循环，先追加数据到文件中，然后读取文件，来模拟动态数据
 * @author littleboy
 */
public class TopK {
    public static final int K = 10;

    /**
     * 计数器，要求有多少个数
     */
    public static int count = 0;
    /**
     * 每一次一个文件追加多少个数据
     */
    public static int apppedNum = 1000000;
    /**
     * 文件的数量
     */
    public static int fileNum = 10;

    /**
     * 存放数字的文件夹
     */
    public static String path = "src/com/zxj/file/";

    /**
     * allnumber
     */
    public static int allnumber = 99999999;

    public static void main(String[] args) {
        //获取开始时间
        long startTime = System.currentTimeMillis();
        //top k的数组
        int[] topKNums = new int[K];
        try {
            for (int i = 1; i <= fileNum; i++) {
                //如果之前创建了文件，先删除重新创建
                String fileName = i + ".txt";
                File file = new File(path + fileName);
                if (file.exists() && file.isFile()) {
                    file.delete();
                }
            }

            //大概循环多少次
            while (count <= allnumber) {
                for (int i = 1; i <= fileNum; i++) {
                    //给三个文件追加数据
                    String fileName = i + ".txt";
                    File file = new File(path + fileName);
                    if (file.createNewFile()) {
                        System.out.println("Create file successed");
                    }
                    StringBuffer appendNumString = new StringBuffer();
                    //拼接数字字符串
                    for (int j = 0; j < apppedNum; j++) {
                        appendNumString.append((count++) + " ");
                    }
                    //追加到文件
                    appendFile(path + fileName, appendNumString.toString());
                }
                for (int i = 1; i <= fileNum; i++) {
                    //读取三个文件的数据
                    String fileName = i + ".txt";
                    String numString = readFile(path + fileName);
                    String[] nums = numString.split(" ");
                    //求解topk
                    topK(nums, topKNums);
                }
                //打印每轮的topK
                System.out.println(Arrays.toString(topKNums));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }


        //获取结束时间
        long endTime = System.currentTimeMillis();
        //输出程序运行时间
        System.out.println("程序运行时间：" +((endTime - startTime)/1000.0/60.0) + "min");
    }

    /**
     * 追加内容
     *
     * @param fileName 文件名
     * @param content  追加的内容
     */
    public static void appendFile(String fileName, String content) {
        FileWriter writer = null;
        try {
            // 打开一个写文件器，构造函数中的第二个参数true表示以追加形式写文件
            writer = new FileWriter(fileName, true);
            writer.write(content);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (writer != null) {
                    writer.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 求解topK
     *
     * @param arrs 读取一个文件的内容
     * @param data topK保存的数据
     */
    public static void topK(String[] arrs, int data[]) {
        for (int i = 0; i < arrs.length; i++) {
            try {
                int temp = Integer.parseInt(arrs[i]);
                if (data[0] >= temp) {
                    continue;
                } else {
                    data[0] = temp;
                    minHeap(data, 0, data.length);
                }
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }

        }
    }


    /**
     * 以字符为单位读取文件，常用于读文本，数字等类型的文件
     */
    public static String readFile(String fileName) {
        Reader reader = null;
        StringBuffer stringBuffer = new StringBuffer();
        try {
            // 一次读多个字符
            char[] tempchars = new char[30];
            int charread = 0;
            reader = new InputStreamReader(new FileInputStream(fileName));
            // 读入多个字符到字符数组中，charread为一次读取字符数
            while ((charread = reader.read(tempchars)) != -1) {
                if (charread == tempchars.length) {
                    stringBuffer.append(tempchars);
                } else {
                    stringBuffer.append(tempchars, 0, charread);
                }
            }

        } catch (Exception e1) {
            e1.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        }
        return stringBuffer.toString();
    }

    /**
     * 小根堆堆化
     *
     * @param data  数据源
     * @param start 开始
     * @param end   结束
     */
    public static void minHeap(int data[], int start, int end) {
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
}

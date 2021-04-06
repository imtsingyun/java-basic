package org.mindidea.datastructure_001数据结构基础.demo01_斐波那契数;

public class Main {

    /**
     * 使用递归
     *
     * @param n N
     * @return int
     */
    public static int fib1(int n) {
        if (n <= 1) {
            return n;
        }
        return fib1(n - 1) + fib1(n - 2);
    }

    /**
     * 使用循环
     *
     * @param n N
     * @return int
     */
    public static int fib2(int n) {
        if (n <= 1) {
            return n;
        }
        int first = 0;
        int second = 1;
        /*
            下标n：0 1 2 3 4 5 6 7  8
            数值v：0 1 1 2 3 5 8 13 21
            下标为 0 或 1 的时候需要计算 0 次
            下标为 2 时候需要计算 1 次
            下标为 3 时候需要计算 2 次
            下标为 n 时候需要计算 n-1 次 
         */
        for (int i = 0; i < n - 1; i++) {
            int sum = first + second;
            first = second;
            second = sum;
        }
        return second;
    }

    public static void main(String[] args) {
        System.out.println(fib1(46));
        System.out.println(fib2(46));
    }
}

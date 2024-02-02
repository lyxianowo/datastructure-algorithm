package com.lyxianowo.ds.list;

import java.util.Arrays;

/**
 * @author lyxianowo
 * @date 2024-02-02
 * 自己实现ArrayList
 */
public class MyArrayList {
    private int[] arr;
    private int capacity = 10; // 容量
    private int size = 0; // 当前数组的长度
    private final int EXTENDRATIO = 2; // 扩容因子

    public MyArrayList() {
        arr = new int[capacity];
    }

    /* 获取当前数组的长度 */
    public int size() {
        return this.size;
    }

    /* 获取当前数组的容量 */
    public int capacity() {
        return this.capacity;
    }

    /* 访问数组元素 */
    public int get(int index) {
        checkIndex(index);
        return arr[index];
    }

    /* 更新数组元素 */
    public void set(int index, int num) {
        checkIndex(index);
        arr[index] = num;
    }

    /* 尾部添加元素 */
    public void add(int num) {
        ensureCapacity();
        arr[size] = num;
        size++;
    }

    /* 中间添加元素 */
    public void add(int index, int num) {
        checkIndex(index);
        ensureCapacity();
        for (int i = size - 1; i >= index; i--) {
            arr[i + 1] = arr[i];
        }
        arr[index] = num;
        size++;
    }

    /* 删除元素 */
    public void remove(int index) {
        checkIndex(index);
        int num = arr[index];
        for (int i = index; i < size - 1; i++) {
            arr[i] = arr[i + 1];
        }
        size--;
    }

    /* 确保容量足够 */
    private void ensureCapacity() {
        if (size >= capacity()) extendCapacity();
    }
    /* 数组扩容 */
    private void extendCapacity() {
        // 新建一个长度为原数组 extendRatio 倍的新数组，并将原数组复制到新数组
        arr = Arrays.copyOf(arr, capacity() * EXTENDRATIO);
        // 更新容量
        capacity = arr.length;
    }

    private void checkIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("索引越界");
        }
    }
    public int[] toArray() {
        int size = this.size();
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = get(i);
        }
        return arr;
    }

    public static void main(String[] args) {
        /* 初始化列表 */
        MyArrayList arryList = new MyArrayList();
        /* 在尾部添加元素 */
        arryList.add(1);
        arryList.add(3);
        arryList.add(2);
        arryList.add(5);
        arryList.add(4);
        System.out.println("列表 arryList = " + Arrays.toString(arryList.toArray()) +
                " ，容量 = " + arryList.capacity() + " ，长度 = " + arryList.size());

        /* 在中间插入元素 */
        arryList.add(3, 6);
        System.out.println("在索引 3 处插入数字 6 ，得到 arryList = " + Arrays.toString(arryList.toArray()));

        /* 删除元素 */
        arryList.remove(3);
        System.out.println("删除索引 3 处的元素，得到 arryList = " + Arrays.toString(arryList.toArray()));

        /* 访问元素 */
        int num = arryList.get(1);
        System.out.println("访问索引 1 处的元素，得到 num = " + num);

        /* 更新元素 */
        arryList.set(1, 0);
        System.out.println("将索引 1 处的元素更新为 0 ，得到 arryList = " + Arrays.toString(arryList.toArray()));

        /* 测试扩容机制 */
        for (int i = 0; i < 10; i++) {
            // 在 i = 5 时，列表长度将超出列表容量，此时触发扩容机制
            arryList.add(i);
        }
        System.out.println("扩容后的列表 arryList = " + Arrays.toString(arryList.toArray()) +
                " ，容量 = " + arryList.capacity() + " ，长度 = " + arryList.size());
    }
}

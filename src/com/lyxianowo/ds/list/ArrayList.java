package com.lyxianowo.ds.list;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

/**
 * @author lyxianowo
 * @date 2024-02-02
 */
public class ArrayList {

    /* 初始化数组 */
    int[] nums = {1, 2, 3, 4, 5, 6};
    int[] arr = new int[6];

    /* 随机访问数组中的元素 */
    static int randomAccess(int[] nums) {
        // 在区间 [0, nums.length) 中随机抽取一个数字
        int index = ThreadLocalRandom.current().nextInt(0, nums.length);
        // 获取元素
        int num = nums[index];
        return num;
    }

    /* 在数组中的 index 位置上插入元素 num */
    static void insert(int[] nums, int num, int index) {
        // 将索引为 index 以及之后的元素全部后移一位
        for (int i = nums.length - 1; i > index; i--) {
            nums[i] = nums[i - 1];
        }
        nums[index] = num;
    }

    /* 在数组中的 index 位置上删除元素 */
    static void remove(int[] nums, int index) {
        // 索引 index 之后的元素都往前移一位
        for (int i = index; i < nums.length - 1; i++) {
            nums[i] = nums[i + 1];
        }
    }

    /* 遍历数组 */
    static void traverse(int[] nums) {
        int count = 0;
        System.out.println("普通 for 遍历");
        for (int i = 0; i < nums.length; i++) {
            count += nums[i];
        }
        // or
        System.out.println("增强 for 遍历");
        for (int num : nums) {
            count += num;
        }
    }

    /* 查找数组的元素 */
    static int get(int[] nums, int target) {
        for (int num : nums) {
            if (num == target) return num;
        }
        // not found
        return -1;
    }

    /* 扩容数组 */
    static int[] extend(int[] nums, int enlarge) {
        int[] newArr = new int[nums.length + enlarge];
        // nums数组中元素复制到新数组中
        for (int i = 0; i < nums.length; i++) {
            newArr[i] = nums[i];
        }
        return newArr;
    }

    public static void main(String[] args) {
        /* 初始化数组 */
        int[] nums = { 1, 3, 2, 5, 4 };
        System.out.println("数组 nums = " + Arrays.toString(nums));

        /* 随机访问 */
        int randomNum = randomAccess(nums);
        System.out.println("在 nums 中获取随机元素 " + randomNum);

        /* 长度扩展 */
        nums = extend(nums, 3);
        System.out.println("将数组长度扩展至 8 ，得到 nums = " + Arrays.toString(nums));

        /* 插入元素 */
        insert(nums, 6, 3);
        System.out.println("在索引 3 处插入数字 6 ，得到 nums = " + Arrays.toString(nums));

        /* 删除元素 */
        remove(nums, 2);
        System.out.println("删除索引 2 处的元素，得到 nums = " + Arrays.toString(nums));

        /* 遍历数组 */
        traverse(nums);

        /* 查找元素 */
        int index = get(nums, 3);
        System.out.println("在 nums 中查找元素 3 ，得到索引 = " + index);
    }
}

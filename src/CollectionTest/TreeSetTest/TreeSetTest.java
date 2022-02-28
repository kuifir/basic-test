package CollectionTest.TreeSetTest;

import java.util.TreeSet;

/**
 * Package: CollectionTest.TreeSetTest
 * <p>
 * Description： TreeSet采用红黑树的数据结构来存储集合元素。默认采用自然排序
 * <p>
 * Author: baci
 * <p>
 * Date: Created in 2021/8/18 23:05
 * <p>
 * Version: 0.0.1
 */
public class TreeSetTest {
    public static void main(String[] args) {
        TreeSet<Integer> nums = new TreeSet<>();
        nums.add(5);
        nums.add(2);
        nums.add(10);
        nums.add(-9);
        // 输出集合元素，看到集合元素已经处于排序状态
        System.out.println(nums);
        // 输出集合里的第一个元素
        System.out.println(nums.first());
        // 输出集合里的最后一个元素
        System.out.println(nums.last());
        // 返回小于10的子集，不包含10
        System.out.println(nums.headSet(10));
        // 返回大于2的子集，包含2
        System.out.println(nums.tailSet(2));
        // 返回大于等于2、小于10的子集
        System.out.println(nums.subSet(2,10));
        System.out.println(nums.comparator());
    }
}

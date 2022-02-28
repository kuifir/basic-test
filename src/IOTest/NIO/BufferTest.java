package IOTest.NIO;

import java.nio.CharBuffer;

/**
 * Package: PACKAGE_NAME
 * <p>
 * Description： Buffer的常规操作
 * <p>
 * Author: baci
 * <p>
 * Date: Created in 2020/7/29 11:45
 * <p>
 * Version: 0.0.1
 */
public class BufferTest {
    public static void main(String[] args) {
        // 创建buffer
        CharBuffer buffer=CharBuffer.allocate(8);
        System.out.println("capacity======="+buffer.capacity());
        System.out.println("limit========"+buffer.limit());
        System.out.println("position=========="+buffer.position());
        // 放入元素
        buffer.put("d");
        buffer.put("x");
        buffer.put("v");
        System.out.println("加入三个元素后position=========="+buffer.position());
        // 调用flip()方法，该方法将limit设置为position所在的位置并将position设为0.
        // 使得Buffer的读写指针又移到了开始位置，
        // 为输出做好准备。
        buffer.flip();
        System.out.println("flip()后position=========="+buffer.position());
        System.out.println("flip()后limit========"+buffer.limit());

        System.out.println("取出一个元素后position==========" +buffer.get()+buffer.position());
        System.out.println("取出一个元素后limit=========="+buffer.limit());
        // 调用clear()方法
        // clear()不是清空Buffer数据，仅仅将position置为0，将limit置为capacity
        // 这样再次向Buffer中装入数据做好准备
        buffer.clear();
        System.out.println("clear()后position=========="+buffer.position());
        System.out.println("clear()后limit=========="+buffer.limit());
        System.out.println("clear()后缓存区内容没有清除=========="+buffer.get(2));
        System.out.println("执行绝对读取后=========="+buffer.position());



    }
}

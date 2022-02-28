package enumTest;

/**
 * Package: enumTest
 * <p>
 * Description： TODO
 * <p>
 * Author: baci
 * <p>
 * Date: Created in 2021/8/10 15:21
 * <p>
 * Version: 0.0.1
 */
public class EnumTest {
    public static void main(String[] args) {
        System.out.println(SeasonEnum.SPRING.compareTo(SeasonEnum.SPRING));
        System.out.println(SeasonEnum.SPRING.name());
        System.out.println(SeasonEnum.SPRING.ordinal());
        for (SeasonEnum s : SeasonEnum.values()) {
            System.out.println(s);
        }
        new EnumTest().judge(SeasonEnum.SPRING);
    }
    public void judge(SeasonEnum s){
        switch (s){
            case SPRING: System.out.println("春暖花开，正好踏青");break;
            case SUMMER: System.out.println("夏日炎炎，适合游泳");break;
            case FALL: System.out.println("秋高气爽，进补及时");break;
            case WINTER: System.out.println("冬日雪飘，围炉赏雪");break;
        }
    }
}

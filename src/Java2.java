public class Java2 {
    static class Person {
        int age = 100;

    }

    public static void main(String[] args) {
        Java2 j = new Java2();
        Person person = new Person();
        j.test1(person);
        int a = person.age;
        int  d= (int)(Math.random()*10);

        System.out.println(a);//200
        System.out.println(d);
        //对象储存的是地址，如果地址的内容改变，对象地址没变，地址的内容变了

    }

    public void test1(Person person) {
       // person = new Person();
        person.age = 200;
    }
}

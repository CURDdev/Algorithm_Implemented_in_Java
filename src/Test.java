//public class Test {
//    public static void main(String[] args){
//        System.out.println(B.c);
//    }
//}
//class A{
//    public static String c = "C";
//    static {
//        System.out.println("A");
//    }
//}
//class B extends A{
//    static {
//        System.out.println("B");
//    }
//}
//public class Test{
//    static int count = 2;
//    static {
//        name = "Java";
//    }
//    static String name = "dsdsds";
//}

class Creature{
    {
        System.out.println("Creature 的非静态初始化块");
    }
    public Creature(){
        System.out.println("Creature 无参数的构造器");
    }
    public Creature(String name){
        this();
        System.out.println("Creature 的带有name参数的构造器" + name);
    }
}

class Animal extends Creature{
    {
        System.out.println("Animal 的非静态初始化块");
    }
    public Animal(String name){
        super(name);
        System.out.println("Animal 带有参数的构造器，name参数的值为:" + name);
    }
    public Animal(String name, int age){
        this(name);
        System.out.println("Animal带有两个参数的构造器，其age为：" + age);
    }
}
class Wolf extends Animal{
    {
        System.out.println("Wolf 的非静态初始化");
    }
    public Wolf(){
        super("灰太狼",3);
        System.out.println("Wolf 的无参数构造器");
    }
    public Wolf(double weight){
        this();
        System.out.println("Wolf 的带weight参数的构造器，weight 参数为：" + weight);
    }
}
public class Test{
    public static void main(String[] args){
        new Wolf(5.6);
    }
}
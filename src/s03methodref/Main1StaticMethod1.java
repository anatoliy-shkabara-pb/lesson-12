package s03methodref;

public class Main1StaticMethod1 {

    interface Sayable{
        void say();
    }

    public static void saySomething(){
        System.out.println("Hello, this is static method.");
    }


    public static void main(String[] args) {
        // Referring static method
        Sayable sayable = Main1StaticMethod1::saySomething;
        // Calling interface method
        sayable.say();
    }
}

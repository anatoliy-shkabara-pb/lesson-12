package s03methodref;

public class Main2InstanceMethod {

    interface Sayable{
        void say();
    }


    public void saySomething(){
        System.out.println("Hello, this is non-static method.");
    }

    public static void main(String[] args) {
        Main2InstanceMethod methodReference = new Main2InstanceMethod(); // Creating object
        // Referring non-static method using reference
        Sayable sayable = methodReference::saySomething;
        // Calling interface method
        sayable.say();
        // Referring non-static method using anonymous object
        Sayable sayable2 = new Main2InstanceMethod()::saySomething; // You can use anonymous object also
        // Calling interface method
        sayable2.say();
    }
}

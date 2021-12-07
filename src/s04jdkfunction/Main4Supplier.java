package s04jdkfunction;

import java.util.function.Supplier;

public class Main4Supplier {
    public static void main(String[] args) {
        String t = "One";
        Supplier<String> supplierStr = () -> t.toUpperCase();
        System.out.println(supplierStr.get());

        Supplier<Integer> rand10 = () -> (int) (Math.random() * 10);
        System.out.println(rand10.get());
        System.out.println(rand10.get());
    }
}

package s02lambdas;

public class Main3 {

    @FunctionalInterface
    public interface Printable {
        void print(String s);
    }

    public static void main(String[] args) {
        doPrint(
                (s) -> {
                    System.out.println("length of '" + s + "' = " + s.length());
                    String rev = new StringBuilder(s).reverse().toString();
                    System.out.println("reverse: " + rev);
                }
        );
    }

    public static void doPrint(Printable printable) {
        System.out.println("start doPrintable");
        printable.print("Two words");
        System.out.println("exit doPrintable");
    }
}

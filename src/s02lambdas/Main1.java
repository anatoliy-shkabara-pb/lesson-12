package s02lambdas;

public class Main1 {

    @FunctionalInterface
    interface Operation {
        int execute(int x, int y);
    }

    public static void main(String[] args) {
        Operation add = new Operation() {
            @Override
            public int execute(int x, int y) {
                return x + y;
            }
        };

        Operation sub = (x, y) -> x - y;
        Operation div = (x, y) -> x / y;
        Operation mul = (x, y) -> x * y;

        int resAdd = add.execute(12, 4);
        int resSub = sub.execute(12, 4);
        int resDiv = div.execute(12, 4);
        int resMul = mul.execute(12, 4);

        System.out.println("add: " + resAdd);
        System.out.println("sub: " + resSub);
        System.out.println("div: " + resDiv);
        System.out.println("mul: " + resMul);
    }
}

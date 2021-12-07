package s03methodref;

public class Main3Constructor {

    static class Message {
        Message(String msg) {
            System.out.print(msg);
        }
    }

    interface Messageable {
        Message getMessage(String msg);
    }

    public static void main(String[] args) {
        Messageable hello = Message::new;
        hello.getMessage("Hello");
    }
}

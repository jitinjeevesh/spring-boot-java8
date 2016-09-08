package sample;

@FunctionalInterface
public interface Message {

    String display(String s);

    default String show(String s) {
        System.out.println(s);
        return s;
    }
}

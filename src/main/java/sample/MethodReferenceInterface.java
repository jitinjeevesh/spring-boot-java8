package sample;

@FunctionalInterface
public interface MethodReferenceInterface {

    String display(String s);

    default String show(String s) {
        System.out.println(s + "Inside MethodReferenceInterface");
        return s;
    }

    static String show1(String s) {
        System.out.println(s + "Inside MethodReferenceInterface static");
        return s;
    }
}

package sample;

@FunctionalInterface
public interface Operation {

    //Only one method inside the interface.
    int operate(int a, int b);
}

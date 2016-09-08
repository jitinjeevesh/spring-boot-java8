package sample;

public class DefaultMethodImpl implements MethodReferenceInterface, Message {
    @Override
    public String display(String s) {
        return null;
    }

    @Override
    public String show(String s) {
        return MethodReferenceInterface.super.show(s);
    }
}

package sample;

public class Util {

    private String disp;

    public static String display(String s) {
        System.out.println(s);
        return s;
    }

    public String show(String s) {
        System.out.println(s);
        return s;
    }

    Util() {
    }

    Util(String s) {
        this.disp = s;
    }

    public String getDisp() {
        return disp;
    }

    public void setDisp(String disp) {
        this.disp = disp;
    }
}

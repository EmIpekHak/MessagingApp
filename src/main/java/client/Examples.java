package client;

public class Examples {

    public static void main(String[] args) {
        MyInt x = new MyInt(3);
        inc(x);
        System.out.println(x.getValue());

    }

    public static void inc(MyInt x){
        x.setValue(x.getValue()+1);
        x = null;
    }
}

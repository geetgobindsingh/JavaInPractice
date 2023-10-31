package accessmodifier;

public class Nested {

    private int a;
    private static  int b;
    int c;
    static int d;
    protected int e;
    protected static int f;
    public int g;
    public static int h;

    class NestA {
        public void method() {
            a = 1; // can access private
            c = 1; // can access default
            e = 1; // can access protected
            g = 1; // can access public
        }
    }

    static class NestB {
        public void method() {
//            a = 1; // can not access private
//            c = 1; // can not access default
//            e = 1; // can not access protected
//            g = 1; // can not access public
            b = 1;// can access private
            d = 1; // can access default
            f = 1; // can access protected
            h = 1; // can access public
        }
    }
}

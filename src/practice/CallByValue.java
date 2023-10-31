package practice;

public class CallByValue {
    public static void main(String[] args) {
        int a = 10;
        boolean[] ar = new boolean[1];
        ar[0] = false;
        A obj = new A();
        replace(a, obj, ar);
        System.out.println(a);
        System.out.println(obj.a);
        System.out.println(ar[0]);
        update(a, obj, ar);
        System.out.println(System.identityHashCode(a));
        System.out.println(a);
        System.out.println(obj.a);
        System.out.println(ar[0]);
    }

    private static void update(int a, A obj, boolean[] ar) {
        a = 20;
        obj.a = 20;
        ar[0] = true;
    }

    private static void replace(int a, A obj, boolean[] ar) {
        a = 20;
        obj = new A();
        obj.a = 20;
        ar = new boolean[1];
        ar[0] = true;
    }

    static class A {
        public int a = 10;
    }
}

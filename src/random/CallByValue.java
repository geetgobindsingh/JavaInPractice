package random;

public class CallByValue {
    static class A {
        int a;
    }
    public static void main(String[] args) {
        A objA = new A();
        System.out.println(objA.a);
        updateA(objA);
        System.out.println(objA.a);
        updateAA(objA);
        System.out.println(objA.a);
    }

    private static void updateA(A objA) {
        objA.a = 1;
    }

    private static void updateAA(A objA) {
        objA = new A();
        objA.a = 2;
    }
}

package random;

public class StaticCheck {
    static {
        System.out.println("Hello from Static block");
    }

    public StaticCheck() {
        System.out.println("Hello from Constructor");
    }

    public static void main(String[] args) {
        helloFromStaticMethod();
        System.out.println("Hello from main before");
        new StaticCheck();
        System.out.println("Hello from main after");
        helloFromStaticMethod();
    }

    public static void helloFromStaticMethod() {
        System.out.println("Hello from Static method");
    }
}

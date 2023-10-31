package random;

public class InheritanceTest {

    public static void main(String[] args) {
        B ob = new B();
        ob.hello();
        ob.holla();
    }


    static class A {
        public /*final*/ void holla() {
            System.out.println("Holla");
        }
    }

    static class B extends A {
        public void hello() {
            System.out.println("Hello");
        }

        @Override
        public void holla() {
            super.holla();
//            System.out.println("holla holla");
        }
    }
}

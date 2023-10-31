package serialisation;

public class C extends A {
    private static final long serialVersionUID = 1234567L;

    int a = 1;
    int b = 1;

    @Override
    public String toString() {
        return "C{" +
                "a=" + a +
                ", b=" + b +
                ", a.a='" + super.a + '\'' +
                ", a.b='" + super.b + '\'' +
                '}';
    }
}

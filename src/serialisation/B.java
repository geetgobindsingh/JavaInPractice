package serialisation;

public class B extends A {
    int a = 1;
    int b = 1;
    @Override
    public String toString() {
        return "B{" +
                "a=" + a +
                ", b=" + b +
                ", a.a='" + super.a + '\'' +
                ", a.b='" + super.b + '\'' +
                '}';
    }
}

package serialisation;

import java.io.Serializable;
 class A implements Serializable {
    public static long serialVersionUID = 1234122567L;

    public String a = "";
    public String b = "";

    @Override
    public String toString() {
        return "A{" +
                "a='" + a + '\'' +
                ", b='" + b + '\'' +
                '}';
    }
}

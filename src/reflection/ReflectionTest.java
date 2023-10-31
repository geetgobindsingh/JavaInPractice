package reflection;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ReflectionTest {

    private int a;
    private static  int b;
    int c;
    static int d;
    protected int e;
    protected static int f;
    public int g;
    public static int h;

    public void simpleMethodA() {}
    public static void simpleMethodB() {}
    private void simpleMethodC() {}
    private static void simpleMethodD() {}
    protected void simpleMethodE() {}
    protected static void simpleMethodF() {}
    void simpleMethodG() {}
    static void simpleMethodH() {}

    public static void main(String[] args) {
        Method[] methods = ReflectionTest.class.getMethods();

        for(Method method : methods){
            System.out.println("method = " + method.getName() + " " + method.getModifiers());
        }

        Method[] declaredMethods = ReflectionTest.class.getDeclaredMethods();

        for(Method method : declaredMethods){
            System.out.println("declared method = " + method.getName());
        }

        Field[] fields   = ReflectionTest.class.getFields();

        for (Field field : fields) {
            System.out.println("field = " + field.getName());
        }

        Field[] declaredFields   = ReflectionTest.class.getDeclaredFields();

        for (Field field : declaredFields) {
            System.out.println("declared field = " + field.getName());
        }
    }
}

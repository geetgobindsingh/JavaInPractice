package random.base;

public abstract class BaseClass {
    int property = 0;
    public static void print(BaseClass baseClass) {
//        if (baseClass instanceof ChildOne) {
//            System.out.println("Property: " + ((ChildOne) baseClass).onlyOneProperty);
//        } else {
            System.out.println(((ChildTwo) baseClass).prop);
//        }
    }
}

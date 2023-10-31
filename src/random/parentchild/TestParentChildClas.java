package random.parentchild;

public class TestParentChildClas {
    public static void main(String[] args) {
//        ChildClas childClas = new ChildClas();
//        ParentClas parentClas = (ParentClas) childClas;
//        parentClas.printMe();

        TestParentChildClas obj = new TestParentChildClas();
        TestBool testBool = new TestBool();
        testBool.oldValue = false;
        testBool.oldValueInt = 0;
        testBool.oldValueString = "kapil dev";
        obj.updateBool(testBool.oldValue);
//        obj.updateInt(testBool.oldValueInt);
//        obj.updateString(testBool.oldValueString);
        System.out.println(testBool.oldValue);
//        System.out.println(testBool.oldValueInt);
//        System.out.println(testBool.oldValueString);
        Double doubsle = new Double(2.0);
        double dd = 2.0;
        doubsle.intValue();
    }

    public void updateBool(Boolean oldValue) {
        oldValue = true;
    }

    public void updateInt(int oldValueInt) {
        oldValueInt = 1;
    }

    public void updateString(String oldValueString) {
        oldValueString = "Kapil Kant";
    }


    public void updateTestBool(TestBool testBool) {
        testBool.oldValue = true;
        testBool.oldValueInt = 1;
    }

    static class TestBool {
        Boolean oldValue;
        int oldValueInt;
        String oldValueString;
    }
}

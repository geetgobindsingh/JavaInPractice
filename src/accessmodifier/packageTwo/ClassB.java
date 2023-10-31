package accessmodifier.packageTwo;

import accessmodifier.packageOne.ClassC;

public class ClassB {
    public static void main(String[] args) {
        //ClassA classA = new ClassA();
        ClassC.h = 1;
        System.out.println("h = " + ClassC.h);
        ClassC classC = new ClassC();
        classC.g = 1;
        classC.h = 2; // yes can modify
        System.out.println("h = " + ClassC.h);
    }
}

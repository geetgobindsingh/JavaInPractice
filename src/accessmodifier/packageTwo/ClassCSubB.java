package accessmodifier.packageTwo;

import accessmodifier.packageOne.ClassC;

public class ClassCSubB extends ClassC {
    public static void main(String[] args) {

    }

    public void nonStaticMethod() {
//        super.a = 1; // Private
//        super.c = 1; // default
        super.e = 1; // protected
        super.g = 1; // public
    }
}

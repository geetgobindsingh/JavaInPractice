package accessmodifier.packageOne;

public class ClassCSubA extends ClassC {
    public static void main(String[] args) {

    }
    public void nonStatocMethod() {
//        super.a = 1; // Private
        super.c = 1; // default
        super.e = 1; // protected
        super.g = 1; // public
    }
}

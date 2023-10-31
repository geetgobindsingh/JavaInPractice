package random;

/**
 * Created by geetgobindsingh on 12/07/17.
 */
public class NPEClass {
    public static void main(String[] args) {
        NPE object = null;
        try {
            System.out.print(object.npeIndex);
        }
        catch(Exception ex) {
            System.out.print("Catched NPE");
        }
    }

    class NPE {
        String npeIndex;
    }
}

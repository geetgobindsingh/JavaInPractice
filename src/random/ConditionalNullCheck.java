package random;

/**
 * Created by geetgobindsingh on 11/10/17.
 */
public class ConditionalNullCheck {

    public static void main(String[] args) {
        Block block = new Block();
        if(block == null || block.integ == null) {
            if(block == null) {
                System.out.print("Object not created");
            } else if(block.integ == null) {
                System.out.print("Object Integ not created");
            }
        }
    }

    static class Block {
        public Integer integ;
    }
}

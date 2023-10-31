package daa.recursion;

/**
 * Created by geetgobindsingh on 13/11/17.
 */
public class TOH {



    public static void main(String[] args) {
        TOH object = new TOH();

        object.towerOfHanoi(3, 'a', 'b', 'c');
    }


    private void towerOfHanoi(int pegsCount, char fromTower, char auxTower, char toTower) {
        if (pegsCount == 1) {
            System.out.println("Moved peg from " + fromTower + " to " + toTower);
            return;
        }

        towerOfHanoi(pegsCount -1, fromTower, toTower, auxTower);

        System.out.println("Step 1 completed, Moved n-1 pegs from Source("+fromTower+") to Auxiliary tower("+auxTower+")");

        towerOfHanoi(pegsCount -1, auxTower, fromTower, toTower);

        System.out.println("Step 2 completed, Moved n-1 pegs from Auxiliary("+auxTower+") to Destination tower("+toTower+")");
    }
}

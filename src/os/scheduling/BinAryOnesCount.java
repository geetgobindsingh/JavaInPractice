package os.scheduling;

import java.util.ArrayList;
import java.util.List;

public class BinAryOnesCount {

    public static void main(String[] args) {

        int[] list = getOneBits(161);

        for (int j = 0; j < list.length; ++j) {
                System.out.println(list[j]);
            }

    }

    static int[] getOneBits(int value) {
        if (value > 1 && value < Math.pow(10, 9)) {

            String binary = String.valueOf(find(value));

            ArrayList<Integer> positionList = new ArrayList<>();

            for (int i = 0; i < binary.length(); ++i) {
                if (binary.charAt(i) == '1') {
                    positionList.add(i + 1);
                }
            }

            positionList.add(0, positionList.size());

            return (convertIntegers(positionList));
        } else {
            return new int[0];
        }
    }

    public static int[] convertIntegers(List<Integer> integers)
    {
        int[] ret = new int[integers.size()];
        for (int i=0; i < ret.length; i++)
        {
            ret[i] = integers.get(i).intValue();
        }
        return ret;
    }

    static int find(int decimal_number)
    {
        if (decimal_number == 0)
            return 0;

        else

            return (decimal_number % 2 +
                    10 * find(decimal_number / 2));
    }

}

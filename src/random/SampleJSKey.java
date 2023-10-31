package random;

public class SampleJSKey {

    private static int i = 2;
    private static int j = 3;

    public static void main(String[] args) {
        System.out.println(getFlipKey("a"));
        System.out.println(getFlipKey("a.b"));
        System.out.println(getFlipKey("a.b.c"));
        System.out.println(getFlipKey("a[$i]"));
        System.out.println(getFlipKey("a[$i].b[1]"));
        System.out.println(getFlipKey("a[$i].z.b[1].c"));
        System.out.println(getFlipKey("a[$i].b[1].c"));
        System.out.println(getFlipKey("a[$i].b[$j].c[2]"));
        System.out.println(getFlipKey("a[$i].b[$j].c[2].d[0]"));
        System.out.println(getFlipKey("a[0].b[1].c[2].d[3]"));
    }

    private static String getFlipKey(String input) {
        String result = "";

        String[] sr = input.split("");

        for (int index = 0; index < sr.length; ++index) {
            if (sr[index].equalsIgnoreCase("[")) {
                if ((index + 1) < input.length() && sr[index + 1].equalsIgnoreCase("$")) {
                    sr[index] = "";
                    sr[index + 1] = "";
                    if (sr[index + 2].equalsIgnoreCase("i")) {
                        sr[index + 2] = "#" + String.valueOf(i);
                    } else if (sr[index + 2].equalsIgnoreCase("j")) {
                        sr[index + 2] = "#" + String.valueOf(j);
                    }
                } else {
                    sr[index] = "#";
                }
            } else if (input.charAt(index) == ']') {
                sr[index] = "";
            }
        }

        for (int index = 0; index < sr.length; ++index) {
            result = result + sr[index];
        }

        return result;
    }
}

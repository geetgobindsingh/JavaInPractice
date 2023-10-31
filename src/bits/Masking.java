package bits;

public class Masking {
    private static int CREATE = 0x1000;
    private static int READ = 0x0100;
    private static int UPDATE = 0x0010;
    private static int DELETE = 0x0001;

    public static void main(String[] args) {
        int a = Integer.decode("0x1110");
        System.out.println(hasCreatePermission(a));
        System.out.println(hasReadPermission(a));
        System.out.println(hasUpdatePermission(a));
        System.out.println(hasDeletePermission(a));
    }


    private static boolean hasCreatePermission(int permissionRequested) {
        return hasPermission(permissionRequested, CREATE);
    }

    private static boolean hasReadPermission(int permissionRequested) {
        return hasPermission(permissionRequested, READ);
    }

    private static boolean hasUpdatePermission(int permissionRequested) {
        return hasPermission(permissionRequested, UPDATE);
    }

    private static boolean hasDeletePermission(int permissionRequested) {
        return hasPermission(permissionRequested, DELETE);
    }

    private static boolean hasPermission(int permissionRequested, int permission) {
        return (permissionRequested & permission) > 0;
    }
}

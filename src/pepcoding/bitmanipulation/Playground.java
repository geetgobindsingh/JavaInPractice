package pepcoding.bitmanipulation;

public class Playground {
    public static void main(String[] args) {
        int i = 1;
        System.out.println("1>>0 :" + (1>>0));
        System.out.println("1>>1 :" + (1>>1));
        System.out.println("1>>2 :" + (1>>2));
        System.out.println("1<<1 :" + (1<<1));
        System.out.println("1<<2 :" + (1<<2));
        System.out.println();

        byte b = 0b00;
        System.out.println("b:" + Integer.toBinaryString(b) + "/" + b);
        b = (byte) (b + 0b01);
        System.out.println("b:" + Integer.toBinaryString(b) + "/" + b);
        b = (byte) (b + 0b01);
        System.out.println("b:" + Integer.toBinaryString(b) + "/" + b);
        b = (byte) (b + 0b01);
        System.out.println("b:" + Integer.toBinaryString(b) + "/" + b);
        b = (byte) (b + 0b01);
        System.out.println("b:" + Integer.toBinaryString(b) + "/" + b);
        System.out.println();

        System.out.println("byte add 1 to max byte value");
        System.out.println((byte)(Byte.MAX_VALUE));
        System.out.println((byte)(Byte.MAX_VALUE + 1));
        System.out.println();

        byte bits = 0b10100;
        System.out.println("10100 | 00100: (ON) " + Integer.toBinaryString(bits | 0b00100));
        System.out.println("10100 & 00100: (OFF) " + Integer.toBinaryString(bits & 0b11011));
        System.out.println("10100 ^ 00100: (Toggle) " + Integer.toBinaryString(bits ^ 0b00100));
        System.out.println("10100 & 00100: (check) " + Integer.toBinaryString(bits & 0b00100));
        System.out.println("Right Most Set Bit " + Integer.toBinaryString(0b10100) + " : " + Integer.toBinaryString(bits & -bits));
    }
}

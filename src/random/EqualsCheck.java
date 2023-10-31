package random;

public class EqualsCheck {
    public static void main(String[] args) {
        Age age2 = new Age(2);
        Age age3 = new Age(3);
        Age age4 = new Age(2);
        if (age2 == age3) {
            System.out.println("age2 == age3");
        }
        if (age2 == age4) {
            System.out.println("age2 == age4");
        }
        if (age2.equals(age3)) {
            System.out.println("age2 == age3");
        }
        if (age2.equals(age4)) {
            System.out.println("age2 == age4");
        }
    }
}

class Age {
    int val = 0;
    public Age(int val) {
        this.val = val;
    }

    @Override
    public boolean equals(Object obj) {
        return ((Age)obj).val == this.val;
    }
}

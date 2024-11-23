package kodilla.com.exception.test;

public class SecondChallenge {

    public int power(int base, int power) throws Exception {
        if (base <= 0) {
            throw new Exception("Base cannot be negative or zero");
        } else if ( power <= 0) {
            throw new Exception("Power cannot be negative or zero");
        } else if (power == 1) {
            return base;
        }
        for (int i = 1; i < power; i++) {
            base = base * base;
        }
        return base;
    }
    public static void main(String[] args) {
        SecondChallenge secondChallenge = new SecondChallenge();
        try {
            System.out.println(secondChallenge.power(3, 3));
        } catch (Exception e) {
            System.out.println("Exception" + e);
        }
    }
}

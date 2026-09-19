class PasswordChecker {
    private final String password;

    public PasswordChecker(String password) {
        this.password = password;
    }

    public String getStrength() {

        if (password.length() < 6) {
            return "Weak";
        } 
        else if (password.length() <= 9) {
            return "Medium";
        } 
        else {
            return "Strong";
        }
    }
}

public class Problem3 {
    public static void main(String[] args) {

        PasswordChecker pc = new PasswordChecker("abcd");

        PasswordChecker pc2 = new PasswordChecker("abcdefghij");

        PasswordChecker pc3 = new PasswordChecker("abcdefgh");

        System.out.println("Password 1 strength: " + pc.getStrength());

        System.out.println("Password 2 strength: " + pc2.getStrength());

        System.out.println("Password 3 strength: " + pc3.getStrength());
    }
}
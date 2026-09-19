class Locker {
    private final int lockerNumber;
    private String combinationCode;

    public Locker(int lockerNumber, String combinationCode) {
        this.lockerNumber = lockerNumber;
        this.combinationCode = combinationCode;
    }

    public void changeCode(String currentCode, String newCode) {
        if (!combinationCode.equals(currentCode)) {
            System.out.println("Code change rejected");
            return;
        }

        combinationCode = newCode;
        System.out.println("Code changed successfully");
    }
}

public class M4 {
    public static void main(String[] args) {

        Locker l = new Locker(101, "1234");

        l.changeCode("1234", "5678");

        l.changeCode("0000", "9999");
    }
}
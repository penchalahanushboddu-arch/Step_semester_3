import java.util.Scanner;

abstract class Ticket {
    int count;
    static final double CONVENIENCE_FEE = 20.0;

    Ticket(int count) {
        this.count = count;
    }

    abstract double getPrice();

    double calculateAmount() {
        return count * (getPrice() + CONVENIENCE_FEE);
    }
}

class RegularTicket extends Ticket {
    RegularTicket(int count) {
        super(count);
    }

    double getPrice() {
        return 150;
    }
}

class PremiumTicket extends Ticket {
    PremiumTicket(int count) {
        super(count);
    }

    double getPrice() {
        return 250;
    }
}

class ReclinerTicket extends Ticket {
    ReclinerTicket(int count) {
        super(count);
    }

    double getPrice() {
        return 400;
    }
}

public class MovieTicketCounter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        Ticket[] tickets = new Ticket[n];
        String[] seats = new String[n];
        double total = 0;

        for (int i = 0; i < n; i++) {
            seats[i] = sc.next();
            int count = sc.nextInt();

            if (seats[i].equals("REGULAR")) {
                tickets[i] = new RegularTicket(count);
            } else if (seats[i].equals("PREMIUM")) {
                tickets[i] = new PremiumTicket(count);
            } else {
                tickets[i] = new ReclinerTicket(count);
            }
        }

        for (int i = 0; i < n; i++) {
            double amount = tickets[i].calculateAmount();
            System.out.printf("%s: %.2f%n", seats[i], amount);
            total += amount;
        }

        System.out.printf("Total: %.2f%n", total);
        sc.close();
    }
}
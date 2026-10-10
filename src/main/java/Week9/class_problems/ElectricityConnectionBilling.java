import java.util.Scanner;

abstract class ElectricityConnection {
    int units;

    ElectricityConnection(int units) {
        this.units = units;
    }

    abstract double calculateBill();
}

class Home extends ElectricityConnection {
    Home(int units) {
        super(units);
    }

    double calculateBill() {
        if (units <= 100) {
            return units * 5.0;
        }
        return 100 * 5.0 + (units - 100) * 7.0;
    }
}

class Shop extends ElectricityConnection {
    Shop(int units) {
        super(units);
    }

    double calculateBill() {
        return units * 8.0 + 100;
    }
}

class Factory extends ElectricityConnection {
    Factory(int units) {
        super(units);
    }

    double calculateBill() {
        return Math.max(units * 6.0, 1000.0);
    }
}

public class ElectricityConnectionBilling {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        ElectricityConnection[] connections = new ElectricityConnection[n];
        String[] types = new String[n];
        double total = 0;

        for (int i = 0; i < n; i++) {
            types[i] = sc.next();
            int units = sc.nextInt();

            if (types[i].equals("HOME")) {
                connections[i] = new Home(units);
            } else if (types[i].equals("SHOP")) {
                connections[i] = new Shop(units);
            } else {
                connections[i] = new Factory(units);
            }
        }

        for (int i = 0; i < n; i++) {
            double bill = connections[i].calculateBill();
            System.out.printf("%s: %.2f%n", types[i], bill);
            total += bill;
        }

        System.out.printf("Total: %.2f%n", total);
        sc.close();
    }
}
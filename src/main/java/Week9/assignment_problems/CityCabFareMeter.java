import java.util.Scanner;

interface NightService {
    double calculateNightFare(double fare);
}

abstract class Cab {
    double distance;
    static final double MINIMUM_FARE = 100;

    Cab(double distance) {
        this.distance = distance;
    }

    abstract double calculateBaseFare();

    double calculateFare() {
        return Math.max(calculateBaseFare(), MINIMUM_FARE);
    }
}

class Mini extends Cab {
    Mini(double distance) {
        super(distance);
    }

    double calculateBaseFare() {
        return distance * 10;
    }
}

class Sedan extends Cab implements NightService {
    Sedan(double distance) {
        super(distance);
    }

    double calculateBaseFare() {
        return distance * 14;
    }

    public double calculateNightFare(double fare) {
        return fare * 1.20;
    }
}

class SUV extends Cab implements NightService {
    SUV(double distance) {
        super(distance);
    }

    double calculateBaseFare() {
        return distance * 18;
    }

    public double calculateNightFare(double fare) {
        return fare * 1.20;
    }
}

public class CityCabFareMeter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        Cab[] cabs = new Cab[n];
        String[] types = new String[n];
        String[] times = new String[n];
        double total = 0;

        for (int i = 0; i < n; i++) {
            types[i] = sc.next();
            double distance = sc.nextDouble();
            times[i] = sc.next();

            if (types[i].equals("MINI")) {
                cabs[i] = new Mini(distance);
            } else if (types[i].equals("SEDAN")) {
                cabs[i] = new Sedan(distance);
            } else {
                cabs[i] = new SUV(distance);
            }
        }

        for (int i = 0; i < n; i++) {
            if (times[i].equals("NIGHT") && !(cabs[i] instanceof NightService)) {
                System.out.println(types[i] + ": night service not available");
                continue;
            }

            double fare = cabs[i].calculateFare();

            if (times[i].equals("NIGHT")) {
                NightService service = (NightService) cabs[i];
                fare = service.calculateNightFare(fare);
            }

            System.out.printf("%s: %.2f%n", types[i], fare);
            total += fare;
        }

        System.out.printf("Total: %.2f%n", total);
        sc.close();
    }
}
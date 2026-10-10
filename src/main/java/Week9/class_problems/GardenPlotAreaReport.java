import java.util.Scanner;

abstract class GardenPlot {
    String owner;

    GardenPlot(String owner) {
        this.owner = owner;
    }

    abstract double calculateArea();
}

class Circle extends GardenPlot {
    double radius;

    Circle(String owner, double radius) {
        super(owner);
        this.radius = radius;
    }

    double calculateArea() {
        return Math.PI * radius * radius;
    }
}

class Rectangle extends GardenPlot {
    double length, width;

    Rectangle(String owner, double length, double width) {
        super(owner);
        this.length = length;
        this.width = width;
    }

    double calculateArea() {
        return length * width;
    }
}

class Triangle extends GardenPlot {
    double base, height;

    Triangle(String owner, double base, double height) {
        super(owner);
        this.base = base;
        this.height = height;
    }

    double calculateArea() {
        return 0.5 * base * height;
    }
}

public class GardenPlotAreaReport {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        GardenPlot[] plots = new GardenPlot[n];
        String[] shapes = new String[n];
        double total = 0;

        for (int i = 0; i < n; i++) {
            shapes[i] = sc.next();
            String owner = sc.next();

            if (shapes[i].equals("CIRCLE")) {
                plots[i] = new Circle(owner, sc.nextDouble());
            } else if (shapes[i].equals("RECTANGLE")) {
                plots[i] = new Rectangle(owner, sc.nextDouble(), sc.nextDouble());
            } else {
                plots[i] = new Triangle(owner, sc.nextDouble(), sc.nextDouble());
            }
        }

        for (int i = 0; i < n; i++) {
            double area = plots[i].calculateArea();
            System.out.printf("%s (%s): %.2f%n",
                    plots[i].owner, shapes[i], area);
            total += area;
        }

        System.out.printf("Total Area: %.2f%n", total);
        sc.close();
    }
}
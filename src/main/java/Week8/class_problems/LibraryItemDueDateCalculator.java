import java.util.*;
import java.time.LocalDate;

interface LibraryItem {
    LocalDate calculateDueDate();
    String getTitle();
}

class Book implements LibraryItem {
    private String title;
    private LocalDate currentDate;

    Book(String title, LocalDate currentDate) {
        this.title = title;
        this.currentDate = currentDate;
    }

    public LocalDate calculateDueDate() {
        return currentDate.plusDays(14);
    }

    public String getTitle() {
        return title;
    }
}

class DVD implements LibraryItem {
    private String title;
    private LocalDate currentDate;

    DVD(String title, LocalDate currentDate) {
        this.title = title;
        this.currentDate = currentDate;
    }

    public LocalDate calculateDueDate() {
        return currentDate.plusDays(7);
    }

    public String getTitle() {
        return title;
    }
}

class Magazine implements LibraryItem {
    private String title;
    private LocalDate currentDate;

    Magazine(String title, LocalDate currentDate) {
        this.title = title;
        this.currentDate = currentDate;
    }

    public LocalDate calculateDueDate() {
        return currentDate.plusDays(3);
    }

    public String getTitle() {
        return title;
    }
}

public class LibraryItemDueDateCalculator {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());

        LocalDate currentDate = LocalDate.of(2023, 10, 26);

        for (int i = 0; i < n; i++) {
            String line = sc.nextLine();

            int firstSpace = line.indexOf(' ');
            String type = line.substring(0, firstSpace);
            String title = line.substring(firstSpace + 1);

            title = title.replace("\"", "");

            LibraryItem item;

            if (type.equals("BOOK")) {
                item = new Book(title, currentDate);
            } else if (type.equals("DVD")) {
                item = new DVD(title, currentDate);
            } else {
                item = new Magazine(title, currentDate);
            }

            System.out.println(
                item.getTitle() + ": " + item.calculateDueDate()
            );
        }

        sc.close();
    }
}
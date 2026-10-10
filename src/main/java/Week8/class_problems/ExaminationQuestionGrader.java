import java.util.*;

interface Question {
    double calculateScore();
}

class MCQQuestion implements Question {
    private String correctAnswer;
    private String studentAnswer;
    private double points;

    MCQQuestion(String correctAnswer, String studentAnswer, double points) {
        this.correctAnswer = correctAnswer;
        this.studentAnswer = studentAnswer;
        this.points = points;
    }

    public double calculateScore() {
        if (studentAnswer.equals(correctAnswer)) {
            return points;
        }
        return 0;
    }
}

class TFQuestion implements Question {
    private String correctAnswer;
    private String studentAnswer;
    private double points;

    TFQuestion(String correctAnswer, String studentAnswer, double points) {
        this.correctAnswer = correctAnswer;
        this.studentAnswer = studentAnswer;
        this.points = points;
    }

    public double calculateScore() {
        if (studentAnswer.equals(correctAnswer)) {
            return points;
        }
        return 0;
    }
}

class EssayQuestion implements Question {
    private String correctAnswer;
    private String studentAnswer;
    private double points;

    EssayQuestion(String correctAnswer, String studentAnswer, double points) {
        this.correctAnswer = correctAnswer;
        this.studentAnswer = studentAnswer;
        this.points = points;
    }

    public double calculateScore() {
        String[] keywords = correctAnswer.split(",");

        int count = 0;
        String answer = studentAnswer.toLowerCase();

        for (String keyword : keywords) {
            if (answer.contains(keyword.trim().toLowerCase())) {
                count++;
            }
        }

        if (count >= 2) {
            return points * 0.75;
        } else if (count == 1) {
            return points * 0.50;
        } else {
            return 0;
        }
    }
}

public class ExaminationQuestionGrader {

    public static String[] getQuotedParts(String line) {
        ArrayList<String> parts = new ArrayList<>();

        int start = 0;

        while (true) {
            int firstQuote = line.indexOf('"', start);

            if (firstQuote == -1) {
                break;
            }

            int secondQuote = line.indexOf('"', firstQuote + 1);

            parts.add(line.substring(firstQuote + 1, secondQuote));

            start = secondQuote + 1;
        }

        return parts.toArray(new String[0]);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());
        double total = 0;

        for (int i = 0; i < n; i++) {

            String line = sc.nextLine();

            String type = line.substring(0, line.indexOf(' '));

            String[] parts = getQuotedParts(line);

            double points = Double.parseDouble(
                line.substring(line.lastIndexOf(' ') + 1)
            );

            Question question;

            if (type.equals("MCQ")) {
                question = new MCQQuestion(
                    parts[1], parts[2], points
                );
            } else if (type.equals("TF")) {
                question = new TFQuestion(
                    parts[1], parts[2], points
                );
            } else {
                question = new EssayQuestion(
                    parts[1], parts[2], points
                );
            }

            double score = question.calculateScore();

            System.out.printf("%s: %.2f%n", type, score);
            total += score;
        }

        System.out.printf("Total Score: %.2f%n", total);

        sc.close();
    }
}
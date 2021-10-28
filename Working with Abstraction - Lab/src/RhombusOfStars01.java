import java.util.Scanner;

public class RhombusOfStars01 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = Integer.parseInt(scan.nextLine());

        PrintFigure(n);
    }

    private static void PrintFigure(int n) {
        printTop(n);
        printBottom(n);
    }

    private static void printBottom(int n) {
        for (int i = n - 1; i >= 1; i--) {
            StringBuilder builder = new StringBuilder();
            appendSpaces(n, i, builder);
            appendStars(i, builder);
            System.out.println(builder.toString());
        }
    }

    private static void printTop(int n) {
        for (int i = 1; i <= n; i++) {
            StringBuilder builder = new StringBuilder();
            appendSpaces(n, i, builder);
            appendStars(i, builder);
            System.out.println(builder.toString());
        }
    }

    private static void appendStars(int i, StringBuilder builder) {
        for (int j = 1; j <= i; j++) {
            builder.append("* ");
        }
    }

    private static void appendSpaces(int n, int i, StringBuilder builder) {
        for (int j = n - i; j > 0; j--) {
            builder.append(" ");
        }
    }
}

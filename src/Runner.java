import javax.sound.sampled.Line;
import java.util.Scanner;
public class Runner {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        double x1, y1, x2, y2;
        String cOne, cTwo;

        System.out.println("Hello!\nThis program takes 2 valid coordinates and does linear equations." +
                "\nReady to begin?, input below!\nUse the (0,0) format.");

        System.out.print("Coordinate one: ");
        cOne = input.nextLine();

        System.out.print("Coordinate two: ");
        cTwo = input.nextLine();

        x1 = coordinateOne(cOne); y1 = coordinateTwo(cOne); x2 = coordinateOne(cTwo); y2 = coordinateTwo(cTwo);

        LinearEquation operator = new LinearEquation(x1, y1, x2, y2);

        System.out.println(operator.toString());
    }

    public static double coordinateOne(String coordinate) {
        int c = coordinate.indexOf(",");
        String number = coordinate.substring(1, c);

        return Double.parseDouble(number);
    }

    public static double coordinateTwo(String coordinate) {
        int c = coordinate.indexOf(",");
        String number = coordinate.substring(c + 1, coordinate.length() - 1);

        return Double.parseDouble(number);
    }
}

import java.text.DecimalFormat;
import java.util.Locale;

public class LinearEquation {

    DecimalFormat df = new DecimalFormat("0.00");
    private double x1, y1, x2, y2;

    public LinearEquation(double x1, double y1, double x2, double y2) {
        this.x1 = x1; this.y1 = y1; this.x2 = x2; this.y2 = y2;
    }

  //  d = \sqrt{(x_2 - x_1)^2 + (y_2-y_1)^2} - Distance Formula
    public double distance() {
        return Math.sqrt((Math.pow((this.x2 - this.x1), 2) + Math.pow((this.y2 - this.y1), 2)));
    }

    public double distanceRounded() {
        double num = Math.sqrt((Math.pow((this.x2 - this.x1), 2) + Math.pow((this.y2 - this.y1), 2)));
        String newNum = df.format(num);
        double roundedNum = Double.parseDouble(newNum);

        return roundedNum;
    }

    public String distanceToString(String decimalOrFraction) {
        String ds;
        ds = "d = √[(" + this.x2 + " - " + this.x1 + ")^2 + (" + this.y2 + " - " + this.y1 + ")^2]";

        //if (decimalOrFraction.toLowerCase() == "decimal" || decimalOrFraction.toLowerCase() == "d") {

       // } else {

       // }

        return ds;
    }

    //public String distanceToString() {


   // }

    //  m=(y2-y1)/(x2-x1) - Slope Formula
    public double slope() {
        return (this.y2 - this.y1) / (this.x2 - this.x1);
    }

    public double slopeRounded() {
        double num = (this.y2 - this.y1) / (this.x2 - this.x1);
        String newNum = df.format(num);
        double roundedNum = Double.parseDouble(newNum);

        return roundedNum;
    }
/*
    public String slopeToString(String decimalOrFraction) {

    }

    public String slopeToString() {

    }

    y -mx = b | y - slope(x) = b for yintercept
*/
}

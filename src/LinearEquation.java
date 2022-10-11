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

    public String distanceToString(String decimalOrFraction) {

    }

    public String distanceToString() {


    }
}

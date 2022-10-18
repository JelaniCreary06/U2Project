import java.text.DecimalFormat;

public class LinearEquation {

    DecimalFormat df = new DecimalFormat("0.00");
    CF cf = new CF();
    private double x1, y1, x2, y2;

    public LinearEquation(double x1, double y1, double x2, double y2) {
        this.x1 = x1; this.y1 = y1; this.x2 = x2; this.y2 = y2;
    }

    //  Distance Methods below
    public double distance(boolean rounded) {
        double num = Math.sqrt((Math.pow((this.x2 - this.x1), 2) + Math.pow((this.y2 - this.y1), 2)));

        if (rounded) {
            String newNum = df.format(num);
            num = Double.parseDouble(newNum);
        }

        return num;
    }
    public double distance() {
        return distance(false);
    }
    public String distanceToString(boolean fractionForm) {
        String ds;

        if (fractionForm) {
            ds = "d = √[( (" + cf.dTF(this.x2) + ") - (" + cf.dTF(this.x1) +
                    ") )^2 + ( (" + cf.dTF(this.y2) + ") - (" + cf.dTF(this.y1) + ") )^2]";
        } else {
            ds = "d = √[(" + this.x2 + " - " + this.x1 + ")^2 + (" + this.y2 + " - " + this.y1 + ")^2]";
        }


        return ds;
    }
    public String distanceToString() {
        return distanceToString(false);
     }

    //  Slope Methods below | m=(y2-y1)/(x2-x1) - Slope Formula
    public double slope(boolean rounded) {
        double num = (this.y2 - this.y1) / (this.x2 - this.x1);

        if (rounded) {
            String newNum = df.format(num);
            num = Double.parseDouble(newNum);
        }

        return num;
    }
    public double slope() {
        return slope(true);
    }
    public String slopeToString(boolean fractionForm) {

        String toReturn = "";

        if (fractionForm) {
           toReturn = "m = ( (" + cf.dTF(this.y2) + ") - (" + cf.dTF(this.y1) +
                    ") ) / ( (" + cf.dTF(this.x2) + ") - (" + cf.dTF(this.x1) + ") )";
        } else  {
            toReturn = "m = (" + this.y2 + " - " + this.y1 +
                    ") / (" + this.x2 + " - " + this.x1 + ")";
        }

        return toReturn;
    }
    public String slopeToString() {
        return slopeToString(false);
    }

//Y-Intercept Methods below |  y -mx = b | y - slope(x) = b for yintercept
    public double yIntercept(boolean rounded, int coordinateOneOrTwo) {
        double num1 = this.y1 - (slope(false) * this.x1), num2 = this.y2 - (slope(false) * this.x2);

        if (rounded) {
            String newNum1 = df.format(num1), newNum2 = df.format(num2);
            num1 = Double.parseDouble(newNum1); num2 = Double.parseDouble(newNum2);
        }

        return switch (coordinateOneOrTwo) {
            case 1 -> num1;
            default -> num2;
        };
    }
    public double yIntercept(int coordinateOneOrTwo) {
      return  yIntercept(true, coordinateOneOrTwo);
    }
    public double yIntercept(boolean rounded) {
        return  yIntercept(rounded, 1);
    }
    public double yInercept() {
        return yIntercept(true, 1);
    }
    public String yInterceptToString(boolean fractionForm, boolean roundedValues, int coordinateOneOrTwo) {

        String equation1 = "b = ", equation2 = "b = ";

        if (fractionForm) {
            equation1 += cf.dTF(this.y1) + " = " + cf.dTF(slope(roundedValues)) + "(" + cf.dTF(this.x1) + ") +" + cf.dTF(yIntercept(roundedValues, 1));
            equation2 += cf.dTF(this.y2) + " = " + cf.dTF(slope(roundedValues)) + "(" + cf.dTF(this.x2) + ") +" + cf.dTF(yIntercept(roundedValues, 1));
        } else {
            equation1 =  this.y1 + " = " + slope(roundedValues) + "(" + this.x1 + ") +" + yIntercept(roundedValues, 1);
            equation2 =  this.y2 + " = " + slope(roundedValues) + "(" + this.x2 + ") +" + yIntercept(roundedValues, 1);
        }

        return switch (coordinateOneOrTwo) {
            case 1 -> equation1;
            case 2 -> equation2;
            default ->  this.y1 + " - (" + slope(roundedValues) + " * " + this.x1 + ")";
        };
    }

    public String yInterceptToString(boolean fractionForm, int coordinateOneOrTwo) {

        String equation1 = "", equation2 = "";

        if (fractionForm) {
            equation1 += cf.dTF(this.y1) + " = " + cf.dTF(slope(true)) + "(" + cf.dTF(this.x1) + ") +" + cf.dTF(yIntercept(true, 1));
            equation2 += cf.dTF(this.y2) + " = " + cf.dTF(slope(true)) + "(" + cf.dTF(this.x2) + ") +" + cf.dTF(yIntercept(true, 1));
        } else {
            equation1 =  this.y1 + " = " + slope(true) + "(" + this.x1 + ") +" + yIntercept(true, 1);
            equation2 =  this.y2 + " = " + slope(true) + "(" + this.x2 + ") +" + yIntercept(true, 1);
        }



        return switch (coordinateOneOrTwo) {
            case 1 -> equation1;
            case 2 -> equation2;
            default ->  this.y1 + " - (" + slope(true) + " * " + this.x1 + ")";
        };
    }
    public String yInterceptToString(int coordinateOneOrTwo) {
        return yInterceptToString(false, coordinateOneOrTwo);
    }
    public String yInterceptToString(boolean fractionForm) {
        return yInterceptToString(fractionForm, 1);
    }
    public String yInterceptToString() {
        return yInterceptToString(false, 1);
    }
    public String toString(boolean outputEquations, boolean areValuesRounded, boolean fractionsForDecimals) {

        String toRetun = "Coordinates: (" + this.x1 + " , " + this.x2 + ") ( " + this.x2 + " , " + this.y2 +")\n" +
                "Expression: " +yInterceptToString(fractionsForDecimals);

        if (outputEquations) {
            toRetun +=  "\nSlope: " + slopeToString(fractionsForDecimals) +
                    "\nY-Intercept: " + yInterceptToString(fractionsForDecimals, areValuesRounded, 1) +
                    "\nDistance: " + distanceToString(fractionsForDecimals);
        } else {
            toRetun +=  "\nSlope: " + slope(areValuesRounded) +
                    "\nY-Intercept: " + yIntercept(areValuesRounded) +
                    "\nDistance: " + distance(areValuesRounded);
        }

        return toRetun;
    }
    public String toString(boolean outputEquations, boolean areValuesRounded) {

        String toRetun = "Coordinates: (" + this.x1 + " , " + this.x2 + ") ( " + this.x2 + " , " + this.y2 +")\n" +
                "Expression: " + yInterceptToString(false);

        if (outputEquations) {
            toRetun +=  "\nSlope: " + slopeToString(false) +
                    "\nY-Intercept: " + yInterceptToString(false, areValuesRounded, 1) +
                    "\nDistance: " + distanceToString(false);
        } else {
            toRetun +=  "\nSlope: " + slope(areValuesRounded) +
                    "\nY-Intercept: " + yIntercept(areValuesRounded) +
                    "\nDistance: " + distance(areValuesRounded);
        }

        return toRetun;
    }
    public String toString( boolean areValuesRounded) {
        return "Coordinates: (" + this.x1 + " ," + this.x2 + ") ( " + this.x2 + "," + this.y2 +")\n" +
                "Expression: " +yInterceptToString(false) +
                "\nSlope: " + slope(areValuesRounded) +
                "\nY-Intercept: " + yIntercept(areValuesRounded) +
                "\nDistance: " + distance(areValuesRounded);
    }
    public String toString() {
        return toString(true);
    }
}


public class CF {
    //Wanted a fresh file to work on this, to compose myself.
    public String dTF(double decimal) {
        String converted = Double.toString(decimal);

        int i = converted.indexOf(".");

        String getLength = converted.substring(i, converted.length() - 1);

        int toIncrease = getLength.length(), switchCase = 10;

        return (decimal * toIncrease) + "/" + toIncrease;
    }

    public String dTF(String decimalString) {
        int i = decimalString.indexOf(".");

        String getLength = decimalString.substring(i, decimalString.length() - 1);

        int toIncrease = getLength.length();

        return (Double.parseDouble(decimalString) * toIncrease) + "/" + toIncrease;
    }

    //private double c(double i) {

    //}


}
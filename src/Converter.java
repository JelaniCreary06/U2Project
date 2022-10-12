public class ConverterClass {
    //Wanted a fresh file to work on this, to compose myself.
    public String dTF(double roundedDecimal) {
        int num1 = (int) roundedDecimal;
        double lo = roundedDecimal - num1;

        double f1 = num1 * 100;
        double f2 = lo * 100;

        return f1 + "/" +f2;
    }

    public String dTF(String roundedDecimal) {
        String l = ""; //Place holder //
        return l;
    }
}
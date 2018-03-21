package calculator.tugraz.at.calculator;


public class Calculations {
    private Calculations() {

    }

    public static int doAddition(int n1, int n2) {
        int result = n1 + n2;
        return result;
    }

    public static int doSubtraction(int n1, int n2) {
        int result = n1 - n2;
        return result;
    }

    public static int doMultiplication(int n1, int n2) {
        int result = n1 * n2;
        return result;
    }

    public static int doDivision(int n1, int n2) {
        if (n2 == 0) {
            return 0;
        }
        int result = n1 / n2;
        return result;
    }
}

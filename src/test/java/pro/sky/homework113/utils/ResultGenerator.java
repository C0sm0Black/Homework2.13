package pro.sky.homework113.utils;

public class ResultGenerator {

    public static String plusGenerator(Integer num1, Integer num2, Integer result) {
        return String.format("%d + %d = %d", num1, num2, result);
    }

    public static String minusGenerator(Integer num1, Integer num2, Integer result) {
        return String.format("%d - %d = %d", num1, num2, result);
    }

    public static String multiplyGenerator(Integer num1, Integer num2, Integer result) {
        return String.format("%d * %d = %d", num1, num2, result);
    }

    public static String divideGenerator(Double num1, Double num2, Double result) {
        return String.format("%1$,.1f / %2$,.1f = %3$,.1f", num1, num2, result);
    }

}

package pro.sky.homework113.service;

import org.springframework.stereotype.Service;
import pro.sky.homework113.exception.DivideByZero;
import pro.sky.homework113.exception.NumsNullException;

@Service
public class CalculatorServiceImpl implements CalculatorService{

    public String plus(Integer num1, Integer num2) {

        checkIntegerNumsForNull(num1, num2);
        return String.format("%d + %d = %d", num1, num2, num1 + num2);

    }

    public String minus(Integer num1, Integer num2) {

        checkIntegerNumsForNull(num1, num2);
        return String.format("%d - %d = %d", num1, num2, num1 - num2);

    }

    public String multiply(Integer num1, Integer num2) {

        checkIntegerNumsForNull(num1, num2);
        return String.format("%d * %d = %d", num1, num2, num1 * num2);

    }

    public String divide(Double num1, Double num2) {

        checkDoubleNumsForNull(num1, num2);

        if (num2 == 0) {
            throw new DivideByZero("Делить на 0 недьзя!");
        }

        return String.format("%1$,.1f / %2$,.1f = %3$,.1f", num1, num2, num1 / num2);

    }

    private void checkIntegerNumsForNull(Integer num1, Integer num2) {

        if (num1 == null || num2 == null) {
            throw new NumsNullException("Одно или два из чисел не введены!");
        }

    }

    private void checkDoubleNumsForNull(Double num1, Double num2) {

        if (num1 == null || num2 == null) {
            throw new NumsNullException("Одно или два из чисел не введены!");
        }

    }

}

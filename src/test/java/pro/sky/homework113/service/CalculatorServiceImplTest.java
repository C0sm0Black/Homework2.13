package pro.sky.homework113.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import pro.sky.homework113.exception.DivideByZero;

import static org.junit.jupiter.api.Assertions.*;

@ContextConfiguration(classes = {CalculatorServiceImpl.class})
@ExtendWith(SpringExtension.class)
class CalculatorServiceImplTest {

    @Autowired
    private CalculatorService calculatorService;

    @Test
    void plus_success() {

        //Подготовка входных данных

        Integer num1 = 7;
        Integer num2 = 8;

        //Подготовка ожидаемого результата

        String actual = calculatorService.plus(num1, num2);
        String expected = "7 + 8 = 15";

        //Начало теста

        assertEquals(expected, actual);

    }

    @Test
    void plus_success2() {

        //Подготовка входных данных

        Integer num1 = 55;
        Integer num2 = 10;

        //Подготовка ожидаемого результата

        String actual = calculatorService.plus(num1, num2);
        String expected = "55 + 10 = 65";

        //Начало теста

        assertEquals(expected, actual);

    }

    @Test
    void minus_success() {

        //Подготовка входных данных

        Integer num1 = 44;
        Integer num2 = 5;

        //Подготовка ожидаемого результата

        String actual = calculatorService.minus(num1, num2);
        String expected = "44 - 5 = 39";

        //Начало теста

        assertEquals(expected, actual);

    }

    @Test
    void minus_success2() {

        //Подготовка входных данных

        Integer num1 = 0;
        Integer num2 = 60;

        //Подготовка ожидаемого результата

        String actual = calculatorService.minus(num1, num2);
        String expected = "0 - 60 = -60";

        //Начало теста

        assertEquals(expected, actual);

    }

    @Test
    void multiply_success() {

        //Подготовка входных данных

        Integer num1 = 5;
        Integer num2 = 3;

        //Подготовка ожидаемого результата

        String actual = calculatorService.multiply(num1, num2);
        String expected = "5 * 3 = 15";

        //Начало теста

        assertEquals(expected, actual);

    }

    @Test
    void multiply_success2() {

        //Подготовка входных данных

        Integer num1 = -77;
        Integer num2 = -6;

        //Подготовка ожидаемого результата

        String actual = calculatorService.multiply(num1, num2);
        String expected = "-77 * -6 = 462";

        //Начало теста

        assertEquals(expected, actual);

    }

    @Test
    void divide_success() {

        //Подготовка входных данных

        Double num1 = 70.0;
        Double num2 = 5.0;

        //Подготовка ожидаемого результата

        String actual = calculatorService.divide(num1, num2);
        String expected = "70,0 / 5,0 = 14,0";

        //Начало теста

        assertEquals(expected, actual);

    }

    @Test
    void divide_success2() {

        //Подготовка входных данных

        Double num1 = 5.0;
        Double num2 = 1.0;

        //Подготовка ожидаемого результата

        String actual = calculatorService.divide(num1, num2);
        String expected = "5,0 / 1,0 = 5,0";

        //Начало теста

        assertEquals(expected, actual);

    }

    @Test
    void divideByZero() {

        //Подготовка входных данных

        Double num1 = 5.0;
        Double num2 = 0.0;

        //Подготовка ожидаемого результата

        Exception e = assertThrows(
                DivideByZero.class,
                () -> {
                    calculatorService.divide(num1, num2);
                }
        );
        String expected = "Делить на 0 недьзя!";

        //Начало теста

        assertEquals(expected, e.getMessage());

    }

}
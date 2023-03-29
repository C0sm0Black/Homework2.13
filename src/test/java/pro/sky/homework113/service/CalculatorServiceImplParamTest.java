package pro.sky.homework113.service;

import net.bytebuddy.asm.Advice;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import pro.sky.homework113.exception.DivideByZero;
import pro.sky.homework113.utils.ResultGenerator;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@ContextConfiguration(classes = {CalculatorServiceImpl.class})
@ExtendWith(SpringExtension.class)
class CalculatorServiceImplParamTest {

    @Autowired
    private CalculatorService calculatorService;

    public static Stream<Arguments> plusParam() {

        return Stream.of(
                Arguments.of(8, 7, ResultGenerator.plusGenerator(8, 7, 15)),
                Arguments.of(55, 10, ResultGenerator.plusGenerator(55, 10, 65)));


    }

    public static Stream<Arguments> minusParam() {

        return Stream.of(
                Arguments.of(23, 6, ResultGenerator.minusGenerator(23, 6, 17)),
                Arguments.of(-1, 60, ResultGenerator.minusGenerator(-1, 60, -61)));


    }

    public static Stream<Arguments> multiplyParam() {

        return Stream.of(
                Arguments.of(50, 3, ResultGenerator.multiplyGenerator(50, 3, 150)),
                Arguments.of(48, 5, ResultGenerator.multiplyGenerator(48, 5, 240)));


    }

    public static Stream<Arguments> divideParam() {

        return Stream.of(
                Arguments.of(55.0, 5.0, ResultGenerator.divideGenerator(55.0, 5.0, 11.0)),
                Arguments.of(-1.0, -1.0, ResultGenerator.divideGenerator(-1.0, -1.0, 1.0)));


    }

    @ParameterizedTest
    @MethodSource("plusParam")
    void paramTestPlus(Integer num1, Integer num2, String expected) {
        Assertions.assertEquals(calculatorService.plus(num1, num2), expected);
    }

    @ParameterizedTest
    @MethodSource("minusParam")
    void paramTestMinus(Integer num1, Integer num2, String expected) {
        Assertions.assertEquals(calculatorService.minus(num1, num2), expected);
    }

    @ParameterizedTest
    @MethodSource("multiplyParam")
    void paramTestMultiply(Integer num1, Integer num2, String expected) {
        Assertions.assertEquals(calculatorService.multiply(num1, num2), expected);
    }

    @ParameterizedTest
    @MethodSource("divideParam")
    void paramTestDivide(Double num1, Double num2, String expected) {
        Assertions.assertEquals(calculatorService.divide(num1, num2), expected);
    }

}
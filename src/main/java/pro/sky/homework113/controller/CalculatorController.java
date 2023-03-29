package pro.sky.homework113.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import pro.sky.homework113.exception.DivideByZero;
import pro.sky.homework113.exception.NumsNullException;
import pro.sky.homework113.service.CalculatorService;

@RestController
@RequestMapping("/calculator")
public class CalculatorController {

    private final CalculatorService calculatorService;

    @Autowired
    public CalculatorController(CalculatorService calculatorService) {
        this.calculatorService = calculatorService;
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler({DivideByZero.class, NumsNullException.class})
    public String handlerException(IllegalArgumentException e) {
        return String.format("%s - %s", HttpStatus.BAD_REQUEST.value(), e.getMessage());
    }

    @GetMapping
    public String hello() {
        return "Добро пожаловать в калькулятор";
    }

    @GetMapping("/plus")
    public String plus(@RequestParam (required = false) Integer num1, @RequestParam (required = false) Integer num2) {
        return calculatorService.plus(num1, num2);
    }

    @GetMapping("/minus")
    public String minus(@RequestParam (required = false) Integer num1, @RequestParam (required = false) Integer num2) {
        return calculatorService.minus(num1, num2);
    }

    @GetMapping("/multiply")
    public String multiply(@RequestParam (required = false) Integer num1, @RequestParam (required = false) Integer num2) {
        return calculatorService.multiply(num1, num2);
    }

    @GetMapping("/divide")
    public String divide(@RequestParam (required = false) Double num1, @RequestParam (required = false) Double num2) {
        return calculatorService.divide(num1, num2);
    }

}

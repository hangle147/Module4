package com.example.may_tinh_don_gian.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class calculatorController {
    @RequestMapping("/")
    public String showForm() {
        return "index";
    }

    @RequestMapping(value = "/calculate", method = RequestMethod.POST)
    public String calculate(
            @RequestParam("num1") double num1,
            @RequestParam("num2") double num2,
            @RequestParam("operation") String operation,
            Model model) {

        double result = 0;
        String symbol = "";

        switch (operation) {
            case "add":
                result = num1 + num2;
                symbol = "Addition";
                break;
            case "sub":
                result = num1 - num2;
                symbol = "Subtraction";
                break;
            case "mul":
                result = num1 * num2;
                symbol = "Multiplication";
                break;
            case "div":
                symbol = "Division";
                result = num2 != 0 ? num1 / num2 : 0;
                break;
        }

        model.addAttribute("result", "Result " + symbol + " : " + result);
        return "index";
    }
}

package com.group.libraryapp.controller.calculator;

import com.group.libraryapp.dto.calculator.request.CalculartorMultiplyRequest;
import com.group.libraryapp.dto.calculator.request.CalculatorAddRequest;
import org.springframework.web.bind.annotation.*;

@RestController // 주어진 Class를 Controller로 등록
public class CalculatorController {

    @GetMapping("/add") // HTTP Method에서의 GET이고 HTTP PATH가 /add인 API로 지정한다.
    public int addTwoNumbers(CalculatorAddRequest request) { //주어지는 쿼리를 함수 파라미터에 넣는다
        // GET/add?number1=10&number2=20 -> 10 = number1 , 20 = number2
        return request.getNumber1() + request.getNumber2();
    }

    @PostMapping("multiply")
    public int multiplyTwoNumbers(@RequestBody CalculartorMultiplyRequest request) {
        return request.getNumber1() * request.getNumber2();
    }

    // 과제
//    @GetMapping("/api/v1/calc")
//    public int calculator(@RequestParam int num1, @RequestParam int num2) {
//
//    }
}

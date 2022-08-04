package com.example.spring.controllor;

import com.example.spring.dto.ResponseDTO;
import com.example.spring.dto.TestRequestBodyDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("test")
public class JavaExController {

    @GetMapping
    public String test(){
        return "Hi I'm YJ";
    }

    @GetMapping("/{id}")
                                    //url 경로로 넘어오는 값을 변수로 받기 (requried는 필수 여부)
    public String testPathVariables(@PathVariable(required = false) int id){
        return "Hello World! ID : " + id;

    }

    @GetMapping("/testRequestParam")
                                    //경로에 ?id 쓰면 된다.
    public String testRequestParam(@RequestParam(required = false)int id){
        return "Hi your age is "+ id;
    }

    @GetMapping("/testRequestBody")
    public String testRequestBody(@RequestBody TestRequestBodyDTO testDTO){
        return "Hi! you're " + testDTO.getId() + ", Message : "+ testDTO.getMessage();
    }

    @GetMapping("/testResponseEntity")
    public ResponseEntity<?> testResponseEntity(){
        List<String> text = new ArrayList<>();
        text.add("Hello! I'm ResponseEntity! you got 400!");
        ResponseDTO response = ResponseDTO.builder().data(text).build();
        //400 ERROR
        return ResponseEntity.badRequest().body(response);
        //200 ok
        //return ResponseEntity.ok().body(response);
    }
}
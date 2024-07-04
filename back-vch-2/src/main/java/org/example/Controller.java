package org.example;

import org.example.SolvingNonlinearEquation.Main;
import org.example.SolvingNonlinearEquation.methods.Result;
import org.example.SolvingSystemOfNonlinearEquations.Main2;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/app-controller")
@CrossOrigin(origins = "*")
public class Controller {
    public Integer system = 0;
    public Integer equation = 0;
    public Integer method = 0;
    public Main main = new Main();
    public Main2 main2 = new Main2();

    @PostMapping("/system")
    public ResponseEntity number(@RequestBody Integer a) {
        system = a;
        return ResponseEntity.ok("");
    }
    @PostMapping("/equation")
    public ResponseEntity equation(@RequestBody Integer a) {
        if (system == 1) {
            equation = a;
            main.function_choice(equation);
            return ResponseEntity.ok("");
        }
        if (system == 2) {
            equation = a;
            main2.function_choice(equation);
        }
        return ResponseEntity.ok("");
    }

    @PostMapping("/method")
    public ResponseEntity method(@RequestBody Integer a) {
        method = a;
        Result result = main.method_choice(method);
        return ResponseEntity.ok(result);
    }

    @PostMapping(value = "/borders", consumes = "multipart/form-data")
    public ResponseEntity borders(@RequestParam("left") String leftValue, @RequestParam("right") String rightValue, @RequestParam("accuracy") String accuracy, @RequestParam("quantity") String quantity) {
        if (system == 1) {
            String out = main.check(leftValue, rightValue, accuracy, quantity);
            System.out.println(out);
            return ResponseEntity.ok(out);
        }
        if (system == 2) {
            String out = main2.check(leftValue, rightValue, accuracy, quantity);
            return ResponseEntity.ok(out);
        }
        return ResponseEntity.ok("");
    }
    @GetMapping("/bord2")
    public ResponseEntity bord2() {
        org.example.SolvingSystemOfNonlinearEquations.methods.Result result = main2.run();
        return ResponseEntity.ok(result);
    }
    @GetMapping("/welcome")
    public ResponseEntity welcome() {
        return ResponseEntity.ok("welcome");
    }
}

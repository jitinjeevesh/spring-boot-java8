package sample;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/lambda")
public class LambdaController {

    //with out type declaration
    @RequestMapping(value = "/optionalType")
    public String optionalType() {
        //anonymous
        Operation addAno = new Operation() {
            @Override
            public int operate(int a, int b) {
                return a + b;
            }
        };
        //Lambda
        Operation add = (a, b) -> a + b;
        Operation sub = (a, b) -> a - b;
        return calculate(3, 5, add, "Addition :");
    }

    //with type declaration
    @RequestMapping(value = "/withType")
    public int optionalParenthesis() {
        Operation operation = (int a, int b) -> a + b; //Must be assign to every value
        return operation.operate(2, 3);
    }

    //with return statement and  curly braces
    @RequestMapping(value = "/withCurlyBraces")
    public int withCurlyBraces() {
        Operation operation = (int a, int b) -> {
            return a + b;
        };
        return operation.operate(2, 3);
    }

    private String calculate(int a, int b, Operation operation, String msg) {
        Message message = s -> s + String.valueOf(operation.operate(a, b));
        return message.display(msg);
    }
}

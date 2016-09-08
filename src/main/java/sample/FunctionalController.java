package sample;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Comparator;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;

@RestController
@RequestMapping("/functional")
public class FunctionalController {

    @RequestMapping("/biConsumer")
    public void biConsumer() {
        BiConsumer<Integer, Integer> biConsumer = (Integer a, Integer b) -> System.out.println(a + b);
        biConsumer.accept(2, 3);
    }

    @RequestMapping("/biFunction")
    public Integer biFunction() {
        BiFunction<Integer, Integer, Integer> biFunction = (Integer a, Integer b) -> a + b;
        return biFunction.apply(2, 3);
    }

    @RequestMapping("/binaryOperator")
    public void binaryOperator() {
        BinaryOperator<Integer> biConsumer = (Integer a, Integer b) -> a + b;
        System.out.println(biConsumer.apply(2, 4));

        BinaryOperator binaryOperator = BinaryOperator.maxBy(Comparator.reverseOrder());
        System.out.println(binaryOperator.apply(3, 5));

        BinaryOperator binaryOperator1 = BinaryOperator.minBy(Comparator.reverseOrder());
        System.out.println(binaryOperator1.apply(3, 5));

        BinaryOperator binaryOperator2 = BinaryOperator.maxBy(Comparator.comparingInt(value -> 5));
        System.out.println(binaryOperator2.apply(11, 10));

        BinaryOperator binaryOperator3 = BinaryOperator.minBy(Comparator.comparingInt(value -> 5));
        System.out.println(binaryOperator3.apply(19, 10));
    }
}

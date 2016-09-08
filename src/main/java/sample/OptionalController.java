package sample;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/optional")
public class OptionalController {

    @RequestMapping("/check")
    public Integer check() {
        Integer a = 20;
        Integer b = 2;
        Optional<Integer> first = Optional.ofNullable(a);
        Optional<Integer> second = Optional.ofNullable(b);
        //get will throws and exception if first is null
        System.out.println(first.get());
        System.out.println(second.get());
        System.out.println(second.orElse(30));
        System.out.println(second.isPresent());
        System.out.println(Optional.ofNullable(null).orElse(20));

        try {
            Optional.ofNullable(null).orElseThrow(() -> new Exception("Exception"));
        } catch (Exception e) {
            System.out.println("Exception....");
        }

        first.ifPresent((val) -> {
            System.out.println("Value is present");
        });

        second.orElseGet(() -> {
            System.out.println("Default value is : 10");
            return 10;
        });
        System.out.println("..........................1....................................");
        System.out.println(first.get());

        //Map is used to manipulate the value.
        Optional optional = second.map((val) -> val + 50);

        System.out.println("...........................2...................................");
        System.out.println(first.get());
        System.out.println(second.get());
        System.out.println(optional.get());

        return first.get() + second.orElse(10);
    }
}

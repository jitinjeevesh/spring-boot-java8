package sample;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/stream")
public class StreamController {

    private static final List<String> strings = Arrays.asList("abc", "", "bc", "efg", "abcd", "", "jkl");
    private static final List<Integer> integers = Arrays.asList(1, 2, 13, 4, 15, 6, 17, 8, 19);

    @RequestMapping("/count")
    public long countEmptyString() {
        return strings.stream().filter(String::isEmpty).count();
    }

    @RequestMapping("/count3")
    public long countLength3() {
        return strings.stream().filter(s -> s.length() == 3).count();
    }

    @RequestMapping("/deleteEmpty")
    public List<String> deleteEmptyStrings() {
        return strings.stream().filter(s -> !s.isEmpty()).collect(Collectors.toList());
    }

    @RequestMapping("/merge")
    public String mergeStrings() {
        return strings.stream().filter(s -> !s.isEmpty()).collect(Collectors.joining(","));
    }

    @RequestMapping("/max")
    public int max() {
        return integers.stream().mapToInt(value -> value).summaryStatistics().getMax();
    }

    @RequestMapping("/min")
    public int min() {
        return integers.stream().mapToInt(value -> value).summaryStatistics().getMin();
    }

    @RequestMapping("/sum")
    public long sum() {
        return integers.stream().mapToInt(value -> value).summaryStatistics().getSum();
    }

    @RequestMapping("/average")
    public double average() {
        return integers.stream().mapToInt(value -> value).summaryStatistics().getAverage();
    }

    @RequestMapping("/random")
    public List<Integer> random() {
        new Random(10).ints().limit(10).mapToLong(value -> value).forEach(System.out::println);
        new Random().ints().limit(10).forEach(System.out::println);
        return new Random().ints().limit(10).boxed().collect(Collectors.toList());
    }
}

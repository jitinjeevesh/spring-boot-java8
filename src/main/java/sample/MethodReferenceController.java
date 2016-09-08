package sample;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/method/reference")
public class MethodReferenceController {

    //Reference to a static method
    @RequestMapping(value = "/static")
    public String staticReference() {
        //anonymous..
        MethodReferenceInterface message = new MethodReferenceInterface() {
            @Override
            public String display(String s) {
                return "hello";
            }
        };

        //Lambda
        MethodReferenceInterface message1 = (s) -> "hello";
        //Method call
        MethodReferenceInterface message2 = (s) -> Util.display(s);
        //Method Ref
        MethodReferenceInterface message4 = Util::display;
        return message4.display("Hello this is static method reference example");
    }

    //Reference to an instance method of a particular object
    @RequestMapping(value = "/instance")
    public String instanceReference() {
        MethodReferenceInterface message = new Util()::show;
        return message.display("Hello this is Instance method reference example");
    }

    //Reference to a constructor
    @RequestMapping(value = "/constructor")
    public String constructorReference() {
        MethodReferenceForConstructorInterface message = Util::new;
        Util util = message.put("Hello this is Reference to a constructor example");
        return util.getDisp();
    }

    //Reference to an instance method of an arbitrary object of a particular type
    @RequestMapping(value = "/arbitrary")
    public int arbitraryObject() {
        //anonymous.
        MethodReferenceForArbitraryInterface message = new MethodReferenceForArbitraryInterface() {
            @Override
            public int compare(String s) {
                return "Hello".compareTo(s);
            }
        };
        //Lambda
        MethodReferenceForArbitraryInterface message2 = (s) -> "hello".compareToIgnoreCase(s);
        //Functional
        MethodReferenceForArbitraryInterface message3 = "hello"::compareToIgnoreCase;
        return message.compare("hello");
    }
}
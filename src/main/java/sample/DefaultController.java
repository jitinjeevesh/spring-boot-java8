package sample;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/default")
public class DefaultController {

    @RequestMapping("/display")
    public void display() {
        DefaultMethodImpl defaultMethod = new DefaultMethodImpl();
        defaultMethod.display("Hello");
        defaultMethod.show("world");
        MethodReferenceInterface.show1("Hello");
    }
}

package sv.com.bancoagricola.pagosqr.example1.demo;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoApplicationController {
    
    @RequestMapping("/hello") 
    public String hello (){
        System.out.println("we're going to add some logs, just in case");
        return "Hello world. This is an example using spring boot with visual code and also I'm testing git.!!";
    }
}

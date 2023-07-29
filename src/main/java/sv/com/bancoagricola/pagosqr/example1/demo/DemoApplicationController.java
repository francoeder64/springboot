package sv.com.bancoagricola.pagosqr.example1.demo;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@RestController
public class DemoApplicationController {

    private static final Logger logger = LogManager.getLogger(DemoApplicationController.class);
    
    @RequestMapping("/hello") 
    public String hello (){
        logger.info("we're going to add some logs, just in case");
        return "Hello world. This is an example using spring boot with visual code and also I'm testing git.!!";
    }
}

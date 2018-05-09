package cloud.test1.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by hefan on 2018/5/2.
 */
@RestController
public class AppTestController {

    private final Logger log = LoggerFactory.getLogger(AppTestController.class);


    @RequestMapping(value = "hello",method = RequestMethod.GET)
    public String index(){
        log.info("test2");
        return "hello world";
    }
}

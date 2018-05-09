package cloud.test1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * Created by hefan on 2018/5/9.
 */
@RestController
public class ConsumerController {

    @Autowired
    RestTemplate restTemplate;

    @RequestMapping(value = "hello",method = RequestMethod.GET)
    public String hello(){
        return restTemplate.getForEntity("http://CLOUD-TEST1/hello",String.class).getBody();
    }
}

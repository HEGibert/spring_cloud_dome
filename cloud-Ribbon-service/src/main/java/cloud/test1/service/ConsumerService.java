package cloud.test1.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * Created by hefan on 2018/5/11.
 */
@Service
public class ConsumerService {

    @Autowired
    RestTemplate restTemplate;


    @HystrixCommand(fallbackMethod = "helloServiceFallback")
    public String helloService(){
        return restTemplate.getForEntity("http://CLOUD-TEST1/hello",String.class).getBody();
    }

    public String helloServiceFallback(){
        return "error";
    }
}

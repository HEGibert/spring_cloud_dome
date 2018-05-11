package cloud.test1.compute;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by hefan on 2018/5/11.
 */
@FeignClient("cloud-test1")
public interface ComputeClient {

    @RequestMapping(value = "hello",method = RequestMethod.GET)
    String hello();
}

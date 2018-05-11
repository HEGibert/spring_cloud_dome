package cloud.test1.compute;

import cloud.test1.compute.impl.ComputeClientHystrix;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by hefan on 2018/5/11.
 */
@FeignClient(value = "cloud-test1",fallback = ComputeClientHystrix.class)
public interface ComputeClient {

    @RequestMapping(value = "hello",method = RequestMethod.GET)
    String hello();
}

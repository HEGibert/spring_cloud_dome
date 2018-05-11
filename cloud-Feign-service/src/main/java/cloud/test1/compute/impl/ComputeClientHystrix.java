package cloud.test1.compute.impl;

import cloud.test1.compute.ComputeClient;
import org.springframework.stereotype.Component;

/**
 * Created by hefan on 2018/5/11.
 */
@Component
public class ComputeClientHystrix implements ComputeClient {
    @Override
    public String hello() {
        return "error";
    }
}

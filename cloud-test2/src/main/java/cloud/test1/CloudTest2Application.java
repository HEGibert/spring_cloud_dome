package cloud.test1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * Created by hefan on 2018/5/2.
 */
@EnableDiscoveryClient
@SpringBootApplication
public class CloudTest2Application {

    public static void main(String[] args) {
        SpringApplication.run(CloudTest2Application.class, args);
    }
}

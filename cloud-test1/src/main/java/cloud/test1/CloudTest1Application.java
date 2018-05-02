package cloud.test1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * Created by hefan on 2018/5/2.
 */
@EnableDiscoveryClient
@SpringBootApplication
public class CloudTest1Application {

    public static void main(String[] args) {
        SpringApplication.run(CloudTest1Application.class, args);
    }
}

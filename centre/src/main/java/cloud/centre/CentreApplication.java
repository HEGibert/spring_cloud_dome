package cloud.centre;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * Created by hefan on 2018/5/2.
 */

@SpringBootApplication
@EnableEurekaServer
public class CentreApplication {

    public static void main(String[] args) {
        SpringApplication.run(CentreApplication.class, args);
    }
}

package cloud.test1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

/**
 * Created by hefan on 2018/5/2.
 */
@EnableDiscoveryClient
@SpringBootApplication
@EnableMongoRepositories(value = "cloud.test1.doao.custom")
@EntityScan("domain")
public class CloudTest2Application {

    public static void main(String[] args) {
        SpringApplication.run(CloudTest2Application.class, args);
    }
}

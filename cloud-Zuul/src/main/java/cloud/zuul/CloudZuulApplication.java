package cloud.zuul;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@EnableZuulProxy
@SpringCloudApplication
public class CloudZuulApplication {
    public static void main(String[] args){
        new SpringApplicationBuilder(CloudZuulApplication.class).web(true).run(args);
    }
}

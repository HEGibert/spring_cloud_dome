package cloud.test1.config;

import com.mongodb.MongoClientURI;
import com.mongodb.MongoCredential;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;

import java.net.UnknownHostException;

@Configuration
@PropertySource(value = "classpath:application.yml",ignoreResourceNotFound = true)
public class MongoDBConfig {

    @Value("${mongodb.databasename}")
    private String databaseName;

    @Value("${mongodb.uri}")
    private String uri;

    @Value("${mongodb.usernmae}")
    private String username;

    @Value("${mongodb.password}")
    private String passwrod;

    @Bean
    public MongoDbFactory mongoDbFactory() throws UnknownHostException {


        String uriStr="mongodb://"+username+":"+passwrod+"@"+uri+"/"+databaseName;
        System.out.println("mongo链接"+uriStr);
        MongoClientURI mongoClientURI=new MongoClientURI(uriStr);
        MongoDbFactory mongoDbFactory=new SimpleMongoDbFactory(mongoClientURI);
        return mongoDbFactory;
    }
}

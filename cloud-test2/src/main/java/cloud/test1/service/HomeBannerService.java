package cloud.test1.service;

import cloud.test1.doao.custom.HomeBannerRepository;
import cloud.test1.domain.entity.HomeBanner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

@Service
public class HomeBannerService {

    private final HomeBannerRepository homeBannerRepository;

    private final MongoOperations mongoTemplate;

    @Autowired
    HomeBannerService(HomeBannerRepository homeBannerRepository, MongoOperations mongoTemplate){
        this.homeBannerRepository = homeBannerRepository;
        this.mongoTemplate = mongoTemplate;
    }

    public Object saveHomeBanner(){

        HomeBanner homeBanner = new HomeBanner();
        homeBanner.setName("第二条数据");
        homeBanner.setStatus(1);
        homeBanner.setUrl("http://www.009dz.com");
        homeBanner.setDesc("这是第二个描述");

        homeBannerRepository.save(homeBanner);

        return null;
    }

    public Object findHomeBanner(String name){

//        return null;
        return homeBannerRepository.findByName(name);
    }

    public Object findHomeBanner(){

        HomeBanner one = mongoTemplate.findOne(new Query(Criteria.where("name").is("第二条数据")), HomeBanner.class);

        return mongoTemplate.find(new Query(Criteria.where("name").is("第二条数据")),HomeBanner.class);
    }
}

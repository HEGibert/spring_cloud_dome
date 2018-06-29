package cloud.test1.service;

import cloud.test1.dao.custom.HomeBannerRepository;
import cloud.test1.domain.entity.HomeBanner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HomeBannerService {

    private final HomeBannerRepository homeBannerRepository;

    @Autowired
    HomeBannerService(HomeBannerRepository homeBannerRepository){
        this.homeBannerRepository = homeBannerRepository;
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
}

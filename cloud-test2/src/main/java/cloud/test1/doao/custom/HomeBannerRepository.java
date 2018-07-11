package cloud.test1.doao.custom;

import cloud.test1.domain.entity.HomeBanner;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
public interface HomeBannerRepository extends MongoRepository<HomeBanner,String> {

   HomeBanner findByName(String name);

   List<HomeBanner> findAllByStatus(Integer status);

   List<HomeBanner> findAll();
}

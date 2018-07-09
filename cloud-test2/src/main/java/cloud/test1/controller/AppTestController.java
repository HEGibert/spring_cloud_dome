package cloud.test1.controller;

import cloud.test1.service.HomeBannerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by hefan on 2018/5/2.
 */
@RestController
public class AppTestController {

    private final Logger log = LoggerFactory.getLogger(AppTestController.class);


    @Autowired
    private HomeBannerService homeBannerService;

    @RequestMapping(value = "hello",method = RequestMethod.GET)
    public String index(){
        log.info("test2");
        return "hello world";
    }

   @RequestMapping(value = "save/homebanner",method = RequestMethod.POST)
   public String saveHomeBanner(){
        homeBannerService.saveHomeBanner();

        return "seccess";
   }

   @RequestMapping(value = "find/homebanner/byname",method = RequestMethod.GET)
   public Object findHomeBanner(@RequestParam(value = "name")String name){

        return homeBannerService.findHomeBanner(name);
   }

    @RequestMapping(value = "find/homebanner",method = RequestMethod.GET)
    public Object findHomeBanner(){

        return homeBannerService.findHomeBanner();
    }

}

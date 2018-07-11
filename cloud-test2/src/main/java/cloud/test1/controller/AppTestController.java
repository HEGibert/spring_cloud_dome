package cloud.test1.controller;

import cloud.test1.domain.entity.HomeBanner;
import cloud.test1.model.view.UserDTO;
import cloud.test1.service.HomeBannerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

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
   public String saveHomeBanner(@RequestBody HomeBanner homeBanner){
        homeBannerService.saveHomeBanner(homeBanner);

        return "seccess";
   }

   @RequestMapping(value = "find/homebanner/byname",method = RequestMethod.GET)
   public Object findHomeBanner(@RequestParam(value = "name")String name){

        return homeBannerService.findHomeBanner(name);
   }

    @RequestMapping(value = "find/homebanner/bystatus",method = RequestMethod.GET)
    public Object findHomeBannerListByStatus(){

        return homeBannerService.findHomeBannersByStatus();
    }

    @RequestMapping(value = "find/homebanner",method = RequestMethod.GET)
    public Object findHomeBannerList(){

        return homeBannerService.findHomeBannersByStatus();
    }

    //测试Query  Criteria
    @RequestMapping(value = "find/homebanner/query",method = RequestMethod.GET)
    public Object findHomeBanner(){

        return homeBannerService.findHomeBanner();
    }

    @RequestMapping(value = "test/valid",method = RequestMethod.POST)
    public Object testValid(@Valid @RequestBody UserDTO userDTO, BindingResult result){
        if (result.hasErrors()){
            List<ObjectError> errorList = result.getAllErrors();
            for(ObjectError error : errorList){
                System.out.println(error.getDefaultMessage());
            }
        }
        return "seccess";
    }

}

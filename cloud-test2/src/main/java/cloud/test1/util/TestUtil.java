package cloud.test1.util;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

import java.io.IOException;

public class TestUtil {

    //查询电话号码属地
    public static void main(String[] args){

        try {
            String str = HttpUtil.httpGet("https://tcc.taobao.com/cc/json/mobile_tel_segment.htm?tel=18220063023");
            String strinfo = str.substring(str.indexOf("{"));
            try {
                JSONObject jsonObject = new JSONObject(strinfo);
                if (jsonObject.get("province").equals("陕西")){
                    System.out.println("电话为"+strinfo);
                }else {
                    System.out.println("不是陕西的");
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}

package cloud.test1.util;


import okhttp3.*;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Map;

public class HttpUtil {


    public static final String SIGN_AND = "&";

    public static final String SIGN_EQUAL = "=";

    public static final String SIGN_QUESTION_MARK = "?";

    public static final String METHOD_POST="POST";

    public static final MediaType MEDIA_TYPE_JSON = MediaType.parse("application/json; charset=utf-8");

    public static final MediaType MEDIA_TYPE_FORM = MediaType.parse("application/x-www-form-urlencoded; charset=utf-8");

    private static final OkHttpClient client = new OkHttpClient.Builder().build();

    public OkHttpClient getClient() {
        return client;
    }


    public static String sendGet(String url, String param) {
        StringBuffer result = new StringBuffer();
        BufferedReader in = null;
        try {
            String urlNameString = url + "?" + param;
            URL realUrl = new URL(urlNameString);
            // 打开和URL之间的连接
            URLConnection connection = realUrl.openConnection();
            // 设置通用的请求属性
            connection.setRequestProperty("accept", "*/*");
            connection.setRequestProperty("connection", "Keep-Alive");
            connection.setRequestProperty("user-agent",
                    "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
            // 建立实际的连接
            connection.connect();
            // 获取所有响应头字段
            Map<String, List<String>> map = connection.getHeaderFields();
            // 遍历所有的响应头字段
            for (String key : map.keySet()) {
                System.out.println(key + "--->" + map.get(key));
            }
            // 定义 BufferedReader输入流来读取URL的响应
            in = new BufferedReader(new InputStreamReader(
                    connection.getInputStream()));
            String line;
            while ((line = in.readLine()) != null) {
                result.append(line);
            }
        } catch (Exception e) {
            System.out.println("发送GET请求出现异常！" + e);
            e.printStackTrace();
        }
        // 使用finally块来关闭输入流
        finally {
            try {
                if (in != null) {
                    in.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
     return result.toString();
    }




        public static String httpGet(String url) throws IOException {
            Request request = new Request.Builder().url(url).build();
            try (Response response = client.newCall(request).execute()) {
                if (response.isSuccessful()) {
                    return response.body().string();
                } else {
                    throw new IOException("Unexpected code " + response);
                }
            }
        }

        public static String httpPostByJson(String url, String body) throws IOException {
            RequestBody requestBody = RequestBody.create(MEDIA_TYPE_JSON, body);
            Request request = new Request.Builder().url(url).post(requestBody).build();

            try (Response response = client.newCall(request).execute()) {
                if (response.isSuccessful()) {
                    return response.body().string();
                } else {
                    throw new IOException("Unexpected code " + response);
                }
            }
        }

        public static String httpPostByForm(String url, Map<String,String> form) throws IOException {
            if (form==null||form.size()==0){
                throw new RuntimeException("form value empty");
            }
            FormBody.Builder builder= new FormBody.Builder();
            for (String key:form.keySet()){
                builder.add(key,form.get(key));
            }

            Request request = new Request.Builder().url(url).post(builder.build()).build();

            try (Response response = client.newCall(request).execute()) {
                if (response.isSuccessful()) {
                    return response.body().string();
                } else {
                    throw new IOException("Unexpected code " + response);
                }
            }
        }

        public String getRequestBody(HttpServletRequest request){
            if(METHOD_POST.equals(request.getMethod())){
                try {
                    String requestBody= StringUtil.readStringFromBufferedReader(request.getReader());
                    if(requestBody==null){
                        //throw new AppRuntimeException(OperationCode.BUFFER_READ_ERROR);
                    }
                    return requestBody;
                } catch (IOException e) {
                  //  throw new AppRuntimeException(OperationCode.BUFFER_READ_ERROR);
                }
            }
           // throw new AppRuntimeException(OperationCode.BUFFER_METHOD_ERROR);
            return null;
        }



        public static void main(String[] args) throws IOException {
            String url="http://localhost/index.php?g=home&m=ads&a=new_ads";

//        String user= JsonUtil.writeValue(new User("123456", "12345a"));
//        Map<String,String> form =new HashMap<>();
//        form.put("user",user);
//        //        String body="[{\"user\":{\"mobile\":\"123456\",\"password\":\"三文鱼\"}}]";
//        System.out.println(new HttpUtil().httpPostByForm(url,form));;
        }




}

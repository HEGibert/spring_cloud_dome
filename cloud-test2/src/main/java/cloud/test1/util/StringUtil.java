package cloud.test1.util;


import java.io.BufferedReader;
import java.io.IOException;

public class StringUtil {
    public static String readStringFromBufferedReader(BufferedReader br) {
        String inputLine;
        String str = "";
        try {
            while ((inputLine = br.readLine()) != null) {
                str += inputLine;
            }
        } catch (IOException e) {
            str=null;
        }finally {
            try {
                br.close();
            } catch (IOException e) {
            }

        }

        return str;
    }

    public static boolean isBlank(String str){
        int strLen;
        if (str == null || (strLen = str.length()) == 0) {
            return true;
        }
        for (int i = 0; i < strLen; i++) {
            if (!Character.isWhitespace(str.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    public static boolean isNotBlank(String str){
        return !isBlank(str);
    }

    public static boolean isEmpty(String str){
        return str == null || str.length() == 0;
    }

    public static boolean isNotEmpty(String str){
        return !isEmpty(str);
    }
}

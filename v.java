import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import sun.net.www.protocol.http.HttpURLConnection;


public class  v{
    public static void main(String[] args){
        String r;
        try {
            URL url = new URL("http://app.bilibili.com/");
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
            int responseCode= urlConnection.getResponseCode();
            if(responseCode == 200){
                BufferedReader reader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream(), "utf-8"));
                while((r=reader.readLine())!=null){
                    System.out.println(r);
                }
            }else{
                System.out.println("获取不到源代码 ，服务器响应代码为："+responseCode);
            }
        } catch (Exception e) {
            System.out.println("获取不到网页源码："+e);
        }
    }
}

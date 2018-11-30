import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class J {

    //通过jdbc连接数据库
    private static Connection getConn() {

        String driver = "com.mysql.cj.jdbc.Driver";
        //下面的变量设置根据自己的情况
        String url = "jdbc:mysql://localhost/3306"; 
        String username = "root";
        String password = "";

        Connection conn = null;


        try {
            Class.forName(driver); //classLoader,加载对应驱动
            conn = (Connection) DriverManager.getConnection(url + "? serverTimezone=GMT%2B8&useSSL=false&characterEncoding=utf-8", username, password);

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return conn;
    }
    static int insertkc( List<String> list1, List<String> list2,List<String> list3,List<String> list4  ) throws SQLException {

        Connection conn = getConn();
        try {
            conn.setAutoCommit(false);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        int i = 0;

       
        String sql = "insert into kc (kc,ls,sj,dd) values(?,?,?,?)";
        PreparedStatement pstmt;

        try {

            //表示预编译的sql对象，这里出现了问题....,插入数据到数据库时显示operation没有statement给它去做了==只插入了一行数据
            pstmt = (PreparedStatement) conn.prepareStatement(sql);

            for (int j = 0; j < 9; j++) {
                pstmt.setString(1, list1.get(j));
                pstmt.setString(2, list2.get(j));
                pstmt.setString(3, list3.get(j));
                pstmt.setString(4, list4.get(j));
                i = pstmt.executeUpdate();
                pstmt.close();
                conn.commit();
                conn.close();

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }


        return i;
    }




    public static ArrayList<String> getMatherSubstrs(String destStr, String regexStr) {
        Pattern pattern = Pattern.compile(regexStr);
        Matcher mather = pattern.matcher(destStr);
        ArrayList<String> res = new ArrayList<String>();
        while (mather.find()) {
            res.add(mather.group());
        }

        return res;
    }

    public static String getURLContent(String urlStr, String charset) {
        StringBuffer res = new StringBuffer();
        try {
            URL url = new URL(urlStr);

            BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream(), Charset.forName(charset)));
            String str = null;

            while ((str = br.readLine()) != null) {
                res.append(str);
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return res.toString();
    }

    public static void main(String[] args) {
        String destStr = getURLContent("http://jwzx.cqupt.edu.cn/kebiao/kb_stu.php?xh=2018211259", "utf-8");


        ArrayList<String> list = getMatherSubstrs(destStr, "<div class=\"printTable\">.*?</div>");
        ArrayList<String> list1 = new ArrayList<>();
        ArrayList<String> list2 = new ArrayList<>();
        ArrayList<String> list3 = new ArrayList<>();
        ArrayList<String> list4 = new ArrayList<>();
        for (String temp : list) {
            temp.replaceAll("[\\t\\n\\r]", "").replaceAll("\\s+", " ");
            Pattern p = Pattern.compile("<td >(.*?)</td>");
            Matcher m = p.matcher(temp);
            while (m.find()) {
                System.out.println("老师:" + m.group(1)); //打印组1
                String str = m.group(1);
                list1.add(str);
            }
            Pattern p1 = Pattern.compile("[1-3]'>([A,B]+[0-9]{7}.*?)</td>");
            Matcher m1 = p1.matcher(temp);
            while (m1.find()) {
                System.out.println("课程:" + m1.group(1)); //打印组1
                String str = m1.group(1);
                list2.add(str);
            }
            Pattern p2 = Pattern.compile("<td>([0-9]{4})</td>");
            Matcher m2 = p2.matcher(temp);
            while (m2.find()) {
                System.out.println("地点:" + m2.group(1)); //打印组1
                String str = m2.group(1);
                list3.add(str);
            }
            Pattern p3 = Pattern.compile("<td>(星.*?)</td>");
            Matcher m3 = p3.matcher(temp);
            while (m3.find()) {
                System.out.println("时间:" + m3.group(1)); //打印组1
                String str = m3.group(1);
                list4.add(str);          }
    }

        try {
            insertkc(list2,list1,list4,list3);
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }
}




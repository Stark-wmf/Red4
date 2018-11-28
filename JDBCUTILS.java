import java.sql.*;
import java.sql.DriverManager;
import java.sql.ResultSet;

public class JDBCUTILS {
    // 获取数据库的连接
    static{
        //加载JDBC驱动程序         
        try{
            String diverName="com.mysql.cj.jdbc.Driver";
            Class.forName(diverName);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public static Connection getConnection(){
        Connection con = null;
        try{
            con = DriverManager.getConnection("jdbc:mysql://localhost/3306"+"? serverTimezone=GMT%2B8&useSSL=false&characterEncoding=utf-8","root","");

        }catch (Exception e){ e.printStackTrace(); }
        return con;}


    public static void queryyg (){
        Connection conn = JDBCUTILS.getConnection();
        String sql = "select y.Yname ,Bname ,y.Ytel ,y.Yaddress ,y.Yage ,y.Yjob from yuangong y, bumen b where y.Yb = b.Bid";
        PreparedStatement pstmt;
        try {
            pstmt = (PreparedStatement) conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            int col = rs.getMetaData().getColumnCount();


            while (rs.next()) {
                for (int i = 1; i <= col; i++) {
                    System.out.print(rs.getString(i) + "\t");
                }
                System.out.println("");
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void querysp (){
        Connection conn = JDBCUTILS.getConnection();
        String sql = "select s.Sname ,c.Cname ,s.Scost ,s.Sprice ,s.Jnameint from shangping s, cangku c where s.Cid = c.Cid";
        PreparedStatement pstmt;
        try {
            pstmt = (PreparedStatement) conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            int col = rs.getMetaData().getColumnCount();


            while (rs.next()) {
                for (int i = 1; i <= col; i++) {
                    System.out.print(rs.getString(i) + "\t");
                }
                System.out.println("");
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void queryspSx (){
        Connection conn = JDBCUTILS.getConnection();
        String sql = "select * from shangping  order by Sprice asc";
        PreparedStatement pstmt;
        try {
            pstmt = (PreparedStatement) conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            int col = rs.getMetaData().getColumnCount();


            while (rs.next()) {
                for (int i = 1; i <= col; i++) {
                    System.out.print(rs.getString(i) + "\t");
                }
                System.out.println("");
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void queryspJx (){
        Connection conn = JDBCUTILS.getConnection();
        String sql = "select * from shangping  order by Sprice desc";
        PreparedStatement pstmt;
        try {
            pstmt = (PreparedStatement) conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            int col = rs.getMetaData().getColumnCount();


            while (rs.next()) {
                for (int i = 1; i <= col; i++) {
                    System.out.print(rs.getString(i) + "\t");
                }
                System.out.println("");
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void queryspMH (){
        Connection conn = JDBCUTILS.getConnection();
        String sql = "select * from shangping where Sname like '___'";
        PreparedStatement pstmt;
        try {
            pstmt = (PreparedStatement) conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            int col = rs.getMetaData().getColumnCount();


            while (rs.next()) {
                for (int i = 1; i <= col; i++) {
                    System.out.print(rs.getString(i) + "\t");
                }
                System.out.println("");
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    // 插入
    public static int insertsp() {
        Connection conn = JDBCUTILS.getConnection();
        int i = 0;
        String sql = "insert into shangping (Sid,Sname,Scost,Sprice,Jnameint,Cid) values(?,?,?,?,?,?)";
        PreparedStatement pstmt;
        try {
            pstmt = (PreparedStatement) conn.prepareStatement(sql);
            pstmt.setObject(1,2008);
            pstmt.setObject(2,"奥利奥");
            pstmt.setObject(3,5);
            pstmt.setObject(4,6);
            pstmt.setObject(5,"阿里");
            pstmt.setObject(6,4001);
            i = pstmt.executeUpdate();
            pstmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return i;
    }
    public static int insertyg() {
        Connection conn = JDBCUTILS.getConnection();
        int i = 0;
        String sql = "insert into yuangong (Yid,Yname,Yjob,Ytel,Yaddress,Yage,Yb) values(?,?,?,?,?,?,?)";
        PreparedStatement pstmt;
        try {
            pstmt = (PreparedStatement) conn.prepareStatement(sql);
            pstmt.setObject(1,6);
            pstmt.setObject(2,"钢铁侠");
            pstmt.setObject(3,"员工");
            pstmt.setObject(4,138);
            pstmt.setObject(5,"美国");
            pstmt.setObject(6,38);
            pstmt.setObject(7,1001);
            i = pstmt.executeUpdate();
            pstmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return i;
    }


    // 修改
    public static int updatesp() {
        Connection conn = JDBCUTILS.getConnection();
        int i = 0;
        String sql = "update shangping set Scost = 3,Sprice = 4 where Sid = 2003";
        PreparedStatement pstmt;
        try {
            pstmt = (PreparedStatement) conn.prepareStatement(sql);
            i = pstmt.executeUpdate();
            pstmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return i;
    }
    public static int updateyg() {
        Connection conn = JDBCUTILS.getConnection();
        int i = 0;
        String sql = "update yuangong set Yjob = '副主管',Yage = 20 where Yid = 4";
        PreparedStatement pstmt;
        try {
            pstmt = (PreparedStatement) conn.prepareStatement(sql);
            i = pstmt.executeUpdate();
            pstmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return i;
    }


    // 删除
    public static int deletesp() {
        Connection conn = JDBCUTILS.getConnection();
        int i = 0;
        String sql = "delete from shangping where Sid=2005";
        PreparedStatement pstmt;
        try {
            pstmt = (PreparedStatement) conn.prepareStatement(sql);
            i = pstmt.executeUpdate();
            pstmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return i;
    }
    public static int deleteyg() {
        Connection conn = JDBCUTILS.getConnection();
        int i = 0;
        String sql = "delete from yuangong where Yid=5";
        PreparedStatement pstmt;
        try {
            pstmt = (PreparedStatement) conn.prepareStatement(sql);
            i = pstmt.executeUpdate();
            pstmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return i;
    }


    // 用于测试的main方法
    public static void main(String[] args) {
//没有多写插入方法，因为感觉部门、仓库、进货商一般不会变太多。另外就是（偷懒）觉得知道这个功能怎么做了以后..感觉其他几个写下去有点重造轮子的感觉...
//        JDBCUTILS.insertyg();
//        JDBCUTILS.insertsp();
////更新也和上面一样没有写太多，以商品和员工为例，修改他们中一些元素
//        JDBCUTILS.updatesp();
//        JDBCUTILS.updateyg();
////删除也如上
//        JDBCUTILS.deletesp();
//        JDBCUTILS.deleteyg();
//查询时用了多表联查，可能理解的还不深或者是这个表比较简单，感觉左右内外连接感觉没有多少必要..
        System.out.println("-------下面是员工的查询-------");
        System.out.println("员工名   部门 电话 地址 年龄 职位");
        JDBCUTILS.queryyg();
        System.out.println("-------下面是商品的查询-------");
        System.out.println("商品名 仓库名 进价 价格 进货商");
        JDBCUTILS.querysp();
//提供了模糊查询的一种模糊情况
        System.out.println("-------下面是商品的模糊查询（商品名三位）-------");
        JDBCUTILS.queryspMH();
        System.out.println("-------下面是商品的升序查询-------");
        JDBCUTILS.queryspSx();
        System.out.println("-------下面是商品的降序查询-------");
        JDBCUTILS.queryspJx();
    }
}
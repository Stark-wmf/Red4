import java.sql.*;

public class Main {
    Connection con;
    Statement statement;
    ResultSet rs;

    public Connection getCon() {
        return con;
    }

    public Statement getStatement() {
        return statement;
    }

    public ResultSet getRs() {
        return rs;
    }

    public Main(Connection con) {
        this.con = con;
        try {
            statement = con.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void createTable() throws SQLException {
        String sql = "create table if not exists test(id int,name varchar(100))";
        statement.executeUpdate(sql);
    }

    public void update() throws SQLException {
        String sql = "update test set name=? where id=? ";
        PreparedStatement ptmt = (PreparedStatement) con.prepareStatement(sql);
        ptmt.executeUpdate();
    }

    public void insert(String id,String name) throws SQLException {
        String sql = "insert into test(id,name)values(?,?)";
        PreparedStatement ptmt = (PreparedStatement) con.prepareStatement(sql);
        ptmt.setString(1,id);
        ptmt.setString(2,name);
        ptmt.executeUpdate();
    }
        public void select () throws SQLException {
            String sql = "select id,name from test";
            rs = statement.executeQuery(sql);
            while (rs.next()) {
                String id = rs.getString("id");
                String name = rs.getString("name");
                System.out.println(id + "\t" + name);
            }
        }
        public static void main (String[]args){
            Connection con = JDBCUtil.getConnection();
            Main main = new Main(con);
            try {
                main.createTable();
                main.insert("1","hc");
                main.select();
                main.update();
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                JDBCUtil.close(main.getRs(), main.getStatement(), main.getCon());
            }
        }
    }


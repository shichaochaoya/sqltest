import java.sql.*;

public class SqlTest {
    private static final String driver = "com.mysql.jdbc.Driver";
    private static final String url = "jdbc:mysql://localhost:3306/mysql_demo？useSSL=false";
    private static final String user = "root";
    private static final String password = "root";

    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("连接数据库。。。");
            conn = DriverManager.getConnection(url,user,password);

            System.out.println("实例化对象");
            stmt = conn.createStatement();
            String sql;
            sql = "SELECT id,name,url FROM teacher";
            ResultSet resultSet = stmt.executeQuery(sql);

            while (resultSet.next()) {
            int id = resultSet.getInt("Tid");
            String name = resultSet.getString("Tname");
                String uname = resultSet.getString("username");
                System.out.println(id+name+uname);
            }
            resultSet.close();
            stmt.close();
            conn.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

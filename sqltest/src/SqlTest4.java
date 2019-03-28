import java.sql.*;

public class SqlTest4 {
    public static void main(String[] args) {
        String driverName = "com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/mysql_demo?useSSL=false&serverTimezone=GMT%2B8";
        String username = "root";
        String password = "root";
        Connection conn = null;
        try {
            Class.forName(driverName);
            conn = DriverManager.getConnection(url, username, password);
            String sql = "SELECT Tid,Tname,username,password FROM teacher WHERE username= '" + username + "'AND password ='" + password + "'";
            PreparedStatement pstm = conn.prepareStatement(sql);
            ResultSet resultSet = pstm.executeQuery();

            System.out.println(resultSet);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}

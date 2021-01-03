import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class test {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver"); // 注册数据库驱动
        String url = "jdbc:mysql://localhost:3306/jsu?user=root&password=&useSSL=true&serverTimezone=GMT%2B8";
        Connection con = DriverManager.getConnection(url); // 获取数据库连接
        System.out.println("用户名是" + con.getMetaData().getUserName());
        System.out.println(con);
    }
}

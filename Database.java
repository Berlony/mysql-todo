import java.sql.DriverManager;
import java.sql.Connection;

public class Database {

    public static Connection getInstance() throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3306/ravenmk?characterEncoding=utf8";
        String username = "root";
        String password = "root";
        Connection con = DriverManager.getConnection(url, username, password);

        return con;
    }

}

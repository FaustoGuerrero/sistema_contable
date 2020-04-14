package ConexionBD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class ConBD {
    public static final String URL = "jdbc:mysql://localhost:3306/buxgalter";
    public static final String USERNAME = "root";
    public static final String PASSWORD = "1234";


    public Connection getConection() {
        Connection con = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = (Connection) DriverManager.getConnection(URL, USERNAME, PASSWORD);              
           // System.out.println("Conectados");
        } catch (ClassNotFoundException | SQLException e) {
            JOptionPane.showMessageDialog(null, "Ошибка при подключении к базе данных "+e , "СИСТЕМА", JOptionPane.ERROR_MESSAGE);
        }
        return con;
    }
}

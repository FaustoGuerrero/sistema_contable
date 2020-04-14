package ConexionBD;

import com.mysql.jdbc.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class ConsultaSqlDataIn {
    public int[][] datos;
    public void llenarDatos(String[] pokaz, int nrows, int ncolumns) {
        datos =new int[nrows][ncolumns];
        try {
            Connection con = null;
            con = new ConBD().getConection();
            PreparedStatement ps;
            ResultSet rs;
            for (int i = 0; i < pokaz.length; i++) {
                ps = (PreparedStatement) con.prepareStatement("SELECT Za2016,Za2017,Za2018 FROM datain WHERE Kod = ?;");
                ps.setString(1, pokaz[i]);              
                rs = ps.executeQuery();
                while (rs.next()) {
                    datos[i][0] = (int)rs.getDouble("Za2016");
                    datos[i][1] = (int)rs.getDouble("Za2017");
                    datos[i][2] = (int)rs.getDouble("Za2018");
                }
            }
            con.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Ошибка при подключении, проверьте данные!" + ex, "ВНИМАНИЕ", JOptionPane.ERROR_MESSAGE);
        }              
    }
    
    
}

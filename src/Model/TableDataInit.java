package Model;

import ConexionBD.ConBD;
import com.mysql.jdbc.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class TableDataInit {

    private String kod;
    private int za2016, za2017, za2018;

    public TableDataInit(String kod, int za2016, int za2017, int za2018) throws SQLException {
        this.kod = kod;
        this.za2016 = za2016;
        this.za2017 = za2017;
        this.za2018 = za2018;
        actualizarDatos();
    }

    public String getKod() {
        return kod;
    }

    public void setKod(String kod) {
        this.kod = kod;
    }

    public int getZa2016() {
        return za2016;
    }

    public void setZa2016(int za2016) {
        this.za2016 = za2016;
    }

    public int getZa2017() {
        return za2017;
    }

    public void setZa2017(int za2017) {
        this.za2017 = za2017;
    }

    public int getZa2018() {
        return za2018;
    }

    public void setZa2018(int za2018) {
        this.za2018 = za2018;
    }

    private void actualizarDatos() throws SQLException {
        try {
            Connection con = null;
            con = (Connection) new ConBD().getConection();
            PreparedStatement ps;            
            ps = con.prepareStatement("UPDATE datain SET Za2016 = ?, Za2017 = ?, Za2018 = ?  WHERE Kod = ?;");
                    ps.setInt(1, getZa2016());
                    ps.setInt(2, getZa2017());
                    ps.setInt(3, getZa2018());
                    ps.setString(4, getKod());
                    ps.executeUpdate(); 
                    System.out.println("actualizado "+getKod());
            con.close();           
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Ошибка при подключении, проверьте данные!" + ex, "ВНИМАНИЕ", JOptionPane.ERROR_MESSAGE);
        }
    }
}

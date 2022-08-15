package co.edu.utp.misiontic2022.c2.reto5.model.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import co.edu.utp.misiontic2022.c2.reto5.model.vo.CasaCampestreVo;
import co.edu.utp.misiontic2022.c2.reto5.util.JDBCUtilities;

public class CasaCampestreDao {
    public ArrayList<CasaCampestreVo> listar() throws SQLException {
        ArrayList<CasaCampestreVo> resultado = new ArrayList<CasaCampestreVo>();

        Connection conn = JDBCUtilities.gConnection();

        try {
            String sql =    "SELECT p.ID_Proyecto , p.Constructora , p.Numero_Habitaciones , p.Ciudad " +
                            "FROM Proyecto p " +
                            "WHERE p.Ciudad In('Santa Marta' , 'Cartagena' , 'Barranquilla') " +
                            "AND p.Clasificacion = 'Casa Campestre'; ";

        Statement stmt = conn.createStatement();
        ResultSet rset = stmt.executeQuery(sql);

        while (rset.next()) {
            CasaCampestreVo casaCampestre = new CasaCampestreVo(
                rset.getInt("ID_Proyecto"),
                rset.getString("Constructora"),
                rset.getDouble("Numero_Habitaciones"),
                rset.getString("Ciudad")
            );

        resultado.add(casaCampestre);
        }

        stmt.close();
        rset.close();

        } finally {
            if (conn != null) {
                conn.close();
            }
        }

        return resultado;
    }
}

package co.edu.utp.misiontic2022.c2.reto5.model.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import co.edu.utp.misiontic2022.c2.reto5.model.vo.LiderPorCiudadVo;
import co.edu.utp.misiontic2022.c2.reto5.util.JDBCUtilities;

public class LiderPorCiudadDao {
    
    public ArrayList<LiderPorCiudadVo> listar() throws SQLException {
        ArrayList<LiderPorCiudadVo> resultado = new ArrayList<LiderPorCiudadVo>();

        Connection conn = JDBCUtilities.gConnection();

        try {
            String sql =    "SELECT l.ID_Lider, l.Nombre , l.Primer_Apellido , l.Ciudad_Residencia " +
                            "FROM Lider l " +
                            "ORDER BY l.Ciudad_Residencia; ";

            Statement stmt = conn.createStatement();
            ResultSet rset = stmt.executeQuery(sql);

            while (rset.next()) {
                LiderPorCiudadVo lider = new LiderPorCiudadVo(
                    rset.getInt("ID_Lider"),
                    rset.getString("Nombre"),
                    rset.getString("Primer_Apellido"),
                    rset.getString("Ciudad_Residencia")
                    );

            resultado.add(lider);

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

package co.edu.utp.misiontic2022.c2.reto5.model.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import co.edu.utp.misiontic2022.c2.reto5.model.vo.ComprasProyectoVo;
import co.edu.utp.misiontic2022.c2.reto5.util.JDBCUtilities;

public class ComprasProyectoDao {
    public ArrayList<ComprasProyectoVo> listar() throws SQLException {
        ArrayList<ComprasProyectoVo> resultado = new ArrayList<ComprasProyectoVo>();

        Connection conn = JDBCUtilities.gConnection();

        try {
            String sql = "SELECT c.ID_Compra , p.Constructora , p.Banco_Vinculado " +
                            "FROM Compra c " +
                            "JOIN Proyecto p ON (p.ID_Proyecto = c.ID_Proyecto) " +
                            "WHERE p.ciudad = 'Salento' AND c.Proveedor = 'Homecenter';";

        Statement stmt = conn.createStatement();
        ResultSet rset = stmt.executeQuery(sql);

        while (rset.next()) {
            ComprasProyectoVo compraProyecto = new ComprasProyectoVo(
                rset.getInt("ID_Compra"),
                rset.getString("Constructora"),
                rset.getString("Banco_Vinculado")
            );
        resultado.add(compraProyecto);
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

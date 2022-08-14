package co.edu.utp.misiontic2022.c2.reto5.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCUtilities {

    private static final String RUTA_BD = "ProyectosConstruccion.db";

    public static Connection gConnection() throws SQLException {
        String url = "jdbc:sqlite:" + RUTA_BD;
        return DriverManager.getConnection(url);
    }
}

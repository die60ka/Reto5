package co.edu.utp.misiontic2022.c2.reto5.controller;

import java.sql.SQLException;
import java.util.ArrayList;

import co.edu.utp.misiontic2022.c2.reto5.model.dao.CasaCampestreDao;
import co.edu.utp.misiontic2022.c2.reto5.model.dao.ComprasProyectoDao;
import co.edu.utp.misiontic2022.c2.reto5.model.dao.LiderPorCiudadDao;
import co.edu.utp.misiontic2022.c2.reto5.model.vo.CasaCampestreVo;
import co.edu.utp.misiontic2022.c2.reto5.model.vo.ComprasProyectoVo;
import co.edu.utp.misiontic2022.c2.reto5.model.vo.LiderPorCiudadVo;

public class RequerimientoController {
    private final LiderPorCiudadDao liderPorCiudadDao;
    private final CasaCampestreDao casaCampestreDao;
    private final ComprasProyectoDao comprasProyectoDao;

    public RequerimientoController() {
        liderPorCiudadDao = new LiderPorCiudadDao();
        casaCampestreDao = new CasaCampestreDao();
        comprasProyectoDao = new ComprasProyectoDao();
    }

    public ArrayList<LiderPorCiudadVo> consultarLiderPorCiudad() throws SQLException {
        return liderPorCiudadDao.listar();
    }

    public ArrayList<CasaCampestreVo> consultarCasaCampestre() throws SQLException {
        return casaCampestreDao.listar();
    }

    public ArrayList<ComprasProyectoVo> consultarComprasProyecto() throws SQLException {
        return comprasProyectoDao.listar();
    }
}

package co.edu.utp.misiontic2022.c2.reto5.controller;

import java.sql.SQLException;
import java.util.ArrayList;

import co.edu.utp.misiontic2022.c2.reto5.model.dao.LiderPorCiudadDao;
import co.edu.utp.misiontic2022.c2.reto5.model.vo.LiderPorCiudadVo;

public class RequerimientoController {
    private final LiderPorCiudadDao liderPorCiudadDao;

    public RequerimientoController() {
        liderPorCiudadDao = new LiderPorCiudadDao();
    }

    public ArrayList<LiderPorCiudadVo> consultarLiderPorCiudad() throws SQLException {
        return liderPorCiudadDao.listar();
    }

}

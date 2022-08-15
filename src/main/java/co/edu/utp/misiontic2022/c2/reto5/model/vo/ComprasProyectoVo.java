package co.edu.utp.misiontic2022.c2.reto5.model.vo;

public class ComprasProyectoVo {
    private Integer idcompra;
    private String constructora;
    private String banco;

    public ComprasProyectoVo() {
    }

    public ComprasProyectoVo(Integer idcompra, String constructora, String banco) {
        this.idcompra = idcompra;
        this.constructora = constructora;
        this.banco = banco;
    }

    public Integer getIdcompra() {
        return idcompra;
    }

    public void setIdcompra(Integer idcompra) {
        this.idcompra = idcompra;
    }

    public String getConstructora() {
        return constructora;
    }

    public void setConstructora(String constructora) {
        this.constructora = constructora;
    }

    public String getBanco() {
        return banco;
    }
    
    public void setBanco(String banco) {
        this.banco = banco;
    }


}

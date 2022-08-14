package co.edu.utp.misiontic2022.c2.reto5.model.vo;

public class LiderPorCiudadVo {
    
    private Integer idLider;
    private String nombre;
    private String apellido;
    private String ciudad;

    
    
    public LiderPorCiudadVo() {
    }

    public LiderPorCiudadVo(Integer idLider, String nombre, String apellido, String ciudad) {
        this.idLider = idLider;
        this.nombre = nombre;
        this.apellido = apellido;
        this.ciudad = ciudad;
    }

    public Integer getIdLider() {
        return idLider;
    }

    public void setIdLider(Integer idLider) {
        this.idLider = idLider;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }


}

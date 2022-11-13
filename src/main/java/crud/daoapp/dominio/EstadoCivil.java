package crud.daoapp.dominio;

public class EstadoCivil {
    
    private int idestadocivil;
    private String estadocivil;

    public EstadoCivil(int idestadocivil, String estadocivil) {
        this.idestadocivil = idestadocivil;
        this.estadocivil = estadocivil;
    }

    public EstadoCivil() {
    }

    public int getIdestadocivil() {
        return idestadocivil;
    }

    public void setIdestadocivil(int idestadocivil) {
        this.idestadocivil = idestadocivil;
    }

    public String getEstadocivil() {
        return estadocivil;
    }

    public void setEstadocivil(String estadocivil) {
        this.estadocivil = estadocivil;
    }
    
    @Override
    public String toString(){
        return idestadocivil + " " + estadocivil;
    }
    
}

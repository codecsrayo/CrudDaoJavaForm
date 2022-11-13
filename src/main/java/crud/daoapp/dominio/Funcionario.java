package crud.daoapp.dominio;

public class Funcionario {

    public Funcionario(String idfuncionario, String nombres, String apellidos, String celular, int idestadocivil, int idsexo, String fechanacimiento, String direccion, int idciudad) {
        this.idfuncionario = idfuncionario;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.celular = celular;
        this.idestadocivil = idestadocivil;
        this.idsexo = idsexo;
        this.fechanacimiento = fechanacimiento;
        this.direccion = direccion;
        this.idciudad = idciudad;
        
    }
       
    public Funcionario(){
    }
    
    private String idfuncionario;
    private String nombres;
    private String apellidos;
    private String celular;
    private int idestadocivil;
    private int idsexo;
    private String fechanacimiento;
    private String direccion;
    private int idciudad;

    public String getIdfuncionario() {
        return idfuncionario;
    }

    public void setIdfuncionario(String idfuncionario) {
        this.idfuncionario = idfuncionario;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public int getIdestadocivil() {
        return idestadocivil;
    }

    public void setIdestadocivil(int idestadocivil) {
        this.idestadocivil = idestadocivil;
    }

    public int getIdsexo() {
        return idsexo;
    }

    public void setIdsexo(int idsexo) {
        this.idsexo = idsexo;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getIdciudad() {
        return idciudad;
    }

    public void setIdciudad(int idciudad) {
        this.idciudad = idciudad;
    }

    public String getFechanacimiento() {
        return fechanacimiento;
    }

    public void setFechanacimiento(String fechanacimiento) {
        this.fechanacimiento = fechanacimiento;
    }       
}

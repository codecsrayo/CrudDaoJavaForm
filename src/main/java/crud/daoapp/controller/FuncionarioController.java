package crud.daoapp.controller;

import crud.daoapp.dao.FuncionarioDao;
import crud.daoapp.dominio.Funcionario;
import java.sql.SQLException;
import java.util.List;

public class FuncionarioController {
    
    private final FuncionarioDao funcionariodao;

    public FuncionarioController() {
        
        funcionariodao = new FuncionarioDao();
    }
    
    public void crearFuncionario(Funcionario funcionario) throws SQLException{
        funcionariodao.crearFuncionario(funcionario);
    }
    
    public List<Funcionario> obtenerFuncionarios()throws SQLException{   
        return funcionariodao.obtenerFuncionarios();
    }
    
  
    public Funcionario obtenerFuncionario(String idfuncionario) throws SQLException{
    
        return funcionariodao.obtenerFuncionario(idfuncionario);
    }
    
    public void actualizarFuncionario(String idfuncionario, Funcionario funcionario) throws SQLException{
        
        funcionariodao.actualizarFuncionario(idfuncionario, funcionario);
    }
    
    public void eliminarFuncionario(String idfuncionario) throws SQLException{
    
        funcionariodao.eliminarFuncionario(idfuncionario);
    }
}

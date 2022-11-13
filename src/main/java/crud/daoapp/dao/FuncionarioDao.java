package crud.daoapp.dao;

import crud.daoapp.conexion.Conectar;
import crud.daoapp.dominio.Funcionario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class FuncionarioDao {
    
    private static final String GETFUNCIONARIOS = "SELECT * FROM infofuncionario;";
    private static final String CREATEFUNCIONARIO = "INSERT INTO infofuncionario"
                            +"(idfuncionario, nombres, apellidos, celular, idestadocivil, idsexo, fechanacimiento, direccion, idciudad)"
                            +"VALUES(?,?,?,?,?,?,?,?,?)";
    private static final String GETFUNCIONARIOBYID = "SELECT * FROM infofuncionario WHERE idfuncionario = ?";
    private static final String UPDATEFUNCIONARIO = "UPDATE infofuncionario"
                +" SET nombres= ?, apellidos= ?, celular= ?, idestadocivil= ?, idsexo= ?, fechanacimiento= ?, direccion= ?, idciudad= ? WHERE idfuncionario= ?";
    private static final String DELETEFUNCIONARIO = "DELETE FROM infofuncionario WHERE idfuncionario= ?";
    
    public void crearFuncionario (Funcionario funcionario) throws SQLException{
        
        Connection connection = null;
        PreparedStatement pstm = null;
        try {
            connection = Conectar.getConnection();
            pstm = connection.prepareCall(CREATEFUNCIONARIO);
            pstm.setString(1, funcionario.getIdfuncionario());
            pstm.setString(2, funcionario.getNombres());
            pstm.setString(3, funcionario.getApellidos());
            pstm.setString(4, funcionario.getCelular());
            pstm.setString(5, String.valueOf(funcionario.getIdestadocivil()));
            pstm.setString(6, String.valueOf(funcionario.getIdsexo()));
            pstm.setString(7, funcionario.getFechanacimiento());
            pstm.setString(8, funcionario.getDireccion());
            pstm.setString(9, String.valueOf(funcionario.getIdciudad()));
            pstm.execute();
        } finally {
            if (pstm != null){
                pstm.close();
            }            
            if (connection != null){
                connection.close();
            }
        }  
    }

    public List<Funcionario> obtenerFuncionarios() throws SQLException{
        
        Connection connection = Conectar.getConnection();
        PreparedStatement pstm = null;
        ResultSet resultado = null;
        
        try {
            List<Funcionario> listafuncionarios = new ArrayList<>();
            pstm = connection.prepareStatement(GETFUNCIONARIOS);
            resultado = pstm.executeQuery();
            
            while(resultado.next()){
                
                Funcionario funcionario = new Funcionario();
                
                funcionario.setIdfuncionario(resultado.getString("idfuncionario"));
                funcionario.setNombres(resultado.getString("nombres"));
                funcionario.setApellidos(resultado.getString("apellidos"));
                funcionario.setCelular(resultado.getString("celular"));
                funcionario.setIdestadocivil(resultado.getInt("idestadocivil"));
                funcionario.setIdsexo(resultado.getInt("idsexo"));
                funcionario.setFechanacimiento(resultado.getString("fechanacimiento"));
                funcionario.setDireccion(resultado.getString("direccion"));
                funcionario.setIdciudad(resultado.getInt("idciudad"));
               
                listafuncionarios.add(funcionario);
                
            }

            return listafuncionarios;        
        } finally {
            if (pstm != null){
                pstm.close();
            }
            if (resultado!=null){
                resultado.close();
            }
            if (connection != null){
                connection.close();
            }
            
        }
    }
    
   
    public Funcionario obtenerFuncionario(String idfuncionario)throws SQLException{
    
        Connection connection = null;
        PreparedStatement pstm = null;
        ResultSet resultado = null;
        Funcionario funcionario = null;
        try {
            connection = Conectar.getConnection();
            pstm = connection.prepareStatement(GETFUNCIONARIOBYID);
            pstm.setString(1, idfuncionario);  //revisar el indice 0 o 1
            resultado = pstm.executeQuery();

            if (resultado.next()){
                funcionario = new Funcionario();
                funcionario.setIdfuncionario(resultado.getString("idfuncionario"));
                funcionario.setNombres(resultado.getString("nombres"));
                funcionario.setApellidos(resultado.getString("apellidos"));
                funcionario.setCelular(resultado.getString("celular"));
                funcionario.setIdestadocivil(resultado.getInt("idestadocivil"));
                funcionario.setIdsexo(resultado.getInt("idsexo"));
                funcionario.setFechanacimiento(resultado.getString("fechanacimiento"));
                funcionario.setDireccion(resultado.getString("direccion"));
                funcionario.setIdciudad(resultado.getInt("idciudad"));
            }          
          
            return funcionario;
            
        } finally {    
            if (pstm != null){
                pstm.close();
            }
            if (resultado!=null){
                resultado.close();
            }
            if (connection != null){
                connection.close();
            }
        }         
    }

    public void actualizarFuncionario (String idfuncionario, Funcionario funcionario) throws SQLException{
        
        Connection connection = null;
        PreparedStatement pstm = null;

        try {
            
            connection = Conectar.getConnection();
            pstm = connection.prepareStatement(UPDATEFUNCIONARIO);

            pstm.setString(1, funcionario.getNombres());
            pstm.setString(2, funcionario.getApellidos());
            pstm.setString(3, funcionario.getCelular());
            pstm.setInt(4, funcionario.getIdestadocivil());
            pstm.setInt(5, funcionario.getIdsexo());
            pstm.setString(6, funcionario.getFechanacimiento());
            pstm.setString(7, funcionario.getDireccion());
            pstm.setInt(8, funcionario.getIdciudad());
            pstm.setString(9, funcionario.getIdfuncionario());
            pstm.execute();
        } finally {
            if (pstm != null){
                pstm.close();
            }
            if (connection != null){
                connection.close();
            }            
        }
    }
    
    public void eliminarFuncionario (String idfuncionario)throws SQLException{
    
        Connection connection = null;
        PreparedStatement pstm = null;
        
        try {
            connection = Conectar.getConnection();
            pstm = connection.prepareStatement(DELETEFUNCIONARIO);
            pstm.setString(1, idfuncionario);  //revisar el indice 0 o 1
            pstm.execute();
        } finally {
            if (pstm != null){
                pstm.close();
            }
            if (connection != null){
                connection.close();
            }            
        }       
    }    
}

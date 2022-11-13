
package crud1.daoapp;

import crud.daoapp.controller.FuncionarioController;
import crud.daoapp.dominio.Funcionario;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DAOAPP {   
    
    public static void crearFuncionario (FuncionarioController funcionarioController){

        try {
            Scanner sc = new Scanner(System.in);
            System.out.println("Entre la identificación  del Funcionario");
            String idfuncionario = sc.nextLine();       
            System.out.println("-------------------");
            System.out.println("Entre los nombres del funcionario");
            String nombres = sc.nextLine();
            System.out.println("-------------------");
            System.out.println("Entre los apellidos del Funcionario");
            String apellidos = sc.nextLine();
            System.out.println("-------------------");
            System.out.println("Entre el numero de celular  del Funcionario");
            String celular = sc.nextLine();
            System.out.println("-------------------");
            System.out.println("Entre el estado civil del funcionario");
            System.out.println("1. Soltero");
            System.out.println("2. Casado");
            System.out.println("3. Divorsiado");
            System.out.println("4 Unión libre");
            int idestadocivil = sc.nextInt();
            System.out.println("-------------------");
            System.out.println("Entre el sexo del Funcionario");
            System.out.println("1. Masculino");
            System.out.println("2. Femenimo");
            int idsexo = sc.nextInt();
            sc.nextLine();
            System.out.println("-------------------");
            System.out.println("Entre la fecha de nacimiento del Funcionario yyyy/mm/dd");
            String fechanacimiento =sc.nextLine();
            System.out.println("-------------------");
            System.out.println("Entre la direccioin de residencia del Funcionario");
            String direccion = sc.nextLine();
            System.out.println("-------------------");
            System.out.println("Entre la ciudad de residencia del Funcionario");
            System.out.println("1. Rionegro");
            System.out.println("2. Medellín");
            int idciudad = sc.nextInt();
            sc.nextLine();
            System.out.println("-------------------");

            Funcionario funcionario = new Funcionario();
            funcionario.setIdfuncionario(idfuncionario);
            funcionario.setNombres(nombres);
            funcionario.setApellidos(apellidos);
            funcionario.setCelular(celular);
            funcionario.setIdestadocivil(idestadocivil);
            funcionario.setIdsexo(idsexo);
            funcionario.setFechanacimiento(fechanacimiento);
            funcionario.setDireccion(direccion);
            funcionario.setIdciudad(idciudad);

            funcionarioController.crearFuncionario(funcionario);
            
        } catch (SQLException ex) {
            System.out.println("");
            Logger.getLogger(DAOAPP.class.getName()).log(Level.WARNING, "Revise la entrada de datos");
            System.out.println("");
        }
    }
    
    public static void obtenerFuncionarios (FuncionarioController funcionarioController){
        try {
            List<Funcionario> listafuncionarios = funcionarioController.obtenerFuncionarios();
            
            if (listafuncionarios.isEmpty()){
                System.out.println("Lista vacia, no existen datos en la tabla");
            }else{
               listafuncionarios.forEach(funcionario -> {
                   System.out.println("Identificación = " + funcionario.getIdfuncionario());
                   System.out.println("Nombres = " + funcionario.getNombres());
                   System.out.println("Apellidos = " + funcionario.getApellidos());
                   System.out.println("Celular = " + funcionario.getCelular());
                   System.out.println("Estado Civil = " + funcionario.getIdestadocivil());
                   System.out.println("Sexo = " + funcionario.getIdsexo());
                   System.out.println("Fecha de Nacimiento = " + funcionario.getFechanacimiento());
                   System.out.println("Dirección de residencia = " + funcionario.getDireccion());
                   System.out.println("Ciudad de residencia = " + funcionario.getIdciudad());
                   System.out.println("------------------------------------------------------------------------");                 
                });
            }            
        } catch (SQLException e) {
            System.out.println("");
            System.out.println("Error al obtener funcionarios, revise la base de datos: " + e);
            System.out.println("");
       }
    }
    
    public static void actualizarFuncionario(FuncionarioController funcionarioController){

        try {
            Scanner sc = new Scanner(System.in);
            System.out.println("Entre la identificación  del Funcionario");
            String idfuncionario = sc.nextLine();
            
            Funcionario funcionarioExiste = funcionarioController.obtenerFuncionario(idfuncionario);
            
            if (funcionarioExiste == null){
                System.out.println("El funcionario no existe en ls BD");
                return;
            }
            
            System.out.println("-------------------");
            System.out.println("Entre los nombres del funcionario");
            String nombres = sc.nextLine();
            System.out.println("-------------------");
            System.out.println("Entre los apellidos del Funcionario");
            String apellidos = sc.nextLine();
            System.out.println("-------------------");
            System.out.println("Entre el numero de celular  del Funcionario");
            String celular = sc.nextLine();
            System.out.println("-------------------");
            System.out.println("Entre el estado civil del funcionario");
            System.out.println("1. Soltero");
            System.out.println("2. Casado");
            System.out.println("3. Divorsiado");
            System.out.println("4 Unión libre");
            int idestadocivil = sc.nextInt();
            System.out.println("Estado civil = " + idestadocivil);
            System.out.println("-------------------");
            System.out.println("Entre el sexo del Funcionario");
            System.out.println("1. Masculino");
            System.out.println("2. Femenimo");
            int idsexo = sc.nextInt();
            System.out.println("Sexo = " + idsexo);
            sc.nextLine();
            System.out.println("-------------------");
            System.out.println("Entre la fecha de nacimiento del Funcionario yyyy/mm/dd");
            String fechanacimiento =sc.nextLine();
            System.out.println("-------------------");
            System.out.println("Entre la direccioin de residencia del Funcionario");
            String direccion = sc.nextLine();
            System.out.println("-------------------");
            System.out.println("Entre la ciudad de residencia del Funcionario");
            System.out.println("1. Rionegro");
            System.out.println("2. Medellín");
            int idciudad = sc.nextInt();
            System.out.println("Ciudad = " + idciudad);
            sc.nextLine();
            System.out.println("-------------------");
            
            Funcionario funcionario = new Funcionario();
            
            funcionario.setIdfuncionario(idfuncionario);
            funcionario.setNombres(nombres);
            funcionario.setApellidos(apellidos);
            funcionario.setCelular(celular);
            funcionario.setIdestadocivil(idestadocivil);
            funcionario.setIdsexo(idsexo);
            funcionario.setFechanacimiento(fechanacimiento);
            funcionario.setDireccion(direccion);
            funcionario.setIdciudad(idciudad);
      
            funcionarioController.actualizarFuncionario(idfuncionario, funcionario);

        }  catch (SQLException ex) {
            Logger.getLogger(DAOAPP.class.getName()).log(Level.WARNING, "Revise la entrada de datos");
        }
    }
    
    public static void borrarFuncionario(FuncionarioController funcionarioController){

        try {
            Scanner sc = new Scanner(System.in);
            System.out.println("Entre la identificación  del Funcionario");
            String idfuncionario = sc.nextLine();
            
            Funcionario funcionarioExiste = funcionarioController.obtenerFuncionario(idfuncionario);
            
            if (funcionarioExiste == null){
                System.out.println("El funcionario no existe en ls BD");
                return;
            }
            
            funcionarioController.eliminarFuncionario(idfuncionario);

        }  catch (SQLException ex) {
            Logger.getLogger(DAOAPP.class.getName()).log(Level.WARNING, "Revise la entrada de datos");
        }
    }
    
    public static void obtenerFuncionario(FuncionarioController funcionarioController){
        
        try{
            Scanner sc = new Scanner(System.in);
            System.out.println("Entre la identificación  del Funcionario");
            String idfuncionario = sc.nextLine();
            
            Funcionario funcionario = funcionarioController.obtenerFuncionario(idfuncionario);
            
            if (funcionario == null){
                System.out.println("El funcionario no existe en ls BD");
                return;
            }
            System.out.println("Identificación = " + funcionario.getIdfuncionario());
            System.out.println("Nombres = " + funcionario.getNombres());
            System.out.println("Apellidos = " + funcionario.getApellidos());
            System.out.println("Celular = " + funcionario.getCelular());
            System.out.println("Estado Civil = " + funcionario.getIdestadocivil());
            System.out.println("Sexo = " + funcionario.getIdsexo());
            System.out.println("Fecha de Nacimiento = " + funcionario.getFechanacimiento());
            System.out.println("Dirección de residencia = " + funcionario.getDireccion());
            System.out.println("Ciudad de residencia = " + funcionario.getIdciudad());
            System.out.println("------------------------------------------------------------------------"); 
            
           
        } catch (SQLException e) {
            System.out.println("");
            System.out.println("Error al obtener funcionarios, revise la base de datos: " + e);
            System.out.println("");
       }
        
    }
    
    public static void funciones(int opcion) {
    FuncionarioController funcionarioController = new FuncionarioController();
    
    switch (opcion) {
        case 1:
                crearFuncionario(funcionarioController);
            break;
        case 2:
                obtenerFuncionarios(funcionarioController);
            break;
        case 3:
                actualizarFuncionario(funcionarioController);
            break;
        case 4:
                borrarFuncionario(funcionarioController);
            break;
        case 5: 
                obtenerFuncionario(funcionarioController); 
        default:
            System.out.println("Programa terminado");
            break;
    }
}

    
    public static void main(String[] args) throws ParseException {
        Scanner sc = new Scanner(System.in);
        int opcion;
        do{  
            System.out.println("1. Crear un funcionario");
            System.out.println("2. Obtener lista de funcionarios");
            System.out.println("3. Actualizar funcionario");
            System.out.println("4. Borrar funcionario");
            System.out.println("5. Obtener funcionario");
            System.out.println("6. Salir");
            System.out.println("");
            System.out.println("Entre la opción deseada entre 1 y 6 : ");
            System.out.println("");
            System.out.println("--------------------------------------");
            System.out.println("");
            opcion = sc.nextInt();
            sc.nextLine();
            funciones(opcion);
        }while (opcion>=1 && opcion<6);
    }
}

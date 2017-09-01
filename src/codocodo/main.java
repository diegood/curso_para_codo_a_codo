/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codocodo;

import codocodo.entidades.Alumno;
import codocodo.entidades.Pais;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author DARIAS
 */
public class main {

    /**
     * @param args the command line arguments
     */
    private static final DefaultTableModel tableModel = new DefaultTableModel();
    private static final String URL = "jdbc:mysql://localhost:3306/";
    private static final String NOMBRE_DB= "codo";
    private static final String DRIVER = "com.mysql.jdbc.Driver";
    private static final String USUARIO = "root";
    private static final String PASSWORD = "";
    private static ArrayList<Alumno> alumnos = new ArrayList<>();
    private static Map<Integer,Pais> mapaPaises = new HashMap<Integer,Pais>(); 
    
    public static void main(String[] args) {
            cargarPaises();
            try {                                            
                Class.forName(DRIVER).newInstance();
                Connection conn = DriverManager.getConnection(URL+NOMBRE_DB, USUARIO, PASSWORD);
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery("select * from alumnos");
                while(rs.next()){ 
                  Alumno alumno = mapearAlumno(rs);
                  alumnos.add(alumno);
                }
                rs.close();
                stmt.close();
                
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
         for (Alumno al : alumnos) {
                    System.out.println(al);
         }
                
                /*alumnos.forEach((al) -> {
                    System.out.println(al);
                });*/   
            
    }

    private static Alumno mapearAlumno(ResultSet rs) throws SQLException {
                Integer id = rs.getInt("id");
                String nombre = rs.getString("nombre");
                String apellido = rs.getString("apellido");
                Integer documento = rs.getInt("documento");
                Integer pais_id = rs.getInt("id_pais");
                Alumno alumno = new Alumno();
                
                alumno.setId(id);
                alumno.setNombre(nombre);
                alumno.setApellido(apellido);
                alumno.setDocumento(documento);

                Pais nacionalidad = mapaPaises.get(pais_id);
                alumno.setNacionalidad(nacionalidad);
                
                return alumno;
    }    
    
    
    private static void cargarPaises(){
        try {                                            
                Class.forName(DRIVER).newInstance();

                Connection conn = DriverManager.getConnection(URL+NOMBRE_DB, USUARIO, PASSWORD);
                PreparedStatement stmt = conn.prepareStatement("select * from paises");
                ResultSet rs = stmt.executeQuery();
                while(rs.next()){ 
                  Pais pais = mapearPais(rs);
                  mapaPaises.put(pais.getId(),pais);
                }
                rs.close();
                stmt.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } 
    }
    
    private static Pais mapearPais(ResultSet rs) throws SQLException{
        Pais pais = new Pais();
        pais.setId(rs.getInt("id"));
        pais.setNombre(rs.getString("nombre"));
        pais.setIso(rs.getString("iso"));
        return pais;
    }
    
}

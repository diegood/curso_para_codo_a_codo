/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author DARIAS
 */
public class MySQLConector {
    
    private static MySQLConector instance = null;
    final String URL = "jdbc:mysql://localhost:3306/";
    final String NOMBRE_DB= "codo";
    final String DRIVER = "com.mysql.jdbc.Driver";
    final String USUARIO = "root";
    final String PASSWORD = "";
    private Connection conexion = null;

    private  MySQLConector() {
        super();
    }
    
    public List<Map<String, String>> ejecutarConsulta(String query){
        try {
            Class.forName(DRIVER).newInstance();
            this.conexion = DriverManager.getConnection(URL+NOMBRE_DB, USUARIO, PASSWORD);
            PreparedStatement stmt = conexion.prepareStatement(query);
            List<Map<String, String>> resultado = resultSetToList(stmt.executeQuery());
            stmt.close();
            return resultado;
        } catch (Exception ex) {
            System.out.println("no se establecio conexion, Exception: "+ ex.getMessage());
        }finally{
            try {
                if(conexion != null){
                    conexion.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(MySQLConector.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return null;
    }
            
    /*Implementacion de patron singleton*/
    public static MySQLConector getInstance() {
        if(instance == null) {
           instance = new MySQLConector();
        }
        return instance;
    }
    
        
    public Connection getConexion() {
        return conexion;
    }
    
    private List<Map<String, String>> resultSetToList(ResultSet rs) throws SQLException {
    ResultSetMetaData md = rs.getMetaData();
    int columns = md.getColumnCount();
    List<Map<String, String>> rows = new ArrayList<Map<String, String>>();
    while (rs.next()){
        Map<String, String> row = new HashMap<String, String>(columns);
        for(int i = 1; i <= columns; ++i){
            row.put(md.getColumnName(i), rs.getString(i));
        }
        rows.add(row);
    }
    rs.close();
    return rows;
}

}

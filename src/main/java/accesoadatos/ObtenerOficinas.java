/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package accesoadatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase que se invoca al comienzo del programa
 * para obtener y rellenar automáticamente los códigos de 
 * las oficinas en el ComboBox de la interfaz.
 * 
 * @author masemoel
 */
public class ObtenerOficinas {
    // Variables
    private String codigo;
    
    // Constructores
    public ObtenerOficinas() {
        
    }
    
    public ObtenerOficinas(String codigo) {
        this.codigo=codigo;
    }
    
    public List obtenerOficinas() {
        List<ObtenerOficinas> lista = new ArrayList<ObtenerOficinas>();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/empresainformatica", "masemoel", "1609");
            Statement stmt = null;
            stmt = con.createStatement();
            String query = "SELECT codigo FROM oficinas";
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
		String codigo = rs.getString("codigo");
		ObtenerOficinas oo = new ObtenerOficinas (codigo);
		lista.add(oo);
            }
            stmt.close();
            rs.close();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            return lista;
        }
    }
}
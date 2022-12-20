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
 * Clase utilizada por la interfaz gráfica para
 * obtener los resultados de la búsqueda realizada por
 * el usuario para después mostrarse en la tabla.
 * 
 * @author masemoel
 */
public class Búsqueda {
    // Variables
    private String dni;
    private String nombre;

    // Constructores
    public Búsqueda(String dni, String nombre) {
        this.dni = dni;
        this.nombre = nombre;
    }
    
    public Búsqueda() {
        
    }

    // Getters y setters
    public String getDni() {
        return dni;
    }
    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public List<Búsqueda> buscarParaVista(String query) {
        List<Búsqueda> lista = new ArrayList<Búsqueda>();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/empresainformatica", "masemoel", "1609");
            Statement stmt = null;
            stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
		String dnii = rs.getString("dni");
		String nombree = rs.getString("nombre");
		Búsqueda busq = new Búsqueda (dnii, nombree);
		lista.add(busq);
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

    // Métodos generales
    @Override
    public String toString() {
        return "Búsqueda{" + "DNI=" + dni + ", nombre=" + nombre + '}';
    }
}
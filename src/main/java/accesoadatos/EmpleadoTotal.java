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

/**
 * Clase utilizada por el programa para
 * obtener información extendida de un empleado
 * a partir de su DNI.
 * 
 * @author masemoel
 */
public class EmpleadoTotal {
    // Variables
    private String dni;
    private String nombre;
    private String apellido1;
    private String apellido2;
    private String fecha_nacimiento;
    private String cod_oficina;
    private String custom;
    private String custom2;
    
    // Constructores
    public EmpleadoTotal(String dni, String nombre, String apellido1, String apellido2, String fecha_nacimiento, String cod_oficina, String custom, String custom2) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
        this.fecha_nacimiento = fecha_nacimiento;
        this.cod_oficina = cod_oficina;
        this.custom = custom;
        this.custom2 = custom2;
    }
    
    public EmpleadoTotal(String dni, String nombre, String apellido1, String apellido2, String fecha_nacimiento, String cod_oficina, String custom) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
        this.fecha_nacimiento = fecha_nacimiento;
        this.cod_oficina = cod_oficina;
        this.custom = custom;
    }
    
    public EmpleadoTotal() {
        
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

    public String getApellido1() {
        return apellido1;
    }
    public void setApellido1(String apellido1) {
        this.apellido1 = apellido1;
    }

    public String getApellido2() {
        return apellido2;
    }
    public void setApellido2(String apellido2) {
        this.apellido2 = apellido2;
    }

    public String getFecha_nacimiento() {
        return fecha_nacimiento;
    }
    public void setFecha_nacimiento(String fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
    }

    public String getCod_oficina() {
        return cod_oficina;
    }
    public void setCod_oficina(String cod_oficina) {
        this.cod_oficina = cod_oficina;
    }

    public String getCustom() {
        return custom;
    }
    public void setCustom(String custom) {
        this.custom = custom;
    }

    public String getCustom2() {
        return custom2;
    }
    public void setCustom2(String custom2) {
        this.custom2 = custom2;
    }

    // Métodos
    public EmpleadoTotal obtenerInformacionExtendida(String dni, String templeado) {
        EmpleadoTotal et = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/empresainformatica", "masemoel", "1609");
            Statement stmt = null;
            stmt = con.createStatement();
            String query = "SELECT * FROM "+templeado.toLowerCase()+" p JOIN empleados e ON p.dni=e.dni WHERE p.dni='"+dni+"'";
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
		String bdni = rs.getString("p.dni");
                String bnombre = rs.getString("e.nombre");
                String bapellido1 = rs.getString("e.apellido1");
                String bapellido2 = rs.getString("e.apellido2");
                String bfecha_nacimiento = rs.getString("e.fecha_nacimiento");
                String bcod_oficina = rs.getString("e.cod_oficina");
                if (templeado == "Programadores") {
                    String bcustom = rs.getString("p.experiencia");
                    String bcustom2 = rs.getString("p.tecnologias");
                    et = new EmpleadoTotal (bdni, bnombre, bapellido1, bapellido2, bfecha_nacimiento, bcod_oficina, bcustom, bcustom2);
                } else if (templeado == "Analistas") {
                    String bcustom = rs.getString("p.titulacion");
                    et = new EmpleadoTotal (bdni, bnombre, bapellido1, bapellido2, bfecha_nacimiento, bcod_oficina, bcustom);
                } else if (templeado == "Vendedores") {
                    String bcustom = rs.getString("p.zona");
                    et = new EmpleadoTotal (bdni, bnombre, bapellido1, bapellido2, bfecha_nacimiento, bcod_oficina, bcustom);
                } else if (templeado == "Administrativos") {
                    String bcustom = rs.getString("p.experiencia");
                    et = new EmpleadoTotal (bdni, bnombre, bapellido1, bapellido2, bfecha_nacimiento, bcod_oficina, bcustom);
                }
            }
            stmt.close();
            rs.close();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            return et;
        }
    }
}
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import excepciones.FormatoNoValidoDNI;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

/**
 * @author masemoel
 */
public class Tecnicos extends Empleados {
    // Variables
    protected ArrayList<String> tecnos;
    
    // Constructores
    public Tecnicos(String dni, String nombre, String apellido1, String apellido2, double sueldo, GregorianCalendar fecha_nacimiento, Oficinas oficinaEmpleado, Direccion direccion, ArrayList<String> tecnos) throws FormatoNoValidoDNI {
        super(dni, nombre, apellido1, apellido2, sueldo, fecha_nacimiento, oficinaEmpleado, direccion);
        setTecnos(tecnos);
    }
    
    public Tecnicos() {
        
    }
    
    // Getters y setters

    public List getTecnologias() {
        return tecnos;
    }
    public void setTecnos(ArrayList<String> tecnos) {
        this.tecnos = tecnos;
    }
    
    
    // Métodos
    @Override
    public double calcularNomina(int mes) {
        int base = 500;
	int tecnosextra = 200;
        switch (mes) {
            case 1, 3, 5, 7, 8, 10, 12:
		return super.getSueldo() + tecnosextra + (31 * 10);
            case 4, 6, 9, 11:
		return super.getSueldo() + tecnosextra + (30 * 10);
            case 2:
		return super.getSueldo() + tecnosextra + (28 * 10);
            default:
		return 0;
	}
    }
}

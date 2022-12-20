/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import excepciones.FormatoNoValidoDNI;
import java.util.ArrayList;
import java.util.GregorianCalendar;

/**
 * @author masemoel
 */
public class Analistas extends Tecnicos {
    // Variables
    private String titulacion;
    
    // Constructores
    public Analistas(String dni, String nombre, String apellido1, String apellido2, double sueldo, GregorianCalendar fecha_nacimiento, Oficinas oficinaEmpleado, Direccion direccion, String titulacion, ArrayList<String> tecnos) throws FormatoNoValidoDNI {
        super(dni, nombre, apellido1, apellido2, sueldo, fecha_nacimiento, oficinaEmpleado, direccion, tecnos);
        setTitulacion(titulacion);
    }
    
    public Analistas() {
        
    }
    
    // Getters y setters

    public String getTitulacion() {
        return titulacion;
    }
    public void setTitulacion(String titulacion) {
        this.titulacion = titulacion;
    }
    
    
    // Métodos
    @Override
    public double calcularNomina(int mes) {
        int base = 500;
	int analisextra = 300;
        switch (mes) {
            case 1, 3, 5, 7, 8, 10, 12:
		return super.getSueldo() + analisextra + (31 * 10);
            case 4, 6, 9, 11:
		return super.getSueldo() + analisextra + (30 * 10);
            case 2:
		return super.getSueldo() + analisextra + (28 * 10);
            default:
		return 0;
	}
    }
}

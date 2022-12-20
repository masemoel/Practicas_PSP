/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import excepciones.FormatoNoValidoDNI;
import java.util.GregorianCalendar;

/**
 * @author masemoel
 */
public class Vendedores extends Empleados{
    // Variables
    private int zona;
    
    // Constructores
    public Vendedores(String dni, String nombre, String apellido1, String apellido2, double sueldo, GregorianCalendar fecha_nacimiento, Oficinas oficinaEmpleado, Direccion direccion, int zona) throws FormatoNoValidoDNI {
        super(dni, nombre, apellido1, apellido2, sueldo, fecha_nacimiento, oficinaEmpleado, direccion);
        setZona(zona);
    }
    
    public Vendedores() {
        
    }
    
    // Getters y settersñ
    public int getZona() {
        return zona;
    }
    public void setZona(int zona) {
        this.zona = zona;
    }
    
    
    // Métodos
    @Override
    public double calcularNomina(int mes) {
        int base = 500;
        switch (mes) {
            case 1, 3, 5, 7, 8, 10, 12:
		return super.getSueldo() + (31 * 10);
            case 4, 6, 9, 11:
		return super.getSueldo() + (30 * 10);
            case 2:
		return super.getSueldo() + (28 * 10);
            default:
		return 0;
	}
    }
}

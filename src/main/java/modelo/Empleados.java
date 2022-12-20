/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import excepciones.FormatoNoValidoDNI;
import java.util.GregorianCalendar;
import validadores.ValidarDNI;

/**
 * @author masemoel
 */
public abstract class Empleados implements Comparable {
    // Variables
    private String dni;
    private String nombre;
    private String apellido1;
    private String apellido2;
    private double sueldo;
    private GregorianCalendar fecha_nacimiento;
    private Oficinas oficinaEmpleado;
    private Direccion direccion;

    // Constructores
    public Empleados(String dni, String nombre, String apellido1, String apellido2, double sueldo, GregorianCalendar fecha_nacimiento, Oficinas oficinaEmpleado, Direccion direccion) throws FormatoNoValidoDNI {
        super();
        setDni(dni);
        setNombre(nombre);
        setApellido1(apellido1);
        setApellido2(apellido2);
        setFecha_nacimiento(fecha_nacimiento);
        setDireccion(direccion);
        setSueldo(sueldo);
        setOficinas(oficinaEmpleado);
    }
    
    public Empleados() {
        
    }

    // Getters y setters
    public String getDni() {
        return dni;
    }
    public void setDni(String dni) throws FormatoNoValidoDNI {
        if (ValidarDNI.validar(dni)) {
			this.dni = dni;
		} else {
			throw new FormatoNoValidoDNI();
		}
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

    public GregorianCalendar getFecha_nacimiento() {
        return fecha_nacimiento;
    }
    public void setFecha_nacimiento(GregorianCalendar fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
    }

    public Direccion getDireccion() {
        return direccion;
    }
    public void setDireccion(Direccion direccion) {
        this.direccion = direccion;
    }

    public double getSueldo() {
        return sueldo;
    }
    public void setSueldo(double sueldo) {
        this.sueldo = sueldo;
    }

    public Oficinas getOficinas() {
        return oficinaEmpleado;
    }
    public void setOficinas(Oficinas oficinaEmpleado) {
        this.oficinaEmpleado = oficinaEmpleado;
    }

    // Métodos generales
    @Override
    public int compareTo(Object o) {
        Empleados p = (Empleados)o;
        return this.toString().compareTo(p.toString());
    }

    @Override
    public String toString() {
        return "Persona [dni=" + dni + ", nombre=" + nombre + ", apellido1=" + apellido1 + ", apellido2=" + apellido2
            + ", fecha_nacimiento=" + fecha_nacimiento + ", direccion=" + direccion + "]";
    }
    
    @Override
    public boolean equals(Object obj) {
        return getDni().equals(((Empleados)obj).getDni());
    }
    
    // Métodos abstractos
    public abstract double calcularNomina(int mes);
}

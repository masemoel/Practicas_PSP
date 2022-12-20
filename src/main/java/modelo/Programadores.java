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
public class Programadores extends Tecnicos {
    // Variables
    private enum Experiencia {
	Bajo, Medio, Alto, MuyAlto
    }
    private Experiencia nivelExperiencia;
    
    // Constructores
    public Programadores (String dni, String nombre, String apellido1, String apellido2, double sueldo, GregorianCalendar fecha_nacimiento, Oficinas oficinaEmpleado, Direccion direccion, String exp, ArrayList<String> tecnos) throws FormatoNoValidoDNI {
        super(dni, nombre, apellido1, apellido2, sueldo, fecha_nacimiento, oficinaEmpleado, direccion, tecnos);
        setNivelExperiencia(nivelExperiencia);
        
        switch (exp) {
            case "Bajo":
                setNivelExperiencia(Programadores.Experiencia.Bajo);
                break;
            case "Medio":
                setNivelExperiencia(Programadores.Experiencia.Medio);
                break;
            case "Alto":
                setNivelExperiencia(Programadores.Experiencia.Alto);
                break;
            case "MuyAlto":
                setNivelExperiencia(Programadores.Experiencia.MuyAlto);
                break;
        }
    }
    
    public Programadores() {
        
    }
    
    // Getters y setters
    public Experiencia getNivelExperiencia() {
        return nivelExperiencia;
    }
    public void setNivelExperiencia(Experiencia nivelExperiencia) {
        this.nivelExperiencia = nivelExperiencia;
    }
    
    
    // Métodos
    @Override
    public double calcularNomina(int mes) {
        int base = 500;
        int progsextra = 0;
        if (tecnos != null) {
            progsextra = 25*tecnos.size();
        } else {
            progsextra = 25*2; // Dos tecnologías por defecto
        }
        switch (mes) {
            case 1, 3, 5, 7, 8, 10, 12:
		return super.getSueldo() + progsextra + (31 * 10);
            case 4, 6, 9, 11:
		return super.getSueldo() + progsextra + (30 * 10);
            case 2:
		return super.getSueldo() + progsextra + (28 * 10);
            default:
		return 0;
	}
    }
}

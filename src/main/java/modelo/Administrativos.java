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
public class Administrativos extends Empleados {
    // Variables
    private enum Experiencia {
	Bajo, Medio, Alto, Experto
    }
    private Experiencia nivelExperiencia;
    
    // Constructores
    public Administrativos(String dni, String nombre, String apellido1, String apellido2, double sueldo, GregorianCalendar fecha_nacimiento, Oficinas oficinaEmpleado, Direccion direccion, String exp) throws FormatoNoValidoDNI {
        super(dni, nombre, apellido1, apellido2, sueldo, fecha_nacimiento, oficinaEmpleado, direccion);
        setNivelExperiencia(nivelExperiencia);
        
        switch (exp) {
            case "Bajo":
                setNivelExperiencia(Experiencia.Bajo);
                break;
            case "Medio":
                setNivelExperiencia(Experiencia.Medio);
                break;
            case "Alto":
                setNivelExperiencia(Experiencia.Alto);
                break;
            case "Experto":
                setNivelExperiencia(Experiencia.Experto);
                break;
        }
    }
    
    public Administrativos() {
        
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
	int administextra = 100;
        switch (mes) {
            case 1, 3, 5, 7, 8, 10, 12:
		return super.getSueldo() + administextra + (31 * 10);
            case 4, 6, 9, 11:
		return super.getSueldo() + administextra + (30 * 10);
            case 2:
		return super.getSueldo() + administextra + (28 * 10);
            default:
		return 0;
	}
    }
}

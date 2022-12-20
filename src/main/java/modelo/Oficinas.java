/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 * @author masemoel
 */
public class Oficinas {
    // Variables
    private String codigo;
    private String nombre;
    private Direccion direccionOf;
    
    // Constructores
    public Oficinas(String codigo, String nombre, Direccion direccionOf) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.direccionOf = direccionOf;
    }
    
    // Getters y setters
    public String getCodigo() {
        return codigo;
    }
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Direccion getDireccionOf() {
        return direccionOf;
    }
    public void setDireccionOf(Direccion direccionOf) {
        this.direccionOf = direccionOf;
    }
    
    // Métodos generales
    @Override
	public String toString() {
		return "Oficina [Código=" + codigo + ", nombre=" + nombre + ", dirección de la oficina=" + direccionOf + "]";
	}
}

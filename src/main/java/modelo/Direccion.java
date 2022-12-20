/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 * @author masemoel
 */
public class Direccion implements Comparable<Direccion> {
    /* Atributos */
    private String nombrevia;
    private String numero;
    private String piso;
    private String cp;
    private String localidad;

    /* Constructores */
    public Direccion(String nombrevia, String cp, String localidad, String piso, String numero) {
        super();
        setNombrevia(nombrevia);
        setCp(cp);
        setLocalidad(localidad);
        setPiso(localidad);
        setNumero(localidad);
    }

    public Direccion(String nombrevia, String cp, String localidad) {
        super();
        setNombrevia(nombrevia);
        setCp(cp);
        setLocalidad(localidad);
    }
	
    /* Getters y setters */
    public String getNombrevia() {
        return nombrevia;
    }
    public void setNombrevia(String nombrevia) {
        this.nombrevia = nombrevia;
    }

    public String getNumero() {
        return numero;
    }
    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getPiso() {
        return piso;
    }
    public void setPiso(String piso) {
        this.piso = piso;
    }

    public String getCp() {
        return cp;
    }
    public void setCp(String cp) {
        this.cp = cp;
    }

    public String getLocalidad() {
        return localidad;
    }
    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    /* Métodos */
    @Override
    public String toString() {
        return getNombrevia()+" "+getNumero();
    }

    public int compareTo(Direccion o) {
        return this.toString().compareTo(o.toString());
    }

    @Override
    public boolean equals(Object obj){
        Direccion d = (Direccion) obj;
        return this.getCp().equals(obj);
    }
}
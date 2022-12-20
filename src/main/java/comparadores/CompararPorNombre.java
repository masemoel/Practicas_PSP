/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package comparadores;

import java.util.Comparator;
import modelo.Empleados;

/**
 * @author Masemo
 */
public class CompararPorNombre implements Comparator<Empleados> {
    public CompararPorNombre() {
        
    }
    
    @Override
    public int compare(Empleados o1, Empleados o2) {
        return o1.getNombre().compareTo(o2.getNombre());
    }
}
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package excepciones;

/**
 *
 * @author Masemo
 */
@SuppressWarnings("serial")
public class FormatoNoValidoDNI extends Exception {
    public FormatoNoValidoDNI() {
        super("Formato del DNI no válido.");
    }
}
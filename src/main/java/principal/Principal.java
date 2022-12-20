/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package principal;

import accesoadatos.Conexion;
import vista.VentanaPrincipal;

/**
 * @author masemoel
 */
public class Principal {
    public static void main(String[] args) {
        Conexion c = new Conexion();
        c.iniciarConexion();
        VentanaPrincipal vp = new VentanaPrincipal();
        vp.setVisible(true);
    }
}

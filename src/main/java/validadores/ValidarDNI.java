/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package validadores;

import excepciones.FormatoNoValidoDNI;

/**
 *
 * @author Masemo
 */
public class ValidarDNI {
    public static boolean validar(String dni) throws FormatoNoValidoDNI {
        String mayus = "";
        
        if (dni.length() != 9 || Character.isLetter(dni.charAt(8)) == false) {
            throw new FormatoNoValidoDNI();
            //return false;
        }
        
        mayus = (dni.substring(8)).toUpperCase();

        if (soloNumeros(dni) == true && letraDNI(dni).equals(mayus)) {
            return true;
        } else {
            return false;
        }
    }

    private static boolean soloNumeros(String dni) {
        String numero = ""; // Es el número que se comprueba uno a uno por si hay alguna letra entre los 8						// primeros dígitos
        String miDni = ""; // Guardamos en una cadena los números para después calcular la letra
	String[] numeros = { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9" };
        for (int i = 0; i < dni.length() - 1; i++) {
            numero = dni.substring(i, i + 1);

            for (int j = 0; j < numeros.length; j++) {
		if (numero.equals(numeros[j])) {
                    miDni += numeros[j];
		}
            }
	}

	if (miDni.length() != 8) {
            return false;
	} else {
            return true;
	}
    }

	private static String letraDNI(String dni) {
            int miDNI = Integer.parseInt(dni.substring(0, 8));
            int resto = 0;
            String miLetra = "";
            String[] asignacionLetra = { "T", "R", "W", "A", "G", "M", "Y", "F", "P", "D", "X", "B", "N", "J", "Z", "S",
                            "Q", "V", "H", "L", "C", "K", "E" };
            resto = miDNI % 23;
            miLetra = asignacionLetra[resto];
            return miLetra;
	}
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package aplicacionamigos.models;

/**
 * La clase representa una persona Amigo del que se conocen los nombres, telefono y correo Electronico
 * @author Sofia Bermudez
 * @version 1.0.0
 * @since 26032025
 * 
 */
public class Amigo {
    private String nombres;
    private String telefono;
    private String correoElectronico;
    
    /**
     * Constructor de la clase Amigo.
     *
     * @param nombres - Nombre de amigo. No puede estar vacio
     * @param telefono - Número de telefono de amigo. Debe empezar con 606 o 30 y solo puede contener numeros despues del prefijo. No puede estar vacio
     * @param correoElectronico - Correo electronico de amigo. Debe contener @ y no puede estar vacio
     * @Exception IllegalArgumentException - Si alguno de los parametros no cumple con las restricciones
     */

    public Amigo(String nombres, String telefono, String correoElectronico) {
        String errores = "";

        if (nombres == null || nombres.isEmpty()) {
            errores += "El nombre no puede estar vacío.\n";
        }

        if (telefono == null || telefono.isEmpty()) {
            errores += "El teléfono no puede estar vacío.\n";
        } else if (!(telefono.startsWith("606") || telefono.startsWith("30"))) {
            errores += "El teléfono debe iniciar con 606 o 30.\n";
        } else {
            String restoTelefono = telefono.substring(telefono.startsWith("606") ? 3 : 2); 
            for (int i = 0; i < restoTelefono.length(); i++) {
                if (restoTelefono.charAt(i) < '0' || restoTelefono.charAt(i) > '9') {
                    errores += "El teléfono solo puede contener números después del prefijo.\n";
                    break;
                }
            }
        }

        if (correoElectronico == null || correoElectronico.isEmpty()) {
            errores += "El correo electrónico no puede estar vacío.\n";
        } else if (correoElectronico.indexOf('@') == -1) {
            errores += "El correo electrónico debe contener una @.\n";
        }

        if (!errores.isEmpty()) {
            throw new IllegalArgumentException(errores);
        }

        this.nombres = nombres;
        this.telefono = telefono;
        this.correoElectronico = correoElectronico;
    }
    
    /**
     * Obtiene los nombres de amigo
     *
     * @return los nombres de amigo
     */

    public String getNombres() {
        return nombres;
    }

    /**
     * Obtiene el numero de telefono de amigo
     *
     * @return el telefono de amigo
     */
    
    public String getTelefono() {
        return telefono;
    }
    
    /**
     * Obtiene el correo electronico de amigo
     *
     * @return el correo electronico de amigo
     */

    public String getCorreoElectronico() {
        return correoElectronico;
    }
    
    /**
     * Establece un nuevo nombre para amigo
     *
     * @param nombres - El nuevo nombre, no puede estar vacio
     * @Exception IllegalArgumentException - Si el nombre esta vacio o es nulo
     */

    public void setNombres(String nombres) {
        if (nombres == null || nombres.isEmpty()) {
            throw new IllegalArgumentException("El nombre no puede estar vacío");
        }
        this.nombres = nombres;
    }
    
    /**
     * Establece un nuevo telefono para amigo
     *
     * @param telefono - El nuevo telefono, debe iniciar con 606 o 30
     * @Exception IllegalArgumentException - Si el nombre esta vacio o es nulo
     */

    public void setTelefono(String telefono) {
        if (telefono == null || telefono.isEmpty()) {
            throw new IllegalArgumentException("El teléfono no puede estar vacío");
        }
        if (!(telefono.startsWith("606") || telefono.startsWith("30"))) {
            throw new IllegalArgumentException("El teléfono debe iniciar con 606 o 30");
        }
        this.telefono = telefono;
    }
    
    /**
     * Establece un nuevo correo electronico para amigo
     *
     * @param correoElectronico - El nuevo correo electronico, debe tener @
     * @Exception IllegalArgumentException - Si el nombre esta vacio o es nulo
     */

    public void setCorreoElectronico(String correoElectronico) {
        if (correoElectronico == null || correoElectronico.isEmpty()) {
            throw new IllegalArgumentException("El correo no puede estar vacío");
        }
        if (correoElectronico.indexOf('@') == -1) {
            throw new IllegalArgumentException("El correo electrónico debe contener una @");
        }
        this.correoElectronico = correoElectronico;
    }
}

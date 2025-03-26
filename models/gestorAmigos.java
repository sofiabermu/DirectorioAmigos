/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package aplicacionamigos.models;

/**
 * Permite gestionar una lista de amigos, se pueden buscra, agregar, eliminar, actualizar y mostrar los contactos que tiene una persona
 * @author Sofia Bermudez
 * @version 1.0.0
 * @since 26032025
 */
public class gestorAmigos {
    private Amigo[] listaAmigos;
    public int cantidadAmigos;

    /**
     * Constructor que inicializa la lista de amigos con un tamaño maximo de 100 contactos
     */
    
    public gestorAmigos() {
        listaAmigos = new Amigo[100]; 
        cantidadAmigos = 0;
    }
    
     /**
     * Permite agregar un nuevo contacto a la lista de amigos de la persona
     *
     * @param amigo - Objeto de tipo Amigo que se desea agregar
     * @Exception IllegalStateException - si el correo del amigo ya esta registrado o si la lista de amigos ya esta llena
     */

    public void agregarAmigo(Amigo amigo) {

        for (int i = 0; i < cantidadAmigos; i++) {
            if (listaAmigos[i].getCorreoElectronico().equals(amigo.getCorreoElectronico())) {
                throw new IllegalStateException("Ya existe un amigo registrado con ese correo electrónico");
            }
        }

        if (cantidadAmigos >= listaAmigos.length) {
            throw new IllegalStateException("Se ha alcanzado el límite máximo de amigos");
        }

        listaAmigos[cantidadAmigos] = amigo;
        cantidadAmigos++;
    }
    
    /**
     * Permite buscar un amigo por su correo electronico
     *
     * @param correoElectronico - Correo electronico del amigo a buscar
     * @return El objeto Amigo encontrado
     * @Exception IllegalArgumentException - Si no se encuentra ningun amigo con ese correo electronico
     */

    public Amigo buscarAmigo(String correoElectronico) {
        for (int i = 0; i < cantidadAmigos; i++) {
            if (listaAmigos[i].getCorreoElectronico().equals(correoElectronico)) {
                return listaAmigos[i];
            }
        }
        throw new IllegalArgumentException("No se encontró ningún amigo con ese correo electrónico");
    }
    
    /**
     * Permite obtener la lista actualizada de amigos
     *
     * @return un arreglo de objetos Amigo con los amigos registrados
     */

    public Amigo[] getListaAmigos() {
        Amigo[] amigosActuales = new Amigo[cantidadAmigos];
        for (int i = 0; i < cantidadAmigos; i++) {
            amigosActuales[i] = listaAmigos[i];
        }
        return amigosActuales;
    }
    
     /**
     * Permite mostrar en la consola la lista de contactos registrados con sus nombres, telefonos y correos electronicos
     */
    
    public void mostrarContactos() {
        if (cantidadAmigos == 0) {
            System.out.println("No hay contactos registrados.");
            return;
        }
        System.out.println("Lista de contactos:");
        for (int i = 0; i < cantidadAmigos; i++) {
            Amigo amigo = listaAmigos[i];
            System.out.println("Nombre: " + amigo.getNombres() + 
                               " Teléfono: " + amigo.getTelefono() + 
                               " Correo: " + amigo.getCorreoElectronico());
        }
    }
    
    /**
     * Permite eliminar un contacto de la lista por su correo electronico
     *
     * @param correoElectronico - Correo electronico del amigo que se desea eliminar
     * @Exception IllegalArgumentException - Si no se encuentra el amigo con ese correo electronico
     */
    
    public void eliminarContacto(String correoElectronico) {
        int indiceAEliminar = -1;
        for (int i = 0; i < cantidadAmigos; i++) {
            if (listaAmigos[i].getCorreoElectronico().equals(correoElectronico)) {
                indiceAEliminar = i;
                break;
            }
        }

        if (indiceAEliminar == -1) {
            throw new IllegalArgumentException("No se encontró ningún amigo con ese correo electrónico");
        }

        for (int i = indiceAEliminar; i < cantidadAmigos - 1; i++) {
            listaAmigos[i] = listaAmigos[i + 1];
        }

        listaAmigos[cantidadAmigos - 1] = null;
        cantidadAmigos--;
    }
    
    /**
     * Permite actualizar la informacion de un amigo
     *
     * @param correoOriginal - Correo actual del amigo
     * @param nuevoAmigo - nuevo objeto Amigo con la informacion actualizada
     * @Exception IllegalArgumentException - Si no se encuentra el amigo con el correo original
     * @Exception IllegalStateException - si el nuevo correo electronico ya esta registrado en otro amigo
     */
    
    public void actualizarContacto(String correoOriginal, Amigo nuevoAmigo) {

        int indiceActualizar = -1;
        for (int i = 0; i < cantidadAmigos; i++) {
            if (listaAmigos[i].getCorreoElectronico().equals(correoOriginal)) {
                indiceActualizar = i;
                break;
            }
        }

        if (indiceActualizar == -1) {
            throw new IllegalArgumentException("No se encontró ningún amigo con ese correo electrónico");
        }

        if (!correoOriginal.equals(nuevoAmigo.getCorreoElectronico())) {
            for (int i = 0; i < cantidadAmigos; i++) {
                if (i != indiceActualizar && 
                    listaAmigos[i].getCorreoElectronico().equals(nuevoAmigo.getCorreoElectronico())) {
                    throw new IllegalStateException("Ya existe un amigo registrado con el nuevo correo electrónico");
                }
            }
        }

        listaAmigos[indiceActualizar] = nuevoAmigo;
    }
}

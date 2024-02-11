package ec.edu.espoch.agenda.controlador;

import ec.edu.espoch.agenda.modelo.Archivo;
import ec.edu.espoch.agenda.modelo.Persona;
import ec.edu.espoch.agenda.vista.Modificar;
import java.util.ArrayList;

public class ControladorModificar {
    private Modificar modificar;

    public ControladorModificar(Modificar modificar) {
        this.modificar = modificar;
    }
   
    public void modificar() {
        String newUsuario = String.valueOf(modificar.getNombreAntiguo());
        String nombre = modificar.getNombre();

        if (this.modificar.getNombre().isEmpty() || this.modificar.getDia().isEmpty() ||
            this.modificar.getHora().isEmpty() || this.modificar.getDosis().isEmpty()) {
            this.modificar.mostrarResultado("No deje ninguna casilla vacía");
            return;
        }

        String dia, hora;
        double dosis;
        
        try {
            dia = String.valueOf(this.modificar.getDia());
            hora = String.valueOf(this.modificar.getHora());
            dosis = Double.parseDouble(this.modificar.getDosis());
            
        } catch (NumberFormatException e) {
            modificar.mostrarResultado("Los valores son incorrectos");
            return;
        }
        
        ArrayList<Persona> persona = Archivo.leerArchivo();
        int posicion = Archivo.verificarNombre(persona, newUsuario);

        String mensaje;
        if (posicion != -1) {
            mensaje = Archivo.modificar(persona, posicion, nombre, dia, hora, dosis);
        } else {
            mensaje = "El medicamento no está en la lista.";
        }
        modificar.mostrarResultado(mensaje);
    }
    
}

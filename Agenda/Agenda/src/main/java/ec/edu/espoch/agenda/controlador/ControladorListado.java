package ec.edu.espoch.agenda.controlador;

import ec.edu.espoch.agenda.modelo.Persona;
import ec.edu.espoch.agenda.vista.Listado;

public class ControladorListado {
    private Listado listado;
    private Persona persona;

    public ControladorListado(Listado listado) {
        this.listado = listado;
        this.persona = new Persona(); 
    }

    public void procesoListado() {
        persona.mostrarDatos();
        this.listado.mostrar(this.persona.mostrarDatos());  
    }
    
}

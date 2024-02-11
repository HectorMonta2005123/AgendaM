package ec.edu.espoch.agenda.controlador;


import ec.edu.espoch.agenda.modelo.Persona;
import ec.edu.espoch.agenda.vista.Ingresar;

public class ControladorIngresar {

    private Ingresar ingresar;
    private Persona persona;

    public ControladorIngresar(Ingresar ingresar) {
        this.ingresar = ingresar;
        this.persona = new Persona();
    }

    public void procesoIngresoDatos() {
        double dosis=0;
        String nombre = "",dia = "",hora = "";
        try {
        nombre = String.valueOf(this.ingresar.getNombre());
        if (nombre.matches(".*\\d.*")) {
            throw new NumberFormatException();
        }
        } catch (NumberFormatException e) {
            this.ingresar.mensajeError("El nombre no debe contener números");
            return;
        }

        try {
            dia = String.valueOf(this.ingresar.getDia());
            if (dia.matches(".*\\d.*")) {
                throw new NumberFormatException();
            }
        } catch (NumberFormatException e) {
            this.ingresar.mensajeError("El día debe ser en texto");
            return;
        }
        try {
            hora = String.valueOf(this.ingresar.getHora());

            if (hora.matches(".*[a-zA-Z].*")) {
                throw new NumberFormatException();
            }
        } catch (NumberFormatException e) {
            this.ingresar.mensajeError(" ");
            return;
        }        
        
        try {
            dosis = Double.parseDouble(this.ingresar.getDosis());
        } catch (NumberFormatException e) {
            this.ingresar.mensajeError("La dosis debe ser un número");
            return;
        }
        if (this.ingresar.getNombre().isEmpty() || this.ingresar.getDia().isEmpty() ||
            this.ingresar.getHora().isEmpty() || this.ingresar.getDosis().isEmpty()) {
            this.ingresar.mostrarResultado("No deje ninguna casilla vacia");
            return;
        }

        this.persona.setNombre(nombre);
        this.persona.setDia(dia);
        this.persona.setHora(hora);
        this.persona.setDosis(dosis);      
        String mensaje=this.persona.ingresoDatos();
        this.ingresar.mostrarResultado(mensaje);
        this.ingresar.mensajeError("");  
        }
    
        public void limpiarCampos(){
            ingresar.limpiarCamposTexto();
        }
        
}

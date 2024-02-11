package ec.edu.espoch.agenda.modelo;

import java.util.ArrayList;

public class Persona {
    
    private String nombre;
    private String dia;
    private String hora;
    private Double dosis;

    public Persona(String nombre, String dia, String hora, double dosis) {
        this.nombre = nombre;
        this.dia = dia;
        this.hora = hora;
        this.dosis = dosis;
    }

    public Persona() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDia() {
        return dia;
    }

    public void setDia(String dia) {
        this.dia = dia;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public double getDosis() {
        return dosis;
    }

    public void setDosis(double dosis) {
        this.dosis = dosis;
    }
    
    public String ingresoDatos(){
        
         return Archivo.anexarArchivo(this.nombre, this.dia, this.hora, this.dosis);
      
    }
    public ArrayList<Persona> mostrarDatos(){
         return Archivo.leerArchivo();
      
    }
    
    public String escribirArchivo(){
         return Archivo.anexarArchivo(this.nombre, this.dia, this.hora, this.dosis);
      
    } 
}

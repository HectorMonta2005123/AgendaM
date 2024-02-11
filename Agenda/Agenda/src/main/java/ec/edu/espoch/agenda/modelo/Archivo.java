package ec.edu.espoch.agenda.modelo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Archivo {

    private static final String nombreArchivo = "C:\\REGISTROS\\registro.txt";

    public static void crearArchivo() {
        File archivo = new File(nombreArchivo);
        try {
            if (!archivo.exists()) {
                PrintWriter salida = new PrintWriter(archivo);
                salida.close();
                System.out.println("El archivo se ha creado correctamente");
            } else {
                System.out.println("El archivo ya existe");
            }

        } catch (FileNotFoundException ex) {
            ex.printStackTrace(System.out);
        }
    }

    public static ArrayList<Persona> leerArchivo() {
        ArrayList<Persona> personas = new ArrayList<>();
        File archivo = new File(nombreArchivo);
        try {
            BufferedReader entrada = new BufferedReader(new FileReader(archivo));
            String lectura = entrada.readLine();
            while (lectura != null) {
                String[] datos = lectura.split(";");
                Persona objPersona = new Persona();
                objPersona.setNombre(datos[0]);
                objPersona.setDia(datos[1]);
                objPersona.setHora(datos[2]);
                objPersona.setDosis(Double.parseDouble(datos[3]));
                personas.add(objPersona);

                lectura = entrada.readLine();
            }
            entrada.close();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace(System.out);
        } catch (IOException ex) {
            ex.printStackTrace(System.out);
        }
        return personas;
    }

    public static String anexarArchivo(String nombre, String dia, String hora, double dosis) {
        File archivo = new File(nombreArchivo);
        String verificar = "";
        try {
            PrintWriter salida = new PrintWriter(new FileWriter(archivo, true));
            String contenido = nombre + "; " + dia + "; " + hora + "; " + dosis;
            salida.println(contenido);
            salida.close();
            verificar = "Registro correcto";
        } catch (FileNotFoundException ex) {
            verificar = "Error, al acceder al archivo";
            ex.printStackTrace(System.out);
        } catch (IOException ex) {
            verificar = "Error, escribir en el archivo";
            Logger.getLogger(Archivo.class.getName()).log(Level.SEVERE, null, ex);
        }
        return verificar;
    }

    public static Integer verificarNombre(ArrayList<Persona> personas, String nombre) {
        for (int i = 0; i < personas.size(); i++) {
            if (personas.get(i).getNombre().equalsIgnoreCase(nombre)) {
                return i;
            }
        }
        return -1;
    }

    public static String modificar(ArrayList<Persona> person, int pos, String nuevoNombre, String dia, String hora, double dosis) {
        if (pos != -1 && pos < person.size()) {
            Persona newPerson = person.get(pos);
            newPerson.setNombre(nuevoNombre);
            newPerson.setDosis(dosis);                  
            newPerson.setDia(dia);
            newPerson.setHora(hora);

            actualizar(person);

            return "Se modificó correctamente";
        } else {
            return "El medicamento no esta en la lista";
        }
    }

    public static void actualizar(ArrayList<Persona> person) {
        File archivo = new File(nombreArchivo);

        try {
            PrintWriter salida = new PrintWriter(new FileWriter(archivo, false));

            for (Persona persona : person) {
                String contenido = persona.getNombre() + "; " + persona.getDia() + "; " + persona.getHora() + "; " + persona.getDosis();
                salida.println(contenido);
            }
            salida.close();
        } catch (IOException ex) {
            ex.printStackTrace(System.out);
        }
    }
}
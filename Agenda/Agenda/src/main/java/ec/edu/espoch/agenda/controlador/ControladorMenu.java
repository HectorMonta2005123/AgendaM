
package ec.edu.espoch.agenda.controlador;

import ec.edu.espoch.agenda.modelo.Archivo;
import ec.edu.espoch.agenda.modelo.Persona;
import ec.edu.espoch.agenda.vista.Ingresar;
import ec.edu.espoch.agenda.vista.Listado;
import ec.edu.espoch.agenda.vista.Menu;
import ec.edu.espoch.agenda.vista.Modificar;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class ControladorMenu {
    private Menu menu;
    private Ingresar ingresar;
    private Modificar modificar;
    private Listado listado;
    private Archivo archivo;
    
    public ControladorMenu(Menu menu) {
        this.menu = menu;
    }

    public void proceso(String accion) {

        Archivo.crearArchivo();
        switch (accion) {
            case "Ingresar":
                ingresar = new Ingresar();
                ingresar.setSize(300, 350);
                ingresar.setVisible(true);
                break;
            case "Listar":
                listado = new Listado();     
                break;
             case "Modificar":
                modificar = new Modificar();
                modificar.setSize(400, 400);
                modificar.setVisible(true);
                break;
            case "Eliminar":           
                ArrayList<Persona> person = Archivo.leerArchivo();
                String medicaDelete = JOptionPane.showInputDialog("Ingrese el medicamento a eliminar:");
                if (medicaDelete != null) {
                    int pos = Archivo.verificarNombre(person, medicaDelete);
                    if (pos != -1) {
                        person.remove(pos);
                        Archivo.actualizar(person);
                    } else {
                        JOptionPane.showMessageDialog(null, "El medicamento no está en la lista.");
                    }
                }
                break;
            default:
                throw new AssertionError();
        }
    }
}


package ec.edu.espoch.agenda.vista;

import ec.edu.espoch.agenda.controlador.ControladorListado;
import ec.edu.espoch.agenda.modelo.Persona;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Listado extends javax.swing.JFrame {

    private ControladorListado controlador;

    public Listado() {
        initComponents();
        controlador = new ControladorListado(this);
        controlador.procesoListado();
        
    }

    public void mostrar(ArrayList<Persona> personas) {
    JFrame objListar = new JFrame("DATOS DE ARCHIVO");

    JTable datosPersonas = new JTable();
    DefaultTableModel model = new DefaultTableModel();
    model.setColumnIdentifiers(new Object[]{"Medicamento", "Día", "Hora", "Dosis"});

    for (Persona persona : personas) {
        model.addRow(new Object[]{persona.getNombre(), persona.getDia(), persona.getHora(), persona.getDosis()});
    }

    datosPersonas.setModel(model);
    objListar.add(new JScrollPane(datosPersonas));  
    objListar.setSize(500, 400);
    objListar.setVisible(true);
    }  
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 464, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 451, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}

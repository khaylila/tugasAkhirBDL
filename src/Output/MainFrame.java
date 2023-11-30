/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Output;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.swing.JOptionPane;

/**
 *
 * @author milea
 */
public class MainFrame extends javax.swing.JFrame {
    protected EntityManager entityManager;
    
    public MainFrame(){
        this.entityManager = Persistence.createEntityManagerFactory("tugasAkhirBDLPU").createEntityManager();
    }
    
    protected void peringatan(String pesan) {
        JOptionPane.showMessageDialog(rootPane, pesan);
    }
}

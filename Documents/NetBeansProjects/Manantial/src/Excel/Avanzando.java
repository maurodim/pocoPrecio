/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Excel;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JProgressBar;

/**
 *
 * @author Usuario
 */
public class Avanzando implements Runnable{
    JProgressBar bar;
    private int maximo;

    public JProgressBar getBar() {
        return bar;
    }

    public void setBar(JProgressBar bar) {
        this.bar = bar;
    }
    
    public void setMaximo(int maximo) {
        this.maximo = maximo;
    }
    
    
    @Override
    public void run() {
        for(int i=0;i < maximo;i++){
            try {
                Thread.sleep(100);
            } catch (InterruptedException ex) {
                Logger.getLogger(Avanzando.class.getName()).log(Level.SEVERE, null, ex);
            }
            this.bar.setValue(i);
            if(this.bar.getValue()==maximo)JOptionPane.showMessageDialog(null,"PROCESO REALIZADO");
        }
    }
    
}

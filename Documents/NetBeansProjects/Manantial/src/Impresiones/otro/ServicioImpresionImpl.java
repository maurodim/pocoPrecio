/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Impresiones.otro;

/**
 *
 * @author andy
 */
public class ServicioImpresionImpl {

    public ServicioImpresionImpl() {
    }
    
    public void prueba(){
       /* int margin = 0;
        String output = ticket;
        JTextPane jtp = new JTextPane();
        jtp.setText(output);
        jtp.setFont(new Font(Font.MONOSPACED, 0 , 8));    
        PrinterJob printerJob = PrinterJob.getPrinterJob();
        PageFormat pageFormat = printerJob.defaultPage();        
        Paper paper = new Paper();      
        //paper.setSize(180.0, (double) (paper.getHeight() + lines * 10.0));
        paper.setImageableArea(margin, margin, paper.getWidth() - margin * 2, paper.getHeight() - margin * 2);
        pageFormat.setPaper(paper);        
        pageFormat.setOrientation(PageFormat.PORTRAIT);
        printerJob.setPrintable(jtp.getPrintable(null, null), pageFormat);
        printerJob.print();  */
       
       /*
        POR SI ALGUNA VEZ LES SIRVE AQUI SE LOS DEJO:
ESTO FUNCIONA CON UNA IMPRESORA DE TICKETS EPSON TM-U220 CONECTADA AL PUERTO COM4.....

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class MainClass {
public static void main(String[] args) {
try {
FileWriter fw = new FileWriter("COM4:");

PrintWriter pw = new PrintWriter(fw);
String s = "PROBANDO ";

int i, len = s.length();

for (i = 0; len > 80; i += 80) {
pw.print(s.substring(i, i + 80));
pw.print("\r\n");
len -= 80;
}

if (len > 0) {
pw.print(s.substring(i));
pw.print("\r\n");
}

pw.close();
} catch (IOException e) {
System.out.println(e);
}
}
}
       */
    }
    
}

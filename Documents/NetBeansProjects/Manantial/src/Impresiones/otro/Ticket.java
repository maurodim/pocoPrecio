/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Impresiones.otro;

import java.util.ArrayList;
import javax.print.Doc;
import javax.print.DocFlavor;
import javax.print.DocPrintJob;
import javax.print.PrintService;
import javax.print.PrintServiceLookup;
import javax.print.SimpleDoc;

/**
 *
 * @author mauro
 */
public class Ticket {

    private ArrayList<String> CabezaLineas = new ArrayList<String>();
    private ArrayList<String> subCabezaLineas = new ArrayList<String>();
    private ArrayList<String> items = new ArrayList<String>();
    private ArrayList<String> totales = new ArrayList<String>();
    private ArrayList<String> LineasPie = new ArrayList<String>();

    public void AddCabecera(String line) {
        CabezaLineas.add(line);
    }

    public void AddSubCabecera(String line) {
        subCabezaLineas.add(line);
    }

    public void AddItem(String cantidad, String item, String price) {
        OrderItem newItem = new OrderItem(' ');
        items.add(newItem.GeneraItem(cantidad, item, price));
    }

    public void AddTotal(String name, String price) {
        OrderTotal newTotal = new OrderTotal(' ');
        totales.add(newTotal.GeneraTotal(name, price));
    }

    public void AddPieLinea(String line) {
        LineasPie.add(line);
    }

    public String DibujarLinea(int valor) {
        String raya = "";
        for (int x = 0; x < valor; x++) {
            raya += "=";
        }
        return raya;
    }

    public String DarEspacio() {
        return "\n";
    }

    public void ImprimirDocumento() {
        String cadena = "";
        for (int cabecera = 0; cabecera < CabezaLineas.size(); cabecera++) {
            cadena += CabezaLineas.get(cabecera);
        }
        for (int subcabecera = 0; subcabecera < subCabezaLineas.size(); subcabecera++) {
            cadena += subCabezaLineas.get(subcabecera);
        }
        for (int ITEM = 0; ITEM < items.size(); ITEM++) {
            cadena += items.get(ITEM);
        }
        for (int total = 0; total < totales.size(); total++) {
            cadena += totales.get(total);
        }
        for (int pie = 0; pie < LineasPie.size(); pie++) {
            cadena += LineasPie.get(pie);
        }

        DocFlavor flavor = DocFlavor.BYTE_ARRAY.AUTOSENSE;
        PrintService service = PrintServiceLookup.lookupDefaultPrintService();
        DocPrintJob pj = service.createPrintJob();
        byte[] bytes = cadena.getBytes();
        Doc doc = new SimpleDoc(bytes, flavor, null);
        try {
            pj.print(doc, null);
        } catch (Exception e) {
        }
    }
}

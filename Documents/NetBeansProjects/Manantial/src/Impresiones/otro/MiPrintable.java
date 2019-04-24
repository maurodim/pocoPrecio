/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Impresiones.otro;

import Articulos.Articulos;
import conversiones.Numeros;
import interfaceGraficasManantial.Inicio;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Iterator;
import objetosR.Comprobantes;

/**
 *
 * @author mauro
 */
public class MiPrintable implements Printable{
    private Comprobantes caja;

    public MiPrintable(Comprobantes caja) {
        this.caja = caja;

    }

    public void setCaja(Comprobantes caja) {
        this.caja = caja;
    }

    @Override
    public int print(Graphics grphcs, PageFormat pf, int i) throws PrinterException {

        if (i == 0) {
            Calendar fecha = new GregorianCalendar();
            int dia = fecha.get(Calendar.DAY_OF_MONTH);
            int mes = fecha.get(Calendar.MONTH);
            mes++;
            int ano = fecha.get(Calendar.YEAR);
            int hora = fecha.get(Calendar.HOUR_OF_DAY);
            int minuto = fecha.get(Calendar.MINUTE);
            int segundo = fecha.get(Calendar.SECOND);
            String fec = dia + "/" + mes + "/" + ano;
            String hrs = hora + "," + minuto + ":" + segundo;
            Font fuente1 = new Font("Arial", Font.BOLD, 26);
            Font fuente11 = new Font("Arial", Font.BOLD, 10);
            Font fuente12 = new Font("Arial", Font.BOLD, 9);
            grphcs.setFont(fuente11);
            grphcs.drawString("Poco Precio", 73, 80);
            Font fuente3 = new Font("Arial", Font.PLAIN, 8);
            grphcs.setFont(fuente3);
            grphcs.drawString("Comprobante " + caja.getNumero(), 73, 90);
            grphcs.drawString("Fecha " + fec + " " + hrs, 73, 100);
            grphcs.setFont(fuente3);
            grphcs.drawString("Cajero " + Inicio.usuario.getNombre(), 73, 110);
            Iterator itRem1 = caja.getListadoDeArticulos().listIterator();
            Double costoTotal = 0.00;
            int columna = 120;
            String cann = "";
            String costo = "";
            String venta = "";
            String desc = "";
            int cantiL = 0;
            Font fuente4 = new Font("Arial", Font.PLAIN, 6);
            grphcs.setFont(fuente4);
            while (itRem1.hasNext()) {
                Articulos articulo = (Articulos) itRem1.next();

                cann = String.valueOf(articulo.getCantidad());
                costo = String.valueOf(articulo.getPrecioDeCosto());
                venta = Numeros.ConvetirNumeroDosDigitos(articulo.getPrecioUnitario());
                grphcs.drawString(cann, 73, columna);
                cantiL = articulo.getDescripcionArticulo().length();
                if (cantiL > 40) {
                    desc = articulo.getDescripcionArticulo().substring(0, 40);
                } else {
                    desc = articulo.getDescripcionArticulo();
                }
                grphcs.drawString(desc, 93, columna);

                grphcs.drawString("$ " + venta, 200, columna);
                if (articulo.getPrecioDeCosto() != null) {
                    costoTotal = costoTotal + (articulo.getPrecioDeCosto() * articulo.getCantidad());
                }
                columna = columna + 10;
            }

            columna = columna + 20;
            grphcs.setFont(fuente12);
            grphcs.drawString("TOTAL : $" + Numeros.ConvetirNumeroDosDigitos(caja.getMontoTotal()), 73, columna);

            return PAGE_EXISTS;
        } else {
            return NO_SUCH_PAGE;
        }
    }
}

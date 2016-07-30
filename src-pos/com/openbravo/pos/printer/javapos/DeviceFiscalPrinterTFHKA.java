package com.openbravo.pos.printer.javapos;

import com.openbravo.beans.LocaleResources;
import com.openbravo.pos.forms.AppLocal;
import com.openbravo.pos.printer.DeviceFiscalPrinter;
import tfhka.PrinterException;
import tfhka.SVPrinterData;
import tfhka.ve.Tfhka;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

/**
 * Created by Saul on 7/28/2016.
 */
public class DeviceFiscalPrinterTFHKA extends javax.swing.JPanel implements DeviceFiscalPrinter {

    private String fiscalName;
    private JButton xReport;
    private static Tfhka fiscalPrinter;
    private static SVPrinterData fiscalPrinterModel;
    
    public DeviceFiscalPrinterTFHKA(String fiscalName){
        this.fiscalName = fiscalName;
        if ( fiscalPrinter == null ){
            fiscalPrinter = new Tfhka();
            fiscalPrinter.OpenFpctrl("COM99");
            try {
                fiscalPrinterModel = fiscalPrinter.getSVPrinterData();
            } catch (PrinterException e) {
                e.printStackTrace();
            }
        }
        
        initComponents();
    }

    private void initComponents() {
        this.xReport = new JButton(AppLocal.getIntString("Button.XReport"));
        this.xReport.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                printXReport();
            }
        });
        this.xReport.setBounds(30, 10, 130, 23);
        add(this.xReport);
        
        setLayout(null);
        
    }

    @Override
    public String getFiscalName() {
        return fiscalPrinterModel.getModel();
    }

    @Override
    public JComponent getFiscalComponent() {
        return this;
    }

    @Override
    public void beginReceipt() {
        System.out.println("BEGIN RECEIPT");
    }

    @Override
    public void endReceipt() {
        try {
            fiscalPrinter.SendCmd("101");
        } catch (PrinterException e) {
            e.printStackTrace();
        }
        System.out.println("END RECEIPT");
    }

    @Override
    public void printLine(String sproduct, double dprice, double dunits, int taxinfo) {
        System.out.println("PRINT LINE{sproduct=" + sproduct + ", dprice=" + dprice + ",dunits=" + dunits + ",taxinfo=" + taxinfo+"}");
        DecimalFormat decimalFormatPrice = new DecimalFormat("#00000000.00");
        DecimalFormat decimalFormatUnit = new DecimalFormat("#00000.000");
        sproduct = sproduct.substring(0, Math.min(20, sproduct.length()));
        
        String taxMapper = " !\"#";
        try {
            fiscalPrinter.SendCmd(taxMapper.charAt(taxinfo) + decimalFormatPrice.format(dprice).replaceAll(",", "") + decimalFormatUnit.format(dunits).replaceAll(",", "") + sproduct);
        } catch (PrinterException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void printMessage(String smessage) {
        System.out.println("PRINT MESSAGE{" + smessage + "}");
    }

    @Override
    public void printTotal(String sPayment, double dpaid) {
        System.out.println("PRINT TOTAL{sPayment=" + sPayment +",dpaid=" +dpaid+"}");
    }

    @Override
    public void printZReport() {
        System.out.println("PRINT Z REPORT");
    }

    @Override
    public void printXReport() {
        try {
            fiscalPrinter.printXReport();
        } catch (PrinterException e) {
            e.printStackTrace();
        }
    }
}

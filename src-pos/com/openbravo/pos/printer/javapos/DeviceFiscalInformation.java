package com.openbravo.pos.printer.javapos;

import tfhka.ve.ReportData;
import tfhka.ve.S1PrinterData;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Date;

public class DeviceFiscalInformation {
    private int numberOfLastZReport;
    private Date ZReportDate;
    private Date lastInvoiceDate;
    private double freeSalesTax;
    private double generalRate1Sale;
    private double generalRate1Tax;
    private double reducedRate2Sale;
    private double reducedRate2Tax;
    private double additionalRate3Sale;
    private double additionalRate3Tax;
    private double freeTaxDevolution;
    private double generalRateDevolution;
    private double generalRateTaxDevolution;
    private double reducedRateDevolution;
    private double reducedRateTaxDevolution;
    private double additionalRateDevolution;
    private double additionalRateTaxDevolution;
    private double freeTaxDebit;
    private double generalRateDebit;
    private double generalRateTaxDebit;
    private double reducedRateDebit;
    private double reducedRateTaxDebit;
    private double additionalRateDebit;
    private double additionalRateTaxDebit;
    private int numberOfLastInvoice;
    private int numberOfLastCreditNote;
    private int numberOfLastDebitNote;
    private int numberOfLastNonFiscal;
    private String registeredMachineNumber;

    public DeviceFiscalInformation(){

    }

    public DeviceFiscalInformation(ReportData tfhkaData, S1PrinterData s1PrinterData){
        // We get the fields using reflection...
        Class classReportData = tfhkaData.getClass();
        for (Method method : classReportData.getDeclaredMethods()){
            int modifiers = method.getModifiers();
            if (Modifier.isPublic(modifiers) || Modifier.isProtected(modifiers)){
                String name = method.getName();
                if ( name.startsWith("get") ){
                    String realName = name.substring(3);

                    try {
                        Method classReportDataMethod = classReportData.getMethod(name);
                        Object setData = classReportDataMethod.invoke(tfhkaData);
                        Method setMethod = this.getClass().getMethod("set" + realName, classReportDataMethod.getReturnType());
                        setMethod.invoke(this, setData);
                    } catch (Exception e) {
                        // TODO
                    }
                }
            }
        }

        this.setRegisteredMachineNumber(s1PrinterData.getRegisteredMachineNumber());
    }

    public int getNumberOfLastZReport() {
        return numberOfLastZReport;
    }

    public void setNumberOfLastZReport(int numberOfLastZReport) {
        this.numberOfLastZReport = numberOfLastZReport;
    }

    public Date getZReportDate() {
        return ZReportDate;
    }

    public void setZReportDate(Date ZReportDate) {
        this.ZReportDate = ZReportDate;
    }

    public Date getLastInvoiceDate() {
        return lastInvoiceDate;
    }

    public void setLastInvoiceDate(Date lastInvoiceDate) {
        this.lastInvoiceDate = lastInvoiceDate;
    }

    public double getFreeSalesTax() {
        return freeSalesTax;
    }

    public void setFreeSalesTax(double freeSalesTax) {
        this.freeSalesTax = freeSalesTax;
    }

    public double getGeneralRate1Sale() {
        return generalRate1Sale;
    }

    public void setGeneralRate1Sale(double generalRate1Sale) {
        this.generalRate1Sale = generalRate1Sale;
    }

    public double getGeneralRate1Tax() {
        return generalRate1Tax;
    }

    public void setGeneralRate1Tax(double generalRate1Tax) {
        this.generalRate1Tax = generalRate1Tax;
    }

    public double getReducedRate2Sale() {
        return reducedRate2Sale;
    }

    public void setReducedRate2Sale(double reducedRate2Sale) {
        this.reducedRate2Sale = reducedRate2Sale;
    }

    public double getReducedRate2Tax() {
        return reducedRate2Tax;
    }

    public void setReducedRate2Tax(double reducedRate2Tax) {
        this.reducedRate2Tax = reducedRate2Tax;
    }

    public double getAdditionalRate3Sale() {
        return additionalRate3Sale;
    }

    public void setAdditionalRate3Sale(double additionalRate3Sale) {
        this.additionalRate3Sale = additionalRate3Sale;
    }

    public double getAdditionalRate3Tax() {
        return additionalRate3Tax;
    }

    public void setAdditionalRate3Tax(double additionalRate3Tax) {
        this.additionalRate3Tax = additionalRate3Tax;
    }

    public double getFreeTaxDevolution() {
        return freeTaxDevolution;
    }

    public void setFreeTaxDevolution(double freeTaxDevolution) {
        this.freeTaxDevolution = freeTaxDevolution;
    }

    public double getGeneralRateDevolution() {
        return generalRateDevolution;
    }

    public void setGeneralRateDevolution(double generalRateDevolution) {
        this.generalRateDevolution = generalRateDevolution;
    }

    public double getGeneralRateTaxDevolution() {
        return generalRateTaxDevolution;
    }

    public void setGeneralRateTaxDevolution(double generalRateTaxDevolution) {
        this.generalRateTaxDevolution = generalRateTaxDevolution;
    }

    public double getReducedRateDevolution() {
        return reducedRateDevolution;
    }

    public void setReducedRateDevolution(double reducedRateDevolution) {
        this.reducedRateDevolution = reducedRateDevolution;
    }

    public double getReducedRateTaxDevolution() {
        return reducedRateTaxDevolution;
    }

    public void setReducedRateTaxDevolution(double reducedRateTaxDevolution) {
        this.reducedRateTaxDevolution = reducedRateTaxDevolution;
    }

    public double getAdditionalRateDevolution() {
        return additionalRateDevolution;
    }

    public void setAdditionalRateDevolution(double additionalRateDevolution) {
        this.additionalRateDevolution = additionalRateDevolution;
    }

    public double getAdditionalRateTaxDevolution() {
        return additionalRateTaxDevolution;
    }

    public void setAdditionalRateTaxDevolution(double additionalRateTaxDevolution) {
        this.additionalRateTaxDevolution = additionalRateTaxDevolution;
    }

    public double getFreeTaxDebit() {
        return freeTaxDebit;
    }

    public void setFreeTaxDebit(double freeTaxDebit) {
        this.freeTaxDebit = freeTaxDebit;
    }

    public double getGeneralRateDebit() {
        return generalRateDebit;
    }

    public void setGeneralRateDebit(double generalRateDebit) {
        this.generalRateDebit = generalRateDebit;
    }

    public double getGeneralRateTaxDebit() {
        return generalRateTaxDebit;
    }

    public void setGeneralRateTaxDebit(double generalRateTaxDebit) {
        this.generalRateTaxDebit = generalRateTaxDebit;
    }

    public double getReducedRateDebit() {
        return reducedRateDebit;
    }

    public void setReducedRateDebit(double reducedRateDebit) {
        this.reducedRateDebit = reducedRateDebit;
    }

    public double getReducedRateTaxDebit() {
        return reducedRateTaxDebit;
    }

    public void setReducedRateTaxDebit(double reducedRateTaxDebit) {
        this.reducedRateTaxDebit = reducedRateTaxDebit;
    }

    public double getAdditionalRateDebit() {
        return additionalRateDebit;
    }

    public void setAdditionalRateDebit(double additionalRateDebit) {
        this.additionalRateDebit = additionalRateDebit;
    }

    public double getAdditionalRateTaxDebit() {
        return additionalRateTaxDebit;
    }

    public void setAdditionalRateTaxDebit(double additionalRateTaxDebit) {
        this.additionalRateTaxDebit = additionalRateTaxDebit;
    }

    public int getNumberOfLastInvoice() {
        return numberOfLastInvoice;
    }

    public void setNumberOfLastInvoice(int numberOfLastInvoice) {
        this.numberOfLastInvoice = numberOfLastInvoice;
    }

    public int getNumberOfLastCreditNote() {
        return numberOfLastCreditNote;
    }

    public void setNumberOfLastCreditNote(int numberOfLastCreditNote) {
        this.numberOfLastCreditNote = numberOfLastCreditNote;
    }

    public int getNumberOfLastDebitNote() {
        return numberOfLastDebitNote;
    }

    public void setNumberOfLastDebitNote(int numberOfLastDebitNote) {
        this.numberOfLastDebitNote = numberOfLastDebitNote;
    }

    public int getNumberOfLastNonFiscal() {
        return numberOfLastNonFiscal;
    }

    public void setNumberOfLastNonFiscal(int numberOfLastNonFiscal) {
        this.numberOfLastNonFiscal = numberOfLastNonFiscal;
    }

    public String getRegisteredMachineNumber() {
        return registeredMachineNumber;
    }

    public void setRegisteredMachineNumber(String registeredMachineNumber) {
        this.registeredMachineNumber = registeredMachineNumber;
    }
}

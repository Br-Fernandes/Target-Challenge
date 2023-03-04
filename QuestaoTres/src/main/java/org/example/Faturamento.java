package org.example;

import java.util.List;

public class Faturamento {

    private String mes;
    private List<FaturamentoDiario> faturamento;

    public String getMes() {
        return mes;
    }

    public void setMes(String mes) {
        this.mes = mes;
    }

    public List<FaturamentoDiario> getFaturamento() {
        return faturamento;
    }

    public void setFaturamento(List<FaturamentoDiario> faturamento) {
        this.faturamento = faturamento;
    }
}

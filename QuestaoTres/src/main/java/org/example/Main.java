package org.example;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;


public class Main
{
    public static void main( String[] args ) {
        ObjectMapper objectMapper = new ObjectMapper();

        try {
            Faturamento faturamento = objectMapper.readValue(new File("src/main/res/faturamento.json"), Faturamento.class);
            List<FaturamentoDiario> faturamentoDiarioList = faturamento.getFaturamento();

            Comparator<FaturamentoDiario> comparador = Comparator.comparing(FaturamentoDiario::getValor);
            FaturamentoDiario menorValor = Collections.min(faturamentoDiarioList, comparador);
            FaturamentoDiario maiorValor = Collections.max(faturamentoDiarioList, comparador);

            System.out.println("No dia " + menorValor.getDia() +
                    " do mês " + faturamento.getMes() +
                    " teve R$" + menorValor.getValor() +
                    " como menor valor.");

            System.out.println("No dia " + maiorValor.getDia() +
                    " do mês " + faturamento.getMes() +
                    " teve R$" + maiorValor.getValor() +
                    " como maior valor.");

            int qtdeFaturamentos = 0;
            Double somaFaturamento = 0.0;
            for (FaturamentoDiario faturamentoDiario : faturamentoDiarioList) {
                if (faturamentoDiario.getValor() != 0) {
                    somaFaturamento += faturamentoDiario.getValor();
                    qtdeFaturamentos++;
                }
            }
            Double media = somaFaturamento / qtdeFaturamentos;

            int faturamentosAcimaMedia = 0;
            for (FaturamentoDiario faturamentoDiario : faturamentoDiarioList) {
                if (faturamentoDiario.getValor() > media) {
                    faturamentosAcimaMedia++;
                }
            }
            System.out.println(faturamentosAcimaMedia +
                    " dias tiveram um faturamento superior a média de R$" + media+ " reais");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

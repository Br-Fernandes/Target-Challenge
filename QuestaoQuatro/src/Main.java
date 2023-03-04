import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Map<String, Double> faturamento = new HashMap<>();
        faturamento.put("SP", 67836.43);
        faturamento.put("RJ", 36678.66);
        faturamento.put("MG", 29229.88);
        faturamento.put("ES", 27165.48);
        faturamento.put("Outros", 19849.53);

        double faturamentoTotal = 0;
        for (double valor : faturamento.values()) {
            faturamentoTotal += valor;
        }

        Map<String, Double> representacao = new HashMap<>();
        DecimalFormat df = new DecimalFormat("#.##");
        for (Map.Entry<String, Double> entry : faturamento.entrySet()) {
            double percentual = (entry.getValue() / faturamentoTotal) * 100;
        representacao.put(entry.getKey(), Double.valueOf(df.format(percentual).replace(",", ".")));
        }
        
        System.out.println("Faturamento mensal por estado:");
        for (Map.Entry<String, Double> entry : faturamento.entrySet()) {
            System.out.println(entry.getKey() + " - R$" + entry.getValue());
        }

        System.out.println("\nPercentual de representação no faturamento total:");
        for (Map.Entry<String, Double> entry : representacao.entrySet()) {
            System.out.println(entry.getKey() + " - " + entry.getValue() + "%");
        }
    }
}
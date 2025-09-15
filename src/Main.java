import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String... args) {

        final int NUMERO_SIMULACOES = 1000;
        
        // 1. testando diferentes números de caixas
        System.out.println("=== TESTANDO NÚMEROS DE CAIXAS ===");
        int[] numerosCaixas = {1, 2, 3};
        
        for (int numCaixas : numerosCaixas) {
            final List<Double> mediasAtendimento = new ArrayList<>();
            SimulacaoCaixaSupermercado simulador = new SimulacaoCaixaSupermercado();

            for (int i = 0; i < NUMERO_SIMULACOES; i++) {
                simulador.setNumeroCaixas(numCaixas);
                simulador.setMediaAtendimentos(100);
                simulador.setMediaTempoAtendimentoPorCliente(5.00);
                simulador.setDesvioPadraoTempoAtendimentoPorCliente(0.50);

                double mediaAtendimento = simulador.simular();
                mediasAtendimento.add(mediaAtendimento);
            }

            double media = media(mediasAtendimento);
            double dp = desvioPadrao(mediasAtendimento, media);

            System.out.printf("%d caixa(s): Média = %.3f min, Desvio = %.3f min%n", 
                    numCaixas, media, dp);
        }
        
        // 2. testando diferentes desvios padrão
        System.out.println("\n=== TESTANDO DIFERENTES DESVIOS PADRÃO ===");
        double[] desviosPadrao = {0.25, 1.0, 2.0};
        
        for (double sigma : desviosPadrao) {
            final List<Double> mediasAtendimento = new ArrayList<>();
            SimulacaoCaixaSupermercado simulador = new SimulacaoCaixaSupermercado();

            for (int i = 0; i < NUMERO_SIMULACOES; i++) {
                simulador.setNumeroCaixas(1);
                simulador.setMediaAtendimentos(100);
                simulador.setMediaTempoAtendimentoPorCliente(5.00);
                simulador.setDesvioPadraoTempoAtendimentoPorCliente(sigma);

                double mediaAtendimento = simulador.simular();
                mediasAtendimento.add(mediaAtendimento);
            }

            double media = media(mediasAtendimento);
            double dp = desvioPadrao(mediasAtendimento, media);

            System.out.printf("σ = %.2f: Média = %.3f min, Desvio = %.3f min%n", 
                    sigma, media, dp);
        }
    }   

    private static double media(List<Double> xs) {
        double s = 0.0;
        for (double x : xs) s += x;
        return s / xs.size();
    }

    private static double desvioPadrao(List<Double> xs, double m) {
        double s2 = 0.0;
        for (double x : xs) {
            double d = x - m;
            s2 += d * d;
        }
        return Math.sqrt(s2 / (xs.size() - 1));
    }
}
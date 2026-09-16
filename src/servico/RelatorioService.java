package servico;

import modelo.Veiculo;

public class RelatorioService {

    public void apresentarRelatorio(GestorFrota gestor) {
        if (gestor == null) {
            throw new IllegalArgumentException("O gestor nao pode ser nulo.");
        }

        System.out.println();
        System.out.println("========== RELATORIO DA FROTA ==========");
        System.out.println("Numero total de veiculos: " + gestor.getNumeroVeiculos());
        gestor.listarVeiculos();

        double autonomiaTotal = 0;

        for (Veiculo veiculo : gestor.obterVeiculos()) {
            autonomiaTotal += veiculo.calcularAutonomia();
        }

        if (gestor.getNumeroVeiculos() > 0) {
            double media = autonomiaTotal / gestor.getNumeroVeiculos();
            System.out.printf("Autonomia media: %.2f km%n", media);
        }

        System.out.println("=========================================");
    }
}

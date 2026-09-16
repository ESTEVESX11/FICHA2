package principal;

import modelo.Camiao;
import modelo.Carro;
import modelo.Mota;
import servico.GestorFrota;
import servico.RelatorioService;

public class Main {

    public static void main(String[] args) {
        GestorFrota gestor = new GestorFrota();

        Carro carro = new Carro(
            "AA-12-BB", 180, 7.0, 55, 5
        );

        Mota mota = new Mota(
            "CC-34-DD", 130, 3.5, 18, true
        );

        Camiao camiao = new Camiao(
            "EE-56-FF", 100, 22.0, 300, 12000
        );

        gestor.adicionarVeiculo(carro);
        gestor.adicionarVeiculo(mota);
        gestor.adicionarVeiculo(camiao);

        RelatorioService relatorio = new RelatorioService();
        relatorio.apresentarRelatorio(gestor);

        System.out.println();
        System.out.println("========== TESTE DE VELOCIDADE ==========");
        System.out.println("Carro a 120 km/h: " + carro.velocidadeValida(120));
        System.out.println("Carro a 200 km/h: " + carro.velocidadeValida(200));

        System.out.println();
        System.out.println("========== TESTE DE EXCECOES ==========");

        try {
            carro.setMatricula("MATRICULA-ERRADA");
        } catch (IllegalArgumentException e) {
            System.out.println("Excecao de matricula: " + e.getMessage());
        }

        try {
            mota.setCapacidadeDeposito(0);
        } catch (IllegalArgumentException e) {
            System.out.println("Excecao de deposito: " + e.getMessage());
        }

        try {
            camiao.setCapacidadeCarga(-500);
        } catch (IllegalArgumentException e) {
            System.out.println("Excecao de carga: " + e.getMessage());
        }

        try {
            gestor.adicionarVeiculo(
                new Carro("AA-12-BB", 150, 6.5, 50, 5)
            );
        } catch (IllegalArgumentException e) {
            System.out.println("Excecao de matricula duplicada: " + e.getMessage());
        }
    }
}

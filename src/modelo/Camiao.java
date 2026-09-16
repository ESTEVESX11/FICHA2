package modelo;

public class Camiao extends Veiculo {
    private double capacidadeCarga;

    public static final double CARGA_MINIMA = 0.1;

    public Camiao(String matricula, double velocidadeMaxima,
                  double consumoMedio, double capacidadeDeposito,
                  double capacidadeCarga) {
        super(matricula, velocidadeMaxima, consumoMedio, capacidadeDeposito);
        setCapacidadeCarga(capacidadeCarga);
    }

    public double getCapacidadeCarga() {
        return capacidadeCarga;
    }

    public void setCapacidadeCarga(double capacidadeCarga) {
        if (capacidadeCarga <= 0) {
            throw new IllegalArgumentException(
                "A capacidade de carga deve ser superior a zero."
            );
        }
        this.capacidadeCarga = capacidadeCarga;
    }

    @Override
    public double calcularAutonomia() {
        double fatorCarga = 1 + (capacidadeCarga / 10000);
        return getCapacidadeDeposito() / (getConsumoMedio() * fatorCarga) * 100;
    }

    @Override
    public String descrever() {
        return "Camiao | " + informacaoBase()
            + ", Carga: " + capacidadeCarga + " kg"
            + ", Autonomia: " + String.format("%.2f", calcularAutonomia()) + " km";
    }
}

package modelo;

public class Carro extends Veiculo {
    private int numeroPassageiros;

    public static final int NUMERO_PASSAGEIROS_PADRAO = 5;

    public Carro(String matricula, double velocidadeMaxima,
                 double consumoMedio, double capacidadeDeposito,
                 int numeroPassageiros) {
        super(matricula, velocidadeMaxima, consumoMedio, capacidadeDeposito);
        setNumeroPassageiros(numeroPassageiros);
    }

    public int getNumeroPassageiros() {
        return numeroPassageiros;
    }

    public void setNumeroPassageiros(int numeroPassageiros) {
        if (numeroPassageiros <= 0) {
            throw new IllegalArgumentException(
                "O numero de passageiros deve ser superior a zero."
            );
        }
        this.numeroPassageiros = numeroPassageiros;
    }

    @Override
    public double calcularAutonomia() {
        return getCapacidadeDeposito() / getConsumoMedio() * 100;
    }

    @Override
    public String descrever() {
        return "Carro | " + informacaoBase()
            + ", Passageiros: " + numeroPassageiros
            + ", Autonomia: " + String.format("%.2f", calcularAutonomia()) + " km";
    }
}

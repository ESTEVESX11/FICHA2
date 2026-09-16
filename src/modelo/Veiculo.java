package modelo;

public abstract class Veiculo {
    private String matricula;
    private double velocidadeMaxima;
    private double consumoMedio;
    private double capacidadeDeposito;

    public static final double VELOCIDADE_MAXIMA_PADRAO = 120.0;
    public static final double CAPACIDADE_DEPOSITO_PADRAO = 50.0;

    protected Veiculo(String matricula, double velocidadeMaxima,
                      double consumoMedio, double capacidadeDeposito) {
        setMatricula(matricula);
        setVelocidadeMaxima(velocidadeMaxima);
        setConsumoMedio(consumoMedio);
        setCapacidadeDeposito(capacidadeDeposito);
    }

    public String getMatricula() {
        return matricula;
    }

    public final void setMatricula(String matricula) {
        if (matricula == null || !matricula.matches("[A-Z]{2}-\\d{2}-[A-Z]{2}")) {
            throw new IllegalArgumentException(
                "Matricula invalida. Use o formato AA-00-AA."
            );
        }
        this.matricula = matricula;
    }

    public double getVelocidadeMaxima() {
        return velocidadeMaxima;
    }

    public void setVelocidadeMaxima(double velocidadeMaxima) {
        if (velocidadeMaxima < 0) {
            throw new IllegalArgumentException(
                "A velocidade maxima nao pode ser negativa."
            );
        }
        this.velocidadeMaxima = velocidadeMaxima;
    }

    public double getConsumoMedio() {
        return consumoMedio;
    }

    public void setConsumoMedio(double consumoMedio) {
        if (consumoMedio <= 0) {
            throw new IllegalArgumentException(
                "O consumo medio deve ser superior a zero."
            );
        }
        this.consumoMedio = consumoMedio;
    }

    public double getCapacidadeDeposito() {
        return capacidadeDeposito;
    }

    public void setCapacidadeDeposito(double capacidadeDeposito) {
        if (capacidadeDeposito <= 0) {
            throw new IllegalArgumentException(
                "A capacidade do deposito deve ser superior a zero."
            );
        }
        this.capacidadeDeposito = capacidadeDeposito;
    }

    public final boolean velocidadeValida(double velocidade) {
        return velocidade >= 0 && velocidade <= velocidadeMaxima;
    }

    public abstract double calcularAutonomia();

    public abstract String descrever();

    protected String informacaoBase() {
        return "Matricula: " + matricula
            + ", Velocidade maxima: " + velocidadeMaxima + " km/h"
            + ", Consumo: " + consumoMedio + " L/100km"
            + ", Deposito: " + capacidadeDeposito + " L";
    }
}

package modelo;

public class Mota extends Veiculo {
    private boolean temCaixaTransporte;

    public static final double CONSUMO_MINIMO_MOTA = 1.0;

    public Mota(String matricula, double velocidadeMaxima,
                double consumoMedio, double capacidadeDeposito,
                boolean temCaixaTransporte) {
        super(matricula, velocidadeMaxima, consumoMedio, capacidadeDeposito);
        setTemCaixaTransporte(temCaixaTransporte);
    }

    public boolean isTemCaixaTransporte() {
        return temCaixaTransporte;
    }

    public void setTemCaixaTransporte(boolean temCaixaTransporte) {
        this.temCaixaTransporte = temCaixaTransporte;
    }

    @Override
    public double calcularAutonomia() {
        return getCapacidadeDeposito() / getConsumoMedio() * 100;
    }

    @Override
    public String descrever() {
        return "Mota | " + informacaoBase()
            + ", Caixa de transporte: " + (temCaixaTransporte ? "Sim" : "Nao")
            + ", Autonomia: " + String.format("%.2f", calcularAutonomia()) + " km";
    }
}

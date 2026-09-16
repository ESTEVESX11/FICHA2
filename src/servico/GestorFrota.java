package servico;

import java.util.ArrayList;
import java.util.List;
import modelo.Veiculo;

public class GestorFrota {
    private final List<Veiculo> veiculos;

    public GestorFrota() {
        veiculos = new ArrayList<>();
    }

    public void adicionarVeiculo(Veiculo veiculo) {
        if (veiculo == null) {
            throw new IllegalArgumentException("O veiculo nao pode ser nulo.");
        }

        if (procurarPorMatricula(veiculo.getMatricula()) != null) {
            throw new IllegalArgumentException(
                "Ja existe um veiculo com a matricula " + veiculo.getMatricula() + "."
            );
        }

        veiculos.add(veiculo);
    }

    public Veiculo procurarPorMatricula(String matricula) {
        for (Veiculo veiculo : veiculos) {
            if (veiculo.getMatricula().equals(matricula)) {
                return veiculo;
            }
        }
        return null;
    }

    public boolean removerVeiculo(String matricula) {
        Veiculo veiculo = procurarPorMatricula(matricula);

        if (veiculo != null) {
            return veiculos.remove(veiculo);
        }

        return false;
    }

    public int getNumeroVeiculos() {
        return veiculos.size();
    }

    public void listarVeiculos() {
        if (veiculos.isEmpty()) {
            System.out.println("A frota nao possui veiculos.");
            return;
        }

        for (Veiculo veiculo : veiculos) {
            System.out.println(veiculo.descrever());
        }
    }

    List<Veiculo> obterVeiculos() {
        return new ArrayList<>(veiculos);
    }
}

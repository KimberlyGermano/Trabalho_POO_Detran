import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Ocorrencia> ocorrencias = new ArrayList<>();
        List<RegraMulta> regras = new ArrayList<>();
        List<Multa> multas = new ArrayList<>();

        // Inicialize dados
        ocorrencias.add(new Ocorrencia("Av. Paulista", 50, 22));
        ocorrencias.add(new Ocorrencia("Rua da Consolação", 40, 18));

        regras.add(new RegraCorredorOnibus(6, 20, "Av. Paulista"));

        // Verifique as multas
        for (Ocorrencia ocorrencia : ocorrencias) {
            for (RegraMulta regra : regras) {
                Multa multa = regra.calcularMulta(ocorrencia);
                if (multa != null) {
                    multas.add(multa);
                }
            }
        }

        // Exiba as multas
        if (multas.isEmpty()) {
            System.out.println("Nenhuma multa registrada.");
        } else {
            for (Multa multa : multas) {
                System.out.println(multa);
            }
        }
    }
}

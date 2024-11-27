import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Inicializando listas para armazenar ocorrências, regras e multas
        List<Ocorrencia> ocorrencias = new ArrayList<>();
        List<RegraMulta> regras = new ArrayList<>();
        List<Multa> multas = new ArrayList<>();

        // Passo 1: Inicializar dados de exemplo
        // Adicionando ocorrências
        ocorrencias.add(new Ocorrencia("Avenida Washington Luiz", 80, 22)); // Excesso de velocidade
        ocorrencias.add(new Ocorrencia("Avenida Santo Amaro", 0, 22));      // Corredor de ônibus
        ocorrencias.add(new Ocorrencia("Avenida Bandeirantes", 50, 23));     // Rodízio

        // Adicionando regras
        regras.add(new RegraVelocidade(60, "Avenida Washington Luiz")); // Limite 60 km/h
        regras.add(new RegraCorredorOnibus(6, 23, "Avenida Santo Amaro")); // Corredor das 6h às 23h
        regras.add(new RegraRodizio(2, new String[]{"Avenida Bandeirantes"}, 7, 10)); // Rodízio segunda-feira

        // Passo 2: Processar ocorrências
        for (Ocorrencia ocorrencia : ocorrencias) {
            for (RegraMulta regra : regras) {
                Multa multa = regra.calcularMulta(ocorrencia); // Aplicar regra
                if (multa != null) {
                    multas.add(multa); // Adicionar multa gerada
                }
            }
        }

        // Passo 3: Exibir todas as multas geradas
        System.out.println("Multas Geradas:");
        if (multas.isEmpty()) {
            System.out.println("Nenhuma multa foi registrada.");
        } else {
            for (Multa multa : multas) {
                System.out.println(multa); // Usa o método toString da classe Multa
            }
        }
    }
}


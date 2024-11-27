import java.util.ArrayList;
import java.util.List;

public class BaseDeDados {
    private List<Ocorrencia> ocorrenciasSemProcessar;
    private List<Ocorrencia> ocorrenciasProcessadas;
    private List<Multa> multas;
    private List<RegraMulta> regras;

    public BaseDeDados() {
        this.ocorrenciasSemProcessar = new ArrayList<>();
        this.ocorrenciasProcessadas = new ArrayList<>();
        this.multas = new ArrayList<>();
        this.regras = new ArrayList<>();
    }

    // Inicializa regras de multa (exemplo com várias regras)
    public void inicializaRegras() {
        // Adicionando regras com base nos parâmetros de exemplo. Certifique-se de que os construtores dessas classes de regra suportam os parâmetros fornecidos.
        regras.add(new RegraVelocidade(60, "Avenida Washington Luiz")); // Regra de velocidade com limite de 60
        regras.add(new RegraVelocidade(70, "Avenida Nações Unidas")); // Regra de velocidade com limite de 70
        regras.add(new RegraRodizio(1, new String[]{"Avenida Bandeirantes", "Avenida 23 de Maio"}, 1, 1)); // Regra de rodízio
        regras.add(new RegraCorredorOnibus(6, 23, "Avenida Santo Amaro")); // Corredor de ônibus com horário das 6h às 23h
        regras.add(new RegraCorredorOnibus(0, 24, "Avenida Vereador José Diniz")); // Corredor de ônibus 24 horas
        // Adicione outras regras conforme necessário para atender aos requisitos mínimos
    }

    // Método para adicionar uma ocorrência
    public void adicionarOcorrencia(Ocorrencia ocorrencia) {
        ocorrenciasSemProcessar.add(ocorrencia);
    }

    // Processa todas as ocorrências não processadas e aplica as regras de multa
    public void processar() {
        for (Ocorrencia ocorrencia : ocorrenciasSemProcessar) {
            for (RegraMulta regra : regras) {
                int nivelMulta = regra.verificaNivelMulta(ocorrencia);

                // Se a regra resultar em uma multa, cria e adiciona à lista de multas
                if (nivelMulta > 0) { // 0 indica "sem multa"
                    Multa multa = regra.calcularMulta(ocorrencia);
                    multas.add(multa);
                }
            }
            // Move a ocorrência para a lista de processadas após aplicar as regras
            ocorrenciasProcessadas.add(ocorrencia);
        }
        // Limpa a lista de ocorrências sem processar, pois todas foram movidas para "processadas"
        ocorrenciasSemProcessar.clear();
    }

    // Getters para recuperar informações das listas (multas, ocorrências processadas, etc.)
    public List<Multa> getMultas() {
        return multas;
    }

    public List<Ocorrencia> getOcorrenciasProcessadas() {
        return ocorrenciasProcessadas;
    }

    public List<Ocorrencia> getOcorrenciasSemProcessar() {
        return ocorrenciasSemProcessar;
    }

    public List<RegraMulta> getRegras() {
        return regras;
    }
}



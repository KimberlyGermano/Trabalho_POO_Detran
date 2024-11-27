import java.util.Date;

public class RegraCorredorOnibus extends RegraMulta {
    private int horaInicial;
    private int horaFinal;
    private String nomeLogradouro;

    public RegraCorredorOnibus(int horaInicial, int horaFinal, String nomeLogradouro) {
        this.horaInicial = horaInicial;
        this.horaFinal = horaFinal;
        this.nomeLogradouro = nomeLogradouro;
    }

    @Override
    public int verificaNivelMulta(Ocorrencia o) {
        // Verifica se a ocorrência foi no logradouro correto
        if (o.getNomeLogradouro().equalsIgnoreCase(nomeLogradouro)) {
            int horaOcorrencia = o.getHorario(); // Hora da ocorrência

            // Depuração: Verificando a hora da ocorrência e os limites de horário
            System.out.println("Verificando a ocorrência na " + o.getNomeLogradouro() + " às " + horaOcorrencia + "h");
            System.out.println("Comparando com intervalo de " + horaInicial + "h a " + horaFinal + "h");

            // Verifica se a ocorrência está fora do intervalo permitido
            if (horaOcorrencia < horaInicial || horaOcorrencia > horaFinal) {
                // Se a ocorrência está fora do intervalo de 1 hora antes ou depois, aplica a multa grave
                if (horaOcorrencia < (horaInicial - 1) || horaOcorrencia > (horaFinal + 1)) {
                    System.out.println("Multa Nível 2: Fora do intervalo de 1 hora");
                    return 2; // Nível 2
                } else {
                    System.out.println("Multa Nível 1: Fora do intervalo, mas dentro de 1 hora");
                    return 1; // Nível 1
                }
            }
        }
        return 0; // Sem multa se a regra não for infringida
    }

    @Override
    public Multa calcularMulta(Ocorrencia o) {
        int nivelMulta = verificaNivelMulta(o);

        // Depuração: Verificando o nível da multa
        System.out.println("Nível da multa: " + nivelMulta);

        // Cria a multa com base no nível
        if (nivelMulta == 1) {
            return new Multa(150.0, obterDescricaoMulta() + " - Nível 1", new Date(), o.getPlaca());
        } else if (nivelMulta == 2) {
            return new Multa(300.0, obterDescricaoMulta() + " - Nível 2", new Date(), o.getPlaca());
        }
        return null; // Sem multa se o nível for 0
    }

    @Override
    public String obterDescricaoMulta() {
        return "Multa por tráfego em corredor de ônibus fora do horário permitido";
    }
}

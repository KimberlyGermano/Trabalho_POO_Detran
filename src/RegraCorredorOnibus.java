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
        // Verifica se a ocorrência foi no logradouro e fora do horário permitido
        if (o.getNomeLogradouro().equalsIgnoreCase(nomeLogradouro)) { // Método correto
            int horaOcorrencia = o.getHorario(); // Método correto

            // Se a ocorrência está fora do horário permitido, aplica a multa
            if (horaOcorrencia < horaInicial || horaOcorrencia > horaFinal) {
                // Retorna um nível de multa baseado no quão fora do horário a ocorrência foi
                if (horaOcorrencia < horaInicial - 1 || horaOcorrencia > horaFinal + 1) {
                    return 2; // Multa mais alta para horário fora do limite permitido em 1 hora
                } else {
                    return 1; // Multa padrão para horário fora do intervalo permitido
                }
            }
        }
        return 0; // Sem multa se a regra não for infringida
    }

    @Override
    public Multa calcularMulta(Ocorrencia o) {
        int nivelMulta = verificaNivelMulta(o);

        if (nivelMulta == 1) {
            return new Multa(150.0, obterDescricaoMulta() + " - Nível 1", new Date(), o.getPlaca());
        } else if (nivelMulta == 2) {
            return new Multa(300.0, obterDescricaoMulta() + " - Nível 2", new Date(), o.getPlaca());
        } else {
            return null; // Sem multa se o nível for 0
        }
    }

    @Override
    public String obterDescricaoMulta() {
        return "Multa por tráfego em corredor de ônibus fora do horário permitido";
    }
}

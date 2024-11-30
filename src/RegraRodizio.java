public class RegraRodizio extends RegraMulta {
    private int diaSemana;
    private String[] logradourosPermitidos;
    private int horaInicial;
    private int horaFinal;

    public RegraRodizio(int diaSemana, String[] logradourosPermitidos, int horaInicial, int horaFinal) {
        this.diaSemana = diaSemana;
        this.logradourosPermitidos = logradourosPermitidos;
        this.horaInicial = horaInicial;
        this.horaFinal = horaFinal;
    }

    @Override
    public int verificaNivelMulta(Ocorrencia o) {
        // Implementação da verificação do nível de multa para rodízio
        return 0;
    }

    @Override
    public Multa calcularMulta(Ocorrencia o) {
        // Implementação do cálculo da multa para rodízio
        return null;
    }

    @Override
    public String obterDescricaoMulta() {
        return "Multa por infração ao rodízio";
    }
}


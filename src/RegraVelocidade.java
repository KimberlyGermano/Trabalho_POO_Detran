public class RegraVelocidade extends RegraMulta {
    private int limiteVelocidade;
    private String nomeLogradouro;

    public RegraVelocidade(int limiteVelocidade, String nomeLogradouro) {
        this.limiteVelocidade = limiteVelocidade;
        this.nomeLogradouro = nomeLogradouro;
    }

    @Override
    public int verificaNivelMulta(Ocorrencia o) {
        // Implementação da verificação do nível de multa para velocidade
        return 0;
    }

    @Override
    public Multa calcularMulta(Ocorrencia o) {
        // Implementação do cálculo da multa para velocidade
        return null;
    }

    @Override
    public String obterDescricaoMulta() {
        return "Multa por excesso de velocidade";
    }
}

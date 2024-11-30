public abstract class RegraMulta {
    protected static double valorMultaLeve;
    protected static double valorMultaMedia;
    protected static double valorMultaGrave;

    public abstract int verificaNivelMulta(Ocorrencia o);
    public abstract Multa calcularMulta(Ocorrencia o);
    public abstract String obterDescricaoMulta();
}

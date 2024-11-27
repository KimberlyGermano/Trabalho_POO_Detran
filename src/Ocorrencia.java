import java.util.Date;

public class Ocorrencia {
    private String placa; // Opcional: identificador do veículo
    private Date dataHora; // Opcional: data e hora completos
    private String nomeLogradouro;
    private int velocidadeMedida;
    private int horario; // Indica o horário da ocorrência (hora do dia)
    private int tipoVeiculo; // Opcional: tipo de veículo

    // Construtor principal usado na classe Main
    public Ocorrencia(String nomeLogradouro, int velocidadeMedida, int horario) {
        this.nomeLogradouro = nomeLogradouro;
        this.velocidadeMedida = velocidadeMedida;
        this.horario = horario;
    }

    // Construtor adicional para uso com todos os atributos
    public Ocorrencia(String placa, Date dataHora, String nomeLogradouro, int velocidadeMedida, int horario, int tipoVeiculo) {
        this.placa = placa;
        this.dataHora = dataHora;
        this.nomeLogradouro = nomeLogradouro;
        this.velocidadeMedida = velocidadeMedida;
        this.horario = horario;
        this.tipoVeiculo = tipoVeiculo;
    }

    // Getters e Setters para os atributos

    public String getNomeLogradouro() {
        return nomeLogradouro;
    }

    public void setNomeLogradouro(String nomeLogradouro) {
        this.nomeLogradouro = nomeLogradouro;
    }

    public int getVelocidadeMedida() {
        return velocidadeMedida;
    }

    public void setVelocidadeMedida(int velocidadeMedida) {
        this.velocidadeMedida = velocidadeMedida;
    }

    public int getHorario() {
        return horario;
    }

    public void setHorario(int horario) {
        this.horario = horario;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public Date getDataHora() {
        return dataHora;
    }

    public void setDataHora(Date dataHora) {
        this.dataHora = dataHora;
    }

    public int getTipoVeiculo() {
        return tipoVeiculo;
    }

    public void setTipoVeiculo(int tipoVeiculo) {
        this.tipoVeiculo = tipoVeiculo;
    }

    // Método para exibir a ocorrência (opcional, útil para depuração)
    @Override
    public String toString() {
        return "Ocorrencia{" +
                "placa='" + placa + '\'' +
                ", dataHora=" + dataHora +
                ", nomeLogradouro='" + nomeLogradouro + '\'' +
                ", velocidadeMedida=" + velocidadeMedida +
                ", horario=" + horario +
                ", tipoVeiculo=" + tipoVeiculo +
                '}';
    }
}

import java.util.Date;

public class Multa {
    private double valor; // Valor da multa
    private String motivo; // Motivo ou descrição da multa
    private Date data; // Data da ocorrência da multa
    private String placa; // Placa do veículo associado à multa

    // Construtor principal
    public Multa(double valor, String motivo, Date data, String placa) {
        this.valor = valor;
        this.motivo = motivo;
        this.data = data;
        this.placa = placa;
    }

    // Construtor alternativo para casos mais simples (sem data e placa)
    public Multa(double valor, String motivo) {
        this.valor = valor;
        this.motivo = motivo;
        this.data = new Date(); // Define a data como o momento da criação
        this.placa = ""; // Placa opcional, inicialmente vazia
    }

    // Getters e setters para todos os atributos
    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    // Método para exibir a multa (útil para logs ou relatórios)
    @Override
    public String toString() {
        return "Multa{" +
                "valor=" + valor +
                ", motivo='" + motivo + '\'' +
                ", data=" + data +
                ", placa='" + placa + '\'' +
                '}';
    }
}

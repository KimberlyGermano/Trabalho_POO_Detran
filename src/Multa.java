import java.text.SimpleDateFormat;
import java.util.Date;

public class Multa {
    private double valor;
    private String motivo;
    private Date data;
    private String placa;

    public Multa(double valor, String motivo, Date data, String placa) {
        this.valor = valor;
        this.motivo = motivo;
        this.data = data;
        this.placa = placa;
    }

    @Override
    public String toString() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        return "Multa:\n" +
                "- Valor: R$" + String.format("%.2f", valor) + "\n" +
                "- Motivo: " + motivo + "\n" +
                "- Data: " + sdf.format(data) + "\n" +
                "- Placa: " + (placa != null && !placa.isEmpty() ? placa : "Não informada") + "\n";
    }
}

package objetos;

public class Quarto {
    public int numQuarto;
    public String tipo;
    public double precoDiario;
    public boolean disponibilidade;
    public String nomeHospede;

    public Quarto(int numQuarto, String tipo, double precoDiario, boolean disponibilidade) {
        this.numQuarto = numQuarto;
        this.tipo = tipo;
        this.precoDiario = precoDiario;
        this.disponibilidade = disponibilidade;
        this.nomeHospede = ""; 
    }

    @Override
    public String toString() {
        return "Quarto: " + numQuarto + ", Tipo: " + tipo + ", Preço Diário: R$" + precoDiario +
                ", Disponibilidade: " + (disponibilidade ? "Disponível" : "Indisponível") +
                (disponibilidade ? "" : ", Hóspede: " + nomeHospede);
    }
}

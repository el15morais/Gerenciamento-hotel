package objetos;

public class Reserva {
    public String nomeHospede;
    public String dataCheckin;
    public String dataCheckout;
    public int[] numQuartosReservados;
    public String[] tipoQuarto;

    public Reserva(String nomeHospede, String dataCheckin, String dataCheckout, int[] numQuartosReservados, String[] tipoQuarto) {
        this.nomeHospede = nomeHospede;
        this.dataCheckin = dataCheckin;
        this.dataCheckout = dataCheckout;
        this.numQuartosReservados = numQuartosReservados;
        this.tipoQuarto = tipoQuarto;
    }

    @Override
    public String toString() {
        return "Nome do hóspede: " + nomeHospede + ", Data Check-in: " + dataCheckin + 
               ", Data Check-out: " + dataCheckout + ", Quartos Reservados: " + 
               numQuartosReservados.length + ", Tipos de Quartos: " + String.join(", ", tipoQuarto);
    }
}

package objetos;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Hotel {
    public static Scanner sc = new Scanner(System.in);
    List<Quarto> listaQuartos = new ArrayList<>();
    List<Reserva> listaReservas = new ArrayList<>();

    public void criarQuarto() {
        System.out.println("Digite o número do quarto:");
        int num = sc.nextInt();
        if(num <= 0) {
            System.out.println("Não pode ser menor ou igual a 0!");
        } else {
            System.out.println("Digite o tipo do quarto (solteiro, casal, suite):");
            String tipo = sc.next();

            while (!tipo.equalsIgnoreCase("solteiro") && !tipo.equalsIgnoreCase("casal") && !tipo.equalsIgnoreCase("suite")) {
                System.out.println("Tipo inválido! Escolha solteiro, casal ou suite:");
                tipo = sc.next();
            }

            System.out.println("Qual o preço da diária?");
            double precoDiaria = sc.nextDouble();

            Quarto quarto = new Quarto(num, tipo, precoDiaria, true);
            listaQuartos.add(quarto);
            System.out.println("Quarto cadastrado!");
        }
    }

    public void criarReserva() {
        System.out.println("Nome do hóspede:");
        String nome = sc.next();
        System.out.println("Escolha a data de Check-in:");
        String checkin = sc.next();
        System.out.println("Escolha a data de Check-out:");
        String checkout = sc.next();

        System.out.println("Escolha a quantidade de quartos:");
        int quant = sc.nextInt();
        int[] num = new int[quant];
        String[] tipo = new String[quant];

        System.out.println("Lista de Quartos:");
        for (Quarto quartos : listaQuartos) {
            System.out.println(quartos);   
        }
        System.out.println();
        
        for (int i = 0; i < quant; i++) {
            boolean quartoValido = false;
            while (!quartoValido) {
                System.out.println("Escolha o número do quarto " + (i + 1) + ":");
                num[i] = sc.nextInt();
                for (Quarto quarto : listaQuartos) {
                    if (quarto.numQuarto == num[i] && quarto.disponibilidade) {
                        quarto.nomeHospede = nome;
                        quarto.disponibilidade = false;
                        quartoValido = true;
                        tipo[i] = quarto.tipo;
                        break;
                    }
                }
                if (!quartoValido) {
                    System.out.println("Quarto indisponível ou não existe! Tente novamente.");
                }
            }
        }

        Reserva reserva = new Reserva(nome, checkin, checkout, num, tipo);
        listaReservas.add(reserva);
        System.out.println("Reserva cadastrada!");
    }

    public void checkOut() {
        System.out.println("Digite o nome do hóspede:");
        String nome = sc.next();

        List<Quarto> quartosHospede = new ArrayList<>();
        for (Quarto quarto : listaQuartos) {
            if (quarto.nomeHospede.equalsIgnoreCase(nome)) {
                quartosHospede.add(quarto);
            }
        }

        if (quartosHospede.isEmpty()) {
            System.out.println("Nenhum quarto encontrado para o hóspede: " + nome);
            return;
        }

        System.out.println("Quartos ocupados pelo hóspede " + nome + ":");
        for (Quarto quarto : quartosHospede) {
            System.out.println("Quarto número: " + quarto.numQuarto);
        }

        System.out.println("Escolha o número do quarto para fazer o check-out:");
        int numQuarto = sc.nextInt();

        Quarto quartoEscolhido = null;
        for (Quarto quarto : quartosHospede) {
            if (quarto.numQuarto == numQuarto) {
                quartoEscolhido = quarto;
                break;
            }
        }

        if (quartoEscolhido != null) {
            quartoEscolhido.disponibilidade = true;
            quartoEscolhido.nomeHospede = "";
            System.out.println("Check-out realizado com sucesso para o quarto " + numQuarto);
        } else {
            System.out.println("Nenhum quarto com esse número foi encontrado para o hóspede.");
        }
    }

    public void relatorioOcupacao() {
        System.out.println("Relatório de Ocupação:");
        for (Quarto quarto : listaQuartos) {
            System.out.println(quarto);
        }
    }

    public void historicoReservas() {
        System.out.println("Histórico de Reservas:");
        for (Reserva reserva : listaReservas) {
            System.out.println(reserva);
        }
    }
}

package fag;

import objetos.Hotel;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Hotel hotel = new Hotel();
        Scanner sc = new Scanner(System.in);
        boolean saida = true;
        while(saida) {
            System.out.println("Menu:");
            System.out.println("1- Cadastrar Quarto");
            System.out.println("2- Fazer Reserva");
            System.out.println("3- Check-out");
            System.out.println("4- Relatório de Ocupação");
            System.out.println("5- Histórico de Reservas");
            System.out.println("0- Sair");
            System.out.print("Escolha uma opção: ");
            int opcao = sc.nextInt();
            switch (opcao) {
                case 1:
                    hotel.criarQuarto();
                    break;
                case 2:
                    hotel.criarReserva();
                    break;
                case 3:
                    hotel.checkOut();
                    break;
                case 4:
                	   hotel.relatorioOcupacao();
                    break;
                case 5:
                	hotel.historicoReservas();
                    break;
                case 0:
                	System.out.println("Saindo do sistema...");
                	saida = false;
                    break;
                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }
        }
    }
}

/*
Crie um programa de jogo de adivinhação em que o computador escolhe um número aleatório entre
1 e 100, e o jogador tenta adivinhar o número. Use um loop while para contar o número de tentativas
que o jogador leva para adivinhar corretamente e, em seguida, exiba o número de tentativas no final.
*/

import java.util.Scanner;

public class Exercicio3 {

    public static int getNumber(Scanner scanner) {
        int number;
        try {
            System.out.println("Digite um número inteiro positivo: ");
            number = scanner.nextInt();

        } catch (Exception e) {
            if (e instanceof java.util.InputMismatchException) {
                System.out.println("Invalid number, try again.");
                scanner.next();
                number = getNumber(scanner);
            } else {
                throw e;
            }
        }
        return number;
    }

    public static void main(String[]args){

        Scanner scanner = new Scanner(System.in);
        int number = (int) (Math.random() * 100);
        int tries = 0;

        while(true){
            int guess = getNumber(scanner);
            if(guess == number){
                System.out.printf("Você acertou! Seu número de tentativas foi: %d. O número era: %d%n",tries,number);
                break;
            }
            else{
                System.out.println("Você errou, tente novamente.");
                tries += 1;
            }
        }
    }
}

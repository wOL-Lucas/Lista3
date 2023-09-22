/*
Melhore o jogo de adivinhação do Exercício 3, onde o jogador adivinha um número entre 1 e 100.
Adicione um contador de tentativas e informe ao jogador se a próxima tentativa deve ser maior ou
menor do que a anterior. O jogo deve continuar até que o jogador acerte o número ou atinja um
limite de tentativas.
*/

import java.util.Scanner;
public class Exercicio4 {
    public static int getNumber(Scanner scanner){
        int number;
        try{
            System.out.println("Insira um número");
            number = scanner.nextInt();
        }
        catch(Exception e){
            if(e instanceof java.util.InputMismatchException){
                System.out.println("Número inválido, tente novamente.");
                scanner.next();
                number = getNumber(scanner);
            }
            else{
                throw e;
            }
        }
        return number;
    }

    public static void main(String[]args){
        int number,tries = 0,guess;
        Scanner scanner = new Scanner(System.in);
        number = (int) (Math.random() * 100);

        while(true){
            guess = getNumber(scanner);
            tries += 1;
            if(guess == number){
                System.out.printf("Você acertou! Seu número de tentativas foi: %d. O número era: %d%n",tries,number);
                break;
            }
            else{
                System.out.println("Você errou, tente novamente.");
                if(guess > number){
                    System.out.println("O número é menor que o chute anterior.");
                }
                else{
                    System.out.println("O número é maior que o chute anterior.");
                }
            }
        }
    }
}

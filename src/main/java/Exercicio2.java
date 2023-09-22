/*
Peça ao usuário que insira uma série de números inteiros positivos. Use um loop while para calcular
a média dos números até que o usuário insira um número negativo. Em seguida, exiba a média.
*/

import java.util.ArrayList;
import java.util.Collection;
import java.util.Scanner;

public class Exercicio2 {

    public static int getNumber(Scanner scanner){
        int number;
        try{
            System.out.println("Digite um número inteiro positivo: ");
            number = scanner.nextInt();
            if(number == 0){
                throw new java.util.InputMismatchException("Invalid number");
            }
        }
        catch(Exception e){
            if(e instanceof java.util.InputMismatchException){
                System.out.println("Invalid number, try again.");
                scanner.next();
                number =  getNumber(scanner);
            }
            else{
                throw e;
            }
        }
        return number;
    }

    public static void main(String[]args){
        int number,sum,middle;
        Scanner scanner = new Scanner(System.in);
        Collection<Integer> numbers = new ArrayList<>();

        while(true){
            number = getNumber(scanner);
            if(number < 0) {
                middle = numbers.stream().reduce(0, Integer::sum) / numbers.size();
                System.out.println("Número negativo inserido, encerrando programa.");
                System.out.printf("Média dos números: %d %n", middle);
                break;
            }
            numbers.add(number);
        }
    }
}

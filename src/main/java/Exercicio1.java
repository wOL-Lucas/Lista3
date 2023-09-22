/*
Peça ao usuário que insira uma série de números inteiros positivos. Use um loop while para calcular
a soma dos números pares até que o usuário insira um número ímpar. Em seguida, exiba a soma dos
números pares.
*/
import java.util.ArrayList;
import java.util.Collection;
import java.util.Scanner;

public class Exercicio1 {

    public static int getNumber(Scanner scanner){
        int number;
        try{
            System.out.println("Digite um número inteiro positivo: ");
            number = scanner.nextInt();
            if(number < 0 || number == 0){
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
        int number;
        Scanner scanner = new Scanner(System.in);
        Collection<Integer> numbers = new ArrayList<>();
        while(true){
            number = getNumber(scanner);
            if(number % 2 != 0){
                System.out.printf("Soma dos números pares: %d %n",numbers.stream().filter(n -> n % 2 == 0).reduce(0, Integer::sum));
                break;
            }
            numbers.add(number);

        }
    }
}

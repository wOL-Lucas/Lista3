/*
Um Posto de combustíveis deseja determinar qual de seus produtos tem a preferência de seus clientes.
Escreva um algoritmo para ler o tipo de combustível abastecido (codificado da seguinte forma:
1.Álcool 2.Gasolina 3.Diesel 4.Fim).
Caso o usuário informe um código inválido (fora da faixa de 1 a 4) deve ser solicitado um novo
código (até que seja válido). O programa será encerrado quando o código informado for o número 4.
 Deve ser escrito a mensagem: "MUITO OBRIGADO" e a quantidade de clientes que abasteceram cada tipo de
 combustível, conforme exemplo.
*/

import java.util.HashMap;
import java.util.Scanner;
public class Exercicio6 {

    public static int getCode(Scanner scanner){
        int code;
        System.out.println("Insira o código do combustível\n1 para Álcool\n2 para Gasolina\n3 para Diesel\n4 para sair\n\n");
        try{
            code = scanner.nextInt();
            if(code < 0 || code > 4){
                throw new java.util.InputMismatchException();
            }
        }
        catch(Exception e){
            if(e instanceof java.util.InputMismatchException){
                System.out.println("Código inválido, tente novamente.");
                scanner.next();
                code = getCode(scanner);
            }
            else{
                throw e;
            }
        }
        return code;
    }

    public static void main(String[]args){

        HashMap<Integer,Integer> combustiveisCount = new HashMap<>();
        combustiveisCount.put(1,0);
        combustiveisCount.put(2,0);
        combustiveisCount.put(3,0);

        int code,instructionCount = 0;
        Scanner scanner = new Scanner(System.in);

        while(true){
            code = getCode(scanner);
            if(code == 4){
                System.out.println("MUITO OBRIGADO");
                System.out.printf("Álcool: %d%n",combustiveisCount.get(1));
                System.out.printf("Gasolina: %d%n",combustiveisCount.get(2));
                System.out.printf("Diesel: %d%n",combustiveisCount.get(3));
                break;
            }
            else{
                combustiveisCount.put(code,combustiveisCount.get(code) + 1);                }
            }
        }
    }



/*
Escreva um programa que repita a leitura de uma senha até que ela seja válida.
Para cada leitura de senha incorreta informada,
escrever a mensagem "Senha Invalida". Quando a senha for informada
corretamente deve ser impressa
a mensagem "Acesso Permitido" e o algoritmo encerrado.
Considere que a senha correta é o valor 2023.
*/

import java.util.Scanner;
public class Exercicio5 {

    public static String getPassword(Scanner scanner){
        String senha;
        try{
            System.out.println("Insira a senha");
            senha = scanner.next();
            if(senha.isEmpty()){
                throw new java.util.InputMismatchException();
            }
        }
        catch(Exception e){
            if(e instanceof java.util.InputMismatchException){
                System.out.println("Enter a valid password");
                scanner.next();
                senha = getPassword(scanner);
            }
            else{
                throw e;
            }
        }
        return senha;
    }

    public static void main(String[]args){
        Scanner scanner = new Scanner(System.in);
        String correctPassword = "2023";
        while(true){
            String passwordInput = getPassword(scanner);
            if(passwordInput.equals(correctPassword)){
                System.out.println("Acesso permitido");
                break;
            }
            else{
                System.out.println("Senha inválida.");
            }
        }
    }
}

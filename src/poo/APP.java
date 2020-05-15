
package poo;

import java.util.Scanner;

public class APP {
    
    //Constante
    static final int MAXCONTA = 20;
   
    //variável comum
    static int index = 0;
    
    //Lista de contas
    static Conta[] lista = new Conta[MAXCONTA];
    
    static Scanner tecla = new Scanner(System.in);

    public static void main(String[] args) {
        int op;
        do {                
            System.out.println("*** MENU PRINCIPAL ***");
            System.out.println("1-Incluir Conta Física");
            System.out.println("2-Incluir Conta Jurídica");
            System.out.println("3-Sacar");
            System.out.println("4-Depositar");
            System.out.println("5-Listar saldo das Contas");
            System.out.println("6-Imprimir dados da conta");
            System.out.println("7-Sair");
            System.out.println("Digite sua opção: ");
            op = tecla.nextInt(); 
            switch(op){
                case 1: incluirContaFisica(); break;
                case 2: incluirContaJuridica(); break;
                case 3: sacarValor(); break;
                case 4: depositarValor(); break;    
                case 5: listarContas(); break;
                
                case 6: imprimirDados(); break;
                
                case 7: break;
            }
        } while (op!=7);       
    }
    
    public static void imprimirDados(){
        for (int i = 0; i < lista.length; i++) {
            if (lista[i] != null){
                lista[i].print(); //polimorfismo
            }
        }
    }
    
    public static void incluirContaJuridica(){
        //Entrada
        System.out.println("Digite o número da conta:");
        int num = tecla.nextInt();
        System.out.println("Digite o saldo da conta:");
        double saldo = tecla.nextDouble();
        
        System.out.println("Digite seu CNPJ:");
        long cnpj = tecla.nextLong();
        
        //Criar o objeto e inserir na lista
        lista[index++] = new ContaJuridica(num, saldo, cnpj);
        System.out.println("Conta Jurídica cadastrada com sucesso!");
    }
    
    public static void incluirContaFisica(){
        //Entrada
        System.out.println("Digite o número da conta:");
        int num = tecla.nextInt();
        System.out.println("Digite o saldo da conta:");
        double saldo = tecla.nextDouble();
        
        System.out.println("Digite seu CPF:");
        long cpf = tecla.nextLong();
        
        //Criar o objeto e inserir na lista
        lista[index++] = new ContaFisica(num, saldo, cpf);
        System.out.println("Conta Física cadastrada com sucesso!");
    }
    
    public static void sacarValor(){
        //Entrada
        System.out.println("Digite o número da conta:");
        int num = tecla.nextInt();
        System.out.println("Digite o valor do saque:");
        double valor = tecla.nextDouble();
        
        //Procurar a conta na lista
        for (int i = 0; i < lista.length; i++) {
            if (num == lista[i].getNumero()){
                lista[i].sacar(valor);
                break;
            }
        }
    }
    
    public static void depositarValor(){
        //Entrada
        System.out.println("Digite o número da conta:");
        int num = tecla.nextInt();
        System.out.println("Digite o valor do depósito:");
        double valor = tecla.nextDouble();
        
        //Procurar a conta na lista
        for (int i = 0; i < lista.length; i++) {
            if (num == lista[i].getNumero()){
                lista[i].depositar(valor);
                break;
            }
        }
    }
    
    public static void listarContas(){
        double total = 0;
        System.out.println("Nº Conta:........ SALDO:");
        for (int i = 0; i < lista.length; i++) {
            if (lista[i] != null){
                System.out.println(lista[i].getNumero()
                                   + "........" +
                                   lista[i].getSaldo());
                //total += lista[i].getSaldo();
                total = total + lista[i].getSaldo();
            }else{
                break;
            }
        }
        System.out.println("Total:........" + total);
    }
    
    
}

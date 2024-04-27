import java.util.Scanner;

public class Conta {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String nome = "Jacqueline Oliveira";
        String tipoConta = "Corrente";
        double saldo = 2500.00;

        System.out.println(dadosIniciais(nome, tipoConta, saldo));

        int opcao = 0;
        while (opcao != 4) {
            System.out.println("\n\n" + escolhas());
            System.out.println("\nDigite a opção desejada:");
            opcao = sc.nextInt();
            if(opcao == 1){
                System.out.println("\n" + consultarSaldo(saldo));
            } else if(opcao == 2){
                System.out.println("\n\nInforme o valor:");
                int valor = sc.nextInt();
                if(valor <= 0){
                    System.out.println("\nvalor digitado invalido");
                } else {
                    saldo = depositar(valor, saldo);
                    System.out.println("\n\nSaldo atualizado R$ " + consultarSaldo(saldo));
                }
            } else if(opcao == 3){
                System.out.println("\n\nInforme o valor:");
                int valor = sc.nextInt();
                if(valor > saldo){
                    System.out.println("Não há saldo suficiente para fazer essa transferência.");
                } else {
                    saldo = sacar(valor, saldo);
                    System.out.println("\n\nSaldo atualizado R$ " + consultarSaldo(saldo));
                }
            } else if(opcao == 4){
                System.out.println("\nSaindo");
            } else {
                System.out.println("\nOpção invalida");
            }

        }

        sc.close();
    }

    public static String dadosIniciais(String nome, String tipoConta, double saldo){
        String saldoFormatado = String.format("%.2f", saldo);
        return  "*".repeat(23) +
                "\nDados iniciais do cliente:" +
                "\n" +
                "\n" +
                "\nNome: " + nome +
                "\nTipo conta: " + tipoConta +
                "\nSaldo inicial: R$ " + saldoFormatado +
                "\n" + "*".repeat(23);
    }

    public static String escolhas(){
        return """
                Operações\



                1 - Consultar saldos\

                2 - Depositar\

                3 - Sacar\

                4 - Sair""";

    }

    public static String consultarSaldo(double saldo){
        return String.format("%.2f", saldo);
    }

    public static Double depositar(double valor , double saldoAtual){
        return saldoAtual + valor;
    }

    public static Double sacar(double valor, double saldoAtual){
        return saldoAtual - valor;
    }
}

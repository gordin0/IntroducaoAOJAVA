import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("\n========== MENU DE EXERCÍCIOS ==========");
            System.out.println("1 - Exercício 01: Posto de Combustíveis");
            System.out.println("2 - Exercício 02: Fruteira");
            System.out.println("3 - Exercício 03: Hipermercado Carnes");
            System.out.println("4 - Exercício 04: Aumento Salarial");
            System.out.println("5 - Exercício 05: Duração do Jogo");
            System.out.println("6 - Exercício 06: Patos e Coelhos");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");
            opcao = sc.nextInt();

            switch (opcao) {
                case 1:
                    exercicio01();
                    break;
                case 2:
                    exercicio02();
                    break;
                case 3:
                    exercicio03();
                    break;
                case 4:
                    exercicio04();
                    break;
                case 5:
                    exercicio05();
                    break;
                case 6:
                    exercicio06();
                    break;
                case 0:
                    System.out.println("Programa encerrado!");
                    break;
                default:
                    System.out.println("Opção inválida! Digite um número de 0 a 6.");
            }
        } while (opcao != 0);

        sc.close();
    }

    // ==================== EXERCÍCIO 01 ====================
    public static void exercicio01() {
        Scanner sc = new Scanner(System.in);

        System.out.println("\n--- EXERCÍCIO 01: POSTO DE COMBUSTÍVEIS ---");
        System.out.print("Digite o número de litros vendidos: ");
        double litros = sc.nextDouble();

        System.out.print("Digite o tipo de combustível (A-álcool, G-gasolina): ");
        char tipo = sc.next().charAt(0);

        double precoLitro;
        double descontoPorcentagem;

        if (tipo == 'A' || tipo == 'a') {
            precoLitro = 3.98;
            if (litros <= 20) {
                descontoPorcentagem = 0.03;
            } else {
                descontoPorcentagem = 0.05;
            }
        } else if (tipo == 'G' || tipo == 'g') {
            precoLitro = 6.49;
            if (litros <= 20) {
                descontoPorcentagem = 0.04;
            } else {
                descontoPorcentagem = 0.06;
            }
        } else {
            System.out.println("Tipo de combustível inválido!");
            return;
        }

        double valorBruto = precoLitro * litros;
        double valorDesconto = valorBruto * descontoPorcentagem;
        double valorPagar = valorBruto - valorDesconto;

        System.out.println("\n--- RESULTADO ---");
        System.out.printf("Valor bruto: R$ %.2f\n", valorBruto);
        System.out.printf("Desconto: R$ %.2f\n", valorDesconto);
        System.out.printf("Valor a pagar: R$ %.2f\n", valorPagar);
    }

    // ==================== EXERCÍCIO 02 ====================
    public static void exercicio02() {
        Scanner sc = new Scanner(System.in);

        System.out.println("\n--- EXERCÍCIO 02: FRUTEIRA ---");
        System.out.print("Digite a quantidade de morangos (Kg): ");
        double morangos = sc.nextDouble();

        System.out.print("Digite a quantidade de maçãs (Kg): ");
        double macas = sc.nextDouble();

        double precoMorango, precoMaca;

        if (morangos <= 5) {
            precoMorango = 2.50;
        } else {
            precoMorango = 2.20;
        }

        if (macas <= 5) {
            precoMaca = 1.80;
        } else {
            precoMaca = 1.50;
        }

        double totalMorango = morangos * precoMorango;
        double totalMaca = macas * precoMaca;
        double total = totalMorango + totalMaca;

        System.out.println("\n--- RESULTADO ---");
        System.out.printf("Total morangos: R$ %.2f\n", totalMorango);
        System.out.printf("Total maçãs: R$ %.2f\n", totalMaca);
        System.out.printf("Subtotal: R$ %.2f\n", total);

        if (morangos + macas > 8 || total > 25.00) {
            total = total * 0.90;
            System.out.println("Desconto de 10% aplicado!");
        }

        System.out.printf("Valor a pagar: R$ %.2f\n", total);
    }

    // ==================== EXERCÍCIO 03 ====================
    public static void exercicio03() {
        Scanner sc = new Scanner(System.in);

        System.out.println("\n--- EXERCÍCIO 03: HIPERMERCADO CARNES ---");
        System.out.println("Tipos de carne:");
        System.out.println("F - File Duplo");
        System.out.println("A - Alcatra");
        System.out.println("P - Picanha");
        System.out.print("Digite o tipo de carne: ");
        char tipo = sc.next().charAt(0);

        System.out.print("Digite a quantidade (Kg): ");
        double quantidade = sc.nextDouble();

        System.out.print("Pagamento no cartão? (S/N): ");
        char cartao = sc.next().charAt(0);

        double precoKg;
        String nomeCarne = "";

        if (tipo == 'F' || tipo == 'f') {
            nomeCarne = "File Duplo";
            if (quantidade <= 5) {
                precoKg = 4.90;
            } else {
                precoKg = 5.80;
            }
        } else if (tipo == 'A' || tipo == 'a') {
            nomeCarne = "Alcatra";
            if (quantidade <= 5) {
                precoKg = 5.90;
            } else {
                precoKg = 6.80;
            }
        } else if (tipo == 'P' || tipo == 'p') {
            nomeCarne = "Picanha";
            if (quantidade <= 5) {
                precoKg = 6.90;
            } else {
                precoKg = 7.80;
            }
        } else {
            System.out.println("Tipo de carne inválido!");
            return;
        }

        double totalBruto = precoKg * quantidade;
        double desconto = 0;
        String tipoPagamento = "Dinheiro";

        if (cartao == 'S' || cartao == 's') {
            tipoPagamento = "Cartão";
            desconto = totalBruto * 0.05;
        }

        double valorPagar = totalBruto - desconto;

        System.out.println("\n========== CUPOM FISCAL ==========");
        System.out.println("Tipo de carne: " + nomeCarne);
        System.out.println("Quantidade: " + quantidade + " Kg");
        System.out.printf("Preço por Kg: R$ %.2f\n", precoKg);
        System.out.printf("Preço total: R$ %.2f\n", totalBruto);
        System.out.println("Tipo de pagamento: " + tipoPagamento);
        System.out.printf("Valor do desconto: R$ %.2f\n", desconto);
        System.out.printf("Valor a pagar: R$ %.2f\n", valorPagar);
        System.out.println("====================================");
    }

    // ==================== EXERCÍCIO 04 ====================
    public static void exercicio04() {
        Scanner sc = new Scanner(System.in);

        System.out.println("\n--- EXERCÍCIO 04: AUMENTO SALARIAL ---");
        System.out.print("Digite o número do funcionário: ");
        int numero = sc.nextInt();

        System.out.print("Digite o salário atual: R$ ");
        double salario = sc.nextDouble();

        double percentual;

        if (salario <= 400.00) {
            percentual = 0.15;
        } else if (salario <= 700.00) {
            percentual = 0.12;
        } else if (salario <= 1000.00) {
            percentual = 0.10;
        } else if (salario <= 1800.00) {
            percentual = 0.07;
        } else if (salario <= 2500.00) {
            percentual = 0.04;
        } else {
            percentual = 0.00;
        }

        double aumento = salario * percentual;
        double novoSalario = salario + aumento;

        System.out.println("\n--- RESULTADO ---");
        System.out.println("Número do funcionário: " + numero);
        System.out.printf("Salário atual: R$ %.2f\n", salario);
        System.out.printf("Percentual de aumento: %.0f%%\n", percentual * 100);
        System.out.printf("Valor do aumento: R$ %.2f\n", aumento);
        System.out.printf("Novo salário: R$ %.2f\n", novoSalario);
    }

    // ==================== EXERCÍCIO 05 ====================
    public static void exercicio05() {
        Scanner sc = new Scanner(System.in);

        System.out.println("\n--- EXERCÍCIO 05: DURAÇÃO DO JOGO ---");
        System.out.println("--- Horário de início ---");
        System.out.print("Horas: ");
        int horaIni = sc.nextInt();
        System.out.print("Minutos: ");
        int minIni = sc.nextInt();

        System.out.println("--- Horário de término ---");
        System.out.print("Horas: ");
        int horaFim = sc.nextInt();
        System.out.print("Minutos: ");
        int minFim = sc.nextInt();

        // Validação das horas e minutos
        if (horaIni < 0 || horaIni > 23 || horaFim < 0 || horaFim > 23 ||
            minIni < 0 || minIni > 59 || minFim < 0 || minFim > 59) {
            System.out.println("Horário inválido! Horas devem estar entre 0 e 23, minutos entre 0 e 59.");
            return;
        }

        int totalIni = horaIni * 60 + minIni;
        int totalFim = horaFim * 60 + minFim;

        int duracaoMinutos;
        if (totalFim > totalIni) {
            duracaoMinutos = totalFim - totalIni;
        } else if (totalFim == totalIni) {
            duracaoMinutos = 1440; // 24 horas
        } else {
            duracaoMinutos = (24 * 60 - totalIni) + totalFim;
        }

        // Limitar a 24 horas (1440 minutos)
        if (duracaoMinutos > 1440) {
            duracaoMinutos = 1440;
        }

        int horas = duracaoMinutos / 60;
        int minutos = duracaoMinutos % 60;

        System.out.println("\n--- RESULTADO ---");
        System.out.println("Duração do jogo: " + horas + " hora(s) e " + minutos + " minuto(s)");
    }

    // ==================== EXERCÍCIO 06 ====================
    public static void exercicio06() {
        Scanner sc = new Scanner(System.in);

        System.out.println("\n--- EXERCÍCIO 06: PATOS E COELHOS ---");
        System.out.print("Digite o total de cabeças: ");
        int cabecas = sc.nextInt();

        System.out.print("Digite o total de patas: ");
        int patas = sc.nextInt();

        // Coelhos têm 4 patas, patos têm 2 patas
        // x = número de coelhos, y = número de patos
        // x + y = cabecas
        // 4x + 2y = patas
        // Resolvendo o sistema:
        // 4x + 2(cabecas - x) = patas
        // 4x + 2*cabecas - 2x = patas
        // 2x = patas - 2*cabecas
        // x = (patas - 2*cabecas) / 2

        if (patas % 2 != 0) {
            System.out.println("Valores inválidos! O número de patas deve ser par.");
            return;
        }

        int coelhos = (patas - 2 * cabecas) / 2;
        int patos = cabecas - coelhos;

        if (coelhos < 0 || patos < 0) {
            System.out.println("Valores inválidos! Não é possível determinar a quantidade de animais.");
            System.out.println("Verifique se o número de patas é compatível com o número de cabeças.");
        } else {
            System.out.println("\n--- RESULTADO ---");
            System.out.println("Quantidade de patos: " + patos);
            System.out.println("Quantidade de coelhos: " + coelhos);
            System.out.println("Total de animais: " + (patos + coelhos));
        }
    }
}
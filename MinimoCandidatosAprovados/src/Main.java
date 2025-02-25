import java.util.Scanner;

class Resolvendo {
    public static void quantosaprovados(int notas[], int candidatos, int minimo) {
        for (int i = 0; i < candidatos - 1; i++) {
            for (int j = 0; j < candidatos - 1 - i; j++) {
                if (notas[j] < notas[j + 1]) {
                    int aux = notas[j];
                    notas[j] = notas[j + 1];
                    notas[j + 1] = aux;
                }
            }
        }

        int notaCorte = notas[minimo - 1];
        int contador = 0;

        for (int i = 0; i < candidatos; i++) {
            if (notas[i] >= notaCorte) {
                contador++;
            }
        }

        System.out.println("Número de candidatos aprovados: " + contador);
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);
        int candidatos;

        do {
            System.out.println("Coloque o total de candidatos que irão participar da prova: ");
            candidatos = leitor.nextInt();
            if (candidatos < 1 || candidatos > 1000) {
                System.out.println("Erro!");
            }
        } while (candidatos < 1 || candidatos > 1000);

        int minimo;
        do {
            System.out.println("Coloque o número mínimo de candidatos que deve ser aprovado: ");
            minimo = leitor.nextInt();
            if (minimo < 1 || minimo > candidatos) {
                System.out.println("Número mínimo de aprovados não pode ser menor que 1 ou maior que o total de candidatos");
            }
        } while (minimo < 1 || minimo > candidatos);

        int notas[] = new int[candidatos];

        for (int i = 0; i < candidatos; i++) {
            do {
                System.out.println("Digite a nota do candidato " + (i + 1) + ": ");
                notas[i] = leitor.nextInt();
                if (notas[i] < 1 || notas[i] > 1000) {
                    System.out.println("Nota Inválida!");
                }
            } while (notas[i] < 1 || notas[i] > 1000);
        }

        Resolvendo.quantosaprovados(notas, candidatos, minimo);
        leitor.close();
    }
}

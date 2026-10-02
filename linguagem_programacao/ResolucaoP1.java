//Os comentários aqui presentes são de minha autoria, e não da IA

package resolucoes_provas.linguagem_programacao;

import java.util.Scanner;
import java.util.Random;

public class ResolucaoP1
{
	//Temos que declarar a matriz fora do escopo de qualquer método se quisermos que ela seja global
	int[][] matriz = new int[800][800];

	Random rand = new Random();
	Scanner scan = new Scanner(System.in);


	public static void main(String[] args)
	{
		//Instanciei esta classe só para não ter que inserir "static" em cada método
		ResolucaoP1 programa = new ResolucaoP1();

		programa.menu();
	}


	//EXERCÍCIO 3
	public void menu()
	{
		int entrada = 0;

		while (entrada != 9)
		{
		    System.out.println("— O que desejas?\n\t1-) Carregar Valores na Matriz\n\t2-) Gerar Fatorial de Cada Índice\n\t4-) Somar N Fatoriais\n\t9-) Fim");

		    entrada = scan.nextInt();

		    switch (entrada)
		    {
		        case 1:
		            procedimento();
		            break;

		        case 2:
					fatorialMatriz();
					break;

		        case 4:
		            somaFatoriais();
		            break;

		        case 9:
		            System.out.println("— Fim do Programa");
		            break;

		        default:
		            System.out.println("DIGITE UM NÚMERO VÁLIDO\n\n");
		    }
		}
	}


    //EXERCÍCIO 1
	public void procedimento()
	{
	    int soma = 0;

	    for (int i = 0; i < 800; i++)
	    {
	        for (int j = 0; j < 800; j++)
	        {
	            if (i + j == 799)
	            {
	                if (i % 2 == 0)
	                {
	                    matriz[i][j] = 1;
	                }
	                else
	                {
	                    matriz[i][j] = 4;
	                }
	            }
	            else
	            {
					//Limitei os valores aleatórios de 0 a 9, já que o fatorial de números exorbitantes culminaria num "Stack Overflow"
	                matriz[i][j] = rand.nextInt(10);

	                if (matriz[i][j] % 3 == 0 || matriz[i][j] % 5 == 0)
	                {
	                    soma += matriz[i][j];
	                }
	            }
	        }
	    }

	    System.out.println("— Matriz gerada com sucesso!\n— Soma dos números divisíveis por 3 e/ou 5: " + soma + "\n\n");
	}


	//EXERCÍCIO 2 e uma parte do 4
	public int fatorial(int x)
	{
		if (x < 0)
		{
			return 0;
		}
		else if (x == 0 || x == 1)
		{
			return 1;
		}
		else
		{
			return x * fatorial(x - 1);
		}
	}


	//Tornei esta parte um procedimento a fim de deixar o Switch Case do Exercício 3 mais limpo
	public void fatorialMatriz()
	{
		for (int a = 0; a < 800; a++)
		{
			for (int b = 0; b < 800; b++)
			{
				if (a + b != 799)
				{
					System.out.println(fatorial(matriz[a][b]));
				}
			}
		}

		System.out.println("\n");
	}


    //EXERCÍCIO 4
	public void somaFatoriais()
	{
	    int valor;

	    while (true)
	    {
	        System.out.println("— Digite um número entre 5 e 10");

            valor = scan.nextInt();

            if (valor >= 5 && valor <= 10)
            {
                break;
            }

            System.out.println("O VALOR DIGITADO É IGUAL OU MENOR QUE 4 OU MAIOR QUE 10\nDIGITE NOVAMENTE\n");
	    }

	    System.out.println("— Soma dos fatoriais: " + soma(valor) + "\n\n");
	}


	public int soma(int y)
	{
	    if (y == 1)
	    {
	        return 1;
	    }
	    else
	    {
			return fatorial(y) + soma(y - 1);
	    }
	}
}
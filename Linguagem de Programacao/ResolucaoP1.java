import java.util.Scanner;
import java.util.Random;

public class ResolucaoP1
{
	Random rand = new Random();
	Scanner scan = new Scanner(System.in);
	
	int[][] matriz = new int[800][800];

    //EXERCÍCIO 3
	public void main(String[] args)
	{
		int entrada = 0;

		while (entrada != 9)
		{
		    System.out.println("— O que deseja?\n\t1-) Carregar Matriz\n\t2-) Gerar Fatorial\n\t4-) Somar Fatoriais\n\t9-) Fim");

		    entrada = scan.nextInt();

		    switch (entrada)
		    {
		        case 1:
		            procedimento();
		            break;

		        case 2:
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
					break;

		        case 4:
		            somaFatoriais();
		            break;

		        case 9:
		            System.out.println("— Fim do Programa");
		            break;

		        default:
		            System.out.println("DIGITE UM NÚMERO VÁLIDO\n");
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
	                matriz[i][j] = rand.nextInt(10);

	                if (matriz[i][j] % 3 == 00 || matriz[i][j] % 5 == 00)
	                {
	                    soma += matriz[i][j];
	                }
	            }
	        }
	    }

	    System.out.println("— Matriz gerada com sucesso!\n— Soma dos números divisíveis por 3 e/ou 5: " + soma + "\n");
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


    //EXERCÍCIO 4
	public void somaFatoriais()
	{
	    int valor = 0;

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

	    System.out.println("— Soma dos fatoriais: " + soma(valor) + "\n");
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
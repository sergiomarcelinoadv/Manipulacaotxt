import java.io.BufferedReader; 
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws IOException {
		int op;
		Scanner ler = new Scanner(System.in);
		
		File arq = new File("/Users/sergiomarcelinonobregadecastro/eclipse-workspace/ProjetoProfessor/src/exercicio1.txt");
		
		do {
			
			System.out.println("Escolha a sua opção");
			System.out.println("1 - Inserir nome no arquivo");
			System.out.println("2 - Exibir todos os nomes do arquivo ");
			System.out.println("3 - Apagar todo o arquivo");
			System.out.println("0 - Sair do Programa");
			
			op = ler.nextInt();
			switch (op) {
			
				case 0:
					System.out.println("Você encerrou o programa");
					
				break;
				
				case 1:
					String nome;
					Scanner entrada = new Scanner(System.in);
					FileWriter fw = new FileWriter(arq, true);
					BufferedWriter buffered = new BufferedWriter(fw);
					
					if (!arq.exists()) {	
						arq.createNewFile();		
					}
					
					System.out.print("Inserir nome: ");
					nome = entrada.nextLine();
					buffered.append(nome + "\n");
					System.out.println();
					buffered.close();
					System.out.println("##############################");
					System.out.println("##  CADASTRADO COM SUCESSO  ##");
					System.out.println("##############################\n");			
				break;
				
				case 2:
					System.out.println("##############################");
					System.out.println("##        EXIBIR LISTA      ##");
					System.out.println("##############################\n");
					
					if (arq.exists()) {
						FileReader fr = new FileReader(arq);
						BufferedReader bufferler = new BufferedReader (fr);
						String exibir;
						while(bufferler.ready()) {
							exibir = bufferler.readLine();
							System.out.println(exibir);
							System.out.println("------------------------------");
						}
						bufferler.close();	
					}else {
						System.out.println("Você deletou o arquivo txt.");
					}
				break;
				
				case 3:
					System.out.println("##############################");
					System.out.println("##   DELETADO COM SUCESSO   ##");
					System.out.println("##############################\n");	
					arq.delete();
				break;
		
				default:
					System.out.println("Você escolheu uma opção inválida");	
				break;
		}
			
			
		}while(op !=0);
		ler.close();
	}

}

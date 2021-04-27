import java.util.Scanner;
import java.io.*;
public class PrincipalLabirinto {

	public static void main(String arg[]) {
			boolean resultado;
			try {
				File f = new File("saidaLabirinto.txt");
				FileWriter fr = new FileWriter(f);
				PrintWriter out = new PrintWriter(fr);
			
				Scanner scanner = new Scanner(System.in);
				String nome;
				Labirinto2 l = new Labirinto2();
				System.out.println("Dígite o nome do arquivo do labirinto (temos 2 exemplos M2F.txt e m2LAB)");
				nome = scanner.nextLine();
				l.LC(nome);
				resultado = l.labirinto(l.carregaLabirinto(nome));
				if(resultado) {
					out.println("Existe um caminho para o labirinto");
				}else
					out.println("Não existe um caminho para o labirinto");
				out.close();
			}catch(IOException e) {
				System.out.println("Erro ao escrever arquivo");
			}
			
	}
}

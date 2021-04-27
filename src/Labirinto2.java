import java.io.*;
public class Labirinto2 {
	int linha;
	int coluna;
	String fileName;
	//Pega a Linha e COluna
	public void LC(String fileName) {
		try {
			FileReader fr = new FileReader(fileName);
			BufferedReader in = new BufferedReader(fr);
			
			linha = Integer.parseInt(in.readLine());
			coluna = Integer.parseInt(in.readLine());
			this.fileName = fileName;
			in.close();	
		} catch (FileNotFoundException e) {
			System.out.println("Arquivo \""+fileName+"\" não existe.");
		} catch(IOException e) {
			System.out.println("Erro na leitura de "+fileName+".");
		}
	}
	//Cria labirinto
	public char[][] carregaLabirinto(String fileName){
		
		char array[] [] = new char [linha] [coluna];
		int i =0;
		
		
		try {
			FileReader fr = new FileReader(fileName);
			BufferedReader in = new BufferedReader(fr);
			
			in.readLine();
			in.readLine();
			String line = in.readLine();
			
			while(line != null) {
					for(int k =0;k < coluna ; k++) {
						array[i][k] = line.charAt(k);
					}
					i++;
					line = in.readLine();
			}
			for (int ii = 0; ii < array.length; ii++) {
			      for (int j = 0; j < array[ii].length; j++) {
			        //System.out.print(array[ii][j] + "");
			      }
			     // System.out.println();
			}
		in.close();	
		} catch (FileNotFoundException e) {
			System.out.println("Arquivo \""+fileName+"\" não existe.");
		} catch(IOException e) {
			System.out.println("Eroo na leitura de "+fileName+".");
		}
		return array;
	}
	//Até aqui ok
	public boolean labirinto(char[][] array) throws IllegalArgumentException {
		if(array == null) throw new IllegalArgumentException();
		int arrayInt[][] = new int[linha][coluna];
		return labirinto1(0, 0, arrayInt);
	}
	
	private boolean labirinto1(int l, int c, int [][] arrayInt) {

		int count = 0;
		char array[][] =  new char[linha][coluna];
		
		array = carregaLabirinto(fileName);
		
		//N [0-1][0]
		//L [0][0+1]
		//S [0+1][0]
		//O [0][-1]
		
		if(count >= (linha * coluna)) return false;
		//try {
		
		if(c < coluna -1) {
			if (array[l][c + 1] == ' ' && arrayInt[l][c+1]  == 0) {
				count++;
				c +=1;
				arrayInt[l][c] = 1;
				return labirinto1(l, c, arrayInt);
			}}
		if(l < linha -1) {
			if(array[l + 1][c] == ' ' && arrayInt[l + 1][c]  == 0) {
				count++;
				 l += 1;
				//System.out.println("C" + c+ "L"+l);
				arrayInt[l][c] = 1;
				return labirinto1(l, c, arrayInt);
			}
		}
		
		if(l >= 1) {
			if (array[l - 1][c] == ' ' && arrayInt[l -1][c]  == 0) {
				count++;
				l-=1;
				//System.out.println("aaaC" + c+ "L"+l);
				arrayInt[l][c] = 1;
				return labirinto1(l, c, arrayInt);
			}	
		}
		if(c >= 1) {
			if(array[l][c-1] == ' ' && arrayInt[l][c-1] == 0) {
				count++;
				c -= 1;
				//System.out.println("cccC" + c+ "L"+l);
				arrayInt[l][c] = 1;
				return labirinto1(l, c, arrayInt);
			}
		}
		//}catch(ArrayIndexOutOfBoundsException e) {}
		
		
		//System.out.println("ssssC" + c+ "L"+l);
		
		//System.out.println(array[7][19]);
		
		//N [0-1][0]
		//L [0][0+1]
		//S [0+1][0]
		//O [0][-1]

		
		if(c < coluna -1) {
			if (array[l][c + 1] == ' ' && arrayInt[l][c+1]  == 1) {
				count++;
				c +=1;
				arrayInt[l][c] = 2;
				return labirinto1(l, c, arrayInt);
			}}
		if(l < linha -1) {
			if(array[l + 1][c] == ' ' && arrayInt[l + 1][c]  == 1) {
				count++;
				 l += 1;
				//System.out.println("C" + c+ "L"+l);
				arrayInt[l][c] = 2;
				return labirinto1(l, c, arrayInt);
			}
		}
		
		if(l >= 1) {
			if (array[l - 1][c] == ' ' && arrayInt[l -1][c]  == 1) {
				count++;
				l-=1;
				//System.out.println("aaaC" + c+ "L"+l);
				arrayInt[l][c] = 2;
				return labirinto1(l, c, arrayInt);
			}	
		}
		if(c >= 1) {
			if(array[l][c-1] == ' ' && arrayInt[l][c-1] == 1) {
				count++;
				c -= 1;
				//System.out.println("cccC" + c+ "L"+l);
				arrayInt[l][c] = 2;
				return labirinto1(l, c, arrayInt);
			}
		}
		
		
		if(l < coluna -1) {
			if(array[l+1][c] == 'D')
				return true;	
		}
		if(c < linha -1) {
			if(array[l][c+1] == 'D')
				return true;
		}
		
		if(l >= 1) {
			if(array[l-1][c] == 'D')
				return true;
		}
		if(c >= 1) {
			if(array[l][c-1] == 'D')
				return true;
		}
		
		
		
		//return true;
		return  false ;
	}
	

}

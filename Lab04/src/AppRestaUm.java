
public class AppRestaUm {
	char[][]tabuleiro;
	
	public AppRestaUm (){
		tabuleiro = new char [8][8];
	}

	public static void criaTabuleiro (AppRestaUm t) {
		//Peca marcador = new Peca();
		
		for(int i=1;i<=7;i++) {			
			for(int j=1;j<=7;j++) {
				
				if(i==4 && j==4) t.tabuleiro[i][j]='-';
				
				else if(i==3|i==4|i==5) {
					t.tabuleiro[i][j]='P';
									
			  } else {
					if(j==3|j==4|j==5) {
						
						t.tabuleiro[i][j]= 'P';
					} else {
						t.tabuleiro[i][j]=' ';
						
					}
				}				
			}
		}
	}
	
	public static void executaJogo(String diretorio) {
		//método deve receber uma string contendo o caminho do .csv
		//para executar as operações do jogo
		
		AppRestaUm t = new AppRestaUm();
		criaTabuleiro(t);
		
		System.out.print("Tabuleiro principal:");
		mostaTabuleiro(t);
		
		CSVReader csv = new CSVReader();
		csv.setDataSource(diretorio);
		
		//vetor contendo os passos de execução
		String commands[] = csv.requestCommands();
		char [] posInicial = new char[2];
		char [] posFinal = new char[2];
		
		int n=commands.length; //contem o número de comandos presentes no .csv
		
		for(int j=1;j<n;j++) {
			posInicial[0]=commands[j].charAt(0);
			posInicial[1]=commands[j].charAt(1);
			
			posFinal[0]=commands[j].charAt(3);
			posFinal[1]=commands[j].charAt(4);
			
			System.out.println("\n");
			System.out.println("Source:"+posInicial[0]+"" +posInicial[1]);
			System.out.print("Target:"+posFinal[0]+"" +posFinal[1]);
			
			alteraPos(posInicial,posFinal,t);
			
			
		} 
	}
	
	public static void alteraPos(char[] A, char [] B, AppRestaUm t) {
		
		int i_1, j_1,i_2, j_2;
			
			//posicao final
			i_1=traduzPos(A[1]);
			j_1=traduzPos(A[0]);
			
			//posicao inicial
			i_2=traduzPos(B[1]);
			j_2=traduzPos(B[0]);
			
			
			//objetivo deste método é alterar t.tabuleiro[i_2][j_2] para t.tabuleiro[i_1][j_1] 
			//1-verifica se a posicao final é uma posicao adjacente na mesma linha:
			if(i_1 == i_2 && j_2 ==j_1-2) {
				if(t.tabuleiro[i_1][j_1-1]=='P' && t.tabuleiro[i_2][j_2]=='-'){
					
					t.tabuleiro[i_1][j_1]='-'; //posicao final recebe a peça
					t.tabuleiro[i_2][j_2]='P'; //posicao incial fica vazia
					t.tabuleiro[i_2][j_2+1]='-'; //posicao incial fica vazia
				}
				
			}else if(i_1 == i_2 && j_2 ==j_1+2) {
				if(t.tabuleiro[i_1][j_1-1]=='P' && t.tabuleiro[i_2][j_2]=='-'){
					
					t.tabuleiro[i_1][j_1]='-'; //posicao final recebe a peça
					t.tabuleiro[i_2][j_2]='P'; //posicao incial fica vazia
					t.tabuleiro[i_2][j_2-1]='-'; //posicao incial fica vazia
				}
				
			}else if(i_2 == i_1-2 && j_2 ==j_1) {
				if(t.tabuleiro[i_1][j_1-1]=='P' && t.tabuleiro[i_2][j_2]=='-'){
					
					t.tabuleiro[i_1][j_1]='-'; //posicao final recebe a peça
					t.tabuleiro[i_2][j_2]='P'; //posicao incial fica vazia
					t.tabuleiro[i_2][j_2-1]='-'; //posicao incial fica vazia
			}
				
			}else if(i_2 == i_1+2 && j_2 ==j_1) {
				if(t.tabuleiro[i_1+1][j_1]=='P' && t.tabuleiro[i_2][j_2]=='-'){
					
					t.tabuleiro[i_1][j_1]='-'; //posicao final recebe a peça
					t.tabuleiro[i_2][j_2]='P'; //posicao incial fica vazia
					t.tabuleiro[i_2][j_2+1]='-'; //posicao incial fica vazia
			}
				
			} 
			
			mostaTabuleiro(t);
	}
		
	public static int traduzPos (char c) {
	//traduz as instruções em indices do vetor do tabuleiro
		int var=0;
		if(c=='a' | c=='1') var=1;
		else if(c=='a' | c=='1') var=1;
		else if(c=='b' | c=='2') var=2;
		else if(c=='c' | c=='3') var=3;
		else if(c=='d' | c=='4') var=4;
		else if(c=='e' | c=='5') var=5;
		else if(c=='f' | c=='6') var=6;
		
		return var;
	}
	
	public static void mostaTabuleiro (AppRestaUm t) {
		System.out.println("\n");
		char a='a';
		for(int i=7;i>=0;i--) {
			
			
			if(i!=0)System.out.print(+i);
			System.out.print(" ");
			
			for(int j=1;j<=7;j++) {
				
				if(i==0) {
					System.out.print(" "+a);a++;}
				
				else if(i==3|i==4|i==5) {
					   System.out.print(t.tabuleiro[i][j]);
					   System.out.print(" ");
					if(j==7)System.out.println();
					
				} else {
					if(j==3|j==4|j==5) {
						System.out.print(t.tabuleiro[i][j]);
						System.out.print(" ");
						
					}else {
						System.out.print(t.tabuleiro[i][j]);
						System.out.print(" ");
						if(j==7)System.out.println();
					}
				}				
			}
		}
	}
	
	
	public static void main(String [] args) {
		String diretorio = "C:\\Users\\55119\\OneDrive\\Documentos\\testeRestaUm\\arq001.csv";
		executaJogo(diretorio);
			
	}	
}

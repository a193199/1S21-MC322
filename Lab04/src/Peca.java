
public class Peca {
	
	private char peca;
	
public char criaTabuleiro (AppRestaUm t) {
		
		for(int i=1;i<=7;i++) {			
			for(int j=1;j<=7;j++) {
				
				if(i==4 && j==4) peca='-';
				
				else if(i==3|i==4|i==5) {
					peca='P';
									
			  } else {
					if(j==3|j==4|j==5) {
						
						peca= 'P';
					} else {
						peca=' ';
						
					}
				}				
			}
		}
		return peca;
	}
}

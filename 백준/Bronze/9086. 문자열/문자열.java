import java.util.Scanner;

public class Main {
    
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt(); 
		
		String names[] = new String[n];
		
		for(int i = 0; i < n; i++) {
			String str = sc.next();
			names[i] = str.substring(0,1)+ str.substring(str.length()-1,str.length());
		}
				
		for(int i=0;i<n;i++) {
			System.out.println(names[i]);
		}
	}

}

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class TidyNumbers {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("tidyLarge.in"));
		BufferedWriter bw = new BufferedWriter(new FileWriter("tidy.out"));
		int t = Integer.parseInt(br.readLine());
		for(int i = 1; i <= t; i++) {
			char[] chr = br.readLine().toCharArray();
			while(!isTidy(chr)) {
				chr = changnumber(chr);
			}
			System.out.println("Case #" + i + ": " + Long.parseLong(String.valueOf(chr)));
			bw.write("Case #" + i + ": " + Long.parseLong(String.valueOf(chr)) + "\n");
		}
		br.close();
		bw.close();
	}
	
	public static boolean isTidy(char[] chr) {
		for(int i = 0; i < chr.length-1; i++) {
			if(chr[i] > chr[i+1]) return false;
		}
		return true;
	}
	
	public static char[] changnumber(char[] chr) {
		int pos = checkFirstPos(chr);
		chr[pos - 1] = Character.forDigit(Integer.parseInt(chr[pos - 1] + "") - 1, 10);
		for(int i = pos; i < chr.length; i++) {
			chr[i] = '9';
		}
		return chr;
	}
	
	public static int checkFirstPos(char[] chr) {
		for(int i = 0; i < chr.length-1; i++) {
			if(chr[i] > chr[i+1]) return i+1;
		}
		return chr.length;
	}
}

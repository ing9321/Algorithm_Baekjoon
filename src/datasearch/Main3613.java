package datasearch;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.regex.Pattern;

// java vs C++
public class Main3613 {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input3613.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine().trim();
		String java = "^[a-z]+([A-Z]?[a-z]+)*$";
		String cpp = "^[a-z]+(_?[a-z]+)*$";
		boolean javap = Pattern.matches(java, str);
		boolean cppp = Pattern.matches(cpp, str);
		if(cppp) {
			while(str.contains("_")) {
				int idx = str.indexOf("_");
				char tar = str.charAt(idx+1);
				char chg = Character.toUpperCase(tar);
				str = str.replaceAll("_"+tar, chg+"");
				System.out.println(str);
			}
		} else if(javap) {
			System.out.println("JAVA");
			
		} else {
			System.out.println("Error!");
		}
	}

}

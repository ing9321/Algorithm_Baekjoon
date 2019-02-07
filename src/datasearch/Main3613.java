package datasearch;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

// java vs C++
public class Main3613 {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input3613.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine().trim();
		String java = "^[a-z]+([A-Za-z])*$";
		String cpp = "^[a-z]+(_?[a-z]+)*$";
		Pattern pJava = Pattern.compile("([A-Z])");
		boolean javap = Pattern.matches(java, str);
		boolean cppp = Pattern.matches(cpp, str);
		if(cppp) {
			while(str.contains("_")) {
				int idx = str.indexOf("_");
				char tar = str.charAt(idx+1);
				char chg = Character.toUpperCase(tar);
				str = str.replaceAll("_"+tar, chg+"");
			}
			System.out.println(str);
		} else if(javap) {
			Matcher mJava = pJava.matcher(str);
			while(mJava.find()) {
				char ch = Character.toLowerCase(mJava.group().charAt(0));
				str = str.replaceAll(mJava.group(), "_"+ch);
			}
			System.out.println(str);
		} else {
			System.out.println("Error!");
		}
	}

}

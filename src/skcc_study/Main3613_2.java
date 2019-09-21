package skcc_study;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main3613_2 {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input3613.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine().trim();
		
		String java = "^[a-z]+([A-Za-z])*$";
		String cpp = "^[a-z]+(_?[a-z]+)*$";
		boolean isJava = Pattern.matches(java, str);
		boolean isCpp = Pattern.matches(cpp, str);
		if(isJava) {
			Matcher matcher = Pattern.compile("([A-Z])").matcher(str);
			while(matcher.find()) {
				char ch = Character.toLowerCase(matcher.group().charAt(0));
				str = str.replaceAll(matcher.group(), "_"+ch);
			}
		} else if(isCpp) {
			while(str.contains("_")) {
				int idx = str.indexOf("_");
				char ch = Character.toUpperCase(str.charAt(idx+1));
				str = str.replaceAll("_"+str.charAt(idx+1), ch+"");
			}
		} else {
			str = "Error!";
		}

		System.out.println(str);
	}
}

package simulation;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/*
 * 4378 트ㅏㅊ;
 * https://www.acmicpc.net/problem/4378
 * Simulation
 */
public class Main4378 {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input4378.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String str = br.readLine();
		while(str != null) {
			char[] charr = str.toCharArray();
			for (int i = 0, size = charr.length; i < size; i++) {
				char c = charr[i];
				if(c == ' ') {
					sb.append(' ');
				} else if(c == '1') {
					sb.append('`');
				} else if(c == '2') {
					sb.append('1');
				} else if(c == '3') {
					sb.append('2');
				} else if(c == '4') {
					sb.append('3');
				} else if(c == '5') {
					sb.append('4');
				} else if(c == '6') {
					sb.append('5');
				} else if(c == '7') {
					sb.append('6');
				} else if(c == '8') {
					sb.append('7');
				} else if(c == '9') {
					sb.append('8');
				} else if(c == '0') {
					sb.append('9');
				} else if(c == '-') {
					sb.append('0');
				} else if(c == '=') {
					sb.append('-');
				} else if(c == 'W') {
					sb.append('Q');
				} else if(c == 'E') {
					sb.append('W');
				} else if(c == 'R') {
					sb.append('E');
				} else if(c == 'T') {
					sb.append('R');
				} else if(c == 'Y') {
					sb.append('T');
				} else if(c == 'U') {
					sb.append('Y');
				} else if(c == 'I') {
					sb.append('U');
				} else if(c == 'O') {
					sb.append('I');
				} else if(c == 'P') {
					sb.append('O');
				} else if(c == '[') {
					sb.append('P');
				} else if(c == ']') {
					sb.append('[');
				} else if(c == '\\') {
					sb.append(']');
				} else if(c == 'S') {
					sb.append('A');
				} else if(c == 'D') {
					sb.append('S');
				} else if(c == 'F') {
					sb.append('D');
				} else if(c == 'G') {
					sb.append('F');
				} else if(c == 'H') {
					sb.append('G');
				} else if(c == 'J') {
					sb.append('H');
				} else if(c == 'K') {
					sb.append('J');
				} else if(c == 'L') {
					sb.append('K');
				} else if(c == ';') {
					sb.append('L');
				} else if(c == '\'') {
					sb.append(';');
				} else if(c == 'X') {
					sb.append('Z');
				} else if(c == 'C') {
					sb.append('X');
				} else if(c == 'V') {
					sb.append('C');
				} else if(c == 'B') {
					sb.append('V');
				} else if(c == 'N') {
					sb.append('B');
				} else if(c == 'M') {
					sb.append('N');
				} else if(c == ',') {
					sb.append('M');
				} else if(c == '.') {
					sb.append(',');
				} else if(c == '/') {
					sb.append('.');
				}
			}
			sb.append('\n');
			str = br.readLine();
		}
		System.out.print(sb);
	}

}

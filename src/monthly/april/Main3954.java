package monthly.april;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/*
 * 
-	포인터가 가리키는 숫자를 1 감소시킨다. (modulo 28)
+	포인터가 가리키는 숫자를 1 증가시킨다. (module 28)
<	포인터를 왼쪽으로 움직인다.(1 감소)
>	포인터를 오른쪽으로 움직인다.(1 증가)
[	만약 포인터가 가리키는 숫자가 0과 같다면, [와 짝을 이루는 ]로 점프한다.
]	만약 포인터가 가리키는 숫자가 0이 아니라면, ]와 짝을 이루는 [로 점프한다.
.	포인터가 가리키는 숫자를 출력한다.
,	문자 하나를 읽고 포인터가 가리키는 곳에 저장한다. 입력의 마지막(EOF)인 경우에는 255를 저장한다.
 */
// brainfuck 인터프리터
public class Main3954 {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input3954.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine().trim());
		for (int i = 1; i <= T; i++) {
			String[] strarr = br.readLine().split(" ");
			int M = Integer.parseInt(strarr[0]); // 메모리 크리
			int C = Integer.parseInt(strarr[1]); // 코드 크기
			int I = Integer.parseInt(strarr[2]); // 입력크기
		}
	}

}

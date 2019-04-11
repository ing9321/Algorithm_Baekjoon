import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
 * 미해결
 * 17136 색종이 붙이기
 * https://www.acmicpc.net/problem/17136
 * 
 * !! 1x1, 2x2, 3x3, 4x4, 5x5 각 색종이는  5장씩 존재
 */
public class Main17136 {
	static int[][] map;
	static int MIN;
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input17136.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[][] matrix = new int[10][10];
		StringTokenizer st;
		for (int i = 0; i < 10; i++) {
			st = new StringTokenizer(br.readLine().trim());
			for (int j = 0; j < 10; j++) {
				matrix[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		MIN = Integer.MAX_VALUE;
		// 0,0
		map = new int[10][10];
		for (int i = 0; i < 10; i++) {
			System.arraycopy(matrix[i], 0, map[i], 0, 10);
		}
		boolean res1 = go1(new int[] {5, 5, 5, 5, 5});

		// 0,9
		for (int i = 0; i < 10; i++) {
			System.arraycopy(matrix[i], 0, map[i], 0, 10);
		}
		boolean res2 = go2(new int[] {5, 5, 5, 5, 5});
		
		// 9,0
		for (int i = 0; i < 10; i++) {
			System.arraycopy(matrix[i], 0, map[i], 0, 10);
		}
		boolean res3 = go3(new int[] {5, 5, 5, 5, 5});
		
		// 9,9
		for (int i = 0; i < 10; i++) {
			System.arraycopy(matrix[i], 0, map[i], 0, 10);
		}
		boolean res4 = go4(new int[] {5, 5, 5, 5, 5});
		
		if(!res1 && !res2 && !res3 && !res4) MIN = -1;
		
		System.out.println(MIN);
	}
	private static boolean go1(int[] paper) {
		top:
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				if(paper[4] <= 0) break top;
				if(map[i][j] == 1) {
					int cnt = 0;
					for (int m = i; m < i+5; m++) {
						for (int n = j; n < j+5; n++) {
							if(m >= 10 || n >= 10 || map[m][n] == 0) break;
							if(map[m][n] == 1) cnt++;
						}
					}
					if(cnt == 25) {
						for (int m = i; m < i+5; m++) {
							for (int n = j; n < j+5; n++) {
								map[m][n] = 5;
							}
						}
						paper[4]--;
					}
				}
			}
		}
		top:
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				if(paper[3] <= 0) break top;
				if(map[i][j] == 1) {
					int cnt = 0;
					for (int m = i; m < i+4; m++) {
						for (int n = j; n < j+4; n++) {
							if(m >= 10 || n >= 10 || map[m][n] == 0) break;
							if(map[m][n] == 1) cnt++;
						}
					}
					if(cnt == 16) {
						for (int m = i; m < i+4; m++) {
							for (int n = j; n < j+4; n++) {
								map[m][n] = 4;
							}
						}
						paper[3]--;
					}
				}
			}
		}
		top:
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				if(paper[2] <= 0) break top;
				if(map[i][j] == 1) {
					int cnt = 0;
					for (int m = i; m < i+3; m++) {
						for (int n = j; n < j+3; n++) {
							if(m >= 10 || n >= 10 || map[m][n] == 0) break;
							if(map[m][n] == 1) cnt++;
						}
					}
					if(cnt == 9) {
						for (int m = i; m < i+3; m++) {
							for (int n = j; n < j+3; n++) {
								map[m][n] = 3;
							}
						}
						paper[2]--;
					}
				}
			}
		}
		top:
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				if(paper[1] <= 0) break top;
				if(map[i][j] == 1) {
					int cnt = 0;
					for (int m = i; m < i+2; m++) {
						for (int n = j; n < j+2; n++) {
							if(m >= 10 || n >= 10 || map[m][n] == 0) break;
							if(map[m][n] == 1) cnt++;
						}
					}
					if(cnt == 4) {
						for (int m = i; m < i+2; m++) {
							for (int n = j; n < j+2; n++) {
								map[m][n] = 2;
							}
						}
						paper[1]--;
					}
				}
			}
		}
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				if(map[i][j] == 1) paper[0]--;
			}
		}
		if(paper[0] < 0) return false;
		int cnt = 25 - paper[0] - paper[1] - paper[2] - paper[3] - paper[4];
		if(cnt >= 0) {
			MIN = Math.min(MIN, cnt);
			return true;
		} else {
			return false;
		}
	}

	private static boolean go2(int[] paper) {
		top:
		for (int i = 9; i >= 0; i--) {
			for (int j = 0; j < 10; j++) {
				if(paper[4] <= 0) break top;
				if(map[i][j] == 1) {
					int cnt = 0;
					for (int m = i; m > i-5; m--) {
						for (int n = j; n < j+5; n++) {
							if(m < 0 || n >= 10 || map[m][n] == 0) break;
							if(map[m][n] == 1) cnt++;
						}
					}
					if(cnt == 25) {
						for (int m = i; m > i-5; m--) {
							for (int n = j; n < j+5; n++) {
								map[m][n] = 5;
							}
						}
						paper[4]--;
					}
				}
			}
		}
		top:
		for (int i = 9; i >= 0; i--) {
			for (int j = 0; j < 10; j++) {
				if(paper[3] <= 0) break top;
				if(map[i][j] == 1) {
					int cnt = 0;
					for (int m = i; m > i-4; m--) {
						for (int n = j; n < j+4; n++) {
							if(m < 0 || n >= 10 || map[m][n] == 0) break;
							if(map[m][n] == 1) cnt++;
						}
					}
					if(cnt == 16) {
						for (int m = i; m > i-4; m--) {
							for (int n = j; n < j+4; n++) {
								map[m][n] = 4;
							}
						}
						paper[3]--;
					}
				}
			}
		}
		top:
		for (int i = 9; i >= 0; i--) {
			for (int j = 0; j < 10; j++) {
				if(paper[2] <= 0) break top;
				if(map[i][j] == 1) {
					int cnt = 0;
					for (int m = i; m > i-3; m--) {
						for (int n = j; n < j+3; n++) {
							if(m < 0 || n >= 10 || map[m][n] == 0) break;
							if(map[m][n] == 1) cnt++;
						}
					}
					if(cnt == 9) {
						for (int m = i; m > i-3; m--) {
							for (int n = j; n < j+3; n++) {
								map[m][n] = 3;
							}
						}
						paper[2]--;
					}
				}
			}
		}
		top:
		for (int i = 9; i >= 0; i--) {
			for (int j = 0; j < 10; j++) {
				if(paper[1] <= 0) break top;
				if(map[i][j] == 1) {
					int cnt = 0;
					for (int m = i; m > i-2; m--) {
						for (int n = j; n < j+2; n++) {
							if(m < 0 || n >= 10 || map[m][n] == 0) break;
							if(map[m][n] == 1) cnt++;
						}
					}
					if(cnt == 4) {
						for (int m = i; m > i-2; m--) {
							for (int n = j; n < j+2; n++) {
								map[m][n] = 2;
							}
						}
						paper[1]--;
					}
				}
			}
		}
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				if(map[i][j] == 1) paper[0]--;
			}
		}
		if(paper[0] < 0) return false;
		int cnt = 25 - paper[0] - paper[1] - paper[2] - paper[3] - paper[4];
		if(cnt >= 0) {
			MIN = Math.min(MIN, cnt);
			return true;
		} else {
			return false;
		}
	}

	private static boolean go3(int[] paper) {
		top:
		for (int i = 0; i < 10; i++) {
			for (int j = 9; j >= 0; j--) {
				if(paper[4] <= 0) break top;
				if(map[i][j] == 1) {
					int cnt = 0;
					for (int m = i; m < i+5; m++) {
						for (int n = j; n > j-5; n--) {
							if(m >= 10 || n < 0 || map[m][n] == 0) break;
							if(map[m][n] == 1) cnt++;
						}
					}
					if(cnt == 25) {
						for (int m = i; m < i+5; m++) {
							for (int n = j; n > j-5; n--) {
								map[m][n] = 5;
							}
						}
						paper[4]--;
					}
				}
			}
		}
		top:
		for (int i = 0; i < 10; i++) {
			for (int j = 9; j >= 0; j--) {
				if(paper[3] <= 0) break top;
				if(map[i][j] == 1) {
					int cnt = 0;
					for (int m = i; m < i+4; m++) {
						for (int n = j; n > j-4; n--) {
							if(m >= 10 || n < 0 || map[m][n] == 0) break;
							if(map[m][n] == 1) cnt++;
						}
					}
					if(cnt == 16) {
						for (int m = i; m < i+4; m++) {
							for (int n = j; n > j-4; n--) {
								map[m][n] = 4;
							}
						}
						paper[3]--;
					}
				}
			}
		}
		top:
		for (int i = 0; i < 10; i++) {
			for (int j = 9; j >= 0; j--) {
				if(paper[2] <= 0) break top;
				if(map[i][j] == 1) {
					int cnt = 0;
					for (int m = i; m < i+3; m++) {
						for (int n = j; n > j-3; n--) {
							if(m >= 10 || n < 0 || map[m][n] == 0) break;
							if(map[m][n] == 1) cnt++;
						}
					}
					if(cnt == 9) {
						for (int m = i; m < i+3; m++) {
							for (int n = j; n > j-3; n--) {
								map[m][n] = 3;
							}
						}
						paper[2]--;
					}
				}
			}
		}
		top:
		for (int i = 0; i < 10; i++) {
			for (int j = 9; j >= 0; j--) {
				if(paper[1] <= 0) break top;
				if(map[i][j] == 1) {
					int cnt = 0;
					for (int m = i; m < i+2; m++) {
						for (int n = j; n > j-2; n--) {
							if(m >= 10 || n < 0 || map[m][n] == 0) break;
							if(map[m][n] == 1) cnt++;
						}
					}
					if(cnt == 4) {
						for (int m = i; m < i+2; m++) {
							for (int n = j; n > j-2; n--) {
								map[m][n] = 2;
							}
						}
						paper[1]--;
					}
				}
			}
		}
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				if(map[i][j] == 1) paper[0]--;
			}
		}
		if(paper[0] < 0) return false;
		int cnt = 25 - paper[0] - paper[1] - paper[2] - paper[3] - paper[4];
		if(cnt >= 0) {
			MIN = Math.min(MIN, cnt);
			return true;
		} else {
			return false;
		}
	}
	
	private static boolean go4(int[] paper) {
		top:
		for (int i = 9; i >= 0; i--) {
			for (int j = 9; j >= 0; j--) {
				if(paper[4] <= 0) break top;
				if(map[i][j] == 1) {
					int cnt = 0;
					for (int m = i; m > i-5; m--) {
						for (int n = j; n > j-5; n--) {
							if(m  < 0 || n < 0 || map[m][n] == 0) break;
							if(map[m][n] == 1) cnt++;
						}
					}
					if(cnt == 25) {
						for (int m = i; m > i-5; m--) {
							for (int n = j; n > j-5; n--) {
								map[m][n] = 5;
							}
						}
						paper[4]--;
					}
				}
			}
		}
		top:
		for (int i = 9; i >= 0; i--) {
			for (int j = 9; j >= 0; j--) {
				if(paper[3] <= 0) break top;
				if(map[i][j] == 1) {
					int cnt = 0;
					for (int m = i; m > i-4; m--) {
						for (int n = j; n > j-4; n--) {
							if(m  < 0 || n < 0 || map[m][n] == 0) break;
							if(map[m][n] == 1) cnt++;
						}
					}
					if(cnt == 16) {
						for (int m = i; m > i-4; m--) {
							for (int n = j; n > j-4; n--) {
								map[m][n] = 4;
							}
						}
						paper[3]--;
					}
				}
			}
		}
		top:
		for (int i = 9; i >= 0; i--) {
			for (int j = 9; j >= 0; j--) {
				if(paper[2] <= 0) break top;
				if(map[i][j] == 1) {
					int cnt = 0;
					for (int m = i; m > i-3; m--) {
						for (int n = j; n > j-3; n--) {
							if(m  < 0 || n < 0 || map[m][n] == 0) break;
							if(map[m][n] == 1) cnt++;
						}
					}
					if(cnt == 9) {
						for (int m = i; m > i-3; m--) {
							for (int n = j; n > j-3; n--) {
								map[m][n] = 3;
							}
						}
						paper[2]--;
					}
				}
			}
		}
		top:
		for (int i = 9; i >= 0; i--) {
			for (int j = 9; j >= 0; j--) {
				if(paper[1] <= 0) break top;
				if(map[i][j] == 1) {
					int cnt = 0;
					for (int m = i; m > i-2; m--) {
						for (int n = j; n > j-2; n--) {
							if(m  < 0 || n < 0 || map[m][n] == 0) break;
							if(map[m][n] == 1) cnt++;
						}
					}
					if(cnt == 4) {
						for (int m = i; m > i-2; m--) {
							for (int n = j; n > j-2; n--) {
								map[m][n] = 2;
							}
						}
						paper[1]--;
					}
				}
			}
		}
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				if(map[i][j] == 1) paper[0]--;
			}
		}
		if(paper[0] < 0) return false;
		int cnt = 25 - paper[0] - paper[1] - paper[2] - paper[3] - paper[4];
		if(cnt >= 0) {
			MIN = Math.min(MIN, cnt);
			return true;
		} else {
			return false;
		}
	}
}

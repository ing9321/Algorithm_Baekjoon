package simulation;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;

/*
 * 16954 움직이는 미로 탈출
 * https://www.acmicpc.net/problem/16954
 * Simulation
 */
public class Main16954 {
	static int[][] map;
	static int[] posX = {0, 1, 1, 1, 0, -1, -1, -1};
	static int[] posY = {1, 1, 0, -1, -1, -1, 0, 1};
	static LinkedList<int[]> qPerson;
	static LinkedList<int[]> qWall;
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input16954.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		map = new int[8][8];
		qPerson = new LinkedList<int[]>();
		qWall = new LinkedList<int[]>();
		for (int i = 0; i < 8; i++) {
			String line = br.readLine();
			for (int j = 0; j < 8; j++) {
				if(line.charAt(j) == '#') {
					map[i][j] = 1;
					qWall.offer(new int[] {i, j});
				}
			}
		}
		map[7][0] = 2;
		int res = 1;
		int turn = 0;
		while(turn < 8) {
			turn++;
			checkWall();
			if(!qPerson.isEmpty()) {
				movePerson();
			} else {
				res = 0;
				break;
			}
			moveWall();
		}
		System.out.println(res);
	}
	private static void checkWall() {
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				if(map[i][j] == 2) {
					qPerson.offer(new int[] {i, j});
				}
			}
		}
	}
	private static void movePerson() {
		while(!qPerson.isEmpty()) {
			int[] person = qPerson.poll();
			for (int i = 0; i < 8; i++) {
				int nx = person[0] + posX[i];
				int ny = person[1] + posY[i];
				if(nx < 0 || ny < 0 || nx >= 8 || ny >= 8) continue;
				if(map[nx][ny] == 0) {
					map[nx][ny] = 2;
				}
			}
		}
	}
	private static void moveWall() {
		int turn = qWall.size();
		while(turn > 0) {
			turn--;
			int[] wall = qWall.poll();
			map[wall[0]][wall[1]] = 0;
			if(wall[0]+1 < 8) {
				map[wall[0]+1][wall[1]] = 1;				
				qWall.offer(new int[] {wall[0]+1, wall[1]});
			}
		}
	}
}

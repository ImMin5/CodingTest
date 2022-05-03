//https://www.acmicpc.net/source/41565788

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
	static int N, M;
	static char[] answer;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		answer = new char[2 * M];

		for (int i = 0; i < M - 1; i++)
			answer[2 * i + 1] = ' ';
		answer[2 * M - 1] = '\n';
		solution(0);
		System.out.println(sb);
	}

	public static void solution(int idx) {
		if (idx == M) {
			sb.append(answer);
			return;
		}
		for (int i = 1; i < N + 1; i++) {
			answer[idx * 2] = (char) (i + '0');
			solution(idx + 1);
		}
	}
}
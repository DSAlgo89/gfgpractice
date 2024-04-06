package codility;

import java.util.HashSet;
import java.util.Set;

public class CountriesCount {
    private static int solution(int[][] A) {
        // Implement your solution here
        int m = A.length;
        int n = A[0].length;
        boolean[][] visited = new boolean[m][n];

        int count = 0;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(!visited[i][j]) {
                    count++;
                    int color = A[i][j];
                    dfs(A, visited, color, i, j, m, n);
                }
            }
        }
        return count;
    }

    private static void dfs(int[][] A, boolean[][] visited, int color, int i, int j, int m, int n) {
        if(i < 0 || i >= m || j < 0 || j >= n || visited[i][j] || A[i][j] != color)
            return;
        visited[i][j] = true;
        dfs(A, visited, color, i - 1, j, m, n);
        dfs(A, visited, color, i + 1, j, m, n);
        dfs(A, visited, color, i, j - 1, m, n);
        dfs(A, visited, color, i, j + 1, m, n);
    }

    public static void main(String[] args) {
        int[][] map = {{1,1,1},{1,1,1},{1,1,1}};
        int ans = solution(map);

        System.out.println(ans);
    }
}

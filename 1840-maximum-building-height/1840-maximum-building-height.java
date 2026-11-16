import java.util.*;

class Solution {
    public int maxBuilding(int n, int[][] restrictions) {

        Arrays.sort(restrictions, (a, b) -> a[0] - b[0]);

        int m = restrictions.length;

        int[][] arr = new int[m + 2][2];

        arr[0] = new int[]{1, 0};

        for (int i = 0; i < m; i++) {
            arr[i + 1] = restrictions[i];
        }

        arr[m + 1] = new int[]{n, n - 1};

        // Left to right
        for (int i = 1; i < arr.length; i++) {
            arr[i][1] = Math.min(arr[i][1],
                    arr[i - 1][1] + arr[i][0] - arr[i - 1][0]);
        }

        // Right to left
        for (int i = arr.length - 2; i >= 0; i--) {
            arr[i][1] = Math.min(arr[i][1],
                    arr[i + 1][1] + arr[i + 1][0] - arr[i][0]);
        }

        int ans = 0;

        for (int i = 1; i < arr.length; i++) {

            int distance = arr[i][0] - arr[i - 1][0];

            int peak = (arr[i][1] + arr[i - 1][1] + distance) / 2;

            ans = Math.max(ans, peak);
        }

        return ans;
    }
}
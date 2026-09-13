class Solution {
    public int largestOverlap(int[][] img1, int[][] img2) {
        		if (img1.length == 0 || img2.length == 0) {
			return 0;
		}
		int n = img1.length;
		int m = img2.length;
		Map<String, Integer> map = new HashMap<>();
		int answer = 0;
		for (int r = 0; r < n; r++) {
			for (int c = 0; c < n; c++) {
				if (img1[r][c] == 0) {
					continue;
				}

				for (int r1 = 0; r1 < m; r1++) {
					for (int c1 = 0; c1 < m; c1++) {
						if (img2[r1][c1] == 0) {
							continue;
						}

						String key = (r1 - r) + "," + (c1 - c);
						map.put(key, map.getOrDefault(key, 0) + 1);
						answer = Math.max(answer, map.get(key));
					}
				}
			}
		}
		return answer;
    }
}
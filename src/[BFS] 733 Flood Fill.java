class Solution {
    private int[][] directions = new int[][] {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if (image[sr][sc] == newColor) return image;
        Queue<int[]> q = new LinkedList<>();
        int n = image.length, m = image[0].length;
        q.add(new int[] {sr, sc});
        int color = image[sr][sc];
        image[sr][sc] = newColor;
        while(!q.isEmpty()) {
            int size = q.size();
            for(int i = 0; i < size; i++) {
                int[] curr = q.remove();
                for (int[] d : directions) {
                    int x = curr[0] + d[0];
                    int y = curr[1] + d[1];
                    if (x < n && x >= 0 && y < m && y >= 0 && image[x][y] == color) {
                        image[x][y] = newColor;
                        q.add(new int[] {x, y});
                    }
                }
            }
        }
        return image;
    }
}

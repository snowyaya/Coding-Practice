class Solution {
    public int findContentChildren(int[] g, int[] s) {
        // let the small greedy-factored children eat first
        Arrays.sort(g);
        Arrays.sort(s);
        int child = 0, cookie = 0;
        while (child < g.length && cookie < s.length) {
            if (g[child] <= s[cookie]) {
                child++;
                cookie++;
            } else {
                cookie++;
            }
        }
        return child;
    }
}

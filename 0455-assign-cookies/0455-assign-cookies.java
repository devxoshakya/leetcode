class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int cookieIdx = s.length - 1;
        int childIdx = g.length;
        while (cookieIdx >= 0 && --childIdx >= 0) {
            if (s[cookieIdx] >= g[childIdx])
                cookieIdx--;
        }
        return s.length - 1 - cookieIdx;

    }
}
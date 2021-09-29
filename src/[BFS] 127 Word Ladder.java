class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Queue<String> q = new LinkedList<>();
        q.offer(beginWord);
        HashSet<String> wordSet = new HashSet<>(wordList);
        wordSet.remove(beginWord); // the same as marking visited
        int step = 0;
        while (!q.isEmpty()) {
            int size = q.size(); step++;
            while (size-- > 0) {
                String str = q.poll();
                if (str.equals(endWord)) return step; // found shortest transformation path
                for (int i = 0; i < str.length(); i++) {
                    char[] chars = str.toCharArray();
                    for (char c = 'a'; c <= 'z'; c++) { // try to change 1 character of `str`
                        chars[i] = c;
                        String newStr = new String(chars);
                        if (wordSet.contains(newStr)) {
                            q.offer(newStr);
                            wordSet.remove(newStr); // the same as marking visited
                        }
                    }
                }
            }
        }
        return 0; // no such transformation sequence.
    }
}

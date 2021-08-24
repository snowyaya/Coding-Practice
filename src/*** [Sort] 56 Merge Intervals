class Solution {
    public int[][] merge(int[][] intervals) {
        // initialize a list of array
        List<int[]> list = new ArrayList<>();

        Arrays.sort(intervals, (a, b) -> {
            return a[0] - b[0]; 
        });
       
        list.add(intervals[0]);
        
        for(int[] interval : intervals) {
            int[] prev = list.get(list.size() - 1);
            
            if(interval[0] >= prev[0] && interval[1] <= prev[1]) {
                continue;
            } else if(interval[0] <= prev[1]) {
                list.get(list.size() - 1)[1] = interval[1];
            } else {
                list.add(interval);
            }
        }
        
        int[][] returnArr = new int[list.size()][2];
        
        for(int i = 0; i < list.size(); ++i) {
            returnArr[i] = list.get(i);
        }
        
        return returnArr;
    }
}


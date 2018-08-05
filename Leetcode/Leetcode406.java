class Solution {
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, new Comparator<int[]>(){
           public int compare(int[] a, int[] b){
               if (a[0]==b[0]) return a[1]-b[1];
               else return b[0]-a[0];
           } 
        });
        List<int[]> res =new ArrayList<>();
        for (int[] p : people) {
            res.add(p[1], p);
        }
        int [][] result= new int[people.length][2];
        for (int i=0; i<people.length; i++) {
            result[i]=res.get(i);
        }
        return result;
    }
}

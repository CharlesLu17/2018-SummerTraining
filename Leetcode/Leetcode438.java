class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        char[]matchchar= p.toCharArray();
        char[]str= s.toCharArray();
        ArrayList res= new ArrayList();
        int[] match= new int[26];
        for (int i= 0; i< matchchar.length; i++) {
            match[matchchar[i]-'a']++;
        }
        for (int i= 0; i<=str.length-matchchar.length; i++) {
            int[] temp= new int[26];
            for (int j=i; j<i+matchchar.length; j++) {
                temp[str[j]-'a']++;
            }
            if (Arrays.equals(temp,match)) res.add(i);
        }
        return res;
    }
}

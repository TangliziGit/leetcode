// version 2
// 10.51% time, 49.35% space
class Solution {
    private static int lenSize=7;
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<Integer, List<String>> map=new HashMap();
        List<List<String>> ans=new LinkedList();

        for (int i=0; i<strs.length; i++){
            int hash=getHash(strs[i]);
            List<String> lis=null;
            if (map.containsKey(hash))
                lis=map.get(hash);
            else{
                lis=new LinkedList();
                ans.add(lis);       // attend this code.
                map.put(hash, lis);
            }
            lis.add(strs[i]);
        }
        return ans;
    }

    private int getHash(String str){
        int[] vis=new int[26];
        for (int i=0; i<str.length(); i++){
            char ch=str.charAt(i);
            vis[ch-'a']++;
        }

        int hash=0;
        for (int i=0; i<vis.length; i++)
            hash=hash*lenSize+vis[i];
        return hash;
    }
}



// version 1
// 10.51% time, 49.35% space
// class Solution {
//     private static int lenSize=7;
//     public List<List<String>> groupAnagrams(String[] strs) {
//         Map<Integer, List<String>> map=new HashMap();

//         for (int i=0; i<strs.length; i++){
//             int hash=getHash(strs[i]);
//             List<String> lis=null;
//             if (map.containsKey(hash))
//                 lis=map.get(hash);
//             else{
//                 lis=new LinkedList();
//                 map.put(hash, lis);
//             }
//             lis.add(strs[i]);
//         }

//         List<List<String>> ans=new LinkedList();
//         for (List<String> lis: map.values())
//             ans.add(lis);
//         return ans;
//     }

//     private int getHash(String str){
//         int[] vis=new int[26];
//         for (int i=0; i<str.length(); i++){
//             char ch=str.charAt(i);
//             vis[ch-'a']++;
//         }

//         int hash=0;
//         for (int i=0; i<vis.length; i++)
//             hash=hash*lenSize+vis[i];
//         return hash;
//     }
// }


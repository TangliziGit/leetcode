class Solution {
    private static Map<Character, Character> map=new HashMap();
    static{
        map.put('(', ')');
        map.put('{', '}');
        map.put('[', ']');
    }
    
    public boolean isValid(String s) {
        Stack<Character> sta=new Stack();
        int len=s.length();
        
        for (int i=0; i<len; i++){
            if (map.containsKey(s.charAt(i))) sta.push(s.charAt(i));
            else{
                if (!sta.isEmpty() && s.charAt(i)==map.get(sta.peek())) sta.pop();
                else return false;
            }
        }
        
        if (sta.isEmpty())
            return true;
        return false;
    }
}

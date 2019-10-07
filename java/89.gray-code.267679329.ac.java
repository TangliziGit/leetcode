class Solution {
    public List<Integer> grayCode(int n) {
        List<Integer> list=new LinkedList<>();
        for (int i=0; i< 1<<n; i++) list.add(i^(i/2));
        return list;
    }
    
    public List<Integer> grayCodeBefore(int n) {
        if (n==0) return new LinkedList<Integer>(){{add(0);}};
        Integer plus=((Double)Math.pow(2, n-1)).intValue();
        List<Integer> list=grayCodeBefore(n-1);
        List<Integer> tmp=new LinkedList<>();
        
        ListIterator<Integer> it=list.listIterator(list.size());
        while (it.hasPrevious()) tmp.add(it.previous()+plus);
        for (Integer x: tmp) list.add(x);
        return list;
    }
}

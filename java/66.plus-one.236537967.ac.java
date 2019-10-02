class Solution {
    public int[] plusOne(int[] digits) {
        LinkedList<Integer> list=IntStream.of(digits)
            .boxed()
            .collect(Collectors.toCollection(LinkedList::new));
        
        ListIterator iter=list.listIterator(digits.length);
        int tmp=1;
        
        while (iter.hasPrevious()){
            Integer elem=(Integer)iter.previous();
            if (elem+tmp<10){
                iter.set(elem+tmp);
                tmp=0;
            }else{
                iter.set(0);
                tmp=1;
            }
        }
        
        if (tmp!=0) list.addFirst(1);
        return list.stream()
            .mapToInt(Integer::valueOf)
            .toArray();
    }
}

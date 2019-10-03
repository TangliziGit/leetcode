class Solution {
    private String[] words;
    private int maxw;
    
    public List<String> fullJustify(String[] words, int maxWidth) {
        if (words.length==0) return Arrays.asList("");
        this.words=words;
        this.maxw=maxWidth;
        
        List<String> ans=new LinkedList();
        int size=0, ptr=0;
        for (int i=0; i<words.length; i++){
            if (size+(i-ptr)+words[i].length()>maxWidth){
                ans.add(output(ptr, i-1, size));
                size=0; ptr=i;
            }
            size+=words[i].length();
        }
        
        ans.add(outputLastLine(ptr, size));
        return ans;
    }
    
    private String productSpace(int count){
        StringBuilder builder=new StringBuilder();
        while (count --> 0) builder.append(" ");
        return builder.toString();
    }
    
    private String output(int pre, int pos, int size){
        if (pos==pre) return words[pre]+productSpace(maxw-words[pre].length());
        
        int cnt=pos-pre+1, avg=(maxw-size)/(cnt-1), rest=maxw-size-avg*(cnt-1);
        StringBuilder builder=new StringBuilder();
        for (int i=pre; i<pos; i++){
            builder.append(words[i]+productSpace(avg));
            if (rest>0) {builder.append(" "); rest--;}
        }builder.append(words[pos]);
        return builder.toString();
    }
    
    private String outputLastLine(int pre, int size){
        StringBuilder builder=new StringBuilder();
        for (int i=pre; i<words.length-1; i++) builder.append(words[i]+" ");
        builder.append(words[words.length-1]);
        for (int i=builder.length(); i<maxw; i++) builder.append(" ");
        return builder.toString();
    }
}

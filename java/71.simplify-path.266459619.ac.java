class Solution {
    public String simplifyPath(String path) {
        if (path==null || path.length()==0) return "";
        String[] dirs=path.split("/");
        String[] sta=new String[dirs.length];// Stack<String> sta;
        int size=0;
        
        for (String dir: dirs){
            if (dir.equals("") || dir.equals(".")) continue;
            else if (dir.equals("..") && size!=0) size--;
            else if (dir.equals(".."));
            else sta[size++]=dir;
        }
        
        StringBuilder builder=new StringBuilder();
        if (size==0) builder.append("/");
        else for (int i=0; i<size; i++) builder.append("/"+sta[i]);
        return builder.toString();
    }
}

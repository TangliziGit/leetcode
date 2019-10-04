object Solution {
    def minWindow(s: String, t: String): String = {
        var charSet = new Array[Int](200)
        var charSetT = new Array[Int](200)
        t.foreach(x => charSetT(x-'A')+=1)
        
        var pre, cnt: Int = 0
        var prea, posa: Int = -1
        for (pos <- s.indices){
            if (charSet(s(pos)-'A') < charSetT(s(pos)-'A')) cnt+=1
            charSet(s(pos)-'A')+=1
            while (pre<pos && (charSetT(s(pre)-'A')==0 || charSet(s(pre)-'A')>charSetT(s(pre)-'A'))){
                charSet(s(pre)-'A')-=1
                pre+=1
            }
            
            if (cnt==t.length && (pos-pre<posa-prea || prea == -1)){
                prea=pre; posa=pos
            }
        }
        
        if (prea == -1) ""
        else s.substring(prea, posa+1)
    }
}

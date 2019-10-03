import collection.mutable
import collection.JavaConverters._
// since 2.13.0 use jdk.CollectionConverters

object Solution {
    def simplifyPath(path: String): String = {
        if (path == null || path.length == 0) return ""
        val dirs: Array[String]=path.split("/").filter(_ != "")
        var sta = mutable.Stack[String]()
        
        for (dir <- dirs) dir match{
            case "." => None
            case ".." => if (sta.length!=0) sta.pop()
            case _ => sta.push(dir)
        }
        "/"+sta.reverse.mkString("/")
    }
}

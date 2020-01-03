class WordDictionary() {
  private val root: Trie = new Trie(false)
  def addWord(word: String): Unit = root.insert(word)
  def search(word: String): Boolean = root.search(word)

  class Trie(private var stop: Boolean) {
    private val chlids: Array[Trie] = Array.ofDim[Trie](26);

    final def search(word: String): Boolean = word match {
      case "" => stop
      // case s".$tail" =>
      case word if word.startsWith(".") =>
        chlids.exists(x => null != x && x.search(word.tail))
      case word => {
        val ch: Int = word.head - 'a'
        if (null == chlids(ch))
          return false
        chlids(ch).search(word.tail)
      }
    }

    @scala.annotation.tailrec
    final def insert(word: String): Unit = word match {
      case "" => stop = true
      case word => {
        val ch: Int = word.head - 'a'
        if (null == chlids(ch))
          chlids(ch) = new Trie(word.length == 0)
        chlids(ch).insert(word.tail)
      }
    }
  }
}


/**
 * Your WordDictionary object will be instantiated and called as such:
 * var obj = new WordDictionary()
 * obj.addWord(word)
 * var param_2 = obj.search(word)
 */

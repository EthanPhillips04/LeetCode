class Node{
    Node data[];
    boolean isEnd;
    Node(){
        data = new Node[26];
        isEnd = false;
    }
}

class WordDictionary {
    Node root;
    public WordDictionary() {
        root = new Node();
    }
    
    public void addWord(String word) {
        Node curr = root;

        int n = word.length();
        for(int i = 0;i<n;i++){
            int idx = word.charAt(i) - 'a';
            if(curr.data[idx] == null) curr.data[idx] = new Node();
            curr = curr.data[idx] ;
        }

        curr.isEnd = true;
    }
    
    public boolean find(Node curr,char s[],int pos){
        if(curr == null) return false;
        if(pos == s.length) return curr.isEnd;

        if(s[pos] == '.'){
            for(Node child : curr.data){
                if(child != null && find(child,s,pos+1)) return true;
            }
            return false;
        }
        
        return find(curr.data[s[pos] - 'a'],s,pos + 1);
    }

    public boolean search(String word) {
        return find(root,word.toCharArray(),0);
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */
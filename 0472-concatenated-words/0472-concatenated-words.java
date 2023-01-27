class Solution {
    Trie root = new Trie();
    Set<String> set = new HashSet<>();
    class Trie{
        Trie[] childs = new Trie[26];
        String str;
    }
    void insert(String str, Trie root){
        for(char ch : str.toCharArray()){
            if(root.childs[ch-'a'] == null){
                root.childs[ch-'a'] = new Trie();
            }
            root = root.childs[ch-'a'] ;
        }
        root.str = str ;
    }
    void search1(Trie curr){
        if(curr.str != null){
            search2(curr,root);
        }
        for(Trie child : curr.childs){
            if(child != null){
                search1(child);
            }
        }
    }
    void search2(Trie curr, Trie newWord){
        if(curr.str != null && newWord.str != null){
            set.add(curr.str);
        }
        if(newWord.str != null){
            search2(curr,root);
        }
        for(int i=0; i<26; i++){
            if(curr.childs[i] != null && newWord.childs[i] != null){
                search2(curr.childs[i],newWord.childs[i]);
            }
        }
    }
    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        for(String str : words){
            insert(str, root);
        }
        
        search1(root);
        return new ArrayList<>(set);
    }
}
class Solution {
    
    Trie root = new Trie();
    Set<String> set = new HashSet<>();
    
    class Trie{
        // instead of boolean isEnd, here we are taking str variable of type String
        // which is giving us the complete word for which that trieNode is representing.
        // for intermediate trieNode -> the str will be equals to null.
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
        // currently our root is at the last node in trie -> so updating its string
        // which will also act as isEnd.
        root.str = str ;
    }
    
    void search1(Trie curr){
        //we get a word
        if(curr.str != null){
            //to get concatenated word, calling search2 function
            search2(curr,root);
        }
        for(Trie child : curr.childs){
            if(child != null){
                search1(child);
            }
        }
    }
    
    void search2(Trie curr, Trie newWord){
        // we get a concatenated word
        if(curr.str != null && newWord.str != null){
            set.add(curr.str);
        }
        // if a word is concatenated by more than 2 words
        if(newWord.str != null){
            search2(curr,root);
        }
        //checking exact same word characted by character in trie
        for(int i=0; i<26; i++){
            if(curr.childs[i] != null && newWord.childs[i] != null){
                search2(curr.childs[i],newWord.childs[i]);
            }
        }
    }
    
    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        //inserting words into Trie
        for(String str : words){
            insert(str, root);
        }
        //searching all words in trie
        search1(root);
        
        return new ArrayList<>(set);
    }
}
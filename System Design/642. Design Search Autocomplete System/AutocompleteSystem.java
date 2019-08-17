// /*
// * Method: 1 level indexing 
// * Time AutocompleteSystem: O(k*l + 26)
// * Time input: O(s + mlog(m))
// */
// class AutocompleteSystem {
//     HashMap<String, Integer>[] firstlevel;

//     // Maintain two value set with a class
//     class Node{
//         String sentence;
//         int times;
        
//         public Node(String sent, int t){
//             sentence = sent;
//             times = t;
//         }
//     }
    
//     public AutocompleteSystem(String[] sentences, int[] times) {
//         firstlevel = new HashMap[26];
        
//         for(int i = 0; i < 26; i++)
//             firstlevel[i] = new HashMap<String, Integer>();
        
//         for(int i = 0; i < sentences.length; i++)
//             firstlevel[sentences[i].charAt(0) - 'a'].put(sentences[i], times[i]);
        
//     }
    
//     // Main login, but first maintain current string
//     String current_string = "";
    
//     public List<String> input(char c) {
//         List<String> result = new ArrayList<>();
        
//         if(c=='#'){
//             firstlevel[current_string.charAt(0)-'a'].put(current_string, firstlevel[current_string.charAt(0)-'a'].getOrDefault(current_string, 0) + 1);
//             current_string = "";
//         }else{
//             List<Node> list = new ArrayList<>();
//             current_string += c;
            
//             for(String key: firstlevel[current_string.charAt(0) - 'a'].keySet()){
//                 if(key.indexOf(current_string) == 0)
//                     list.add(new Node(key, firstlevel[current_string.charAt(0) - 'a'].get(key)));
//             }
            
//             Collections.sort(list, (a,b) -> a.times == b.times ? a.sentence.compareTo(b.sentence) : b.times - a.times);
            
//             for(int i = 0; i < Math.min(3, list.size()); i++)
//                 result.add(list.get(i).sentence);
//         }
        
//         return result;
//     }
// }

// /**
//  * Your AutocompleteSystem object will be instantiated and called as such:
//  * AutocompleteSystem obj = new AutocompleteSystem(sentences, times);
//  * List<String> param_1 = obj.input(c);
//  */



/*
* Method: Trie Implementation
*/
class AutocompleteSystem {
    // To strore values while returing results
    class Node{
        String sentence;
        int times;
        
        public Node(String st, int t){
            sentence = st;
            times = t;
        }
    }
    
    // Define Trie Class
    class Trie{
        int times;
        Trie[] branches = new Trie[27];
    }
    Trie root;
    
    // Function to get the value of the character
    private int indexChar(char c){
        return (c == ' ' ? 26 : c - 'a');
    }
    
    public AutocompleteSystem(String[] sentences, int[] times) {
        root = new Trie();
        
        for(int i = 0; i < sentences.length; i++){
            utilInsert(root, sentences[i], times[i]);
        }
    }
    
    // Utility fucntion to insert values inside trie data structure
    private void utilInsert(Trie t, String str, int times){
        for(int i = 0; i < str.length(); i++){
            if(t.branches[indexChar(str.charAt(i))] == null)
                t.branches[indexChar(str.charAt(i))] = new Trie();
            
            t = t.branches[indexChar(str.charAt(i))];
        }
        t.times += times;
    }
    
    // Maintain current string
    String current_string = "";
    public List<String> input(char c) {
        List<String> result = new ArrayList<>();
        
        if(c == '#'){
            utilInsert(root, current_string, 1);
            current_string = "";
        }else{
            current_string += c;
            List<Node> list = getNodes(root, current_string);
            
            Collections.sort(list, (a,b) -> a.times == b.times ? a.sentence.compareTo(b.sentence) : b.times - a.times);
            
            for(int i = 0; i < Math.min(3, list.size()); i++)
                result.add(list.get(i).sentence);
        }
        
        return result;
    }
    
    // Utility function to setup nodes and return to the input function
    private List<Node> getNodes(Trie t, String str){
        List<Node> node = new ArrayList<>();
        
        for(int i = 0; i < str.length(); i++){
            if(t.branches[indexChar(str.charAt(i))] == null)
                return new ArrayList<Node>();
            
            t = t.branches[indexChar(str.charAt(i))];
        }
        traverse(str, t, node);
        return node;
    }
    
    // Traversing through the trie data structure
    private void traverse(String str, Trie t, List<Node> node){
        if(t.times > 0)
            node.add(new Node(str, t.times));
        
        for(char ch = 'a'; ch <= 'z'; ch++){
            if(t.branches[ch - 'a'] != null)
                traverse(str + ch, t.branches[ch - 'a'], node);
        }
        
        if(t.branches[26] != null)
            traverse(str + ' ', t.branches[26], node);
    }
}

/**
 * Your AutocompleteSystem object will be instantiated and called as such:
 * AutocompleteSystem obj = new AutocompleteSystem(sentences, times);
 * List<String> param_1 = obj.input(c);
 */
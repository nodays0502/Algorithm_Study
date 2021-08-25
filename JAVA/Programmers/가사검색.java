package Programmer;

import java.util.HashMap;

public class 가사검색 {
    static class Node{
        public char alpha;
        public HashMap<Integer,Integer> count = new HashMap();
        public HashMap<Character,Node> child = new HashMap<>();

        public Node(char alpha) {
            this.alpha = alpha;
        }
    }
    static class Trie{
        Node head = new Node('#');
        public void addWord(String s){
            Node cur = head;
            for(char c : s.toCharArray()){
                if(cur.count.containsKey(s.length())){
                    Integer cnt = cur.count.get(s.length());
                    cur.count.put(s.length(),cnt+1);
                }else{
                    cur.count.put(s.length(),1);
                }
                if(!cur.child.containsKey(c)){
                    cur.child.put(c,new Node(c));
                }
                cur = cur.child.get(c);
            }
        }
        public int search(String s){
            Node cur = head;
            for(char c : s.toCharArray()){
//                System.out.println(cur.alpha);
//                System.out.println(cur.child);
                if(c == '?') break;
                else if(cur.child.containsKey(c)){
                    cur = cur.child.get(c);
                }else{
                    return 0;
                }
            }
            if(cur.count.containsKey(s.length())){
                return cur.count.get(s.length());
            }else{
                return 0;
            }
        }
    }
    public int[] solution(String[] words, String[] queries) {
        int[] answer = new int[queries.length];
        Trie prixTrie = new Trie();
        Trie postTrie = new Trie();
        for(String s : words){
            prixTrie.addWord(s);
            postTrie.addWord(new StringBuilder(s).reverse().toString());
        }
        int index = 0;
        for(String s : queries){
            if(s.charAt(0) == '?'){
                answer[index++] = postTrie.search(new StringBuilder(s).reverse().toString());
            }else{
                answer[index++] = prixTrie.search(s);
            }
            System.out.println();
        }
        return answer;
    }

}

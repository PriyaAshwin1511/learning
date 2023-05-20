package com.java8.string;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class RemoveDuplicates {
    public static void main(String[] args) {
        Set<String> words = new HashSet<>();
        words.add("this");
        words.add("apple");
        words.add("mango");
        Trie trie = new Trie();
        for(String s: words) {
            trie.insert(s);
        }
        System.out.println(removeDuplicates(trie, words, "thisthisthisisisthethe"));
    }

    private static String removeDuplicates(Trie trie, Set<String> words , String sentence) {
        String result = "";
        int minlength = findMinLength(words);
        Set<String> foundwords = new HashSet<>();
        int n = sentence.length();
        int i=0;
        while(i<n){
            int j = i+ minlength;
            if (j <= n) {
                String substr = sentence.substring(i, j);
                boolean isfound = trie.search(substr);
                if(isfound ) {
                    if (!foundwords.contains(substr)) {
                        foundwords.add(substr);
                        result = result.concat(substr);
                    }
                } else {
                    result = result.concat(substr);
                }
                i = i+ substr.length();
            } else {
                result = result.concat(sentence.substring(i));
                break;
            }
        }
        return result;
    }

    private static int findMinLength(Set<String> words) {
        int minlength = Integer.MAX_VALUE;
        for(String s: words) {
            minlength = Math.min(minlength, s.length());
        }
        return minlength;
    }
}

class TrieNode{
    private Map<Character, TrieNode> children ;
    private boolean endOfWord;

    TrieNode() {
        this.children = new HashMap<>();
        this.endOfWord = false;
    }

    public boolean isEndOfWord() {
        return endOfWord;
    }

    public void setEndOfWord(boolean endOfWord) {
        this.endOfWord = endOfWord;
    }

    public Map<Character, TrieNode> getChildren() {
        return children;
    }

    public void setChildren(Map<Character, TrieNode> children) {
        this.children = children;
    }
}
class Trie{
    TrieNode root;
    public Trie() {
        this.root = new TrieNode();
    }

    public void insert(String s) {
        TrieNode node = root;
        char[] charArray = s.toCharArray();
        for(Character ch: charArray) {
            if(!node.getChildren().containsKey(ch)) {
                node.getChildren().put(ch, new TrieNode());
            }
            node = node.getChildren().get(ch);
        }
        node.setEndOfWord(true);
    }

    public boolean search(String s) {
        TrieNode node = root;
        char[] charArray = s.toCharArray();
        for(Character ch: charArray) {
            if(!node.getChildren().containsKey(ch)) {
                return false;
            }
            node = node.getChildren().get(ch);
        }
        return node.isEndOfWord();
    }

}
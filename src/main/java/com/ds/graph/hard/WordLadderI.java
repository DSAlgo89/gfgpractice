package com.ds.graph.hard;

import java.util.*;

public class WordLadderI {
    public static int wordLadderLength(String startWord, String targetWord, String[] wordList) {
        // Code here
        Map<String, List<String>> adjList = new HashMap<>();

        for(int i = 0; i < wordList.length; i++) {
            String currentWord = wordList[i];
            for(int j = 0; j < wordList.length; j++) {
                if(isDiffOne(currentWord, wordList[j])) {
                    if(!adjList.containsKey(currentWord))
                        adjList.put(currentWord, new ArrayList<>());
                    adjList.get(currentWord).add(wordList[j]);

                    if(!adjList.containsKey(wordList[j]))
                        adjList.put(wordList[j], new ArrayList<>());
                    adjList.get(wordList[j]).add(currentWord);
                }
            }
        }

        if(!adjList.containsKey(startWord)) {
            adjList.put(startWord, new ArrayList<>());
            for(int i = 0; i < wordList.length; i++) {
                if(isDiffOne(startWord, wordList[i])) {
                    adjList.get(startWord).add(wordList[i]);

                    if(!adjList.containsKey(wordList[i])) {
                        adjList.put(wordList[i], new ArrayList<>());
                    }
                    adjList.get(wordList[i]).add(startWord);
                }
            }
        }

        if(adjList.get(startWord).isEmpty())
            return -1;
        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        queue.add(startWord);
        visited.add(startWord);
        int len = 1;

        while(!queue.isEmpty()) {
            int size = queue.size();
            for(int i = 0; i < size; i++) {
                String remItem = queue.poll();
                if(remItem.equals(targetWord))
                    return len;
                List<String> neighbors = adjList.getOrDefault(remItem, new ArrayList<>());
                if(!neighbors.isEmpty()) {
                    for(String nei: neighbors) {
                        if(!visited.contains(nei)) {
                            queue.add(nei);
                            visited.add(nei);
                        }
                    }
                }
            }
            len++;
        }

        return 0;
    }

    private static boolean isDiffOne(String word1, String word2) {
        if(word1.length() != word2.length())
            return false;
        int count = 0;
        int n = word1.length();
        int i = 0;
        while(i < n) {
            if(word1.charAt(i) != word2.charAt(i)) {
                count++;
            }
            i++;
        }
        return count == 1;
    }

    public static void main(String[] args) {
        String[] words = {"geek", "gefk"};
        String startWord = "gedk";
        String targetWord = "geek";
        int ans = wordLadderLength(startWord, targetWord, words);

        System.out.println(ans);

        words = new String[]{"poon", "plee", "same", "poie","plea","plie","poin"};
        startWord = "toon";
        targetWord = "plea";
        ans = wordLadderLength(startWord, targetWord, words);

        System.out.println(ans);
    }
}

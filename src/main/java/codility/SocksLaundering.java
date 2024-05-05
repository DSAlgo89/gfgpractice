package codility;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class SocksLaundering {
    static class SockItem implements Comparable<SockItem> {
        int sockId;
        int freq;

        public SockItem(int sockId, int freq) {
            this.sockId = sockId;
            this.freq = freq;
        }

        @Override
        public int compareTo(SockItem sockItem) {
            return sockItem.freq - this.freq;
        }
    }

    private static int solution(int K, int[] C, int[] D) {
        // Implement your solution here
        Map<Integer, Integer> cleanMap = new HashMap<>();
        Map<Integer, Integer> dirtyMap = new HashMap<>();

        for(int i = 0; i < C.length; i++) {
            cleanMap.put(C[i], cleanMap.getOrDefault(C[i], 0) + 1);
        }

        for(int i = 0; i < D.length; i++) {
            dirtyMap.put(D[i], dirtyMap.getOrDefault(D[i], 0) + 1);
        }

        PriorityQueue<SockItem> cleanQ = new PriorityQueue<>();
        for(Map.Entry<Integer, Integer> entry: cleanMap.entrySet()) {
            cleanQ.add(new SockItem(entry.getKey(), entry.getValue()));
        }


        int count = 0;
        while(!cleanQ.isEmpty()) {
            SockItem si = cleanQ.poll();
            if(si.freq % 2 == 0) {
                count += si.freq / 2;
            } else {
                if(K == 0) {
                    int value = si.freq - 1;
                    count += value / 2;
                } else {
                    if(dirtyMap.containsKey(si.sockId)) {
                        count++;
                        int value = dirtyMap.get(si.sockId);
                        value--;
                        if(value == 0) {
                            dirtyMap.remove(si.sockId);
                        } else {
                            dirtyMap.put(si.sockId, value);
                        }
                        K--;
                        count += si.freq / 2;
                    }
                }
            }
        }

        if(K > 0) {
            PriorityQueue<SockItem> dirtyQ = new PriorityQueue<>();
            for(Map.Entry<Integer, Integer> entry: dirtyMap.entrySet()) {
                dirtyQ.add(new SockItem(entry.getKey(), entry.getValue()));
            }
            while(!dirtyQ.isEmpty() && K > 0) {
                SockItem si = dirtyQ.poll();
                if(si.freq <= K) {
                    if(si.freq % 2 == 0) {
                        K = K - si.freq;
                    } else {
                        K = K - si.freq - 1;
                        si.freq = 1;
                        dirtyQ.add(si);
                    }
                    count += si.freq / 2;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {

    }
}

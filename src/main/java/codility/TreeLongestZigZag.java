package codility;

import java.util.LinkedList;
import java.util.Queue;

public class TreeLongestZigZag {
    static class Tree {
        public int x;
        public Tree l;
        public Tree r;
    }

    static class TreeItem {
        Tree node;
        String pathSoFar;

        public TreeItem(Tree node, String pathSoFar) {
            this.node = node;
            this.pathSoFar = pathSoFar;
        }
    }

    public int solution(Tree T) {
        if(T == null || (T.l == null && T.r == null))
            return 0;
        // Implement your solution here
        Queue<TreeItem> queue = new LinkedList<>();
        int maxCount = 0;
        queue.add(new TreeItem(T, "P"));

        while(!queue.isEmpty()) {
            TreeItem treeItem = queue.poll();
            Tree node = treeItem.node;
            String pathSoFar = treeItem.pathSoFar;

            if(node.l == null && node.r == null) {
                int ans = findZigZagCount(pathSoFar);
                maxCount = Integer.max(maxCount, ans);
                continue;
            }

            if(node.l != null) {
                queue.add(new TreeItem(node.l, pathSoFar + "L"));
            }

            if(node.r != null) {
                queue.add(new TreeItem(node.r, pathSoFar + "R"));
            }
        }
        return maxCount;
    }

    private int findZigZagCount(String pathSoFar) {
        int count = 0;
        int len = pathSoFar.length();
        char prevCh = pathSoFar.charAt(len - 1);
        int i = len - 2;
        while(i > 0 && pathSoFar.charAt(i) != 'P') {
            char currentChar = pathSoFar.charAt(i);
            if(currentChar != prevCh) {
                count++;
                prevCh = currentChar;
            }
            i--;
        }
        return count;
    }


    public static void main(String[] args) {

    }
}

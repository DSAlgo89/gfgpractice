package com.ds.graph.medium;

import java.util.*;

public class StepsByKnight {
    static class Position {
        int x;
        int y;

        public Position(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Position position = (Position) o;
            return x == position.x && y == position.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }

    public static int minStepToReachTarget(int KnightPos[], int TargetPos[], int N) {
        // Code here
        int startX = KnightPos[0];
        int startY = KnightPos[1];

        int endX = TargetPos[0];
        int endY = TargetPos[1];

        int[][] directions = {{1,2},{2,1},{-1,2},{-2,1},{2,-1},{-2,-1},{1,-2},{-1,-2}};
        Queue<Position> queue = new LinkedList<>();
        queue.add(new Position(startX, startY));
        Set<Position> visited = new HashSet<>();
        visited.add(new Position(startX, startY));


        int count = 0;
        while(!queue.isEmpty()) {
            int size = queue.size();
            for(int i = 0; i < size; i++) {
                Position pos = queue.poll();
                if(pos.x == endX && pos.y == endY)
                    return count;

                for(int j = 0; j < directions.length; j++) {
                    int newX = pos.x + directions[j][0];
                    int newY = pos.y + directions[j][1];
                    if(newX < 0 || newX >= N || newY < 0 || newY >= N)
                        continue;
                    Position newPos = new Position(newX, newY);
                    if(!visited.contains(newPos)) {
                        queue.add(newPos);
                        visited.add(newPos);
                    }
                }
            }
            count++;
        }
        return count;
    }

    public static void main(String[] args) {

    }
}

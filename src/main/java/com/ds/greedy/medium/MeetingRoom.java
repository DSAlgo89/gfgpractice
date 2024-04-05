package com.ds.greedy.medium;

import java.util.*;

public class MeetingRoom {
    static class Item {
        int start;
        int end;
        int indx;

        public Item(int start, int end, int indx) {
            this.start = start;
            this.end = end;
            this.indx = indx;
        }
    }

    static class FinishTimeComparator implements Comparator<Item> {

        @Override
        public int compare(Item t1, Item t2) {
            return t1.end - t2.end;
        }
    }

    public static int[] printMeetingIds(int[] start, int[] finish)
    {
        // Code here
        int n = start.length;
        List<Item> items = new ArrayList<>();

        for(int i = 0; i < n; i++) {
            Item item = new Item(start[i], finish[i], i + 1);
            items.add(item);
        }

        Collections.sort(items, new FinishTimeComparator());


        List<Item> result = new ArrayList<>();
        result.add(items.get(0));
        for(int i = 1; i < items.size(); i++) {
            Item prevMeeting = result.get(result.size() - 1);
            if(prevMeeting.end < items.get(i).start) {
                result.add(items.get(i));
            }
        }

        int[] finalResult = new int[result.size()];
        for(int i = 0; i < result.size(); i++) {
            finalResult[i] = result.get(i).indx;
        }
        return finalResult;
    }

    public static void main(String[] args) {

    }
}

package com.codingpractice.misc;

import java.util.HashMap;
import java.util.Map;

public class Google_Least_Recently_Used_Random_Shuffle_Playlist {

    Map<Integer, String> songMap = new HashMap<>();
    DllNode start;
    DllNode end;
    public static void main(String[] args) {



    }

    private void createDllList(String[] arr){
        this.start = new DllNode("");
        this.end = new DllNode("");

        //Create doubly linked list
        DllNode cur = null;
        DllNode prev = this.start;
        for(String song : arr){
            cur = new DllNode(song);
            cur.prev = prev;
            prev.next = cur;
            prev = cur;
            cur = cur.next;
        }
        cur.prev = prev;
        prev.next = cur;
        cur.next =end;
        end.prev = cur;
    }

    private void shuffle(String[] arr){
        for(int i=1;i<=arr.length;i++){
            songMap.put(i, arr[i-1]);
        }
    }
    private void play(int n){
        System.out.println(songMap.get(n));
    }

    private void addAtEnd(String C){
        DllNode node = new DllNode(C);
        DllNode prev = end.prev;
        prev.next = node;
        node.prev = prev;

        node.next = end;
        end.prev = node;
    }

    private void remove(DllNode node){
        DllNode prev = node.prev;
        DllNode next = node.next;
        prev.next = next;
        next.prev = prev;
    }

    class DllNode{
        DllNode prev;
        DllNode next;
        String song;

        DllNode(String song){
            this.song = song;
        }
    }
}

package org.example;

public class node {
    char symbl;
    int freqency;
    node left;
    node right;
    node(char symbl,int freqency){
        this.symbl=symbl;
        this.freqency=freqency;
        this.left=null;
        this.right=null;
    }
}

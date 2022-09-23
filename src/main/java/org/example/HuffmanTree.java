package org.example;

import java.security.Security;
import java.util.*;

public class HuffmanTree {
HashMap<Character,Integer> frequences= new HashMap();

    class ImplementComparator implements Comparator<node> {
        public int compare(node x, node y) {
            return x.freqency - y.freqency;
        }
    }
void GetFrequency(String CharArr){
    int tempValue;
    System.out.println("This is the Get GetFrequency Function: "+CharArr);
    for(int i=0; i<CharArr.length();i++){
        if(!frequences.containsKey(CharArr.charAt(i))){
            frequences.put(CharArr.charAt(i),1);
        }
        else {
            frequences.merge(CharArr.charAt(i),1,Integer::sum);
        }
    }
    System.out.println(frequences);
    HuffmanEncoding();
}

void HuffmanEncoding() {
    System.out.println("This is the Get  HuffmanEncoding() Function");
    Queue<node> huffmanNodes = new PriorityQueue(new ImplementComparator());
for(HashMap.Entry<Character,Integer>entry: frequences.entrySet()){
    char temp=entry.getKey();
    int tempNum= entry.getValue();
    huffmanNodes.add(new node(temp,tempNum));

}
for(node temp:huffmanNodes )
    System.out.println(temp.symbl+"|"+temp.freqency);
node root=null;
while (huffmanNodes.size()>1){
    node letterOne=huffmanNodes.peek();
    huffmanNodes.poll();
    node lettertwo=huffmanNodes.peek();
    huffmanNodes.poll();
    node nodeRoot=new node('_',0);
    nodeRoot.freqency= letterOne.freqency+ lettertwo.freqency;
    nodeRoot.right=letterOne;
    nodeRoot.left=lettertwo;
    root=nodeRoot;
    huffmanNodes.add(root);
}
    System.out.println(" Char | Huffman code ");
    System.out.println("--------------------");
    print(root,"");
}

void print(node root,String code){
    if(root.left==null && root.right==null&& Character.isLetter(root.symbl)) {
        System.out.println(root.symbl + "   |  " + code);
        return;
    }
      print(root.left,code+"0");
    print(root.right,code+"1");
}


}

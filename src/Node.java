import java.util.ArrayList;

public class Node {
    //private ArrayList<Integer> arrayList = new ArrayList<>();

    private PerfectHashingSpaceN2 perfectHashingSpaceN2;
    int size;
    Node(){
        this.perfectHashingSpaceN2 = new PerfectHashingSpaceN2(1);
    }

    public boolean insert(int key){
        return this.perfectHashingSpaceN2.insertSecondLevel(key);
    }

    public boolean deleteSecondLevel(int key){
        return this.perfectHashingSpaceN2.deleteSecondLevel(key);
    }

    public boolean search(int key){
        return this.perfectHashingSpaceN2.search(key);
    }

    public PerfectHashingSpaceN2 getPerfectHashingSpaceN2() {
        return perfectHashingSpaceN2;
    }


}

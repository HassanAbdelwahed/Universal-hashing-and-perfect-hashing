import java.util.ArrayList;
import java.util.Arrays;

public class PerfectHashingSpaceN2 {
    Integer[] table;
    ArrayList<Integer> keys = new ArrayList<>();
    int maxSize;
    int currentSize = 0;
    int countRehash = 0;
    UniversalHashing universalHashing;

    public PerfectHashingSpaceN2 (int n) {
        this.table = new Integer[(int) Math.pow(n, 2)];
        this.universalHashing = new UniversalHashing(n * n);
        maxSize = n;
    }
    public boolean insertKey(int key){
        if (currentSize == maxSize)
            return false;
        int hashValue = universalHashing.getHashValue(key);
        //System.out.println(hashValue);
        if (table[hashValue] == null){
            table[hashValue] = key;
            currentSize++;
        } else if (table[hashValue] == key) {
            return false;
        } else {
            reHash();
            countRehash++;
            insertKey(key);
        }
        //System.out.println(Arrays.deepToString(table));
        return true;
    }

    public void reHash(){
        // save elements to rehash it
        ArrayList<Integer> keys = new ArrayList<>();
        for (int i = 0; i < table.length; i++){
            if (table[i] != null){
                keys.add(table[i]);
            }
        }
        currentSize = 0;
        // update hash and table
        this.universalHashing.updateHashMatrix();
        this.table = new Integer[(int) Math.pow(maxSize, 2)];

        for (int i = 0; i < keys.size(); i++){
            int hashValue = universalHashing.getHashValue(keys.get(i));
            if (table[hashValue] == null){
                table[hashValue] = keys.get(i);
                currentSize++;
            }else {
                this.universalHashing.updateHashMatrix();
                this.table = new Integer[(int) Math.pow(maxSize, 2)];
                i = -1;
                currentSize = 0;
            }
        }
    }
    public boolean getKey(int key){
        int hashValue = this.universalHashing.getHashValue(key);
        //System.out.println(hashValue);
        return table[hashValue] != null;
    }
    public int getCountRehash(){
        return countRehash;
    }
}

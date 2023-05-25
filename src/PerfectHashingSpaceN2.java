import java.util.ArrayList;
import java.util.Arrays;

public class PerfectHashingSpaceN2 {
    Integer[] table;
    //boolean flag = false;
    int maxSize = 0;
    int currentSize = 0;
    int countRehash = 0;
    UniversalHashing universalHashing;

    public PerfectHashingSpaceN2 (int n) {
        this.table = new Integer[(int) Math.pow(n, 2)];
        this.universalHashing = new UniversalHashing(n * n);
        maxSize = n;
    }
    public boolean insert(int key){
        if (currentSize == maxSize || this.search(key)){
            // System.out.println(key + " exist");
            return false;
        }

        int hashValue = universalHashing.getHashValue(key);
        if (table[hashValue] == null){
            table[hashValue] = key;
            currentSize++;
        } else if (table[hashValue].equals(key)) {
            return false;
        } else {
            reHash();
            insert(key);
        }
        return true;
    }

    public boolean insertSecondLevel(int key){
        if (currentSize != 0 && this.search(key)){
            return false;
        }
        int hashValue = universalHashing.getHashValue(key);
        if (table[hashValue] == null){
            table[hashValue] = key;
            currentSize++;
        } else if (table[hashValue].equals(key)) {
            return false;
        } else {
            this.maxSize++;
            this.universalHashing = new UniversalHashing(maxSize * maxSize);
            this.reHash();
            this.insert(key);
        }
        return true;
    }

/*
    public boolean insertSecondLevel(int key){ // for O(N) space method
        if (currentSize != 0 && search(key)){
            return false;
        }

        if (flag){
            this.maxSize++;
        }
        this.universalHashing = new UniversalHashing(maxSize * maxSize);
        this.reHash();
        this.insert(key);
        flag = true;
        return true;
    }
*/
    public void reHash(){
        // save elements to rehash it
        ArrayList<Integer> keys = new ArrayList<>();
        for (int i = 0; i < table.length; i++) {
            if (table[i] != null){
                keys.add(table[i]);
            }
        }
        currentSize = 0;
        // update hash and table
        this.universalHashing.updateHashMatrix();
        this.table = new Integer[(int) Math.pow(maxSize, 2)];

        for (int i = 0; i < keys.size(); i++){
            int hashValue = this.universalHashing.getHashValue(keys.get(i));
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
        this.countRehash++;
        // System.out.print("collision");
        // System.out.println("number of rehashing: " + countRehash);
    }
    public boolean search(int key){
        int hashValue = this.universalHashing.getHashValue(key);
        return table[hashValue] != null && table[hashValue] == key;
    }

    public boolean delete(int key){
        if (!search(key)){
            return false;
        }
        int hashValue = this.universalHashing.getHashValue(key);
        table[hashValue] = null;
        this.currentSize--;
        return true;
    }
    public boolean deleteSecondLevel(int key){
        if (!search(key)){
            return false;
        }
        int hashValue = this.universalHashing.getHashValue(key);
        table[hashValue] = null;
        //this.maxSize--;
        this.currentSize--;
        //this.universalHashing = new UniversalHashing(maxSize * maxSize);
        //this.reHash();
        return true;
    }

    public boolean batchInsert(int words[]){
        boolean success = true;
        for (int i = 0; i < words.length; i++){
            boolean res = this.insert(words[i]);
            if (!res){
                success = res;
                System.out.println("Insert " + words[i] + " failed");
            }

        }
        return success;
    }

    public boolean batchDelete(int words[]){
        boolean success = true;
        for (int i = 0; i < words.length; i++){
            boolean res = this.delete(words[i]);
            if (!res){
                success = res;
                System.out.println("Delete " + words[i] + " failed");
            }
        }
        return success;
    }

    public int getCountRehash(){
        return countRehash;
    }
    public int getSize(){return table.length;}

    public void printTable(){
        System.out.println("size = " + table.length);
        System.out.println(Arrays.deepToString(table));
    }
}

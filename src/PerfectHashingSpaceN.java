import java.util.ArrayList;
import java.util.Arrays;

public class PerfectHashingSpaceN {
    Node[] table;
    UniversalHashing universalHashing;
    int countRehash = 0;
    PerfectHashingSpaceN(int n){
        this.table = new Node[n];
        this.universalHashing = new UniversalHashing(n);
    }

    public boolean insert(int key){
        int hashValue = universalHashing.getHashValue(key);
        if (table[hashValue] == null){                     // no collision
            table[hashValue] = new Node();
        }
        // count rehashing before insert
        int count = table[hashValue].countRehash();
        boolean success = table[hashValue].insert(key);
        // count rehashing after insert
        int count2 = table[hashValue].countRehash();
        this.countRehash += count2 - count;
        // System.out.println("insert " + key + success);
        return success;
    }

    public boolean search(int key){
        int hashValue = universalHashing.getHashValue(key);
        if (table[hashValue] == null){
            return false;
        }
        return table[hashValue].search(key);
    }

    public boolean delete(int key){
        int hashValue = universalHashing.getHashValue(key);
        if (table[hashValue] == null){
            return false;
        }
        if (table[hashValue].getPerfectHashingSpaceN2().getSize() == 1 && table[hashValue].getPerfectHashingSpaceN2().search(key)){
            table[hashValue] = null;
            return true;
        }
        return table[hashValue].deleteSecondLevel(key) ;
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

    public void printTable(){
        for (int i = 0; i < table.length; i++){
            if (table[i] == null){
                System.out.println("null");
            }else {
                System.out.println(Arrays.deepToString(table[i].getPerfectHashingSpaceN2().table));
            }
        }
    }
    public int getCountRehash(){
        return countRehash;
    }


}

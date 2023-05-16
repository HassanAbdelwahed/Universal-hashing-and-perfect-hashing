import java.util.ArrayList;
import java.util.Arrays;

public class PerfectHashingSpaceN {
    Node[] table;
    UniversalHashing universalHashing;
    PerfectHashingSpaceN(int n){
        this.table = new Node[n];
        this.universalHashing = new UniversalHashing(n);
    }

    public boolean insert(int key){
        int hashValue = universalHashing.getHashValue(key);
        if (table[hashValue] == null){                     // no collision
            table[hashValue] = new Node();
        }
        return table[hashValue].insert(key);
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
            success = this.insert(words[i]);
        }
        return success;
    }
    public boolean batchDelete(int words[]){
        boolean success = true;
        for (int i = 0; i < words.length; i++){
            success = this.delete(words[i]);
        }
        return success;
    }

    public void printTables(){
        for (int i = 0; i < table.length; i++){
            if (table[i] == null){
                System.out.println("null");
            }else {
                System.out.println(Arrays.deepToString(table[i].getPerfectHashingSpaceN2().table));
            }
        }
    }


}

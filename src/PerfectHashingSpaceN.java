import java.util.ArrayList;

public class PerfectHashingSpaceN {
    Node[] table;
    UniversalHashing universalHashing;
    PerfectHashingSpaceN(int n){
        this.table = new Node[n];
        this.universalHashing = new UniversalHashing(n);
    }

    public boolean insertKey(int key){
        int hashValue = universalHashing.getHashValue(key);
        return table[hashValue].insertKey(key);
    }
}

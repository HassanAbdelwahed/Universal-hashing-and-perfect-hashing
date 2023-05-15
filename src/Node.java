import java.util.ArrayList;

public class Node {
    private ArrayList<Integer> arrayList = new ArrayList<>();

    public boolean insertKey(int key){
        if (arrayList.contains(key)){
            return false;
        }
        arrayList.add(key);
        return true;
    }

}

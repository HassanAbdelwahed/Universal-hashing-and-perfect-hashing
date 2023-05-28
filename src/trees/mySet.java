package trees;

public interface mySet <Key extends Comparable<Key>>{
    boolean Insert(Key key);
    boolean Delete(Key key);
    boolean Search(Key key);
    int Size();
    int Height();
}
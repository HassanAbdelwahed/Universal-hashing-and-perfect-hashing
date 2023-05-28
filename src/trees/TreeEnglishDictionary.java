package trees;

import java.nio.file.Paths;
import java.util.*;

public class TreeEnglishDictionary {
    private mySet<String> dict;

    public TreeEnglishDictionary(String type) {
        if (type.equals("AVL")) {
            dict = new AVLTree<>();
        }else if (type.equals("RedBlack")) {
            dict = new RedBlackTree<>();
        }
    }

    public boolean insert(String key) {
        return dict.Insert(key);
    }
    public boolean delete(String key) {
        return dict.Delete(key);
    }
    public boolean search(String key) {
        return dict.Search(key);
    }

    public int batchInsert(String fpath) {
        int count = 0;
        try (Scanner scanner = new Scanner(Paths.get(fpath))) {
            while (scanner.hasNextLine()) {
                String row = scanner.nextLine();
                if (dict.Insert(row))
                    count++;
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        return count;
    }

    public int batchDelete(String fpath) {
        int count = 0;
        try (Scanner scanner = new Scanner(Paths.get(fpath))) {
            while (scanner.hasNextLine()) {
                String row = scanner.nextLine();
                if (dict.Delete(row))
                    count++;
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        return count;
    }

    public int size() {
        return dict.Size();
    }

    public int height() {
        return dict.Height();
    }

    public static void main(String[] args) {

    }
}

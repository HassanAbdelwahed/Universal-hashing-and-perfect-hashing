import org.junit.jupiter.api.Test;
import trees.TreeEnglishDictionary;

import static org.junit.jupiter.api.Assertions.*;

public class perfectHashAndTreesTest {
    @Test
    void searchTimeComparison() {
        EnglishDictionary hashN = new EnglishDictionary(1, 1000);
        hashN.batchInsert("words.txt");
        TreeEnglishDictionary AVLDictionary = new TreeEnglishDictionary("AVL");
        TreeEnglishDictionary redBlackDictionary = new TreeEnglishDictionary("RedBlack");
//        EnglishDictionary hashN2= new EnglishDictionary(2, 1000);
//        hashN2.batchInsert("words.txt");
        long hashMapTime, AVLTreeTime, redBlackTreeTime;
        // hashN search
        long startN = System.nanoTime();
        hashN.search("scvv");
        long endN = System.nanoTime();
        hashMapTime = endN - startN;
        // AVL Tree search
        long startAVL = System.nanoTime();
        hashN.search("scvv");
        long endAVL = System.nanoTime();
        AVLTreeTime = endAVL - startAVL;
        // red black tree search
        long startRedBlack = System.nanoTime();
        hashN.search("scvv");
        long endRedBlack = System.nanoTime();
        redBlackTreeTime = endRedBlack - startRedBlack;

        assertTrue( hashMapTime > AVLTreeTime);
        assertTrue( hashMapTime > redBlackTreeTime);
    }
}

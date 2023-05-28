import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EnglishDictionaryTest {
    @Test
    void insertNOTExistingElementReturnTrue() {
        EnglishDictionary mytest = new EnglishDictionary(1, 500);
        EnglishDictionary mytest2 = new EnglishDictionary(2, 500);
        assertTrue(mytest.insert("qzeacpem"));
        assertTrue(mytest2.insert("qzeacpem"));
    }
    @Test
    void insertExistingElementReturnFalse() {
        EnglishDictionary mytest = new EnglishDictionary(1, 500);
        mytest.insert("qzeacpem");
        assertFalse(mytest.insert("qzeacpem"));
        EnglishDictionary mytest2 = new EnglishDictionary(2, 500);
        mytest2.insert("qzeacpem");
        assertFalse(mytest2.insert("qzeacpem"));
    }
    @Test
    void deleteExistingElementReturnTrue() {
        EnglishDictionary mytest = new EnglishDictionary(1, 500);
        mytest.insert("qzeacpem");
        assertTrue(mytest.delete("qzeacpem"));
        EnglishDictionary mytest2 = new EnglishDictionary(2, 500);
        mytest2.insert("qzeacpem");
        assertTrue(mytest2.delete("qzeacpem"));
    }

    @Test
    void deleteNOTExitingElementReturnFalse() {
        EnglishDictionary mytest = new EnglishDictionary(1, 500);
        mytest.insert("qzeacpem");
        assertFalse(mytest.delete("qz"));
        EnglishDictionary mytest2 = new EnglishDictionary(2, 500);
        mytest2.insert("qzeacpem");
        assertFalse(mytest2.delete("qz"));

    }

    @Test
    void search() {
    }
    @Test
    void searchExitingElementReturnTrue() {
        EnglishDictionary mytest = new EnglishDictionary(1, 500);
        mytest.insert("qzeacpem");
        assertTrue(mytest.search("qzeacpem"));
        EnglishDictionary mytest2 = new EnglishDictionary(2, 500);
        mytest2.insert("qzeacpem");
        assertTrue(mytest2.search("qzeacpem"));

    }
    @Test
    void searchNOTExitingKeyReturnFalse() {
        EnglishDictionary mytest = new EnglishDictionary(1, 500);
        mytest.insert("qzeacpem");
        assertFalse(mytest.search("qz"));
        EnglishDictionary mytest2 = new EnglishDictionary(2, 500);
        mytest2.insert("qzeacpem");
        assertFalse(mytest2.search("qz"));

    }


    @Test
    void batchInsertSpaceN() {
        EnglishDictionary mytest = new EnglishDictionary(1, 1000);
        assertTrue(mytest.batchInsert("words.txt"));
    }
    @Test
    void batchInsertSpaceN2() {
        EnglishDictionary mytest2 = new EnglishDictionary(2, 1000);
        assertTrue(mytest2.batchInsert("words.txt"));
    }

    @Test
    void batchDeleteN() {
        EnglishDictionary mytest = new EnglishDictionary(1, 1000);
        mytest.batchInsert("words.txt");
        assertTrue(mytest.batchDelete("words.txt"));
    }
    @Test
    void batchDeleteN2() {
        EnglishDictionary mytest = new EnglishDictionary(2, 1000);
        mytest.batchInsert("words.txt");
        assertTrue(mytest.batchDelete("words.txt"));
    }

    @Test
    void batchInsertTimeComparison() {
        //>>>>>>>>>Revise<<<<<<<
        EnglishDictionary mytest = new EnglishDictionary(1, 1000);
        long N,N2;
        long startN = System.nanoTime();
        mytest.batchInsert("words.txt");
        long endN = System.nanoTime();
        N = endN - startN;
        EnglishDictionary mytest2 = new EnglishDictionary(2, 1000);
        long startN2 = System.nanoTime();
        mytest2.batchInsert("words.txt");
        long endN2 = System.nanoTime();
        N2 = endN2 - startN2;
        assertTrue(N2 < N);
    }
    @Test
    void searchTimeComparisonBetweenhashNandhashN2() {
        EnglishDictionary hashN = new EnglishDictionary(1, 1000);
        hashN.batchInsert("words.txt");
        EnglishDictionary hashN2= new EnglishDictionary(2, 1000);
        hashN2.batchInsert("words.txt");
        long N,N2;
        // hashN search
        long startN = System.nanoTime();
        hashN.search("scvv");
        long endN = System.nanoTime();
        N = endN - startN;
        // hashN2 search
        long startN2 = System.nanoTime();
        hashN.search("scvv");
        long endN2 = System.nanoTime();
        N2 = endN2 - startN2;
        assertTrue(N > N2);
    }
    @Test
    void sizeComparisonBetweenhashNandhashN2() {
        EnglishDictionary hashN = new EnglishDictionary(1, 1000);
        hashN.batchInsert("words.txt");
        EnglishDictionary hashN2= new EnglishDictionary(2, 1000);
        hashN2.batchInsert("words.txt");
        assertTrue(hashN.getSize() < hashN2.getSize());
    }
    @Test
    void hashingCountComparisonBetweenhashNandhashN2() {
        EnglishDictionary hashN = new EnglishDictionary(1, 1000);
        hashN.batchInsert("words.txt");
        EnglishDictionary hashN2= new EnglishDictionary(2, 1000);
        hashN2.batchInsert("words.txt");
        assertTrue(hashN.getCountRehash() > hashN2.getCountRehash());
    }
}
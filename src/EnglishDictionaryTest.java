import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EnglishDictionaryTest {
    @Test
    void insertNOTExistingElementReturnTrue() {
        EnglishDictionary mytest = new EnglishDictionary(1);
        EnglishDictionary mytest2 = new EnglishDictionary(2);
        assertTrue(mytest.insert("qzeacpem"));
        assertTrue(mytest2.insert("qzeacpem"));
    }
    @Test
    void insertExistingElementReturnFalse() {
        EnglishDictionary mytest = new EnglishDictionary(1);
        mytest.insert("qzeacpem");
        assertFalse(mytest.insert("qzeacpem"));
        EnglishDictionary mytest2 = new EnglishDictionary(2);
        mytest2.insert("qzeacpem");
        assertFalse(mytest2.insert("qzeacpem"));
    }
    @Test
    void deleteExistingElementReturnTrue() {
        EnglishDictionary mytest = new EnglishDictionary(1);
        mytest.insert("qzeacpem");
        assertTrue(mytest.delete("qzeacpem"));
        EnglishDictionary mytest2 = new EnglishDictionary(2);
        mytest2.insert("qzeacpem");
        assertTrue(mytest2.delete("qzeacpem"));
    }

    @Test
    void deleteNOTExitingElementReturnFalse() {
        EnglishDictionary mytest = new EnglishDictionary(1);
        mytest.insert("qzeacpem");
        assertFalse(mytest.delete("qz"));
        EnglishDictionary mytest2 = new EnglishDictionary(2);
        mytest2.insert("qzeacpem");
        assertFalse(mytest2.delete("qz"));

    }

    @Test
    void search() {
    }
    @Test
    void searchExitingElementReturnTrue() {
        EnglishDictionary mytest = new EnglishDictionary(1);
        mytest.insert("qzeacpem");
        assertTrue(mytest.search("qzeacpem"));
        EnglishDictionary mytest2 = new EnglishDictionary(2);
        mytest2.insert("qzeacpem");
        assertTrue(mytest2.search("qzeacpem"));

    }
    @Test
    void searchNOTExitingKeyReturnFalse() {
        EnglishDictionary mytest = new EnglishDictionary(1);
        mytest.insert("qzeacpem");
        assertFalse(mytest.search("qz"));
        EnglishDictionary mytest2 = new EnglishDictionary(2);
        mytest2.insert("qzeacpem");
        assertFalse(mytest2.search("qz"));

    }


    @Test
    void batchInsertSpaceN() {
        EnglishDictionary mytest = new EnglishDictionary(1);
        assertTrue(mytest.batchInsert("insert_words.txt"));
    }
//    @Test
//    void batchInsertSpaceN2() {
//        EnglishDictionary mytest2 = new EnglishDictionary(2);
//        assertTrue(mytest2.batchInsert("insert_words.txt"));
//    }

    @Test
    void batchInsertTimeComparison() {
        //>>>>>>>>>Revise<<<<<<<
        EnglishDictionary mytest = new EnglishDictionary(1);
        long N,N2;
        long startN = System.nanoTime();
        mytest.batchInsert("insert_words.txt");
        long endN = System.nanoTime();
        N = endN - startN;
        EnglishDictionary mytest2 = new EnglishDictionary(2);
        long startN2 = System.nanoTime();
        mytest2.batchInsert("insert_words.txt");
        long endN2 = System.nanoTime();
        N2 = endN2 - startN2;
        assertTrue(N2 < N);

    }

    @Test
    void batchDeleteN() {
        EnglishDictionary mytest = new EnglishDictionary(1);
        mytest.batchInsert("insert_words.txt");
        assertTrue(mytest.batchDelete("delete_words.txt"));
    }
//    @Test
//    void batchDeleteN2() {
//        EnglishDictionary mytest = new EnglishDictionary(2);
////        mytest.batchInsert("insert_words.txt");
//        assertTrue(mytest.batchDelete("delete_words.txt"));
//    }
}
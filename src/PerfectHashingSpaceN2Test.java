import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PerfectHashingSpaceN2Test {

    @Test
    void insertNOTExistingKeyReturnTrue() {
        PerfectHashingSpaceN2 mytest = new PerfectHashingSpaceN2(10000);

        assertTrue(mytest.insert(10));
    }
    @Test
    void insertExistingKeyReturnFalse() {
        PerfectHashingSpaceN2 mytest = new PerfectHashingSpaceN2(10000);
        mytest.insert(10);
        assertFalse(mytest.insert(10));
    }
    @Test
    void searchExitingKeyReturnTrue() {
        PerfectHashingSpaceN2 mytest = new PerfectHashingSpaceN2(10000);
        mytest.insert(10);
        assertTrue(mytest.search(10));

    }
    @Test
    void searchNOTExitingKeyReturnFalse() {
        PerfectHashingSpaceN2 mytest = new PerfectHashingSpaceN2(10000);
        mytest.insert(10);
        assertFalse(mytest.search(11));

    }

    @Test
    void deleteExistingKeyReturnTrue() {
        PerfectHashingSpaceN2 mytest = new PerfectHashingSpaceN2(10000);
        mytest.insert(10);
        assertTrue(mytest.delete(10));
    }

    @Test
    void deleteNOTExitingKeyReturnFalse() {
        PerfectHashingSpaceN2 mytest = new PerfectHashingSpaceN2(10000);
        mytest.insert(10);
        assertFalse(mytest.delete(11));

    }
    @Test
    void insertSLNOTExistingKeyReturnTrue() {
        PerfectHashingSpaceN2 mytest = new PerfectHashingSpaceN2(10000);

        assertTrue(mytest.insertSecondLevel(10));
    }
    @Test
    void insertSLExistingKeyReturnFalse() {
        PerfectHashingSpaceN2 mytest = new PerfectHashingSpaceN2(10000);
        mytest.insert(10);
        assertFalse(mytest.insertSecondLevel(10));
    }
    @Test
    void deleteSLExistingKeyReturnTrue() {
        PerfectHashingSpaceN2 mytest = new PerfectHashingSpaceN2(10000);
        mytest.insert(10);
        assertTrue(mytest.delete(10));
    }

    @Test
    void deleteSLNOTExitingKeyReturnFalse() {
        PerfectHashingSpaceN2 mytest = new PerfectHashingSpaceN2(10000);
        mytest.insert(10);
        assertFalse(mytest.deleteSecondLevel(11));

    }

//    @Test
//    void batchInsert() {
//    }
//
//    @Test
//    void batchDelete() {
//    }
//
//    @Test
//    void getCountRehash() {
//    }
//
//    @Test
//    void getSize() {
//
//    }
}
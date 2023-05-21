import static org.junit.jupiter.api.Assertions.*;

class PerfectHashingSpaceNTest {

    @org.junit.jupiter.api.Test
    void insertNOTExistingKeyReturnTrue() {
    PerfectHashingSpaceN mytest = new PerfectHashingSpaceN(2000000);

    assertTrue(mytest.insert(10));
    }
    @org.junit.jupiter.api.Test
    void insertExistingKeyReturnFalse() {
        PerfectHashingSpaceN mytest = new PerfectHashingSpaceN(2000000);
        mytest.insert(10);
        assertFalse(mytest.insert(10));
    }

    @org.junit.jupiter.api.Test
    void searchExitingKeyReturnTrue() {
        PerfectHashingSpaceN mytest = new PerfectHashingSpaceN(2000000);
        mytest.insert(10);
        assertTrue(mytest.search(10));

    }
    @org.junit.jupiter.api.Test
    void searchNOTExitingKeyReturnFalse() {
        PerfectHashingSpaceN mytest = new PerfectHashingSpaceN(2000000);
        mytest.insert(10);
        assertFalse(mytest.search(11));

    }

    @org.junit.jupiter.api.Test
    void deleteExistingKeyReturnTrue() {
        PerfectHashingSpaceN mytest = new PerfectHashingSpaceN(2000000);
        mytest.insert(10);
        assertTrue(mytest.delete(10));
    }

    @org.junit.jupiter.api.Test
    void deleteNOTExitingKeyReturnFalse() {
        PerfectHashingSpaceN mytest = new PerfectHashingSpaceN(2000000);
        mytest.insert(10);
        assertFalse(mytest.delete(11));

    }
//    @org.junit.jupiter.api.Test
//    void batchInsert() {
//    }
//
//    @org.junit.jupiter.api.Test
//    void batchDelete() {
//    }
}
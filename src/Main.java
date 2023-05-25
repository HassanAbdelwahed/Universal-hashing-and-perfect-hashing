import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int operationNumber;
        int hashType;
        String insertedWord;
        String deletedWord;
        String searchedWord;
        String filePath;
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("Insert number of perfect hashing type (1-space N  2-space N2) : ");
            hashType = scanner.nextInt();
            if(hashType == 1 || hashType == 2) break;
            else System.out.println("Invalid type");
        }
        EnglishDictionary dictionary = new EnglishDictionary(hashType);
        while(true) {
            System.out.println("\n[1-insert, 2-delete, 3-search, 4-batch insert, 5-batch delete,  6-get Size, 7-rehashing count, 8-exit]");
            System.out.print("Insert operaton number you want to perform: ");
            operationNumber = scanner.nextInt();
            if(operationNumber == 8 ) break;
            switch (operationNumber) {
                case 1:
                    System.out.print("Word to be inserted: ");
                    insertedWord = scanner.next();
                    if (dictionary.insert(insertedWord)) {
                        System.out.printf("\"%s\" is added\n", insertedWord);
                    } else {
                        System.out.println("Error");
                    }
                    break;
                case 2:
                    System.out.print("Word to be deleted: ");
                    deletedWord = scanner.next();
                    if (dictionary.delete(deletedWord)) {
                        System.out.printf("\"%s\" is deleted\n", deletedWord);
                    } else {
                        System.out.println("word doesn't exist");
                    }
                    break;
                case 3:
                    System.out.print("Word to be searched: ");
                    searchedWord = scanner.next();
                    if (dictionary.search(searchedWord)) {
                        System.out.printf("\"%s\" word exists\n", searchedWord);
                    } else {
                        System.out.printf("\"%s\" word doesn't exist\n", searchedWord);
                    }
                    break;
                case 4:
                    System.out.print("directory of file of words to be inserted: ");
                    filePath = scanner.next();
                    if (dictionary.batchInsert(filePath)) {
                        System.out.printf("words inserted successfully\n");
                    } else {
                        System.out.println("there are previously existing words");
                    }
                    break;
                case 5:
                    System.out.print("directory of file of words to be deleted: ");
                    filePath = scanner.next();
                    if (dictionary.batchDelete(filePath)) {
                        System.out.printf("words deleted successfully\n");
                    } else {
                        System.out.println("there are words that don't exist");
                    }
                    break;
                case 6:
                    System.out.print("Size = " + dictionary.getSize());
                    break;
                case 7:
                    System.out.println("Rehashing count = " + dictionary.getCountRehash());
                    break;
                default:
                    System.out.println("invalid input");
            }
        }

//        PerfectHashingSpaceN2 perfectHashingSpaceN2 = new PerfectHashingSpaceN2(7);
//        PerfectHashingSpaceN perfectHashingSpaceN = new PerfectHashingSpaceN(5);
//        StringMapping stringMapping = new StringMapping();

        //System.out.print("insert hello" );
//        System.out.println(perfectHashingSpaceN.insert(stringMapping.getMapping("hello")));
        //System.out.print("insert hello" );
//        System.out.println(perfectHashingSpaceN.insert(stringMapping.getMapping("hello")));
//        System.out.println(perfectHashingSpaceN.insert(stringMapping.getMapping("ahmed")));
//        System.out.println(perfectHashingSpaceN.insert(stringMapping.getMapping("ashraf")));
//        System.out.println(perfectHashingSpaceN.insert(stringMapping.getMapping("magdy")));
//        System.out.println(perfectHashingSpaceN.insert(stringMapping.getMapping("omar")));
//        System.out.println(perfectHashingSpaceN.insert(stringMapping.getMapping("hassan")));
//        System.out.println(perfectHashingSpaceN.search(stringMapping.getMapping("ahmed")));
        //perfectHashingSpaceN.printTables();
//        System.out.println(perfectHashingSpaceN.delete(stringMapping.getMapping("ahmed")));
//        System.out.println(perfectHashingSpaceN.search(stringMapping.getMapping("ahmed")));
        /*
        System.out.println(perfectHashingSpaceN.insert(stringMapping.getMapping("khamis")));
        System.out.println(perfectHashingSpaceN.insert(stringMapping.getMapping("abbas")));
        System.out.println(perfectHashingSpaceN.insert(stringMapping.getMapping("omar")));
        System.out.println(perfectHashingSpaceN.insert(stringMapping.getMapping("hassan")));
        System.out.println(perfectHashingSpaceN.insert(stringMapping.getMapping("khamis")));
        System.out.println(perfectHashingSpaceN.insert(stringMapping.getMapping("abbas")));*/

        // perfectHashingSpaceN.printTables();
        /*
        System.out.println(perfectHashingSpaceN.insert(stringMapping.getMapping("hello")));
        System.out.println(perfectHashingSpaceN.insert(stringMapping.getMapping("hello")));
        System.out.println(perfectHashingSpaceN.insert(stringMapping.getMapping("ahmed")));
        System.out.println(perfectHashingSpaceN.insert(stringMapping.getMapping("omar")));
        System.out.println(perfectHashingSpaceN.insert(stringMapping.getMapping("hassan")));
        System.out.println(perfectHashingSpaceN.insert(stringMapping.getMapping("khamis")));
        System.out.println(perfectHashingSpaceN.insert(stringMapping.getMapping("abbas")));

        /*
        System.out.println(perfectHashingSpaceN.insert(10));
        System.out.println(perfectHashingSpaceN.insert(20));
        System.out.println(perfectHashingSpaceN.insert(30));
        System.out.println(perfectHashingSpaceN.insert(40));
        System.out.println(perfectHashingSpaceN.insert(50));
        System.out.println(perfectHashingSpaceN.insert(60));*/

        // perfectHashingSpaceN.printTables();

    }
}
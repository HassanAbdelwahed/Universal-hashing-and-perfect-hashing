import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        PerfectHashingSpaceN2 perfectHashingSpaceN2 = new PerfectHashingSpaceN2(7);
        PerfectHashingSpaceN perfectHashingSpaceN = new PerfectHashingSpaceN(5);
        StringMapping stringMapping = new StringMapping();


        //System.out.print("insert hello" );
        System.out.println(perfectHashingSpaceN.insert(stringMapping.getMapping("hello")));
        //System.out.print("insert hello" );
        System.out.println(perfectHashingSpaceN.insert(stringMapping.getMapping("hello")));
        System.out.println(perfectHashingSpaceN.insert(stringMapping.getMapping("ahmed")));
        System.out.println(perfectHashingSpaceN.insert(stringMapping.getMapping("ashraf")));
        System.out.println(perfectHashingSpaceN.insert(stringMapping.getMapping("magdy")));
        System.out.println(perfectHashingSpaceN.insert(stringMapping.getMapping("omar")));
        System.out.println(perfectHashingSpaceN.insert(stringMapping.getMapping("hassan")));
        System.out.println(perfectHashingSpaceN.search(stringMapping.getMapping("ahmed")));
        //perfectHashingSpaceN.printTables();
        System.out.println(perfectHashingSpaceN.delete(stringMapping.getMapping("ahmed")));
        System.out.println(perfectHashingSpaceN.search(stringMapping.getMapping("ahmed")));
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
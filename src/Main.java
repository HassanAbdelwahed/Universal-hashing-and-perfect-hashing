import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        //System.out.print("Enter size of dictionary: ");
        //int n = input.nextInt(); // dictionary size
        PerfectHashingSpaceN2 perfectHashingSpaceN2 = new PerfectHashingSpaceN2(8);
        System.out.println(perfectHashingSpaceN2.insertKey(5));
        System.out.println(perfectHashingSpaceN2.insertKey(10));
        System.out.println(perfectHashingSpaceN2.insertKey(20));
        System.out.println(perfectHashingSpaceN2.insertKey(40));
        System.out.println(perfectHashingSpaceN2.insertKey(30));
        System.out.println(perfectHashingSpaceN2.insertKey(10));
        System.out.println(perfectHashingSpaceN2.insertKey(20));
        System.out.println(perfectHashingSpaceN2.insertKey(40));
        System.out.println(perfectHashingSpaceN2.insertKey(30));
        System.out.print("count rehash: ");
        System.out.println(perfectHashingSpaceN2.getCountRehash());
        //System.out.println(perfectHashingSpaceN2.getKey(5));
        System.out.println(perfectHashingSpaceN2.getKey(800));

    }

}
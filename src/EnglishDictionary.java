import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class EnglishDictionary {
    private int hashType;
    PerfectHashingSpaceN hashSpaceN;
    PerfectHashingSpaceN2 hashSpaceN2;
    StringMapping stringMapping = new StringMapping();

    public EnglishDictionary(int hashType){
        this.hashType = hashType;
        if(hashType == 1){
            hashSpaceN = new PerfectHashingSpaceN(2000000);
        }else if(hashType == 2){
            hashSpaceN2 = new PerfectHashingSpaceN2(10000);
        }
    }
    public boolean insert(String word){
        int key = stringMapping.getMapping(word);
        if(hashType == 1){
           return hashSpaceN.insert(key);
        }else{
           return hashSpaceN2.insert(key);
        }
    }
    public boolean delete(String word){
        int key = stringMapping.getMapping(word);
        if(hashType == 1){
            return hashSpaceN.delete(key);
        }else{
            return hashSpaceN2.delete(key);
        }
    }
    public boolean search(String word){
        int key = stringMapping.getMapping(word);
        if(hashType == 1){
            return hashSpaceN.search(key);
        }else{
            return hashSpaceN2.search(key);
        }
    }
    public boolean batchInsert(String fpath) {
        ArrayList<Integer> words = new ArrayList<Integer>();
        int index = 0;
        try (Scanner scanner = new Scanner(Paths.get(fpath))) {
            while (scanner.hasNextLine()) {
                String row = scanner.nextLine();
                int key = stringMapping.getMapping(row);
                words.add(key);
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        int[] words2 = new int[words.size()];
        for(int i = 0; i < words.size(); i++) words2[i] = words.get(i);
        if(hashType == 1) {
            return hashSpaceN.batchInsert(words2);
        }else{
            return hashSpaceN2.batchInsert(words2);
        }
    }

    public boolean batchDelete(String fpath) {
        ArrayList<Integer> words = new ArrayList<Integer>();
        int index = 0;
        try (Scanner scanner = new Scanner(Paths.get(fpath))) {
            while (scanner.hasNextLine()) {
                String row = scanner.nextLine();
                int key = stringMapping.getMapping(row);
                words.add(key);
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        int[] words2 = new int[words.size()];
        for(int i = 0; i < words.size(); i++) words2[i] = words.get(i);
        if(hashType == 1) {
            return hashSpaceN.batchDelete(words2);
        }else{
            return hashSpaceN2.batchDelete( words2);
        }
    }
}

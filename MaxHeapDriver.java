import java.io.File;
import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;;

public class MaxHeapDriver{
    public static void main(String [] args) throws IOException{
        MaxHeap<String> maxHeap = new MaxHeap<>();
        File dataRandom = new File("/Users/andre/Desktop/proj4_code/data/data_random.txt");
        Scanner scan = new Scanner(dataRandom);
        
        while(scan.hasNextLine()){
            maxHeap.add(scan.nextLine());
        }
        scan.close();

        String fileContent = "";
        //add the heap contents to fileContent
        fileContent = maxHeap.toString();

        FileWriter writer = new FileWriter("/Users/andre/Desktop/output.txt");
        writer.write(fileContent);
        writer.close();
        System.out.println("number of swaps: " + maxHeap.getSwaps());
    }
}
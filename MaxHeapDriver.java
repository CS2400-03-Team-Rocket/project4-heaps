import java.io.File;
import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;
import java.io.*;

public class MaxHeapDriver{
    public static void main(String [] args) throws IOException{
        MaxHeap<String> maxHeap = new MaxHeap<>();
        File dataRandom = new File("data/data_random.txt");
        Scanner scan = new Scanner(dataRandom);
        
        while(scan.hasNextLine()){
            maxHeap.add(scan.nextLine());
        }
        scan.close();

        String fileContent = "";
        //add the heap contents to fileContent
        fileContent = maxHeap.toString();

        FileWriter writer = new FileWriter("output.txt");
        writer.write(fileContent);
        writer.close();
        System.out.println("number of swaps: " + maxHeap.getSwaps());


        //CREATING HEAP USING OPTIMAL METHOD
        Scanner scan2 = new Scanner(dataRandom);
        String[] a = new String[100];
        int i = 0;
        while(scan2.hasNextLine()){
            a[i] = scan2.nextLine();
            i++;
        }
        scan2.close();
        MaxHeap<String> maxHeapOptimal = new MaxHeap<String>(a);
        String fileContent2 = maxHeapOptimal.toString();

        FileWriter writer2 = new FileWriter("output2.txt");
        writer2.write(fileContent2);
        writer2.close();
        System.out.println("number of swaps: " + maxHeapOptimal.getSwaps());
    }
}
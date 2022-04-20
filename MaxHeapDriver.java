import java.io.File;
import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;

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


        maxHeapOptimalTest();

        
    }

    public static void maxHeapOptimalTest() throws IOException
    {
        //CREATING HEAP USING OPTIMAL METHOD
        File dataRandom2 = new File("data/data_random.txt");
        Scanner scan2 = new Scanner(dataRandom2);
        String[] a = new String[100];
        int i = 0;
        while(scan2.hasNextLine()){
            a[i] = scan2.nextLine();
            i++;
        }
        scan2.close();
        MaxHeap<String> maxHeapOptimal = new MaxHeap<>(a);
        //String fileContent2 = "";
        //fileContent2 = maxHeapOptimal.toString();
        String fileContent2 = maxHeapOptimal.toString();
        System.out.print(fileContent2);
        FileWriter writer2 = new FileWriter("output2.txt");
        writer2.write(fileContent2);
        writer2.close();
        System.out.println("number of swaps: " + maxHeapOptimal.getSwapsOptimal());
    }
}
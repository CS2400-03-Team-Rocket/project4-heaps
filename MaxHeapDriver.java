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
        fileContent = maxHeap.toString10();

        FileWriter writer = new FileWriter("output.txt");
        writer.write("SEQUENTIAL INSERTIONS\n");
        writer.write("Heap built using sequential insertions: ");
        writer.write(fileContent);

        for(int i = 1; i < 11; i++){
            maxHeap.removeMax();
        }
        fileContent = maxHeap.toString10();

        writer.write("\nNumber of swaps in the heap creation: " + maxHeap.getSwaps());
        writer.write("\nHeap after 10 removals: ");
        writer.write(fileContent);

        writer.close();

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
        MaxHeap<String> maxHeapOptimal = new MaxHeap<String>(a);
        String fileContent2 = maxHeapOptimal.toString10();
        FileWriter writer = new FileWriter("output2.txt");
        writer.write("OPTIMAL METHOD\n");
        writer.write("Heap built using optimal method: ");
        writer.write(fileContent2);
        writer.write("\nNumber of swaps in the heap creation: " + maxHeapOptimal.getSwapsOptimal());
        for(int j = 1; j < 11; j++){
            maxHeapOptimal.removeMax();
        }
        fileContent2 = maxHeapOptimal.toString10();
        writer.write("\nHeap after 10 removals: ");
        writer.write(fileContent2);
        writer.close();
    }
}
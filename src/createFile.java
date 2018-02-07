import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 * A simple creation method to create one relation with 1,000,000 tuples
 */
public class createFile {
    public static void createRecords() throws IOException{
        BufferedWriter writer = new BufferedWriter(new FileWriter("src/Records.txt"));
        for(int i = 0; i < 500000; i++){
            writer.append("12345678");
            writer.append("John      ");
            writer.append("Smiths    ");
            writer.append("      ");
            writer.append("111222999999999");
            writer.append("1455 Maisonneuve West,Montreal, QC, H3G 1M8              ");
            writer.append("\n");
            writer.append("88888888");
            writer.append("Roselyn   ");
            writer.append("Shiri     ");
            writer.append("      ");
            writer.append("222444888888888");
            writer.append("1515 Saint-Catherine West,Montreal, QC, H3G 1M7              ");
            writer.append("\n");
        }
        writer.close();
        System.out.println("Complete");
    }

    public static void main(String args[]) {
        try{
            createRecords();
        }catch(IOException e){

        }
    }

}


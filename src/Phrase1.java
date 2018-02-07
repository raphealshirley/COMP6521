import java.io.*;

public class Phrase1 {
    //Input and output
    BufferedReader br=null;BufferedReader br2=null;
    BufferedReader[] brs = null;
    FileWriter fw = null;
    File outputFile = null;
    RelationFile RF = null;
    int tupleNumTotal = 0;
    int phrase1output = 0;

    int readIO = 0, localreadIO=0;
    int writeIO = 0,localwriteIO=0;

    public Phrase1(RelationFile RF){
        this.RF = RF;
    }

    public void runPhrase1(){
        try{
            br = new BufferedReader(new FileReader("src/Records.txt")); //input file name

            //arrays to store records
            int[] studentID = new int[RF.noOfMMBlock*RF.noOfTuplesPerBlock];
            String[] content = new String[RF.noOfMMBlock*RF.noOfTuplesPerBlock];
            int [] index = new int [RF.noOfMMBlock*40];

            int tupleNum = 0; // use to count tuple number that already read

            RF.blocksWritten = (RF.noOfMMBlock-3)*1000/4*4/5;

            String inputLine;
            while((inputLine = br.readLine()) != null){
                studentID[tupleNum] = Integer.parseInt(inputLine.substring(0,7));
                index[tupleNum] = tupleNum;
                content[tupleNum] = inputLine.substring(7);
                tupleNum++;
                if (tupleNum==RF.noOfMMBlock*RF.noOfTuplesPerBlock) {
                    readIO++;
                    //sort and writeback
                    sortW.sort(studentID,index,tupleNum);
//                    sortW.sort(studentID,tupleNum);
                    outputFile = new File("src/PhraseOutput/outputEMPphase1-"+String.valueOf(writeIO)+".txt");
                    if (!outputFile.exists()) {
                    outputFile.createNewFile();
                }
                fw = new FileWriter(outputFile.getAbsoluteFile(),false);

                for (int i=0; i < tupleNum; i++){

                    fw.write(String.valueOf(studentID[i])+content[index[i]]+"\r");
                    //change to i, before is index[i]
                }

                fw.close();
                writeIO++;
                tupleNumTotal+=tupleNum;
                tupleNum=0;
                }
            }
            //sort and write back
            //if the sublist is not full
            if (tupleNum > 0) {
                readIO++;
                //sort and writeback;
                sortW.sort(studentID,index,tupleNum);
//                sortW.sort(studentID,tupleNum);
                outputFile = new File("src/PhraseOutput/outputEMPphase1-"+String.valueOf(writeIO)+".txt");
                if (!outputFile.exists()) {
                    outputFile.createNewFile();
                }
                fw = new FileWriter(outputFile.getAbsoluteFile(),false);
                for (int i=0;i<tupleNum;i++){
                    fw.write(String.valueOf(studentID[i])+content[index[i]]+"\r");
                }
                fw.close();
                tupleNumTotal+=tupleNum;
                writeIO++;
            }
        br.close();
        phrase1output = writeIO;
        System.out.println("	Phase1: Total record is "+tupleNumTotal+", each IO "+RF.blocksWritten+" blocks "+RF.blocksWritten*40+" tuples, ReadIO = "+readIO+" WriteIO = "+writeIO+", divide into "+phrase1output+" files");
        System.gc();
    }catch (IOException e) {
        e.printStackTrace();
    } finally {
        try {
            if (br != null)br.close();
            if (fw != null)fw.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    }

}

import java.io.IOException;
import java.util.Arrays;

public class testSort {
    public static void main(String[] args) {
//        int [] a = new int[100001];
//        for(int i = 100000; i > 0; i--){
//            a[i] = i;
//        }
//        int [] b = new int[100001];
//        for(int i = 0; i <100000; i++){
//            b[i] = i;
//        }
//        sortW.sort(a,b,a.length);
//        System.out.println(Arrays.toString(a));

//        int [] a = new int[100001];
//        for(int i = 100000; i > 0; i--){
//            a[i] = i;
//        }
//        int [] b = new int[100001];
//        for(int i = 0; i <100000; i++){
//            b[i] = i;
//        }
//        sort.quickSort(a,0,a.length);
//        System.out.println(Arrays.toString(a));
//
//        //create file
//        try{
//            createFile.createRecords();
//        }catch(IOException e){
//
//        }
//
        RelationFile RF = new RelationFile("Records.txt",1000000);
        Phrase1 P = new Phrase1(RF);
        P.runPhrase1();
        System.out.println("success");

    }
}

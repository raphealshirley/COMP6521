public class sort {

    public static void sort(int[] studentID){
        quickSort(studentID,0,studentID.length);

    }

    public static void quickSort(int[] studentID, int left, int right){
        if(right - left <= 1){
            return;
        }
        int pi = partition(studentID,left,right);
        quickSort(studentID,left,pi);
        quickSort(studentID,pi+1,right);
    }

    public static int partition(int[] studentID, int left,int right){
        int pi = studentID[right-1];
        int head = left;
        int tail = right-1;
        int temp= 0;
        while(tail > head){
            if(studentID[tail-1] > pi){
//                studentID[tail] = studentID[tail-1];
                tail--;
            }else if(studentID[head] > pi){
                temp = studentID[tail-1];
                studentID[tail-1] = studentID[head];
                studentID[head] = temp;
            }else{
                head++;
            }
        }
        studentID[tail] = pi;
//        System.out.println("pi is: "+studentID[tail]+"Tail"+tail);
        return tail;
    }

}


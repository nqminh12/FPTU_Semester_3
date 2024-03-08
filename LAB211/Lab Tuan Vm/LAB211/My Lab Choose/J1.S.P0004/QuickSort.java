import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author THAYCACAC
 */
public class QuickSort {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
      //get input array size number
       int n=getInput();
        //generate arr in range
       int []arr=Randomarr(n);
        //display arr before sort
        displayArray(arr,"Unsorted array:" );
        //sort by quick sort
     quickSort(arr,0,arr.length-1);
      //display arr after sort 
     displayArray(arr,"Sorted array: ");
    }

    /**
     *
     * @param arr the array
     */
    public static int []Randomarr(int n){
        Random rd=new Random();
        int []arr=new int [n];
        for (int i = 0; i < n; i++) {
            arr[i]=rd.nextInt(n);
        }
        return arr;
    }
    public static int getInput(){
          Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of array:");
        int n;
        while(true){
            try{
               n=Integer.parseInt(sc.nextLine());
               if(n<=0)
                   throw new NumberFormatException();
               break;
            }catch(NumberFormatException ex){
                System.out.println("Integer Number only!Enter integer number");
                
            }
        }
        return n;
    }
    public static void displayArray(int[] arr,String mess) {
        System.out.println(mess);
        System.out.print("[");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            if (i < arr.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.print("]");
    }

    int partition(int arr[], int left, int right) {
        int i = left, j = right;
        int pivot = arr[(left + right) / 2];

        while (i <= j) {
            while (arr[i] < pivot) {
                i++;
            }
            while (arr[j] > pivot) {
                j--;
            }
            if (i <= j) {
               int tmp = arr[i];
                arr[i] = arr[j];
                arr[j] = tmp;
                i++;
                j--;
            }
        };
        return i;
    }

   public static void quickSort(int arr[], int left, int right) {
        int pivot=arr[(left+right)/2];
        if (left < pivot - 1) {
            quickSort(arr, left, pivot - 1);
        }
        if (pivot < right) {
            quickSort(arr, pivot, right);
        }
    }
}

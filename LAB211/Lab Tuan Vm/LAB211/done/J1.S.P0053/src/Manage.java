
public class Manage {

    static void displayMenu() {
        System.out.println("1. Input Element");
        System.out.println("2. Sort Ascending");
        System.out.println("3. Sort Desceding");
        System.out.println("4. Exit.");
    }

    static int[] inputElement() {
        System.out.println("----- Input Element -----");
        System.out.println("Input Length Of Arrays");
        int length_array = Input.checkIn("Enter Number: ");
        int[] arrayNeedSort = new int[length_array];
        //access loop from first to last element in array
        for (int i = 0; i < arrayNeedSort.length; i++) {
            arrayNeedSort[i] = Input.checkIn("Enter Number " + (i + 1) + ": ");
        }
        
        return arrayNeedSort;
    }

    static void sortAscending(int[] arrayNeedSort) {
        /*Loop use to accessed from the first to last element of array, 
        after each loop, one element is sorted*/
        for (int i = 0; i < arrayNeedSort.length; i++) {
            /*Loop use to accessed first unsorted element to the element 
            stand before the last unsorted element*/
            for (int j = 0; j < arrayNeedSort.length - i - 1; j++) {
                //compare each pair adjacent elements
                if (arrayNeedSort[j] > arrayNeedSort[j + 1]) {
                    int temp = arrayNeedSort[j];
                    arrayNeedSort[j] = arrayNeedSort[j + 1];
                    arrayNeedSort[j + 1] = temp;
                }
            }
        }
        
        System.out.println("----- Ascending -----");
        //access loop from first to last element in array
        for (int i = 0; i < arrayNeedSort.length; i++) {
            System.out.print("[" + arrayNeedSort[i] + "]");
            if (i < arrayNeedSort.length - 1) {
                System.out.print("->");
            }
        }
        System.out.println("");
        
    }

    static void sortDescending(int[] arrayNeedSort) {
        /*Loop use to accessed from the first to last element of array, 
        after each loop, one element is sorted*/
        for (int i = 0; i < arrayNeedSort.length; i++) {
            /*Loop use to accessed first unsorted element to the element 
            stand before the last unsorted element*/
            for (int j = 0; j < arrayNeedSort.length - i - 1; j++) {
                //compare each pair adjacent elements
                if (arrayNeedSort[j] < arrayNeedSort[j + 1]) {
                    int temp = arrayNeedSort[j];
                    arrayNeedSort[j] = arrayNeedSort[j + 1];
                    arrayNeedSort[j + 1] = temp;
                }
            }
        }
        
        System.out.println("----- Descending -----");
        //access loop from first to last element in array
        for (int i = 0; i < arrayNeedSort.length; i++) {
            System.out.print("[" + arrayNeedSort[i] + "]");
            if (i < arrayNeedSort.length - 1) {
                System.out.print("<-");
            }
        }
        System.out.println("");
    }

}

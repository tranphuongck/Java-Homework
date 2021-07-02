import java.util.Arrays;
import java.util.Random;

public class Bubblesort {
    public static void main(String[] args){
        int[] example = {1,2,3,4,5};
        System.out.println(arrayToString(example));
        int[] randArr1 = randomArray(10);
        System.out.println(arrayToString(randArr1));
        int[] randArr2 = randomArray(20);
        System.out.println(arrayToString(randArr2));
        int[] randArr3 = randomArray(30);
        System.out.println(arrayToString(randArr3));
        bubbleSort(randArr1);
        System.out.println(arrayToString(randArr1));
    }
    //Aufgabe 1a
    static String arrayToString(int[] arr){       
        String str = "[";
        for (int i = 0; i < arr.length; i++) {
            str += arr[i];
            if (i < arr.length - 1) str += ", ";        
        }
        str += "]";
        return str;
    }
    //Aufgabe 1b
    static int[] randomArray(int n){
        Random rand = new Random();
        int[] arr = new int[n];
        for (int i = 0; i < arr.length; i++){
            arr[i] = rand.nextInt(2);
        }
        return arr;
    }
    //Aufgabe 1c
    static void bubbleSort(int[] arr){
        int l = arr.length;
        for (int i = 0; i < l - 1; i++){
            for (int j = 0; j < l - i - 1; j++){
                if (arr[j] < arr[j + 1]){
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }
}        

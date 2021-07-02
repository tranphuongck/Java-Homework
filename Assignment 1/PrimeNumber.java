import java.util.Random;

public class PrimeNumber {
    public static void main(String[] args){
        int[] example = {1,2,3,4,5};
        System.out.println(arrayToString(example));
        int[] array1 = fillArray(10);  
        System.out.println(arrayToString(array1));
        int[] array2 = fillArray(20);  
        filterArray(array2, 0);
        System.out.println(arrayToString(array2));
        filterArray(array2, 1);
        System.out.println(arrayToString(array2));
        primes(20);
        //Desired output: [2, 3, 5, 7, 11, 13, 17, 19]
        primes(100);
        //Desired output: [2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97]
    }
    //Aufgabe 2a
    static String arrayToString(int[] arr){       
        String str = "[";
        for (int i = 0; i < arr.length; i++){
            str += arr[i];

            if (i < arr.length - 1) {
                str += ", ";
            }
        }
        str += "]";
        return str;
    }
    //Aufgabe 2b
    //Create an array with increasing values from 2 to n
    static int[] fillArray(int n){
        int[] arr = new int[n - 1];
        for (int i = 0; i < arr.length; i++){
            if (i == 0) {
                arr[i] = 2;
            }
            else {
                arr[i] = arr[i - 1] + 1;
            }
        }
        return arr;
    }
    //Aufgabe 2c
    //All multiples turn to -1
    static void filterArray(int[] arr, int index){
        for (int i = 0; i < arr.length; i++){
            if (i > index){
                while (arr[i] % arr[index] == 0){
                    arr[i] = -1;
                }
            }           
        }
    }
    //Aufgabe 2d
    //Print out the prime numbers  
    static void primes(int n){
        int[] arr = fillArray(n);
        filterArray(arr, 0);
        filterArray(arr, 1);
        filterArray(arr, 3);
        filterArray(arr, 5);
        filterArray(arr, 9);
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != -1) count++;
        }
        int[] result = new int[count]; //Create new array with the length of prime numbers

        int j = 0;
        for (int i = 0; i < arr.length; i++) { //Copy all prime numbers to new array
            if (arr[i] != -1) {
                result[j] = arr[i];
                j++;
            }
        }
        System.out.println(arrayToString(result));
    }    
}
public class Debug { //ckass incorrect, lacks public
    // Method prints all numbers in an array that are even.
    static void printEvenNumbers(int[] numbers) {//1printEvenNumbers wrong function name
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] % 2 != 1) { //\% wrong expression, numbers[i] % 2 == 1 only output odd numbers
                System.out.println(numbers[i]);
            }
        }
    }
    public static void main(String[] args){
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        //output should be as follows:
        //2
        //4
        //6
        //8
        Debug.printEvenNumbers(arr);
    }
}

/*Debug.java:1: error: class, interface, or enum expected
ckass Debug {
^
Debug.java:4: error: class, interface, or enum expected
        for (int i = 0; i < numbers.length; ++i) {
                        ^
Debug.java:4: error: class, interface, or enum expected
        for (int i = 0; i < numbers.length; ++i) {
                                            ^
Debug.java:5: error: illegal character: '\'
            if (numbers[i] \% 2 == 1) {s
                           ^
Debug.java:7: error: class, interface, or enum expected
            }
            ^
Debug.java:16: error: class, interface, or enum expected
    Debug.printEvenNumbers(arr);
    ^
Debug.java:17: error: class, interface, or enum expected
}
^
7 errors*/
import java.util.Random;

public class CountSort {

    public static void main(String[] args) {
        int[] arr = new int[30];

        Random random = new Random();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(10);
        }

        for (int j : arr) {
            System.out.print(j + " ");
        }

        System.out.println();

        countSort(arr, 10);

        for (int j : arr) {
            System.out.print(j + " ");
        }


    }

    public static void countSort(int[] array, int m) {
        int[] output = new int[array.length];

        int[] key = new int[m];

        for (int i = 0; i < array.length; i++) {
            key[array[i]]++;
        }

        for (int i = 1; i < key.length; i++) {
            key[i] += key[i - 1];
        }

        for (int i = array.length - 1; i >= 0; i--) {
            output[key[array[i]] - 1] = array[i];
            key[array[i]]--;
        }


        for (int i = 0; i < array.length; i++) {
            array[i] = output[i];
        }
    }

}
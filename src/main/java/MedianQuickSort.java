import java.util.Arrays;
import java.util.Random;

public class MedianQuickSort {

    public static void main(String[] args) {

        int[] arr = new int[10];

        Random random = new Random();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(100);
        }

//       int[] arr = {52, 51, 14, 69, 78, 52, 52, 56, 4, 71};

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();

        medianQuickSort(arr);

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }


    public static int partition(int[] array, int left, int right) {
        int i = left + 1;
        int j = right - 1;

        int value = array[right];

        while (true) {
            while (array[i] < value) {
                i++;
            }
            while (array[j] >= value) {
                j--;
            }
            if (i < j) {

                swap(array, i, j);
            } else {
                break;
            }
        }


        swap(array, i, right);

        return i;
    }


    public static void median(int[] array, int left, int right) {
        int med = left + (right - left) / 2;

        if (array[left] > array[med]) {

            swap(array, left, med);
        }

        if (array[left] > array[right]) {

            swap(array, left, right);
        }

        if (array[med] > array[right]) {

            swap(array, med, right);
        }

    }

    public static void swap(int[] array, int i, int j) {
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }

    public static void medianQuickSort(int[] array) {
        medianQuickSort(array, 0, array.length - 1);
    }

    private static void medianQuickSort(int[] array, int left, int right) {
        if (left < right) {

            if (right - left == 1) {
                if (array[left] > array[right]) {

                    swap(array, left, right);
                }
            } else {
                median(array, left, right);
                if ((right - left) != 2) {
                    int q = partition(array, left, right);
                    medianQuickSort(array, left, q - 1);
                    medianQuickSort(array, q + 1, right);
                }
            }

        }

    }


}

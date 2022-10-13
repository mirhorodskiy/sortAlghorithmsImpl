public class BucketSort {

    public static void main(String[] args) {
        double[] arr = {0.12, 0.75, 0.28, 0.05, 0.056, 0.67, 0.55, 0.21, 0.2};
        bucketSort(arr);

        for (double v : arr) {
            System.out.print(v + " ");
        }
    }


    private static Bucket[] buckets;

    public static void bucketSort(double[] array) {
        insert(array);

        System.out.println("Inserted data: ");
        show(buckets);

        for (int i = 0; i < buckets.length; i++) {
            if (buckets[i] != null)
                buckets[i] = sortList(buckets[i]);
        }

        System.out.println("\nSorted buckets: ");
        show(buckets);

        move(buckets, array);
    }

    private static void insert(double[] array) {
        buckets = new Bucket[array.length];

        for (int i = 0; i < array.length; i++) {
            if (buckets[(int) (10 * array[i])] == null)
                buckets[(int) (10 * array[i])] = new Bucket(array[i], null);
            else {
                add(array[i]);
            }
        }

    }

    private static void add(double data) {
        Bucket current = buckets[(int) (10 * data)];

        while (current.next != null) {
            current = current.next;
        }

        current.next = new Bucket(data, null);
    }

    private static Bucket sortList(Bucket first) {
        Bucket current = first;
        int count = 0;

        while (current != null) {
            count++;
            current = current.next;
        }

        if (count == 1) {
            return first;
        }

        for (int i = 0; i < count; i++) {
            first = swap(first);
        }

        return first;
    }

    private static void move(Bucket[] buckets, double[] array) {
        int j = 0;
        Bucket current;

        for (int i = 0; i < buckets.length; i++) {
            current = buckets[i];
            while (current != null) {
                array[j++] = current.data;
                current = current.next;
            }
        }

    }

    private static Bucket swap(Bucket bucket) {

        if (bucket.next != null) {
            bucket.next = swap(bucket.next);
        } else {
            return bucket;
        }

        if (bucket.data > bucket.next.data) {
            Bucket buffer = bucket.next;
            bucket.next = bucket.next.next;
            buffer.next = bucket;
            return buffer;
        } else {
            return bucket;
        }

    }


    public static void show(Bucket[] buckets) {

        for (int i = 0; i < buckets.length; i++) {
            System.out.print(i + ": ");
            if (buckets[i] == null) {
                System.out.print("empty");
            } else {
                Bucket bucket = buckets[i];
                while (bucket != null) {
                    System.out.print(bucket.data + " ");
                    bucket = bucket.next;
                }
            }
            System.out.println();
        }

    }

    private static class Bucket {

        double data;
        Bucket next;

        public Bucket(double data, Bucket next) {
            this.data = data;
            this.next = next;
        }

    }
}

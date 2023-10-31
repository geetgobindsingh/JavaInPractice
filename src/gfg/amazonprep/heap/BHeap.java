package gfg.amazonprep.heap;

public class BHeap {
    public static void main(String[] args) {
        MinHeap minHeap = new MinHeap(5);
        minHeap.insertKey(4);
        minHeap.insertKey(2);
        System.out.print(minHeap.extractMin());
        minHeap.insertKey(6);
        minHeap.deleteKey(0);
        System.out.print(minHeap.extractMin());
        System.out.print(minHeap.extractMin());
//        minHeap.insertKey(8);
//        minHeap.insertKey(9);
//        minHeap.deleteKey(1);
//        System.out.print(minHeap.extractMin());
//        System.out.print(minHeap.extractMin());
    }

    public static class MinHeap {
        int[] harr;
        int capacity;
        int heap_size;

        MinHeap(int cap) {
            heap_size = 0;
            capacity = cap;
            harr = new int[cap];
        }

        int parent(int i) {
            return (i - 1) / 2;
        }

        int left(int i) {
            return (2 * i + 1);
        }

        int right(int i) {
            return (2 * i + 2);
        }

        int extractMin() {
            if (heap_size <= 0) {
                return -1;
            }
            if (heap_size == 1) {
                heap_size--;
                return harr[0];
            }

            // Store the minimum value, and remove it from heap
            int root = harr[0];
            harr[0] = harr[heap_size - 1];
            heap_size--;
            MinHeapify(0);

            return root;
        }

        void insertKey(int k) {
            if (heap_size == capacity) {
                return;
            }

            heap_size++;
            int i = heap_size - 1;
            harr[i] = k;

            // Fix the min heap property if it is violated
            while (i != 0 && harr[parent(i)] > harr[i]) {
                int temp = harr[i];
                harr[i] = harr[parent(i)];
                harr[parent(i)] = temp;
                i = parent(i);
            }
        }

        void deleteKey(int i) {
            if (i < 0 || i >= heap_size) {
                return;
            }
            decreaseKey(i, 0);
            extractMin();
        }



        // Decrease key operation, helps in deleting the element
        void decreaseKey(int i, int new_val) {
            harr[i] = new_val;
            while (i != 0 && harr[parent(i)] > harr[i] && i < heap_size) {
                int temp = harr[i];
                harr[i] = harr[parent(i)];
                harr[parent(i)] = temp;
                i = parent(i);
            }
        }

        /* You may call below MinHeapify function in
          above codes. Please do not delete this code
          if you are not writing your own MinHeapify */
        void MinHeapify(int i) {
            int l = left(i);
            int r = right(i);
            int smallest = i;
            if (l < heap_size && harr[l] < harr[i]) smallest = l;
            if (r < heap_size && harr[r] < harr[smallest]) smallest = r;
            if (smallest != i) {
                int temp = harr[i];
                harr[i] = harr[smallest];
                harr[smallest] = temp;
                MinHeapify(smallest);
            }
        }

        void print() {
            System.out.print("\n");
            for (int i : harr) {
                System.out.print(i + " ");
            }
            System.out.print("\n");
        }
    }

}

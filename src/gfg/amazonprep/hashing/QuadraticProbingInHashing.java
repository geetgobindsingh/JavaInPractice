package gfg.amazonprep.hashing;

public class QuadraticProbingInHashing {
    public static void main(String[] args) {

    }

    static void quadraticProbing(int[] hash_table, int hash_size, int arr[], int N) {
        for (int i = 0; i < hash_size; i++) {
            hash_table[i] = -1;
        }

        for (int i = 0; i < N; i++) {
            if (hash_table[arr[i] % hash_size] == -1) {
                hash_table[arr[i] % hash_size] = arr[i];
            } else {
                for (int k = 1; k < hash_size; k++) {
                    int key = (arr[i] + (k * k)) % hash_size;
                    if (hash_table[key] == -1) {
                        hash_table[key] = arr[i];
                        break;
                    }
                }
            }
        }
    }
}

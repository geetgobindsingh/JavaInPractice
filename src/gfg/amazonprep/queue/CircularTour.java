package gfg.amazonprep.queue;

public class CircularTour {
    public static void main(String[] args) {
        int petrol[] = new int[]{6, 4, 4};
        int distance[] = new int[]{5, 6, 5};
        System.out.println(tour(petrol, distance));
    }

    public static int tour(int petrol[], int distance[]) {
        int result = -1;
        int petrolLeft = 0;
        boolean[] visited = new boolean[petrol.length];
        int i = 0;
        while (i < petrol.length) {
            if (!visited[i]) {
                visited[i] = true;
                petrolLeft = petrolLeft + petrol[i] - distance[i];

                if (petrolLeft < 0) {
                    petrolLeft = 0;
                    result = -1;
                } else {
                    if (result == -1) {
                        result = i;
                    }
                }
            } else {
                if (i == result) {
                    return result;
                }
                petrolLeft = petrolLeft + petrol[i] - distance[i];
                if (petrolLeft < 0) {
                    return -1;
                }
            }
            i++;
            i = i % petrol.length;
        }
        return result;
    }
}

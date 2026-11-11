public class Question12 {
    public static void main(String[] args) {
        int[] numbers = { 1, 3, 5, 7, 9, 12 };
        int target = 16;
        boolean found = false;

        int left = 0;
        int right = numbers.length - 1;

        while (left < right) {
            int sum = numbers[left] + numbers[right];
            if (sum > target) {
                right--;
            } else if (sum < target) {
                left++;
            } else {
                System.out.println("Pair found: " + numbers[left] + "," + numbers[right]);
                found = true;
                break;
            }

        }

        if (!found) {
            System.out.println("No pair found");
        }

    }
}

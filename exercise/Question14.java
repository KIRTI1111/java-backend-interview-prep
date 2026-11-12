public class Question14 {

    public static void main(String[] args) {
        int[] amounts = { 100, 200, 300, 400, 600, 800 };
        int target = 1000;

        int left = 0;
        int right = amounts.length - 1;
        boolean found = false;

        while (left < right) {
            int sum = amounts[left] + amounts[right];
            if (sum < target) {
                left++;
            } else if (sum > target) {
                right--;
            } else {
                System.out.println("Pair found: " + amounts[left] + ", " + amounts[right]);
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("No pair found");
        }
    }

}

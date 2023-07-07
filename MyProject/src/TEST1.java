import java.util.Arrays;

public class TEST1 {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        char[] chars = new char[nums.length];

        for (int i = 0; i < nums.length; i++) {
            chars[i] = (char) (nums[i] + 65);
        }

        // Printing the resulting character array
        System.out.println(Arrays.toString(chars));
    }
}

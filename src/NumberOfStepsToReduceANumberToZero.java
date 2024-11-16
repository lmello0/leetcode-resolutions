public class NumberOfStepsToReduceANumberToZero {
    public static int numberOfSteps(int num) {
        int steps = 0;

        while (num > 0) {
            if ((num & 1) == 1) {
                num--;
            } else {
                num = num >> 1;
            }

            steps++;
        }

        return steps;
    }
}

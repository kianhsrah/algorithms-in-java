package rosettaCode.bdayProblem;

import java.util.Random;
import java.util.Arrays;

public class birthdayProblem {

    static double equalBirthdays(int nSharers, int groupSize, int nRepetitions) {
        Random rand = new Random(2982); // seed for reproducibility

        int eq = 0; // number of repetitions with equal birthdays

        for (int i = 0; i < nRepetitions; i++) { // simulate nRepetitions
            int[] group = new int[365]; // 365 days in a year
            for (int j = 0; j < groupSize; j++) // simulate groupSize people
                group[rand.nextInt(group.length)]++; // assign a random birthday
            eq += Arrays.stream(group).anyMatch(c -> c >= nSharers) ? 1 : 0; // check for equal birthdays
        }

        return (eq * 100.0) / nRepetitions; // return the percentage of repetitions with equal birthdays
    }

    public static void main(String[] a) {

        int groupEst = 2; // initial group size estimate

        for (int sharers = 2; sharers < 6; sharers++) { // simulate 2 to 5 sharers
            int groupSize = groupEst + 1; // initial group size
            while (equalBirthdays(sharers, groupSize, 100) < 50.0) // simulate 100 repetitions
                groupSize++; // increase group size until 50% probability

            int inf = (int) (groupSize - (groupSize - groupEst) / 4.0); // lower bound for group size
            for (int gs = inf; gs < groupSize + 999; gs++) { // simulate 1000 group sizes
                double eq = equalBirthdays(sharers, groupSize, 250); // simulate 250 repetitions
                if (eq > 50.0) { // check for 50% probability
                    groupSize = gs; // update group size
                    break; // exit loop
                }
            }

            for (int gs = groupSize - 1; gs < groupSize + 999; gs++) { // simulate 1000 group sizes
                double eq = equalBirthdays(sharers, gs, 50_000); // simulate 50,000 repetitions
                if (eq > 50.0) { // check for 50% probability
                    groupEst = gs; // update group size estimate
                    System.out.printf("%d independent people in a group of "
                            + "%s share a common birthday. (%5.1f)%n",
                            sharers, gs, eq);
                    break;
                }
            }
        }
    }
}

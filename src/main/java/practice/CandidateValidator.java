package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MIN_AGE = 35;
    private static final int REQUIRED_YEARS = 10;
    private static final String REQUIRED_CITIZENSHIP = "Ukrainian";

    @Override
    public boolean test(Candidate c) {
        String[] years = c.getPeriodsInUkr().split("-");
        int yearsInUkraine = Integer.parseInt(years[1]) - Integer.parseInt(years[0]);

        return c.getAge() >= MIN_AGE
                && c.isAllowedToVote()
                && c.getNationality().equals(REQUIRED_CITIZENSHIP)
                && yearsInUkraine >= REQUIRED_YEARS;
    }
}

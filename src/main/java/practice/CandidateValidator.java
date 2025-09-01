package practice;

import model.Candidate;
import java.util.function.Predicate;

public class CandidateValidator implements Predicate<Candidate> {

    @Override
    public boolean test(Candidate c) {
        String[] years = c.getPeriodsInUkr().split("-");
        int yearsInUkraine = Integer.parseInt(years[1]) - Integer.parseInt(years[0]);

        return c.getAge() >= 35
                && c.isAllowedToVote()
                && c.getNationality().equals("Ukrainian")
                && yearsInUkraine >= 10;
    }
}

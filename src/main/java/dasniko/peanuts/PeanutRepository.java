package dasniko.peanuts;

import javax.enterprise.context.ApplicationScoped;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Niko Köbler, https://www.n-k.de, @dasniko
 */
@ApplicationScoped
public class PeanutRepository {

    static List<Peanut> peanuts = List.of(
            new Peanut("charlie", "Charlie", "Brown", "charlie.brown@peanuts.com", "1948-05-30", "male", List.of("peanuts"), List.of("child")),
            new Peanut("snoopy", "Snoopy", "", "snoopy@peanuts.com", "1950-12-04", "male", List.of("peanuts"), List.of("animal")),
            new Peanut("schroeder", "", "Schroeder", "schroeder@peanuts.com", "1951-05-31", "male", List.of("peanuts"), List.of("child")),
            new Peanut("lucy", "Lucy", "van Pelt", "lucy.vanpelt@peanuts.com", "1952-03-03", "female", List.of("peanuts"), List.of("child")),
            new Peanut("linus", "Linus", "van Pelt", "linus.vanpelt@peanuts.com", "1952-09-19", "male", List.of("peanuts"), List.of("child")),
            new Peanut("sally", "Sally", "Brown", "sally.brown@peanuts.com", "1959-08-23", "female", List.of("peanuts"), List.of("child")),
            new Peanut("patty", "Patricia 'Pepermint Patty'", "Reichardt", "peppermintpatty@peanuts.com", "1966-08-22", "female", List.of("peanuts"), List.of("child")),
            new Peanut("woodstock", "Woodstock", "", "woodstock@peanuts.com", "1966-03-04", "male", List.of("peanuts"), List.of("animal")),
            new Peanut("marcie", "Marcie", "", "marcie@peanuts.com", "1971-07-20", "female", List.of("peanuts"), List.of("child")),
            new Peanut("rerun", "Rerun", "van Pelt", "rerun.vanpelt@peanuts.com", "1973-03-26", "male", List.of("peanuts"), List.of("child"))
    );

    List<Peanut> searchPeanuts(String search, int first, int max) {
        return peanuts.stream()
                .filter(p -> search == null || search.isBlank() ||
                        p.getUsername().toLowerCase().contains(search.toLowerCase()) ||
                        p.getFirstName().toLowerCase().contains(search.toLowerCase()) ||
                        p.getLastName().toLowerCase().contains(search.toLowerCase()) ||
                        p.getEmail().toLowerCase().contains(search.toLowerCase()))
                .sorted(Comparator.comparing(p -> p.getLastName() + p.getFirstName()))
                .skip(first)
                .limit(max)
                .collect(Collectors.toList());
    }

    Peanut getPeanutByUsername(String username) {
        return peanuts.stream().filter(p -> p.getUsername().equalsIgnoreCase(username)).findFirst().orElse(null);
    }

    Peanut getPeanutByEmail(String email) {
        return peanuts.stream().filter(p -> p.getEmail().equalsIgnoreCase(email)).findFirst().orElse(null);
    }

    Integer getCount() {
        return peanuts.size();
    }
}

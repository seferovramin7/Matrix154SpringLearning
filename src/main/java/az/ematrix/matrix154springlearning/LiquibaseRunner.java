package az.ematrix.matrix154springlearning;

import liquibase.Liquibase;
import liquibase.exception.LiquibaseException;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class LiquibaseRunner implements CommandLineRunner {

    private final Liquibase liquibase;


    @Override
    public void run(String... args) throws LiquibaseException {
        liquibase.update("");
    }
}


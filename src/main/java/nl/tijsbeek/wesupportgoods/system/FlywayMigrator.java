package nl.tijsbeek.wesupportgoods.system;

import org.flywaydb.core.Flyway;
import org.springframework.beans.factory.annotation.Autowired;

public class FlywayMigrator {

    Flyway flyway;

    @Autowired
    public FlywayMigrator(Flyway flyway) {
        this.flyway = flyway;
    }
}

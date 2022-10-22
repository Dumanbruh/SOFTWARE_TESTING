package common;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
        "file:${user.dir}/src/test/resources/config.properties"
})
public interface ConfigProperties extends Config {
    String browser();

    String baseUrl();

    String username();

    String password();

    String databaseUrl();

    String databaseUser();

    String databasePassword();


}

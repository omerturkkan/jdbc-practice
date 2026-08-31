package manage_queries;

public class LoantechQueries {
    private LoantechQueries() { }

    public static final String GET_ALL_USERNAMES =
            "SELECT username FROM users";

    public static final String GET_ALL_FIRSTNAMES =
            "SELECT firstname FROM users";

    public static final String GET_ALL_EMAILS =
            "SELECT email FROM subscribers";
}

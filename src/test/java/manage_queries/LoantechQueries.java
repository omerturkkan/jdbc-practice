package manage_queries;

public final class LoantechQueries {
    private LoantechQueries() { }

    public static final String GET_ALL_USERNAMES =
            "SELECT username FROM users";

    public static final String GET_ALL_FIRSTNAMES =
            "SELECT firstname FROM users";

    public static final String GET_ALL_EMAILS =
            "SELECT email FROM subscribers";

    public static final String GET_ALL_DEPOSIT_AMOUNTS =
            "SELECT amount FROM deposits";

    public static final String GET_ALL_CRON_SCHEDULE_NAMES =
            "SELECT name FROM cron_schedules";

    public static final String GET_USERNAME_BY_ID_FROM_SAUCEDEMO =
            "SELECT username FROM saucedemo WHERE id = 1006";

    public static final String GET_EMAIL_BY_ID_FROM_SUBSCRIBERS =
            "SELECT email FROM subscribers WHERE id = 20";

    public static String query(String column, String table) {
        return "SELECT " + column + " FROM " + table;
    }

    public static String tableQuery(String tableName) {
        return "SELECT * FROM " + tableName;
    }
}
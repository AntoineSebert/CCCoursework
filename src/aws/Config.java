package aws;

/*
 * Hold the database configuration
 * @author	Antoine/Anthony Sébert
 */
public class Config {
	/**
	 * The region where is located the database - 'local' for local database
	 */
	public static final String REGION = "local",
	/**
	 * The webapp URL
	 */
		LOCAL_ENDPOINT = "http://localhost:8000",
	/**
	 * The DynamoBD table name
	 */
		TABLE_NAME = "1705851_users";
}
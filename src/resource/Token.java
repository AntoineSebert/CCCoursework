package resource;
import java.util.Calendar;
import java.util.TimeZone;
import java.util.UUID;

public class Token {
	/* ATTRIBUTES */
		private long id,
			timestamp;
		private String user_id;
	/* MEMBERS */
		// constructor
			public Token(String _user_id) {
				id = UUID.randomUUID().getLeastSignificantBits();
				timestamp = Calendar.getInstance(TimeZone.getTimeZone("GMT")).getTimeInMillis();
				user_id = _user_id;
			}
		// getters
			public long get_id() { return id; }
			public long get_timestamp() { return timestamp; }
			public String get_user_id() { return user_id; }
}
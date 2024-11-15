package clase01;

import java.sql.SQLException;

public class ActorServiceException extends Exception {

	public ActorServiceException(String string) {
	}

	public ActorServiceException(String string, SQLException e) {
	}

}

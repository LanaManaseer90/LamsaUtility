import java.io.Serializable;

public class EmployeeSession implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	String username;
	transient String password;

}

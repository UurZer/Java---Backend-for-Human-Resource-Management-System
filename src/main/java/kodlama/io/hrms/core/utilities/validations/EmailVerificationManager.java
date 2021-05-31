package kodlama.io.hrms.core.utilities.validations;

public class EmailVerificationManager<T> implements EmailVerificationService<T> {

	@Override
	public boolean checkIfRealEmail(T entity) {
		return true;
	}

}

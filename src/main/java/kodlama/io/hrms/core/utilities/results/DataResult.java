package kodlama.io.hrms.core.utilities.results;

public class DataResult<T> extends Result{

	private T data;
	public DataResult(boolean success, String message,T data) {
		super(success, message);
		this.data=data;
	}

	public DataResult(boolean success,T data) {
		super(success);
		this.data=data;
	}
	
	public T getData() {
		return this.data;
	} {

}
}

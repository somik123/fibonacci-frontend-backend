package sg.nus.iss.somik.api;

public class FibRequest {
	private Integer elements;

	public FibRequest() {
		super();
		// TODO Auto-generated constructor stub
	}

	public FibRequest(Integer elements) {
		super();
		this.elements = elements;
	}

	public Integer getElements() {
		return elements;
	}

	public void setElements(Integer elements) {
		this.elements = elements;
	}
}

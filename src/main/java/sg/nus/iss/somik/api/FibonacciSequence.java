package sg.nus.iss.somik.api;

import java.util.ArrayList;
import java.util.List;

public class FibonacciSequence {
	private List<String> fibonacci;
	private List<String> sorted;

	public FibonacciSequence() {
		super();
		// TODO Auto-generated constructor stub
		this.fibonacci = new ArrayList<String>();
		this.sorted = new ArrayList<String>();
	}

	public FibonacciSequence(List<String> fibonacci, List<String> sorted) {
		super();
		this.fibonacci = fibonacci;
		this.sorted = sorted;
	}

	public List<String> getFibonacci() {
		return fibonacci;
	}

	public void setFibonacci(List<String> fibonacci) {
		this.fibonacci = fibonacci;
	}

	public List<String> getSorted() {
		return sorted;
	}

	public void setSorted(List<String> sorted) {
		this.sorted = sorted;
	}
}

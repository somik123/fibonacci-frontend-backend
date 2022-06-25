package sg.nus.iss.somik.api;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class FibonacciSequence {
	private List<BigInteger> fibonacci;
	private List<BigInteger> sorted;
	
	public FibonacciSequence() {
		super();
		// TODO Auto-generated constructor stub
		this.fibonacci = new ArrayList<BigInteger>();
		this.sorted = new ArrayList<BigInteger>();
	}
	
	public FibonacciSequence(List<BigInteger> fibonacci, List<BigInteger> sorted) {
		super();
		this.fibonacci = fibonacci;
		this.sorted = sorted;
	}
	
	public List<BigInteger> getFibonacci() {
		return fibonacci;
	}
	public void setFibonacci(List<BigInteger> fibonacci) {
		this.fibonacci = fibonacci;
	}
	public List<BigInteger> getSorted() {
		return sorted;
	}
	public void setSorted(List<BigInteger> sorted) {
		this.sorted = sorted;
	}
}

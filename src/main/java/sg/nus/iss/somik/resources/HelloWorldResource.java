package sg.nus.iss.somik.resources;

import java.io.File;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import com.codahale.metrics.annotation.Timed;

import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import sg.nus.iss.somik.api.FibRequest;
import sg.nus.iss.somik.api.FibonacciSequence;

@Path("/fibonacci")
@Produces(MediaType.APPLICATION_JSON)
public class HelloWorldResource {

    public HelloWorldResource() {
    }

    @POST
    @Timed
    public FibonacciSequence sayHello(FibRequest fibReq) {
        
    	try {
			if (fibReq == null) {
				//System.out.println("ERROR: Received empty input.");
				return new FibonacciSequence();
			}

			int num = fibReq.getElements();
			if (num < 1 || num > 100) {
				//System.out.println("Number out of range.");
				return new FibonacciSequence();
			}

			// Data for output
			List<BigInteger> fibonacci = new ArrayList<>();
			List<BigInteger> sorted = new ArrayList<>();

			// Temp data for sorting
			List<BigInteger> evenNums = new ArrayList<>();
			List<BigInteger> oddNums = new ArrayList<>();

			// Read the numbers from file (windows)
			File myObj = new File("data.txt");
			if (!myObj.exists() || myObj.isDirectory()) {
				// Read the numbers from file (linux)
				myObj = new File("/usr/app/data.txt");
				if (!myObj.exists() || myObj.isDirectory()) {
					//System.out.println("Data file not found either location");
					return new FibonacciSequence();
				}
			}
			Scanner myReader = new Scanner(myObj);

			int i = 0;
			// Only read until the number provided
			while (myReader.hasNextLine() && i < num) {
				String data = myReader.nextLine();

				String[] parts = data.split(":");
				BigInteger fibonacciNumber = new BigInteger(parts[1]);

				// Add number to output sequence
				fibonacci.add(fibonacciNumber);

				// Seperate even and odd numbers
				if (fibonacciNumber.mod(BigInteger.TWO) == BigInteger.ZERO)
					evenNums.add(fibonacciNumber);
				else
					oddNums.add(fibonacciNumber);
				i++;
			}
			myReader.close();

			// Reserve sort
			Collections.sort(evenNums, Collections.reverseOrder());
			Collections.sort(oddNums, Collections.reverseOrder());

			// Combine with even first, then odd
			sorted.addAll(evenNums);
			sorted.addAll(oddNums);

			FibonacciSequence reply = new FibonacciSequence(fibonacci, sorted);
			//System.out.println(reply);

			return reply;

		} catch (Exception e) {
			//System.out.println("ERROR: Unknown exception occured.");
			return new FibonacciSequence();
		}
    }
}

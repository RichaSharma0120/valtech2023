package firstWeb;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class TimerFilter implements Filter {

	private FilterConfig filterConfig;

	@Override
	public void destroy() {
		System.out.println("destroy of TIMER filter...");
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		long startTime = System.currentTimeMillis();

        // Proceed with the request
        chain.doFilter(request, response);

        // Capture the end timestamp after processing the request
        long endTime = System.currentTimeMillis();

        // Calculate the time taken
        long timeTaken = endTime - startTime;

        // Print the time taken to the console (you can customize this output as needed)
        System.out.println("Time taken to process the request: " + timeTaken + " ms");
		
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		
		System.out.println("init of Timer filter");
	
		
		this.filterConfig = filterConfig;

        // Perform any initialization tasks here
        String initializationParameter = filterConfig.getInitParameter("myInitParameter");
        if (initializationParameter != null) {
            System.out.println("Initialization parameter: " + initializationParameter);
            
//            This line retrieves an initialization parameter named "myInitParameter" from the FilterConfig object 
//            using the getInitParameter method.
		
	}

}
}

package InterceptorChain;

public class FilterB implements Filter {

	@Override
	public void preFilter(Request req, Response res, FilterChain chain) {
		System.out.println("start execute FilterB ");
		chain.doFilter(req, res);
	}

	@Override
	public void afterFilter(Request req, Response res, FilterChain chain) {
		System.out.println(" end execute FilterB");
		
	}

}

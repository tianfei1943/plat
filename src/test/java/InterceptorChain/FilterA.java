package InterceptorChain;

public class FilterA implements Filter {

	@Override
	public void preFilter(Request req, Response res, FilterChain chain) {
		System.out.println("start execute FilterA ");
		chain.doFilter(req, res);
		
	}

	@Override
	public void afterFilter(Request req, Response res, FilterChain chain) {
		System.out.println(" end execute FilterA");
	}

}

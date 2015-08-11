package InterceptorChain;

public class Client {

	public static void main(String[] args) {
		FilterChain chain = new FilterChainImpl();
		chain.addFilter(new FilterA());
		chain.addFilter(new FilterB());
		chain.doFilter(new Request(), new Response());
	}

}

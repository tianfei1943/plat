package thread.pool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class CustomerThreadPoolExecutor {

	private ThreadPoolExecutor pool = null;
	
	public CustomerThreadPoolExecutor(){
		pool = new ThreadPoolExecutor(5, 10, 30, 
				TimeUnit.MINUTES, 
				new LinkedBlockingQueue<Runnable>(10), 
				new CustomerThreadFactory(), 
				new CustomRejectedExecutionHandler());
	}
	
	public ExecutorService getExecutorService(){
		return pool;
	}
	
	public void destory(){
		if(pool != null){
			pool.shutdownNow();
		}
	}
	
	private class CustomerThreadFactory implements ThreadFactory{

		private AtomicInteger count = new AtomicInteger(0);
		
		@Override
		public Thread newThread(Runnable r) {
			Thread t = new Thread(r);
			String threadName = CustomerThreadPoolExecutor.class.getSimpleName() + count.addAndGet(1);  
            System.out.println(threadName);  
            t.setName(threadName); 
            return t;
		}
		
	}
	
	private class CustomRejectedExecutionHandler implements RejectedExecutionHandler {  
		  
        @Override  
        public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {  
            // 记录异常  
            // 报警处理等  
            System.out.println("error.............");  
        }  
    }
	
	
	 // 测试构造的线程池  
    public static void main(String[] args) {  
    		CustomerThreadPoolExecutor exec = new CustomerThreadPoolExecutor();  

          
        ExecutorService pool = exec.getExecutorService();  
        for(int i=1; i<100; i++) {  
            System.out.println("提交第" + i + "个任务!");  
            pool.execute(new Runnable() {  
                @Override  
                public void run() {  
                    try {  
                        Thread.sleep(3000);  
                    } catch (InterruptedException e) {  
                        e.printStackTrace();  
                    }  
                    System.out.println("running=====");  
                }  
            });  
        }  
          
          
          
        // 2.销毁----此处不能销毁,因为任务没有提交执行完,如果销毁线程池,任务也就无法执行了  
        // exec.destory();  
          
        try {  
            Thread.sleep(10000);  
        } catch (InterruptedException e) {  
            e.printStackTrace();  
        }  
    } 

}

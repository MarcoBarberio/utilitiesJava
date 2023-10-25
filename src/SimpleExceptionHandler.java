import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.TimeUnit;

public class SimpleExceptionHandler {

	public static void awaitTermination(ExecutorService threadPool) {
		try {
			threadPool.awaitTermination(Long.MAX_VALUE, TimeUnit.MILLISECONDS);
		} catch (InterruptedException e) {
			System.out.println("threadPool waiting termination");
		}
	}

	public static void closeFile(InputStream stream) {
		try {
			stream.close();
		} catch (IOException e) {
			System.out.println("Error closing file");
		}
	}

	public static void execute(ExecutorService threadPool, Runnable task) {
		try {
			threadPool.execute(task);
		} catch (RejectedExecutionException e) {
			System.out.println("Rejected task error");
		}
	}
}

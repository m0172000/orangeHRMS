package commonUtlis;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryImp implements IRetryAnalyzer{

	int startindex=0;
	int lastTry=3;
	@Override
	public boolean retry(ITestResult result) {
		if(startindex<lastTry) {
			startindex++;
            System.out.println(" Retrying test: " + result.getName() + "Attempt: " + startindex);

			return true;
		}
		
		return false;
	}

}

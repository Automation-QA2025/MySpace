package testCases;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import org.testng.IAnnotationTransformer;
import org.testng.IRetryAnalyzer;
import org.testng.annotations.ITestAnnotation;

public class MyRetryAnalyzer implements IAnnotationTransformer{




	@Override
	public void transform(ITestAnnotation annotation, Class testClass,Constructor testConstructor, Method testMethod) {
		
			annotation.setRetryAnalyzer(RetryAnalyzer.class);
}
}

package org.vkedco.mobappdev.ndk.jni;

//  public class before
public class CppFunctionsJNI
{

	static
	{
		System.loadLibrary("processJNI");
	}

	// pass in an array of ints of size size and increment
	// each element by 1.
	public static native void incrementNumbers(int[] numbers, int size);
}

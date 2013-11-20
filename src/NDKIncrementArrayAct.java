package org.vkedco.mobappdev.ndk.main;

/*
 ******************************************************* 
 * NDKIncrementArrayAct.java is an an example
 * that uses C++ code through CppFunctionsJNI.java.
 * It creates an array of random integers and passes
 * it to the C++ program defined in /jni/NDKSource.cpp.
 * The C++ program increments each integer by 1.
 * The array is displayed on the screen of this
 * activity before and after the modification.
 * 
 * Errors, comments to vladimir dot kulyukin at gmail dot com
 *******************************************************
 */

import java.util.Random;
import org.vkedco.mobappdev.ndk.jni.CppFunctionsJNI;
import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class NDKIncrementArrayAct extends Activity
{
	private static final int SIZE = 5;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		TextView display = (TextView) findViewById(R.id.display);
		display.setText("Original Numbers:\n");

		int[] numbers = new int[SIZE];

		Random random = new Random();
		for (int i = 0; i < SIZE; i++)
		{
			numbers[i] = random.nextInt(1000);
			display.append(numbers[i] + "\n");
		}

		// This is where the NDK stuff begins
		CppFunctionsJNI.incrementNumbers(numbers, SIZE);

		display.append("\n\nModified Numbers:\n");

		for (int i = 0; i < SIZE; i++)
		{
			display.append(numbers[i] + "\n");
		}

	}
}

#include <jni.h>
#include <cpu-features.h>

#define JNIEXPORT
#define JNICALL

#ifdef __cplusplus
extern "C"
{
#endif

  // Comment 1: JNIEnv *env, jclass jc are mandatory Android NDK params 
  // that must be there
  // all the time (there might be exceptions but I do not know of any)
  // Comment 2: The name of the function is 
  // Java_org_vkedco_mobapdev_ndk_jni_CppFunctionsJNI_incrementNumbers
  // Java_ is mandatory
  // org_vkedco_mobappdev_ndk_jni reflects the package name
  // org.vkedco.mobappdev.ndk.jni in the eclipse project where
  // the class CppFunctionsJNI resides.
  // CppFunctionsJNI is a wrapper for the C/C++ functions that
  // you want to call from your Android app.
  //org.vkedco.mobappdev.ndk.jni
JNIEXPORT void JNICALL
Java_org_vkedco_mobappdev_ndk_jni_CppFunctionsJNI_incrementNumbers(
		JNIEnv *env, jclass jc, jintArray numArray, jint size)
{
	jboolean isCopy; // copy flags
	// Java to C++ arrays: this is where the Java array is copied
        // into a C array.
	jint *numbers = env->GetIntArrayElements(numArray, &isCopy);

        // this is where the C array is modified
	for (int i = 0; i < size; i++)
		numbers[i] = numbers[i] + 1;

        // once the array is modified you copy it back into the
        // Java array numArray.
	if (isCopy == JNI_TRUE)
                // Copy the contents of the buffer back into array and free the buffer
	  env->ReleaseIntArrayElements(numArray, numbers, 0);
	else
		env->ReleaseIntArrayElements(numArray, numbers, JNI_ABORT);
}

#ifdef __cplusplus
}
#endif

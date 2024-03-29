/* DO NOT EDIT THIS FILE - it is machine generated */
#include <jni.h>
/* Header for class Dispatch */

#ifndef _Included_Dispatch
#define _Included_Dispatch
#ifdef __cplusplus
extern "C" {
#endif
/*
 * Class:     com_jacob_com_Dispatch
 * Method:    QueryInterface
 * Signature: (Ljava/lang/String;)Lcom/jacob/com/Dispatch;
 */
JNIEXPORT jobject JNICALL Java_com_jacob_com_Dispatch_QueryInterface
  (JNIEnv *, jobject, jstring);

/*
 * Class:     Dispatch
 * Method:    createInstance
 * Signature: (Ljava/lang/String;)V
 */
JNIEXPORT void JNICALL Java_com_jacob_com_Dispatch_createInstance
  (JNIEnv *, jobject, jstring);

/*
 * Class:     Dispatch
 * Method:    release
 * Signature: ()V
 */
JNIEXPORT void JNICALL Java_com_jacob_com_Dispatch_release
  (JNIEnv *, jobject);

/*
 * Class:     Dispatch
 * Method:    getIDsOfNames
 * Signature: (Ljava/lang/Object;I[Ljava/lang/String;)[I
 */
JNIEXPORT jintArray JNICALL Java_com_jacob_com_Dispatch_getIDsOfNames
  (JNIEnv *, jclass, jobject, jint, jobjectArray);

/*
 * Class:     Dispatch
 * Method:    invokev
 * Signature: (Ljava/lang/Object;Ljava/lang/String;III[LVariant;[I)LVariant;
 */
JNIEXPORT jobject JNICALL Java_com_jacob_com_Dispatch_invokev
  (JNIEnv *, jclass, jobject, jstring, jint, jint, jint, jobjectArray, jintArray);

#ifdef __cplusplus
}
#endif
#endif

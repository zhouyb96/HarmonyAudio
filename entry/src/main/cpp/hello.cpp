#include "OpenSLESRecord.h"
#include <jni.h>
#include <string>
#include <Hilog/log.h>

auto * op=new OpenSLESRecord();

extern "C"
JNIEXPORT void JNICALL
Java_cn_zybwz_audio_slice_MainAbilitySlice_startRecord(JNIEnv* env, jobject  obj,jstring path) {
    HILOG_ERROR(LOG_APP,"startRecord");
    const char * f=env->GetStringUTFChars(path,0);
    op->startRecord(f);
}

extern "C"
JNIEXPORT void JNICALL
Java_cn_zybwz_audio_slice_MainAbilitySlice_stopRecord(JNIEnv* env, jobject  obj) {
    HILOG_ERROR(LOG_APP,"stopRecord");
    op->stopRecord();
}

extern "C"
JNIEXPORT void JNICALL
Java_cn_zybwz_audio_slice_MainAbilitySlice_playRecord(JNIEnv* env, jobject  obj,jstring path) {
    HILOG_ERROR(LOG_APP,"playRecord");
    const char * f=env->GetStringUTFChars(path,0);
    op->play(f);
}

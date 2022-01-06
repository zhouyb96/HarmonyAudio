# For more information about using CMake with Android Studio, read the
# documentation: https://d.android.com/studio/projects/add-native-code.html

# Sets the minimum version of CMake required to build the native library.

cmake_minimum_required(VERSION 3.4.1)

project("audio")

# Creates and names a library, sets it as either STATIC
# or SHARED, and provides the relative paths to its source code.
# You can define multiple libraries, and CMake builds them for you.
# Gradle automatically packages shared libraries with your APK.

add_library( # Sets the name of the library.
        hello

        # Sets the library as a shared library.
        SHARED

        # Provides a relative path to your source file(s).
        hello.cpp)
target_link_libraries( # Specifies the target library.
        hello
        # Links the target library to the log library
        # included in the NDK.
        OpenSLESRecord)

add_library( # Sets the name of the library.
        OpenSLESRecord

        # Sets the library as a shared library.
        SHARED

        # Provides a relative path to your source file(s).
        OpenSLESRecord.cpp)

target_link_libraries( # Specifies the target library.
        OpenSLESRecord
        # Links the target library to the log library
        # included in the NDK.
        OpenSLES
        libhilog_ndk.z.so)
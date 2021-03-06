package com.bridgelabz.moodanalyser;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class MoodAnalyserReflector {
    private static MoodAnalyserReflector moodAnalyserClass;

    public static MoodAnalyser createMoodAnalyser(String message) {
        try {
            Class<?> moodAnalyserClass = Class.forName("com.bridgelabz.moodanalyser.MoodAnalyser");
            Constructor<?> moodConstructors = moodAnalyserClass.getConstructor(String.class);
            Object myobj = moodConstructors.newInstance(message);
            return (MoodAnalyser) myobj;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return null;
    }


    public static Constructor<?> getConstructor(Class<?>... stringClass) {
        Constructor<?> constructor = null;
        try {
            Class<?> aClass = Class.forName("com.bridgelabz.moodanalyser.MoodAnalyser");
            constructor = aClass.getConstructor(stringClass);

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        return constructor;
    }


    public static Object getObject(Constructor constructor, String... message) throws MoodAnalyserException {
        Object moodObj = null;
        try {
            moodObj = constructor.newInstance(message);
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalArgumentException e) {
            throw new MoodAnalyserException(MoodAnalyserException.ExceptionType.ENTERED_NULL,"Please enter valid message");
        }
        return moodObj;
    }
    public static Method getMethod(String methodName) throws MoodAnalyserException {
        try {
            Constructor<?> constructor = getConstructor(String.class);
            Object object = getObject(constructor, "sad");
            Method analyze = object.getClass().getDeclaredMethod(methodName);
            return analyze;
        } catch (NoSuchMethodException e) {
            throw new MoodAnalyserException(MoodAnalyserException.ExceptionType.NO_SUCH_METHOD_FOUND,"Please enter the valid method name");
        } catch (SecurityException e) {
            e.printStackTrace();
        }

        return null;
    }
}
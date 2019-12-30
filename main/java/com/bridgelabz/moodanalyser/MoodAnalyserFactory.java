package com.bridgelabz.moodanalyser;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class MoodAnalyserFactory {
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

    public static Object getObject(Constructor<?> constructor, String... message) {
        Object moodObject = null;
        try {
            moodObject = constructor.newInstance(message);
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return moodObject;
    }
}


//    public static Object getObjectParameter(Constructor constructor,String... message) {
//        Object obj=null;
//        try {
//             obj= constructor.newInstance(message);
//        } catch (InstantiationException e) {
//            e.printStackTrace();
//        } catch (IllegalAccessException e) {
//            e.printStackTrace();
//        } catch (InvocationTargetException e) {
//            e.printStackTrace();
//        }
//        return obj;
//    }
//}

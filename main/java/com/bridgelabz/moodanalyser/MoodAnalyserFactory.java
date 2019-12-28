package com.bridgelabz.moodanalyser;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class MoodAnalyserFactory {
    public static MoodAnalyser createMoodAnalyser(String message) {
        try {
            Class<?> moodAnalyserClass = Class.forName("com.bridgelabz.moodanalyser.MoodAnalyser");
            Constructor<?> moodConstructors = moodAnalyserClass.getConstructor(String.class);
            Object myobj=moodConstructors.newInstance(message);
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
}

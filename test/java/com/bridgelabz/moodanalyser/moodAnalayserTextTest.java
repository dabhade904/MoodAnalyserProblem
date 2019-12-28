package com.bridgelabz.moodanalyser;

import org.junit.Assert;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import static java.lang.Class.forName;

public class moodAnalayserTextTest {

    @Test
    public void whenGivenSadMessage_shouldReturnSad() {
        MoodAnalyser analyser=new MoodAnalyser("i am sad right now");
        String message= null;
        try {
            message = analyser.analyse();
            Assert.assertEquals("Sad",message);

        } catch (MoodAnalyserException e) {
            e.printStackTrace();
        }
    }

   @Test
   public void whenGivenHappyMessage_shouldReturnHappy()
    {
        MoodAnalyser moodAnalayser=new MoodAnalyser("i m happy");
        String message = null;
        try {
            message = moodAnalayser.analyse();
            Assert.assertEquals("happy",message);
        } catch (MoodAnalyserException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void whenGivenSadMessage_WithSAlphabetCapital_ShouldReturnHappy()
    {
        MoodAnalyser moodAnalyser=new MoodAnalyser("i am happy");
        String message = null;
        try {
            message = moodAnalyser.analyse();
            Assert.assertEquals("happy",message);

        } catch (MoodAnalyserException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void whenGivenNullMessage_ShouldReturnHappy ()
    {
        MoodAnalyser moodAnalyser=new MoodAnalyser(null);
        String message = null;
        try {
            ExpectedException expectedException=ExpectedException.none();
            expectedException.expect(MoodAnalyserException.class);
            message = moodAnalyser.analyse();
            Assert.assertEquals("happy",message);
        } catch (MoodAnalyserException e) {
            e.printStackTrace();
        }
    }

    @Test
    public  void whenGivenMessageNull_ShouldReturnException(){
        MoodAnalyser moodAnalyser=new MoodAnalyser(null);
        String message="";
        try {
            message=moodAnalyser.analyse();
            Assert.assertEquals("happy",message);
        }catch (MoodAnalyserException e)
        {
           Assert.assertEquals("please enter in proper",e.getMessage());
        }
    }

    @Test
    public void givenMoodAnalyserClass_WhenProper_ShouldReturnObject(){
        MoodAnalyser moodAnalyser=MoodAnalyserFactory.createMoodAnalyser("i am in happy mood");
        }

    @Test
    public  void givenMoodAnalyser_WhenProper_ShouldReturnObject() {
        Constructor<?>constructor=null;
        try{
            constructor = forName("com.bridgelabz.moodanalyser.MoodAnalyser").getConstructor(String.class);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try{
            Object obj=constructor.newInstance("please enter in proper");
            MoodAnalyser moodAnalyser=(MoodAnalyser)obj;
            String mood=moodAnalyser.analyse();
            Assert.assertEquals("happy",mood);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (MoodAnalyserException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void whenGivenObjectWithProperMessage_ShouldReturnTrue()
    {
        MoodAnalyser obj1=new MoodAnalyser("i am happy");
        MoodAnalyser obj2=MoodAnalyserFactory.createMoodAnalyser("i am happy");
        Assert.assertEquals(true,obj2.equals(obj1));
    }

    @Test
//    public  void  whenGivenClassName_improper_ShouldThrowMoodAnalsisException() throws MoodAnalyserException {
//        try {
//            Constructor<?> constructor = Class.forName("com.bridgelabz.moodanalyser.moodAnalyser").getConstructor(String.class);
//            Object object=constructor.newInstance("please enter in proper");
//            MoodAnalyser moodAnalyser=(MoodAnalyser)object;
//            String mood=moodAnalyser.analyse();
//            Assert.assertEquals("happy",mood);
//        } catch (InstantiationException e) {
//            e.printStackTrace();
//        } catch (InvocationTargetException e) {
//            e.printStackTrace();
//        } catch (NoSuchMethodException e) {
//            e.printStackTrace();
//        } catch (MoodAnalyserException e) {
//            throw new MoodAnalyserException(MoodAnalyserException.ExceptionType.CLASS_NOT_FOUND_EXCEPTION, "please enter in proper");
//        } catch (IllegalAccessException e) {
//            e.printStackTrace();
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        }
//    }


    public void whenImproperClassName_shouldReturnException() {
        try {
            Constructor<?>constructor=Class.forName("com.bridgelabz.moodanalyse").getConstructor(String.class);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
            try {
                throw new MoodAnalyserException(MoodAnalyserException.ExceptionType.NO_SUCH_METHOD_FOUND,"please enter in proper");
            } catch (MoodAnalyserException ex) {
                ex.printStackTrace();
            }
        } catch (ClassNotFoundException e) {
            try {
                throw new MoodAnalyserException(MoodAnalyserException.ExceptionType.NO_SUCH_CLASS_FOUND, "please enter in proper");
            }catch (MoodAnalyserException a){
                a.printStackTrace();
            }

        }

    }
}
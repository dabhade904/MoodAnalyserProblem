package com.bridgelabz.moodanalyser;

import org.junit.Assert;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

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
        MoodAnalyser moodAnalyser= MoodAnalyserReflector.createMoodAnalyser("i am in happy mood");
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
        MoodAnalyser obj2= MoodAnalyserReflector.createMoodAnalyser("i am happy");
        Assert.assertEquals(true,obj2.equals(obj1));
    }


    @Test
    public void whenGivenClassName_ImproperClassName_shouldReturnException() {
        try {
            Constructor<?>constructor=Class.forName("com.bridgelabz.moodanalyser.moodAnalyser").getConstructor(String.class);
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

    @Test
    public void whenGivenConstructor_NotProper_ShouldReturnCustomException() throws MoodAnalyserException {
        Constructor<?>constructor=null;
        try {
            constructor=Class.forName("com.bridgelabz.moodanalyser.MoodAnalyser").getConstructor();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
            try{
                throw  new MoodAnalyserException(MoodAnalyserException.ExceptionType.NO_SUCH_CONSTRCUTOR_FOUND,"Invalid Entry");
            }catch (MoodAnalyserException a){
                a.printStackTrace();
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Test
    public  void whenGivenConstructorParameter_ShouldReturnObject(){
        Constructor<?> constructor= MoodAnalyserReflector.getConstructor(String.class);
        Object object= MoodAnalyserReflector.getObject(constructor,"i am happy");
        MoodAnalyser moodAnalyser=(MoodAnalyser)object;
        Assert.assertEquals(true,moodAnalyser.equals(new MoodAnalyser("i am happy")));
    }

    @Test
    public  void whenGivenConstructorWithNoParameter_ShouldReturnObject() {
        Constructor constructor= null;
        constructor = MoodAnalyserReflector.getConstructor();
        Object object= MoodAnalyserReflector.getObject(constructor);
        MoodAnalyser moodAnalyser=(MoodAnalyser)object;
        Assert.assertEquals(true,moodAnalyser.equals(new MoodAnalyser()));
    }


    @Test
    public void whenGivenMethod_shouldInvokeReturnObject() throws InvocationTargetException, IllegalAccessException, NoSuchMethodException {
        Method method = MoodAnalyserReflector.getMethod("i am happy");
        String mood = (String) method.invoke(new MoodAnalyser("i am happy"));
        Assert.assertEquals("happy",mood);
    }
}
package com.bridgelabz.moodanalyser;

import org.junit.Assert;
import org.junit.Test;
import org.junit.rules.ExpectedException;

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
    public void whenGivenSadMessage_WithSAlphabetCapital_ShouldReturnSad()
    {
        MoodAnalyser moodAnalyser=new MoodAnalyser("i am Sad");
        String message = null;
        try {
            message = moodAnalyser.analyse();
            Assert.assertEquals("Sad",message);

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
}
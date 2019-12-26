package com.bridgelabz.moodanalyser;

public class MoodAnalyser {
    public String analyse(String message) throws MoodAnalyserException{
        try {
            if (message.length()==0)
                throw new MoodAnalyserException(MoodAnalyserException.ExceptionType.ENTERED_EMPTY,"please enter in proper");
            if (message.contains("sad") || message.contains("Sad"))

                return "Sad";
            else
                return "happy";

        }catch(NullPointerException e)
        {
            throw  new MoodAnalyserException(MoodAnalyserException.ExceptionType.ENTERED_NULL,"please enter in proper");
        }
    }
}



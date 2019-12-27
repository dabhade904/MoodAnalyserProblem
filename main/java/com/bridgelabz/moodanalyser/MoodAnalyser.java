package com.bridgelabz.moodanalyser;

public class MoodAnalyser {
    private  String message;

    public  MoodAnalyser(String message) {
        this.message=message;
    }
    public MoodAnalyser(){

    }

    public String analyse() throws MoodAnalyserException{
        try {
            if (message.length()==0)
                throw new MoodAnalyserException(MoodAnalyserException.ExceptionType.ENTERED_EMPTY,"please enter in proper");
            if (message.contains("sad"))

                return "Sad";
            else
                return "happy";

        }catch(NullPointerException e)
        {
            throw  new MoodAnalyserException(MoodAnalyserException.ExceptionType.ENTERED_NULL,"please enter in proper");
        }
    }
}



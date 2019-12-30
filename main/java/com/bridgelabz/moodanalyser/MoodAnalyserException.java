package com.bridgelabz.moodanalyser;

public class MoodAnalyserException extends Exception{
    enum ExceptionType {
       ENTERED_NULL,ENTERED_EMPTY,NO_SUCH_METHOD_FOUND,NO_SUCH_CLASS_FOUND,NO_SUCH_CONSTRCUTOR_FOUND,NO_FIELD_FOUND;
    }
    ExceptionType type;

    public MoodAnalyserException(ExceptionType type,String message)
    {
        super(message);
        this.type=type;
    }

}

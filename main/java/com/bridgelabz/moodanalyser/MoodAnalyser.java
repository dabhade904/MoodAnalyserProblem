package com.bridgelabz.moodanalyser;

import java.util.Objects;

public class MoodAnalyser {
    private  String message;

    public  MoodAnalyser(String message) {
        this.message=message;
    }

    public MoodAnalyser() {

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MoodAnalyser that = (MoodAnalyser) o;
        return Objects.equals(message, that.message);
    }

    @Override
    public int hashCode() {
        return Objects.hash(message);
    }

    public String analyse() throws MoodAnalyserException {
        try {
            if (message.length() == 0)
                throw new MoodAnalyserException(MoodAnalyserException.ExceptionType.ENTERED_EMPTY, "please enter in proper");
            if (message.contains("Sad")|| message.contains("sad"))

                return "Sad";
            else
                return "happy";

        } catch (NullPointerException e) {
            throw new MoodAnalyserException(MoodAnalyserException.ExceptionType.ENTERED_NULL, "please enter in proper");
        }
    }

}



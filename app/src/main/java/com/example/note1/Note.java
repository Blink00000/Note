package com.example.note1;

public class Note {

    private static String title;

    private static String content;

    public Note(String title, String content){
        this.title = title;
        this.content = content;
    }

    public static String getTitle(){
        return title;
    }

    public static String getContent(){
        return content;
    }
}

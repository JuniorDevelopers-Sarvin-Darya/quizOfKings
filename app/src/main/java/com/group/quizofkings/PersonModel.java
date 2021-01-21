package com.group.quizofkings;

public class PersonModel
{
    private String name;
    private int imageID;

    public PersonModel(String name, int imageID)
    {
        this.name = name;
        this.imageID = imageID;
    }
    public String getName() {
        return name;
    }

    public int getImageID() {
        return imageID;
    }
}

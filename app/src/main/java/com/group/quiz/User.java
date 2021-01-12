package com.group.quiz;

public class User
{
    private String username;
    private String password;
    private int imageId;
    public User(String username, String password)
    {
        this.username = username;
        this.password = password;
    }

    public User(PersonUI firstPlayer)
    {
        this.username = firstPlayer.getName();

    }
}

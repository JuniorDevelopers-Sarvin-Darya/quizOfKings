package com.group.quiz;

public class Game
{
    private User firstPlayer;
    private User secondPlayer;
    public Game(PersonUI firstPlayer, PersonUI secondPlayer)
    {
        this.firstPlayer = new User(firstPlayer);
        this.secondPlayer = new User(secondPlayer);
        start();
    }

    public void start()
    {

    }
}

package com.group.quiz;

public class PersonUI
{
        private int imageID;
        private String name;

        public PersonUI(int imageID, String name)
        {
            this.imageID = imageID;
            this.name = name;
        }

        public int getImageID() {
            return imageID;
        }
        public String getName() {
            return name;

        }
}

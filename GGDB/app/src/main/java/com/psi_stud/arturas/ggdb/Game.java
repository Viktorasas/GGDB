package com.psi_stud.arturas.ggdb;

import java.util.LinkedList;

/**
 * Created by Arturas on 2015-12-16.
 */
public class Game {
    private int gameID;
    private String name;
    private String rating;
    private String description;

    public Game(int gameID){
        this.gameID = gameID;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getRating() {

        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getName() {

        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void loadGame(){
        SQLService service = new SQLService();
        LinkedList<LinkedList<String>> result = service.queryDB("SELECT * FROM Games WHERE ID = 1");//+gameID);
        name = result.get(0).get(1);
        description = result.get(0).get(5);
    }
}

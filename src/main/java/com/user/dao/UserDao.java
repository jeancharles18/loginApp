package com.user.dao;

import com.user.model.User;

import java.util.HashMap;

public class UserDao {
 private HashMap<String,User>  BD;

  {  BD = new HashMap<>();
     BD.put("chris", new User("chris", "chris"));
     BD.put("jean", new User("jean", "jean"));
    }

    public HashMap<String, User> getBD() {
        return BD;
    }
}

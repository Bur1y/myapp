package com.example.myapp.Base;

import com.example.myapp.Base.Tables.User;

public class CRUD {

    public static User getUser(String login, String password){
        return (User) Hibernate
                .getSessionFactory()
                .openSession()
                .createQuery("FROM User U WHERE U.login = '" + login +"' AND U.password = '" + password + "'")
                .uniqueResult();
    }
}

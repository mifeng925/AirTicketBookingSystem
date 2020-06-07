package com.bee.airsystem.dao;

import com.bee.airsystem.entity.UserBase;
import org.junit.Test;

import java.util.List;

public class UserBaseDAOImplTest {

    UserBaseDao dao = new UserBaseDAOImpl();

    @Test
    public void getAll() {

        List<UserBase> all = dao.getAll();
        for (UserBase user : all) {
            System.out.println(user);
        }
    }

    @Test
    public void delete() {
        boolean delete = dao.delete(new UserBase("123456"));
        System.out.println(delete);
    }

    @Test
    public void update() {
        dao.update(new UserBase("hello","word","男","怕怕","949323","8888","13333","","",""));
    }

    @Test
    public void add() {
        dao.add(new UserBase("hello","word","女","怕怕","949323","8888","13333","","",""));

    }

    @Test
    public void findByIdentityCard() {
        UserBase byIdentityCard = dao.findByIdentityCard("949323");
        System.out.println(byIdentityCard);
    }
}
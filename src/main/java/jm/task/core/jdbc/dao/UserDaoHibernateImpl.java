package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDaoHibernateImpl implements UserDao {
    public UserDaoHibernateImpl() {

    }


    @Override
    public void createUsersTable() {
        try (Session session = Util.getSessionFactory().openSession()) {
            Transaction tx = session.beginTransaction();
            String createUsersTable = """
                    CREATE TABLE if not exists users (
                    id bigint NOT NULL AUTO_INCREMENT,
                    name varchar(100),
                    lastName varchar(150),
                    age tinyint,
                    PRIMARY KEY (id)
                    );
                    """;
            session.createSQLQuery(createUsersTable).executeUpdate();
            tx.commit();
        }

    }

    @Override
    public void dropUsersTable() {
        try (Session session = Util.getSessionFactory().openSession()) {
            Transaction tx = session.beginTransaction();
            String dropUsersTable = "DROP TABLE if exists USERS;";
            session.createNativeQuery(dropUsersTable).executeUpdate();
            tx.commit();
        }

    }

    @Override
    public void saveUser(String name, String lastName, byte age) {
        try (Session session = Util.getSessionFactory().openSession()) {
            Transaction tx = session.beginTransaction();
            session.save(new User(name, lastName, age));
            tx.commit();
        }

    }

    @Override
    public void removeUserById(long id) {
        try (Session session = Util.getSessionFactory().openSession()) {
            Transaction tx = session.beginTransaction();
            session.delete(session.load(User.class, id));
            tx.commit();
        }
    }

    @Override
    public List<User> getAllUsers() {
        List<User> result;
        try (Session session = Util.getSessionFactory().openSession()) {
            result = session.createQuery("SELECT a FROM User a", User.class).getResultList();
        }
        return result;
    }

    @Override
    public void cleanUsersTable() {
        try (Session session = Util.getSessionFactory().openSession()) {
            Transaction tx = session.beginTransaction();
            Query query = session.createQuery("DELETE FROM User");
            query.executeUpdate();
            tx.commit();
        }
    }
}

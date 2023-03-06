package jm.task.core.jdbc.model;

import javax.persistence.*;

@Entity
@Table(name = "users")
@Access(AccessType.FIELD)
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private final Long id;

    @Column(name = "name")
    private final String name;

    @Column(name = "lastName")
    private final String lastName;

    @Column(name = "age")
    private final Byte age;

    public User() {
        this.id = 0L;
        this.name = null;
        this.lastName = null;
        this.age = 0;
    }

    public User(String name, String lastName, Byte age) {
        this.id = 0L;
        this.name = name;
        this.lastName = lastName;
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                '}';
    }
}

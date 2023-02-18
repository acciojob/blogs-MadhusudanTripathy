package com.driver.models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "user")
public class User{

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private int id;

        @Column(unique = true)
        private String userName;
        private String password;
        private String firstName;
        private String lastName;

        @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
        private List<Blog> blogs;

        public User() {
                firstName ="test";
                lastName ="test";
        }

        public int getId() {
                return id;
        }

        public void setId(int id) {
                this.id = id;
        }

        public String getUserName() {
                return userName;
        }

        public void setUserName(String userName) {
                this.userName = userName;
        }

        public String getPassword() {
                return password;
        }

        public void setPassword(String password) {
                this.password = password;
        }

        public String getFirstName() {
                return firstName;
        }

        public void setFirstName(String firstName) {
                this.firstName = firstName;
        }

        public String getLastName() {
                return lastName;
        }

        public void setLastName(String lastName) {
                this.lastName = lastName;
        }

        public List<Blog> getblogs() {
                return blogs;
        }

        public void setblogs(List<Blog> blogs) {
                this.blogs = blogs;
        }
}
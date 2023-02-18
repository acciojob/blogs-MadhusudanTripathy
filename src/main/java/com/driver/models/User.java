package com.driver.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "user")
public class User{

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private int id;

        @Column(unique = true)
        private String username;
        private String password;
        private String firstname="test";
        private String lastname="test";

        @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
        private List<Blog> blogList = new ArrayList<>();

        public User() {

                blogList = new ArrayList<>();
        }
        public User(String username, String password) {
                blogList = new ArrayList<>();

                this.username = username;
                this.password = password;
        }

        public int getId() {
                return id;
        }

        public void setId(int id) {
                this.id = id;
        }

        public String getUsername() {
                return username;
        }

        public void setUsername(String username) {
                this.username = username;
        }

        public String getPassword() {
                return password;
        }

        public void setPassword(String password) {
                this.password = password;
        }

        public String getFirstname() {
                return firstname;
        }

        public void setFirstname(String firstname) {
                this.firstname = firstname;
        }

        public String getLastname() {
                return lastname;
        }

        public void setLastname(String lastname) {
                this.lastname = lastname;
        }

        public List<Blog> getBlogList() {
                return blogList;
        }

        public void setBlogList(List<Blog> blogs) {
                this.blogList = blogs;
        }
}
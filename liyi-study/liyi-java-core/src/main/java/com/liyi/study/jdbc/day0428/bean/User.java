package com.liyi.study.jdbc.day0428.bean;

/**
 * @TODO: javastudy
 * @author: xiangdan/xiangdan@dtxytech.com
 * @time: 2021/4/28 9:30  星期三
 */
public class User {



        private String user;
        private String password;

        public User() {
        }

        public User(String user, String password) {
            super();
            this.user = user;
            this.password = password;
        }

        @Override
        public String toString() {
            return "User [user=" + user + ", password=" + password + "]";
        }

        public String getUser() {
            return user;
        }

        public void setUser(String user) {
            this.user = user;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }


}

package module7.lesson;

public class User {
    private  String name;
    private  String lastName;
    private String login;
    private  String mail;

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", login='" + login + '\'' +
                ", mail='" + mail + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public static Builder getBuilder(){
        return new Builder();
    }

    public static class Builder{
        private  String name;
        private  String lastName;
        private String login;
        private  String mail;


        public Builder name(String s){
            this.name = s;
            return this;
        }

        public Builder lastName (String s){
            this.lastName = s;
            return this;
        }

        public Builder login ( String s){
            this.login = s;
            return this;
        }

        public Builder mail ( String s) {
            this.mail = s;
            return this;
        }

        public User build () {
            User user = new User();
            user.setName(name);
            user.setLastName(lastName);
            user.setMail(mail);
            user.setLogin(login);
            return user;
        }

    }
}

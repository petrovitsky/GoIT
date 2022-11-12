package module13.http;

public class UserDTO {
    private String gender;
    private int id;
    private String name;
    private int salary;
    private String surname;

    private UserDTO(){};

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    @Override
    public String toString() {
        return "User{" +
                "gender='" + gender + '\'' +
                ", id=" + id +
                ", name='" + name + '\'' +
                ", salary=" + salary +
                ", surname='" + surname + '\'' +
                '}';
    }

    public static class UserDTOBuilder {
        private String gender;
        private int id;
        private String name;
        private int salary;
        private String surname;

        public UserDTOBuilder gender(String g) {
            gender = g;
            return this;
        }

        public UserDTOBuilder id(int i) {
            id = i;
            return this;
        }

        public UserDTOBuilder name(String n) {
            name = n;
            return this;
        }

        public UserDTOBuilder salary(int s) {
            salary = s;
            return this;
        }
        public UserDTOBuilder surname(String s){
            surname = s;
            return this;
        }


        public UserDTO build() {
            UserDTO user = new UserDTO();
            user.gender = this.gender;
            user.id = this.id;
            user.name = this.name;
            user.surname = this.surname;
            user.salary = salary;
            return user;
        }

    }
}

package moscow.travelhack.russpass.resource;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Account {

    @Id
    @GeneratedValue
    private Integer id;
    private String username, password, name, surname, phone, passport_info, age;

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getPhone() {
        return phone;
    }

    public String getPassport_info() {
        return passport_info;
    }

    public String getAge() {
        return age;
    }

    public Account(String username, String password, String name, String surname, String phone, String passport_info,
                   String age) {
        this.username = username;
        this.password = password;
        this.name = name;
        this.surname = surname;
        this.phone = phone;
        this.passport_info = passport_info;
        this.age = age;
    }

    public Account() {

    }

    public Integer getId() {
        return id;
    }

    public String getPassword() {
        return password;
    }

    public String getUsername() {
        return username;
    }
}

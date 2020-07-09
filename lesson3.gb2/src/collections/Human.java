package collections;


import java.util.ArrayList;
import java.util.List;

public class Human {
    private ArrayList<String> phone;
    private String email;
    private String name;

    public Human(String name, String phone, String email) {
        this.name = name;
        this.phone = new ArrayList<>();
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<String> getPhone() {
        return phone;
    }

    public void setPhone(List<String> phone) {
        this.phone = (ArrayList<String>) phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
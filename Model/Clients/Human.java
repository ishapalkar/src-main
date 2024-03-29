package Model.Clients;

public class Human {
    String f_name;
    int f_age;
    String f_gender;

public Human()
{
    System.out.println("Creating a Human:");
}

public Human(String f_name, int f_age, String f_gender)
{
    this.setf_name(f_name);
    this.setf_age(f_age);
    this.setf_gender(f_gender);
}

public void setf_name(String f_name) {
    this.f_name = f_name; 
}

public void setf_age(int f_age) {
    this.f_age= f_age;
} 

public void setf_gender(String f_gender) {
    this.f_gender = f_gender;
}

public String getf_name() {
    return f_name;
}

public int getf_age() {
    return f_age;
}

public String getf_gender() {
    return f_gender;
}

public void display()
    {
        System.out.println("name: "+getf_name());
        System.out.println("age: "+getf_age());
        System.out.println("gender: "+getf_gender());
    }

}
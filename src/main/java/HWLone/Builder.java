package HWLone;

public class Builder{
    Person person;

    public Builder addFirstName(String firstName) {
        person.setFirstName (firstName);
        return this;
    }

    public Builder addLastName(String lastName) {
        person.setLastName ( lastName);
        return this;
    }

    public Builder addMiddleName(String middleName) {
        person.setMiddleName ( middleName);
        return this;
    }

    public Builder addCountry(String country) {
        person.setCountry ( country);
        return this;
    }

    public Builder addPhone(String phone) {
        person.setPhone ( phone);
        return this;
    }

    public Builder addAge(int age) {
        person.setAge (age);
        return this;
    }

    public Builder addGender(String gender) {
        person.setGender(gender);
        return this;
    }

    public Builder reset(){
        this.person=new Person();
        return this;
    }

    public Person getResult(){
        return person;
    }
}

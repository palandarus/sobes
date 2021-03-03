package HWLone;

public class Main {

    public static void main(String[] args) {
        Builder personBuilder= new Builder();
        Person person=personBuilder.reset().addFirstName("Mike").addMiddleName("Elenovich").addLastName("Zeus").
                addCountry("USA").addPhone("+31212121234").addAge(32).addGender("Unknown").getResult();
    }

}

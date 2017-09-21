//package geekbrains.oop;

public class Main {

    public static void main(String[] args) {
	Person[] person = new Person[5];
	person[0] = new Person("Kalita Ivan Michailovich", "Engineer", "ivan@hotmail.com", "+39168745112", 56, 38);
	person[1] = new Person("Tin Gennadiy Sergeevich", "Car-mechanic", "gennadytin@mail.ru", "+79645241698", 25, 55);
	person[2] = new Person("Lacabidze David Valeryevich", "Builder", "mc_dave@yandex.ru", "+79183578219", 30, 41);
	person[3] = new Person("Kalita Oksana Michailovna", "Teacher", "oksa@apple.com", "89889897505", 25, 22);
	person[4] = new Person("Shucharina Anastasia Batkovna", "Office-manager", "anastasia@gmail.com", "89186452877", 25, 24);

        for (int i = 0; i < person.length; i++) {
            if(person[i].age > 40){
                System.out.println(person[i]);
            }
        }

    }
}

class Person{
    String name;
    String work;
    String e_mail;
    String phone;
    int salary;
    int age;

    Person(String name, String work, String e_mail, String phone, int salary, int age) {
        this.name = name;
        this.work = work;
        this.e_mail = e_mail;
        this.phone = phone;
        this.salary = salary;
        this.age = age;
    }


    @Override
    public String toString(){
        return name + ", " + work + ", " + e_mail + ", " + phone + ", " + salary + ", " + age;
    }

}

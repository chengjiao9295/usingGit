public class Person {
    private String userName;
    private int age;
    Person(){

    }
    Person(int age, String userName){
        this.age = age;
        this.userName = userName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}

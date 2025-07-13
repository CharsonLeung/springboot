public class Cat extends Animal {
  super(name);
  super(age);


  public Cat(String name, Integer age) {
    this.name = name;
    this.age = age;
  }
  public String getName() {
    return this.name;
  }
  public Integer getAge() {
    return this.age;
  }
}
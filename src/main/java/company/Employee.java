package company;

public class Employee {

  private Integer age;
  private String name;

  private Employee (String name, Integer age) {
    this.name = name;
    this.age = age;
  }

  public static Employee create (String name, Integer age) {
    if (age == null) {
      throw new RuntimeException("请输入正确的年龄");
    }
    if (age > 18) {
      return new Employee(name, age);
    }
    if (age == 0) {
      throw new RuntimeException("非法参数");
    }
    throw new RuntimeException("不是一个合法的年纪");
  }

  public void work () {
    System.err.println("我是" + name + " , 我在努力工作");
  }
}

package company;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Company {

  private String name;

  private List<String> employee = new ArrayList<>();

  public String getName () {
    return name;
  }

  public Company () {
    this.name = "default";
  }

  public void naming (String name) {
    this.checkName(name);
    this.name = name;
  }

  private void checkName (String name) {
    if (Objects.isNull(name)) {
      throw new RuntimeException("name must not be null");
    }
    if (name.length() <= 1) {
      throw new RuntimeException("name must great equals 1");
    }
    if (name.length() >= 10) {
      throw new RuntimeException("name must less equals 10");
    }
  }

  public void rename (String newName) {
    this.checkName(newName);
    this.name = newName;
  }

  public void train (List<String> employee) {
    this.employee.addAll(employee);
  }

  public List<String> getEmployee () {
    return employee;
  }
}

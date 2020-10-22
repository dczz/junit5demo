import company.Employee;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("员工测试")
public class EmployeeTest {

  @Test
  @DisplayName("创建时应该会失败")
  void should_throws_exception () {
    Assertions.assertThrows(RuntimeException.class, () -> Employee.create("123", 1));
    Assertions.assertThrows(RuntimeException.class, () -> Employee.create("123", null));
    Assertions.assertThrows(RuntimeException.class, () -> Employee.create("123", 0));
    Assertions.assertNotNull(Employee.create("zhangsan", 19));
  }

  @Test
  @DisplayName("员工在工作")
  void should_work_employee () {
    Employee.create("zhangsan", 20).work();
  }

  @Test
  @Disabled
  @DisplayName("禁止自动执行此测试单元,需手动执行")
  void should_disable_bootstrap () {
    Assertions.assertTrue(false);
  }

}

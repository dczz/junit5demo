import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import company.Company;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

@DisplayName("公司测试")
public class CompanyTest {

  private final Company company = new Company();

  @BeforeAll
  static void beforeAll () {
    System.err.println("beforeall");
  }

  @BeforeEach
  void beforeEach () {
    System.err.println("each");
  }

  @Test
  @DisplayName("应该有一个公司")
  void should_create_company () {
    Assertions.assertNotNull(company);
  }

  @ParameterizedTest
  @ValueSource(strings = {"测试公司"})
  @DisplayName("为公司起名")
  void should_company_naming_for_happy (String newName) {
    company.naming(newName);
    Assertions.assertEquals(company.getName(), newName);
  }

  //业务规则：
  //名称不能大于10个汉字
  //不允许小于1个汉字
  @ParameterizedTest(name = "如果参数是{0},那么这个测试会抛出异常")
  @NullAndEmptySource
  @ValueSource(strings = {"1", "我也是一个公司名称，但是我特别长"})
  @DisplayName("为公司起名，公司如果使用非法名称会抛出异常")
  void should_company_naming_for_said (String newName) {
    Assertions.assertThrows(RuntimeException.class, () -> company.naming(newName));
  }


  public static Stream<Arguments> testEmployeeParams () {
    return Stream.of(
        Arguments.of(Arrays.asList("李1", "李2")),
        Arguments.of(Arrays.asList("王5", "赵6"))
    );
  }

  @ParameterizedTest(name = "如果员工是{0}，那么会通过测试")
  @MethodSource("testEmployeeParams")
  @DisplayName("公司应该有两个员工")
  void should_company_has_employee (List<String> employee) {
    company.train(employee);
    Assertions.assertEquals(company.getEmployee().size(), 2);
  }

  @DisplayName("公司品牌升级，修改名称")
  @Test
  void should_company_rename () {
    String newName = "新名称有限公司";
    company.rename(newName);
    Assertions.assertEquals(company.getName(), newName);
  }

  @Test
  @DisplayName("公司名称不应该为null或者空")
  void should_not_be_empty () {
    Assertions.assertNotNull(company.getName());
    Assertions.assertTrue(company.getName().length() > 1);
  }

}

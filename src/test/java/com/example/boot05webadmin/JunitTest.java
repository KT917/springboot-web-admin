package com.example.boot05webadmin;

import jdk.nashorn.internal.ir.annotations.Ignore;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.junit.platform.commons.util.StringUtils;

import java.time.Duration;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.*;

@DisplayName("jUnit5功能测试类")
public class JunitTest {


//    ● @DisplayName :为测试类或者测试方法设置展示名称
    @DisplayName("测试")
    @Test
    void testDisplayName(){
        System.out.println("tomtom");
    }

    @DisplayName("测试")
    @Test
    @Disabled
    void testDisplayName2(){
        System.out.println("tomtom22");
    }

    //● @BeforeEach :表示在每个单元测试之前执行
    @BeforeEach
    void testBeforeEach(){
        System.out.println("测试要开始了==");
    }

    //● @AfterEach :表示在每个单元测试之后执行
    @AfterEach
    void testAfterEach(){
        System.out.println("测试结束==");
    }

    //● @BeforeAll :表示在所有单元测试之前执行
    @BeforeAll
    static void testBeforeAll(){
        System.out.println("所有测试就要开始");
    }

    //● @AfterAll :表示在所有单元测试之后执行
    @AfterAll
    static void testAfterAll(){
        System.out.println("所有测试就要结束");
    }
    //● @Tag :表示单元测试类别，类似于JUnit4中的@Categories
    //● @Disabled :表示测试类或测试方法不执行，类似于JUnit4中的@Ignore

    //● @Timeout :表示测试方法运行如果超过了指定时间将会返回错误
    @Timeout(value = 5,unit = TimeUnit.MILLISECONDS)
    @Test
    void  testTimeOut() throws InterruptedException {
        Thread.sleep(500);
    }

    //● @ExtendWith :为测试类或测试方法提供扩展类引用

    @Test
    @RepeatedTest(5)
    void test(){
        System.out.println("tom");
    }

    int cal(int i,int j){
        return i+j;
    }

    /**
        断言： 前面断言失败 后面的代码不会执行
     */
    @DisplayName("测试简单断言")
    @Test
    void testSimpleAssertion(){
        int cal=cal(2,3);
        assertEquals(5,cal,"断言错误");
        assertSame(new Object(),new Object(),"断言错误same");
    }

    @Test
    @DisplayName("array assertion")
    public void array() {
       assertArrayEquals(new int[]{1, 2}, new int[] {1, 2});
    }

    @Test
    @DisplayName("assert all")
    public void all() {
        assertAll("Math",
                () -> assertEquals(2, 1 + 1),
                () -> assertTrue(1 > 0)
        );
    }

    @Test
    @DisplayName("异常测试")
    public void exceptionTest() {
        ArithmeticException exception = Assertions.assertThrows(
                //扔出断言异常
                ArithmeticException.class, () -> System.out.println(1/1),"业务逻辑没错误");

    }@Test
    @DisplayName("测试失败")
    public void testFilr() {

        if (2==2){
            fail("测试失败");
        }
    }

    private final String environment = "DEV";

    @Test
    @DisplayName("simple")
    public void simpleAssume() {
        assumeTrue(Objects.equals(this.environment, "DEV"));
        assumeFalse(() -> Objects.equals(this.environment, "PROD"));
    }

    @Test
    @DisplayName("assume then do")
    public void assumeThenDo() {
        assumingThat(
                Objects.equals(this.environment, "DEV"),
                () -> System.out.println("In DEV")
        );
    }


    //   参数化测试
    @ParameterizedTest
    @ValueSource(strings = {"one", "two", "three"})
    @DisplayName("参数化测试1")
    public void parameterizedTest1(String string) {
        System.out.println(string);
        Assertions.assertTrue(StringUtils.isNotBlank(string));
    }

}

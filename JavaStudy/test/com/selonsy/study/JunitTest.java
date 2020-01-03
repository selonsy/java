package com.selonsy.study;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.condition.*;
import org.junit.jupiter.api.function.Executable;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Copyright：Sichen International Co. Ltd.
 * 用来对"实现加减乘除的简单的计算类"进行测试。此类仅用于展示基本的使用方法。
 *
 * @author selonsy
 * Created on 2019/11/28.
 * Desc : none
 */
class JunitTest {

    Junit junit;

    @BeforeEach
    void beforeEach() {
        junit = new Junit();
        System.out.println("在【每个】@Test方法之【前】运行~");
    }

    @AfterEach
    void afterEach() {
        System.out.println("在【每个】@Test方法之【后】运行~");
    }

    @BeforeAll
    static void beforeAll() {
        System.out.println("在【所有】@Test方法之【前】运行~");
        // 本身需要为static方法，一般也只用于测试那些static的方法。
    }

    @AfterAll
    static void afterAll() {
        System.out.println("在【所有】@Test方法之【后】运行~");
        // 本身需要为static方法，一般也只用于测试那些static的方法。
    }

    @Test
    void staticAdd() {
        // 静态方法测试
        assertEquals(5, Junit.staticAdd(2, 3));
    }

    /**
     * 测试常见的断言
     */
    @Test
    void testAssert() {
        // 判断结果是否与预期相同
        assertEquals(1, 1);
        // 判断结果是否为True
        assertTrue(3 > 2);
        // 判断结果是否为False
        assertFalse(3 > 5);
        // 判断结果是否为非Null
        assertNotNull(new Junit());
        // 判断结果为数组并与期望数组的每个元素的值均相等
        assertArrayEquals(new int[]{1, 2, 3}, new int[]{1, 2, 3});

        // 浮点数比较，由于浮点数无法精确地进行比较，所以需要指定一个误差值
        assertEquals(0.1, Math.abs(1 - 9 / 10.0), 0.0000001);
    }

    @Test
    void exceptionTest() {

        // 异常测试（原始写法~
        assertThrows(IllegalArgumentException.class, new Executable() {
            @Override
            public void execute() throws Throwable {
                int res = junit.divide(5, 0);
            }
        });

        // 异常测试（函数式编程写法~
        assertThrows(IllegalArgumentException.class, () -> {
            int res = junit.divide(5, 0);
        });

    }

    @Test
    void add() {
        assertEquals(5, junit.add(2, 3), "加法有问题"); // message：如果断言失败，给定的错误信息。
    }

    @Test
    void subtract() {
        assertEquals(5, junit.subtract(6, 1), "减法有问题");
    }

    @Test
    void multiply() {
        assertEquals(10, junit.multiply(2, 5), "乘法有问题");
    }

    @Test
    void divide() {
        assertEquals(2, junit.divide(10, 5), "除法有问题");
    }

    @Disabled
    @Test
    void testDisable() {
        // 条件测试，屏蔽@Disabled标定的函数，使其不执行。
        assertEquals(5, junit.add(2, 3), "加法有问题"); // message：如果断言失败，给定的错误信息。
    }

    @Test
    @EnabledOnOs(OS.MAC)
    void testMac() {
        System.out.println("在 Mac 系统之上运行~");
    }

    @Test
    @EnabledOnOs({OS.MAC, OS.WINDOWS})
    void testMacOrWindows() {
        System.out.println("在 Mac 或者 Windows 系统之上运行~");
    }

    @Test
    @DisabledOnOs(OS.WINDOWS)
    void testOnNonMacWindows() {
        System.out.println("在 非windows 系统之上运行~");
    }

    @Test
    @EnabledOnJre(JRE.JAVA_13)
    void testOnJava13OrAbove() {
        System.out.println("在 JRE的版本为Java13 的系统之上运行~");
    }

    @Test
    @EnabledIfEnvironmentVariable(named = "DEBUG", matches = "false")
    void testOnlyOnDebugMode() {
        // this test is only run on DEBUG=true
        // Environment variable [DEBUG] does not exist（环境变量若不存在则不会满足执行条件~
        System.out.println("环境变量\"DEBUG\"的值匹配\"false\"~");
    }

    @Test
    @EnabledIfSystemProperty(named = "os.arch", matches = ".*64.*")
    void testOnlyOn64bitSystem() {
        // this test is only run on 64 bit system
        System.out.println("当前系统为64位架构~");
    }

    @Test
    @EnabledIf("java.time.LocalDate.now().getDayOfWeek()==java.time.DayOfWeek.SUNDAY")
    void testOnlyOnSunday() {
        // this test is only run on Sunday
        // Script `java.time.LocalDate.now().getDayOfWeek()==java.time.DayOfWeek.SUNDAY` evaluated to: false（因为今天是周六，所以不满足条件~
        System.out.println("今天是星期天~");
    }

    /*@Test(timeout = 500)  // 单位为ms,注：Junit5中的@Test没有参数了，暂不清楚替代方案是什么？
    public void testOverTime() {

    }*/
    @Test
    public void testOverTime() {
        // ToDo: 增加测试超时的测试用例
    }

    @ParameterizedTest
    @MethodSource
    void testCapitalize_01(String input, String result) {
        assertEquals(result, Junit.capitalize(input));
    }

    static List<Arguments> testCapitalize_01() {
        // 通过@MethodSource注解，它允许我们编写一个同名的静态方法来提供测试参数
        return List.of( // arguments:
                Arguments.arguments("abc", "Abc"), //
                Arguments.arguments("APPLE", "Apple"), //
                Arguments.arguments("gooD", "Good"));
    }

    @ParameterizedTest
    @CsvSource({"abc, Abc", "APPLE, Apple", "gooD, Good"})
    void testCapitalize_02(String input, String result) {
        assertEquals(result, Junit.capitalize(input));
    }

    // 当测试数据过多的时候，可以采用引入外部文件的方式
    /*@ParameterizedTest
    @CsvFileSource(resources = { "/test-capitalize.csv" })
    void testCapitalizeUsingCsvFile(String input, String result) {
        assertEquals(result, StudyJunit.capitalize(input));
    }*/

    @ParameterizedTest
    @ValueSource(strings = {"racecar", "radar", "able was I ere I saw elba"})
    void testCapitalize_02(String candidate) {
        // 参数化测试
        assertTrue(candidate.length() > 0);
    }

    // @DisplayName:
    // 测试类和测试方法可以声明自定义显示名称——带有空格、特殊字符甚至表情符号（自定义显示名称，是在运行时显示在【测试结果栏】的名称~
    @Test
    @DisplayName("Custom test name containing spaces")
    void testWithDisplayNameContainingSpaces() {
        // 测试方法的自定义显示名称，包含空格
    }

    @Test
    @DisplayName("╯°□°）╯")
    void testWithDisplayNameContainingSpecialCharacters() {
        // 测试方法的自定义显示名称，包含特殊字符
    }

    @Test
    @DisplayName("��")
    void testWithDisplayNameContainingEmoji() {
        // 测试方法的自定义显示名称，包含表情符号
    }

    // @RepeatedTest:
    // 定义测试方法重复运行
    @RepeatedTest(10)
    void repeatedTest() {
        // 本测试方法一共运行 10 次~
    }

    @RepeatedTest(5)
    void repeatedTestWithRepetitionInfo(RepetitionInfo repetitionInfo) {
        // 拿到本测试方法的指定的重复运行次数
        assertEquals(5, repetitionInfo.getTotalRepetitions());
    }

    @RepeatedTest(value = 1, name = "{displayName} {currentRepetition}/{totalRepetitions}")
    @DisplayName("Repeat!")
    void customDisplayName(TestInfo testInfo) {
        assertEquals(testInfo.getDisplayName(), "Repeat! 1/1");
    }

    @RepeatedTest(value = 1, name = RepeatedTest.LONG_DISPLAY_NAME)
    @DisplayName("Details...")
    void customDisplayNameWithLongPattern(TestInfo testInfo) {
        assertEquals(testInfo.getDisplayName(), "Details... :: repetition 1 of 1");
    }

    @RepeatedTest(value = 5, name = "Wiederholung {currentRepetition} von {totalRepetitions}")
    void repeatedTestInGerman() {
        // ...
    }
}
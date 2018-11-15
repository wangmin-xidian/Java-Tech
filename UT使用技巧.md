*********************************************************
**1. 怎样确保UT方法按顺序执行？**    2018/11/15
********************************************************
平时最常使用的UT框架有JUnit和TestNG，那这两种框架下，如何保证测试用例按顺序执行呢？
- JUnit 
  在UT类上使用JUnit的注解`@FixMethodOrder`来控制方法执行顺序。 在枚举类`org.junit.runners.MethodSorters`中定义了三种执行顺序：
  - **MethodSorters.JVM** ： 按照JVM得到方法的顺序，即代码中方法定义的顺序
  - **MethodSorters.DEFAULT** ： 按确定但不可预期的顺序
  - **MethodSorters.NAME_ASCENDING** ： 按方法名的字母顺序

- TestNG
  TestNG中，有多种方式可以实现用例方法的顺序执行，包含以下方式：
    - 在方法上使用**priority参数**配置注解Test， `@Test(enabled = false, priorty = 0)`，数字越小，越小执行
    - TestNG的默认执行顺序是根据**方法名字母顺序**，基于此，可使用命名方式让方法按顺序执行 
    - 在TestNG.xml的**配置文件**中利用`preserve-order`,`include/exclude`等来定义执行顺序   
      preserve-order：用来控制<test>里面所有<classes>的执行顺序。<test>中的preserve-order为true，表示<test>下所有<classes>按照顺序执行。methods中的方法也是按include的顺序执行。
     
 ```xml
  <suite name="suite1">
    <test name="test" preserve-order="true">
      <classes>
        <class name="com.pack.ClassTwo">
          <methods>
            <include name="TestB"/>
            <include name="TestA"/>
          </methods>
        <class name="com.pack.ClassThree">
        <class name="com.pack.ClassOne">
      </classes>
    </test>
  </suite>
 ```  

*******************************************
**Spring AOP的理解 **  2018/11/14
**************************************
- **AOP的定义**         
	AOP，Aspect Oriented Programming，面向切面编程。通过预编译的方式和运行期动态代理实现程序功能的统一维护的一种技术。    
	利用AOP可以对业务逻辑的各个部分进行隔离，从而使得业务逻辑各部分之间的耦合度降低，提高程序的可重用性，同时提高了开发的效率。

- **AOP原理**        
	- 采用动态代理的技术，利用截取消息的方式，对该消息进行装饰，以取代原有对象行为的执行；
  - 采用静态织入的方式，引入特定的语法创建切面，从而使得编译器可以在编译期间织入有关切面的代码
	
  **AOP思想实现的技术有Spring AOP和AspectJ** 	   
  - AspectJ ： 底层技术是静态代理，即用一种AspectJ支持的特定语言编写切面，通过一个命令来编译，生成一个新的代理类，该代理类增强了业务类，这是在编译时增强，相对于运行期增强，编译器增强的性能更好。
  - Spring AOP ： 采用的是动态代理技术，在运行期间对业务方法进行增强，所以不会产生新类，对于动态代理技术，Spring AOP提供了对JDK动态代理和CGLib的支持。    
  动态代理：    
	  - JDK动态代理只能为接口创建动态代理实例，而不能对类创建动态代理，需要获得被代理的目标类的接口信息（利用Java的反射技术），生成一个实现了代理接口的动态代理类（字节码），再通过反射机制获得动态代理类的构造函数，利用构造函数生成动态代理类的实例对象，在调用具体方法前调用invokeHandler方法来处理。
	  - CGLib动态代理需要依赖asm包，把被代理对象类的class文件加载进来，修改器字节码生成子类。但Spring AOP基于注解配置的情况下，需要依赖于AspectJ包的标准注解，但不需要额外的编译以及AspectJ的织入器，而基于XML配置不需要。
	
	
- **AOP相关概念**       
	- **切面Aspect** ： 一个关注点的模块化，    
	- **连接点JoinPoint** ： 程序执行过程中明确的点，如方法的调用或特定的异常被抛出        
	- **通知Advice** ： 在特定的连接点，AOP框架执行的动作。	  
	- **切入点PointCut** ： 指定一个通知将被引发的一系列连接点的稽核。    
	- **织入Weaving** ： 织入切面来创建一个呗告知对象，可以在编译期完成（AspectJ），也可以在运行期（Spring AOP）完成。   

	
- **Spring AOP 实现方式**    
  - **XML配置文件**	    
		大概有四种方式：  
		1.  配置ProxyFactoryBean，显式地设置advisors, advice, target等   
		2. 配置AutoProxyCreator，这种方式下，还是如以前一样使用定义的bean，但是从容器中获得的其实已经是代理对象   
		3. 通过<aop:config>来配置   
		4. 通过<aop: aspectj-autoproxy>来配置，使用AspectJ的注解来标识通知及切入点  
		
```xml 
    <!--被代理的目标对象 -->
    <bean id="math" class="com.min.aop.proxy.Math"></bean>
    <!-- 通知 -->
    <bean id="advice" class="com.min.aop.Advices"></bean>
    <!-- AOP配置 -->
    <!-- proxy-target-class属性表示被代理的类是否为一个没有实现接口的类，Spring会依据实现了接口则使用JDK内置的动态代理，如果未实现接口则使用cblib -->
    <aop:config proxy-target-class="true">
        <!-- 切面配置 -->
        <!--ref表示通知对象的引用 -->
        <aop:aspect ref="advice">
            <!-- 配置切入点(横切逻辑将注入的精确位置) -->
            <aop:pointcut expression="execution(* com.min.aop.proxy.Math.*(..))" id="pointcut1"/>
            <!--声明通知，method指定通知类型，pointcut指定切点，就是该通知应该注入那些方法中 -->
            <aop:before method="before" pointcut-ref="pointcut1"/>
            <aop:after method="after" pointcut-ref="pointcut1"/>
            <aop:around method="around" pointcut="execution(* com.min.aop.proxy.Math.s*(..))"/>
            <aop:after-throwing method="afterThrowing" pointcut="execution(* com.min.aop.proxy.Math.d*(..))"  throwing="exp"/>
            <aop:after-returning method="afterReturning" pointcut="execution(* com.min.aop.proxy.Math.m*(..))" returning="result"/>
        </aop:aspect>
    </aop:config>	
```			
  - **注解方式**   
      重点注解有如下：    
 ```java     
     @Aspect 
     @PointCut("execution(* com.min.aop.proxy.Math.*(..))")
     @Before("pointcut()")
     @After("pointcut()")
     @Around("execution(* com.min.aop.proxy.Math.s*(..))")
     @AfterReturing("execution(* com.min.aop.proxy.Math.m*(..))")
     @AfterThrowing("execution(* com.min.aop.proxy.Math.d*(..))")    
```


     
     





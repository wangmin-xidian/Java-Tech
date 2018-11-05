**Spring Bean 生命周期**
****************************************
**Spring IOC容器管理Bean的生命周期**  

	1. 通过构造器或者工厂方法创建bean实例；
	2. 为bean的属性赋值和对其他bean的引用；
	3. 调用Bean的初始化方法
	4. bean初始成功，可以使用
	5. 容器关闭时，调用bean的销毁方法。
  
  
**BeanFactory和ApplicationContext作用和关系**

*作用*

	1. BeanFactory负责读取Bean配置文件，管理Bean的加载，实例化，维护Bean之间的依赖关系，负责Bean的生命周期；
	2. ApplicationContext除了提供上述BeanFactory的功能外，还提供了更完整的框架功能，是BeanFactory的扩展。
	-	国际化支持；
	-	资源访问；
	-	事件传递：通过实现ApplicationContextAware接口
	3. Spring IoC容器就是一个实现了BeanFactory接口的实例化类，Spring提供了两种不同的容器，即以上两种。
	4. ApplicationContext常用的的子类：
	-	FileSystemXmlApplicationContext;
	-	ClassPathXmlApplicationContext;
	-	WebApplicationContextUtils

*关系*

	1. ApplicationContext是BeanFactory的子类；
	2. BeanFactory在初始化容器时，并未实例化Bean，直到第一次访问某个Bean时才实例化Bean；
	3. ApplicationContext则在初始化上下文时就实例化了所有的单实例的Bean
	
	



*******************************************************
**Spring Bean 生命周期**                2018/11/05
*******************************************************
**Spring IOC容器管理Bean的生命周期**  

	1. 通过构造器或者工厂方法创建bean实例；
	2. 为bean的属性赋值和对其他bean的引用；
	3. 调用Bean的初始化方法
	4. bean初始成功，可以使用
	5. 容器关闭时，调用bean的销毁方法。
  
  
**BeanFactory和ApplicationContext作用和关系**
- 作用

1. BeanFactory负责读取Bean配置文件，管理Bean的加载，实例化，维护Bean之间的依赖关系，负责Bean的生命周期；
2. ApplicationContext除了提供上述BeanFactory的功能外，还提供了更完整的框架功能，是BeanFactory的扩展。
 	- 国际化支持；
 	- 资源访问；
 	- 事件传递：通过实现ApplicationContextAware接口
3. Spring IoC容器就是一个实现了BeanFactory接口的实例化类，Spring提供了两种不同的容器，即以上两种。
4. ApplicationContext常用的的子类：
 	- FileSystemXmlApplicationContext;
 	- ClassPathXmlApplicationContext;
 	- WebApplicationContextUtils

- 关系 
1. ApplicationContext是BeanFactory的子类；
2. BeanFactory在初始化容器时，并未实例化Bean，直到第一次访问某个Bean时才实例化Bean；
3. ApplicationContext则在初始化上下文时就实例化了所有的单实例的Bean

******************************************************	 	
**BeanFactory & FactoryBean的关系**       2018/11/13
******************************************************	  
Spring 的Bean有两种，一种是普通的bean，一种是FactoryBean，两者都是由IOC容器来管理的。FactoryBean可以说为IOC容器中Bean的实现提供了更加灵活的方式，FactoryBean在IOC容器的基础上给Bean的实现加上了一个简单工厂模式和装饰模式，我们可以在getObject()方法中灵活配置。

- BeanFactory    
	- 以Factory结尾，表示它是一个`工厂类(接口)`， 它负责`生产和管理bean`的一个工厂。在Spring中，BeanFactory是IOC容器的核心接口。     
	- 它的职责包括：实例化、定位、配置应用程序中的对象及建立这些对象间的依赖。     
	- BeanFactory只是个接口，并不是IOC容器的具体实现，但是Spring容器给出了很多种实现，如 DefaultListableBeanFactory、XmlBeanFactory、ApplicationContext等，其中XmlBeanFactory就是常用的一个，该实现将以XML方式描述组成应用的对象及对象间的依赖关系。XmlBeanFactory类将持有此XML配置元数据，并用它来构建一个完全可配置的系统或应用。   

- FactoryBean   
	- 一般情况下，Spring通过反射机制利用<bean>的class属性指定实现类实例化Bean，在某些情况下，实例化Bean过程比较复杂，如果按照传统的方式，则需要在<bean>中提供大量的配置信息。配置方式的灵活性是受限的，这时采用编码的方式可能会得到一个简单的方案。       
	- Spring为此提供了一个org.springframework.bean.factory.FactoryBean的工厂类接口，用户可以通过实现该接口`定制实例化Bean的逻辑`。FactoryBean接口对于Spring框架来说占用重要的地位，Spring自身就提供了70多个FactoryBean的实现。  
	- 它们隐藏了实例化一些复杂Bean的细节，给上层应用带来了便利。从Spring3.0开始，FactoryBean开始支持泛型，即接口声明改为FactoryBean<T>的形式。         
	 - 以Bean结尾，表示它是一个`Bean`，不同于普通Bean的是：它是`实现了FactoryBean<T>接口的Bean`，`根据该Bean的ID从BeanFactory中获取的实际上是FactoryBean的getObject()返回的对象，而不是FactoryBean本身`，如果要获取FactoryBean对象，请在id前面加一个&符号来获取。


- 总结        
1. BeanFactory是一个IOC基础容器。
2. FactoryBean是一个Bean，不是一个普通Bean，是一个工厂Bean。 
3. FactoryBean实现与工厂模式和装饰模式类似。
4. 通过转义符&来区分获取FactoryBean产生的对象和FactoryBean对象本身（FactoryBean实现类）。







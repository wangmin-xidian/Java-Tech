******************************************
**天猫研发4面题目**  2018/11/26
*****************************************
**一面**
 1. 常见集合类的区别和适用场景 
    > [Collection/Map常见集合类说明](https://github.com/wangmin-xidian/Java-Tech/blob/master/collections/%E5%B8%B8%E8%A7%81%E9%9B%86%E5%90%88%E7%B1%BB%E7%9A%84%E7%90%86%E8%A7%A3.md)
    
 2. 并发容器了解哪些  
    > [7大并发容器说明](https://github.com/wangmin-xidian/Java-Tech/blob/master/collections/%E5%B9%B6%E5%8F%91%E5%AE%B9%E5%99%A8%E7%9A%84%E7%90%86%E8%A7%A3.md)
  
 3. 如何判断链表是否有环？
    > 最优方法：快慢指针。定义两个指针，分别指向head,然后设置不同的步长开始遍历，若快慢指针能相遇，则表示有环。
  
 4. ConcurrentHashMap如何实现 
    > [ConcurrentHashMap的实现原理(JDK1.7和JDK1.8)](http://youzhixueyuan.com/concurrenthashmap.html)
 
 5. 集群服务器如何application共享  
 
 6. JVM网络编程中：BIO、NIO、AIO的区别和联系  
    > [NIO、BIO、AIO的区别，及NIO的应用和框架选型](http://youzhixueyuan.com/java-nio-introduce.html)

 7. JVM内存模型   
    > [深入详解JVM内存模型与JVM参数详细配置](http://youzhixueyuan.com/jvm-memory-model-and-parameter-configuration.html)

 8. Java的垃圾回收，标记算法和复制算法的区别，用在什么场合  
    > [JVM的4种垃圾回收算法、垃圾回收机制与总结](http://youzhixueyuan.com/jvm-garbage-collection-algorithm.html)
    
 9. HTTP和HTTPS的区别，HTTP1.x和HTTP2.x的区别，SSL和TSL的区别 
    > [Http/Https, Http1.x&Http2.x区别](https://github.com/wangmin-xidian/Java-Tech/blob/master/Http1.x%2B2.x%E5%8F%8AHttps%E5%8C%BA%E5%88%AB.md)
 
 10. GC、G1和ZGC的区别  
 
 11. B+树和B树的区别，和红黑树的区别    
    > 先了解下AVL树（平衡二叉树），再理解B、B+、红黑树会更好理解。[参考](https://github.com/wangmin-xidian/Java-Tech/blob/master/AVL%E5%B9%B3%E8%A1%A1%E6%A0%91%E7%9A%84%E7%90%86%E8%A7%A3.md)
    
 12. 内存泄露与内存溢出的区别 
 
 13. session生命周期是多久
    
**二面**
1. Java CAS原理
2. Java线程池有哪些参数，若涉及一个线程池要考虑哪些问题
3. Java的lock的底层实现
4. MySQL数据库默认存储引擎，有什么优点
5. MySQL的事务隔离级别是什么，分别解决什么问题
6. 四个表，记录成绩，每个大约十万条记录，如何找到成绩最好的同学
7. 常见的均衡负载算法有哪些
8. 如何Redis有1亿的key，使用keys命令是否会影响线上服务
9. Redis的持久化方式，aod和rdb，具体怎么实现，追加日志和备份文件，底层实现的原理了解否

**三面** 
1. 请画一个完整大型网站的分布式服务器集群部署图
2. 多个RPC请求进来，服务器怎么处理并发
3. 讲一下Redis的哨兵机制
4. 数据库分库分表一般数据库多大才需要     
    > [分库分表&读写分离的理解](https://github.com/wangmin-xidian/Java-Tech/blob/master/%E6%95%B0%E6%8D%AE%E5%BA%93%E5%88%86%E5%BA%93%E5%88%86%E8%A1%A8.md)

5. 如何保证数据库与Redis缓存一致的
6. 项目中消息队列怎么用的，使用哪些具体业务场景
7. JVM相关的分析工具有使用过哪些，具体的性能调优步骤   
    > 1. [4大JVM性能分析工具详解，及内存泄漏分析方案](http://youzhixueyuan.com/jvm-performance-analysis-tool.html)      
    > 2. [JVM性能调优的6大步骤，及关键调优参数详解](http://youzhixueyuan.com/jvm-performance-optimization.html)   

8. MySQL的慢sql优化一般如何做，是否还有方法优化
9. 线上的服务器监控指标，哪些最需要关注，原因是什么
10. 如何做压力测试，抗压手段有哪些
11. 秒杀模块怎么设计的

**HR面**
1. 自我介绍
2. 怎么评价之前的面试
3. 怎么看待自己，最大的核心竞争力是什么
4. 未来自己的职业规划
5. 对阿里技术氛围有什么的理解，用过哪些阿里开源库
6. 期望薪资
7. 有什么想要了解的










*******************************************
**SOFA学习**   2019-01-28
********************************************
**SOFA - Scalable Open Financial Architecture**     
[蚂蚁金服微服务实践-余淮.pdf](https://www.sofastack.tech/posts/2018-12-17-01)

**[SOFAStack](https://www.sofastack.tech/)**         
> SOFAStack（Scalable Open Financial Architecture Stack）    
> SOFA中间件是金融级分布式中间件，包含了构建金融级云原生架构所需的各个组件，包括微服务研发框架，RPC框架，服务注册中心，分布式定时任务，限流/熔断框架，动态配置推送，分布式链路跟踪，Metrics监控度量，分布式高可用消息队列，分布式事务框架，分布式数据库代理层等组件。

**LandScape**
- 开发框架：[SOFABoot](https://github.com/alipay/sofa-boot)
- RPC框架：[SOFARPC](https://github.com/alipay/sofa-rpc)
- 服务发现：SOFARegisty
- 动态配置：DRM
- 熔断限流：Guardian
- 服务管控台：SOFAAdmin
- 定时任务：Scheduler
- 消息：ANTQ
- ServieMesh: [SOFAMesh](https://github.com/alipay/sofa-mesh), [SOFAMosn](https://github.com/alipay/sofa-mosn)
- 网关： MOSNG
- 监控度量：[SOFALookout](https://github.com/alipay/sofa-lookout)，OCS
- 分布式跟踪：[SOFATracer](https://github.com/alipay/sofa-tracer)，OCS
- 测试框架：ACTS
- DTX：分布式事务
- 分库分表： ZDAL，DBP

**SOFAStack 开源组件**
- [SOFABoot](https://github.com/alipay/sofa-boot)
  > - SOFABoot是基于Spring Boot的开发的框架。  
  > - 在完全兼容Spring Boot的基础上，SOFABoot还提供了启动监控检查、上下文隔离、模块化开发、类隔离、日志空间隔离等功能。    
  > - 同时SOFAStack提供的很多组件，例如RPC框架、动态配置、消息框架、分布式事务等组件都已经集成到SOFABoot中。
- [SOFARPC](https://github.com/alipay/sofa-rpc)
   > - SOFARPC是一个高可扩展性、高性能、生产级别的Java RPC框架。    
   > - SOFARPC致力于简化应用之间的RPC调用，为应用提供方便透明、稳定高效的点对点远程服务调用方案。   
   > - 为了用户和开发者方便的进行功能扩展，SOFARPC提供了丰富的模型抽象和可扩展接口，包括过滤器、路由、负载均衡等，同时围绕SOFARPC框架及其周边组件提供丰富的微服务治理方案。 
- [SOFAMesh](https://github.com/alipay/sofa-mesh)
   > - 基于Istio改进和扩展的Service Mesh大规模落地实践方法。  
   > - 在继承Istio强大功能和丰富特性的基础上，为满足大规模部署下的性能要求以及应对落地实践中的实际情况，有如下改进：   
      1. 采用Golang编写的MOSN取代Envoy   
      2. 合并Mixer到数据平面以解决性能瓶颈    
      3. 增加Pilot已实现更灵活的服务发现机制    
      4. 增加对SOFARPC、Dubbo、HSF等的支持    
- [SOFAMosn](https://github.com/alipay/sofa-mosn)   
  > - SOFAMosn全名 Modular Observable Smart Network，可作为SOFAMesh中的数据平面Sidecar，也可独立部署使用。
  > - 使用Go语言编写，兼容Envoy的API，可以与Istio集成。支持HTTP1.1/2.0、SOFARPC和Dubbo协议。
- [SOFATracer](https://github.com/alipay/sofa-tracer) 
  > - SOFATracer是一个用于分布式系统调用跟踪的组件。
  > - 通过统一的TraceId将调用链路中的各种网络调用情况以日志的方式记录下来，以达到透视化网络调用的目的。这些链路数据可用于故障的快速发现、服务治理等。
  > - 为了解决在实施大规模微服务架构时的链路跟踪问题，SOFATracer基于OpenTracing规范并扩展其能力，包括基于Disruptor高性能无锁循环队列的异步落地磁盘的日志打印能力，自定义日志格式，日志自清楚和滚动能力，基于SLF4J MDC的扩展能力，统一的配置能力等。
  > - 同时SOFATracer也对接了开源生态，可以选择Tracer数据对接到ZIPkin等开源产品做链路展示。
- [SOFALookout](https://github.com/alipay/sofa-lookout)
  > - SOFALookout是一个利用多维度的Metrics对目标系统进行度量和监控的项目。SOFALookout的多维度metrics参考Metrics2.0标准。SOFALookout项目分为客户端部分与服务器端部分。     
      1. 客户端是一个Java的类库，可以将它植入应用代码中采集Metrics信息，客户端更多详情等     
      2. 服务器端通过SOFALookout的服务，可以对Metrics数据进行收集、加工、存储和查询等处理，并结合Grafana，可做数据可视化展示。



**SOFARPC**
- **SOFARPC与Dubbo对比**
  - Dubbo 是阿里集团开源的一款非常优秀的RPC框架，高性能，具有良好的扩展性。Dubbo在国内开源界起步较早，使用者较多，开源生态更加丰富，目前已进入Apache基金会进行孵化。Dubbo最早在阿里巴巴B2B部门广泛使用。更多信息这里就不多介绍了。

  - SOFARPC 最早起源于阿里集团内部的 HSF，但是经过了蚂蚁金服集团内部多年的独立发展，目前脱离为一个独立的产品。SOFARPC 在协议，网络，路由，可扩展性等层面都进行了大量的改造和优化的工作，以满足蚂蚁金服大规模金融级的业务场景。在蚂蚁金服内部，SOFARPC 在蚂蚁中间件（SOFAStack）的生态下，有完善的微服务技术栈支持，包括微服务研发框架，RPC 框架，服务注册中心，分布式定时任务，限流/熔断框架，动态配置推送，分布式链路追踪，Metrics监控度量等等。截止 2017 年双十一，SOFARPC 已经被蚂蚁几千个系统所使用，生产环境发布的接口数量超过了几万。

  - 但是在开源领域，SOFARPC 目前还是一个起步阶段，开源生态还在建设当中，随着开源计划的推进，我们会在后续的版本里增加各个周边组件，完善微服务技术栈。同时也欢迎大家来贡献，共同打造 SOFAStack。

  - 对于性能的对比，类似协议下使用的技术点都是差不多的，所以基本上可比性不高。 对于扩展性的对比，两者都具有良好的扩展性。 对于其它功能差异点的话，这里列一些已经开源或者即将开源的功能点供参考：SOFARPC 协议上将支持 HTTP/2、GRPC，能力上如服务预热权重、自动故障降级、协商机制、CRC数据校验等，结合 SOFABoot 可以实现 RPC 框架与业务的类隔离防止类冲突等等，另外 SOFARPC 在跨单元机房的路由，包括配合服务注册体系实现的对异地多活的支撑也是非常有特色的，期望后面能逐步跟大家分享讨论，甚至形成行业标准。而 SOFARPC 结合内部微服务下做一致性的框架实现的「微交易」架构也是蚂蚁在金融领域非常有价值的沉淀，也是跟 dubbo 体系不一样的地方。
  
- **和Spring Cloud 的对比**
  - SOFARPC 定位在 RPC 框架，和 Spring Cloud 的比较不在一个对比维度上面。 Spring Cloud 可对比的是 SOFAStack，SOFAStack 是蚂蚁金服自主研发的金融级分布式中间件，包含了构建金融级云原生架构所需的各个组件，包括微服务研发框架，RPC 框架，服务注册中心，分布式定时任务，限流/熔断框架，动态配置推送，分布式链路追踪，Metrics监控度量，以及分布式高可用消息队列，分布式事务框架，分布式数据库代理层等组件，是一套分布式架构的完整的解决方案。SOFAStack 的各个组件会在未来逐渐开源。另外，SOFARPC 的 Starter 是基于 Spring Boot 开发的，Spring Cloud 的各个组件也是基于 Spring Boot 开发的，所以两者并不冲突。

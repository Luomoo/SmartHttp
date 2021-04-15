# SmartHttp

## 介绍

**SmartHttp** 是我模仿 Spring Boot 写的一个轻量级的 HTTP 框架。

**SmartHttp** 内置由 Netty 编写 HTTP 服务器，无需额外依赖 Tomcat 之类的 web 服务器。使用 Netty 几十行代码即可实现一个简易的 HTTP 服务，性能高且轻量。

## 特点

1. 内置由 Netty 编写 HTTP 服务器，无需额外依赖 Tomcat 之类的 web 服务
2. 代码简洁，可读性好
3. 支持 Spring MVC 常用的注解，用法也和 Spring MVC 基本一样
4. 后端只返回 json 数据给前端

## 框架基本情况和待办

### 功能实现

#### Get 请求和 POST 请求处理

- [ ] `@GetMapping` : 处理 Get 请求
- [ ] `@PostMapping` ：处理 Post 请求
- [ ] `@RequestBody` : 接收前端传递给后端的 json 字符串
- [ ] `@RequestParam` ：获取 Get 请求的 URL 查询参数
- [ ] `@PathVariable` : 获取 URL 中的参数/占位符

#### IOC

- [ ] `@Autowired` ：注入对象
- [ ] `@Component`：声明对象被 IOC 容器管理
- [ ] `@Qualifier`: 指定注入的bean

#### AOP

- [ ] `@Aspect`
- [ ] `@Pointcut`
- [ ] `@Before`
- [ ] `@After`
- [ ] `@Order`
- [ ] ......

#### 拦截器

- [ ] 支持拦截实现某个接口的所有 bean(基于 JDK 动态代理)
- [ ] 支持拦截某个没有实现任何接口的 bean（基于 CGLIB 动态代理）
- [ ] 支持全局拦截器（拦截所有 bean）
- [ ] 支持配置多个拦截器
- [ ] 支持自定义拦截器的执行顺序

#### 异常处理

- [ ] `@ControllerAdvice`
- [ ] `@ExceptionHandler`

#### 配置文件读取

- [ ] 支持读取 yaml 以及 properties 类型的文件

#### 其他

- [ ] `@SpringBootApplication`
- [ ] `@Configuration`

## 功能演示

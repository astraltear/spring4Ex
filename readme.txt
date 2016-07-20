Spring 4.0.0

## sample.spring.chapter01.bankapp
	getBean						

## sample.spring.chapter02
	factory method				 
	factory bean				

## sample.spring.chapter03
	property setting			 
	Properties setting
	xml util setting

## sample.spring.chapter03.bankapp
	bean parent 상속		 		
	factory method
	factory bean 
	constructor-arg

## sample.spring.chapter04.autowiring
	autowire byType				
	autowire constructor
	autowire byName

## sample.spring.chapter04.dependency
	scope prototype 설명(싱글턴, 프로토타입)	 
	constructor-arg

## sample.spring.chapter04.lookupmethod	
	scope prototype 활용 및 lookup-method		 	

## sample.spring.chapter04.replacedmethod
	scope prototype 활용 및 replaced-method	 

## sample.spring.chapter05.postconpredestroy
	@PostConstruct @PreDestroy 어노테이션 사용법	
	해당 기능을 사용하기 위해서는 xml설정이 필요하다
	registerShutdownHook

## sample.spring.chapter06
	<context:component-scan base-package=""/>	
	@Component("sample")
	@Value("#{configuration.environment}")
	@Autowired
	@Value("#{configuration.splitName('FirstName LastName')}"

## sample.spring.chapter07.database
	해당 패키지 intro.txt 파일 참조후 테스트할 것.
	
	<context:component-scan base-package="sample.spring.chapter07.database"/>
	<context:property-placeholder location="classpath:database.properties"/>
	@Repository
	@Service	
		
	apache dbcp
	jdbcTemplate
	namedJdbcTemplate
	txManager
	transactionTemplate
	
## sample.spring.chapter08.simpledb
	jdbc select, insert ,update,delte
	jdbcTemplate
	jdbcTemplateInsert
	RowMapper
	
## sample.spring.chapter09.aop
	<aop:aspectj-autoproxy proxy-target-class="false" expose-proxy="true"/>
	@Aspect
	@Pointcut(value="execution(* sample.spring.chapter09.aop.AopService.returnMethodCallThree(..))")  
	@AfterReturning(value="methodCallThree()", returning="aValue")  
	@After(value="aftterAdviceMethods()")
	@Around(value="execution(* sample.spring.chapter09..AopService2.*(..))")
	@Before(value="execution(* sample.spring.chapter09.aop.*Service.*(..))") 
	@Before(value="invokeServiceMethods()")  
	@AfterThrowing(value="exceptionMethods()", throwing="exception")  
	
	
Spring 4.2.4
AOP

## com.youngjee.springcore.first
	<constructor-arg
	<property name="restaurantWaitersList">
			<list>
				<value>Mr. A</value>
				<value>Mr. B</value>
				<value>Mr. C</value>
				<value>Mr. D</value>
				<value>Mr. E</value>
			</list>
		</property>
		
## com.youngjee.springcore.first2
	service, dao inject 주입 기본 샘플
	

## com.youngjee.springcore.beanlifecycle
	빈 생명주기
	init-method="init" destroy-method="destroy"/>
	@PostConstruct
	@PreDestroy	
	<bean class="org.springframework.context.annotation.CommonAnnotationBeanPostProcessor"/> 
	<context:annotation-config/> 	

## com.youngjee.springcore.beanpostprocessor
	사용자 정의  BeanPostProcessor 만들기
	BeanPostProcessor1 implements BeanPostProcessor	
	
## com.youngjee.springcore.factorybeanmethod
	factory method
		
## com.youngjee.springcore.lazyinit
	<bean id="secondBean" class="com.youngjee.springcore.lazyinit.Second" lazy-init="true">
	
## com.youngjee.springcore.prototype
	scope="prototype"/> 	
	
## 자바로 빈 설정하기 
	com.youngjee.springcore.di
	
## 빈 설정 파일 리로드, 환경설정 파일 읽기 
	com.youngjee.springcore.env	
	
## com.youngjee.springcore.beanlifecycle2
	<context:annotation-config></context:annotation-config>
	@PostConstruct
	@PreDestroy
	context.close();
	
## com.youngjee.springcore.property
	<context:property-placeholder location="admin.properties, sub_admin.properties"/>
	AnnotationConfigApplicationContext
	@Configuration
	빈 설정 동적 리로드 ConfigSwitchMain
	소스로 빈 설정 및 동적 리로드 SourcePropertySwitchMain
	
## AOP
	aspect: 공통기능
	advice: aspect 기능 자체 
	joinpoint: advice를 적용해야 하는 부분(메소드)
	pointcut: joinpoint의 부분으로 실제로 advice가 적용된 부분 
	
	<aop:before>			: 메소드 실행 전에 advice 실행
	<aop:after-returning>	: 정상적으로 메소드 실행 후에 advice 실행
	<aop:after-throwing>	: 메소드 실행 중에 exception 발생 시 advice실행
	<aop:after>				: 메소드 실행 중에 exception 발생하여도 advice실행
	<aop:around>			: 메소드 실행 전/후 및 exception 발생시 advice실행 
	
	<aop:aspectj-autoproxy/>
	@Aspect
	aspectj pointcut 표현식
	
	*	:	 모든
	.	:	현재
	..	:	0개 이상
	
	@Pointcut("execution(public void get*(..))")		public void 인 모든 get 메소드
	@Pointcut("execution(* com.javalec.ex.*.*())")		com.javalec.ex 패키지에 파라미터가 없는 모든 메소드
	@Pointcut("execution(* com.javalec.ex..*.*())")		com.javalec.ex 패키지 & com.javalec.ex 하위 패키지에 파라미터가 없는 메소드
	@Pointcut("execution(* com.javalec.ex.Worker.*())")	com.javalec.ex.Worker 안의 모든 메소드
	
	@Pointcut("within(com.javalec.ex.*)")				com.javalec.ex 패키지 안에 있는 모든 메소드
	@Pointcut("within(com.javalec.ex..*)")				com.javalec.ex 패키지 및 하위 패키지의 모든 메소드
	@Pointcut("within(com.javalec.ex.Worker)")			com.javalec.ex.Worker의 모든 메소드 
		
package com.simple.basic.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.mysql.cj.x.protobuf.MysqlxDatatypes.Array;
import com.simple.basic.controller.HomeController;
import com.simple.basic.util.UserAuthHandler;
import com.simple.basic.util.UserSuccessHandler;

@Configuration //개별적인 스프링 빈 설정 파일
public class WebConfig implements WebMvcConfigurer{

//   //빈을 보관하고 있는 장소(스프링 컨테이너)
//   @Autowired
//   ApplicationContext applicationContext;
//   
//   //properties파일에 선언된 변수를 바로 참조
//   @Value("${server.port}") //어플리케이션프로퍼티 변수명
//   String port;
//   
//   @Bean //해당 메서드 실행하게됨.
//   public void test() {
//      
//      TestBean t = applicationContext.getBean(TestBean.class);
//      t.hello();
//      
//      HomeController h = applicationContext.getBean(HomeController.class);
//      System.out.println(h);
//      
//      int c = applicationContext.getBeanDefinitionCount();
//      System.out.println("빈의 갯수: " + c);
//      
//      System.out.println("properties에 선언된 값: " + port);
//   }
//   
//   @Bean
//   public TestBean testBean() {
//      System.out.println("테스트 빈 실행됨2");
//      return new TestBean();
//   }
	
	@Bean
	public UserAuthHandler userAuthHandler() {
		return new UserAuthHandler(); //반환되는 값을 빈으로 등록
	}

	@Bean
	public UserSuccessHandler userSuccessHandler() {
		return new UserSuccessHandler();
	}
	
	//WebMvcConfigurer클래스가 제공해주는 인터셉터 추가 함수
	@Override
	public void addInterceptors(InterceptorRegistry registry) {

		registry.addInterceptor(userAuthHandler())
				/*.addPathPatterns(Arrays.asList("경로", "경로", "경로"))*/
				.addPathPatterns("/user/*") //패스경로 포함
				.excludePathPatterns("/user/login"); //패스경로 제외
		//경로별로 인터셉터를 다르게 등록가능
		registry.addInterceptor(userSuccessHandler())
				.addPathPatterns("/user/*");
		
	}
	
	
}

















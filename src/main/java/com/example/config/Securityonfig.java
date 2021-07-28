package com.example.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;


@EnableWebSecurity
@Configuration
public class Securityonfig extends WebSecurityConfigurerAdapter{
	
	@Autowired
	private UserDetailsService userDetailsService;
	
	@Bean
	public PasswordEncoder PasswordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	//セキュリティの対象外を設定
	@Override
	public void configure(WebSecurity web) throws Exception {
		web
			.ignoring()
				.antMatchers("/webjars/**")
				.antMatchers("/css/**")
				.antMatchers("/jd/**");
	}
	
	//各種セキュリティ設定
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		//ログイン不要ページの設定
		http
			.authorizeRequests()
				.antMatchers("/").permitAll()//直リンクOK
				.antMatchers("/admin/signup").permitAll()//
				.antMatchers("/admin").hasAuthority("ROLE_ADMIN")//権限制限
				.anyRequest().authenticated();//上以外は直リンク禁止
		//後で Apptop.htmlも直リンクOKに入れる。
		
		
		//ログイン処理
		http
			.formLogin()
				.loginProcessingUrl("/login")//ログイン処理のパス
				.loginPage("/")//ログインページの指定
				.failureUrl("/login?login")//ログイン失敗時の遷移先
				.usernameParameter("userId")//ログインページのユーザーID
				.passwordParameter("password")//ログインページのパスワード
				.defaultSuccessUrl("/admin/top", true);//ログイン成功時の遷移先
		
		//ログアウト処理
		http
			.logout()
				.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
				.logoutUrl("/logout")
				.logoutSuccessUrl("/login?logout");
		
//		http
//			.csrf().disable();	
	}
	
	//認証の設定
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		PasswordEncoder encoder = PasswordEncoder();
		
		//インメモリ内認証
//		auth
//			.inMemoryAuthentication()
//				.withUser("user@co.jp")//useを追加
//				.password(encoder.encode("user"))
//				.roles("GENERAL")
//			.and()
//				.withUser("admin@co.jp")//adminを追加
//				.password(encoder.encode("admin"))
//				.roles("ADMIN");
		
		//ユーザーデーター認証
		auth
			.userDetailsService(userDetailsService).passwordEncoder(encoder);
	}
	

}

package com.localeapp.i18n;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;

import java.util.Locale;


@SpringBootApplication
public class I18nApplication implements WebMvcConfigurer {

	private final LocaleChangeInterceptor localeChangeInterceptor;

    public I18nApplication(LocaleChangeInterceptor localeChangeInterceptor) {
        this.localeChangeInterceptor = localeChangeInterceptor;
    }
	@Override
	public void addInterceptors(InterceptorRegistry interceptorRegistry) {
		interceptorRegistry.addInterceptor(localeChangeInterceptor);
	}

    public static void main(String[] args) {
		ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
		messageSource.setBasename("lang/messages");
		messageSource.setDefaultEncoding("UTF-8");
		System.out.println(messageSource.getMessage("hello", null, Locale.ENGLISH));
		SpringApplication.run(I18nApplication.class, args);
	}

}

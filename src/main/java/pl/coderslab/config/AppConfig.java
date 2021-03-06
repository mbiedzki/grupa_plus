package pl.coderslab.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.format.FormatterRegistry;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalEntityManagerFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.servlet.LocaleContextResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import pl.coderslab.converter.*;

import javax.persistence.EntityManagerFactory;
import javax.validation.Validator;
import java.util.Locale;

@Configuration
@EnableWebMvc
@EnableJpaRepositories(basePackages = "pl.coderslab.repository")
@ComponentScan("pl.coderslab")
@EnableTransactionManagement
public class AppConfig extends WebMvcConfigurerAdapter {

    //view resolver
    @Bean
    public ViewResolver viewResolver() {
        InternalResourceViewResolver viewResolver =
                new InternalResourceViewResolver();
        viewResolver.setPrefix("/WEB-INF/views/app/");
        viewResolver.setSuffix(".jsp");
        return viewResolver;
    }

    //servlety
    @Override
    public void configureDefaultServletHandling(
            DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }

    //entity manager - persistence unit z META-INF
    @Bean
    public LocalEntityManagerFactoryBean entityManagerFactory() {
        LocalEntityManagerFactoryBean emfb = new LocalEntityManagerFactoryBean();
        emfb.setPersistenceUnitName("grupaPlusPersistenceUnit");
        return emfb;
    }

    //transaction manager
    @Bean
    public JpaTransactionManager transactionManager(EntityManagerFactory emf) {
        JpaTransactionManager tm = new JpaTransactionManager(emf);
        return tm;
    }

    //lokalizacja
    @Bean(name = "localeResolver")
    public LocaleContextResolver getLocaleContextResolver() {
        SessionLocaleResolver localeResolver = new SessionLocaleResolver();
        localeResolver.setDefaultLocale(new Locale("pl", "PL"));
        return localeResolver;
    }

    //walidacja
    @Bean
    public Validator validator() {
        return new LocalValidatorFactoryBean();
    }


    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addConverter(getCompanyConverter());
        registry.addConverter(getMainCoverConverter());
        registry.addConverter(getRiderConverter());
        registry.addConverter(getProductConverter());
        registry.addConverter(getUserConverter());
        registry.addConverter(getGroupConverter());
    }

    @Bean
    public CompanyConverter getCompanyConverter() {
        return new CompanyConverter();
    }

    @Bean
    public MainCoverConverter getMainCoverConverter() {
        return new MainCoverConverter();
    }

    @Bean
    public RiderConverter getRiderConverter() {
        return new RiderConverter();
    }

    @Bean
    public ProductConverter getProductConverter() {
        return new ProductConverter();
    }

    @Bean
    public UserConverter getUserConverter() {
        return new UserConverter();
    }

    @Bean
    public GroupConverter getGroupConverter() {
        return new GroupConverter();
    }

}

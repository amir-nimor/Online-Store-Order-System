package ir.maktabsharif.controller.lisenter;

import ir.maktabsharif.model.AddressUser;
import ir.maktabsharif.model.Product;
import ir.maktabsharif.model.User;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;
import ir.maktabsharif.repository.product.productRepositoryImpl;
import ir.maktabsharif.repository.user.userRepositoryImpl;
import ir.maktabsharif.service.user.userServiceImpl;
import ir.maktabsharif.service.product.productServiceImpl;

import java.math.BigDecimal;

@WebListener
public class Start implements ServletContextListener {


    @Override
    public void contextInitialized(ServletContextEvent sce) {
        productRepositoryImpl productRepository = new productRepositoryImpl();
        userRepositoryImpl userRepository = new userRepositoryImpl();

        userServiceImpl userService = new userServiceImpl(userRepository);
        productServiceImpl productService = new productServiceImpl(productRepository);


        productService.save(new Product("لپ‌تاپ گیمینگ", "لپ‌تاپ قدرتمند با گرافیک RTX 4060", new BigDecimal("45000000"), 10));
        productService.save(new Product("موس بی‌سیم", "موس ارگونومیک با دقت 1600DPI", new BigDecimal("850000"), 50));
        productService.save(new Product("کیبورد مکانیکی", "کیبورد RGB با سوییچ‌های آبی", new BigDecimal("2200000"), 25));
        productService.save(new Product("مانیتور 24 اینچ", "مانیتور IPS با رزولوشن Full HD", new BigDecimal("7500000"), 15));
        productService.save(new Product("هندزفری بلوتوث", "هندزفری با قابلیت حذف نویز فعال", new BigDecimal("1800000"), 40));
        productService.save(new Product("هارد اکسترنال", "هارد 1 ترابایت با سرعت انتقال بالا", new BigDecimal("3200000"), 20));
        productService.save(new Product("وب‌کم", "وب‌کم با کیفیت 1080p برای استریم", new BigDecimal("1500000"), 12));
        productService.save(new Product("پاوربانک", "پاوربانک 20000 میلی‌آمپر با فست شارژ", new BigDecimal("2100000"), 35));
        productService.save(new Product("پد موس", "پد موس بزرگ با کفی ضد لغزش", new BigDecimal("350000"), 100));
        productService.save(new Product("کابل HDMI", "کابل 2 متری با روکش کنفی", new BigDecimal("250000"), 80));



        userService.save(new User("علی رضایی", "09120000001", new AddressUser("تهران", "ولیعصر", "1234567891"), new BigDecimal("5000000"), "ali_r", "pass_123"));
        userService.save(new User("سارا احمدی", "09120000002", new AddressUser("اصفهان", "چهارباغ", "1234567892"), new BigDecimal("7500000"), "sara_a", "pass_123"));
        userService.save(new User("محمد کریمی", "09120000003", new AddressUser("شیراز", "زند", "1234567893"), new BigDecimal("3200000"), "mohamad_k", "pass_123"));
        userService.save(new User("فاطمه حسینی", "09120000004", new AddressUser("تبریز", "امام", "1234567894"), new BigDecimal("6100000"), "fatemeh_h", "pass_123"));
        userService.save(new User("رضا محمدی", "09120000005", new AddressUser("مشهد", "وکیل‌آباد", "1234567895"), new BigDecimal("4200000"), "reza_m", "pass_123"));
        userService.save(new User("نازنین مرادی", "09120000006", new AddressUser("کرج", "طالقانی", "1234567896"), new BigDecimal("8900000"), "nazanin_m", "pass_123"));
        userService.save(new User("حسین جعفری", "09120000007", new AddressUser("رشت", "گلسار", "1234567897"), new BigDecimal("2500000"), "hossein_j", "pass_123"));
        userService.save(new User("مریم اکبری", "09120000008", new AddressUser("اهواز", "نادری", "1234567898"), new BigDecimal("5400000"), "maryam_a", "pass_123"));
        userService.save(new User("امیر قاسمی", "09120000009", new AddressUser("قم", "صفاییه", "1234567899"), new BigDecimal("6800000"), "amir_q", "pass_123"));
        userService.save( new User("الهام موسوی", "09120000010", new AddressUser("یزد", "کاشانی", "1234567890"), new BigDecimal("3700000"), "elham_m", "pass_123"));


        sce.getServletContext().setAttribute("userService",userService);
        sce.getServletContext().setAttribute("productService",productService);
    }
}

package pl.coderslab.service;


import org.springframework.beans.factory.annotation.Autowired;
import pl.coderslab.model.Contract;
import pl.coderslab.util.Mailer;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.text.SimpleDateFormat;
import java.util.*;

@WebListener
public class AdminService implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {


        TimerTask emailAppStatus = new TimerTask() {
            public void run() {
                //get current time
                SimpleDateFormat time_formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm");
                String currentTime = time_formatter.format(System.currentTimeMillis());

                Mailer.send("mbiedzki@me.com", "",
                        "Grupa Plus - Server running - " + currentTime,
                        "Grupa Plus, server running", false);
            }

        };

        Timer timer = new Timer("Timer");

        // long delay = 1000L;
        long period = 1000L * 60L * 60L * 24L; // once per day
        timer.scheduleAtFixedRate(emailAppStatus, getSendTime(), period);
    }


    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        System.out.println("Shutting down!");
    }

    //get time for next scheduled email
    private static Date getSendTime() {
        Calendar tomorrow = new GregorianCalendar();
        // today plus 1 = tomorrow
        tomorrow.add(Calendar.DATE, 1);
        Calendar result = new GregorianCalendar(tomorrow.get(Calendar.YEAR),
                tomorrow.get(Calendar.MONTH), tomorrow.get(Calendar.DATE), 7,
                0);
        return result.getTime();
    }

}

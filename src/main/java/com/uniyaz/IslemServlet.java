package com.uniyaz;

import javax.servlet.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class IslemServlet implements Servlet {
   List<Person> personList = new ArrayList<>();

    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        System.out.println("Init metodu çalıştı");
    }

    @Override
    public ServletConfig getServletConfig() {
        System.out.println("ServletConfig metodu çalıştı");
        return null;
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        String tur = servletRequest.getParameter("tur");

        if(tur.equals("listele")){
            for (Person person : personList) {
                System.out.println(person.getAdi() + " " + person.getSoyadi());
                String html =person.getAdi() + " " + person.getSoyadi() + "\n";
                servletResponse.setCharacterEncoding("UTF-8");
                servletResponse.getWriter().write(html);
            }


        }
        if(tur.equals("kaydet")){
            String adi = servletRequest.getParameter("ad");
            String soyadi = servletRequest.getParameter("soyad");

            Person person = new Person(adi, soyadi);
            personList.add(person);
            System.out.println(person.getAdi() + " " + person.getSoyadi()+ " kişisi eklendi");

        }
    }

    @Override
    public String getServletInfo() {
        System.out.println("ServletInfo metodu çalıştı");
        return null;
    }

    @Override
    public void destroy() {
        System.out.println("Service metodu çalıştı");

    }
}

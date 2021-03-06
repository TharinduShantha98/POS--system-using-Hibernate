package util;

import entity.Customer;
import entity.Item;
import entity.Order;
import entity.OrderDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
public class FactoryConfiguration {

    private  static  FactoryConfiguration factoryConfiguration = null;
    private  SessionFactory sessionFactory;
    private FactoryConfiguration(){
        Configuration configuration = new Configuration().configure()
                .addAnnotatedClass(Item.class)
                .addAnnotatedClass(Order.class)
                .addAnnotatedClass(OrderDetail.class);
        sessionFactory = configuration.buildSessionFactory();
    }

    public  static FactoryConfiguration getInstance(){
        return (factoryConfiguration == null) ? factoryConfiguration = new FactoryConfiguration():factoryConfiguration;

    }

    public Session getSession(){
        return  sessionFactory.openSession();
    }




}

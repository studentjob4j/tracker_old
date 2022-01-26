package ru.job4j.config;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import java.sql.Timestamp;

/**
 * @author Shegai Evgenii
 * @since 27.01.2022
 * @version 1.0
 * Хибер создал таблицу - добавил запись - я изменил модель данных - хибер самостоятельго изменил
 * таблицу и добавил запись с новой колонкой
 */

public class HbmRun {

    public static void main(String[] args) {
        final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure().build();
        try {
            SessionFactory sf = new MetadataSources(registry)
                    .buildMetadata()
                    .buildSessionFactory();
            Session session = sf.openSession();
            session.beginTransaction();

            Car car = Car.of("Toyota", new Timestamp(1459510232000L), "Ivan Ivanov");
            session.save(car);

            session.getTransaction().commit();
            session.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            StandardServiceRegistryBuilder.destroy(registry);
        }
    }
}

package com;

import com.entities.Car;
import com.util.HibernateUtil;
import org.hibernate.Session;

import java.util.HashMap;
import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
/*        for (int i=0;i<10;i++){
            addCar(new Car(i,getRandomCar(),getRandomColor()));
        }*/
//       getAll().stream().forEach(System.out::println);

//         update(new Car(1,"a","b"));
//         update(new Car(0,"a","b"));

        deleteByID(3);

    }

    /*------------------------------------------------------*/
    public static void addCar(Car car){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.saveOrUpdate(car);
        session.getTransaction().commit();
        session.close();
        System.out.println("adding");
    }

    /*--------------------------------------------------------*/
    public static List<Car> getAll(){
      Session session = HibernateUtil.getSessionFactory().openSession();
      session.beginTransaction();
      List<Car> cars = session.createQuery("FROM Car").list();
      session.close();
      return cars;
    }

    /*----------------------------------------------------------*/
    public static void update(Car car){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Car car1 = (Car) session.load(Car.class,car.getId());
        car1.setColor(car.getColor());
        car1.setName(car.getName());
        session.getTransaction().commit();
        session.close();
        System.out.println("upd:"+car);

    }
/*--------------------------------------------------------------*/
    public static void deleteByID(Integer id){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Car car = findById(id);
        session.delete(car);
        session.getTransaction().commit();
        session.close();
        System.out.println("Succesfully delete");
    }
    /*----------------------------------------------------------------*/

    public static Car findById(Integer id){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Car car = (Car) session.load(Car.class,id);
        session.close();
        return car;
    }






    /*==================================================================*/
    static String getRandomCar(){
        int r = (int) (Math.random()*5);
        String name = new String [] {"honda","bmv","washing-machine","benz","bike","truck"}[r];
        return name;
    }
    static String getRandomColor(){
        int r = (int) (Math.random()*5);
        String name = new String [] {"red","white","ugay","black","green","puprle"}[r];
        return name;
    }

}

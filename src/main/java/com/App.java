package com;

import com.entities.*;
import com.util.HibernateUtil;
import org.hibernate.Session;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        Country country1 = new Country("Covidland");
        Country country2 = new Country("Virusiya");
        Country country3 = new Country("Italy");
        Country country4 = new Country("USA");

        List<Command> commands = new ArrayList<>();
        KindOfSport kindOfSport1 = new KindOfSport();
        KindOfSport kindOfSport2 = new KindOfSport();
        KindOfSport kindOfSport3 = new KindOfSport();

        Command command1 = new Command("team1","madrid.jpg","http//....",kindOfSport1);
        Command command2 = new Command("team2","nba.jpg","http//....",kindOfSport2);
        Command command3 = new Command("team3","teakwondo.jpg","http//....",kindOfSport3);
        commands.add(command1);
        commands.add(command2);
        commands.add(command3);


        kindOfSport3.setName("Taekwondo");
        kindOfSport3.setCommands(commands);
        kindOfSport2.setName("basketball");
        kindOfSport2.setCommands(commands);
        kindOfSport1.setName("football");
        kindOfSport1.setCommands(commands);

        List<KindOfSport> kindOfSports = new ArrayList<>();
        kindOfSports.add(kindOfSport1);
        kindOfSports.add(kindOfSport2);
        kindOfSports.add(kindOfSport3);


        Championship championship1 = new Championship("champ USA",country4,kindOfSports);
        Championship championship2 = new Championship("champ Virusiya",country2,kindOfSports);
        Championship championship3 = new Championship("champ Covidland",country1,kindOfSports);
        Championship championship4 = new Championship("champ italy",country3,kindOfSports);
        Championship championship5 = new Championship("champ italy",country3,kindOfSports);

        System.out.println(kindOfSports.get(0).getName());


/*        create(kindOfSport1);
        create(kindOfSport2);
        create(kindOfSport3);

        create(command1);
        create(command2);
        create(command3);

        create(championship1);
        create(championship2);
        create(championship3);
        create(championship4);
        create(championship5);*/

//        selectCommandByCountry().stream().forEach(x -> System.out.println(x));
//          selectCommandByCountry2().stream().forEach(x -> System.out.println(x));




          List<Championship> championship = selectCommandByCountry2();
          List<Championship> championships = selectCommandByCountry();
          championship.stream().forEach( x -> x.getKindOfSport().stream().map(s ->s.getName()).forEach(System.out::println));
          championship.stream().forEach(x -> x.getKindOfSport().stream().map(s ->s.getName()).filter(r -> r.equals("football")).forEach(System.out::println));
//          championship.forEach(x -> System.out.println(x));





/*          List <KindOfSport> kind = kindOfSports;
          Championship a = championships.stream()
                                  .filter(x -> x.getKindOfSport().get(0).getName().equals(kind.stream().map(k -> k.getName())))
                                  .findAny()
                                  .orElse(null);


          KindOfSport s = kind.stream()
                              .filter(x -> x.getName().equals(championships.stream().map(k -> k.getKindOfSport().get(0).getName())))
                              .findAny()
                              .orElse(null);*/

//       championships.stream().map(k -> k.getKindOfSport().get(0).getName()).forEach(System.out::println);


//        KindOfSport l = kindOfSports.stream().filter(x -> "football".equals(x.getName())).findAny().orElse(null);
    }

    public static Stream<Championship> sort(List<Championship> champ , String name){
        return champ
                .stream()
                .filter(x -> name.equals(x.getKindOfSport().stream().map(k -> k.getName())));
    }






    public static <T> void  create(T generic){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.saveOrUpdate(generic);
        session.getTransaction().commit();
        session.close();
        System.out.println("create");

    }

/*    public static List<Command> selectCommandSport() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<Command> commands = session.createQuery(" select c from KindOfSport c JOIN c.commands")
                .list();
        session.close();
        System.out.println("Найдено " + commands.size() + " отделов");
        return commands;
    }*/

    public static <T> List<T> selectCommandByCountry() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<T> commands = session.createQuery(" select c from Championship c JOIN c.kindOfSport JOIN c.country WHERE c.country.name = :p_nameCountry")
                .setParameter("p_nameCountry","Italy")
                .list();
        session.close();
        System.out.println("Найдено " + commands.size() + " отделов");
        return commands;
    }


    public static List<Championship> selectCommandByCountry2() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<Championship> championships = session.createQuery(" select c from Championship c WHERE c.country.name = :p_nameCountry")
                .setParameter("p_nameCountry","Italy")
                .list();
        session.close();
        System.out.println("Найдено " + championships.size() + " отделов");
        return championships;
    }


/*    public static List<Command> join2() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<Command> commands = session.createQuery(" select k from KindOfSport k JOIN c.championship ")
                .list();
        session.close();
        System.out.println("Найдено " + commands.size() + " отделов");
        return commands;
    }*/

/*    public static List<Command> getAllChampByCountryName(int id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<Command> commands = session.createQuery("select champ from Championship champ where champ.kindOfSport.id = :p_name").setParameter("p_name",id).list();
        session.close();
        System.out.println("Найдено " + commands.size() + " отделов");
        return commands;
    }*/


}

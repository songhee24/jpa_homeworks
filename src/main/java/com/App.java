package com;

import com.entities.Championship;
import com.entities.Command;
import com.entities.Country;
import com.entities.KindOfSport;
import com.util.HibernateUtil;
import org.hibernate.Session;

import java.util.ArrayList;
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
        Country country1 = new Country("Covidland");
        Country country2 = new Country("Virusiya");
        Country country3 = new Country("Italy");

        KindOfSport kindOfSport1 = new KindOfSport("Cyber sport");
        KindOfSport kindOfSport2 = new KindOfSport("Mk tourney");
        KindOfSport kindOfSport3 = new KindOfSport("Football");
        KindOfSport kindOfSport4 = new KindOfSport("BasketBall");

        Command command1 = new Command("team1","https://www.google.com/url?sa=i&url=https%3A%2F%2Fweareneon.com%2Fblog%2Fgetting-started-with-maven%2F&psig=AOvVaw1YzyWkjUTn_iBYofcavkKs&ust=1585305435659000&source=images&cd=vfe&ved=0CAIQjRxqFwoTCICZtI35t-gCFQAAAAAdAAAAABAD",
                "https://thewitcher.com/ru/",kindOfSport1);
        Command command2 = new Command("team2","https://www.google.com/url?sa=i&url=https%3A%2F%2Fweareneon.com%2Fblog%2Fgetting-started-with-maven%2F&psig=AOvVaw1YzyWkjUTn_iBYofcavkKs&ust=1585305435659000&source=images&cd=vfe&ved=0CAIQjRxqFwoTCICZtI35t-gCFQAAAAAdAAAAABAD",
                "https://football.ua/",kindOfSport2);
        Command command3 = new Command("team3","https://www.google.com/url?sa=i&url=https%3A%2F%2Fweareneon.com%2Fblog%2Fgetting-started-with-maven%2F&psig=AOvVaw1YzyWkjUTn_iBYofcavkKs&ust=1585305435659000&source=images&cd=vfe&ved=0CAIQjRxqFwoTCICZtI35t-gCFQAAAAAdAAAAABAD",
                "https://www.mortalkombat.com/",kindOfSport3);
        Command command4 = new Command("team4","https://www.google.com/url?sa=i&url=https%3A%2F%2Fweareneon.com%2Fblog%2Fgetting-started-with-maven%2F&psig=AOvVaw1YzyWkjUTn_iBYofcavkKs&ust=1585305435659000&source=images&cd=vfe&ved=0CAIQjRxqFwoTCICZtI35t-gCFQAAAAAdAAAAABAD",
                "https://www.php.net/manual/en/tutorial.php",kindOfSport3);
        Command command5 = new Command("team5","https://www.google.com/url?sa=i&url=https%3A%2F%2Fweareneon.com%2Fblog%2Fgetting-started-with-maven%2F&psig=AOvVaw1YzyWkjUTn_iBYofcavkKs&ust=1585305435659000&source=images&cd=vfe&ved=0CAIQjRxqFwoTCICZtI35t-gCFQAAAAAdAAAAABAD",
                "https://www.minecraft.net/ru-ru/download/server/",kindOfSport4);

        Championship championship1 = new Championship("champ1",country1,kindOfSport1);
        Championship championship2 = new Championship("champ2",country2,kindOfSport2);
        Championship championship3 = new Championship("champ3",country3,kindOfSport3);
        Championship championship4 = new Championship("champ4",country3,kindOfSport1);
        Championship championship5 = new Championship("champ5",country3,kindOfSport4);

        create(country1);
        create(country2);
        create(country3);
        create(kindOfSport1);
        create(kindOfSport2);
        create(kindOfSport3);
        create(kindOfSport4);
        create(command1);
        create(command2);
        create(command3);
        create(command4);
        create(command5);
        create(championship1);
        create(championship2);
        create(championship3);
        create(championship4);
        create(championship5);
    }

    public static <T> void  create(T generic){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.saveOrUpdate(generic);
        session.getTransaction().commit();
        session.close();
        System.out.println("create");

    }
}

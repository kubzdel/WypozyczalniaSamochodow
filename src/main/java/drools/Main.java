package drools;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.drools.compiler.compiler.DroolsParserException;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
public class Main {
    public static void main(String[] args) throws DroolsParserException,
            IOException {
        Main main = new Main();
        try {
            main.executeHelloWorldRules();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
    public void executeHelloWorldRules() throws IOException,
            DroolsParserException, ParseException {
        KieServices ks = KieServices.Factory.get();
        BasicConfigurator.configure();
        Logger.getLogger(Main.class).setLevel(Level.OFF);
        KieContainer kContainer = ks.getKieClasspathContainer();
        KieSession session = kContainer.newKieSession("ksession-rules");
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd");


        //Samochody

        Samochod samochod1 = new Samochod(Samochod.Kategoria.A);
        Samochod samochod2 = new Samochod(Samochod.Kategoria.A);
        Samochod samochod3 = new Samochod(Samochod.Kategoria.B);
        Samochod samochod4 = new Samochod(Samochod.Kategoria.D);
        Samochod samochod5 = new Samochod(Samochod.Kategoria.D);

        //Klient1
        Klient klient1 = new Klient();
        klient1.nazwa= "Klient1";
        klient1.lojalnosciowy= true;
        Rezerwacja rezerwacja1 = new Rezerwacja("Rezerwacja1",klient1,new Date(2016,11,11),new Date(2016,11,12),true,true);
        rezerwacja1.zwrot = new Zwrot(new Date(2016,11,12),0,false,66);
        rezerwacja1.setDlugosc();
        rezerwacja1.setOpoznienie();

        //Klient2
        Klient klient2 = new Klient();
        klient2.nazwa= "Klient2";

        Rezerwacja rezerwacja2 = new Rezerwacja("Rezerwacja2",klient2,new Date(2016,11,10),new Date(2016,11,13),
                Samochod.Kategoria.B,false,true);
        rezerwacja2.zwrot = new Zwrot(new Date(2016,11,13),0,false,100);
        rezerwacja2.setDlugosc();
        rezerwacja2.setOpoznienie();

        Rezerwacja rezerwacja3 = new Rezerwacja("Rezerwacja3",klient2,new Date(2016,11,11),new Date(2016,11,14),false,true);
        rezerwacja3.setDlugosc();

        //Klient3
        Klient klient3 = new Klient();
        klient3.nazwa = "Klient3";
        Rezerwacja rezerwacja4 = new Rezerwacja("Rezerwacja4",klient3,new Date(2016,11,11),new Date(2016,11,16),
                Samochod.Kategoria.B,false,false);
        rezerwacja4.zwrot = new Zwrot(new Date(2016,11,18),2,true,1000);
        rezerwacja4.setDlugosc();
        rezerwacja4.setOpoznienie();

        Klient klient4 = new Klient();
        klient4.nazwa = "Klient4";
        Rezerwacja rezerwacja5 = new Rezerwacja("Rezerwacja5",klient4,new Date(2016,11,14),new Date(2016,11,16),
                Samochod.Kategoria.B,false,false);
        rezerwacja5.zwrot = new Zwrot(new Date(2016,11,16),1,false,100);
        rezerwacja5.setDlugosc();
        rezerwacja5.setOpoznienie();

        Klient klient5 = new Klient();
        klient5.nazwa = "Klient5";
        klient5.lojalnosciowy=true;
        Rezerwacja rezerwacja6 = new Rezerwacja("Rezerwacja6",klient5,new Date(2016,11,11),new Date(2016,11,14),
                Samochod.Kategoria.A,false,true);
        rezerwacja6.zwrot = new Zwrot(new Date(2016,11,14),0,false,100);
        rezerwacja6.setDlugosc();
        rezerwacja6.setOpoznienie();









        session.insert(samochod1);
        session.insert(samochod2);
        session.insert(samochod3);
        session.insert(samochod4);
        session.insert(samochod5);
        session.insert(rezerwacja1);
        session.insert(rezerwacja3);
        session.insert(rezerwacja2);
        session.insert(rezerwacja4);
        session.insert(rezerwacja5);
        session.insert(rezerwacja6);

        session.fireAllRules();
    }
}
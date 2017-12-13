package drools;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

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

        //Klient1
        Klient klient1 = new Klient();
        klient1.lojalnosciowy= true;
        Rezerwacja rezerwacja1 = new Rezerwacja();
        rezerwacja1.klient = klient1;
        rezerwacja1.dataWynajmu = formatter.parse("2016/11/11");
        rezerwacja1.dataZwrotu = formatter.parse("2016/11/12");
        rezerwacja1.fotelik=true;
        rezerwacja1.bagaznik=true;
        rezerwacja1.samochod= new Samochod();
        rezerwacja1.zwrot = new Zwrot();
        rezerwacja1.zwrot.dataZwrotu = formatter.parse("2016/11/12");
        rezerwacja1.zwrot.przejechaneKM = 66;
        rezerwacja1.setDlugosc();
        rezerwacja1.setOpoznienie();

        //Klient2
        Klient klient2 = new Klient();

        Rezerwacja rezerwacja4 = new Rezerwacja();
        rezerwacja4.klient= klient2;
        rezerwacja4.dataWynajmu = formatter.parse("2016/11/10");
        rezerwacja4.dataZwrotu = formatter.parse("2016/11/13");
        rezerwacja4.bagaznik=true;
        rezerwacja4.samochod = new Samochod();
        rezerwacja4.preferencja = Samochod.Kategoria.B;
        rezerwacja4.zwrot = new Zwrot();
        rezerwacja4.zwrot.dataZwrotu = formatter.parse("2016/11/14");
        rezerwacja4.zwrot.przejechaneKM = 100;
        rezerwacja4.setDlugosc();
        rezerwacja4.setOpoznienie();

        Rezerwacja rezerwacja2 = new Rezerwacja();
        rezerwacja2.klient = klient2;
        rezerwacja2.dataWynajmu = formatter.parse("2016/11/11");
        rezerwacja2.dataZwrotu = formatter.parse("2016/11/14");
        rezerwacja2.bagaznik=true;
        rezerwacja2.samochod= new Samochod();
        rezerwacja2.zwrot = new Zwrot();
        rezerwacja2.zwrot.dataZwrotu = formatter.parse("2016/11/15");
        rezerwacja2.zwrot.przejechaneKM = 100;
        rezerwacja2.setDlugosc();
        rezerwacja2.setOpoznienie();

        //Klient3
        Klient klient3 = new Klient();
        Rezerwacja rezerwacja3 = new Rezerwacja();
        rezerwacja3.klient = klient3;
        rezerwacja3.dataWynajmu = formatter.parse("2016/11/11");
        rezerwacja3.dataZwrotu = formatter.parse("2016/11/16");
        rezerwacja3.samochod= new Samochod();
        rezerwacja3.preferencja= Samochod.Kategoria.B;
        rezerwacja3.zwrot = new Zwrot();
        rezerwacja3.zwrot.dataZwrotu = formatter.parse("2016/11/18");
        rezerwacja3.zwrot.przejechaneKM = 1000;
        rezerwacja3.zwrot.zgubioneKolpaki=2;
        rezerwacja3.zwrot.brakDowodu=true;
        rezerwacja3.setDlugosc();
        rezerwacja3.setOpoznienie();










        session.insert(rezerwacja3);
        session.insert(rezerwacja2);
        session.insert(rezerwacja4);
        session.insert(rezerwacja1);
        session.fireAllRules();
    }
}
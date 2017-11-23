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
        Rezerwacja rezerwacja = new Rezerwacja();
       // rezerwacja.preferencja = Samochod.Kategoria.B;
        rezerwacja.dataWynajmu = formatter.parse("2016/11/11");
        rezerwacja.dataZwrotu = formatter.parse("2016/11/12");
        rezerwacja.setDlugosc();
        rezerwacja.bagaznik=true;
        rezerwacja.fotelik=true;
        Klient klient = new Klient();
        klient.lojalnosciowy=true;
        rezerwacja.klient=klient;
        session.insert(rezerwacja);
        session.fireAllRules();
        System.out.println("SUMA Wypozyczenie " + rezerwacja.wypozyczenie+"zł");
    }
}
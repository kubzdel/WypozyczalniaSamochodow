package drools;

import java.util.ArrayList;
import java.util.List;

public class Klient {
    public String nazwa;
    public boolean lojalnosciowy;
    public List<Rezerwacja> rezerwacje = new ArrayList<>();
    public static boolean czyDatySieNakladaja(Rezerwacja rezerwacja, List<Rezerwacja> rezerwacje)
    {
        if(rezerwacje.size() < 1)
            return false;


        for(Rezerwacja rez: rezerwacje)
        {
            if(rez==rezerwacja)
                return false;
            //nowa rezerwacja sie calkowicie naklada
            else if((rezerwacja.dataWynajmu.after(rez.dataWynajmu) || rezerwacja.dataWynajmu.equals(rez.dataWynajmu) )
                    &&
                    (rezerwacja.dataZwrotu.equals(rez.dataZwrotu)|| rezerwacja.dataZwrotu.before(rez.dataZwrotu)))
                return true;
                //nowa rezerwacja zaczyna sie w trakcie poprzednich ale konczy po istniejacych
            else if(rezerwacja.dataWynajmu.after(rez.dataWynajmu) && rezerwacja.dataWynajmu.before(rez.dataZwrotu))
                return true;
                //nowa rezerwacja konczy sie w trakcie poprzedniej rezerwacji
            else if(rezerwacja.dataZwrotu.after(rez.dataWynajmu) && rezerwacja.dataZwrotu.before(rez.dataZwrotu))
                return true;

        }
        return false;
    }




}

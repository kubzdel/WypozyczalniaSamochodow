package drools;

import java.util.Date;

public class Rezerwacja {

    public boolean fotelik;
    public boolean bagaznik;
    public Date dataWynajmu;
    public Date dataZwrotu;
    public int stawka=0;
    public Klient klient;
    public int wypozyczenie=0;
    public Samochod.Kategoria preferencja = Samochod.Kategoria.A;
    public long dlugosc;

    public Date getDataZwrotu() {
        return dataZwrotu;
    }

    public void setDlugosc()
    {
        this.dlugosc = (dataZwrotu.getTime()-dataWynajmu.getTime())/((24*60*60*1000))+1;
    }
}


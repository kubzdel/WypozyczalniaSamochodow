package drools;

import java.util.Date;

public class Rezerwacja {

    public String nazwa;
    public boolean fotelik;
    public boolean bagaznik;
    public Date dataWynajmu;
    public Date dataZwrotu;
    public int stawka = 0;
    public Klient klient;
    public int wypozyczenie = 0;
    public Samochod.Kategoria preferencja;
    public Samochod samochod;
    public long dlugosc;
    public long opoznienie;
    public Zwrot zwrot;
    public boolean rezerwacjaNiemozliwa;
    public boolean dodanoDoKlienta;

    public Date getDataZwrotu() {
        return dataZwrotu;
    }

    public void setDlugosc() {
        this.dlugosc = (dataZwrotu.getTime() - dataWynajmu.getTime()) / ((24 * 60 * 60 * 1000)) + 1;
    }

    public void setOpoznienie() {
        this.opoznienie = (zwrot.dataZwrotu.getTime() - dataZwrotu.getTime()) / ((24 * 60 * 60 * 1000));

    }

    public Rezerwacja(String nazwa, Klient klient, Date dataWynajmu, Date dataZwrotu, Samochod.Kategoria preferencja,boolean fotelik, boolean bagaznik)
    {
        this.nazwa=nazwa;
        this.klient=klient;
        this.dataWynajmu=dataWynajmu;
        this.dataZwrotu=dataZwrotu;
        this.preferencja=preferencja;
        this.fotelik=fotelik;
        this.bagaznik=bagaznik;

    }

    public Rezerwacja(String nazwa, Klient klient, Date dataWynajmu, Date dataZwrotu,boolean fotelik, boolean bagaznik)
    {
        this.nazwa=nazwa;
        this.klient=klient;
        this.dataWynajmu=dataWynajmu;
        this.dataZwrotu=dataZwrotu;
        this.preferencja= Samochod.Kategoria.A;
        this.fotelik=fotelik;
        this.bagaznik=bagaznik;

    }


}


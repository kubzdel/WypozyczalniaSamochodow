package drools;

import java.util.Date;

public class Rezerwacja {

    public boolean fotelik;
    public boolean bagaznik;
    public Date dataWynajmu;
    public Date dataZwrotu;
    public int stawka = 0;
    public Klient klient;
    public int wypozyczenie = 0;
    public Samochod.Kategoria preferencja = Samochod.Kategoria.A;
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

}


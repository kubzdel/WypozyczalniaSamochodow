package drools;

import java.util.Date;

public class Zwrot {

    public Date dataZwrotu;
    public int zgubioneKolpaki=0;
    public boolean brakDowodu;
    public double stawkaKM;
    public int przejechaneKM;
    public double sumaZwrot=0;

    public Zwrot(Date dataZwrotu,int zgubioneKolpaki, boolean brakDowodu, int przejechaneKM)
    {
        this.dataZwrotu=dataZwrotu;
        this.zgubioneKolpaki=zgubioneKolpaki;
        this.brakDowodu=brakDowodu;
        this.przejechaneKM=przejechaneKM;
    }
}

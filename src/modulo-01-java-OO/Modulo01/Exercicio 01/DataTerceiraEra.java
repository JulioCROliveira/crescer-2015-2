
/**
 * Write a description of class CalendarioDeTolkien here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class  DataTerceiraEra
{
    int dia, mes, ano;
    
    public  DataTerceiraEra(int dia, int mes, int ano) {
        this.dia = dia;
        this.mes = mes;
        this.ano = ano;
    }
    
    public int getDia() {
        return this.dia;
    }
    
    public int getMes() {
        return this.mes;
    }
    
    public int getAno() {
        return this.ano;
    }
    
    public boolean  ehBissexto() {
        boolean ehBissexto = (((this.ano % 4 == 0) && (this.ano % 100 != 0)) || (this.ano % 400 == 0)) ? true: false;
        return ehBissexto;
    }
    
    public String getData() {
        String dia2Num, mes2Num;
        return String.format("%s/%s/%d", dia2Num = this.dia > 9 ? ""+this.dia : "0"+this.dia , mes2Num = this.mes > 9 ? ""+this.mes : "0"+this.mes , this.ano);
    }
    
    
}

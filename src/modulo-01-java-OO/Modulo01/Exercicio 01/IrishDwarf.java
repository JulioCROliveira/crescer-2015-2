
/**
 * Write a description of class aaa here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class IrishDwarf extends Dwarf {
    
    public IrishDwarf(String nome) {
        super(nome);       
    }
        
    public IrishDwarf(String nome, DataTerceiraEra data) {
        super(nome, data);
    }
            
    public void tentarSorte() {
        if (this.getNumeroSorte() == (double) -3333) {
            this.getInventario().aumentarNVezes1000CadaItem();
        }
    }
}
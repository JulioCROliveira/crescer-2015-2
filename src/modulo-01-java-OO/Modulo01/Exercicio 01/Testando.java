
/**
 * Escreva a descrição da classe Testando aqui.
 * 
 * @author (seu nome) 
 * @version (número de versão ou data)
 */
public class Testando
{
    public static void main(String[] args) {
        Elfo elfo1 = new Elfo("sem nome",6);
        Dwarf dwarf = new Dwarf();
        
        for (int i = 0; i <= 10; i++) {
            System.out.println(elfo1.atirarFlecha(dwarf));
        }       
        
            System.out.println("Vida do dwarf = " + dwarf.getVida()+"\n"+elfo1.toString());
    }    
}

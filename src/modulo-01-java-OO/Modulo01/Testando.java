
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
        Armas arco = new Armas(15,75,"Arco", true);
        Armas espada = new Armas(15,60,"Espada");
        
        for (int i = 0; i <= 10; i++) {
            System.out.println(elfo1.atirarFlechaRefactory(elfo1.armaEquipada()));
        }
        
        System.out.println(elfo1.equiparArma(arco));
        
        for (int i = 0; i <= 10; i++) {
            System.out.println(elfo1.atirarFlechaRefactory(elfo1.armaEquipada()));
        }
        
        System.out.println(elfo1.equiparArma(espada));
        
        for (int i = 0; i <= 10; i++) {
            System.out.println(elfo1.atirarFlechaRefactory(elfo1.armaEquipada()));
        }
    }
}

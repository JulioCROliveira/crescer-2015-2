
/**
 * Escreva a descrição da classe Testando aqui.
 * 
 * @author (seu nome) 
 * @version (número de versão ou data)
 */
public class Testando
{
    public static void main(String[] args) {
        Elfo elfo1 = new Elfo("Elfo1",6);
        Armas arco = new Armas(15,75,"Arco");
        
        for (int i = 0; i <= 10; i++) {
            System.out.println(elfo1.atirarFlechaRefactory(arco));
        }
    }
}


/**
 * Write a description of class Refri2Litros here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Refri2Litros extends Refri {
   
    public Refri2Litros(Refrigerante marca, int qtd) {
        super(marca, qtd);
    }
    
    public void recebeValoresIniciais() {
       valor = 7.00; 
    }
    
    public String toString() {
        if (this.marca == null) { return "Falha no pedido de bebidas"; }
        String garrafas = this.quantidade == 1 ? "garrafa" : "garrafas";
        String marcaRefri;
        if (marca == Refrigerante.PEPSI) {
            marcaRefri = "Pepsi";
        } else if (marca == Refrigerante.COCACOLA) {
            marcaRefri = "Coca-Cola";
        } else {
            marcaRefri = "Guaraná Antartica";
        }
        return String.format("%d %s de 2L de refrigerante %s R$ %.2f", 
                        this.quantidade, garrafas, marcaRefri, getValorTotal());
    }
}

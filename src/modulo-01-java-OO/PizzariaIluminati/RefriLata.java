
/**
 * Write a description of class RefriLata here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class RefriLata extends Refri {
   
    public RefriLata(Refrigerante marca, int qtd) {
        super(marca, qtd);
    }
    
    public void recebeValoresIniciais() {
       valor = 3.50; 
    }
    
    public String toString() {
        if (this.marca == null) { return "Falha no pedido de bebidas"; }
        String latas = this.quantidade == 1 ? "lata" : "latas";
        String marcaRefri;
        if (marca == Refrigerante.PEPSI) {
            marcaRefri = "Pepsi";
        } else if (marca == Refrigerante.COCACOLA) {
            marcaRefri = "Coca-Cola";
        } else {
            marcaRefri = "Guaraná Antartica";
        }
        return String.format("%d %s de refrigerante %s R$ %.2f", 
                        this.quantidade, latas, marcaRefri, getValorTotal());
    }
}

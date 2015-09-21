
/**
 * Write a description of class aaa here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class IrishDwarf {
    private int vida = 110, experiencia;
    private Status status = Status.VIVO;
    private String nome;
    private DataTerceiraEra dataNascimento = new DataTerceiraEra(1,1,1);
    private Inventario inventario = new Inventario();
    
    public IrishDwarf(String nome) {
        this.nome = nome;        
    }
        
    public IrishDwarf(String nome, DataTerceiraEra data) {
        this(nome);
        this.dataNascimento = data;
    }
    
    public void receberFlechada() {
        if (this.status != Status.MORTO) {
            if (this.getNumeroSorte() > 100) {
                this.vida -= 10;
                if (this.vida == 0) {
                    this.status = Status.MORTO;
                    this.vida = 0;
                } 
            } else if (this.getNumeroSorte() < 0) {        
                this.experiencia += 2;
            }
        }
    }
    
    public void receberFlechadaHacker() {
        this.vida -= 50;
        if (this.vida <= 0) {
            this.status = Status.MORTO;
            this.vida = 0;
        }
    }
    
    public int getVida() {
        return this.vida;
    } 
    
    public Status getStatus() {
        return this.status;
    }
    
    public String getNome() {
        return this.nome;
    }
    
    public DataTerceiraEra getDataNascimento() {
        return this.dataNascimento;
    }
    
    public double getNumeroSorte() {
        double numeroSorte = 101.0;        
        boolean vidaEntre80E90 = ((this.vida > 79) && (this.vida < 91)) ? true : false;
        boolean nomeDeSorte = this.nome != null ? true: false; 
        if (nomeDeSorte) { 
            nomeDeSorte = ((this.nome == "Seixas") || (this.nome == "Meireles")) ? true : false;
        }
        if (this.dataNascimento.ehBissexto() && vidaEntre80E90) {
            numeroSorte *= -33;
        }
        if (!this.dataNascimento.ehBissexto() && nomeDeSorte) {
            numeroSorte = (numeroSorte*33)%100;
        }
        return numeroSorte;
    }
    
    public int getExperiencia() {
        return this.experiencia;
    }
    
    public void tentarSorte() {
        if (this.getNumeroSorte() == (double) -3333) {
            this.getInventario().aumentarNVezes1000CadaItem();
        }
    }    
    
    public Inventario getInventario() {
        return this.inventario;
    }
}
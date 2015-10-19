
/**
 * Write a description of class Cliente here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Cliente {
   private String nome, endereco, telefone;
   
   public Cliente(String nome, String endereco, String telefone) {
       try {
           this.nome = nome;
           this.endereco = endereco;
           this.telefone = telefone;
           
           //verificando valores nulls
           this.endereco.equals("");
           this.telefone.equals("");
           this.nome.equals("");
           
        } catch (NullPointerException err) {
           this.nome = "Falha ao informar cliente";
           this.endereco = "";
           this.telefone = "";
        }        
    }
    
    public String getNome() {
        return this.nome;
    }
    
    public String getEndereco() {
        return this.endereco;
    }
    
    public String getTelefone() {
        return this.telefone;
    }
}

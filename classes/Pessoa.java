package classes;

import java.util.List;

public class Pessoa {
  private String Nome;
  private String cpf;
  private String piloto;

  
  public String getPiloto() {
    return piloto;
  }

  public void setPiloto(String piloto) {
    this.piloto = piloto;
  }

  public Pessoa() {
  }

  public Pessoa(String Nome, String cpf, String piloto) {
    setNome(Nome);
    setCpf(cpf);
    setPiloto(piloto);
  }  
  
  public String getNome() {
    return Nome;
  }

  public void setNome(String nome) {
    Nome = nome;
  }

  public String getCpf() {
    return cpf;
  }

  public void setCpf(String cpf) {
    this.cpf = cpf;
  }

  @Override
  public String toString() {
    String saida = "Nome: "+getNome();
    saida=saida+"\n CPF: "+getCpf();

    return saida;
  }

public static void add(List<Pilotos> piloto) {
}

  public static void forEach(Object object) {
  }
}

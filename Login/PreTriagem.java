package Login;

public class PreTriagem {
    private String nome;
    private String cpf;
    private int idade;
    private double temperatura;
    private int pulso;
    private double pressao;
    private double peso;
    private double hemoglobina;
    private double hematocrito;
    private boolean habilitado;

    // Construtor
    public PreTriagem(String nome, String cpf, int idade, double temperatura, int pulso,
                      double pressao, double peso, double hemoglobina, double hematocrito,
                      boolean habilitado) {
        this.nome = nome;
        this.cpf = cpf;
        this.idade = idade;
        this.temperatura = temperatura;
        this.pulso = pulso;
        this.pressao = pressao;
        this.peso = peso;
        this.hemoglobina = hemoglobina;
        this.hematocrito = hematocrito;
        this.habilitado = habilitado;
    }

    // Métodos de acesso (getters e setters)

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public double getTemperatura() {
        return temperatura;
    }

    public void setTemperatura(double temperatura) {
        this.temperatura = temperatura;
    }

    public int getPulso() {
        return pulso;
    }

    public void setPulso(int pulso) {
        this.pulso = pulso;
    }

    public double getPressao() {
        return pressao;
    }

    public void setPressao(double pressao) {
        this.pressao = pressao;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public double getHemoglobina() {
        return hemoglobina;
    }

    public void setHemoglobina(double hemoglobina) {
        this.hemoglobina = hemoglobina;
    }

    public double getHematocrito() {
        return hematocrito;
    }

    public void setHematocrito(double hematocrito) {
        this.hematocrito = hematocrito;
    }

    public boolean isHabilitado() {
        return habilitado;
    }

    public void setHabilitado(boolean habilitado) {
        this.habilitado = habilitado;
    }
}

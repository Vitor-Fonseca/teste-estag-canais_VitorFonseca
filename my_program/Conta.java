package my_program;

public class Conta {
    private int id;
    private String nome_propietario;
    private String numero;
    private String cpf_propietario;
    private String agencia;
    private double saldo;

    public Conta(int id, String nome_propietario, String numero, String cpf_propietario, String agencia){
        this.id = id;
        this.nome_propietario = nome_propietario;
        this.numero = numero;
        this.cpf_propietario = cpf_propietario;
        this.agencia = agencia;
        this.saldo = 0;
    }

    public void transfere(double valor){
        this.saldo = this.saldo - valor;
    }
    
    public void recebe(double valor){
        this.saldo = this.saldo + valor;
    }
    public double getSaldo(){
        return this.saldo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Conta outraConta = (Conta) o;
        return nome_propietario.equals(outraConta.nome_propietario) &&
        numero.equals(outraConta.numero) && cpf_propietario.equals(outraConta.cpf_propietario)
        && agencia.equals(outraConta.agencia);
        }



}
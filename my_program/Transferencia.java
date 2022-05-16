package my_program;

public class Transferencia {
    private int id;
    private double valor;
    private String tipo;
    private Conta emissor;
    private Conta receptor;
    private boolean status;
    private String reason;

    public Transferencia(String id, String valor, String tipo, Conta emissor, Conta receptor){
        this.id = Integer.parseInt(id);
        this.valor = Double.parseDouble(valor);
        this.tipo = tipo;
        this.emissor = emissor;
        this.receptor = receptor;
        this.reason = this.verificaTransferecia();
        this.status = !(this.reason.length()>0);
        if(this.status) this.realizaTransferencia();
    }
    public boolean getStatus(){
        return this.status;
    }
    public String getReason(){
        return this.reason;
    }

    private String verificaTransferecia(){ //testes de transferencia valida
        if(this.emissor.equals(this.receptor)) return "nao eh possivel transferir para a mesma conta";
        if(this.valor <= 0) return "nao eh possivel transferir valores menores ou iguais a 0";
        if(!(this.tipo.equalsIgnoreCase("PIX") || this.tipo.equalsIgnoreCase("DOC") || this.tipo.equalsIgnoreCase("TED"))) return "tipo de transferencia não cadastrado";
        if(this.tipo.equalsIgnoreCase("PIX") && this.valor > 5000.00 ) return "para transferencias PIX, o valor deve ser no maximo de R$ 5.000.00";
        if(this.tipo.equalsIgnoreCase("TED") && this.valor <= 5000.00) return "para transferencias TED, o valor deve ser superior a R$ 5.000.00";
        if(this.tipo.equalsIgnoreCase("TED") && this.valor > 10000.00) return "para transferencias TED, o valor deve ser no maximo de R$ 10.000.00";
        if(this.tipo.equalsIgnoreCase("DOC") && this.valor <= 10000.00) return "para transferencias DOC, o valor deve ser superior a R$ 10.000.00";
        return "";
    }
    private void realizaTransferencia(){
        emissor.transfere(this.valor);
        receptor.recebe(this.valor);
    }

}

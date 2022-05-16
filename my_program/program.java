package my_program;

import java.io.*;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;  

public class program {
    public static void main(String args[]){
        try {
            FileInputStream fis = new FileInputStream("my_program/entrada.txt");
            Scanner sc = new Scanner(fis);
            String[][] in = new String[2][11]; 
            Map<String, String> variaveis = new HashMap<>();
            for(int i = 0; i<2; i++){ //Le o txt
                String valor = sc.nextLine();
                if(valor.length() >0) in[i] = valor.split("\\|");
                else i--;
            }
            for(int i =0; i < 11; i++){ //preenche o Map de variaveis
                variaveis.put(in[0][i], in[1][i]);
            }
            Conta emissor = new Conta(1, variaveis.get("nome_emissor"),variaveis.get("agencia_emissor"), variaveis.get("conta_emissor"), variaveis.get("cpf_emissor"));
            Conta receptor = new Conta(2, variaveis.get("nome_receptor"),variaveis.get("agencia_receptor"), variaveis.get("conta_receptor"), variaveis.get("cpf_receptor"));
            Transferencia transferencia = new Transferencia(variaveis.get("id_transferencia"), variaveis.get("valor_transferencia"), variaveis.get("tipo_transferencia"), emissor, receptor);
            if(transferencia.getStatus()){ //transferencia deu certo
                System.out.println("Sua transferência foi realizada com sucesso!");
                System.out.println("Saldo do emissor: R$ "+ String.format("%.2f", emissor.getSaldo()));
                System.out.println("Saldo do receptor: R$ "+ String.format("%.2f", receptor.getSaldo()));
            }
            else System.out.println("Sua transferência não foi completada pois "+ transferencia.getReason()); //transferencia não deu certo
        
        
        }catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }
}
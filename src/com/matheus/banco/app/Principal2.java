package com.matheus.banco.app;

import com.matheus.banco.model.Pessoa;
import org.w3c.dom.ls.LSOutput;

import java.util.ArrayList;
import java.util.List;

public class Principal2 {

    public static void main(String[] args) {
        Pessoa pessoa1 = new Pessoa("João da silva", "6103645571");
        Pessoa pessoa2 = new Pessoa("Elon Musk", "3050608074");

        List<Pessoa> pessoas = new ArrayList<>();
        pessoas.add(pessoa1);
        pessoas.add(pessoa2);
        //System.out.println(pessoas.toString());

        //Pessoa pessoa3 = pessoas.get(1);
        //System.out.println(pessoa3);

        //   for (int i = 0; i< pessoas.size(); i++){
        //     System.out.println(pessoas.get(i).getNome());

       Pessoa pessoa4 = new Pessoa("Paulo Tavares", "4585963714");

        boolean existe = pessoas.contains(pessoa1);
        System.out.println(existe);

        System.out.println(pessoa1.equals(pessoa4));
    }
}

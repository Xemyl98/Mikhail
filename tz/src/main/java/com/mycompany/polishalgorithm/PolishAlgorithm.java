/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.polishalgorithm;

import java.util.Scanner;
import java.util.logging.Logger;

/**
 *
 * @author Michail
 */
public class PolishAlgorithm {
    public static void main(String[] args) {
       Scanner in = new Scanner(System.in);
       Logger log = Logger.getLogger(PolishAlgorithm.class.getName());
       log.info("Input data");
       try{
       String data = in.nextLine();
       if("".equals(data))
           throw new NullPointerException();
       Converting conv=new Converting();
       conv.Convert(data);
       conv.calculate();
       log.info("Polish record = "+conv.getRecord());
       System.out.println("Value = "+conv.getComputation());
       }
       catch(NullPointerException e)
       {
           System.out.println("Empty string detected");
       }
       in.close();
    }
}

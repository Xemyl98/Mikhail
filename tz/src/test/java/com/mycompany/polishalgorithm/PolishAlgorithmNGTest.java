/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.polishalgorithm;

import java.util.logging.Logger;
import static org.junit.Assert.assertEquals;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 *
 * @author Michail
 */


public class PolishAlgorithmNGTest {

    private static Logger log = Logger.getLogger(PolishAlgorithm.class.getName());
 @Test(dataProvider = "convert")
  public void testParallelConvert(String data,String real_data) {
    final Thread thread = Thread.currentThread();
    Converting conv = new Converting();
    conv.Convert(data);
    conv.calculate();
    log.info("Thread = "+thread.getId()+"\nRecord = "+ conv.getRecord()+"\nComputation = "+conv.getComputation());
    assertEquals(real_data,conv.getRecord());
  }
   @Test(dataProvider = "calculate")
  public void testParallelCalculate(String data,String real_data) {
    final Thread thread = Thread.currentThread();
    Converting conv = new Converting();
    conv.Convert(data);
    conv.calculate();
    log.info("Thread = "+thread.getId()+"\nRecord = "+ conv.getRecord()+"\nComputation = "+conv.getComputation());
    assertEquals(real_data,conv.getComputation());
  }
        
  @DataProvider(parallel=true)
  public Object[][] convert() {
        return new Object[][]{
      {"1+1", "+11"},
      {"10+23*11", "+10*2311"},
      {"3+3", "+33"},//Error
      {"10+(20/30)+40/50", "++10/2030/4050"},  
      {"10+20*((30+40)*(50+60*(70+80)))","+10*20*+3040+50*60+7080"},
      {"-5+10", "+-510"},
      {"(((10*20)+(30/40))*((50+60)+(70*80)))/(-90)", "/*+*1020/3040++5060*7080-90"},
    };
  }
    @DataProvider(parallel=true)
  public Object[][] calculate() {
        return new Object[][]{
      {"1+1", "2"},
      {"10+23*11", "263"},
      {"10+(20/30)+40/50", "11"},
      {"-5+10", "5"},     
      {"(((10*20)+(30/40))*((50+60)+(70*80)))/(-90)", "-12736"},  
    };
}
}
    

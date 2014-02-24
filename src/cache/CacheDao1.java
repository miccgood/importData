/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cache;

import com.sun.management.OperatingSystemMXBean;
import java.lang.instrument.Instrumentation;
import java.lang.management.ManagementFactory;
import java.math.BigDecimal;
import java.math.MathContext;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author tanet-t
 */
public class CacheDao1 {
    
    private static boolean stop = true;
    private static Long memoryMaxSize;
    private static int percenMaxMemory ;
    CacheDao1(int percen){
        setMaxMemory(percen);
    }
    
    CacheDao1(){
        setMaxMemory(50);
    }
    
    private static Instrumentation instrumentation;

    public static void main(String[] args){
        
        Map<String, String> mapp = new HashMap<>();
        mapp.get(null);
        setMaxMemory(50);
        new Thread(){

            @Override
            public void run() {
                while(stop){
                    printRamSpace();
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(CacheDao1.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        }.start();
        
        
        try {
            List<Map<String, List<String>>> list = new ArrayList<>();
            for (long i = 0; i < Long.MAX_VALUE; i++) {
                Map<String, List<String>> map = new HashMap<>();
                list.add(map);
            }
        } catch (OutOfMemoryError e) {
            stop = false;
        }

        
        
    }
    
    public static void printRamSpace(){
        int mb = 1024*1024;
         
        //Getting the runtime reference from system
        Runtime runtime = Runtime.getRuntime();
         
        System.out.println("##### Heap utilization statistics [MB] #####");
         
        //Print used memory
        System.out.println("Used Memory:" + (runtime.totalMemory() - runtime.freeMemory()) / mb);
 
        //Print free memory
        System.out.println("Free Memory:" + runtime.freeMemory() / mb);
         
        //Print total available memory
        System.out.println("Total Memory:" + runtime.totalMemory() / mb);
 
        //Print Maximum available memory
        System.out.println("Max Memory:" + runtime.maxMemory() / mb);
    }
    
//    public static boolean getFullMemory(){
//        Runtime runtime = Runtime.getRuntime();
//        BigDecimal totalMemory = BigDecimal.valueOf(runtime.totalMemory());
//        BigDecimal usedMemory = BigDecimal.valueOf(runtime.totalMemory() - runtime.freeMemory());
//        BigDecimal freeMemory = BigDecimal.valueOf(runtime.freeMemory());
//        
//        
//    }
    
    private static void setMaxMemory(int percen){
        if(percen > 80){
            percen = 100;
        }else if(percen < 20){
            percen = 20;
        }
        percenMaxMemory = percen;
        
        long ramSize = getRamSize();
        memoryMaxSize = BigDecimal.valueOf(ramSize).divide(BigDecimal.valueOf(100),MathContext.DECIMAL64).multiply(BigDecimal.valueOf(percenMaxMemory)).longValue();

    }
    
    private long getSizeObject(Object obj){
        return instrumentation.getObjectSize(obj);
    }
    
    private static long getRamSize(){
        return ((OperatingSystemMXBean) ManagementFactory.getOperatingSystemMXBean()).getTotalPhysicalMemorySize();
    }
   
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package test;

import GUI.TestGUI;
import java.util.concurrent.Callable;

/**
 *
 * @author tanet-t
 */
public class CallFunction {
    public CallFunction myMethod(Callable<CallFunction> func) throws Exception {
        return func.call();
    }


    public int methodToPass() { 
    return 123;
            // do something
    }

    public void dansMethod(int i, Callable<CallFunction> myFunc) {
           // do something
    }

//    dansMethod(100, new Callable<Integer>() {
//       public Integer call() {
//            return methodToPass();
//       }
//    }
    
    public static void Main(String[] args){
        CallFunction c = new CallFunction();
    }

}

/*
 * Copyright [2013] [Cloud4SOA, www.cloud4soa.eu]
 *
 *
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */


package utils;




import java.sql.Time;
import java.text.DecimalFormatSymbols;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Locale;
import java.util.Random;
import java.util.Timer;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * BenchmarkRunner.java
 * Copyright (c) 2010 by Dr. Herong Yang, herongyang.com
 */
public class BenchmarkRunner {
   static java.io.PrintStream out = System.out;
   static java.io.InputStream in = System.in;
   long startTime = 0;
   long endTime = 0;
   long[] timeRecords = null;

   private int[] values;
   private int[] copy;
   
   public static void main(String[] a) {
       
     // if (a.length<5) {
       // out.println("Missing arguments. Usage: ");
       // out.println(
       //    "BenchmarkRunner class method warmups runs steps");
        //return;
       	 String className = "utils.BenchmarkRunner";
      	 String methodName = "sampleTest";
      	 int numberOfWarmups = 4;
      	 int numberOfRuns =100;
      	 int numberOfSteps = 10000;       
     // }
      try {
      	 //String className = a[0];
      	 //String methodName = a[1];
      	// int numberOfWarmups = Integer.parseInt(a[2]);
      	 //int numberOfRuns = Integer.parseInt(a[3]);
      	// int numberOfSteps = Integer.parseInt(a[4]);
     
         // Warming up the JVM
         out.println("Are you ready?");
         in.read(new byte[1]);

         // Loading the benchmark class and method
     	 Class testClass = Class.forName(className);
     	 java.lang.reflect.Method testMethod 
     	    = testClass.getMethod(methodName, int.class,
     	    BenchmarkRunner.class);
         BenchmarkRunner testRunner
            = new BenchmarkRunner(numberOfRuns);
         Object testObject = testClass.newInstance();

         // JIT warmup
         out.println();
         out.println("Waking up the JIT compiler...");
         for (int i=0; i<numberOfWarmups; i++) {
            Object testResult = 
            testMethod.invoke(testObject, numberOfSteps, testRunner);
            out.println("Run: "+i+", Time: "+testRunner.returnTime()
               +", Test returns: "+testResult);
         }

         // Benchmark runs
         out.println();
         out.println("Starting benchmark test runs...");
         for (int i=0; i<numberOfRuns; i++) {
            Object testResult = 
            testMethod.invoke(testObject, numberOfSteps, testRunner);
            testRunner.recordTime(i);
            out.println("Run: "+i+", Time: "+testRunner.returnTime()
               +", Test returns: "+testResult);
         }

         // Benchmark report
         out.println();
         out.println("Benchmark test time report...");
           Long report = testRunner.report(numberOfRuns, numberOfSteps);

      } catch (Exception e) {
         e.printStackTrace();
      }

   }
   
   public Long benchmark() {
       
       	 String className = "utils.BenchmarkRunner";
      	 String methodName = "sampleTest";
      	 int numberOfWarmups = 4;
      	 int numberOfRuns =50;
      	 int numberOfSteps = 10000;
         Long benchTime=0L;
      try {

         // Loading the benchmark class and method
     	 Class testClass = Class.forName(className);
     	 java.lang.reflect.Method testMethod 
     	    = testClass.getMethod(methodName, int.class,
     	    BenchmarkRunner.class);
         BenchmarkRunner testRunner
            = new BenchmarkRunner(numberOfRuns);
         Object testObject = testClass.newInstance();

         // JIT warmup
         out.println();
         out.println("Waking up the JIT compiler...");
         for (int i=0; i<numberOfWarmups; i++) {
            Object testResult = 
            testMethod.invoke(testObject, numberOfSteps, testRunner);
            out.println("Run: "+i+", Time: "+testRunner.returnTime()
               +", Test returns: "+testResult);
         }

         // Benchmark runs
         out.println();
         out.println("Starting benchmark test runs...");
         for (int i=0; i<numberOfRuns; i++) {
            Object testResult = 
            testMethod.invoke(testObject, numberOfSteps, testRunner);
            testRunner.recordTime(i);
            out.println("Run: "+i+", Time: "+testRunner.returnTime()
               +", Test returns: "+testResult);
         }

         // Benchmark report
         out.println();
         out.println("Benchmark test time report...");
           Long report = testRunner.report(numberOfRuns, numberOfSteps);
         out.println("AVG Time:"+report);
           benchTime=report;
      } catch (Exception e) {
         e.printStackTrace();
      }
        out.println("AVG Bench Time:"+benchTime);

      return benchTime;
   }

   // Constructor
   public BenchmarkRunner(int runs) {
      timeRecords = new long[runs];
   }

   // Starting the timer - to be called by test method
   public void startTimer() {
      startTime = System.nanoTime();
   }

   // Stopping the timer - to be called by test method
   public void stopTimer() {
      endTime = System.nanoTime();
   }

   // Returning time from the timer
   public long returnTime() {
      return endTime - startTime;
   }

   // Recording time from the timer
   public void recordTime(int i) {
      timeRecords[i] = endTime - startTime;
   }

   // Reportting benchmark result
   public Long report(int runs, int steps) {
      long total = 0;
      long minimum = Long.MAX_VALUE;
      long maximum = 0;
      for (int i=0; i<runs; i++) {
      	 long t = timeRecords[i];
      	 total += t;
      	 if (t>maximum) maximum = t;
      	 if (t<minimum) minimum = t;
      }
      long average = total/runs;
      out.println("Runs: "+runs+", Ave: "+average/steps
         +", Min: "+minimum/steps
         +", Max: "+maximum/steps
         +" - Per step in nanoseconds");
      out.println("Runs: "+runs+", Ave: "+average
         +", Min: "+minimum+", Max: "+maximum
         +" - All steps in nanoseconds");
      out.println("Runs: "+runs+", Ave: "+average/1000000
         +", Min: "+minimum/1000000
         +", Max: "+maximum/1000000
         +" - All steps in milliseconds");
      out.println("Runs: "+runs+", Ave: "+average/1000000000
         +", Min: "+minimum/1000000000
         +", Max: "+maximum/1000000000
         +" - All steps in seconds");
      Long benchResult=average/1000000;
      out.println("benchresult:"+benchResult);
      out.println("benchresultL:"+Long.toString(benchResult));
      return benchResult;
   }
   
   // Constructor needed as a sample benchmark test class
   public BenchmarkRunner() {
   }

   // A sample benchmark test method
   public static long sampleTest(int size, BenchmarkRunner runner) {
      long total = 0;
      runner.startTimer();  
      
      // for (int i=0; i<steps; i++) {
     //    total += i;
     // }
        Random random = new Random();
        int[] result = new int[size];
        for (int i = 0; i < size; i++) {
          result[i] = random.nextInt();
        SimpleDateFormat sdf = new SimpleDateFormat();
        sdf.clone();
        DecimalFormatSymbols dfs = new DecimalFormatSymbols(Locale.US);
        dfs.clone();
          
        }
        
        BenchmarkRunner br= new BenchmarkRunner();
        br.bubbleSort(result);
  
        
      runner.stopTimer();
      return total;
   }
   
   

     
      private void timeSort(int reps) {
        Random random = new Random();
        int[] result = new int[100000];
        for (int i = 0; i < 100000; i++) {
          result[i] = random.nextInt();
        } 
        
        for (int i = 0; i < 100000; i++) {
        System.arraycopy(values, 0, copy, 0, values.length);
      Arrays.sort(copy);
    }
  }
  private int[] bubbleSort(int[] intArray) {
               
                /*
                 * In bubble sort, we basically traverse the array from first
                 * to array_length - 1 position and compare the element with the next one.
                 * Element is swapped with the next element if the next element is greater.
                 *
                 * Bubble sort steps are as follows.
                 *
                 * 1. Compare array[0] & array[1]
                 * 2. If array[0] > array [1] swap it.
                 * 3. Compare array[1] & array[2]
                 * 4. If array[1] > array[2] swap it.
                 * ...
                 * 5. Compare array[n-1] & array[n]
                 * 6. if [n-1] > array[n] then swap it.
                 *
                 * After this step we will have largest element at the last index.
                 *
                 * Repeat the same steps for array[1] to array[n-1]
                 *  
                 */
               
                int n = intArray.length;
                int temp = 0;
               
                for(int i=0; i < n; i++){
                        for(int j=1; j < (n-i); j++){
                               
                                if(intArray[j-1] > intArray[j]){
                                        //swap the elements!
                                        temp = intArray[j-1];
                                        intArray[j-1] = intArray[j];
                                        intArray[j] = temp;
                                }
                               
                        }
                }
                return intArray;
       
        }
      
   
}
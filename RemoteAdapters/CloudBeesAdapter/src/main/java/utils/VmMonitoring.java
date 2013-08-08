/*
 * To change this templae, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.management.*;
import java.net.HttpURLConnection;
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jdom.*;
import eu.cloud4soa.adapter.rest.response.model.Metric;
import java.io.StringReader;
import org.jdom.input.SAXBuilder;
/**
 *
 * @author jled
 */
public class VmMonitoring {
    
    public static void main(String[] args) {
        VmMonitoring vm = new VmMonitoring();
        try {
            //Metric res[]= vm.getMetricsFromApp();
            //System.out.println("res:"+res[1].toString());
            //Element returnMonitoringInfo = vm.returnMonitoringInfo();
            //System.out.println("vm metrics:"+returnMonitoringInfo.getChild("threads").getAttributeValue("opsys-name"));

           //vm.pingICMP();
           //vm.pingForResponse();
        } catch (Exception ex) {
            Logger.getLogger(VmMonitoring.class.getName()).log(Level.SEVERE, null, ex);
        }
                
    }
    
    	private String adapterUrl;
	
	public VmMonitoring() {
	
	}
	
	public VmMonitoring(String adapterUrl) {
		this.adapterUrl = adapterUrl;
	}
	
        
 public Element returnMonitoringInfo( ) throws Exception
  {
      Element elementReturn= null;
    try
    {
      System.out.println( "MXBeanServlet invoked..." );
      Element root = new Element( "management-info" );
      // Get class loading info
      ClassLoadingMXBean clBean=ManagementFactory.getClassLoadingMXBean();
      
      // Get MbeanServer info
      //MBeanServer platform=ManagementFactory.getPlatformMBeanServer();
      //MBeanInfo mBeanInfo = platform.getMBeanInfo(ObjectName.WILDCARD);
      
      // Get memory info
      MemoryMXBean memusage = ManagementFactory.getMemoryMXBean();
      // Get runtime information
      RuntimeMXBean runtime = ManagementFactory.getRuntimeMXBean();
      // Get operating system info
      OperatingSystemMXBean operatingSys = ManagementFactory.getOperatingSystemMXBean();
      // Garbage Collection
      List<GarbageCollectorMXBean> garbageCollectorMXBeans = ManagementFactory.getGarbageCollectorMXBeans();
      // Handle thread info
      ThreadMXBean threads = ManagementFactory.getThreadMXBean();
      Element threadsElement = new Element( "threads" );
      threadsElement.setAttribute( "thread-count", Long.toString( threads.getThreadCount() ) );
      threadsElement.setAttribute( "total-started-thread-count", Long.toString( threads.getTotalStartedThreadCount() ) );
      threadsElement.setAttribute( "daemon-thread-count", Long.toString( threads.getDaemonThreadCount() ) );
      threadsElement.setAttribute( "peak-thread-count", Long.toString( threads.getPeakThreadCount() ) );
      long totalCpuTime = 0l;
      long totalUserTime = 0l;

      // Parse each thread
      ThreadInfo[] threadInfos = threads.getThreadInfo( threads.getAllThreadIds() );
      for( int i=0; i<threadInfos.length; i++ )
      {
        Element threadElement = new Element( "thread" );
        threadElement.setAttribute( "id", Long.toString( threadInfos[ i ].getThreadId() ) );
        threadElement.setAttribute( "name", threadInfos[ i ].getThreadName() );
        threadElement.setAttribute( "cpu-time-nano", Long.toString( threads.getThreadCpuTime( threadInfos[ i ].getThreadId() ) ) );
        threadElement.setAttribute( "cpu-time-ms", Long.toString( threads.getThreadCpuTime( threadInfos[ i ].getThreadId() ) / 1000000l ) );
        threadElement.setAttribute( "user-time-nano", Long.toString( threads.getThreadUserTime( threadInfos[ i ].getThreadId() ) ) );
        threadElement.setAttribute( "user-time-ms", Long.toString( threads.getThreadUserTime( threadInfos[ i ].getThreadId() ) / 1000000l ) );
        threadElement.setAttribute( "blocked-count", Long.toString( threadInfos[ i ].getBlockedCount() ) );
        threadElement.setAttribute( "blocked-time", Long.toString( threadInfos[ i ].getBlockedTime() ) );
        threadElement.setAttribute( "waited-count", Long.toString( threadInfos[ i ].getWaitedCount() ) );
        threadElement.setAttribute( "waited-time", Long.toString( threadInfos[ i ].getWaitedTime() ) );
        threadsElement.addContent( threadElement );

        // Update our aggregate values
        totalCpuTime += threads.getThreadCpuTime( threadInfos[ i ].getThreadId() );
        totalUserTime += threads.getThreadUserTime( threadInfos[ i ].getThreadId() );
      }
      long totalCpuTimeMs = totalCpuTime / 1000000l;
      long totalUserTimeMs = totalUserTime / 1000000l;
      threadsElement.setAttribute( "total-cpu-time-nano", Long.toString( totalCpuTime ) );
      threadsElement.setAttribute( "total-user-time-nano", Long.toString( totalUserTime ) );
      threadsElement.setAttribute( "total-cpu-time-ms", Long.toString( totalCpuTimeMs ) );
      threadsElement.setAttribute( "total-user-time-ms", Long.toString( totalUserTimeMs ) );
      //root.addContent( threadsElement );
      // Memory Usage Info
      MemoryUsage heapMemoryUsage = memusage.getHeapMemoryUsage();
      MemoryUsage nonHeapMemoryUsage = memusage.getNonHeapMemoryUsage();
      int objectPendingFinalizationCount = memusage.getObjectPendingFinalizationCount();
      
      threadsElement.setAttribute( "heap-memory-max",  Long.toString( heapMemoryUsage.getMax()) );
      threadsElement.setAttribute( "heap-memory-used",  Long.toString( heapMemoryUsage.getUsed()) );
      threadsElement.setAttribute( "heap-memory-init",  Long.toString( heapMemoryUsage.getInit()) );
      threadsElement.setAttribute( "heap-memory-commited",  Long.toString( heapMemoryUsage.getCommitted()) );
      threadsElement.setAttribute( "nonheap-memory-max",  Long.toString( nonHeapMemoryUsage.getMax()) );
      threadsElement.setAttribute( "nonheap-memory-used",  Long.toString( nonHeapMemoryUsage.getUsed()) );
      threadsElement.setAttribute( "nonheap-memory-init",  Long.toString( nonHeapMemoryUsage.getInit()) );
      threadsElement.setAttribute( "nonheap-memory-commited",  Long.toString( nonHeapMemoryUsage.getCommitted()) );
      threadsElement.setAttribute( "memory-object-pending-finalization",  Integer.toString( objectPendingFinalizationCount) );
  
      // Operating System
      String name = operatingSys.getName();
      String version = operatingSys.getVersion();
      String arch = operatingSys.getArch();
      int availableProcessors = operatingSys.getAvailableProcessors();
      double systemLoadAverage = operatingSys.getSystemLoadAverage();
     
      threadsElement.setAttribute( "opsys-name",  name);
      threadsElement.setAttribute( "opsys-version",  version);
      threadsElement.setAttribute( "opsys-arch",  arch);
      threadsElement.setAttribute( "opsys-available-processors",  Integer.toString(availableProcessors));
      threadsElement.setAttribute( "opsys-system-load-avg",  Double.toString(systemLoadAverage));
      
      
      threadsElement.setAttribute( "garbage-collector-mbeans-size",  Integer.toString(garbageCollectorMXBeans.size()));
          
      
      // Compute thread percentages
      long uptime = runtime.getUptime();
      threadsElement.setAttribute( "uptime", Long.toString( uptime ) );
      double cpuPercentage = ( ( double )totalCpuTimeMs / ( double )uptime ) * 100.0;
      double userPercentage = ( ( double )totalUserTimeMs / ( double )uptime ) * 100.0;
      threadsElement.setAttribute( "total-cpu-percent", Double.toString( cpuPercentage ) );
      threadsElement.setAttribute( "total-user-percent", Double.toString( userPercentage ) );
      threadsElement.setAttribute( "loaded-class-count", Integer.toString(clBean.getLoadedClassCount()) );
      threadsElement.setAttribute( "total-loaded-class-count", Long.toString(clBean.getTotalLoadedClassCount()) );
      threadsElement.setAttribute( "unloaded-class-count", Long.toString(clBean.getUnloadedClassCount()) );
      
      
      
      
      root.addContent( threadsElement );
      
      // Output the XML to the caller
      //XMLOutputter outputter = new XMLOutputter(Format.getPrettyFormat());
      //XMLOutputter outputter = new XMLOutputter( "\t", true );
      //outputter.output( root, res.getOutputStream() );
        System.out.println("element:"+threadsElement.getAttributeValue("opsys-name"));
        System.out.println("XML:"+root.getChild("threads").getAttributeValue("opsys-name"));
      elementReturn=root;
    }
    catch( Exception e )
    {
      e.printStackTrace();
      throw new Exception( e );
    }
    return elementReturn;
  }
 
 
 
 public long pingICMP(){
    String host = "localhost";
    int timeOut = 5000;
    long pingTime=0L;
        try {   
            
            long currentTime = System.nanoTime();           
            boolean isPinged = InetAddress.getByName(host).isReachable(timeOut);
            pingTime = System.nanoTime() - currentTime; 
            if(isPinged) {
            System.out.println("pinged successfully in "+ pingTime+ "nanoseconds");
            System.out.println("pinged successfully in "+ pingTime/1000+ "microseconds");
            System.out.println("pinged successfully in "+ pingTime/1000000+ "milliseconds");
            } else {
                System.out.println("PIng failed.");
}
        } catch (IOException ex) {
            Logger.getLogger(VmMonitoring.class.getName()).log(Level.SEVERE, null, ex);
        }
        return pingTime;
 }
 
 
 public long pingForResponse(){
 HttpURLConnection connection = null;
 long pingTime = 0L;   
 try {
        long currentTime = System.nanoTime();           
        
        URL u = new URL("http://"+adapterUrl);
        connection = (HttpURLConnection) u.openConnection();
        connection.setRequestMethod("HEAD");
        int code = connection.getResponseCode();
        pingTime = System.nanoTime() - currentTime; 
        //connection.get
        System.out.println("" + code);
        System.out.println("pinged successfully in "+ pingTime+ "nanoseconds");
        System.out.println("pinged successfully in "+ pingTime/1000+ "microseconds");
        System.out.println("pinged successfully in "+ pingTime/1000000+ "milliseconds");

        // You can determine on HTTP return code received. 200 is success.
    } catch (MalformedURLException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    } catch (IOException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    } finally {
        if (connection != null) {
            connection.disconnect();
            }     
        }
    return pingTime;
 }
 
 public int checkAppMetricsAvailability(String url){
    HttpURLConnection connection = null;
    int code;  
     try {
           URL u = new URL("http://"+url+"/c4smtrex");
              connection = (HttpURLConnection) u.openConnection();
             // connection.setRequestMethod("HEAD");
               code = connection.getResponseCode();
        } catch (Exception ex) {
            Logger.getLogger(VmMonitoring.class.getName()).log(Level.SEVERE, null, ex);
            code=404;
        }
        return code;

 }
 
 public Metric[] getMetricsFromApp(String url){
 HttpURLConnection connection = null;
 String inputLine = null;
 Metric[] metrics = new Metric[4];
 try {
        //url="demo1.testurl.cloudbees.net";
        URL u = new URL("http://"+url+"/c4smtrex");
        //URL u = new URL("http://demo1.testurl.cloudbees.net/c4smtrex/");
        //URL u = new URL("http://demo.cloud4soa.eu/cloud4soa/");
        //URLConnection yc = u.openConnection();
        connection = (HttpURLConnection) u.openConnection();
       // connection.setRequestMethod("HEAD");
        int code = connection.getResponseCode(); 
        if(code==200){
        BufferedReader in = new BufferedReader(
                                new InputStreamReader(
                                connection.getInputStream()));

            StringBuilder response = new StringBuilder();
 
            while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}
		in.close();
                
 
		//print result
		inputLine=response.toString();
                
                
                
	  SAXBuilder builder = new SAXBuilder();
        try {
            org.jdom.Document doc = builder.build(new StringReader(inputLine));
            Element metricsElement =doc.getRootElement().getChild("metrics");
            
        Metric cpuMetric = new Metric();
        cpuMetric.setMetricName("CPU_Load");
        cpuMetric.setValue(metricsElement.getAttributeValue("CPU_Load"));
        Metric memMetric = new Metric();
        memMetric.setMetricName("Memory_Load");
        memMetric.setValue(metricsElement.getAttributeValue("Memory_Load"));
        Metric cloudMetric = new Metric();
        cloudMetric.setMetricName("CloudResponseTime");
        cloudMetric.setValue(metricsElement.getAttributeValue("CloudResponseTime"));        
        Metric containerMetric = new Metric();
        containerMetric.setMetricName("ContainerResponseTime");
        containerMetric.setValue(metricsElement.getAttributeValue("ContainerResponseTime"));
        
        metrics[0]=cpuMetric;
        metrics[1]=memMetric;
        metrics[2]=cloudMetric;
        metrics[3]=containerMetric;
        //ret.setMetrics(metrics);    
        } catch (JDOMException e) {
            // handle JDOMException
        } catch (IOException e) {
            // handle IOException
        }
            
                
                
                
        }
        // You can determine on HTTP return code received. 200 is success.
    } catch (MalformedURLException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    } catch (IOException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    } finally {
        if (connection != null) {
            connection.disconnect();
            }     
        }
    return metrics;
 }
 
}

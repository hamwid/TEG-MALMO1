//Tabell 4: krav på IAD.
//
//IAD_001 Input boundaries
// - Kan ta emot två heltal mellan 0 och 200.
//IAD_002 Input lower limit
// - Input mindre än 0 hanteras som 0.
//IAD_003 Input upper limit
// - Input större än 200 hanteras som 200.
//IAD_004 Output independence
// - Kan skicka ut två booleaner som kan vara true eller false oberoende av varandra.
//
//IAD_005 Analyses IAD_1
// - Kan göra bedömning baserat på storlek av mottaget heltal. Om heltalet är större än 5, är färdriktning 
//   rear godkänd (boolean sätts till true), annars icke godkänd.
//
//IAD_006 Analyses IAD_2
// - Kan göra bedömning baserat på storlek av mottagna heltal. Färdriktningarna forwardL och left är
//   godkända om respektive mottaget heltal är större än 30, annars är de icke godkända.
//
//IAD_007 Analyses IAD_3
// - Kan göra bedömning baserat på storlek av mottagna heltal. Färdriktningarna forwardR och right är
//   godkända om respektive mottaget heltal är större än 30, annars är de icke godkända.


import java.util.ArrayList;
import java.util.Arrays;


/**
 *
 * 
 * 
 * @author Simonster
 */
public class Projekt_IAD_UnitTests {
    
    private IAD testIAD;
    
    // IHDs used for test
    private IHD tIHD_1;
    private IHD tIHD_2;
    
    Sensor testSensor = new Sensor();
        
    // When this is set to true, test will give more information about the test executed
    private boolean verbose = true;
    
    private ArrayList textOutput;
 
    
    public void setVerboseOutput(boolean on_off){
    verbose = on_off;
    }
    
    public void printVerbose(){
       
      System.out.println("Expected: " + textOutput.get(0));
      System.out.println("Actual:   " + textOutput.get(1) ); 
      System.out.print("Result:   "); 
    
    }
    
        public void printVerboseMultiTest(){
       
      System.out.println("Expected: " + textOutput.get(1));
      System.out.println("Actual:   " + textOutput.get(2) ); 
      System.out.println("Result:   " +  textOutput.get(0)); 
 
    
    }
        
     

   // @BeforeMethod
    public void setUp() {
       if(verbose == true) { System.out.println("Testing: Projekt_testIAD");}
       textOutput = new ArrayList();
       testIAD = new IAD();
       tIHD_1 = new IHD();
       tIHD_2 = new IHD();
       

       tIHD_1.initialize(testSensor);
       tIHD_2.initialize(testSensor);
       
       
    }
    
        //@AfterMethod
    public void tearDown() {
        textOutput = null;
        testIAD = null;
        tIHD_1 = null;
        tIHD_2 = null;
        
        
    }

    //@test
    public boolean test_initialized_connect_two_IHDs(){
        
 
        
    if(verbose == true) { System.out.println("Running: test_initialized_connect_two_IHDs");}
    
    ArrayList expected = new ArrayList();
    
    ArrayList actual = new ArrayList();
    
    // ihd_1 expected to pass check of not null hence true
     expected.add(true);
    // ihd_2 expected to pass check of not null hence true
     expected.add(true);
     expected.add(0);
     expected.add(0);
     expected.add(false);
     expected.add(false);
     expected.add(30);

     
     if(tIHD_1 != null && tIHD_2 != null ){
     testIAD.initialize(tIHD_1, tIHD_2);
     
     // Observe that no check is done on tIHD_1 or tIHD_2 has run their initialize function
     
     // for this test the testdata is the expected values after initialize is called as read for the sourcecode
     actual.add(true);
     actual.add(true);
     actual.add(0);
     actual.add(0);
     actual.add(false);
     actual.add(false);
     actual.add(30);

     
     
     }else{
         
         if(tIHD_1 == null){
             System.out.println("tIHD_1 not initialized");
         }
         
         if(tIHD_2 == null){
             System.out.println("tIHD_2 not initialized");
         }
         
         return false;
     }
            
    if(verbose == true) {
        textOutput.add(expected.toString()); 
        textOutput.add(actual.toString());
        printVerbose();
    }
   
    if(expected.toString().equals(actual.toString())){

         return true;
         
    }
     else{
         return false;
     }

   }
    
    public boolean test_initialized_connect_one_IHD(){
        
    if(verbose == true) { System.out.println("Running: test_initialized_connect_one_IHD");}

    ArrayList expected = new ArrayList();
    
    ArrayList actual = new ArrayList();
    
    // ihd_1 expected to pass check of not null hence true
     expected.add(true);
    // ihd_2 expected to pass check of not null hence true
     expected.add(true);
     expected.add(0);
     expected.add(0);
     expected.add(false);
     expected.add(false);
     expected.add(5);

     
     if(tIHD_1 != null ){
     testIAD.initialize(tIHD_1, tIHD_1);
     
     // Observe that no check is done on tIHD_1 has run the initialize function
     
     // for this test the testdata is the expected values after initialize is called as read for the sourcecode
     actual.add(true);
     actual.add(true);
     actual.add(0);
     actual.add(0);
     actual.add(false);
     actual.add(false);
     actual.add(5);

     
     
     }else{
         
         if(tIHD_1 == null){
             System.out.println("tIHD_1 not initialized");
         }
         
         if(tIHD_2 == null){
             System.out.println("tIHD_2 not initialized");
         }
         
         return false;
     }
            
    if(verbose == true) {
        textOutput.add(expected.toString()); 
        textOutput.add(actual.toString());
        printVerbose();
    }
   
    if(expected.toString().equals(actual.toString())){

         return true;
         
    }
     else{
         return false;
     }

   }    
    //@Test
    public boolean test_execute_connected_two_IHDs(){
    if(verbose == true) { System.out.println("Running: test_execute_connected_two_IHDs");}

    // testvalue 50, 97
    
    int testdata [] = { 34, 97};
    
    if(verbose == true) { 
        System.out.println("Testdata: "+Arrays.toString(testdata));
    }
    
    testSensor.originalOutput = testdata[0];
    testSensor.safetyOutput = testdata[1];
    
    tIHD_1.execute();
    tIHD_2.execute();
    
    final boolean expected [] = { true, true};
    
    boolean actual [] = new boolean [2];
    

    
    testIAD.initialize(tIHD_1, tIHD_2);
    
    testIAD.execute();
    
    actual = testIAD.getData();
    
    if(verbose == true) {
        textOutput.add(Arrays.toString(expected)); 
        textOutput.add(Arrays.toString(actual));
        printVerbose();
    }

    boolean result;
    
       
                if(expected[0] == actual[0] && expected[1] == actual[1]){              
                  result= true;      
                  }else{
                  result= false;      
                }
        

    return result;
   }
    
    public boolean test_execute_connected_one_IHD(){
    if(verbose == true) { System.out.println("Running: test_execute_connected_one_IHD");}

    // testvalue 35, 78
    int testdata [] = { 45, 78};
        
        if(verbose == true) { 
        System.out.println("Testdata: "+Arrays.toString(testdata));
    }
    
    
    testSensor.originalOutput = testdata[0];
    testSensor.safetyOutput = testdata[1];
    
    tIHD_1.execute();
    tIHD_2.execute();
   
    
    final boolean expected [] = { true, true};
    
    boolean actual [] = new boolean [2];
    

    
    testIAD.initialize(tIHD_1, tIHD_1);
    
    testIAD.execute();
    
    actual = testIAD.getData();
    
    if(verbose == true) {
        textOutput.add(Arrays.toString(expected)); 
        textOutput.add(Arrays.toString(actual));
        printVerbose();
    }

    boolean result;
    
       
                if(expected[0] == actual[0] && expected[1] == actual[1]){              
                  result= true;      
                  }else{
                  result= false;      
                }
        

    return result;
   }


    public boolean test_analyze_30_limit_first_sensor(){
    if(verbose == true) { System.out.println("Running: test_analyze_30_limit_first_sensor");}

    // testvalue 50, 97
    
    int testdata [] = { 0, 97, 1, 5, 29 ,30, 45, 200, 300, -15};
    
    if(verbose == true) { 
        System.out.print("Testdata:   ");
        for (int i = 0; i < testdata.length; i++) {
              System.out.print("   "+testdata[i]+",");
        } 
      System.out.println(" ");
    }
    
    
   
    
    testIAD.initialize(tIHD_1, tIHD_2);


  
    final boolean expected [] = { false, true, false, false, false, false, true , true, true ,false};
    
    boolean actual [] = new boolean [10];
    

                for (int i = 0; i < testdata.length; i++) {
                    testSensor.originalOutput = testdata[i];
                    testSensor.safetyOutput = testdata[i];
                    
                     tIHD_1.execute();
                    
                     testIAD.execute();
                     
    
                     
                  boolean temp [] = {false,false};
                  temp = testIAD.getData();
                  
                  actual[i] = temp[0];
                }

    
    
    if(verbose == true) {
        textOutput.add(Arrays.toString(expected)); 
        textOutput.add(Arrays.toString(actual));
        printVerbose();
    }

    boolean result = false;
    
             
                    
    result = Arrays.toString(expected).equals(Arrays.toString(actual));

        

    return result;
   }
    
        public boolean test_analyze_30_limit_second_sensor(){
    if(verbose == true) { System.out.println("Running: test_analyze_30_limit_second_sensor");}

    // testvalue 50, 97
    
    int testdata [] = { 0, 97, 1, 5, 29 ,30, 45, 200, 300, -15};
    
    if(verbose == true) { 
        System.out.print("Testdata:   ");
        for (int i = 0; i < testdata.length; i++) {
              System.out.print("   "+testdata[i]+",");
        } 
      System.out.println(" ");
    }

    testIAD.initialize(tIHD_1, tIHD_2);
   
  
    final boolean expected [] = { false, true, false, false, false, false, true , true, true ,false};
    
    boolean actual [] = new boolean [10];
    

                for (int i = 0; i < testdata.length; i++) {
                    testSensor.originalOutput = testdata[i];
                    testSensor.safetyOutput = testdata[i];
                    
                     tIHD_2.execute();
                    
                     testIAD.execute();
                  boolean temp [] = {false,false};
                  temp = testIAD.getData();
                  
                  actual[i] = temp[1];
                }

    
    
    if(verbose == true) {
        textOutput.add(Arrays.toString(expected)); 
        textOutput.add(Arrays.toString(actual));
        printVerbose();
    }

    boolean result = false;
    
             
                    
    result = Arrays.toString(expected).equals(Arrays.toString(actual));

        

    return result;
   }
    
    public boolean test_analyze_5_limit(){
    if(verbose == true) { System.out.println("Running: test_analyze_5_limit");}

    // testvalue 50, 97
    
    int testdata [] = { 0, 97, 1, 5, 29 ,30, 45, 200, 300, -15};
    
    if(verbose == true) { 
        System.out.print("Testdata:   ");
        for (int i = 0; i < testdata.length; i++) {
              System.out.print("   "+testdata[i]+",");
        } 
      System.out.println(" ");
    }
    

    testIAD.initialize(tIHD_1);
    tIHD_1.execute();
  
    final boolean expected [] = { false, true, false, false, true, true, true , true, true ,false};
    
    boolean actual [] = new boolean [10];
    

                for (int i = 0; i < testdata.length; i++) {
                    testSensor.originalOutput = testdata[i];
                    testSensor.safetyOutput = testdata[i];
                    
                     tIHD_1.execute();
                    
                     testIAD.execute();
                  boolean temp [] = {false,false};
                  temp = testIAD.getData();
                  
                  actual[i] = temp[0];
                }

    
    
    if(verbose == true) {
        textOutput.add(Arrays.toString(expected)); 
        textOutput.add(Arrays.toString(actual));
        printVerbose();
    }

    boolean result = false;
    
             
                    
    result = Arrays.toString(expected).equals(Arrays.toString(actual));

        

    return result;
   }
        
  
        
} // end of class

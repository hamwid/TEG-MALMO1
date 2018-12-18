




/**
 *
 * @author Simonster
 */
public class UnitTests {
       //Assert.assertEquals(actual, expected);
  public static final String ANSI_CYAN  = "\u001B[36m"; //Used for output
  public static final String ANSI_RESET = "\u001B[00m"; //Used for output
  public static final String ANSI_RED   = "\u001B[31m"; //Use in test?
  public static final String ANSI_GREEN = "\u001B[32m"; //Use in test?    
    
    public static void testPassed(){
      System.out.println(ANSI_GREEN+"Passed"+ANSI_RESET);
        System.out.println("");
   }
   
   public static void testFailed(){
         System.out.println(ANSI_RED+"Failed"+ANSI_RESET);
         System.out.println("");
   }
   

    
   public static void run_IHD_UnitTests(){
   
       Projekt_IHD_UnitTests testIHD = new Projekt_IHD_UnitTests();
        
       Projekt_OHD_UnitTests testOHD = new Projekt_OHD_UnitTests();
       
             
      testIHD.setUp();
       
      if (testIHD.test_initialized() == true){
      testPassed();
      }else{
      testFailed();
      }
      
      testIHD.tearDown();
      
                   
      testIHD.setUp();
       
      if (testIHD.test_execute() == true){
      testPassed();
      }else{
      testFailed();
      }
      
      testIHD.tearDown();
      
            
      testIHD.setUp();
       
      if (testIHD.test_startSensor() == true){
      testPassed();
      }else{
      testFailed();
      }
      
      testIHD.tearDown();
       
      testIHD.setUp();
       
      if (testIHD.test_readSensor() == true){
      testPassed();
      }else{
      testFailed();
      }
      
      testIHD.tearDown();
      
//      testIHD.setUp();
//       
//      if (testIHD.test_getOutput_with_default_zero() == true){
//      testPassed();
//      }else{
//      testFailed();
//      }
//      
//      testIHD.tearDown();
//      

//      
//      testIHD.setUp();
//       
//      if (testIHD.test_getInputFromSensor_by_calling_getOutput() == true){
//      testPassed();
//      }else{
//      testFailed();
//      }
//      
//      testIHD.tearDown();

      testIHD.setUp();
       
      if (testIHD.test_input_boundaries() == true){
      testPassed();
      }else{
      testFailed();
      }
      
      testIHD.tearDown();
      
      
      testIHD.setUp();
       
      if (testIHD.test_mean() == true){
      testPassed();
      }else{
      testFailed();
      }
      
      testIHD.tearDown();
      
      
      

       System.out.println("Tests for IHD ended.");
      
   } // end of run
              
    public static void run_IAD_UnitTests(){
   
       Projekt_IAD_UnitTests testIAD = new Projekt_IAD_UnitTests();

  testIAD.setVerboseOutput(true);
             
      testIAD.setUp();
       
      if (testIAD.test_initialized_connect_two_IHDs() == true){
      testPassed();
      }else{
      testFailed();
      }
      
      testIAD.tearDown();
      
                 
      testIAD.setUp();
       
      if (testIAD.test_initialized_connect_one_IHD() == true){
      testPassed();
      }else{
      testFailed();
      }
      
      testIAD.tearDown();
             
      
      testIAD.setUp();
       
      if (testIAD.test_execute_connected_two_IHDs() == true){
      testPassed();
      }else{
      testFailed();
      }
      
      testIAD.tearDown();
    
         testIAD.setUp();
       
      if (testIAD.test_execute_connected_one_IHD()== true){
      testPassed();
      }else{
      testFailed();
      }
      
      testIAD.tearDown();
    
            testIAD.setUp();
       
      if (testIAD.test_analyze_30_limit_first_sensor() == true){
      testPassed();
      }else{
      testFailed();
      }
      
      testIAD.tearDown();
      
      testIAD.setUp();
       
      if (testIAD.test_analyze_30_limit_second_sensor() == true){
      testPassed();
      }else{
      testFailed();
      }
      
      testIAD.tearDown();
    
         testIAD.setUp();
       
      if (testIAD.test_analyze_5_limit() == true){
      testPassed();
      }else{
      testFailed();
      }
      
      testIAD.tearDown();
      
        System.out.println("Tests for IAD ended.");
      
   } // end of run_IAD_UnitTests
  
       public static void run_OHD_UnitTests(){
   
  
        
       Projekt_OHD_UnitTests testOHD = new Projekt_OHD_UnitTests();
       
       
            testOHD.setUp();
       
      if (testOHD.test_initialized() == true){
      testPassed();
      }else{
      testFailed();
      }
      
      testOHD.tearDown();
      
             
      testOHD.setUp();
       
      if (testOHD.test_output_independence_with_testMatrix_falsified_with_FFFFF() == true){
      testPassed();
      }else{
      testFailed();
      }
      
      testOHD.tearDown();
      
     

       System.out.println("Tests for OHD ended.");
      
   } // end of run
    
}

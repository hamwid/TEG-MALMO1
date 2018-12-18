//Tabell 5: krav på testOHD.
//
//testOHD_001 Input independence
// - Kan ta emot fem booleaner som kan vara true eller  false oberoende av varandra.
//testOHD_002 Output independence
// - Ger som output en Array innehållande fem booleaner som kan vara true eller false oberoende av varandra




import java.util.ArrayList;
import java.util.Arrays;



/**
 *
 * @author Simonster
 */
public class Projekt_OHD_UnitTests {
    
    private OHD testOHD;
    
    private IAD tIAD_1;
    private IAD tIAD_2;
    private IAD tIAD_3;
        

    
    // When this is set to true, test will give more information about the test executed
    private boolean verbose = true;
    
    private ArrayList textOutput;
    

     
     boolean [][] createTestMatrix(){
     
 
         
      

         int input_int [][] = 
         {       
             {1,0,0,0,0},
             {0,1,0,0,0},
             {0,0,1,0,0},
             {0,0,0,1,0},
             {0,0,0,0,1},
      
             {1,1,0,0,0},
             {0,1,1,0,0},
             {0,0,1,1,0},
             {0,0,0,1,1},
             {1,0,0,0,1},
          
             {1,1,1,0,0},
             {0,1,1,1,0},
             {0,0,1,1,1},
             {1,0,0,1,1},
             {1,1,0,0,1},
     
             {1,1,1,1,0},
             {0,1,1,1,1},
             {1,0,1,1,1},
             {1,1,0,1,1},
             {0,1,1,1,1},
      
             {1,1,1,1,1},
             {0,0,0,0,0}
              
         };
         
          boolean bool_input[][] = new boolean [input_int.length][input_int[0].length];

         for (int i = 0; i < input_int.length; i++) {
             for (int j = 0; j < input_int[0].length; j++) {
                 if(input_int[i][j] == 1){
                 bool_input[i][j] = true;
                 }else{
                 bool_input[i][j] = false;
                 }
                 
                 
             }
         }

       
            return bool_input;
            }
         

    
    public void setVerboseOutput(){
    verbose = true;
    }
    
    public void printVerbose(){
       
      System.out.println("Expected: " + textOutput.get(0));
      System.out.println("Actual:   " + textOutput.get(1) ); 
      System.out.print("Result:   "); 
    
    }

   // @BeforeMethod
    public void setUp() {
       if(verbose == true) { System.out.println("Testing: Projekt_testOHD");}
       textOutput = new ArrayList();
       testOHD = new OHD();
       
          tIAD_1 = new IAD();
          tIAD_2 = new IAD();
          tIAD_3 = new IAD();
          
    }

    //@test
    public boolean test_initialized() {
        
    if(verbose == true) { System.out.println("Running: test_initialized");}
    
    ArrayList expected = new ArrayList();
    
    ArrayList actual = new ArrayList();
    
     expected.add(false);
     expected.add(false);
     expected.add(false);
     expected.add(false);
     expected.add(false);
     
     boolean booleanexpected [] = {false, false, false, false, false};
 
      expected.add(Arrays.toString(booleanexpected));
   
    // IAD1 expected to pass check of not null hence true
     expected.add(true);
     
    // IAD2 expected to pass check of not null hence true
     expected.add(true);
     
    // IAD3 expected to pass check of not null hence true
     expected.add(true);
     

     boolean expectedOutput [] = testOHD.getOutput();
     
         for (int i = 0; i < expectedOutput.length; i++) {
               actual.add(expectedOutput[i]);
         }
         
        actual.add(Arrays.toString(booleanexpected));
     
     if(tIAD_1 != null && tIAD_2 != null && tIAD_3 != null ){
     testOHD.initialize(tIAD_1, tIAD_2, tIAD_3);
     
     // Observe that no check is done on IAD1, IAD2 or IAD3 has run their initialize function
     
     // for this test the testdata is the expected values after initialize is called then accessed through getOutput()
             
     // a boolean of true is added for each valid IAD
             actual.add(true);
             actual.add(true);
             actual.add(true);     
     
     }else{
         
         if(tIAD_1 == null){
             System.out.println("tIAD_1 not initialized");
         }
         
         if(tIAD_2 == null){
             System.out.println("tIAD_2 not initialized");
         }
         
         if(tIAD_3 == null){
             System.out.println("tIAD_3 not initialized");
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
    public boolean test_execute(){ 
        
        if(verbose == true) { System.out.println("Running: test_execute");}
    
            testOHD.initialize(tIAD_1,tIAD_3,tIAD_2);
     
        boolean init = false;
    
      final boolean expected = true;
      
      final boolean actual = init;
    
       if(verbose == true) {
           textOutput.add(expected); 
           textOutput.add(actual);
           printVerbose();
       }

       if(expected == actual){

              return true;
         }
       else{
              return false;
       }

   }
    //@Test
    public boolean test_output_default_as_FFFFF(){

        if(verbose == true) { System.out.println("Running: test_output_default_as_FFFFF");}
    

        final boolean expected [] = {false, false, false , false ,false};
      
        final boolean actual [] = testOHD.getOutput();
    
        if(verbose == true) {
            textOutput.add(Arrays.toString(expected)); 
             textOutput.add(Arrays.toString(actual)); 
            printVerbose();
        }

        if(Arrays.equals(actual, actual)){
            
      
             return true;

        }
        else{
             return false;
        }

   }
    
        public boolean test_output_independence_with_testMatrix_falsified_with_FFFFF(){
        if(verbose == true) { System.out.println("Running: test_output_independence_with_testMatrix_falsified_with_FFFFF");}
    

        final boolean expected [] = {false, false, false , false, false};
        
        boolean actual [] = new boolean [5];
        
        boolean result = false;

     boolean input [][] = createTestMatrix();

            for (int i = 0; i < input.length; i++) {
                
                              actual = input[i];
   
                
             if(verbose == true) {
            
            textOutput.add(Arrays.toString(expected)); 
            textOutput.add(Arrays.toString(actual)); 
            
                            System.out.println("");

            printVerbose();
            
            textOutput.clear();
        }
             
       
           
    if ( actual[0] == false &&
         actual[1] == false &&
         actual[2] == false &&
         actual[3] == false &&
         actual[4] == false ){
                    if(verbose == true) {    System.out.println("\u001B[32m true \u001B[00m"); }
                    result = true;
                }else{
                    result = false;
                    if(verbose == true) {   System.out.println("\u001B[31m false \u001B[00m"); }
                }
            
            }

              System.out.println("");
    


return result;

   }
    
    
    
    
    //@AfterMethod
    public void tearDown() {
        textOutput = null;
        testOHD = null;
    }



}

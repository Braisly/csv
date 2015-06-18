/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package csvtransform;

import java.io.*;


/**
 *
 * @author Brais
 */
public class csvtransform {

    /**
     * @param args the command line arguments
     */
    
    //Function to put the new content in the new files
    public static void writeContent(String nameFile, String newLine) throws IOException
    {
      File newFile = new File ("temperaturasFormato/"+nameFile+".csv");
      FileWriter w = new FileWriter(newFile,true);
      BufferedWriter bw = new BufferedWriter(w);
      //New file creation if it does not exist
      if(!newFile.exists())
        if(!newFile.createNewFile())
              System.out.println("Error! Problems to create the file"+nameFile);
      
      //Write in the new file
      bw.write(newLine+"\n");        
      bw.close();  //Close buffer
    }
    
    //Function to read the content of each line
    public static void readContent(String nameFile) throws FileNotFoundException, IOException 
    {
          String line,newLine;
          FileReader file = new FileReader("temperaturas/"+nameFile);
          BufferedReader buffer = new BufferedReader(file);
          while((line = buffer.readLine())!=null) 
          {   
              newLine=line.replace(" ", ",");
              writeContent(nameFile.substring(0, 6),newLine);
              //System.out.println(newLine);//System to see printing
          }
          buffer.close();//Close buffer
    }
    
    //Function to see all of files
    public static void runningFiles() throws IOException
    {//Loop to go over all of files, since 1854 to 2014, 7º month
      int i=0,j=0;
       
      //Loop of years
       for(i=1854;i<2015;i++)
           for(j=1;j<=12;j++)//Loop of months
               if(j<10)//Checking of month number
                   if(i==2014 && j==8)//if statement to finalize the program
                       System.exit(0);
                   else
                    readContent(i+"0"+j+"15"); 
                else
                 readContent(i+""+j+"15"); 
    }
    
    
    public static void main(String[] args) throws IOException 
    {
        //Process to adequate csv style
        runningFiles();        
    }
}

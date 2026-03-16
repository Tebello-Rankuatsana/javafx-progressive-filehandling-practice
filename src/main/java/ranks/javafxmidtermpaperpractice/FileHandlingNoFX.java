package ranks.javafxmidtermpaperpractice;

import java.io.*;

public class FileHandlingNoFX {
    public static void main(String[] args){
//        practicing file handling before i got in javafx applications
        try{
            BufferedWriter bw = new BufferedWriter(new FileWriter("person.txt"));
            bw.write("Just_ranks the goat");
            bw.newLine();
            bw.write("Line 3 baby");
            bw.close();
        }catch(IOException e){
            e.printStackTrace();
        }
//        reading from the file
        try{
            BufferedReader br = new BufferedReader(new FileReader("person.txt"));
            String line;
            while((line = br.readLine()) != null){
                System.out.println(line);
            }
        }catch(IOException i){
            i.printStackTrace();
        }
    }
}

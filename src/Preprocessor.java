/**
 * Created by rayyeon on 12/5/16.
 */
//import java.io.File;
import javax.swing.text.StyledEditorKit;
import java.io.IOException;
import java.util.Scanner;

public class Preprocessor {
    public static void main(String[] args) throws IOException
    {


        java.io.File outputFile = new java.io.File("temp.c");
        java.io.File outputPre = new java.io.File("preprocessFile.c");


        java.io.PrintStream output = new java.io.PrintStream(outputFile);
        java.io.PrintStream outPre = new java.io.PrintStream(outputPre);

//        if(outputFile.exists()){
//            System.out.println("File already exists");
//            System.exit(1);
//        }

        try{
            java.io.File file = new java.io.File(
                    "/Users/rayyeon/Documents/IdeaProjects/PPLAssignment3/src/a_test.c");
            Scanner input = new Scanner(file);

            boolean seperateLineCommentFlag = false;
            while(input.hasNext())
            {
                String line = input.nextLine();
                if(line.length() != 0) {
                    String[] words = line.split(" ");

                    /*Detect Define*/
                    if( words.length>0 && words[0].equals("#define")){
                        outPre.println(line);
                        continue;
//                        System.out.print(isNumber(words[2]) + "\n");
//                        if(words[2].startsWith("\"")){
//                        if(words.length == 3){
//                            System.out.println("Replace " + words[1] + " with " + words[2]);
//                        }
                    }

                    /*Detect Include*/
                    if (words.length>0 && words[0].equals("#include")){
                        outPre.println(line);
                        continue;
//                        System.out.println("Yes " + words[1]);
//                        System.out.println("Open file " + words[1] + "\n");

//                        if (words[1].startsWith("\"")) {
//                                System.out.print("Yes " + words[1]);
//                            java.io.File fileOfInclude = new java.io.File(words[1]);
//                            Scanner inputInclude = new Scanner(fileOfInclude);
//                            while (inputInclude.hasNext()) {
//                                String lineFromInclude = inputInclude.nextLine();
//                                output.println(lineFromInclude);
//                            }
//                        }
                    }

                    /*Single line comment detection*/
                    if(commentTest3(words))
                        continue;
                    if(commentTest1(words) == 3) {
                        output.println(wordsWithoutCommentEntail(words));
                        continue;
                    }
                    if(commentTest1(words) == 1){
                        seperateLineCommentFlag = true;
                        continue;
                    }
                    if(commentTest1(words) == 2){
                        seperateLineCommentFlag = false;
                        continue;
                    }
                    if(seperateLineCommentFlag)
                        continue;
                }
                output.println(line);
            }
        }
        catch (java.io.FileNotFoundException ex){
            System.out.println("Wrong");
        }

//        replacement();

    }
    public static void replacement() throws IOException{
        java.io.File file1 = new java.io.File("tempInclude.c");
        Scanner input2 = new Scanner(file1);

        java.io.File outputFile2 = new java.io.File("Final.c");
        java.io.PrintStream output2 = new java.io.PrintStream(outputFile2);

        while (input2.hasNext()){
            String line2 = input2.nextLine();
//            System.out.print("++:");
//            System.out.println(line2);
            output2.println(line2);

        }

    }

    public static boolean isNumber(String s){
        try {
            Integer.parseInt(s);
        } catch(NumberFormatException e) {
            try{
                Double.parseDouble(s);
            }
            catch (NumberFormatException e1){
                try{
                    Float.parseFloat(s);
                }
                catch (NumberFormatException e2){
                    return false;
                }
                return true;
            }
            return true;
        } catch(NullPointerException e) {
            return false;
        }
        // only got here if we didn't return false
        return true;
    }


    public static int commentTest1(String[] s){

        int head = 0;
        int tail = 0;
        int allget = 0;
        for(int i =0; i< s.length; i++)
        {
            if(s[i].equals("/*"))
                head = 1;
            if(s[i].equals("*/"))
                tail = 2;
        }
        //allget: 1 comment start, 2 commet finish, 3 comment complete in one line;
        allget = head + tail;
        return allget;
    }

    public static String wordsWithoutCommentEntail(String[] s){
        int index = 0;
        for(int i = 0; i < s.length; i++)
        {
            if(s[i].equals("/*"))
                index = i;
        }
        StringBuilder trimedString = new StringBuilder();

        for(int i = 0; i < index; i++)
        {
            trimedString.append(s[i]);
        }

        String newString = trimedString.toString();

        return newString;
    }



    public static boolean commentTest3(String[] s){
        boolean commenttest = false;
        for(int i =0; i< s.length; i++)
        {
            if(s[i].equals("//"))
                commenttest = true;
        }
        return commenttest;
    }
}

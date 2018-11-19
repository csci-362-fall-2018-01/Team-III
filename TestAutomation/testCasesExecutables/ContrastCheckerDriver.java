import java.util.List;
import java.util.LinkedList;
import java.util.ArrayList;
import java.util.Arrays;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.BufferedReader;
import java.nio.file.*;
import java.awt.Color;
import java.io.IOException;
import java.nio.charset.Charset;

//test case executable for ContrastChecker

public class ContrastCheckerDriver {
  public static void main(String[] args){

    String method = args[3];
    String inputs = args[4];
    String expected = args[5];

    String[] inputList = inputs.split(";");

    if(method.equals("getLuminosity()"))
    {
      String[] rgb = inputList[0].split(",");
      int[] rgbint = new int[rgb.length];
      for (int i=0; i < rgb.length; i++) {
          rgbint[i] = Integer.parseInt(rgb[i]);
      }

      Color rgbColor = new Color(rgbint[0],rgbint[1],rgbint[2]);
      Double actual = ContrastChecker.getLuminosity(rgbColor);
      //Boolean result = actual.toString().equals(expected);
      Boolean compareResults = actual.toString().equals(expected);
        String result;
        if(compareResults.toString().equals("true"))
        result = "Passed";
        else
        result = "Failed";
       
      
      System.out.println(actual.toString());
      System.out.println(result.toString());
    }

    if(method.equals("getContrastRatio5DigitRound()"))
    {
      //formatting inputs
      String[] fgrgb = inputList[0].split(",");
      String[] bgrgb = inputList[1].split(",");

      int[] fgint = new int[fgrgb.length];
      for (int i=0; i < fgrgb.length; i++) {
          fgint[i] = Integer.parseInt(fgrgb[i]);
      }

      int[] bgint = new int[bgrgb.length];
      for (int i=0; i < bgrgb.length; i++) {
          bgint[i] = Integer.parseInt(bgrgb[i]);
      }
      
      Color fgcolor = new Color(fgint[0], fgint[1], fgint[2]);
      Color bgcolor = new Color(bgint[0], bgint[1], bgint[2]);

      //gets result and compares to expected
      Double actual = ContrastChecker.getConstrastRatio5DigitRound(fgcolor,bgcolor);
      //Boolean result = actual.toString().equals(expected);
      Boolean compareResults = actual.toString().equals(expected);
        String result;
        if(compareResults.toString().equals("true"))
        result = "Passed";
        else
        result = "Failed";
       

      System.out.println(actual.toString());
      //System.out.println(result.toString());
      System.out.println(result);
    }
  }
}

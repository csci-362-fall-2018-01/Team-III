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

//test case executable for DistanceCalculator

public class DistanceCalculatorDriver {

  public static void main(String[] args){

    String method = args[3];
    String inputs = args[4];
    String expected = args[5];

    String[] inputList = inputs.split(";");

    if(method.equals("calculate()"))
    {
      //formatting inputs
      String[] firstColor= inputList[0].split(",");
      String[] nextColor = inputList[1].split(",");

     int[] fcToInt = new int[firstColor.length];
      for (int i=0; i < firstColor.length; i++) {
         fcToInt[i] = Integer.parseInt(firstColor[i]);
      }
      

     int[] ncToInt = new int[nextColor.length];
      for (int i=0; i < nextColor.length; i++) {
          ncToInt[i] = Integer.parseInt(nextColor[i]);
      }
      
      Color colorToChange = new Color(fcToInt[0],fcToInt[1],fcToInt[2]);
      Color colorToKeep = new Color(ncToInt[0],ncToInt[1],ncToInt[2]);

      //gets result and compares to expected
      Double actual = DistanceCalculator.calculate(colorToChange, colorToKeep);
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
  }
}

import java.awt.Color;

public class ColorConverterDriver {
    public static void main(String[] args){
  
      String method = args[3];
      String inputs = args[4];
      String expected = args[5];
  
      String[] inputList = inputs.split(";");
  
      if(method.equals("rgb2hsl()"))
      {
        String[] rgb = inputList[0].split(",");
        int[] rgbint = new int[rgb.length];
        for (int i=0; i < rgb.length; i++) {
            rgbint[i] = Integer.parseInt(rgb[i]);
        }
  
        Color rgbColor = new Color(rgbint[0],rgbint[1],rgbint[2]);
        String actual = ColorConverter.rgb2Hsl(rgbColor);
        //Boolean result = actual.equals(expected);
        Boolean compareResults = actual.toString().equals(expected);
        
        String result = "Failed";
        if(compareResults.toString().equals("true"))
        result = "Passed";
         
        System.out.println(actual);
        System.out.println(result.toString());
      }
  
      if(method.equals("hex2rgb()"))
      {
        //formatting inputs
        String rgb = inputList[0];

        Color actualColor = ColorConverter.hex2Rgb(rgb);
        if(actualColor==null){
          String actual = "null";
          
          //Boolean result = actual.toString().equals(expected);
          Boolean compareResults = actual.toString().equals(expected);
        String result = "Failed";
        if(compareResults.toString().equals("true"))
        result = "Passed";

          System.out.println(actual);
          System.out.println(result.toString());
        }

        else{
        Integer r = actualColor.getRed();
        Integer g = actualColor.getGreen();
        Integer b = actualColor.getBlue();

        String actual = r.toString()+","+g.toString()+","+b.toString();
        Boolean compareResults = actual.toString().equals(expected);
        String result = "Failed";
        if(compareResults.toString().equals("true"))
        result = "Passed";
           
		  System.out.println(actual.toString());
        System.out.println(result.toString());
        }
      }
    }
  }

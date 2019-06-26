package com.example.callum.storygenerator.generator;

public class StringFormatter
{
    /*
     * Remove punctuation from strings Only allow specified ASCII character
     */
    public static String stripPunctuation(String s)
    {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < s.length(); i++)
        {
            if ((s.charAt(i) >= 65 && s.charAt(i) <= 90) // uppercase letters
                    || (s.charAt(i) >= 97 && s.charAt(i) <= 122) // lowercase
                    || (s.charAt(i) >= 48 && s.charAt(i) <= 57) // integers
                    || (s.charAt(i) == 32)) // spaces

                sb = sb.append(s.charAt(i));
        }
        return sb.toString();
    }

    /*
     * Convert all words to lowercase
     */
    public static String lowerCase(String line)
    {
        line = line.toLowerCase();

        // Any instance of i should be capitalized
        line = line.replaceAll(" i ", " I ");
        line = line.replaceAll("i ", "I ");
        line = line.replaceAll(" i.", " I.");
        return line;
    }

    /*
     * Capitalize word
     */
    public static String capitalizeWord(String word)
    {
        String firstLetter = word.substring(0, 1); // Get first letter
        String remainder = word.substring(1); // Get remainder of word.
        String capitalized = firstLetter.toUpperCase() + remainder;
        return capitalized;
    }

}

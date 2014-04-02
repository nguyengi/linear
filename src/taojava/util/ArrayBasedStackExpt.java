package taojava.util;

/**
 * A really simple experiment with ArrayBasedStacks.
 * 
 * @author Samuel A. Rebelsky
 * @author Giang Nguyen
 * @author Graeme Boy
 */
public class ArrayBasedStackExpt
{
  /**
   * function indexOf
   * 
   * Returns the position of a character in an array of characters.
   * 
   * @param needle
   *          , a char to search for
   * 
   * @param haystack
   *          , an array of chars through which to search
   * 
   * @return index, an integer index of where the character is in array, or -1
   *         if character not found.
   */
  public static int indexOf(char needle, char[] haystack)
  {
    for (int i = 0; i < haystack.length; i++)
      {
        if (haystack[i] == needle)
          {
            return i;
          }
      } // for
    return -1; // did not find it.
  } // indexOf (char, char[])

  /**
   * function checkMatching
   * 
   * Checks a string to make sure that parentheses are correctly matched.
   * 
   * @pre parentheses are either '()', '{}', or '[]'
   * @param str
   * @return boolean, true if correctly matched with extraneous open parenthesis
   */
  public static boolean checkMatching(String str)
  {
    try
      {
        // Define the types of parens we can use:
        char[] open = { '(', '{', '[' };
        char[] close = { ')', '}', ']' };
        
        // Create a stack to hold the parens as we encounter them
        ArrayBasedStack abs = new ArrayBasedStack<Character>(str.length());

        // iterate through characters of the string
        for (int i = 0; i < str.length(); i++)
          {
              // if open is encountered, push it to stack
            if (indexOf(str.charAt(i), open) >= 0)
              {
                // push
                abs.push(str.charAt(i));
              } // if
            else if (indexOf(str.charAt(i), close) >= 0)
              {
                // pop
                if (abs.isEmpty())
                  {
                    return false;
                  } // if
                else
                  {
                    if (indexOf((char) abs.peek(), open) == indexOf(str.charAt(i),
                                                                    close))
                      {
                        // the close matches the last open
                        abs.pop();
                      }
                    else
                      {
                        return false; // did not match
                      }
                  } // else
              }
          } // for

        return abs.isEmpty(); // if not empty, return false.

      } // try
    catch (Exception e)
      {
        // TODO Auto-generated catch block
        e.printStackTrace();
      } // catch

    return true; // stub

  } // checkMatching (String)

  public static void main(String[] args)
    throws Exception
  {
    // Perform some trivial testing
    String test = "(sum 7 (minus 12 (product 2 5)))";
    // true
    System.out.println("Matching? " + checkMatching(test));

    String test1 = "(sum 7 {minus 12 (product 2 5)})";
    // true
    System.out.println("Matching? " + checkMatching(test1));

    String test2 = "{sum 7 (minus 12 (product 2 5)))";
    // false
    System.out.println("Matching? " + checkMatching(test2));

    String test3 = "(sum 7 (minus 12 (product 2 5))))";
    // false
    System.out.println("Matching? " + checkMatching(test3));

  } // main(String[])
} // class ArrayBasedStackExpt

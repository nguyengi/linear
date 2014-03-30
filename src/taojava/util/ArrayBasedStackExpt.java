package taojava.util;

/**
 * A really simple experiment with ArrayBasedStacks.
 *
 * @author Samuel A. Rebelsky.
 */
public class ArrayBasedStackExpt
{
  /**
   * Do all the work.  (Well, make the helpers do all the work.)
   */
  public static void main(String[] args)
    throws Exception
  {
    LSExpt.expt01(new ArrayBasedStack<String>(16), "size16.");
    LSExpt.expt01(new ArrayBasedStack<String>(4), "size04.");
  } // main(String[])
} // class ArrayBasedStackExpt

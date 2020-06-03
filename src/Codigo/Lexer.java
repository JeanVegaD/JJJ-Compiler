/* The following code was generated by JFlex 1.4.3 on 3/6/20 16:38 */

package Codigo;
import static Codigo.Tokens.*;

/**
 * This class is a scanner generated by 
 * <a href="http://www.jflex.de/">JFlex</a> 1.4.3
 * on 3/6/20 16:38 from the specification file
 * <tt>src/Codigo/Lexer.flex</tt>
 */
class Lexer {

  /** This character denotes the end of file */
  public static final int YYEOF = -1;

  /** initial size of the lookahead buffer */
  private static final int ZZ_BUFFERSIZE = 16384;

  /** lexical states */
  public static final int YYINITIAL = 0;

  /**
   * ZZ_LEXSTATE[l] is the state in the DFA for the lexical state l
   * ZZ_LEXSTATE[l+1] is the state in the DFA for the lexical state l
   *                  at the beginning of a line
   * l is of the form l = 2*k, k a non negative integer
   */
  private static final int ZZ_LEXSTATE[] = { 
     0, 0
  };

  /** 
   * Translates characters to character classes
   */
  private static final String ZZ_CMAP_PACKED = 
    "\11\0\1\1\1\2\2\0\1\1\22\0\1\1\1\47\1\6\1\16"+
    "\1\0\1\46\1\50\1\10\1\7\1\7\1\14\1\45\1\17\1\11"+
    "\1\15\1\46\1\4\11\5\1\17\1\0\1\47\1\20\1\32\1\0"+
    "\1\13\32\3\1\17\1\0\1\17\1\46\1\12\1\0\1\22\1\43"+
    "\1\42\1\36\1\26\1\34\1\51\1\41\1\23\1\3\1\44\1\33"+
    "\1\21\1\24\1\37\1\31\1\3\1\25\1\35\1\27\1\30\1\52"+
    "\1\40\3\3\1\17\1\50\1\17\uff82\0";

  /** 
   * Translates characters to character classes
   */
  private static final char [] ZZ_CMAP = zzUnpackCMap(ZZ_CMAP_PACKED);

  /** 
   * Translates DFA states to action switch labels.
   */
  private static final int [] ZZ_ACTION = zzUnpackAction();

  private static final String ZZ_ACTION_PACKED_0 =
    "\1\0\1\1\1\2\1\3\1\4\2\5\1\1\1\6"+
    "\1\1\1\7\1\1\1\7\1\10\1\11\7\4\1\12"+
    "\6\4\1\7\2\12\1\4\1\5\3\0\1\13\2\0"+
    "\2\4\1\14\15\4\1\13\1\4\1\5\1\0\1\15"+
    "\1\0\1\15\16\4\3\0\6\4\1\15\3\4";

  private static int [] zzUnpackAction() {
    int [] result = new int[90];
    int offset = 0;
    offset = zzUnpackAction(ZZ_ACTION_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackAction(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }


  /** 
   * Translates a state to a row index in the transition table
   */
  private static final int [] ZZ_ROWMAP = zzUnpackRowMap();

  private static final String ZZ_ROWMAP_PACKED_0 =
    "\0\0\0\53\0\126\0\53\0\201\0\254\0\327\0\u0102"+
    "\0\53\0\u012d\0\u0158\0\u0183\0\53\0\53\0\u01ae\0\u01d9"+
    "\0\u0204\0\u022f\0\u025a\0\u0285\0\u02b0\0\u02db\0\u0306\0\u0331"+
    "\0\u035c\0\u0387\0\u03b2\0\u03dd\0\u0408\0\u0433\0\u01ae\0\53"+
    "\0\u045e\0\u0489\0\u04b4\0\u04df\0\254\0\u050a\0\u0535\0\u0560"+
    "\0\u058b\0\u05b6\0\201\0\u05e1\0\u060c\0\u0637\0\u0662\0\u068d"+
    "\0\u06b8\0\u06e3\0\u070e\0\u0739\0\u0764\0\u078f\0\u07ba\0\u07e5"+
    "\0\53\0\u0810\0\53\0\u083b\0\53\0\u0866\0\u0891\0\u08bc"+
    "\0\u08e7\0\u0912\0\u093d\0\u0968\0\u0993\0\u09be\0\u09e9\0\u0a14"+
    "\0\u0a3f\0\u0a6a\0\u0a95\0\u0ac0\0\u0aeb\0\u0b16\0\u0891\0\u0b41"+
    "\0\u0b6c\0\u0b97\0\u0bc2\0\u0bed\0\u0c18\0\u0c43\0\u0535\0\u0c6e"+
    "\0\u0c99\0\u0cc4";

  private static int [] zzUnpackRowMap() {
    int [] result = new int[90];
    int offset = 0;
    offset = zzUnpackRowMap(ZZ_ROWMAP_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackRowMap(String packed, int offset, int [] result) {
    int i = 0;  /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int high = packed.charAt(i++) << 16;
      result[j++] = high | packed.charAt(i++);
    }
    return j;
  }

  /** 
   * The transition table of the DFA
   */
  private static final int [] ZZ_TRANS = zzUnpackTrans();

  private static final String ZZ_TRANS_PACKED_0 =
    "\1\2\1\3\1\4\1\5\1\6\1\7\1\10\1\11"+
    "\1\12\1\13\1\5\1\14\1\15\1\2\1\16\1\11"+
    "\1\17\1\20\1\5\1\21\1\22\1\23\1\24\1\25"+
    "\1\5\1\26\1\27\1\5\1\30\1\31\1\32\1\5"+
    "\1\33\1\5\1\34\1\35\1\5\1\36\1\15\1\37"+
    "\1\40\1\5\1\41\54\0\1\3\54\0\3\5\4\0"+
    "\1\5\6\0\11\5\1\0\12\5\4\0\2\5\15\0"+
    "\1\42\41\0\2\7\7\0\1\42\35\0\2\43\1\0"+
    "\3\43\1\0\44\43\3\0\1\44\15\0\11\44\1\0"+
    "\12\44\4\0\2\44\4\0\1\45\1\7\3\0\1\46"+
    "\41\0\2\47\1\0\11\47\1\50\36\47\20\0\1\40"+
    "\35\0\3\5\4\0\1\5\6\0\1\5\1\51\7\5"+
    "\1\0\12\5\4\0\2\5\3\0\3\5\4\0\1\5"+
    "\6\0\3\5\1\52\5\5\1\0\1\5\1\53\10\5"+
    "\4\0\2\5\3\0\3\5\4\0\1\5\6\0\7\5"+
    "\1\54\1\5\1\0\12\5\4\0\2\5\3\0\3\5"+
    "\4\0\1\5\6\0\5\5\1\55\3\5\1\0\12\5"+
    "\4\0\2\5\3\0\3\5\4\0\1\5\6\0\11\5"+
    "\1\0\1\56\11\5\4\0\2\5\3\0\3\5\4\0"+
    "\1\5\6\0\4\5\1\57\4\5\1\0\12\5\4\0"+
    "\2\5\3\0\3\5\4\0\1\5\6\0\4\5\1\60"+
    "\4\5\1\0\12\5\4\0\2\5\20\0\1\40\11\0"+
    "\1\11\23\0\3\5\4\0\1\5\6\0\1\5\1\24"+
    "\7\5\1\0\1\61\11\5\4\0\2\5\3\0\3\5"+
    "\4\0\1\5\6\0\6\5\1\62\2\5\1\0\5\5"+
    "\1\63\4\5\4\0\2\5\3\0\3\5\4\0\1\5"+
    "\6\0\5\5\1\64\3\5\1\0\4\5\1\53\5\5"+
    "\4\0\2\5\3\0\3\5\4\0\1\5\6\0\11\5"+
    "\1\0\6\5\1\65\3\5\4\0\2\5\3\0\3\5"+
    "\4\0\1\5\6\0\1\5\1\56\7\5\1\0\6\5"+
    "\1\66\3\5\4\0\2\5\3\0\3\5\4\0\1\5"+
    "\6\0\4\5\1\67\4\5\1\0\4\5\1\70\5\5"+
    "\4\0\2\5\45\0\1\71\10\0\3\5\4\0\1\5"+
    "\6\0\11\5\1\0\4\5\1\72\5\5\4\0\2\5"+
    "\4\0\2\42\45\0\2\43\1\0\3\43\1\73\44\43"+
    "\10\0\1\73\47\0\1\74\45\0\2\47\1\75\50\47"+
    "\2\76\1\77\4\76\1\47\3\76\2\47\36\76\3\0"+
    "\3\5\4\0\1\5\6\0\2\5\1\100\6\5\1\0"+
    "\12\5\4\0\2\5\3\0\3\5\4\0\1\5\6\0"+
    "\6\5\1\53\1\5\1\101\1\0\12\5\4\0\2\5"+
    "\3\0\3\5\4\0\1\5\6\0\11\5\1\0\1\102"+
    "\11\5\4\0\2\5\3\0\3\5\4\0\1\5\6\0"+
    "\6\5\1\103\2\5\1\0\12\5\4\0\2\5\3\0"+
    "\3\5\4\0\1\5\6\0\11\5\1\0\2\5\1\104"+
    "\7\5\4\0\2\5\3\0\3\5\4\0\1\5\6\0"+
    "\7\5\1\104\1\5\1\0\12\5\4\0\2\5\3\0"+
    "\3\5\4\0\1\5\6\0\2\5\1\105\6\5\1\0"+
    "\12\5\4\0\2\5\3\0\3\5\4\0\1\5\6\0"+
    "\11\5\1\0\4\5\1\106\5\5\4\0\2\5\3\0"+
    "\3\5\4\0\1\5\6\0\4\5\1\107\4\5\1\0"+
    "\12\5\4\0\2\5\3\0\3\5\4\0\1\5\6\0"+
    "\2\5\1\110\6\5\1\0\12\5\4\0\2\5\3\0"+
    "\3\5\4\0\1\5\6\0\11\5\1\0\1\5\1\111"+
    "\10\5\4\0\2\5\3\0\3\5\4\0\1\5\6\0"+
    "\2\5\1\112\6\5\1\0\12\5\4\0\2\5\3\0"+
    "\3\5\4\0\1\5\6\0\1\5\1\113\7\5\1\0"+
    "\12\5\4\0\2\5\3\0\3\5\4\0\1\5\6\0"+
    "\5\5\1\114\3\5\1\0\12\5\4\0\2\5\3\0"+
    "\3\5\4\0\1\5\6\0\11\5\1\0\4\5\1\102"+
    "\5\5\4\0\2\5\3\0\3\5\4\0\1\5\6\0"+
    "\2\5\1\115\6\5\1\0\12\5\4\0\2\5\4\0"+
    "\2\74\7\0\1\42\35\0\2\76\1\77\4\76\1\47"+
    "\3\76\1\47\1\116\36\76\7\117\1\0\3\117\1\0"+
    "\1\120\36\117\3\0\3\5\4\0\1\5\6\0\3\5"+
    "\1\53\5\5\1\0\12\5\4\0\2\5\3\0\3\5"+
    "\4\0\1\5\6\0\7\5\1\121\1\5\1\0\12\5"+
    "\4\0\2\5\3\0\3\5\4\0\1\5\6\0\11\5"+
    "\1\0\1\53\11\5\4\0\2\5\3\0\3\5\4\0"+
    "\1\5\6\0\7\5\1\122\1\5\1\0\12\5\4\0"+
    "\2\5\3\0\3\5\4\0\1\5\6\0\5\5\1\53"+
    "\3\5\1\0\12\5\4\0\2\5\3\0\3\5\4\0"+
    "\1\5\6\0\3\5\1\121\5\5\1\0\12\5\4\0"+
    "\2\5\3\0\3\5\4\0\1\5\6\0\1\5\1\121"+
    "\7\5\1\0\12\5\4\0\2\5\3\0\3\5\4\0"+
    "\1\5\6\0\2\5\1\123\6\5\1\0\12\5\4\0"+
    "\2\5\3\0\3\5\4\0\1\5\6\0\6\5\1\124"+
    "\2\5\1\0\12\5\4\0\2\5\3\0\3\5\4\0"+
    "\1\5\6\0\1\5\1\125\7\5\1\0\12\5\4\0"+
    "\2\5\3\0\3\5\4\0\1\5\6\0\11\5\1\0"+
    "\1\104\11\5\4\0\2\5\3\0\3\5\4\0\1\5"+
    "\6\0\4\5\1\53\4\5\1\0\12\5\4\0\2\5"+
    "\3\0\3\5\4\0\1\5\6\0\1\5\1\126\7\5"+
    "\1\0\12\5\4\0\2\5\3\0\3\5\4\0\1\5"+
    "\6\0\11\5\1\0\3\5\1\53\6\5\4\0\2\5"+
    "\2\47\1\75\10\47\1\127\37\47\13\0\1\75\42\0"+
    "\3\5\4\0\1\5\6\0\6\5\1\53\2\5\1\0"+
    "\12\5\4\0\2\5\3\0\3\5\4\0\1\5\6\0"+
    "\4\5\1\100\4\5\1\0\12\5\4\0\2\5\3\0"+
    "\3\5\4\0\1\5\6\0\3\5\1\130\5\5\1\0"+
    "\12\5\4\0\2\5\3\0\3\5\4\0\1\5\6\0"+
    "\11\5\1\0\7\5\1\131\2\5\4\0\2\5\3\0"+
    "\3\5\4\0\1\5\6\0\7\5\1\132\1\5\1\0"+
    "\12\5\4\0\2\5\3\0\3\5\4\0\1\5\6\0"+
    "\11\5\1\0\11\5\1\53\4\0\2\5\3\0\3\5"+
    "\4\0\1\5\6\0\11\5\1\0\12\5\4\0\1\53"+
    "\1\5\3\0\3\5\4\0\1\5\6\0\11\5\1\0"+
    "\6\5\1\53\3\5\4\0\2\5\3\0\3\5\4\0"+
    "\1\5\6\0\11\5\1\0\1\121\11\5\4\0\2\5";

  private static int [] zzUnpackTrans() {
    int [] result = new int[3311];
    int offset = 0;
    offset = zzUnpackTrans(ZZ_TRANS_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackTrans(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      value--;
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }


  /* error codes */
  private static final int ZZ_UNKNOWN_ERROR = 0;
  private static final int ZZ_NO_MATCH = 1;
  private static final int ZZ_PUSHBACK_2BIG = 2;

  /* error messages for the codes above */
  private static final String ZZ_ERROR_MSG[] = {
    "Unkown internal scanner error",
    "Error: could not match input",
    "Error: pushback value was too large"
  };

  /**
   * ZZ_ATTRIBUTE[aState] contains the attributes of state <code>aState</code>
   */
  private static final int [] ZZ_ATTRIBUTE = zzUnpackAttribute();

  private static final String ZZ_ATTRIBUTE_PACKED_0 =
    "\1\0\1\11\1\1\1\11\4\1\1\11\3\1\2\11"+
    "\21\1\1\11\2\1\3\0\1\1\2\0\20\1\1\11"+
    "\1\1\1\11\1\0\1\11\1\0\17\1\3\0\12\1";

  private static int [] zzUnpackAttribute() {
    int [] result = new int[90];
    int offset = 0;
    offset = zzUnpackAttribute(ZZ_ATTRIBUTE_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackAttribute(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }

  /** the input device */
  private java.io.Reader zzReader;

  /** the current state of the DFA */
  private int zzState;

  /** the current lexical state */
  private int zzLexicalState = YYINITIAL;

  /** this buffer contains the current text to be matched and is
      the source of the yytext() string */
  private char zzBuffer[] = new char[ZZ_BUFFERSIZE];

  /** the textposition at the last accepting state */
  private int zzMarkedPos;

  /** the current text position in the buffer */
  private int zzCurrentPos;

  /** startRead marks the beginning of the yytext() string in the buffer */
  private int zzStartRead;

  /** endRead marks the last character in the buffer, that has been read
      from input */
  private int zzEndRead;

  /** number of newlines encountered up to the start of the matched text */
  private int yyline;

  /** the number of characters up to the start of the matched text */
  private int yychar;

  /**
   * the number of characters from the last newline up to the start of the 
   * matched text
   */
  private int yycolumn;

  /** 
   * zzAtBOL == true <=> the scanner is currently at the beginning of a line
   */
  private boolean zzAtBOL = true;

  /** zzAtEOF == true <=> the scanner is at the EOF */
  private boolean zzAtEOF;

  /** denotes if the user-EOF-code has already been executed */
  private boolean zzEOFDone;

  /* user code: */
    public String lexemas;


  /**
   * Creates a new scanner
   * There is also a java.io.InputStream version of this constructor.
   *
   * @param   in  the java.io.Reader to read input from.
   */
  Lexer(java.io.Reader in) {
    this.zzReader = in;
  }

  /**
   * Creates a new scanner.
   * There is also java.io.Reader version of this constructor.
   *
   * @param   in  the java.io.Inputstream to read input from.
   */
  Lexer(java.io.InputStream in) {
    this(new java.io.InputStreamReader(in));
  }

  /** 
   * Unpacks the compressed character translation table.
   *
   * @param packed   the packed character translation table
   * @return         the unpacked character translation table
   */
  private static char [] zzUnpackCMap(String packed) {
    char [] map = new char[0x10000];
    int i = 0;  /* index in packed string  */
    int j = 0;  /* index in unpacked array */
    while (i < 132) {
      int  count = packed.charAt(i++);
      char value = packed.charAt(i++);
      do map[j++] = value; while (--count > 0);
    }
    return map;
  }


  /**
   * Refills the input buffer.
   *
   * @return      <code>false</code>, iff there was new input.
   * 
   * @exception   java.io.IOException  if any I/O-Error occurs
   */
  private boolean zzRefill() throws java.io.IOException {

    /* first: make room (if you can) */
    if (zzStartRead > 0) {
      System.arraycopy(zzBuffer, zzStartRead,
                       zzBuffer, 0,
                       zzEndRead-zzStartRead);

      /* translate stored positions */
      zzEndRead-= zzStartRead;
      zzCurrentPos-= zzStartRead;
      zzMarkedPos-= zzStartRead;
      zzStartRead = 0;
    }

    /* is the buffer big enough? */
    if (zzCurrentPos >= zzBuffer.length) {
      /* if not: blow it up */
      char newBuffer[] = new char[zzCurrentPos*2];
      System.arraycopy(zzBuffer, 0, newBuffer, 0, zzBuffer.length);
      zzBuffer = newBuffer;
    }

    /* finally: fill the buffer with new input */
    int numRead = zzReader.read(zzBuffer, zzEndRead,
                                            zzBuffer.length-zzEndRead);

    if (numRead > 0) {
      zzEndRead+= numRead;
      return false;
    }
    // unlikely but not impossible: read 0 characters, but not at end of stream    
    if (numRead == 0) {
      int c = zzReader.read();
      if (c == -1) {
        return true;
      } else {
        zzBuffer[zzEndRead++] = (char) c;
        return false;
      }     
    }

	// numRead < 0
    return true;
  }

    
  /**
   * Closes the input stream.
   */
  public final void yyclose() throws java.io.IOException {
    zzAtEOF = true;            /* indicate end of file */
    zzEndRead = zzStartRead;  /* invalidate buffer    */

    if (zzReader != null)
      zzReader.close();
  }


  /**
   * Resets the scanner to read from a new input stream.
   * Does not close the old reader.
   *
   * All internal variables are reset, the old input stream 
   * <b>cannot</b> be reused (internal buffer is discarded and lost).
   * Lexical state is set to <tt>ZZ_INITIAL</tt>.
   *
   * @param reader   the new input stream 
   */
  public final void yyreset(java.io.Reader reader) {
    zzReader = reader;
    zzAtBOL  = true;
    zzAtEOF  = false;
    zzEOFDone = false;
    zzEndRead = zzStartRead = 0;
    zzCurrentPos = zzMarkedPos = 0;
    yyline = yychar = yycolumn = 0;
    zzLexicalState = YYINITIAL;
  }


  /**
   * Returns the current lexical state.
   */
  public final int yystate() {
    return zzLexicalState;
  }


  /**
   * Enters a new lexical state
   *
   * @param newState the new lexical state
   */
  public final void yybegin(int newState) {
    zzLexicalState = newState;
  }


  /**
   * Returns the text matched by the current regular expression.
   */
  public final String yytext() {
    return new String( zzBuffer, zzStartRead, zzMarkedPos-zzStartRead );
  }


  /**
   * Returns the character at position <tt>pos</tt> from the 
   * matched text. 
   * 
   * It is equivalent to yytext().charAt(pos), but faster
   *
   * @param pos the position of the character to fetch. 
   *            A value from 0 to yylength()-1.
   *
   * @return the character at position pos
   */
  public final char yycharat(int pos) {
    return zzBuffer[zzStartRead+pos];
  }


  /**
   * Returns the length of the matched text region.
   */
  public final int yylength() {
    return zzMarkedPos-zzStartRead;
  }


  /**
   * Reports an error that occured while scanning.
   *
   * In a wellformed scanner (no or only correct usage of 
   * yypushback(int) and a match-all fallback rule) this method 
   * will only be called with things that "Can't Possibly Happen".
   * If this method is called, something is seriously wrong
   * (e.g. a JFlex bug producing a faulty scanner etc.).
   *
   * Usual syntax/scanner level error handling should be done
   * in error fallback rules.
   *
   * @param   errorCode  the code of the errormessage to display
   */
  private void zzScanError(int errorCode) {
    String message;
    try {
      message = ZZ_ERROR_MSG[errorCode];
    }
    catch (ArrayIndexOutOfBoundsException e) {
      message = ZZ_ERROR_MSG[ZZ_UNKNOWN_ERROR];
    }

    throw new Error(message);
  } 


  /**
   * Pushes the specified amount of characters back into the input stream.
   *
   * They will be read again by then next call of the scanning method
   *
   * @param number  the number of characters to be read again.
   *                This number must not be greater than yylength()!
   */
  public void yypushback(int number)  {
    if ( number > yylength() )
      zzScanError(ZZ_PUSHBACK_2BIG);

    zzMarkedPos -= number;
  }


  /**
   * Resumes scanning until the next regular expression is matched,
   * the end of input is encountered or an I/O-Error occurs.
   *
   * @return      the next token
   * @exception   java.io.IOException  if any I/O-Error occurs
   */
  public Tokens yylex() throws java.io.IOException {
    int zzInput;
    int zzAction;

    // cached fields:
    int zzCurrentPosL;
    int zzMarkedPosL;
    int zzEndReadL = zzEndRead;
    char [] zzBufferL = zzBuffer;
    char [] zzCMapL = ZZ_CMAP;

    int [] zzTransL = ZZ_TRANS;
    int [] zzRowMapL = ZZ_ROWMAP;
    int [] zzAttrL = ZZ_ATTRIBUTE;

    while (true) {
      zzMarkedPosL = zzMarkedPos;

      zzAction = -1;

      zzCurrentPosL = zzCurrentPos = zzStartRead = zzMarkedPosL;
  
      zzState = ZZ_LEXSTATE[zzLexicalState];


      zzForAction: {
        while (true) {
    
          if (zzCurrentPosL < zzEndReadL)
            zzInput = zzBufferL[zzCurrentPosL++];
          else if (zzAtEOF) {
            zzInput = YYEOF;
            break zzForAction;
          }
          else {
            // store back cached positions
            zzCurrentPos  = zzCurrentPosL;
            zzMarkedPos   = zzMarkedPosL;
            boolean eof = zzRefill();
            // get translated positions and possibly new buffer
            zzCurrentPosL  = zzCurrentPos;
            zzMarkedPosL   = zzMarkedPos;
            zzBufferL      = zzBuffer;
            zzEndReadL     = zzEndRead;
            if (eof) {
              zzInput = YYEOF;
              break zzForAction;
            }
            else {
              zzInput = zzBufferL[zzCurrentPosL++];
            }
          }
          int zzNext = zzTransL[ zzRowMapL[zzState] + zzCMapL[zzInput] ];
          if (zzNext == -1) break zzForAction;
          zzState = zzNext;

          int zzAttributes = zzAttrL[zzState];
          if ( (zzAttributes & 1) == 1 ) {
            zzAction = zzState;
            zzMarkedPosL = zzCurrentPosL;
            if ( (zzAttributes & 8) == 8 ) break zzForAction;
          }

        }
      }

      // store back cached position
      zzMarkedPos = zzMarkedPosL;

      switch (zzAction < 0 ? zzAction : ZZ_ACTION[zzAction]) {
        case 11: 
          { lexemas=yytext(); return OPERADOR_UNARIO;
          }
        case 14: break;
        case 7: 
          { lexemas=yytext(); return OPERADOR_ARITMETICO;
          }
        case 15: break;
        case 4: 
          { lexemas=yytext(); return IDENTIFICADOR;
          }
        case 16: break;
        case 3: 
          { /**/
          }
        case 17: break;
        case 1: 
          { return ERROR;
          }
        case 18: break;
        case 6: 
          { lexemas=yytext(); return TERMINAL;
          }
        case 19: break;
        case 5: 
          { lexemas=yytext(); return LITERAL;
          }
        case 20: break;
        case 13: 
          { lexemas=yytext(); return COMENTARIO;
          }
        case 21: break;
        case 9: 
          { lexemas=yytext(); return ASIGNACION;
          }
        case 22: break;
        case 10: 
          { lexemas=yytext(); return OPERADOR_RELACIONAL;
          }
        case 23: break;
        case 8: 
          { lexemas=yytext(); return DELIMITADOR;
          }
        case 24: break;
        case 12: 
          { lexemas=yytext(); return RESERVADA;
          }
        case 25: break;
        case 2: 
          { /*Ignore*/
          }
        case 26: break;
        default: 
          if (zzInput == YYEOF && zzStartRead == zzCurrentPos) {
            zzAtEOF = true;
            return null;
          } 
          else {
            zzScanError(ZZ_NO_MATCH);
          }
      }
    }
  }


}

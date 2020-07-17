/* The following code was generated by JFlex 1.4.3 on 16/7/20 23:16 */


package Codigo;
import java_cup.runtime.Symbol;

/**
 * This class is a scanner generated by 
 * <a href="http://www.jflex.de/">JFlex</a> 1.4.3
 * on 16/7/20 23:16 from the specification file
 * <tt>src/Codigo/lexerCup.flex</tt>
 */
class LexerCup implements java_cup.runtime.Scanner {

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
  private static final char [] ZZ_CMAP = {
     0,  0,  0,  0,  0,  0,  0,  0,  0,  1,  2,  0,  0,  1,  0,  0, 
     0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0, 
     1, 49,  6, 14,  0, 47, 50,  8, 31,  7, 12, 44, 32,  9, 13, 45, 
     4,  5,  5,  5,  5,  5,  5,  5,  5,  5, 43,  0, 48, 17, 27, 42, 
    11,  3,  3,  3,  3,  3,  3,  3,  3, 56,  3,  3,  3,  3,  3,  3, 
     3,  3,  3, 54, 55,  3,  3,  3,  3,  3,  3, 29,  0, 30, 46, 10, 
     0, 19, 40, 39, 35, 23, 33, 52, 38, 20,  3, 41, 28, 18, 21, 36, 
    26,  3, 22, 34, 24, 25, 53, 37,  3,  3,  3, 15, 51, 16,  0,  0, 
     0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0, 
     0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0, 
     0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0, 
     0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0, 
     0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0, 
     0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0, 
     0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0, 
     0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0
  };

  /** 
   * Translates DFA states to action switch labels.
   */
  private static final int [] ZZ_ACTION = zzUnpackAction();

  private static final String ZZ_ACTION_PACKED_0 =
    "\1\1\1\2\1\1\1\3\1\4\2\5\1\2\1\6"+
    "\1\2\1\7\1\2\1\10\1\11\1\12\1\13\1\14"+
    "\7\4\1\15\1\16\1\17\1\20\1\21\6\4\1\22"+
    "\1\23\1\24\1\25\1\26\1\27\1\30\1\31\1\32"+
    "\1\33\2\4\1\34\3\0\1\35\2\0\1\36\2\4"+
    "\1\37\5\4\1\40\1\41\6\4\1\42\5\4\1\43"+
    "\1\44\1\45\2\4\1\46\1\47\1\0\1\50\1\0"+
    "\1\50\1\4\1\51\10\4\1\52\12\4\3\0\1\53"+
    "\1\4\1\54\1\4\1\55\1\56\7\4\1\57\1\60"+
    "\1\4\1\61\1\62\1\4\1\50\1\63\1\4\1\64"+
    "\1\65\1\66\3\4\1\67\1\70\1\4\1\71\1\72"+
    "\1\73\2\4\1\74\4\4\1\75";

  private static int [] zzUnpackAction() {
    int [] result = new int[154];
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
    "\0\0\0\71\0\162\0\162\0\253\0\344\0\u011d\0\u0156"+
    "\0\71\0\u018f\0\u01c8\0\u0201\0\71\0\71\0\71\0\71"+
    "\0\u023a\0\u0273\0\u02ac\0\u02e5\0\u031e\0\u0357\0\u0390\0\u03c9"+
    "\0\u0402\0\71\0\71\0\71\0\71\0\u043b\0\u0474\0\u04ad"+
    "\0\u04e6\0\u051f\0\u0558\0\71\0\71\0\u0591\0\71\0\71"+
    "\0\71\0\u05ca\0\u0603\0\71\0\71\0\u063c\0\u0675\0\u06ae"+
    "\0\u06e7\0\u0720\0\344\0\u0759\0\u0792\0\u07cb\0\71\0\u0804"+
    "\0\u083d\0\253\0\u0876\0\u08af\0\u08e8\0\u0921\0\u095a\0\71"+
    "\0\71\0\u0993\0\u09cc\0\u0a05\0\u0a3e\0\u0a77\0\u0ab0\0\253"+
    "\0\u0ae9\0\u0b22\0\u0b5b\0\u0b94\0\u0bcd\0\71\0\71\0\71"+
    "\0\u0c06\0\u0c3f\0\71\0\71\0\u0c78\0\71\0\u0cb1\0\u0cea"+
    "\0\u0d23\0\253\0\u0d5c\0\u0d95\0\u0dce\0\u0e07\0\u0e40\0\u0e79"+
    "\0\u0eb2\0\u0eeb\0\253\0\u0f24\0\u0f5d\0\u0f96\0\u0fcf\0\u1008"+
    "\0\u1041\0\u107a\0\u10b3\0\u10ec\0\u1125\0\u115e\0\u0cea\0\u1197"+
    "\0\253\0\u11d0\0\253\0\u1209\0\253\0\253\0\u1242\0\u127b"+
    "\0\u12b4\0\u12ed\0\u1326\0\u135f\0\u1398\0\253\0\253\0\u13d1"+
    "\0\253\0\253\0\u140a\0\u0792\0\253\0\u1443\0\253\0\253"+
    "\0\253\0\u147c\0\u14b5\0\u14ee\0\253\0\253\0\u1527\0\253"+
    "\0\253\0\253\0\u1560\0\u1599\0\253\0\u15d2\0\u160b\0\u1644"+
    "\0\u167d\0\253";

  private static int [] zzUnpackRowMap() {
    int [] result = new int[154];
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
    "\1\12\1\13\1\5\1\14\1\15\1\2\1\16\1\17"+
    "\1\20\1\21\1\22\1\5\1\23\1\24\1\25\1\26"+
    "\1\27\1\5\1\30\1\31\1\5\1\32\1\33\1\34"+
    "\1\35\1\36\1\37\1\40\1\5\1\41\1\5\1\42"+
    "\1\43\1\5\1\44\1\45\1\46\1\47\1\50\1\51"+
    "\1\52\1\53\1\54\1\55\1\5\1\56\1\57\2\5"+
    "\72\0\2\3\71\0\3\5\4\0\1\5\7\0\11\5"+
    "\1\0\1\5\4\0\11\5\12\0\5\5\15\0\1\60"+
    "\57\0\2\7\7\0\1\60\53\0\2\61\1\0\3\61"+
    "\1\0\62\61\3\0\1\62\16\0\11\62\1\0\1\62"+
    "\4\0\11\62\12\0\5\62\4\0\1\63\1\7\3\0"+
    "\1\64\57\0\2\65\1\0\11\65\1\66\54\65\21\0"+
    "\1\67\52\0\3\5\4\0\1\5\7\0\1\5\1\70"+
    "\7\5\1\0\1\5\4\0\11\5\12\0\5\5\3\0"+
    "\3\5\4\0\1\5\7\0\3\5\1\71\5\5\1\0"+
    "\1\5\4\0\1\72\10\5\12\0\5\5\3\0\3\5"+
    "\4\0\1\5\7\0\7\5\1\73\1\5\1\0\1\5"+
    "\4\0\11\5\12\0\5\5\3\0\3\5\4\0\1\5"+
    "\7\0\5\5\1\74\3\5\1\0\1\5\4\0\11\5"+
    "\12\0\5\5\3\0\3\5\4\0\1\5\7\0\11\5"+
    "\1\0\1\75\4\0\11\5\12\0\5\5\3\0\3\5"+
    "\4\0\1\5\7\0\4\5\1\76\4\5\1\0\1\5"+
    "\4\0\11\5\12\0\5\5\3\0\3\5\4\0\1\5"+
    "\7\0\4\5\1\77\4\5\1\0\1\5\4\0\11\5"+
    "\12\0\5\5\21\0\1\100\11\0\1\101\40\0\3\5"+
    "\4\0\1\5\7\0\1\5\1\102\7\5\1\0\1\103"+
    "\4\0\3\5\1\104\5\5\12\0\5\5\3\0\3\5"+
    "\4\0\1\5\7\0\6\5\1\105\2\5\1\0\1\5"+
    "\4\0\4\5\1\106\4\5\12\0\5\5\3\0\3\5"+
    "\4\0\1\5\7\0\5\5\1\107\3\5\1\0\1\5"+
    "\4\0\3\5\1\110\5\5\12\0\5\5\3\0\3\5"+
    "\4\0\1\5\7\0\11\5\1\0\1\5\4\0\5\5"+
    "\1\111\3\5\12\0\5\5\3\0\3\5\4\0\1\5"+
    "\7\0\1\5\1\112\7\5\1\0\1\5\4\0\5\5"+
    "\1\113\3\5\12\0\5\5\3\0\3\5\4\0\1\5"+
    "\7\0\4\5\1\114\4\5\1\0\1\5\4\0\3\5"+
    "\1\115\5\5\12\0\5\5\54\0\1\116\35\0\1\117"+
    "\70\0\1\120\52\0\3\5\4\0\1\5\7\0\11\5"+
    "\1\0\1\5\4\0\3\5\1\121\5\5\12\0\5\5"+
    "\3\0\3\5\4\0\1\5\7\0\6\5\1\122\2\5"+
    "\1\0\1\5\4\0\11\5\12\0\5\5\4\0\2\60"+
    "\63\0\2\61\1\0\3\61\1\123\62\61\10\0\1\124"+
    "\65\0\1\125\63\0\2\65\1\126\66\65\2\127\1\130"+
    "\4\127\1\65\3\127\2\65\22\127\1\65\31\127\3\0"+
    "\3\5\4\0\1\5\7\0\2\5\1\131\6\5\1\0"+
    "\1\5\4\0\11\5\12\0\5\5\3\0\3\5\4\0"+
    "\1\5\7\0\6\5\1\132\1\5\1\133\1\0\1\5"+
    "\4\0\11\5\12\0\5\5\3\0\3\5\4\0\1\5"+
    "\7\0\11\5\1\0\1\134\4\0\11\5\12\0\5\5"+
    "\3\0\3\5\4\0\1\5\7\0\6\5\1\135\2\5"+
    "\1\0\1\5\4\0\11\5\12\0\5\5\3\0\3\5"+
    "\4\0\1\5\7\0\11\5\1\0\1\5\4\0\1\5"+
    "\1\136\7\5\12\0\5\5\3\0\3\5\4\0\1\5"+
    "\7\0\7\5\1\137\1\5\1\0\1\5\4\0\11\5"+
    "\12\0\5\5\3\0\3\5\4\0\1\5\7\0\2\5"+
    "\1\140\6\5\1\0\1\5\4\0\11\5\12\0\5\5"+
    "\3\0\3\5\4\0\1\5\7\0\11\5\1\0\1\141"+
    "\4\0\11\5\12\0\5\5\3\0\3\5\4\0\1\5"+
    "\7\0\11\5\1\0\1\5\4\0\3\5\1\142\5\5"+
    "\12\0\5\5\3\0\3\5\4\0\1\5\7\0\4\5"+
    "\1\143\4\5\1\0\1\5\4\0\11\5\12\0\5\5"+
    "\3\0\3\5\4\0\1\5\7\0\4\5\1\144\4\5"+
    "\1\0\1\5\4\0\11\5\12\0\5\5\3\0\3\5"+
    "\4\0\1\5\7\0\2\5\1\145\6\5\1\0\1\5"+
    "\4\0\11\5\12\0\5\5\3\0\3\5\4\0\1\5"+
    "\7\0\11\5\1\0\1\5\4\0\1\146\10\5\12\0"+
    "\5\5\3\0\3\5\4\0\1\5\7\0\2\5\1\147"+
    "\6\5\1\0\1\5\4\0\11\5\12\0\5\5\3\0"+
    "\3\5\4\0\1\5\7\0\11\5\1\0\1\5\4\0"+
    "\1\5\1\150\7\5\12\0\5\5\3\0\3\5\4\0"+
    "\1\5\7\0\1\5\1\151\7\5\1\0\1\5\4\0"+
    "\11\5\12\0\5\5\3\0\3\5\4\0\1\5\7\0"+
    "\5\5\1\152\3\5\1\0\1\5\4\0\11\5\12\0"+
    "\5\5\3\0\3\5\4\0\1\5\7\0\11\5\1\0"+
    "\1\5\4\0\3\5\1\153\5\5\12\0\5\5\3\0"+
    "\3\5\4\0\1\5\7\0\2\5\1\154\6\5\1\0"+
    "\1\5\4\0\11\5\12\0\5\5\3\0\3\5\4\0"+
    "\1\5\7\0\4\5\1\155\4\5\1\0\1\5\4\0"+
    "\11\5\12\0\5\5\4\0\2\125\7\0\1\60\53\0"+
    "\2\127\1\130\4\127\1\65\3\127\1\65\1\156\22\127"+
    "\1\65\31\127\7\157\1\0\3\157\1\0\1\160\22\157"+
    "\1\0\31\157\3\0\3\5\4\0\1\5\7\0\3\5"+
    "\1\161\5\5\1\0\1\5\4\0\11\5\12\0\5\5"+
    "\3\0\3\5\4\0\1\5\7\0\7\5\1\162\1\5"+
    "\1\0\1\5\4\0\11\5\12\0\5\5\3\0\3\5"+
    "\4\0\1\5\7\0\11\5\1\0\1\163\4\0\11\5"+
    "\12\0\5\5\3\0\3\5\4\0\1\5\7\0\7\5"+
    "\1\164\1\5\1\0\1\5\4\0\11\5\12\0\5\5"+
    "\3\0\3\5\4\0\1\5\7\0\5\5\1\165\3\5"+
    "\1\0\1\5\4\0\11\5\12\0\5\5\3\0\3\5"+
    "\4\0\1\5\7\0\5\5\1\166\3\5\1\0\1\5"+
    "\4\0\11\5\12\0\5\5\3\0\3\5\4\0\1\5"+
    "\7\0\3\5\1\167\5\5\1\0\1\5\4\0\11\5"+
    "\12\0\5\5\3\0\3\5\4\0\1\5\7\0\11\5"+
    "\1\0\1\5\4\0\1\5\1\170\7\5\12\0\5\5"+
    "\3\0\3\5\4\0\1\5\7\0\1\5\1\171\7\5"+
    "\1\0\1\5\4\0\11\5\12\0\5\5\3\0\3\5"+
    "\4\0\1\5\7\0\2\5\1\172\6\5\1\0\1\5"+
    "\4\0\11\5\12\0\5\5\3\0\3\5\4\0\1\5"+
    "\7\0\6\5\1\173\2\5\1\0\1\5\4\0\11\5"+
    "\12\0\5\5\3\0\3\5\4\0\1\5\7\0\1\5"+
    "\1\174\7\5\1\0\1\5\4\0\11\5\12\0\5\5"+
    "\3\0\3\5\4\0\1\5\7\0\11\5\1\0\1\175"+
    "\4\0\11\5\12\0\5\5\3\0\3\5\4\0\1\5"+
    "\7\0\5\5\1\176\3\5\1\0\1\5\4\0\11\5"+
    "\12\0\5\5\3\0\3\5\4\0\1\5\7\0\4\5"+
    "\1\177\4\5\1\0\1\5\4\0\11\5\12\0\5\5"+
    "\3\0\3\5\4\0\1\5\7\0\1\5\1\200\7\5"+
    "\1\0\1\5\4\0\11\5\12\0\5\5\3\0\3\5"+
    "\4\0\1\5\7\0\11\5\1\0\1\201\4\0\11\5"+
    "\12\0\5\5\3\0\3\5\4\0\1\5\7\0\11\5"+
    "\1\0\1\5\4\0\2\5\1\202\6\5\12\0\5\5"+
    "\3\0\3\5\4\0\1\5\7\0\2\5\1\203\6\5"+
    "\1\0\1\5\4\0\11\5\12\0\5\5\2\65\1\126"+
    "\10\65\1\204\55\65\13\0\1\126\60\0\3\5\4\0"+
    "\1\5\7\0\6\5\1\205\2\5\1\0\1\5\4\0"+
    "\11\5\12\0\5\5\3\0\3\5\4\0\1\5\7\0"+
    "\4\5\1\206\4\5\1\0\1\5\4\0\11\5\12\0"+
    "\5\5\3\0\3\5\4\0\1\5\7\0\6\5\1\207"+
    "\2\5\1\0\1\5\4\0\11\5\12\0\5\5\3\0"+
    "\3\5\4\0\1\5\7\0\5\5\1\210\3\5\1\0"+
    "\1\5\4\0\11\5\12\0\5\5\3\0\3\5\4\0"+
    "\1\5\7\0\6\5\1\211\2\5\1\0\1\5\4\0"+
    "\11\5\12\0\5\5\3\0\3\5\4\0\1\5\7\0"+
    "\3\5\1\212\5\5\1\0\1\5\4\0\11\5\12\0"+
    "\5\5\3\0\3\5\4\0\1\5\7\0\11\5\1\0"+
    "\1\5\4\0\6\5\1\213\2\5\12\0\5\5\3\0"+
    "\3\5\4\0\1\5\7\0\7\5\1\214\1\5\1\0"+
    "\1\5\4\0\11\5\12\0\5\5\3\0\3\5\4\0"+
    "\1\5\7\0\5\5\1\215\3\5\1\0\1\5\4\0"+
    "\11\5\12\0\5\5\3\0\3\5\4\0\1\5\7\0"+
    "\11\5\1\0\1\5\4\0\10\5\1\216\12\0\5\5"+
    "\3\0\3\5\4\0\1\5\7\0\3\5\1\217\5\5"+
    "\1\0\1\5\4\0\11\5\12\0\5\5\3\0\3\5"+
    "\4\0\1\5\7\0\3\5\1\220\5\5\1\0\1\5"+
    "\4\0\11\5\12\0\5\5\3\0\3\5\4\0\1\5"+
    "\7\0\11\5\1\0\1\5\4\0\11\5\12\0\1\221"+
    "\4\5\3\0\3\5\4\0\1\5\7\0\11\5\1\0"+
    "\1\5\4\0\5\5\1\222\3\5\12\0\5\5\3\0"+
    "\3\5\4\0\1\5\7\0\11\5\1\0\1\223\4\0"+
    "\11\5\12\0\5\5\3\0\3\5\4\0\1\5\7\0"+
    "\11\5\1\0\1\5\4\0\11\5\12\0\1\224\4\5"+
    "\3\0\3\5\4\0\1\5\7\0\6\5\1\225\2\5"+
    "\1\0\1\5\4\0\11\5\12\0\5\5\3\0\3\5"+
    "\4\0\1\5\7\0\11\5\1\0\1\5\4\0\11\5"+
    "\12\0\3\5\1\226\1\5\3\0\3\5\4\0\1\5"+
    "\7\0\11\5\1\0\1\5\4\0\3\5\1\227\5\5"+
    "\12\0\5\5\3\0\3\5\4\0\1\5\7\0\11\5"+
    "\1\0\1\5\4\0\11\5\12\0\4\5\1\230\3\0"+
    "\3\5\4\0\1\5\7\0\3\5\1\231\5\5\1\0"+
    "\1\5\4\0\11\5\12\0\5\5\3\0\3\5\4\0"+
    "\1\5\7\0\6\5\1\232\2\5\1\0\1\5\4\0"+
    "\11\5\12\0\5\5";

  private static int [] zzUnpackTrans() {
    int [] result = new int[5814];
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
    "\1\1\1\11\6\1\1\11\3\1\4\11\11\1\4\11"+
    "\6\1\2\11\1\1\3\11\2\1\2\11\3\1\3\0"+
    "\1\1\2\0\1\11\10\1\2\11\14\1\3\11\2\1"+
    "\2\11\1\0\1\11\1\0\26\1\3\0\52\1";

  private static int [] zzUnpackAttribute() {
    int [] result = new int[154];
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
    private Symbol symbol(int type, Object value){
        /*System.out.println("Analizo: " + value);*/
        return new Symbol(type,yyline,yycolumn,value);
    }

    private Symbol symbol(int type){
        return new Symbol(type,yyline,yycolumn);
    }


  /**
   * Creates a new scanner
   * There is also a java.io.InputStream version of this constructor.
   *
   * @param   in  the java.io.Reader to read input from.
   */
  LexerCup(java.io.Reader in) {
    this.zzReader = in;
  }

  /**
   * Creates a new scanner.
   * There is also java.io.Reader version of this constructor.
   *
   * @param   in  the java.io.Inputstream to read input from.
   */
  LexerCup(java.io.InputStream in) {
    this(new java.io.InputStreamReader(in));
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
   * Contains user EOF-code, which will be executed exactly once,
   * when the end of file is reached
   */
  private void zzDoEOF() throws java.io.IOException {
    if (!zzEOFDone) {
      zzEOFDone = true;
      yyclose();
    }
  }


  /**
   * Resumes scanning until the next regular expression is matched,
   * the end of input is encountered or an I/O-Error occurs.
   *
   * @return      the next token
   * @exception   java.io.IOException  if any I/O-Error occurs
   */
  public java_cup.runtime.Symbol next_token() throws java.io.IOException {
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

      yychar+= zzMarkedPosL-zzStartRead;

      boolean zzR = false;
      for (zzCurrentPosL = zzStartRead; zzCurrentPosL < zzMarkedPosL;
                                                             zzCurrentPosL++) {
        switch (zzBufferL[zzCurrentPosL]) {
        case '\u000B':
        case '\u000C':
        case '\u0085':
        case '\u2028':
        case '\u2029':
          yyline++;
          zzR = false;
          break;
        case '\r':
          yyline++;
          zzR = true;
          break;
        case '\n':
          if (zzR)
            zzR = false;
          else {
            yyline++;
          }
          break;
        default:
          zzR = false;
        }
      }

      if (zzR) {
        // peek one character ahead if it is \n (if we have counted one line too much)
        boolean zzPeek;
        if (zzMarkedPosL < zzEndReadL)
          zzPeek = zzBufferL[zzMarkedPosL] == '\n';
        else if (zzAtEOF)
          zzPeek = false;
        else {
          boolean eof = zzRefill();
          zzEndReadL = zzEndRead;
          zzMarkedPosL = zzMarkedPos;
          zzBufferL = zzBuffer;
          if (eof) 
            zzPeek = false;
          else 
            zzPeek = zzBufferL[zzMarkedPosL] == '\n';
        }
        if (zzPeek) yyline--;
      }
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
        case 10: 
          { return new Symbol(sym.Llave_a, yychar, yyline, yytext());
          }
        case 62: break;
        case 5: 
          { return new Symbol(sym.Int, yychar, yyline, yytext());
          }
        case 63: break;
        case 59: 
          { return new Symbol(sym.Switch, yychar, yyline, yytext());
          }
        case 64: break;
        case 56: 
          { return new Symbol(sym.Break, yychar, yyline, yytext());
          }
        case 65: break;
        case 26: 
          { return new Symbol(sym.Conjuncion, yychar, yyline, yytext());
          }
        case 66: break;
        case 45: 
          { return new Symbol(sym.Else, yychar, yyline, yytext());
          }
        case 67: break;
        case 36: 
          { return new Symbol(sym.Menor_igual, yychar, yyline, yytext());
          }
        case 68: break;
        case 41: 
          { return new Symbol(sym.T_int, yychar, yyline, yytext());
          }
        case 69: break;
        case 9: 
          { return new Symbol(sym.Delimitador, yychar, yyline, yytext());
          }
        case 70: break;
        case 14: 
          { return new Symbol(sym.Corchete_a, yychar, yyline, yytext());
          }
        case 71: break;
        case 21: 
          { return new Symbol(sym.Division, yychar, yyline, yytext());
          }
        case 72: break;
        case 3: 
          { /**/
          }
        case 73: break;
        case 34: 
          { return new Symbol(sym.Do, yychar, yyline, yytext());
          }
        case 74: break;
        case 52: 
          { return new Symbol(sym.Print, yychar, yyline, yytext());
          }
        case 75: break;
        case 32: 
          { return new Symbol(sym.Mayor_igual, yychar, yyline, yytext());
          }
        case 76: break;
        case 42: 
          { return new Symbol(sym.For, yychar, yyline, yytext());
          }
        case 77: break;
        case 16: 
          { return new Symbol(sym.Parentesis_a, yychar, yyline, yytext());
          }
        case 78: break;
        case 7: 
          { return new Symbol(sym.Resta, yychar, yyline, yytext());
          }
        case 79: break;
        case 39: 
          { return new Symbol(sym.Character, yychar, yyline, yytext());
          }
        case 80: break;
        case 38: 
          { return new Symbol(sym.String, yychar, yyline, yytext());
          }
        case 81: break;
        case 27: 
          { return new Symbol(sym.Disyuncion, yychar, yyline, yytext());
          }
        case 82: break;
        case 40: 
          { /*ignore*/
          }
        case 83: break;
        case 61: 
          { return new Symbol(sym.String_to_int, yychar, yyline, yytext());
          }
        case 84: break;
        case 60: 
          { return new Symbol(sym.Default, yychar, yyline, yytext());
          }
        case 85: break;
        case 50: 
          { return new Symbol(sym.T_void, yychar, yyline, yytext());
          }
        case 86: break;
        case 11: 
          { return new Symbol(sym.Llave_c, yychar, yyline, yytext());
          }
        case 87: break;
        case 44: 
          { return new Symbol(sym.Null, yychar, yyline, yytext());
          }
        case 88: break;
        case 13: 
          { return new Symbol(sym.Mayor, yychar, yyline, yytext());
          }
        case 89: break;
        case 23: 
          { return new Symbol(sym.Modulo, yychar, yyline, yytext());
          }
        case 90: break;
        case 35: 
          { return new Symbol(sym.Unario_positivo, yychar, yyline, yytext());
          }
        case 91: break;
        case 57: 
          { return new Symbol(sym.Return, yychar, yyline, yytext());
          }
        case 92: break;
        case 15: 
          { return new Symbol(sym.Corchete_c, yychar, yyline, yytext());
          }
        case 93: break;
        case 24: 
          { return new Symbol(sym.Menor, yychar, yyline, yytext());
          }
        case 94: break;
        case 31: 
          { return new Symbol(sym.If, yychar, yyline, yytext());
          }
        case 95: break;
        case 18: 
          { return new Symbol(sym.Sig_pregunta, yychar, yyline, yytext());
          }
        case 96: break;
        case 48: 
          { return new Symbol(sym.T_char, yychar, yyline, yytext());
          }
        case 97: break;
        case 47: 
          { return new Symbol(sym.Case, yychar, yyline, yytext());
          }
        case 98: break;
        case 19: 
          { return new Symbol(sym.Dos_puntos, yychar, yyline, yytext());
          }
        case 99: break;
        case 43: 
          { return new Symbol(sym.Main, yychar, yyline, yytext());
          }
        case 100: break;
        case 49: 
          { return new Symbol(sym.T_bool, yychar, yyline, yytext());
          }
        case 101: break;
        case 25: 
          { return new Symbol(sym.Negacion, yychar, yyline, yytext());
          }
        case 102: break;
        case 6: 
          { return new Symbol(sym.Parentesis_c, yychar, yyline, yytext());
          }
        case 103: break;
        case 33: 
          { return new Symbol(sym.Simbolo_input, yychar, yyline, yytext());
          }
        case 104: break;
        case 29: 
          { return new Symbol(sym.Unario_negatico, yychar, yyline, yytext());
          }
        case 105: break;
        case 51: 
          { return new Symbol(sym.Input, yychar, yyline, yytext());
          }
        case 106: break;
        case 22: 
          { return new Symbol(sym.Potencia, yychar, yyline, yytext());
          }
        case 107: break;
        case 8: 
          { return new Symbol(sym.Multiplicacion, yychar, yyline, yytext());
          }
        case 108: break;
        case 20: 
          { return new Symbol(sym.Suma, yychar, yyline, yytext());
          }
        case 109: break;
        case 12: 
          { return new Symbol(sym.Asignacion, yychar, yyline, yytext());
          }
        case 110: break;
        case 58: 
          { return new Symbol(sym.T_string, yychar, yyline, yytext());
          }
        case 111: break;
        case 54: 
          { return new Symbol(sym.T_float, yychar, yyline, yytext());
          }
        case 112: break;
        case 37: 
          { return new Symbol(sym.Diferente, yychar, yyline, yytext());
          }
        case 113: break;
        case 53: 
          { return new Symbol(sym.False, yychar, yyline, yytext());
          }
        case 114: break;
        case 2: 
          { return new Symbol(sym.Error, yychar, yyline, yytext());
          }
        case 115: break;
        case 55: 
          { return new Symbol(sym.While, yychar, yyline, yytext());
          }
        case 116: break;
        case 1: 
          { /*Ignore*/
          }
        case 117: break;
        case 30: 
          { return new Symbol(sym.Igual, yychar, yyline, yytext());
          }
        case 118: break;
        case 17: 
          { return new Symbol(sym.Coma, yychar, yyline, yytext());
          }
        case 119: break;
        case 46: 
          { return new Symbol(sym.True, yychar, yyline, yytext());
          }
        case 120: break;
        case 4: 
          { return new Symbol(sym.Identificador, yychar, yyline, yytext());
          }
        case 121: break;
        case 28: 
          { return new Symbol(sym.Float, yychar, yyline, yytext());
          }
        case 122: break;
        default: 
          if (zzInput == YYEOF && zzStartRead == zzCurrentPos) {
            zzAtEOF = true;
            zzDoEOF();
              { return new java_cup.runtime.Symbol(sym.EOF); }
          } 
          else {
            zzScanError(ZZ_NO_MATCH);
          }
      }
    }
  }


}

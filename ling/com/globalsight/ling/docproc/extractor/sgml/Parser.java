/* Generated By:JavaCC: Do not edit this line. Parser.java */
package com.globalsight.ling.docproc.extractor.sgml;

import com.globalsight.ling.docproc.extractor.sgml.SgmlObjects;
import com.globalsight.ling.docproc.extractor.sgml.ISgmlHandler;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Iterator;

/**
 * <p>A SGML Parser automatically generated by JavaCC.  Builds an SGML
 * Object Model and sends events to abstract handler methods in type
 * {@link ISgmlHandler}, which are implemented by class
 * ExtractionHandler.
 *
 * @see SgmlObjects
 * @see ISgmlHandler
 * @see ExtractionHandler
 */
public class Parser
    implements SgmlObjects, ParserConstants {
    ISgmlHandler m_handler = null;

    public static void main(String args[])
        throws ParseException
    {
        Parser parser = new Parser (System.in);
        parser.parse();
    }

    public void setHandler(ISgmlHandler p_handler)
    {
        m_handler = p_handler;
    }

    /**
     * <p>Return the current line number in the input file.  This is a
     * little helper that allows us to offset error positions obtained
     * from embedded extractors.  Embedded extractors receive a fresh
     * input object and start counting lines and columns from 1.</p>
     */
    public int getCurrentLine()
    {
        return jj_input_stream.line;
    }

    /**
     * <p>Return the current column number in the input file.  This is a
     * little helper that allows us to offset error positions obtained
     * from embedded extractors.  Embedded extractors receive a fresh
     * input object and start counting lines and columns from 1.</p>
     */
    public int getCurrentColumn()
    {
        return jj_input_stream.column;
    }

    /**
     * Returns the original text including whitespace that occured
     * between two tokens. Leading whitespace before the first token
     * is *not* returned. The tokens cannot be the same.
     */
    private String getTokenText(Token first, Token last)
    {
        StringBuffer res = new StringBuffer();

        res.append(first.image);

        for (Token t = first.next; t != last.next; t = t.next)
        {
            if (t.specialToken != null)
            {
                Token tt = t.specialToken;

                // walk the list backwards
                while (tt.specialToken != null)
                {
                    tt = tt.specialToken;
                }

                // and forwards again
                for (; tt != null; tt = tt.next)
                {
                    res.append(tt.image);
                }
            }

            res.append(t.image);
        }

        return res.toString();
    }

/*
<InEntity> TOKEN :
{
  <ENTITY_END:   ";" > : DEFAULT
| <NUMERIC_ENTITY:  ("#" ("x")? (["0"-"9", "a"-"f"])+) >
| <CHAR_ENTITY:  (<IDENTIFIER_CHAR>)+ >
}
*/

/* START OF GRAMMAR */
  final public void parse() throws ParseException {
    Token text;
    Tag t1;
    /*
    Script t2;
    Style t3;
    Java t4;
    */
    EndTag t9;
      m_handler.handleStart();
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case UNICODE_BOM:
      jj_consume_token(UNICODE_BOM);
      break;
    default:
      jj_la1[0] = jj_gen;
      ;
    }
    label_1:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case CR_NEWLINE:
      case TAG_START:
      case ENDTAG_START:
      case COMMENT_START:
      case DECL_START:
      case PI_START:
      case PCDATA:
        ;
        break;
      default:
        jj_la1[1] = jj_gen;
        break label_1;
      }
      if (jj_2_1(2)) {
        t1 = parseStartTag();
                                          m_handler.handleStartTag(t1);
      } else {
        switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
        case ENDTAG_START:
          t9 = parseEndTag();
                                          m_handler.handleEndTag(t9);
          break;
        case COMMENT_START:
          parseComment();
          break;
        case DECL_START:
          parseDeclaration();
          break;
        case PI_START:
          parseProcessingInstruction();
          break;
        case PCDATA:
          parseText();
          break;
        case CR_NEWLINE:
          parseNewline();
          break;
        default:
          jj_la1[2] = jj_gen;
          jj_consume_token(-1);
          throw new ParseException();
        }
      }
    }
    jj_consume_token(0);
      m_handler.handleFinish();
  }

  final public void parseComment() throws ParseException {
    Token t;
    StringBuffer s = new StringBuffer ("");
    jj_consume_token(COMMENT_START);
    label_2:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case DASH:
      case COMMENT_WORD:
        ;
        break;
      default:
        jj_la1[3] = jj_gen;
        break label_2;
      }
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case DASH:
        t = jj_consume_token(DASH);
            s.append(t.image);
        break;
      case COMMENT_WORD:
        t = jj_consume_token(COMMENT_WORD);
            s.append(t.image);
        break;
      default:
        jj_la1[4] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
    }
    jj_consume_token(COMMENT_END);
            m_handler.handleComment(new Comment(s.toString()));
  }

  final public void parseProcessingInstruction() throws ParseException {
    Token t;
    jj_consume_token(PI_START);
    t = jj_consume_token(PI_ANY);
    jj_consume_token(PI_END);
         m_handler.handlePI(new PI(t.image));
  }

  final public void parseDeclaration() throws ParseException {
    Token t;
    jj_consume_token(DECL_START);
    t = jj_consume_token(DECL_ANY);
    jj_consume_token(DECL_END);
         m_handler.handleDeclaration(new Declaration(t.image));
  }

  final public Attribute parseAttribute(int p_state) throws ParseException {
    Token t1, t2 = null;
    t1 = jj_consume_token(ATTR_NAME);
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case EQUAL:
      jj_consume_token(EQUAL);
      t2 = jj_consume_token(ATTR_VALUE);
      break;
    default:
      jj_la1[5] = jj_gen;
      ;
    }
        token_source.SwitchTo(p_state);

        if (t2 == null)
        {
            {if (true) return new Attribute(t1.image);}
        }
        else
        {
            String temp = t2.image;
            char lastChar  = temp.charAt(temp.length() - 1);
            char firstChar = temp.charAt(0);
            if ((lastChar != firstChar) &&
                (lastChar == '"' || lastChar == '\''))
            {
                // Must be one of them sickly quoted attributes.
                // Repair att=val" to att="val"
                temp = lastChar + temp;
            }

            // Handle CDATA: should ignore \n and replace \r\t with space.
            // However, we remove \r\n and leave \t alone.
            int i_at;
            while ((i_at = temp.indexOf('\n')) >= 0)
            {
                temp = temp.substring(0, i_at) + temp.substring(i_at + 1);
            }
            while ((i_at = temp.indexOf('\r')) >= 0)
            {
            temp = temp.substring(0, i_at) + temp.substring(i_at + 1);
            }

            {if (true) return new Attribute(t1.image, temp);}
        }
    throw new Error("Missing return statement in function");
  }

  final public AttributeList parseAttributeList() throws ParseException {
    AttributeList alist = new AttributeList();
    Attribute a;
    label_3:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case ATTR_NAME:
        ;
        break;
      default:
        jj_la1[6] = jj_gen;
        break label_3;
      }
      a = parseAttribute(token_source.curLexState);
            alist.addAttribute(a);
    }
          {if (true) return alist;}
    throw new Error("Missing return statement in function");
  }

  final public ExtendedAttributeList parseExtendedAttributeList() throws ParseException {
    ExtendedAttributeList elist = new ExtendedAttributeList();
    AttributeList alist;
    Attribute a;
    Token t, t1, tag;
    EndTag e;
    label_4:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case ATTR_NAME:
        ;
        break;
      default:
        jj_la1[7] = jj_gen;
        break label_4;
      }
      a = parseAttribute(token_source.curLexState);
            elist.addAttribute(a);
    }
          {if (true) return elist;}
    throw new Error("Missing return statement in function");
  }

  final public Tag parseStartTag() throws ParseException {
    Token t, tag, t1;
    ExtendedAttributeList elist = null;
    Token firstToken = getToken(1);
    boolean b_closed = false;
    try {
      t = jj_consume_token(TAG_START);
      tag = jj_consume_token(TAG_NAME);
      elist = parseExtendedAttributeList();
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case TAG_END:
        t1 = jj_consume_token(TAG_END);
        break;
      case TAG_END_CLOSE:
        t1 = jj_consume_token(TAG_END_CLOSE);
                                     b_closed = true;
        break;
      default:
        jj_la1[8] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
        token_source.SwitchTo(DEFAULT);

        {if (true) return new Tag(tag.image, elist, b_closed,
            getTokenText(t, t1), t.beginLine, t.beginColumn);}
    } catch (ParseException e) {
        token_source.SwitchTo(DEFAULT);
        String s = getTokenText(firstToken, getNextToken());
        {if (true) throw new ParseException("Error parsing STARTTAG:\n" +
            e.getMessage() + "\nin input: " + s);}
    }
    throw new Error("Missing return statement in function");
  }

/*
Script parseScript() :
{
    Token t, t1, t2, t3, tag;
    StringBuffer b = new StringBuffer();
    ExtendedAttributeList elist;
}
{
    t=<TAG_START> tag=<SCRIPT> elist=parseExtendedAttributeList()
    (
      t1=<TAG_END_CLOSE>
            {
            return new Script(tag.image, elist, true,
                getTokenText(t, t1), "", t.beginLine, t.beginColumn);
            }
    | t1=<TAG_END>          { token_source.SwitchTo(InScript); }
      (
        t2=<SCRIPT_TEXT>    { b.append(t2.image); }
      )*
      t3=<SCRIPT_END>
            {
            String text = b.toString();

            return new Script(tag.image, elist, false,
                getTokenText(t, t3), text, t.beginLine, t.beginColumn);
            }
    )
}

Java parseJava() :
{
    Token t, t1, t2, t3, tag;
    StringBuffer b = new StringBuffer();
    ExtendedAttributeList elist;
}
{
    t=<TAG_START> tag=<JAVA> elist=parseExtendedAttributeList()
    (
      t1=<TAG_END_CLOSE>
            {
            return new Java(tag.image, elist, true,
                getTokenText(t, t1), "", t.beginLine, t.beginColumn);
            }
    | t1=<TAG_END>          { token_source.SwitchTo(InJava); }
      (
        t2=<JAVA_TEXT>      { b.append(t2.image); }
      )*
      t3=<JAVA_END>
            {
            String text = b.toString();

            return new Java(tag.image, elist, false,
                getTokenText(t, t3), text, t.beginLine, t.beginColumn);
            }
    )
}

Style parseStyle() :
{
    Token t, t1, t2, t3, tag;
    StringBuffer b = new StringBuffer();
    ExtendedAttributeList elist;
}
{
    t=<TAG_START> tag=<STYLE> elist=parseExtendedAttributeList()
    (
      t1=<TAG_END_CLOSE>
            {
            return new Style(tag.image, elist, true,
                getTokenText(t, t1), "", t.beginLine, t.beginColumn);
            }
    | t1=<TAG_END>                { token_source.SwitchTo(InStyle); }
      (
        t2=<STYLE_TEXT>           { b.append(t2.image); }
      |
        t2=<COMMENTED_STYLE_TEXT> { b.append(t2.image); }
      )*
      t3=<STYLE_END>
            {
            String text = b.toString();

            return new Style(tag.image, elist, false,
                getTokenText(t, t3), text, t.beginLine, t.beginColumn);
            }
    )
}
*/
  final public EndTag parseEndTag() throws ParseException {
    Token t;
    jj_consume_token(ENDTAG_START);
    t = jj_consume_token(TAG_NAME);
    jj_consume_token(TAG_END);
            {if (true) return new EndTag(t.image);}
    throw new Error("Missing return statement in function");
  }

  final public void parseText() throws ParseException {
    Token t;
    t = jj_consume_token(PCDATA);
        m_handler.handleText(new Text(t.image));
  }

  final public void parseNewline() throws ParseException {
    Token t;
    t = jj_consume_token(CR_NEWLINE);
        m_handler.handleNewline(new Newline(t.image));
  }

  private boolean jj_2_1(int xla) {
    jj_la = xla; jj_lastpos = jj_scanpos = token;
    try { return !jj_3_1(); }
    catch(LookaheadSuccess ls) { return true; }
    finally { jj_save(0, xla); }
  }

  private boolean jj_3_1() {
    if (jj_3R_5()) return true;
    return false;
  }

  private boolean jj_3R_5() {
    if (jj_scan_token(TAG_START)) return true;
    if (jj_scan_token(TAG_NAME)) return true;
    return false;
  }

  /** Generated Token Manager. */
  public ParserTokenManager token_source;
  SimpleCharStream jj_input_stream;
  /** Current token. */
  public Token token;
  /** Next token. */
  public Token jj_nt;
  private int jj_ntk;
  private Token jj_scanpos, jj_lastpos;
  private int jj_la;
  private int jj_gen;
  final private int[] jj_la1 = new int[9];
  static private int[] jj_la1_0;
  static private int[] jj_la1_1;
  static {
      jj_la1_init_0();
      jj_la1_init_1();
   }
   private static void jj_la1_init_0() {
      jj_la1_0 = new int[] {0x400,0x3f800,0x3e800,0x80000000,0x80000000,0x8000000,0x4000000,0x4000000,0x3000000,};
   }
   private static void jj_la1_init_1() {
      jj_la1_1 = new int[] {0x0,0x0,0x0,0x1,0x1,0x0,0x0,0x0,0x0,};
   }
  final private JJCalls[] jj_2_rtns = new JJCalls[1];
  private boolean jj_rescan = false;
  private int jj_gc = 0;

  /** Constructor with InputStream. */
  public Parser(java.io.InputStream stream) {
     this(stream, null);
  }
  /** Constructor with InputStream and supplied encoding */
  public Parser(java.io.InputStream stream, String encoding) {
    try { jj_input_stream = new SimpleCharStream(stream, encoding, 1, 1); } catch(java.io.UnsupportedEncodingException e) { throw new RuntimeException(e); }
    token_source = new ParserTokenManager(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 9; i++) jj_la1[i] = -1;
    for (int i = 0; i < jj_2_rtns.length; i++) jj_2_rtns[i] = new JJCalls();
  }

  /** Reinitialise. */
  public void ReInit(java.io.InputStream stream) {
     ReInit(stream, null);
  }
  /** Reinitialise. */
  public void ReInit(java.io.InputStream stream, String encoding) {
    try { jj_input_stream.ReInit(stream, encoding, 1, 1); } catch(java.io.UnsupportedEncodingException e) { throw new RuntimeException(e); }
    token_source.ReInit(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 9; i++) jj_la1[i] = -1;
    for (int i = 0; i < jj_2_rtns.length; i++) jj_2_rtns[i] = new JJCalls();
  }

  /** Constructor. */
  public Parser(java.io.Reader stream) {
    jj_input_stream = new SimpleCharStream(stream, 1, 1);
    token_source = new ParserTokenManager(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 9; i++) jj_la1[i] = -1;
    for (int i = 0; i < jj_2_rtns.length; i++) jj_2_rtns[i] = new JJCalls();
  }

  /** Reinitialise. */
  public void ReInit(java.io.Reader stream) {
    jj_input_stream.ReInit(stream, 1, 1);
    token_source.ReInit(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 9; i++) jj_la1[i] = -1;
    for (int i = 0; i < jj_2_rtns.length; i++) jj_2_rtns[i] = new JJCalls();
  }

  /** Constructor with generated Token Manager. */
  public Parser(ParserTokenManager tm) {
    token_source = tm;
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 9; i++) jj_la1[i] = -1;
    for (int i = 0; i < jj_2_rtns.length; i++) jj_2_rtns[i] = new JJCalls();
  }

  /** Reinitialise. */
  public void ReInit(ParserTokenManager tm) {
    token_source = tm;
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 9; i++) jj_la1[i] = -1;
    for (int i = 0; i < jj_2_rtns.length; i++) jj_2_rtns[i] = new JJCalls();
  }

  private Token jj_consume_token(int kind) throws ParseException {
    Token oldToken;
    if ((oldToken = token).next != null) token = token.next;
    else token = token.next = token_source.getNextToken();
    jj_ntk = -1;
    if (token.kind == kind) {
      jj_gen++;
      if (++jj_gc > 100) {
        jj_gc = 0;
        for (int i = 0; i < jj_2_rtns.length; i++) {
          JJCalls c = jj_2_rtns[i];
          while (c != null) {
            if (c.gen < jj_gen) c.first = null;
            c = c.next;
          }
        }
      }
      return token;
    }
    token = oldToken;
    jj_kind = kind;
    throw generateParseException();
  }

  static private final class LookaheadSuccess extends java.lang.Error { }
  final private LookaheadSuccess jj_ls = new LookaheadSuccess();
  private boolean jj_scan_token(int kind) {
    if (jj_scanpos == jj_lastpos) {
      jj_la--;
      if (jj_scanpos.next == null) {
        jj_lastpos = jj_scanpos = jj_scanpos.next = token_source.getNextToken();
      } else {
        jj_lastpos = jj_scanpos = jj_scanpos.next;
      }
    } else {
      jj_scanpos = jj_scanpos.next;
    }
    if (jj_rescan) {
      int i = 0; Token tok = token;
      while (tok != null && tok != jj_scanpos) { i++; tok = tok.next; }
      if (tok != null) jj_add_error_token(kind, i);
    }
    if (jj_scanpos.kind != kind) return true;
    if (jj_la == 0 && jj_scanpos == jj_lastpos) throw jj_ls;
    return false;
  }


/** Get the next Token. */
  final public Token getNextToken() {
    if (token.next != null) token = token.next;
    else token = token.next = token_source.getNextToken();
    jj_ntk = -1;
    jj_gen++;
    return token;
  }

/** Get the specific Token. */
  final public Token getToken(int index) {
    Token t = token;
    for (int i = 0; i < index; i++) {
      if (t.next != null) t = t.next;
      else t = t.next = token_source.getNextToken();
    }
    return t;
  }

  private int jj_ntk() {
    if ((jj_nt=token.next) == null)
      return (jj_ntk = (token.next=token_source.getNextToken()).kind);
    else
      return (jj_ntk = jj_nt.kind);
  }

  private java.util.List jj_expentries = new java.util.ArrayList();
  private int[] jj_expentry;
  private int jj_kind = -1;
  private int[] jj_lasttokens = new int[100];
  private int jj_endpos;

  private void jj_add_error_token(int kind, int pos) {
    if (pos >= 100) return;
    if (pos == jj_endpos + 1) {
      jj_lasttokens[jj_endpos++] = kind;
    } else if (jj_endpos != 0) {
      jj_expentry = new int[jj_endpos];
      for (int i = 0; i < jj_endpos; i++) {
        jj_expentry[i] = jj_lasttokens[i];
      }
      jj_entries_loop: for (java.util.Iterator it = jj_expentries.iterator(); it.hasNext();) {
        int[] oldentry = (int[])(it.next());
        if (oldentry.length == jj_expentry.length) {
          for (int i = 0; i < jj_expentry.length; i++) {
            if (oldentry[i] != jj_expentry[i]) {
              continue jj_entries_loop;
            }
          }
          jj_expentries.add(jj_expentry);
          break jj_entries_loop;
        }
      }
      if (pos != 0) jj_lasttokens[(jj_endpos = pos) - 1] = kind;
    }
  }

  /** Generate ParseException. */
  public ParseException generateParseException() {
    jj_expentries.clear();
    boolean[] la1tokens = new boolean[37];
    if (jj_kind >= 0) {
      la1tokens[jj_kind] = true;
      jj_kind = -1;
    }
    for (int i = 0; i < 9; i++) {
      if (jj_la1[i] == jj_gen) {
        for (int j = 0; j < 32; j++) {
          if ((jj_la1_0[i] & (1<<j)) != 0) {
            la1tokens[j] = true;
          }
          if ((jj_la1_1[i] & (1<<j)) != 0) {
            la1tokens[32+j] = true;
          }
        }
      }
    }
    for (int i = 0; i < 37; i++) {
      if (la1tokens[i]) {
        jj_expentry = new int[1];
        jj_expentry[0] = i;
        jj_expentries.add(jj_expentry);
      }
    }
    jj_endpos = 0;
    jj_rescan_token();
    jj_add_error_token(0, 0);
    int[][] exptokseq = new int[jj_expentries.size()][];
    for (int i = 0; i < jj_expentries.size(); i++) {
      exptokseq[i] = (int[])jj_expentries.get(i);
    }
    token.next.beginColumn = jj_input_stream.column;     token.next.beginLine = jj_input_stream.line;     return new ParseException(token, exptokseq, tokenImage);
  }

  /** Enable tracing. */
  final public void enable_tracing() {
  }

  /** Disable tracing. */
  final public void disable_tracing() {
  }

  private void jj_rescan_token() {
    jj_rescan = true;
    for (int i = 0; i < 1; i++) {
    try {
      JJCalls p = jj_2_rtns[i];
      do {
        if (p.gen > jj_gen) {
          jj_la = p.arg; jj_lastpos = jj_scanpos = p.first;
          switch (i) {
            case 0: jj_3_1(); break;
          }
        }
        p = p.next;
      } while (p != null);
      } catch(LookaheadSuccess ls) { }
    }
    jj_rescan = false;
  }

  private void jj_save(int index, int xla) {
    JJCalls p = jj_2_rtns[index];
    while (p.gen > jj_gen) {
      if (p.next == null) { p = p.next = new JJCalls(); break; }
      p = p.next;
    }
    p.gen = jj_gen + xla - jj_la; p.first = token; p.arg = xla;
  }

  static final class JJCalls {
    int gen;
    Token first;
    int arg;
    JJCalls next;
  }

}

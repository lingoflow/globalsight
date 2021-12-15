/* Generated By:JavaCC: Do not edit this line. AmbassadorDwUpParser.java */
package com.globalsight.ling.tw.offline.parser;

public class AmbassadorDwUpParser implements AmbassadorDwUpParserConstants {
    private AmbassadorDwUpEventHandlerInterface m_handler = null;

    public void setHandler(AmbassadorDwUpEventHandlerInterface p_handler)
    {
        m_handler = p_handler;
    }

/*****************************************
 * SYNTACTIC RULES
 *****************************************/
  final public void parse() throws ParseException {
    Token bom = null;
      m_handler.handleStart();
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case BOM:
      bom = jj_consume_token(BOM);
      break;
    default:
      jj_la1[0] = jj_gen;
      ;
    }
      if (bom != null) m_handler.handleBom(bom.image);
    startSignature();
    header();
    jj_consume_token(NEWLINE);
      m_handler.handleEndHeader();
      token_source.SwitchTo(START_LINE);
    label_1:
    while (true) {
      entry();
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case ID:
      case SUBFLOW_ID:
        ;
        break;
      default:
        jj_la1[1] = jj_gen;
        break label_1;
      }
    }
    endSignature();
                     m_handler.handleFinish(); {if (true) return;}
  }

  final public void header() throws ParseException {
    encoding();
    documentFormat();
    placeholderFormat();
    sourceLocale();
    targetLocale();
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case 26:
      jobID();
      break;
    default:
      jj_la1[2] = jj_gen;
      ;
    }
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case 27:
      jobName();
      break;
    default:
      jj_la1[3] = jj_gen;
      ;
    }
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case 28:
      pageName();
      break;
    default:
      jj_la1[4] = jj_gen;
      ;
    }
    pageId();
    workflowId();
    taskId();
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case 32:
      exactMatchWordCount();
      break;
    default:
      jj_la1[5] = jj_gen;
      ;
    }
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case 33:
      fuzzyMatchWordCount();
      break;
    default:
      jj_la1[6] = jj_gen;
      ;
    }
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case 34:
      unmatchedMatchWordCount();
      break;
    default:
      jj_la1[7] = jj_gen;
      ;
    }
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case 35:
      serverInstanceID();
      break;
    default:
      jj_la1[8] = jj_gen;
      ;
    }
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case 36:
      editAll();
      break;
    default:
      jj_la1[9] = jj_gen;
      ;
    }
    label_2:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case HEADER_HELP_LINE:
        ;
        break;
      default:
        jj_la1[10] = jj_gen;
        break label_2;
      }
      help();
    }
    label_3:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case HEADER_NOTE_LINE:
        ;
        break;
      default:
        jj_la1[11] = jj_gen;
        break label_3;
      }
      notes();
    }
  }

  final public void startSignature() throws ParseException {
    Token t;
    t = jj_consume_token(START);
      m_handler.handleStartSignature(t.image);
  }

  final public void endSignature() throws ParseException {
    Token t;
    t = jj_consume_token(END);
      m_handler.handleEndSignature(t.image);
  }

  final public void encoding() throws ParseException {
    Token t;
    jj_consume_token(21);
    t = jj_consume_token(ALPHANUMERIC);
    jj_consume_token(NEWLINE);
      m_handler.handleEncoding(t.image);
  }

  final public void documentFormat() throws ParseException {
    Token t;
    jj_consume_token(22);
    t = jj_consume_token(ALPHANUMERIC);
    jj_consume_token(NEWLINE);
      m_handler.handleDocumentFormat(t.image);
  }

  final public void placeholderFormat() throws ParseException {
    Token t;
    jj_consume_token(23);
    t = jj_consume_token(ALPHANUMERIC);
    jj_consume_token(NEWLINE);
      m_handler.handlePlaceholderFormat(t.image);
  }

  final public void sourceLocale() throws ParseException {
    Token t;
    jj_consume_token(24);
    t = jj_consume_token(ALPHANUMERIC);
    jj_consume_token(NEWLINE);
      m_handler.handleSourceLocale(t.image);
  }

  final public void targetLocale() throws ParseException {
    Token t;
    jj_consume_token(25);
    t = jj_consume_token(ALPHANUMERIC);
    jj_consume_token(NEWLINE);
      m_handler.handleTargetLocale(t.image);
  }

  final public void jobID() throws ParseException {
    Token t;
    jj_consume_token(26);
    t = jj_consume_token(ALPHANUMERIC);
    jj_consume_token(NEWLINE);
      m_handler.handleJobID(t.image);
  }

  final public void jobName() throws ParseException {
    Token t;
    jj_consume_token(27);
    t = jj_consume_token(ALPHANUMERIC);
    jj_consume_token(NEWLINE);
      m_handler.handleJobName(t.image);
  }

  final public void pageName() throws ParseException {
    Token t;
    jj_consume_token(28);
    t = jj_consume_token(ALPHANUMERIC);
    jj_consume_token(NEWLINE);
      m_handler.handlePageName(t.image);
  }

  final public void pageId() throws ParseException {
    Token t;
    jj_consume_token(29);
    t = jj_consume_token(ALPHANUMERIC);
    jj_consume_token(NEWLINE);
      m_handler.handlePageId(t.image);
  }

  final public void workflowId() throws ParseException {
    Token t;
    jj_consume_token(30);
    t = jj_consume_token(ALPHANUMERIC);
    jj_consume_token(NEWLINE);
      m_handler.handleWorkflowId(t.image);
  }

  final public void taskId() throws ParseException {
    Token t;
    jj_consume_token(31);
    t = jj_consume_token(ALPHANUMERIC);
    jj_consume_token(NEWLINE);
      m_handler.handleTaskId(t.image);
  }

  final public void exactMatchWordCount() throws ParseException {
    Token t;
    jj_consume_token(32);
    t = jj_consume_token(ALPHANUMERIC);
    jj_consume_token(NEWLINE);
      m_handler.handleExactMatchWordCount(t.image);
  }

  final public void fuzzyMatchWordCount() throws ParseException {
    Token t;
    jj_consume_token(33);
    t = jj_consume_token(ALPHANUMERIC);
    jj_consume_token(NEWLINE);
      m_handler.handleFuzzyMatchWordCount(t.image);
  }

  final public void unmatchedMatchWordCount() throws ParseException {
    Token t;
    jj_consume_token(34);
    t = jj_consume_token(ALPHANUMERIC);
    jj_consume_token(NEWLINE);
      m_handler.handleUnmatchedMatchWordCount(t.image);
  }

  final public void serverInstanceID() throws ParseException {
    Token t;
    jj_consume_token(35);
    t = jj_consume_token(ALPHANUMERIC);
    jj_consume_token(NEWLINE);
      m_handler.setServerInstanceID(t.image);
  }

  final public void editAll() throws ParseException {
    Token t;
    jj_consume_token(36);
    t = jj_consume_token(ALPHANUMERIC);
    jj_consume_token(NEWLINE);
      m_handler.handleEditAll(t.image);
  }

  final public void help() throws ParseException {
    Token t;
    t = jj_consume_token(HEADER_HELP_LINE);
    jj_consume_token(NEWLINE);
  }

  final public void notes() throws ParseException {
    Token t;
    t = jj_consume_token(HEADER_NOTE_LINE);
    jj_consume_token(NEWLINE);
  }

  final public void entry() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case SUBFLOW_ID:
      subflowId();
      break;
    case ID:
      id();
      break;
    default:
      jj_la1[12] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
    text();
  }

  final public void id() throws ParseException {
    Token sk = null;
    Token sf = null;
    Token mt = null;
    Token ms = null;
    Token tk = null;
    Token t = null;
    Token pageName = null;
    t = jj_consume_token(ID);
        // remove "#" from string
        m_handler.handleId(t.image.substring(1).trim());
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case PAGE_NAME:
      pageName = jj_consume_token(PAGE_NAME);
            if (pageName != null)
            {
                // remove "# Page Name: " from string
                m_handler.handlePageName(pageName.image.substring(12).trim());
            }
      break;
    default:
      jj_la1[13] = jj_gen;
      ;
    }
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case SEG_FORMAT:
      sf = jj_consume_token(SEG_FORMAT);
            if (sf != null)
            {
                // remove "# Segment Format: " from string
                m_handler.handleSegmentFormat(sf.image.substring(17).trim());
            }
      break;
    default:
      jj_la1[14] = jj_gen;
      ;
    }
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case MATCH_TYPE:
      mt = jj_consume_token(MATCH_TYPE);
            if (mt != null)
            {
                // remove "# Match Type: " from string
                m_handler.handleMatchType(mt.image.substring(13).trim());
            }
      break;
    default:
      jj_la1[15] = jj_gen;
      ;
    }
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case MATCH_SCORE:
      ms = jj_consume_token(MATCH_SCORE);
            if (ms != null)
            {
                // remove "# Match Score: " from string
                m_handler.handleMatchScore(ms.image.substring(14).trim());
            }
      break;
    default:
      jj_la1[16] = jj_gen;
      ;
    }
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case RESOURCES:
      mt = jj_consume_token(RESOURCES);

      break;
    default:
      jj_la1[17] = jj_gen;
      ;
    }
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case SOURCE_KEY:
      // Start of source text
              sk = jj_consume_token(SOURCE_KEY);
          if (sk != null) m_handler.handleSourceKey(sk.image);
      text();
      // Start of target text
              tk = jj_consume_token(TARGET_KEY);
          if (tk != null) m_handler.handleTargetKey(tk.image);
      break;
    default:
      jj_la1[18] = jj_gen;
      ;
    }
  }

  final public void subflowId() throws ParseException {
    Token sk = null;
    Token sf = null;
    Token mt = null;
    Token ms = null;
    Token tk = null;
    Token t = null;
    Token pageName = null;
    t = jj_consume_token(SUBFLOW_ID);
        // remove "#" from string
        m_handler.handleSubflowId(t.image.substring(1).trim());
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case PAGE_NAME:
      pageName = jj_consume_token(PAGE_NAME);
            if (pageName != null)
            {
                // remove "# Page Name: " from string
                m_handler.handlePageName(pageName.image.substring(12).trim());
            }
      break;
    default:
      jj_la1[19] = jj_gen;
      ;
    }
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case SEG_FORMAT:
      sf = jj_consume_token(SEG_FORMAT);
            if (sf != null)
            {
                // remove "# Segment Format: " from string
                m_handler.handleSegmentFormat(sf.image.substring(17).trim());
            }
      break;
    default:
      jj_la1[20] = jj_gen;
      ;
    }
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case MATCH_TYPE:
      mt = jj_consume_token(MATCH_TYPE);
            if (mt != null)
            {
                // remove "# Match Type: " from string
                m_handler.handleMatchType(mt.image.substring(13).trim());
            }
      break;
    default:
      jj_la1[21] = jj_gen;
      ;
    }
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case MATCH_SCORE:
      ms = jj_consume_token(MATCH_SCORE);
            if (ms != null)
            {
                // remove "# Match Score: " from string
                m_handler.handleMatchScore(ms.image.substring(14).trim());
            }
      break;
    default:
      jj_la1[22] = jj_gen;
      ;
    }
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case RESOURCES:
      mt = jj_consume_token(RESOURCES);

      break;
    default:
      jj_la1[23] = jj_gen;
      ;
    }
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case SOURCE_KEY:
      // Start of source text
              sk = jj_consume_token(SOURCE_KEY);
          if (sk != null) m_handler.handleSourceKey(sk.image);
      text();
      // Start of target text
              tk = jj_consume_token(TARGET_KEY);
          if (tk != null) m_handler.handleTargetKey(tk.image);
      break;
    default:
      jj_la1[24] = jj_gen;
      ;
    }
  }

  final public void text() throws ParseException {
    Token text = null;
    Token newline = null;
    label_4:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case TEXT:
        text = jj_consume_token(TEXT);
            // test to see of we "MORE'ed" a newline char
            if (text.image.charAt(0) == '\n' || text.image.charAt(0) == '\r')
            {
                m_handler.handleSegmentNewLine(text.image.substring(0, 1)); // newline
                m_handler.handleSegmentText(text.image.substring(1));
            }
            else // all text
            {
                m_handler.handleSegmentText(text.image);
            }
        break;
      case END_LINE:
        newline = jj_consume_token(END_LINE);
            // test to see of we "MORE'ed" a non-newline char
            if (newline.image.charAt(0) != '\n' && newline.image.charAt(0) != '\r')
            {
                m_handler.handleSegmentText(newline.image.substring(0, 1)); // first char
                m_handler.handleSegmentNewLine(newline.image.substring(1));
            }
            else // all newlines
            {
                m_handler.handleSegmentNewLine(newline.image);
            }
        break;
      default:
        jj_la1[25] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case END_LINE:
      case TEXT:
        ;
        break;
      default:
        jj_la1[26] = jj_gen;
        break label_4;
      }
    }
  }

  /** Generated Token Manager. */
  public AmbassadorDwUpParserTokenManager token_source;
  SimpleCharStream jj_input_stream;
  /** Current token. */
  public Token token;
  /** Next token. */
  public Token jj_nt;
  private int jj_ntk;
  private int jj_gen;
  final private int[] jj_la1 = new int[27];
  static private int[] jj_la1_0;
  static private int[] jj_la1_1;
  static {
      jj_la1_init_0();
      jj_la1_init_1();
   }
   private static void jj_la1_init_0() {
      jj_la1_0 = new int[] {0x20,0x300,0x4000000,0x8000000,0x10000000,0x0,0x0,0x0,0x0,0x0,0x40,0x80,0x300,0x400,0x800,0x1000,0x2000,0x4000,0x8000,0x400,0x800,0x1000,0x2000,0x4000,0x8000,0x180000,0x180000,};
   }
   private static void jj_la1_init_1() {
      jj_la1_1 = new int[] {0x0,0x0,0x0,0x0,0x0,0x1,0x2,0x4,0x8,0x10,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,};
   }

  /** Constructor with InputStream. */
  public AmbassadorDwUpParser(java.io.InputStream stream) {
     this(stream, null);
  }
  /** Constructor with InputStream and supplied encoding */
  public AmbassadorDwUpParser(java.io.InputStream stream, String encoding) {
    try { jj_input_stream = new SimpleCharStream(stream, encoding, 1, 1); } catch(java.io.UnsupportedEncodingException e) { throw new RuntimeException(e); }
    token_source = new AmbassadorDwUpParserTokenManager(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 27; i++) jj_la1[i] = -1;
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
    for (int i = 0; i < 27; i++) jj_la1[i] = -1;
  }

  /** Constructor. */
  public AmbassadorDwUpParser(java.io.Reader stream) {
    jj_input_stream = new SimpleCharStream(stream, 1, 1);
    token_source = new AmbassadorDwUpParserTokenManager(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 27; i++) jj_la1[i] = -1;
  }

  /** Reinitialise. */
  public void ReInit(java.io.Reader stream) {
    jj_input_stream.ReInit(stream, 1, 1);
    token_source.ReInit(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 27; i++) jj_la1[i] = -1;
  }

  /** Constructor with generated Token Manager. */
  public AmbassadorDwUpParser(AmbassadorDwUpParserTokenManager tm) {
    token_source = tm;
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 27; i++) jj_la1[i] = -1;
  }

  /** Reinitialise. */
  public void ReInit(AmbassadorDwUpParserTokenManager tm) {
    token_source = tm;
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 27; i++) jj_la1[i] = -1;
  }

  private Token jj_consume_token(int kind) throws ParseException {
    Token oldToken;
    if ((oldToken = token).next != null) token = token.next;
    else token = token.next = token_source.getNextToken();
    jj_ntk = -1;
    if (token.kind == kind) {
      jj_gen++;
      return token;
    }
    token = oldToken;
    jj_kind = kind;
    throw generateParseException();
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

  /** Generate ParseException. */
  public ParseException generateParseException() {
    jj_expentries.clear();
    boolean[] la1tokens = new boolean[37];
    if (jj_kind >= 0) {
      la1tokens[jj_kind] = true;
      jj_kind = -1;
    }
    for (int i = 0; i < 27; i++) {
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

}

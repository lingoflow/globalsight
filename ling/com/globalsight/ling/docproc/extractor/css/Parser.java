/* Generated By:JavaCC: Do not edit this line. Parser.java */
package com.globalsight.ling.docproc.extractor.css;

/**
 * A CSS Parser automatically generated by JavaCC.  Fires {@link
 * com.globalsight.ling.docproc.extractor.css.IParseEvents
 * IParseEvents}.
 */
public class Parser implements ParserConstants {
    private IParseEvents m_handler = null;

    public void setHandler(IParseEvents p_handler)
    {
        m_handler = p_handler;
    }

/*****************************************
 * SYNTATIC RULES
 *****************************************/

/**
 * Main entry point of the parser.  This rule parses an entire CSS
 * style sheet.
 */
  final public void Parse() throws ParseException {
    Token t;
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
      case S:
      case L:
      case C:
      case DIMENSION:
      case PERCENTAGE:
      case NUMBER:
      case STRING:
      case IDENT:
      case UNICODERANGE:
      case HASH:
      case FUNCTION:
      case URI:
      case RGB:
      case RECT:
      case CHARSET:
      case FONTFACE:
      case IMPORT:
      case MEDIA:
      case ATKEYWORD:
      case LPAREN:
      case LBRACE:
      case LBRACKET:
      case COLON:
      case INCLUDES:
      case DASHMATCH:
      case COMMA:
      case CDO:
      case CDC:
      case DELIM:
        ;
        break;
      default:
        jj_la1[1] = jj_gen;
        break label_1;
      }
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case CDO:
        t = jj_consume_token(CDO);
                         m_handler.handleCDO(t.image);
        break;
      case CDC:
        t = jj_consume_token(CDC);
                         m_handler.handleCDC(t.image);
        break;
      case DIMENSION:
      case PERCENTAGE:
      case NUMBER:
      case STRING:
      case IDENT:
      case UNICODERANGE:
      case HASH:
      case FUNCTION:
      case URI:
      case RGB:
      case RECT:
      case CHARSET:
      case FONTFACE:
      case IMPORT:
      case MEDIA:
      case ATKEYWORD:
      case LPAREN:
      case LBRACE:
      case LBRACKET:
      case COLON:
      case INCLUDES:
      case DASHMATCH:
      case COMMA:
      case DELIM:
        Statement();
        break;
      case S:
      case L:
      case C:
        W();
        break;
      default:
        jj_la1[2] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
    }
    jj_consume_token(0);
                         m_handler.handleFinish();
  }

  final public void W() throws ParseException {
    Token t;
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case S:
      t = jj_consume_token(S);
                         m_handler.handleWhite  (t.image);
      break;
    case C:
      t = jj_consume_token(C);
                         m_handler.handleComment(t.image);
      break;
    case L:
      t = jj_consume_token(L);
                         m_handler.handleEndOfLine(t.image);
      break;
    default:
      jj_la1[3] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

  final public void Statement() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case DIMENSION:
    case PERCENTAGE:
    case NUMBER:
    case STRING:
    case IDENT:
    case UNICODERANGE:
    case HASH:
    case FUNCTION:
    case URI:
    case RGB:
    case RECT:
    case LPAREN:
    case LBRACE:
    case LBRACKET:
    case COLON:
    case INCLUDES:
    case DASHMATCH:
    case COMMA:
    case DELIM:
      Ruleset();
      break;
    case ATKEYWORD:
      AtRule();
      break;
    case CHARSET:
      CharSet();
      break;
    case FONTFACE:
      FontFace();
      break;
    case IMPORT:
      Import();
      break;
    case MEDIA:
      Media();
      break;
    default:
      jj_la1[4] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

// handle some @keywords and leave the general AtRule() for unknown stuff
  final public void CharSet() throws ParseException {
    Token t;
    t = jj_consume_token(CHARSET);
                         m_handler.handleStartCharset(t.image);
    label_2:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case S:
      case L:
      case C:
        ;
        break;
      default:
        jj_la1[5] = jj_gen;
        break label_2;
      }
      W();
    }
    t = jj_consume_token(STRING);
                         m_handler.handleCharset(t.image);
    label_3:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case S:
      case L:
      case C:
        ;
        break;
      default:
        jj_la1[6] = jj_gen;
        break label_3;
      }
      W();
    }
    t = jj_consume_token(SEMICOLON);
                         m_handler.handleEndCharset(t.image);
    label_4:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case S:
      case L:
      case C:
        ;
        break;
      default:
        jj_la1[7] = jj_gen;
        break label_4;
      }
      W();
    }
  }

  final public void Import() throws ParseException {
    Token t;
    t = jj_consume_token(IMPORT);
                         m_handler.handleStartImport(t.image);
    label_5:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case S:
      case L:
      case C:
        ;
        break;
      default:
        jj_la1[8] = jj_gen;
        break label_5;
      }
      W();
    }
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case STRING:
      t = jj_consume_token(STRING);
                         m_handler.handleImport(t.image);
      break;
    case URI:
      t = jj_consume_token(URI);
                         m_handler.handleImportURI(t.image);
      break;
    default:
      jj_la1[9] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
    label_6:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case S:
      case L:
      case C:
        ;
        break;
      default:
        jj_la1[10] = jj_gen;
        break label_6;
      }
      W();
    }
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case IDENT:
      t = jj_consume_token(IDENT);
                         m_handler.handleMedia(t.image);
      label_7:
      while (true) {
        switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
        case S:
        case L:
        case C:
          ;
          break;
        default:
          jj_la1[11] = jj_gen;
          break label_7;
        }
        W();
      }
      label_8:
      while (true) {
        switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
        case COMMA:
          ;
          break;
        default:
          jj_la1[12] = jj_gen;
          break label_8;
        }
        t = jj_consume_token(COMMA);
                         m_handler.handleDelimiter(t.image);
        label_9:
        while (true) {
          switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
          case S:
          case L:
          case C:
            ;
            break;
          default:
            jj_la1[13] = jj_gen;
            break label_9;
          }
          W();
        }
        t = jj_consume_token(IDENT);
                         m_handler.handleMedia(t.image);
        label_10:
        while (true) {
          switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
          case S:
          case L:
          case C:
            ;
            break;
          default:
            jj_la1[14] = jj_gen;
            break label_10;
          }
          W();
        }
      }
      break;
    default:
      jj_la1[15] = jj_gen;
      ;
    }
    t = jj_consume_token(SEMICOLON);
                         m_handler.handleEndImport(t.image);
    label_11:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case S:
      case L:
      case C:
        ;
        break;
      default:
        jj_la1[16] = jj_gen;
        break label_11;
      }
      W();
    }
  }

  final public void FontFace() throws ParseException {
    Token t;
    t = jj_consume_token(FONTFACE);
                         m_handler.handleStartFontFace(t.image);
    label_12:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case S:
      case L:
      case C:
        ;
        break;
      default:
        jj_la1[17] = jj_gen;
        break label_12;
      }
      W();
    }
    t = jj_consume_token(LBRACE);
                         m_handler.handleDelimiter(t.image);
    label_13:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case S:
      case L:
      case C:
        ;
        break;
      default:
        jj_la1[18] = jj_gen;
        break label_13;
      }
      W();
    }
    OptionalDeclarationList();
    t = jj_consume_token(RBRACE);
                         m_handler.handleEndFontFace(t.image);
    label_14:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case S:
      case L:
      case C:
        ;
        break;
      default:
        jj_la1[19] = jj_gen;
        break label_14;
      }
      W();
    }
  }

  final public void Media() throws ParseException {
    Token t;
    t = jj_consume_token(MEDIA);
                          m_handler.handleStartMedia(t.image);
    label_15:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case S:
      case L:
      case C:
        ;
        break;
      default:
        jj_la1[20] = jj_gen;
        break label_15;
      }
      W();
    }
    t = jj_consume_token(IDENT);
                          m_handler.handleMedia(t.image);
    label_16:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case S:
      case L:
      case C:
        ;
        break;
      default:
        jj_la1[21] = jj_gen;
        break label_16;
      }
      W();
    }
    label_17:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case COMMA:
        ;
        break;
      default:
        jj_la1[22] = jj_gen;
        break label_17;
      }
      t = jj_consume_token(COMMA);
                          m_handler.handleDelimiter(t.image);
      label_18:
      while (true) {
        switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
        case S:
        case L:
        case C:
          ;
          break;
        default:
          jj_la1[23] = jj_gen;
          break label_18;
        }
        W();
      }
      t = jj_consume_token(IDENT);
                          m_handler.handleMedia(t.image);
      label_19:
      while (true) {
        switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
        case S:
        case L:
        case C:
          ;
          break;
        default:
          jj_la1[24] = jj_gen;
          break label_19;
        }
        W();
      }
    }
    t = jj_consume_token(LBRACE);
                          m_handler.handleDelimiter(t.image);
    label_20:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case S:
      case L:
      case C:
        ;
        break;
      default:
        jj_la1[25] = jj_gen;
        break label_20;
      }
      W();
    }
    label_21:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case DIMENSION:
      case PERCENTAGE:
      case NUMBER:
      case STRING:
      case IDENT:
      case UNICODERANGE:
      case HASH:
      case FUNCTION:
      case URI:
      case RGB:
      case RECT:
      case ATKEYWORD:
      case LPAREN:
      case LBRACE:
      case LBRACKET:
      case COLON:
      case INCLUDES:
      case DASHMATCH:
      case COMMA:
      case DELIM:
        ;
        break;
      default:
        jj_la1[26] = jj_gen;
        break label_21;
      }
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case DIMENSION:
      case PERCENTAGE:
      case NUMBER:
      case STRING:
      case IDENT:
      case UNICODERANGE:
      case HASH:
      case FUNCTION:
      case URI:
      case RGB:
      case RECT:
      case LPAREN:
      case LBRACE:
      case LBRACKET:
      case COLON:
      case INCLUDES:
      case DASHMATCH:
      case COMMA:
      case DELIM:
        Ruleset();
        break;
      case ATKEYWORD:
        AtRule();
        break;
      default:
        jj_la1[27] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
    }
    t = jj_consume_token(RBRACE);
                          m_handler.handleEndMedia(t.image);
    label_22:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case S:
      case L:
      case C:
        ;
        break;
      default:
        jj_la1[28] = jj_gen;
        break label_22;
      }
      W();
    }
  }

  final public void AtRule() throws ParseException {
    Token t;
    t = jj_consume_token(ATKEYWORD);
                         m_handler.handleStartAtRule(t.image);
    label_23:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case S:
      case L:
      case C:
        ;
        break;
      default:
        jj_la1[29] = jj_gen;
        break label_23;
      }
      W();
    }
    label_24:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case DIMENSION:
      case PERCENTAGE:
      case NUMBER:
      case STRING:
      case IDENT:
      case UNICODERANGE:
      case HASH:
      case FUNCTION:
      case URI:
      case RGB:
      case RECT:
      case LPAREN:
      case LBRACKET:
      case COLON:
      case INCLUDES:
      case DASHMATCH:
      case COMMA:
      case DELIM:
        ;
        break;
      default:
        jj_la1[30] = jj_gen;
        break label_24;
      }
      Any();
    }
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case LBRACE:
    case SEMICOLON:
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case LBRACE:
        t = jj_consume_token(LBRACE);
                           m_handler.handleStartDeclarations(t.image);
        label_25:
        while (true) {
          switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
          case S:
          case L:
          case C:
            ;
            break;
          default:
            jj_la1[31] = jj_gen;
            break label_25;
          }
          W();
        }
        OptionalDeclarationList();
        t = jj_consume_token(RBRACE);
                           m_handler.handleEndDeclarations(t.image);
        label_26:
        while (true) {
          switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
          case S:
          case L:
          case C:
            ;
            break;
          default:
            jj_la1[32] = jj_gen;
            break label_26;
          }
          W();
        }
        break;
      case SEMICOLON:
        t = jj_consume_token(SEMICOLON);
                         m_handler.handleDelimiter(t.image);
        label_27:
        while (true) {
          switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
          case S:
          case L:
          case C:
            ;
            break;
          default:
            jj_la1[33] = jj_gen;
            break label_27;
          }
          W();
        }
        break;
      default:
        jj_la1[34] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
      break;
    default:
      jj_la1[35] = jj_gen;
      ;
    }
  }

  final public void Block() throws ParseException {
    Token t;
    t = jj_consume_token(LBRACE);
                         m_handler.handleStartBlock(t.image);
    label_28:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case S:
      case L:
      case C:
        ;
        break;
      default:
        jj_la1[36] = jj_gen;
        break label_28;
      }
      W();
    }
    label_29:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case DIMENSION:
      case PERCENTAGE:
      case NUMBER:
      case STRING:
      case IDENT:
      case UNICODERANGE:
      case HASH:
      case FUNCTION:
      case URI:
      case RGB:
      case RECT:
      case ATKEYWORD:
      case LPAREN:
      case LBRACE:
      case LBRACKET:
      case COLON:
      case SEMICOLON:
      case INCLUDES:
      case DASHMATCH:
      case COMMA:
      case DELIM:
        ;
        break;
      default:
        jj_la1[37] = jj_gen;
        break label_29;
      }
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case DIMENSION:
      case PERCENTAGE:
      case NUMBER:
      case STRING:
      case IDENT:
      case UNICODERANGE:
      case HASH:
      case FUNCTION:
      case URI:
      case RGB:
      case RECT:
      case LPAREN:
      case LBRACKET:
      case COLON:
      case INCLUDES:
      case DASHMATCH:
      case COMMA:
      case DELIM:
        Any();
        break;
      case LBRACE:
        Block();
        break;
      case ATKEYWORD:
        t = jj_consume_token(ATKEYWORD);
                         m_handler.handleStartAtRule(t.image);
        label_30:
        while (true) {
          switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
          case S:
          case L:
          case C:
            ;
            break;
          default:
            jj_la1[38] = jj_gen;
            break label_30;
          }
          W();
        }
        break;
      case SEMICOLON:
        t = jj_consume_token(SEMICOLON);
                         m_handler.handleDelimiter(t.image);
        label_31:
        while (true) {
          switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
          case S:
          case L:
          case C:
            ;
            break;
          default:
            jj_la1[39] = jj_gen;
            break label_31;
          }
          W();
        }
        break;
      default:
        jj_la1[40] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
    }
    t = jj_consume_token(RBRACE);
                         m_handler.handleEndBlock(t.image);
    label_32:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case S:
      case L:
      case C:
        ;
        break;
      default:
        jj_la1[41] = jj_gen;
        break label_32;
      }
      W();
    }
  }

  final public void Ruleset() throws ParseException {
    Token t;
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case DIMENSION:
    case PERCENTAGE:
    case NUMBER:
    case STRING:
    case IDENT:
    case UNICODERANGE:
    case HASH:
    case FUNCTION:
    case URI:
    case RGB:
    case RECT:
    case LPAREN:
    case LBRACKET:
    case COLON:
    case INCLUDES:
    case DASHMATCH:
    case COMMA:
    case DELIM:
      Selector();
      break;
    default:
      jj_la1[42] = jj_gen;
      ;
    }
    t = jj_consume_token(LBRACE);
                         m_handler.handleStartDeclarations(t.image);
    label_33:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case S:
      case L:
      case C:
        ;
        break;
      default:
        jj_la1[43] = jj_gen;
        break label_33;
      }
      W();
    }
    OptionalDeclarationList();
    t = jj_consume_token(RBRACE);
                         m_handler.handleEndDeclarations(t.image);
    label_34:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case S:
      case L:
      case C:
        ;
        break;
      default:
        jj_la1[44] = jj_gen;
        break label_34;
      }
      W();
    }
  }

  final public void OptionalDeclarationList() throws ParseException {
    Token t;
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case IDENT:
      Declaration();
      break;
    default:
      jj_la1[45] = jj_gen;
      ;
    }
    label_35:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case SEMICOLON:
        ;
        break;
      default:
        jj_la1[46] = jj_gen;
        break label_35;
      }
      t = jj_consume_token(SEMICOLON);
                         m_handler.handleDelimiter(t.image);
      label_36:
      while (true) {
        switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
        case S:
        case L:
        case C:
          ;
          break;
        default:
          jj_la1[47] = jj_gen;
          break label_36;
        }
        W();
      }
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case IDENT:
        Declaration();
        break;
      default:
        jj_la1[48] = jj_gen;
        ;
      }
    }
  }

/**
 * Second entry point to parse styles inside the STYLE attribute.  We
 * allow for an optional Unicode byte order mark at the beginning of
 * the input.
 */
  final public void DeclarationList() throws ParseException {
    Token t;
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case UNICODE_BOM:
      jj_consume_token(UNICODE_BOM);
      break;
    default:
      jj_la1[49] = jj_gen;
      ;
    }
    label_37:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case S:
      case L:
      case C:
        ;
        break;
      default:
        jj_la1[50] = jj_gen;
        break label_37;
      }
      W();
    }
    Declaration();
    label_38:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case SEMICOLON:
        ;
        break;
      default:
        jj_la1[51] = jj_gen;
        break label_38;
      }
      t = jj_consume_token(SEMICOLON);
                         m_handler.handleDelimiter(t.image);
      label_39:
      while (true) {
        switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
        case S:
        case L:
        case C:
          ;
          break;
        default:
          jj_la1[52] = jj_gen;
          break label_39;
        }
        W();
      }
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case IDENT:
        Declaration();
        break;
      default:
        jj_la1[53] = jj_gen;
        ;
      }
    }
  }

  final public void Selector() throws ParseException {
    label_40:
    while (true) {
      Any();
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case DIMENSION:
      case PERCENTAGE:
      case NUMBER:
      case STRING:
      case IDENT:
      case UNICODERANGE:
      case HASH:
      case FUNCTION:
      case URI:
      case RGB:
      case RECT:
      case LPAREN:
      case LBRACKET:
      case COLON:
      case INCLUDES:
      case DASHMATCH:
      case COMMA:
      case DELIM:
        ;
        break;
      default:
        jj_la1[54] = jj_gen;
        break label_40;
      }
    }
  }

  final public void Declaration() throws ParseException {
    Token t;
    StyleName();
    t = jj_consume_token(COLON);
                         m_handler.handleStartValues(t.image);
    label_41:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case S:
      case L:
      case C:
        ;
        break;
      default:
        jj_la1[55] = jj_gen;
        break label_41;
      }
      W();
    }
    StyleValue();
                         m_handler.handleEndValues();
  }

  final public void StyleName() throws ParseException {
    Token t;
    t = jj_consume_token(IDENT);
                         m_handler.handleStyle(t.image);
    label_42:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case S:
      case L:
      case C:
        ;
        break;
      default:
        jj_la1[56] = jj_gen;
        break label_42;
      }
      W();
    }
  }

  final public void StyleValue() throws ParseException {
    Token t;
    label_43:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case DIMENSION:
      case PERCENTAGE:
      case NUMBER:
      case STRING:
      case IDENT:
      case UNICODERANGE:
      case HASH:
      case FUNCTION:
      case URI:
      case RGB:
      case RECT:
      case LPAREN:
      case LBRACKET:
      case COLON:
      case INCLUDES:
      case DASHMATCH:
      case COMMA:
      case DELIM:
        Any();
        break;
      case LBRACE:
        Block();
        break;
      case ATKEYWORD:
        t = jj_consume_token(ATKEYWORD);
                         m_handler.handleStartAtRule(t.image);
        label_44:
        while (true) {
          switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
          case S:
          case L:
          case C:
            ;
            break;
          default:
            jj_la1[57] = jj_gen;
            break label_44;
          }
          W();
        }
        break;
      default:
        jj_la1[58] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case DIMENSION:
      case PERCENTAGE:
      case NUMBER:
      case STRING:
      case IDENT:
      case UNICODERANGE:
      case HASH:
      case FUNCTION:
      case URI:
      case RGB:
      case RECT:
      case ATKEYWORD:
      case LPAREN:
      case LBRACE:
      case LBRACKET:
      case COLON:
      case INCLUDES:
      case DASHMATCH:
      case COMMA:
      case DELIM:
        ;
        break;
      default:
        jj_la1[59] = jj_gen;
        break label_43;
      }
    }
  }

  final public void Any() throws ParseException {
    Token t;
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case IDENT:
      t = jj_consume_token(IDENT);
                         m_handler.handleToken(t.image);
      break;
    case NUMBER:
      t = jj_consume_token(NUMBER);
                         m_handler.handleToken(t.image);
      break;
    case PERCENTAGE:
      t = jj_consume_token(PERCENTAGE);
                         m_handler.handleToken(t.image);
      break;
    case DIMENSION:
      t = jj_consume_token(DIMENSION);
                         m_handler.handleToken(t.image);
      break;
    case STRING:
      t = jj_consume_token(STRING);
                         m_handler.handleToken(t.image);
      break;
    case DELIM:
      t = jj_consume_token(DELIM);
                         m_handler.handleDelimiter(t.image);
      break;
    case COMMA:
      t = jj_consume_token(COMMA);
                         m_handler.handleDelimiter(t.image);
      break;
    case COLON:
      t = jj_consume_token(COLON);
                         m_handler.handleDelimiter(t.image);
      break;
    case URI:
      t = jj_consume_token(URI);
                         m_handler.handleFunction(t.image);
      break;
    case RGB:
      t = jj_consume_token(RGB);
                         m_handler.handleFunction(t.image);
      break;
    case RECT:
      t = jj_consume_token(RECT);
                         m_handler.handleFunction(t.image);
      break;
    case HASH:
      t = jj_consume_token(HASH);
                         m_handler.handleToken(t.image);
      break;
    case UNICODERANGE:
      t = jj_consume_token(UNICODERANGE);
                         m_handler.handleToken(t.image);
      break;
    case INCLUDES:
      t = jj_consume_token(INCLUDES);
                         m_handler.handleDelimiter(t.image);
      break;
    case DASHMATCH:
      t = jj_consume_token(DASHMATCH);
                         m_handler.handleDelimiter(t.image);
      break;
    case FUNCTION:
      t = jj_consume_token(FUNCTION);
                         m_handler.handleFunction(t.image);
      label_45:
      while (true) {
        switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
        case S:
        case L:
        case C:
        case DIMENSION:
        case PERCENTAGE:
        case NUMBER:
        case STRING:
        case IDENT:
        case UNICODERANGE:
        case HASH:
        case FUNCTION:
        case URI:
        case RGB:
        case RECT:
        case LPAREN:
        case LBRACKET:
        case COLON:
        case INCLUDES:
        case DASHMATCH:
        case COMMA:
        case DELIM:
          ;
          break;
        default:
          jj_la1[60] = jj_gen;
          break label_45;
        }
        switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
        case S:
        case L:
        case C:
          W();
          break;
        case DIMENSION:
        case PERCENTAGE:
        case NUMBER:
        case STRING:
        case IDENT:
        case UNICODERANGE:
        case HASH:
        case FUNCTION:
        case URI:
        case RGB:
        case RECT:
        case LPAREN:
        case LBRACKET:
        case COLON:
        case INCLUDES:
        case DASHMATCH:
        case COMMA:
        case DELIM:
          Any();
          break;
        default:
          jj_la1[61] = jj_gen;
          jj_consume_token(-1);
          throw new ParseException();
        }
      }
      t = jj_consume_token(RPAREN);
                         m_handler.handleDelimiter(t.image);
      break;
    case LPAREN:
      t = jj_consume_token(LPAREN);
                         m_handler.handleDelimiter(t.image);
      label_46:
      while (true) {
        switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
        case S:
        case L:
        case C:
        case DIMENSION:
        case PERCENTAGE:
        case NUMBER:
        case STRING:
        case IDENT:
        case UNICODERANGE:
        case HASH:
        case FUNCTION:
        case URI:
        case RGB:
        case RECT:
        case LPAREN:
        case LBRACKET:
        case COLON:
        case INCLUDES:
        case DASHMATCH:
        case COMMA:
        case DELIM:
          ;
          break;
        default:
          jj_la1[62] = jj_gen;
          break label_46;
        }
        switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
        case S:
        case L:
        case C:
          W();
          break;
        case DIMENSION:
        case PERCENTAGE:
        case NUMBER:
        case STRING:
        case IDENT:
        case UNICODERANGE:
        case HASH:
        case FUNCTION:
        case URI:
        case RGB:
        case RECT:
        case LPAREN:
        case LBRACKET:
        case COLON:
        case INCLUDES:
        case DASHMATCH:
        case COMMA:
        case DELIM:
          Any();
          break;
        default:
          jj_la1[63] = jj_gen;
          jj_consume_token(-1);
          throw new ParseException();
        }
      }
      t = jj_consume_token(RPAREN);
                         m_handler.handleDelimiter(t.image);
      break;
    case LBRACKET:
      t = jj_consume_token(LBRACKET);
                         m_handler.handleDelimiter(t.image);
      label_47:
      while (true) {
        switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
        case S:
        case L:
        case C:
        case DIMENSION:
        case PERCENTAGE:
        case NUMBER:
        case STRING:
        case IDENT:
        case UNICODERANGE:
        case HASH:
        case FUNCTION:
        case URI:
        case RGB:
        case RECT:
        case LPAREN:
        case LBRACKET:
        case COLON:
        case INCLUDES:
        case DASHMATCH:
        case COMMA:
        case DELIM:
          ;
          break;
        default:
          jj_la1[64] = jj_gen;
          break label_47;
        }
        switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
        case S:
        case L:
        case C:
          W();
          break;
        case DIMENSION:
        case PERCENTAGE:
        case NUMBER:
        case STRING:
        case IDENT:
        case UNICODERANGE:
        case HASH:
        case FUNCTION:
        case URI:
        case RGB:
        case RECT:
        case LPAREN:
        case LBRACKET:
        case COLON:
        case INCLUDES:
        case DASHMATCH:
        case COMMA:
        case DELIM:
          Any();
          break;
        default:
          jj_la1[65] = jj_gen;
          jj_consume_token(-1);
          throw new ParseException();
        }
      }
      t = jj_consume_token(RBRACKET);
                         m_handler.handleDelimiter(t.image);
      break;
    default:
      jj_la1[66] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
    label_48:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case S:
      case L:
      case C:
        ;
        break;
      default:
        jj_la1[67] = jj_gen;
        break label_48;
      }
      W();
    }
  }

  /** Generated Token Manager. */
  public ParserTokenManager token_source;
  SimpleCharStream jj_input_stream;
  /** Current token. */
  public Token token;
  /** Next token. */
  public Token jj_nt;
  private int jj_ntk;
  private int jj_gen;
  final private int[] jj_la1 = new int[68];
  static private int[] jj_la1_0;
  static private int[] jj_la1_1;
  static {
      jj_la1_init_0();
      jj_la1_init_1();
   }
   private static void jj_la1_init_0() {
      jj_la1_0 = new int[] {0x8,0xabffc3f6,0xabffc3f6,0x16,0xabffc3e0,0x16,0x16,0x16,0x16,0x20100,0x16,0x16,0x0,0x16,0x16,0x200,0x16,0x16,0x16,0x16,0x16,0x16,0x0,0x16,0x16,0x16,0xab0fc3e0,0xab0fc3e0,0x16,0x16,0xa20fc3e0,0x16,0x16,0x16,0x8000000,0x8000000,0x16,0xab0fc3e0,0x16,0x16,0xab0fc3e0,0x16,0xa20fc3e0,0x16,0x16,0x200,0x0,0x16,0x200,0x8,0x16,0x0,0x16,0x200,0xa20fc3e0,0x16,0x16,0x16,0xab0fc3e0,0xab0fc3e0,0xa20fc3f6,0xa20fc3f6,0xa20fc3f6,0xa20fc3f6,0xa20fc3f6,0xa20fc3f6,0xa20fc3e0,0x16,};
   }
   private static void jj_la1_init_1() {
      jj_la1_1 = new int[] {0x0,0x7e,0x7e,0x0,0x4e,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x8,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x8,0x0,0x0,0x0,0x4e,0x4e,0x0,0x0,0x4e,0x0,0x0,0x0,0x1,0x1,0x0,0x4f,0x0,0x0,0x4f,0x0,0x4e,0x0,0x0,0x0,0x1,0x0,0x0,0x0,0x0,0x1,0x0,0x0,0x4e,0x0,0x0,0x0,0x4e,0x4e,0x4e,0x4e,0x4e,0x4e,0x4e,0x4e,0x4e,0x0,};
   }

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
    for (int i = 0; i < 68; i++) jj_la1[i] = -1;
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
    for (int i = 0; i < 68; i++) jj_la1[i] = -1;
  }

  /** Constructor. */
  public Parser(java.io.Reader stream) {
    jj_input_stream = new SimpleCharStream(stream, 1, 1);
    token_source = new ParserTokenManager(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 68; i++) jj_la1[i] = -1;
  }

  /** Reinitialise. */
  public void ReInit(java.io.Reader stream) {
    jj_input_stream.ReInit(stream, 1, 1);
    token_source.ReInit(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 68; i++) jj_la1[i] = -1;
  }

  /** Constructor with generated Token Manager. */
  public Parser(ParserTokenManager tm) {
    token_source = tm;
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 68; i++) jj_la1[i] = -1;
  }

  /** Reinitialise. */
  public void ReInit(ParserTokenManager tm) {
    token_source = tm;
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 68; i++) jj_la1[i] = -1;
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
    boolean[] la1tokens = new boolean[39];
    if (jj_kind >= 0) {
      la1tokens[jj_kind] = true;
      jj_kind = -1;
    }
    for (int i = 0; i < 68; i++) {
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
    for (int i = 0; i < 39; i++) {
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
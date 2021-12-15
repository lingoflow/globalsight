/* Generated By:JavaCC: Do not edit this line. UCode_CharStream.java Version 0.7pre6 */
package com.globalsight.ling.docproc.extractor.html;

/* Generated By:JavaCC: Do not edit this line. UCode_CharStream.java Version 0.7pre6 */
/**
 * An implementation of interface CharStream, where the stream is assumed to
 * contain only Unicode characters.
 */

public final class UCode_CharStream
{
    public static final boolean staticFlag = false;
    public int bufpos = -1;
    int bufsize;
    int available;
    int tokenBegin;
    private int bufline[];
    private int bufcolumn[];

    public int column = 0;                        // CvdL
    public int line = 1;                          // CvdL

    private boolean prevCharIsCR = false;
    private boolean prevCharIsLF = false;

    private java.io.Reader inputStream;

    private char[] nextCharBuf;
    private char[] buffer;
    private int maxNextCharInd = 0;
    private int nextCharInd = -1;

    private boolean b_eof = false;                // CvdL
    private boolean b_eof_hack = false;           // CvdL

    private final void ExpandBuff(boolean wrapAround)
    {
        char[] newbuffer = new char[bufsize + 2048];
        int newbufline[] = new int[bufsize + 2048];
        int newbufcolumn[] = new int[bufsize + 2048];

        try
        {
            if (wrapAround)
            {
                System.arraycopy(buffer, tokenBegin, newbuffer, 0, bufsize - tokenBegin);
                System.arraycopy(buffer, 0, newbuffer,
                  bufsize - tokenBegin, bufpos);
                buffer = newbuffer;

                System.arraycopy(bufline, tokenBegin, newbufline, 0, bufsize - tokenBegin);
                System.arraycopy(bufline, 0, newbufline, bufsize - tokenBegin, bufpos);
                bufline = newbufline;

                System.arraycopy(bufcolumn, tokenBegin, newbufcolumn, 0, bufsize - tokenBegin);
                System.arraycopy(bufcolumn, 0, newbufcolumn, bufsize - tokenBegin, bufpos);
                bufcolumn = newbufcolumn;

                bufpos += (bufsize - tokenBegin);
            }
            else
            {
                System.arraycopy(buffer, tokenBegin, newbuffer, 0, bufsize - tokenBegin);
                buffer = newbuffer;

                System.arraycopy(bufline, tokenBegin, newbufline, 0, bufsize - tokenBegin);
                bufline = newbufline;

                System.arraycopy(bufcolumn, tokenBegin, newbufcolumn, 0, bufsize - tokenBegin);
                bufcolumn = newbufcolumn;

                bufpos -= tokenBegin;
            }
        }
        catch (Throwable t)
        {
            throw new Error(t.getMessage());
        }

        available = (bufsize += 2048);
        tokenBegin = 0;
    }

    private final void FillBuff() throws java.io.IOException
    {
        if (maxNextCharInd == 4096)
        {
            maxNextCharInd = nextCharInd = 0;
        }

        int i;
        try
        {
            if ((i = inputStream.read(nextCharBuf, maxNextCharInd,
              4096 - maxNextCharInd)) == -1)
            {
                inputStream.close();
                throw new java.io.IOException();
            }
            else
                maxNextCharInd += i;

            return;
        }
        catch (java.io.IOException e)
        {
            // System.err.println("EOF! - bufpos=" + bufpos + " tokenbegin=" + tokenBegin);
            b_eof = true;                         // CvdL

            if (bufpos > 0)
            {
                b_eof_hack = true;
                --bufpos;                         // CvdL: I don't get this code
                backup(0);                        // but we'll work around it
            }

            if (bufpos >= 0)
            {
                bufline[bufpos] = line;
                bufcolumn[bufpos] = column;
            }

            if (tokenBegin == -1)
            {
                tokenBegin = bufpos;
            }

            if (e instanceof java.nio.charset.MalformedInputException)
            {
                throw new TokenMgrError("Malformed encoding in input file",
                  TokenMgrError.LEXICAL_ERROR);
            }

            throw e;
        }
    }

    private final char ReadChar() throws java.io.IOException
    {
        /*   if (++nextCharInd >= maxNextCharInd)
             FillBuff();

             char c = (char)(((char)nextCharBuf[nextCharInd]) << 8);

             if (++nextCharInd >= maxNextCharInd)
             FillBuff();

             return (char)(c | ((char)0xff & nextCharBuf[nextCharInd]));*/

        if (++nextCharInd >= maxNextCharInd)
            FillBuff();
        char c = nextCharBuf[nextCharInd];
        return c;
    }

    public char BeginToken() throws java.io.IOException
    {
        tokenBegin = -1;
        char c = readChar();
        tokenBegin = bufpos;
        return c;
    }

    private final void UpdateLineColumn(char c)
    {
        column++;

        if (prevCharIsLF)
        {
            prevCharIsLF = false;
            line += (column = 1);
        }
        else if (prevCharIsCR)
        {
            prevCharIsCR = false;
            if (c == '\n')
            {
                prevCharIsLF = true;
            }
            else
                line += (column = 1);
        }

        switch (c)
        {
            case '\r' :
                prevCharIsCR = true;
                break;
            case '\n' :
                prevCharIsLF = true;
                break;
            case '\t' :
                column--;
                column += (8 - (column & 07));
                break;
            default :
                break;
        }

        bufline[bufpos] = line;             // CvdL
        bufcolumn[bufpos] = column;         // CvdL
    }

    private int inBuf = 0;

    public final char readChar() throws java.io.IOException
    {
        if (inBuf > 0)
        {
            --inBuf;
            return (char)buffer[(bufpos == bufsize - 1) ? (bufpos = 0) : ++bufpos];
        }

        char c = ReadChar();
        // System.err.println("READ: " + c);
        // UpdateLineColumn(c);         // CvdL: moved down

        if (++bufpos == available)
        {
            if (available == bufsize)
            {
                if (tokenBegin > 2048)
                {
                    bufpos = 0;
                    available = tokenBegin;
                }
                else if (tokenBegin < 0)
                    bufpos = 0;
                else
                    ExpandBuff(false);
            }
            else if (available > tokenBegin)
                available = bufsize;
            else if ((tokenBegin - available) < 2048)
                ExpandBuff(true);
            else
                available = tokenBegin;
        }

        UpdateLineColumn(c);            // CvdL: moved here
        return (buffer[bufpos] = c);
    }

    /**
     * @deprecated
     * @see #getEndColumn
     */
    public final int getColumn()
    {
        if (bufpos < 0) return 0;
        return bufcolumn[bufpos];
    }

    /**
     * @deprecated
     * @see #getEndLine
     */
    public final int getLine()
    {
        if (bufpos < 0) return 0;
        return bufline[bufpos];
    }

    public final int getEndColumn()
    {
        if (bufpos < 0) return 0;
        return bufcolumn[bufpos];
    }

    public final int getEndLine()
    {
        if (bufpos < 0) return 0;
        return bufline[bufpos];
    }

    public final int getBeginColumn()
    {
        if (tokenBegin < 0) return 0;
        return bufcolumn[tokenBegin];
    }

    public final int getBeginLine()
    {
        if (tokenBegin < 0) return 0;
        return bufline[tokenBegin];
    }

    public final void backup(int amount)
    {
        inBuf += amount;
        if ((bufpos -= amount) < 0)
            bufpos += bufsize;
    }

    public UCode_CharStream(java.io.Reader dstream,
      int startline, int startcolumn, int buffersize)
    {
        inputStream = dstream;
        line = startline;
        column = startcolumn - 1;
        b_eof = b_eof_hack = false;

        available = bufsize = buffersize;
        buffer = new char[buffersize];
        nextCharBuf = new char[buffersize];
        bufline = new int[buffersize];
        bufcolumn = new int[buffersize];
    }

    public UCode_CharStream(java.io.Reader dstream,
      int startline, int startcolumn)
    {
        this(dstream, startline, startcolumn, 4096);
    }

    public void ReInit(java.io.Reader dstream,
      int startline, int startcolumn, int buffersize)
    {
        inputStream = dstream;
        line = startline;
        column = startcolumn - 1;
        b_eof = b_eof_hack = false;

        if (buffer == null || buffersize != buffer.length)
        {
            available = bufsize = buffersize;
            buffer = new char[buffersize];
            nextCharBuf = new char[buffersize];
            bufline = new int[buffersize];
            bufcolumn = new int[buffersize];
        }
    }

    public void ReInit(java.io.Reader dstream,
      int startline, int startcolumn)
    {
        ReInit(dstream, startline, startcolumn, 4096);
    }

    public UCode_CharStream(java.io.InputStream dstream, int startline,
      int startcolumn, int buffersize)
    {
        this(new java.io.InputStreamReader(dstream), startline, startcolumn, 4096);
    }

    public UCode_CharStream(java.io.InputStream dstream, int startline,
      int startcolumn)
    {
        this(dstream, startline, startcolumn, 4096);
    }

    public void ReInit(java.io.InputStream dstream, int startline,
      int startcolumn, int buffersize)
    {
        ReInit(new java.io.InputStreamReader(dstream), startline, startcolumn, 4096);
    }

    public void ReInit(java.io.InputStream dstream, int startline,
      int startcolumn)
    {
        ReInit(dstream, startline, startcolumn, 4096);
    }

    public final String GetImage()
    {
        String result;

        // CvdL: Fix for missing last character.  If the token is only 1 char
        // long, this would return the entire buffer (wrap around calculation
        // in the else branch below).  With 2-char eol token nobody noticed.

        // System.err.println("eof=" + b_eof + " bufpos=" + bufpos + " tokenBegin=" + tokenBegin);

        if (b_eof && b_eof_hack /*bufpos > 0*/)
        {
            bufpos++;                     // undo the -- after EOF exception
        }

        if (bufpos >= tokenBegin)
        {
            result = new String(buffer, tokenBegin, bufpos - tokenBegin + 1);
        }
        else
        {
            // bufPos < tokenBegin -> rest of buffer (=\0) + beginning of buffer
            result = new String(buffer, tokenBegin, bufsize - tokenBegin) +
              new String(buffer, 0, bufpos + 1);
        }

        return result;
    }

    /* not called */
    public final char[] GetSuffix(int len)
    {
        char[] ret = new char[len];

        if ((bufpos + 1) >= len)
            System.arraycopy(buffer, bufpos - len + 1, ret, 0, len);
        else
        {
            System.arraycopy(buffer, bufsize - (len - bufpos - 1), ret, 0,
              len - bufpos - 1);
            System.arraycopy(buffer, 0, ret, len - bufpos - 1, bufpos + 1);
        }

        return ret;
    }

    public void Done()
    {
        nextCharBuf = null;
        buffer = null;
        bufline = null;
        bufcolumn = null;
    }

    /**
     * Method to adjust line and column numbers for the start of a token.<BR>
     *
     * Not used by standard parser.
     */
    public void adjustBeginLineColumn(int newLine, int newCol)
    {
        int start = tokenBegin;
        int len;

        if (bufpos >= tokenBegin)
        {
            len = bufpos - tokenBegin + inBuf + 1;
        }
        else
        {
            len = bufsize - tokenBegin + bufpos + 1 + inBuf;
        }

        int i = 0, j = 0, k = 0;
        int nextColDiff = 0, columnDiff = 0;

        while (i < len &&
          bufline[j = start % bufsize] == bufline[k = ++start % bufsize])
        {
            bufline[j] = newLine;
            nextColDiff = columnDiff + bufcolumn[k] - bufcolumn[j];
            bufcolumn[j] = newCol + columnDiff;
            columnDiff = nextColDiff;
            i++;
        }

        if (i < len)
        {
            bufline[j] = newLine++;
            bufcolumn[j] = newCol + columnDiff;

            while (i++ < len)
            {
                if (bufline[j = start % bufsize] != bufline[++start % bufsize])
                    bufline[j] = newLine++;
                else
                    bufline[j] = newLine;
            }
        }

        line = bufline[j];
        column = bufcolumn[j];
    }
}

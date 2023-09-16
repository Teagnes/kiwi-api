// Generated from /Users/nerv/IdeaProjects/kiwi-api/src/main/resources/SASLog.g4 by ANTLR 4.12.0
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class SASLogParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.12.0", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		PageBreakNumbered=1, PageBreak=2, SOURCE2=3, SOURCE=4, MPRINT=5, NOTE=6, 
		NOTENUMBERED=7, INFO=8, WARNING=9, WARNINGNUMBERED=10, ERROR=11, ERRORNUMBERED=12, 
		DATE=13, TIME=14, WEEKDAY=15, MONTH=16, ID=17, DIGIT=18, WS=19, TEXT=20, 
		EOL=21;
	public static final int
		RULE_saslog = 0, RULE_stmt = 1, RULE_note = 2, RULE_info = 3, RULE_warning = 4, 
		RULE_error = 5, RULE_source = 6, RULE_source2 = 7, RULE_mprint = 8, RULE_garbage = 9, 
		RULE_pageBreak = 10, RULE_emptyLine = 11;
	private static String[] makeRuleNames() {
		return new String[] {
			"saslog", "stmt", "note", "info", "warning", "error", "source", "source2", 
			"mprint", "garbage", "pageBreak", "emptyLine"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "PageBreakNumbered", "PageBreak", "SOURCE2", "SOURCE", "MPRINT", 
			"NOTE", "NOTENUMBERED", "INFO", "WARNING", "WARNINGNUMBERED", "ERROR", 
			"ERRORNUMBERED", "DATE", "TIME", "WEEKDAY", "MONTH", "ID", "DIGIT", "WS", 
			"TEXT", "EOL"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "SASLog.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public SASLogParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class SaslogContext extends ParserRuleContext {
		public List<StmtContext> stmt() {
			return getRuleContexts(StmtContext.class);
		}
		public StmtContext stmt(int i) {
			return getRuleContext(StmtContext.class,i);
		}
		public SaslogContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_saslog; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SASLogListener ) ((SASLogListener)listener).enterSaslog(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SASLogListener ) ((SASLogListener)listener).exitSaslog(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SASLogVisitor ) return ((SASLogVisitor<? extends T>)visitor).visitSaslog(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SaslogContext saslog() throws RecognitionException {
		SaslogContext _localctx = new SaslogContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_saslog);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(25); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(24);
					stmt();
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(27); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,0,_ctx);
			} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class StmtContext extends ParserRuleContext {
		public PageBreakContext pageBreak() {
			return getRuleContext(PageBreakContext.class,0);
		}
		public EmptyLineContext emptyLine() {
			return getRuleContext(EmptyLineContext.class,0);
		}
		public NoteContext note() {
			return getRuleContext(NoteContext.class,0);
		}
		public InfoContext info() {
			return getRuleContext(InfoContext.class,0);
		}
		public WarningContext warning() {
			return getRuleContext(WarningContext.class,0);
		}
		public ErrorContext error() {
			return getRuleContext(ErrorContext.class,0);
		}
		public SourceContext source() {
			return getRuleContext(SourceContext.class,0);
		}
		public Source2Context source2() {
			return getRuleContext(Source2Context.class,0);
		}
		public MprintContext mprint() {
			return getRuleContext(MprintContext.class,0);
		}
		public GarbageContext garbage() {
			return getRuleContext(GarbageContext.class,0);
		}
		public StmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SASLogListener ) ((SASLogListener)listener).enterStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SASLogListener ) ((SASLogListener)listener).exitStmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SASLogVisitor ) return ((SASLogVisitor<? extends T>)visitor).visitStmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StmtContext stmt() throws RecognitionException {
		StmtContext _localctx = new StmtContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_stmt);
		try {
			setState(39);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(29);
				pageBreak();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(30);
				emptyLine();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(31);
				note();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(32);
				info();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(33);
				warning();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(34);
				error();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(35);
				source();
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(36);
				source2();
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(37);
				mprint();
				}
				break;
			case 10:
				enterOuterAlt(_localctx, 10);
				{
				setState(38);
				garbage();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class NoteContext extends ParserRuleContext {
		public TerminalNode NOTE() { return getToken(SASLogParser.NOTE, 0); }
		public TerminalNode NOTENUMBERED() { return getToken(SASLogParser.NOTENUMBERED, 0); }
		public NoteContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_note; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SASLogListener ) ((SASLogListener)listener).enterNote(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SASLogListener ) ((SASLogListener)listener).exitNote(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SASLogVisitor ) return ((SASLogVisitor<? extends T>)visitor).visitNote(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NoteContext note() throws RecognitionException {
		NoteContext _localctx = new NoteContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_note);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(41);
			_la = _input.LA(1);
			if ( !(_la==NOTE || _la==NOTENUMBERED) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class InfoContext extends ParserRuleContext {
		public TerminalNode INFO() { return getToken(SASLogParser.INFO, 0); }
		public InfoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_info; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SASLogListener ) ((SASLogListener)listener).enterInfo(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SASLogListener ) ((SASLogListener)listener).exitInfo(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SASLogVisitor ) return ((SASLogVisitor<? extends T>)visitor).visitInfo(this);
			else return visitor.visitChildren(this);
		}
	}

	public final InfoContext info() throws RecognitionException {
		InfoContext _localctx = new InfoContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_info);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(43);
			match(INFO);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class WarningContext extends ParserRuleContext {
		public TerminalNode WARNING() { return getToken(SASLogParser.WARNING, 0); }
		public TerminalNode WARNINGNUMBERED() { return getToken(SASLogParser.WARNINGNUMBERED, 0); }
		public WarningContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_warning; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SASLogListener ) ((SASLogListener)listener).enterWarning(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SASLogListener ) ((SASLogListener)listener).exitWarning(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SASLogVisitor ) return ((SASLogVisitor<? extends T>)visitor).visitWarning(this);
			else return visitor.visitChildren(this);
		}
	}

	public final WarningContext warning() throws RecognitionException {
		WarningContext _localctx = new WarningContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_warning);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(45);
			_la = _input.LA(1);
			if ( !(_la==WARNING || _la==WARNINGNUMBERED) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ErrorContext extends ParserRuleContext {
		public TerminalNode ERROR() { return getToken(SASLogParser.ERROR, 0); }
		public TerminalNode ERRORNUMBERED() { return getToken(SASLogParser.ERRORNUMBERED, 0); }
		public ErrorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_error; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SASLogListener ) ((SASLogListener)listener).enterError(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SASLogListener ) ((SASLogListener)listener).exitError(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SASLogVisitor ) return ((SASLogVisitor<? extends T>)visitor).visitError(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ErrorContext error() throws RecognitionException {
		ErrorContext _localctx = new ErrorContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_error);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(47);
			_la = _input.LA(1);
			if ( !(_la==ERROR || _la==ERRORNUMBERED) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class SourceContext extends ParserRuleContext {
		public TerminalNode SOURCE() { return getToken(SASLogParser.SOURCE, 0); }
		public SourceContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_source; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SASLogListener ) ((SASLogListener)listener).enterSource(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SASLogListener ) ((SASLogListener)listener).exitSource(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SASLogVisitor ) return ((SASLogVisitor<? extends T>)visitor).visitSource(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SourceContext source() throws RecognitionException {
		SourceContext _localctx = new SourceContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_source);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(49);
			if (!( _input.LT(1).getCharPositionInLine() == 0 )) throw new FailedPredicateException(this, " _input.LT(1).getCharPositionInLine() == 0 ");
			setState(50);
			match(SOURCE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Source2Context extends ParserRuleContext {
		public TerminalNode SOURCE2() { return getToken(SASLogParser.SOURCE2, 0); }
		public Source2Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_source2; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SASLogListener ) ((SASLogListener)listener).enterSource2(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SASLogListener ) ((SASLogListener)listener).exitSource2(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SASLogVisitor ) return ((SASLogVisitor<? extends T>)visitor).visitSource2(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Source2Context source2() throws RecognitionException {
		Source2Context _localctx = new Source2Context(_ctx, getState());
		enterRule(_localctx, 14, RULE_source2);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(52);
			if (!( _input.LT(1).getCharPositionInLine() == 0 )) throw new FailedPredicateException(this, " _input.LT(1).getCharPositionInLine() == 0 ");
			setState(53);
			match(SOURCE2);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class MprintContext extends ParserRuleContext {
		public TerminalNode MPRINT() { return getToken(SASLogParser.MPRINT, 0); }
		public MprintContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_mprint; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SASLogListener ) ((SASLogListener)listener).enterMprint(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SASLogListener ) ((SASLogListener)listener).exitMprint(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SASLogVisitor ) return ((SASLogVisitor<? extends T>)visitor).visitMprint(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MprintContext mprint() throws RecognitionException {
		MprintContext _localctx = new MprintContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_mprint);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(55);
			if (!( _input.LT(1).getCharPositionInLine() == 0 )) throw new FailedPredicateException(this, " _input.LT(1).getCharPositionInLine() == 0 ");
			setState(56);
			match(MPRINT);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class GarbageContext extends ParserRuleContext {
		public TerminalNode TEXT() { return getToken(SASLogParser.TEXT, 0); }
		public TerminalNode EOL() { return getToken(SASLogParser.EOL, 0); }
		public GarbageContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_garbage; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SASLogListener ) ((SASLogListener)listener).enterGarbage(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SASLogListener ) ((SASLogListener)listener).exitGarbage(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SASLogVisitor ) return ((SASLogVisitor<? extends T>)visitor).visitGarbage(this);
			else return visitor.visitChildren(this);
		}
	}

	public final GarbageContext garbage() throws RecognitionException {
		GarbageContext _localctx = new GarbageContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_garbage);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(58);
			if (!( _input.LT(1).getCharPositionInLine() == 0 )) throw new FailedPredicateException(this, " _input.LT(1).getCharPositionInLine() == 0 ");
			setState(59);
			match(TEXT);
			setState(60);
			match(EOL);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class PageBreakContext extends ParserRuleContext {
		public TerminalNode PageBreakNumbered() { return getToken(SASLogParser.PageBreakNumbered, 0); }
		public TerminalNode PageBreak() { return getToken(SASLogParser.PageBreak, 0); }
		public EmptyLineContext emptyLine() {
			return getRuleContext(EmptyLineContext.class,0);
		}
		public PageBreakContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pageBreak; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SASLogListener ) ((SASLogListener)listener).enterPageBreak(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SASLogListener ) ((SASLogListener)listener).exitPageBreak(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SASLogVisitor ) return ((SASLogVisitor<? extends T>)visitor).visitPageBreak(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PageBreakContext pageBreak() throws RecognitionException {
		PageBreakContext _localctx = new PageBreakContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_pageBreak);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(62);
			_la = _input.LA(1);
			if ( !(_la==PageBreakNumbered || _la==PageBreak) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(64);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
			case 1:
				{
				setState(63);
				emptyLine();
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class EmptyLineContext extends ParserRuleContext {
		public TerminalNode EOL() { return getToken(SASLogParser.EOL, 0); }
		public EmptyLineContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_emptyLine; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SASLogListener ) ((SASLogListener)listener).enterEmptyLine(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SASLogListener ) ((SASLogListener)listener).exitEmptyLine(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SASLogVisitor ) return ((SASLogVisitor<? extends T>)visitor).visitEmptyLine(this);
			else return visitor.visitChildren(this);
		}
	}

	public final EmptyLineContext emptyLine() throws RecognitionException {
		EmptyLineContext _localctx = new EmptyLineContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_emptyLine);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(66);
			if (!( _input.LT(1).getCharPositionInLine() == 0 )) throw new FailedPredicateException(this, " _input.LT(1).getCharPositionInLine() == 0 ");
			setState(67);
			match(EOL);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 6:
			return source_sempred((SourceContext)_localctx, predIndex);
		case 7:
			return source2_sempred((Source2Context)_localctx, predIndex);
		case 8:
			return mprint_sempred((MprintContext)_localctx, predIndex);
		case 9:
			return garbage_sempred((GarbageContext)_localctx, predIndex);
		case 11:
			return emptyLine_sempred((EmptyLineContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean source_sempred(SourceContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return  _input.LT(1).getCharPositionInLine() == 0 ;
		}
		return true;
	}
	private boolean source2_sempred(Source2Context _localctx, int predIndex) {
		switch (predIndex) {
		case 1:
			return  _input.LT(1).getCharPositionInLine() == 0 ;
		}
		return true;
	}
	private boolean mprint_sempred(MprintContext _localctx, int predIndex) {
		switch (predIndex) {
		case 2:
			return  _input.LT(1).getCharPositionInLine() == 0 ;
		}
		return true;
	}
	private boolean garbage_sempred(GarbageContext _localctx, int predIndex) {
		switch (predIndex) {
		case 3:
			return  _input.LT(1).getCharPositionInLine() == 0 ;
		}
		return true;
	}
	private boolean emptyLine_sempred(EmptyLineContext _localctx, int predIndex) {
		switch (predIndex) {
		case 4:
			return  _input.LT(1).getCharPositionInLine() == 0 ;
		}
		return true;
	}

	public static final String _serializedATN =
		"\u0004\u0001\u0015F\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0001"+
		"\u0000\u0004\u0000\u001a\b\u0000\u000b\u0000\f\u0000\u001b\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0003\u0001(\b\u0001\u0001\u0002"+
		"\u0001\u0002\u0001\u0003\u0001\u0003\u0001\u0004\u0001\u0004\u0001\u0005"+
		"\u0001\u0005\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0007\u0001\u0007"+
		"\u0001\u0007\u0001\b\u0001\b\u0001\b\u0001\t\u0001\t\u0001\t\u0001\t\u0001"+
		"\n\u0001\n\u0003\nA\b\n\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b"+
		"\u0000\u0000\f\u0000\u0002\u0004\u0006\b\n\f\u000e\u0010\u0012\u0014\u0016"+
		"\u0000\u0004\u0001\u0000\u0006\u0007\u0001\u0000\t\n\u0001\u0000\u000b"+
		"\f\u0001\u0000\u0001\u0002D\u0000\u0019\u0001\u0000\u0000\u0000\u0002"+
		"\'\u0001\u0000\u0000\u0000\u0004)\u0001\u0000\u0000\u0000\u0006+\u0001"+
		"\u0000\u0000\u0000\b-\u0001\u0000\u0000\u0000\n/\u0001\u0000\u0000\u0000"+
		"\f1\u0001\u0000\u0000\u0000\u000e4\u0001\u0000\u0000\u0000\u00107\u0001"+
		"\u0000\u0000\u0000\u0012:\u0001\u0000\u0000\u0000\u0014>\u0001\u0000\u0000"+
		"\u0000\u0016B\u0001\u0000\u0000\u0000\u0018\u001a\u0003\u0002\u0001\u0000"+
		"\u0019\u0018\u0001\u0000\u0000\u0000\u001a\u001b\u0001\u0000\u0000\u0000"+
		"\u001b\u0019\u0001\u0000\u0000\u0000\u001b\u001c\u0001\u0000\u0000\u0000"+
		"\u001c\u0001\u0001\u0000\u0000\u0000\u001d(\u0003\u0014\n\u0000\u001e"+
		"(\u0003\u0016\u000b\u0000\u001f(\u0003\u0004\u0002\u0000 (\u0003\u0006"+
		"\u0003\u0000!(\u0003\b\u0004\u0000\"(\u0003\n\u0005\u0000#(\u0003\f\u0006"+
		"\u0000$(\u0003\u000e\u0007\u0000%(\u0003\u0010\b\u0000&(\u0003\u0012\t"+
		"\u0000\'\u001d\u0001\u0000\u0000\u0000\'\u001e\u0001\u0000\u0000\u0000"+
		"\'\u001f\u0001\u0000\u0000\u0000\' \u0001\u0000\u0000\u0000\'!\u0001\u0000"+
		"\u0000\u0000\'\"\u0001\u0000\u0000\u0000\'#\u0001\u0000\u0000\u0000\'"+
		"$\u0001\u0000\u0000\u0000\'%\u0001\u0000\u0000\u0000\'&\u0001\u0000\u0000"+
		"\u0000(\u0003\u0001\u0000\u0000\u0000)*\u0007\u0000\u0000\u0000*\u0005"+
		"\u0001\u0000\u0000\u0000+,\u0005\b\u0000\u0000,\u0007\u0001\u0000\u0000"+
		"\u0000-.\u0007\u0001\u0000\u0000.\t\u0001\u0000\u0000\u0000/0\u0007\u0002"+
		"\u0000\u00000\u000b\u0001\u0000\u0000\u000012\u0004\u0006\u0000\u0000"+
		"23\u0005\u0004\u0000\u00003\r\u0001\u0000\u0000\u000045\u0004\u0007\u0001"+
		"\u000056\u0005\u0003\u0000\u00006\u000f\u0001\u0000\u0000\u000078\u0004"+
		"\b\u0002\u000089\u0005\u0005\u0000\u00009\u0011\u0001\u0000\u0000\u0000"+
		":;\u0004\t\u0003\u0000;<\u0005\u0014\u0000\u0000<=\u0005\u0015\u0000\u0000"+
		"=\u0013\u0001\u0000\u0000\u0000>@\u0007\u0003\u0000\u0000?A\u0003\u0016"+
		"\u000b\u0000@?\u0001\u0000\u0000\u0000@A\u0001\u0000\u0000\u0000A\u0015"+
		"\u0001\u0000\u0000\u0000BC\u0004\u000b\u0004\u0000CD\u0005\u0015\u0000"+
		"\u0000D\u0017\u0001\u0000\u0000\u0000\u0003\u001b\'@";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}
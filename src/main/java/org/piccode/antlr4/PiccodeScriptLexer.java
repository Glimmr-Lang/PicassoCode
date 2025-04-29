// Generated from PiccodeScript.g4 by ANTLR 4.9.3

	package org.piccode.antlr4;

import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class PiccodeScriptLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.9.3", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		ADD=10, SUB=11, MUL=12, DIV=13, GT=14, GE=15, LT=16, LE=17, EQ=18, NE=19, 
		AND=20, OR=21, SHL=22, SHR=23, BAND=24, BOR=25, EXCLAIM=26, PIPE=27, ASSIGN=28, 
		LET=29, FUNCTION=30, WHEN=31, IMPORT=32, IS=33, IF=34, ELSE=35, MODULE=36, 
		NUMBER=37, STRING=38, DOT=39, LINE_COMMENT=40, BLOCK_COMMENT=41, ID=42, 
		WS=43;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "T__8", 
			"ADD", "SUB", "MUL", "DIV", "GT", "GE", "LT", "LE", "EQ", "NE", "AND", 
			"OR", "SHL", "SHR", "BAND", "BOR", "EXCLAIM", "PIPE", "ASSIGN", "LET", 
			"FUNCTION", "WHEN", "IMPORT", "IS", "IF", "ELSE", "MODULE", "NUMBER", 
			"STRING", "DOT", "LINE_COMMENT", "BLOCK_COMMENT", "ID", "WS"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "':'", "'{'", "'}'", "'('", "')'", "','", "'->'", "'['", "']'", 
			"'+'", "'-'", "'*'", "'/'", "'>'", "'>='", "'<'", "'<='", "'=='", "'!='", 
			"'&&'", "'||'", "'>>'", "'<<'", "'&'", "'|'", "'!'", "'|>'", "'='", "'let'", 
			"'function'", "'when'", "'import'", "'is'", "'if'", "'else'", "'module'", 
			null, null, "'.'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, "ADD", "SUB", 
			"MUL", "DIV", "GT", "GE", "LT", "LE", "EQ", "NE", "AND", "OR", "SHL", 
			"SHR", "BAND", "BOR", "EXCLAIM", "PIPE", "ASSIGN", "LET", "FUNCTION", 
			"WHEN", "IMPORT", "IS", "IF", "ELSE", "MODULE", "NUMBER", "STRING", "DOT", 
			"LINE_COMMENT", "BLOCK_COMMENT", "ID", "WS"
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


	public PiccodeScriptLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "PiccodeScript.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2-\u0112\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\3\2\3\2\3\3\3\3\3\4\3\4\3\5\3\5\3\6\3\6\3\7\3\7\3\b\3\b\3\b\3\t\3"+
		"\t\3\n\3\n\3\13\3\13\3\f\3\f\3\r\3\r\3\16\3\16\3\17\3\17\3\20\3\20\3\20"+
		"\3\21\3\21\3\22\3\22\3\22\3\23\3\23\3\23\3\24\3\24\3\24\3\25\3\25\3\25"+
		"\3\26\3\26\3\26\3\27\3\27\3\27\3\30\3\30\3\30\3\31\3\31\3\32\3\32\3\33"+
		"\3\33\3\34\3\34\3\34\3\35\3\35\3\36\3\36\3\36\3\36\3\37\3\37\3\37\3\37"+
		"\3\37\3\37\3\37\3\37\3\37\3 \3 \3 \3 \3 \3!\3!\3!\3!\3!\3!\3!\3\"\3\""+
		"\3\"\3#\3#\3#\3$\3$\3$\3$\3$\3%\3%\3%\3%\3%\3%\3%\3&\6&\u00c8\n&\r&\16"+
		"&\u00c9\3&\3&\6&\u00ce\n&\r&\16&\u00cf\5&\u00d2\n&\3\'\3\'\3\'\3\'\7\'"+
		"\u00d8\n\'\f\'\16\'\u00db\13\'\3\'\3\'\3\'\3\'\3\'\7\'\u00e2\n\'\f\'\16"+
		"\'\u00e5\13\'\3\'\5\'\u00e8\n\'\3(\3(\3)\3)\3)\3)\7)\u00f0\n)\f)\16)\u00f3"+
		"\13)\3)\3)\3*\3*\3*\3*\7*\u00fb\n*\f*\16*\u00fe\13*\3*\3*\3*\3*\3*\3+"+
		"\3+\7+\u0107\n+\f+\16+\u010a\13+\3,\6,\u010d\n,\r,\16,\u010e\3,\3,\3\u00fc"+
		"\2-\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35"+
		"\20\37\21!\22#\23%\24\'\25)\26+\27-\30/\31\61\32\63\33\65\34\67\359\36"+
		";\37= ?!A\"C#E$G%I&K\'M(O)Q*S+U,W-\3\2\t\3\2\62;\4\2$$^^\4\2))^^\4\2\f"+
		"\f\17\17\5\2C\\aac|\6\2\62;C\\aac|\5\2\13\f\17\17\"\"\2\u011d\2\3\3\2"+
		"\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17"+
		"\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2"+
		"\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3"+
		"\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3"+
		"\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\2"+
		"=\3\2\2\2\2?\3\2\2\2\2A\3\2\2\2\2C\3\2\2\2\2E\3\2\2\2\2G\3\2\2\2\2I\3"+
		"\2\2\2\2K\3\2\2\2\2M\3\2\2\2\2O\3\2\2\2\2Q\3\2\2\2\2S\3\2\2\2\2U\3\2\2"+
		"\2\2W\3\2\2\2\3Y\3\2\2\2\5[\3\2\2\2\7]\3\2\2\2\t_\3\2\2\2\13a\3\2\2\2"+
		"\rc\3\2\2\2\17e\3\2\2\2\21h\3\2\2\2\23j\3\2\2\2\25l\3\2\2\2\27n\3\2\2"+
		"\2\31p\3\2\2\2\33r\3\2\2\2\35t\3\2\2\2\37v\3\2\2\2!y\3\2\2\2#{\3\2\2\2"+
		"%~\3\2\2\2\'\u0081\3\2\2\2)\u0084\3\2\2\2+\u0087\3\2\2\2-\u008a\3\2\2"+
		"\2/\u008d\3\2\2\2\61\u0090\3\2\2\2\63\u0092\3\2\2\2\65\u0094\3\2\2\2\67"+
		"\u0096\3\2\2\29\u0099\3\2\2\2;\u009b\3\2\2\2=\u009f\3\2\2\2?\u00a8\3\2"+
		"\2\2A\u00ad\3\2\2\2C\u00b4\3\2\2\2E\u00b7\3\2\2\2G\u00ba\3\2\2\2I\u00bf"+
		"\3\2\2\2K\u00c7\3\2\2\2M\u00e7\3\2\2\2O\u00e9\3\2\2\2Q\u00eb\3\2\2\2S"+
		"\u00f6\3\2\2\2U\u0104\3\2\2\2W\u010c\3\2\2\2YZ\7<\2\2Z\4\3\2\2\2[\\\7"+
		"}\2\2\\\6\3\2\2\2]^\7\177\2\2^\b\3\2\2\2_`\7*\2\2`\n\3\2\2\2ab\7+\2\2"+
		"b\f\3\2\2\2cd\7.\2\2d\16\3\2\2\2ef\7/\2\2fg\7@\2\2g\20\3\2\2\2hi\7]\2"+
		"\2i\22\3\2\2\2jk\7_\2\2k\24\3\2\2\2lm\7-\2\2m\26\3\2\2\2no\7/\2\2o\30"+
		"\3\2\2\2pq\7,\2\2q\32\3\2\2\2rs\7\61\2\2s\34\3\2\2\2tu\7@\2\2u\36\3\2"+
		"\2\2vw\7@\2\2wx\7?\2\2x \3\2\2\2yz\7>\2\2z\"\3\2\2\2{|\7>\2\2|}\7?\2\2"+
		"}$\3\2\2\2~\177\7?\2\2\177\u0080\7?\2\2\u0080&\3\2\2\2\u0081\u0082\7#"+
		"\2\2\u0082\u0083\7?\2\2\u0083(\3\2\2\2\u0084\u0085\7(\2\2\u0085\u0086"+
		"\7(\2\2\u0086*\3\2\2\2\u0087\u0088\7~\2\2\u0088\u0089\7~\2\2\u0089,\3"+
		"\2\2\2\u008a\u008b\7@\2\2\u008b\u008c\7@\2\2\u008c.\3\2\2\2\u008d\u008e"+
		"\7>\2\2\u008e\u008f\7>\2\2\u008f\60\3\2\2\2\u0090\u0091\7(\2\2\u0091\62"+
		"\3\2\2\2\u0092\u0093\7~\2\2\u0093\64\3\2\2\2\u0094\u0095\7#\2\2\u0095"+
		"\66\3\2\2\2\u0096\u0097\7~\2\2\u0097\u0098\7@\2\2\u00988\3\2\2\2\u0099"+
		"\u009a\7?\2\2\u009a:\3\2\2\2\u009b\u009c\7n\2\2\u009c\u009d\7g\2\2\u009d"+
		"\u009e\7v\2\2\u009e<\3\2\2\2\u009f\u00a0\7h\2\2\u00a0\u00a1\7w\2\2\u00a1"+
		"\u00a2\7p\2\2\u00a2\u00a3\7e\2\2\u00a3\u00a4\7v\2\2\u00a4\u00a5\7k\2\2"+
		"\u00a5\u00a6\7q\2\2\u00a6\u00a7\7p\2\2\u00a7>\3\2\2\2\u00a8\u00a9\7y\2"+
		"\2\u00a9\u00aa\7j\2\2\u00aa\u00ab\7g\2\2\u00ab\u00ac\7p\2\2\u00ac@\3\2"+
		"\2\2\u00ad\u00ae\7k\2\2\u00ae\u00af\7o\2\2\u00af\u00b0\7r\2\2\u00b0\u00b1"+
		"\7q\2\2\u00b1\u00b2\7t\2\2\u00b2\u00b3\7v\2\2\u00b3B\3\2\2\2\u00b4\u00b5"+
		"\7k\2\2\u00b5\u00b6\7u\2\2\u00b6D\3\2\2\2\u00b7\u00b8\7k\2\2\u00b8\u00b9"+
		"\7h\2\2\u00b9F\3\2\2\2\u00ba\u00bb\7g\2\2\u00bb\u00bc\7n\2\2\u00bc\u00bd"+
		"\7u\2\2\u00bd\u00be\7g\2\2\u00beH\3\2\2\2\u00bf\u00c0\7o\2\2\u00c0\u00c1"+
		"\7q\2\2\u00c1\u00c2\7f\2\2\u00c2\u00c3\7w\2\2\u00c3\u00c4\7n\2\2\u00c4"+
		"\u00c5\7g\2\2\u00c5J\3\2\2\2\u00c6\u00c8\t\2\2\2\u00c7\u00c6\3\2\2\2\u00c8"+
		"\u00c9\3\2\2\2\u00c9\u00c7\3\2\2\2\u00c9\u00ca\3\2\2\2\u00ca\u00d1\3\2"+
		"\2\2\u00cb\u00cd\7\60\2\2\u00cc\u00ce\t\2\2\2\u00cd\u00cc\3\2\2\2\u00ce"+
		"\u00cf\3\2\2\2\u00cf\u00cd\3\2\2\2\u00cf\u00d0\3\2\2\2\u00d0\u00d2\3\2"+
		"\2\2\u00d1\u00cb\3\2\2\2\u00d1\u00d2\3\2\2\2\u00d2L\3\2\2\2\u00d3\u00d9"+
		"\7$\2\2\u00d4\u00d8\n\3\2\2\u00d5\u00d6\7^\2\2\u00d6\u00d8\13\2\2\2\u00d7"+
		"\u00d4\3\2\2\2\u00d7\u00d5\3\2\2\2\u00d8\u00db\3\2\2\2\u00d9\u00d7\3\2"+
		"\2\2\u00d9\u00da\3\2\2\2\u00da\u00dc\3\2\2\2\u00db\u00d9\3\2\2\2\u00dc"+
		"\u00e8\7$\2\2\u00dd\u00e3\7)\2\2\u00de\u00e2\n\4\2\2\u00df\u00e0\7^\2"+
		"\2\u00e0\u00e2\13\2\2\2\u00e1\u00de\3\2\2\2\u00e1\u00df\3\2\2\2\u00e2"+
		"\u00e5\3\2\2\2\u00e3\u00e1\3\2\2\2\u00e3\u00e4\3\2\2\2\u00e4\u00e6\3\2"+
		"\2\2\u00e5\u00e3\3\2\2\2\u00e6\u00e8\7)\2\2\u00e7\u00d3\3\2\2\2\u00e7"+
		"\u00dd\3\2\2\2\u00e8N\3\2\2\2\u00e9\u00ea\7\60\2\2\u00eaP\3\2\2\2\u00eb"+
		"\u00ec\7\61\2\2\u00ec\u00ed\7\61\2\2\u00ed\u00f1\3\2\2\2\u00ee\u00f0\n"+
		"\5\2\2\u00ef\u00ee\3\2\2\2\u00f0\u00f3\3\2\2\2\u00f1\u00ef\3\2\2\2\u00f1"+
		"\u00f2\3\2\2\2\u00f2\u00f4\3\2\2\2\u00f3\u00f1\3\2\2\2\u00f4\u00f5\b)"+
		"\2\2\u00f5R\3\2\2\2\u00f6\u00f7\7\61\2\2\u00f7\u00f8\7,\2\2\u00f8\u00fc"+
		"\3\2\2\2\u00f9\u00fb\13\2\2\2\u00fa\u00f9\3\2\2\2\u00fb\u00fe\3\2\2\2"+
		"\u00fc\u00fd\3\2\2\2\u00fc\u00fa\3\2\2\2\u00fd\u00ff\3\2\2\2\u00fe\u00fc"+
		"\3\2\2\2\u00ff\u0100\7,\2\2\u0100\u0101\7\61\2\2\u0101\u0102\3\2\2\2\u0102"+
		"\u0103\b*\2\2\u0103T\3\2\2\2\u0104\u0108\t\6\2\2\u0105\u0107\t\7\2\2\u0106"+
		"\u0105\3\2\2\2\u0107\u010a\3\2\2\2\u0108\u0106\3\2\2\2\u0108\u0109\3\2"+
		"\2\2\u0109V\3\2\2\2\u010a\u0108\3\2\2\2\u010b\u010d\t\b\2\2\u010c\u010b"+
		"\3\2\2\2\u010d\u010e\3\2\2\2\u010e\u010c\3\2\2\2\u010e\u010f\3\2\2\2\u010f"+
		"\u0110\3\2\2\2\u0110\u0111\b,\2\2\u0111X\3\2\2\2\17\2\u00c9\u00cf\u00d1"+
		"\u00d7\u00d9\u00e1\u00e3\u00e7\u00f1\u00fc\u0108\u010e\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}
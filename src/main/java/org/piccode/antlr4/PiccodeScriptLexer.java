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
		ADD=1, SUB=2, MUL=3, DIV=4, GT=5, GE=6, LT=7, LE=8, EQ=9, NE=10, AND=11, 
		OR=12, SHL=13, SHR=14, BAND=15, BOR=16, EXCLAIM=17, PIPE=18, LBRACE=19, 
		RBRACE=20, LPAREN=21, RPAREN=22, LBRACKET=23, RBRACKET=24, COLON=25, COMMA=26, 
		SEMI=27, ARROW=28, ASSIGN=29, LET=30, FUNCTION=31, WHEN=32, IMPORT=33, 
		IS=34, IF=35, ELSE=36, MODULE=37, NUMBER=38, STRING=39, DOT=40, LINE_COMMENT=41, 
		BLOCK_COMMENT=42, ID=43, WS=44;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"ADD", "SUB", "MUL", "DIV", "GT", "GE", "LT", "LE", "EQ", "NE", "AND", 
			"OR", "SHL", "SHR", "BAND", "BOR", "EXCLAIM", "PIPE", "LBRACE", "RBRACE", 
			"LPAREN", "RPAREN", "LBRACKET", "RBRACKET", "COLON", "COMMA", "SEMI", 
			"ARROW", "ASSIGN", "LET", "FUNCTION", "WHEN", "IMPORT", "IS", "IF", "ELSE", 
			"MODULE", "NUMBER", "STRING", "DOT", "LINE_COMMENT", "BLOCK_COMMENT", 
			"ID", "WS"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'+'", "'-'", "'*'", "'/'", "'>'", "'>='", "'<'", "'<='", "'=='", 
			"'!='", "'&&'", "'||'", "'>>'", "'<<'", "'&'", "'|'", "'!'", "'|>'", 
			"'{'", "'}'", "'('", "')'", "'['", "']'", "':'", "','", "';'", "'->'", 
			"'='", "'let'", "'function'", "'when'", "'import'", "'is'", "'if'", "'else'", 
			"'module'", null, null, "'.'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "ADD", "SUB", "MUL", "DIV", "GT", "GE", "LT", "LE", "EQ", "NE", 
			"AND", "OR", "SHL", "SHR", "BAND", "BOR", "EXCLAIM", "PIPE", "LBRACE", 
			"RBRACE", "LPAREN", "RPAREN", "LBRACKET", "RBRACKET", "COLON", "COMMA", 
			"SEMI", "ARROW", "ASSIGN", "LET", "FUNCTION", "WHEN", "IMPORT", "IS", 
			"IF", "ELSE", "MODULE", "NUMBER", "STRING", "DOT", "LINE_COMMENT", "BLOCK_COMMENT", 
			"ID", "WS"
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2.\u0116\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\3\2\3\2\3\3\3\3\3\4\3\4\3\5\3\5\3\6\3\6\3\7\3\7\3\7\3\b\3\b"+
		"\3\t\3\t\3\t\3\n\3\n\3\n\3\13\3\13\3\13\3\f\3\f\3\f\3\r\3\r\3\r\3\16\3"+
		"\16\3\16\3\17\3\17\3\17\3\20\3\20\3\21\3\21\3\22\3\22\3\23\3\23\3\23\3"+
		"\24\3\24\3\25\3\25\3\26\3\26\3\27\3\27\3\30\3\30\3\31\3\31\3\32\3\32\3"+
		"\33\3\33\3\34\3\34\3\35\3\35\3\35\3\36\3\36\3\37\3\37\3\37\3\37\3 \3 "+
		"\3 \3 \3 \3 \3 \3 \3 \3!\3!\3!\3!\3!\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3#\3"+
		"#\3#\3$\3$\3$\3%\3%\3%\3%\3%\3&\3&\3&\3&\3&\3&\3&\3\'\6\'\u00cc\n\'\r"+
		"\'\16\'\u00cd\3\'\3\'\6\'\u00d2\n\'\r\'\16\'\u00d3\5\'\u00d6\n\'\3(\3"+
		"(\3(\3(\7(\u00dc\n(\f(\16(\u00df\13(\3(\3(\3(\3(\3(\7(\u00e6\n(\f(\16"+
		"(\u00e9\13(\3(\5(\u00ec\n(\3)\3)\3*\3*\3*\3*\7*\u00f4\n*\f*\16*\u00f7"+
		"\13*\3*\3*\3+\3+\3+\3+\7+\u00ff\n+\f+\16+\u0102\13+\3+\3+\3+\3+\3+\3,"+
		"\3,\7,\u010b\n,\f,\16,\u010e\13,\3-\6-\u0111\n-\r-\16-\u0112\3-\3-\3\u0100"+
		"\2.\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35"+
		"\20\37\21!\22#\23%\24\'\25)\26+\27-\30/\31\61\32\63\33\65\34\67\359\36"+
		";\37= ?!A\"C#E$G%I&K\'M(O)Q*S+U,W-Y.\3\2\t\3\2\62;\4\2$$^^\4\2))^^\4\2"+
		"\f\f\17\17\5\2C\\aac|\6\2\62;C\\aac|\5\2\13\f\17\17\"\"\2\u0121\2\3\3"+
		"\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2"+
		"\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3"+
		"\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2"+
		"%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61"+
		"\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2\2\2"+
		"\2=\3\2\2\2\2?\3\2\2\2\2A\3\2\2\2\2C\3\2\2\2\2E\3\2\2\2\2G\3\2\2\2\2I"+
		"\3\2\2\2\2K\3\2\2\2\2M\3\2\2\2\2O\3\2\2\2\2Q\3\2\2\2\2S\3\2\2\2\2U\3\2"+
		"\2\2\2W\3\2\2\2\2Y\3\2\2\2\3[\3\2\2\2\5]\3\2\2\2\7_\3\2\2\2\ta\3\2\2\2"+
		"\13c\3\2\2\2\re\3\2\2\2\17h\3\2\2\2\21j\3\2\2\2\23m\3\2\2\2\25p\3\2\2"+
		"\2\27s\3\2\2\2\31v\3\2\2\2\33y\3\2\2\2\35|\3\2\2\2\37\177\3\2\2\2!\u0081"+
		"\3\2\2\2#\u0083\3\2\2\2%\u0085\3\2\2\2\'\u0088\3\2\2\2)\u008a\3\2\2\2"+
		"+\u008c\3\2\2\2-\u008e\3\2\2\2/\u0090\3\2\2\2\61\u0092\3\2\2\2\63\u0094"+
		"\3\2\2\2\65\u0096\3\2\2\2\67\u0098\3\2\2\29\u009a\3\2\2\2;\u009d\3\2\2"+
		"\2=\u009f\3\2\2\2?\u00a3\3\2\2\2A\u00ac\3\2\2\2C\u00b1\3\2\2\2E\u00b8"+
		"\3\2\2\2G\u00bb\3\2\2\2I\u00be\3\2\2\2K\u00c3\3\2\2\2M\u00cb\3\2\2\2O"+
		"\u00eb\3\2\2\2Q\u00ed\3\2\2\2S\u00ef\3\2\2\2U\u00fa\3\2\2\2W\u0108\3\2"+
		"\2\2Y\u0110\3\2\2\2[\\\7-\2\2\\\4\3\2\2\2]^\7/\2\2^\6\3\2\2\2_`\7,\2\2"+
		"`\b\3\2\2\2ab\7\61\2\2b\n\3\2\2\2cd\7@\2\2d\f\3\2\2\2ef\7@\2\2fg\7?\2"+
		"\2g\16\3\2\2\2hi\7>\2\2i\20\3\2\2\2jk\7>\2\2kl\7?\2\2l\22\3\2\2\2mn\7"+
		"?\2\2no\7?\2\2o\24\3\2\2\2pq\7#\2\2qr\7?\2\2r\26\3\2\2\2st\7(\2\2tu\7"+
		"(\2\2u\30\3\2\2\2vw\7~\2\2wx\7~\2\2x\32\3\2\2\2yz\7@\2\2z{\7@\2\2{\34"+
		"\3\2\2\2|}\7>\2\2}~\7>\2\2~\36\3\2\2\2\177\u0080\7(\2\2\u0080 \3\2\2\2"+
		"\u0081\u0082\7~\2\2\u0082\"\3\2\2\2\u0083\u0084\7#\2\2\u0084$\3\2\2\2"+
		"\u0085\u0086\7~\2\2\u0086\u0087\7@\2\2\u0087&\3\2\2\2\u0088\u0089\7}\2"+
		"\2\u0089(\3\2\2\2\u008a\u008b\7\177\2\2\u008b*\3\2\2\2\u008c\u008d\7*"+
		"\2\2\u008d,\3\2\2\2\u008e\u008f\7+\2\2\u008f.\3\2\2\2\u0090\u0091\7]\2"+
		"\2\u0091\60\3\2\2\2\u0092\u0093\7_\2\2\u0093\62\3\2\2\2\u0094\u0095\7"+
		"<\2\2\u0095\64\3\2\2\2\u0096\u0097\7.\2\2\u0097\66\3\2\2\2\u0098\u0099"+
		"\7=\2\2\u00998\3\2\2\2\u009a\u009b\7/\2\2\u009b\u009c\7@\2\2\u009c:\3"+
		"\2\2\2\u009d\u009e\7?\2\2\u009e<\3\2\2\2\u009f\u00a0\7n\2\2\u00a0\u00a1"+
		"\7g\2\2\u00a1\u00a2\7v\2\2\u00a2>\3\2\2\2\u00a3\u00a4\7h\2\2\u00a4\u00a5"+
		"\7w\2\2\u00a5\u00a6\7p\2\2\u00a6\u00a7\7e\2\2\u00a7\u00a8\7v\2\2\u00a8"+
		"\u00a9\7k\2\2\u00a9\u00aa\7q\2\2\u00aa\u00ab\7p\2\2\u00ab@\3\2\2\2\u00ac"+
		"\u00ad\7y\2\2\u00ad\u00ae\7j\2\2\u00ae\u00af\7g\2\2\u00af\u00b0\7p\2\2"+
		"\u00b0B\3\2\2\2\u00b1\u00b2\7k\2\2\u00b2\u00b3\7o\2\2\u00b3\u00b4\7r\2"+
		"\2\u00b4\u00b5\7q\2\2\u00b5\u00b6\7t\2\2\u00b6\u00b7\7v\2\2\u00b7D\3\2"+
		"\2\2\u00b8\u00b9\7k\2\2\u00b9\u00ba\7u\2\2\u00baF\3\2\2\2\u00bb\u00bc"+
		"\7k\2\2\u00bc\u00bd\7h\2\2\u00bdH\3\2\2\2\u00be\u00bf\7g\2\2\u00bf\u00c0"+
		"\7n\2\2\u00c0\u00c1\7u\2\2\u00c1\u00c2\7g\2\2\u00c2J\3\2\2\2\u00c3\u00c4"+
		"\7o\2\2\u00c4\u00c5\7q\2\2\u00c5\u00c6\7f\2\2\u00c6\u00c7\7w\2\2\u00c7"+
		"\u00c8\7n\2\2\u00c8\u00c9\7g\2\2\u00c9L\3\2\2\2\u00ca\u00cc\t\2\2\2\u00cb"+
		"\u00ca\3\2\2\2\u00cc\u00cd\3\2\2\2\u00cd\u00cb\3\2\2\2\u00cd\u00ce\3\2"+
		"\2\2\u00ce\u00d5\3\2\2\2\u00cf\u00d1\7\60\2\2\u00d0\u00d2\t\2\2\2\u00d1"+
		"\u00d0\3\2\2\2\u00d2\u00d3\3\2\2\2\u00d3\u00d1\3\2\2\2\u00d3\u00d4\3\2"+
		"\2\2\u00d4\u00d6\3\2\2\2\u00d5\u00cf\3\2\2\2\u00d5\u00d6\3\2\2\2\u00d6"+
		"N\3\2\2\2\u00d7\u00dd\7$\2\2\u00d8\u00dc\n\3\2\2\u00d9\u00da\7^\2\2\u00da"+
		"\u00dc\13\2\2\2\u00db\u00d8\3\2\2\2\u00db\u00d9\3\2\2\2\u00dc\u00df\3"+
		"\2\2\2\u00dd\u00db\3\2\2\2\u00dd\u00de\3\2\2\2\u00de\u00e0\3\2\2\2\u00df"+
		"\u00dd\3\2\2\2\u00e0\u00ec\7$\2\2\u00e1\u00e7\7)\2\2\u00e2\u00e6\n\4\2"+
		"\2\u00e3\u00e4\7^\2\2\u00e4\u00e6\13\2\2\2\u00e5\u00e2\3\2\2\2\u00e5\u00e3"+
		"\3\2\2\2\u00e6\u00e9\3\2\2\2\u00e7\u00e5\3\2\2\2\u00e7\u00e8\3\2\2\2\u00e8"+
		"\u00ea\3\2\2\2\u00e9\u00e7\3\2\2\2\u00ea\u00ec\7)\2\2\u00eb\u00d7\3\2"+
		"\2\2\u00eb\u00e1\3\2\2\2\u00ecP\3\2\2\2\u00ed\u00ee\7\60\2\2\u00eeR\3"+
		"\2\2\2\u00ef\u00f0\7\61\2\2\u00f0\u00f1\7\61\2\2\u00f1\u00f5\3\2\2\2\u00f2"+
		"\u00f4\n\5\2\2\u00f3\u00f2\3\2\2\2\u00f4\u00f7\3\2\2\2\u00f5\u00f3\3\2"+
		"\2\2\u00f5\u00f6\3\2\2\2\u00f6\u00f8\3\2\2\2\u00f7\u00f5\3\2\2\2\u00f8"+
		"\u00f9\b*\2\2\u00f9T\3\2\2\2\u00fa\u00fb\7\61\2\2\u00fb\u00fc\7,\2\2\u00fc"+
		"\u0100\3\2\2\2\u00fd\u00ff\13\2\2\2\u00fe\u00fd\3\2\2\2\u00ff\u0102\3"+
		"\2\2\2\u0100\u0101\3\2\2\2\u0100\u00fe\3\2\2\2\u0101\u0103\3\2\2\2\u0102"+
		"\u0100\3\2\2\2\u0103\u0104\7,\2\2\u0104\u0105\7\61\2\2\u0105\u0106\3\2"+
		"\2\2\u0106\u0107\b+\2\2\u0107V\3\2\2\2\u0108\u010c\t\6\2\2\u0109\u010b"+
		"\t\7\2\2\u010a\u0109\3\2\2\2\u010b\u010e\3\2\2\2\u010c\u010a\3\2\2\2\u010c"+
		"\u010d\3\2\2\2\u010dX\3\2\2\2\u010e\u010c\3\2\2\2\u010f\u0111\t\b\2\2"+
		"\u0110\u010f\3\2\2\2\u0111\u0112\3\2\2\2\u0112\u0110\3\2\2\2\u0112\u0113"+
		"\3\2\2\2\u0113\u0114\3\2\2\2\u0114\u0115\b-\3\2\u0115Z\3\2\2\2\17\2\u00cd"+
		"\u00d3\u00d5\u00db\u00dd\u00e5\u00e7\u00eb\u00f5\u0100\u010c\u0112\4\b"+
		"\2\2\2\3\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}
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
		SEMI=27, ARROW=28, TILDE=29, ASSIGN=30, LET=31, FUNCTION=32, WHEN=33, 
		IMPORT=34, IS=35, IF=36, ELSE=37, MODULE=38, DO=39, NUMBER=40, STRING=41, 
		DOT=42, LINE_COMMENT=43, BLOCK_COMMENT=44, ID=45, WS=46;
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
			"ARROW", "TILDE", "ASSIGN", "LET", "FUNCTION", "WHEN", "IMPORT", "IS", 
			"IF", "ELSE", "MODULE", "DO", "NUMBER", "STRING", "DOT", "LINE_COMMENT", 
			"BLOCK_COMMENT", "ID", "WS"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'+'", "'-'", "'*'", "'/'", "'>'", "'>='", "'<'", "'<='", "'=='", 
			"'!='", "'&&'", "'||'", "'>>'", "'<<'", "'&'", "'|'", "'!'", "'|>'", 
			"'{'", "'}'", "'('", "')'", "'['", "']'", "':'", "','", "';'", "'->'", 
			"'~'", "'='", "'let'", "'function'", "'when'", "'import'", "'is'", "'if'", 
			"'else'", "'module'", "'do'", null, null, "'.'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "ADD", "SUB", "MUL", "DIV", "GT", "GE", "LT", "LE", "EQ", "NE", 
			"AND", "OR", "SHL", "SHR", "BAND", "BOR", "EXCLAIM", "PIPE", "LBRACE", 
			"RBRACE", "LPAREN", "RPAREN", "LBRACKET", "RBRACKET", "COLON", "COMMA", 
			"SEMI", "ARROW", "TILDE", "ASSIGN", "LET", "FUNCTION", "WHEN", "IMPORT", 
			"IS", "IF", "ELSE", "MODULE", "DO", "NUMBER", "STRING", "DOT", "LINE_COMMENT", 
			"BLOCK_COMMENT", "ID", "WS"
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\60\u011f\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31"+
		"\t\31\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t"+
		" \4!\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t"+
		"+\4,\t,\4-\t-\4.\t.\4/\t/\3\2\3\2\3\3\3\3\3\4\3\4\3\5\3\5\3\6\3\6\3\7"+
		"\3\7\3\7\3\b\3\b\3\t\3\t\3\t\3\n\3\n\3\n\3\13\3\13\3\13\3\f\3\f\3\f\3"+
		"\r\3\r\3\r\3\16\3\16\3\16\3\17\3\17\3\17\3\20\3\20\3\21\3\21\3\22\3\22"+
		"\3\23\3\23\3\23\3\24\3\24\3\25\3\25\3\26\3\26\3\27\3\27\3\30\3\30\3\31"+
		"\3\31\3\32\3\32\3\33\3\33\3\34\3\34\3\35\3\35\3\35\3\36\3\36\3\37\3\37"+
		"\3 \3 \3 \3 \3!\3!\3!\3!\3!\3!\3!\3!\3!\3\"\3\"\3\"\3\"\3\"\3#\3#\3#\3"+
		"#\3#\3#\3#\3$\3$\3$\3%\3%\3%\3&\3&\3&\3&\3&\3\'\3\'\3\'\3\'\3\'\3\'\3"+
		"\'\3(\3(\3(\3)\6)\u00d5\n)\r)\16)\u00d6\3)\3)\6)\u00db\n)\r)\16)\u00dc"+
		"\5)\u00df\n)\3*\3*\3*\3*\7*\u00e5\n*\f*\16*\u00e8\13*\3*\3*\3*\3*\3*\7"+
		"*\u00ef\n*\f*\16*\u00f2\13*\3*\5*\u00f5\n*\3+\3+\3,\3,\3,\3,\7,\u00fd"+
		"\n,\f,\16,\u0100\13,\3,\3,\3-\3-\3-\3-\7-\u0108\n-\f-\16-\u010b\13-\3"+
		"-\3-\3-\3-\3-\3.\3.\7.\u0114\n.\f.\16.\u0117\13.\3/\6/\u011a\n/\r/\16"+
		"/\u011b\3/\3/\3\u0109\2\60\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25"+
		"\f\27\r\31\16\33\17\35\20\37\21!\22#\23%\24\'\25)\26+\27-\30/\31\61\32"+
		"\63\33\65\34\67\359\36;\37= ?!A\"C#E$G%I&K\'M(O)Q*S+U,W-Y.[/]\60\3\2\t"+
		"\3\2\62;\4\2$$^^\4\2))^^\4\2\f\f\17\17\5\2C\\aac|\6\2\62;C\\aac|\5\2\13"+
		"\f\17\17\"\"\2\u012a\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2"+
		"\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3"+
		"\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2"+
		"\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2"+
		"\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2"+
		"\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2\2\2\2A\3\2\2\2\2C\3\2\2\2"+
		"\2E\3\2\2\2\2G\3\2\2\2\2I\3\2\2\2\2K\3\2\2\2\2M\3\2\2\2\2O\3\2\2\2\2Q"+
		"\3\2\2\2\2S\3\2\2\2\2U\3\2\2\2\2W\3\2\2\2\2Y\3\2\2\2\2[\3\2\2\2\2]\3\2"+
		"\2\2\3_\3\2\2\2\5a\3\2\2\2\7c\3\2\2\2\te\3\2\2\2\13g\3\2\2\2\ri\3\2\2"+
		"\2\17l\3\2\2\2\21n\3\2\2\2\23q\3\2\2\2\25t\3\2\2\2\27w\3\2\2\2\31z\3\2"+
		"\2\2\33}\3\2\2\2\35\u0080\3\2\2\2\37\u0083\3\2\2\2!\u0085\3\2\2\2#\u0087"+
		"\3\2\2\2%\u0089\3\2\2\2\'\u008c\3\2\2\2)\u008e\3\2\2\2+\u0090\3\2\2\2"+
		"-\u0092\3\2\2\2/\u0094\3\2\2\2\61\u0096\3\2\2\2\63\u0098\3\2\2\2\65\u009a"+
		"\3\2\2\2\67\u009c\3\2\2\29\u009e\3\2\2\2;\u00a1\3\2\2\2=\u00a3\3\2\2\2"+
		"?\u00a5\3\2\2\2A\u00a9\3\2\2\2C\u00b2\3\2\2\2E\u00b7\3\2\2\2G\u00be\3"+
		"\2\2\2I\u00c1\3\2\2\2K\u00c4\3\2\2\2M\u00c9\3\2\2\2O\u00d0\3\2\2\2Q\u00d4"+
		"\3\2\2\2S\u00f4\3\2\2\2U\u00f6\3\2\2\2W\u00f8\3\2\2\2Y\u0103\3\2\2\2["+
		"\u0111\3\2\2\2]\u0119\3\2\2\2_`\7-\2\2`\4\3\2\2\2ab\7/\2\2b\6\3\2\2\2"+
		"cd\7,\2\2d\b\3\2\2\2ef\7\61\2\2f\n\3\2\2\2gh\7@\2\2h\f\3\2\2\2ij\7@\2"+
		"\2jk\7?\2\2k\16\3\2\2\2lm\7>\2\2m\20\3\2\2\2no\7>\2\2op\7?\2\2p\22\3\2"+
		"\2\2qr\7?\2\2rs\7?\2\2s\24\3\2\2\2tu\7#\2\2uv\7?\2\2v\26\3\2\2\2wx\7("+
		"\2\2xy\7(\2\2y\30\3\2\2\2z{\7~\2\2{|\7~\2\2|\32\3\2\2\2}~\7@\2\2~\177"+
		"\7@\2\2\177\34\3\2\2\2\u0080\u0081\7>\2\2\u0081\u0082\7>\2\2\u0082\36"+
		"\3\2\2\2\u0083\u0084\7(\2\2\u0084 \3\2\2\2\u0085\u0086\7~\2\2\u0086\""+
		"\3\2\2\2\u0087\u0088\7#\2\2\u0088$\3\2\2\2\u0089\u008a\7~\2\2\u008a\u008b"+
		"\7@\2\2\u008b&\3\2\2\2\u008c\u008d\7}\2\2\u008d(\3\2\2\2\u008e\u008f\7"+
		"\177\2\2\u008f*\3\2\2\2\u0090\u0091\7*\2\2\u0091,\3\2\2\2\u0092\u0093"+
		"\7+\2\2\u0093.\3\2\2\2\u0094\u0095\7]\2\2\u0095\60\3\2\2\2\u0096\u0097"+
		"\7_\2\2\u0097\62\3\2\2\2\u0098\u0099\7<\2\2\u0099\64\3\2\2\2\u009a\u009b"+
		"\7.\2\2\u009b\66\3\2\2\2\u009c\u009d\7=\2\2\u009d8\3\2\2\2\u009e\u009f"+
		"\7/\2\2\u009f\u00a0\7@\2\2\u00a0:\3\2\2\2\u00a1\u00a2\7\u0080\2\2\u00a2"+
		"<\3\2\2\2\u00a3\u00a4\7?\2\2\u00a4>\3\2\2\2\u00a5\u00a6\7n\2\2\u00a6\u00a7"+
		"\7g\2\2\u00a7\u00a8\7v\2\2\u00a8@\3\2\2\2\u00a9\u00aa\7h\2\2\u00aa\u00ab"+
		"\7w\2\2\u00ab\u00ac\7p\2\2\u00ac\u00ad\7e\2\2\u00ad\u00ae\7v\2\2\u00ae"+
		"\u00af\7k\2\2\u00af\u00b0\7q\2\2\u00b0\u00b1\7p\2\2\u00b1B\3\2\2\2\u00b2"+
		"\u00b3\7y\2\2\u00b3\u00b4\7j\2\2\u00b4\u00b5\7g\2\2\u00b5\u00b6\7p\2\2"+
		"\u00b6D\3\2\2\2\u00b7\u00b8\7k\2\2\u00b8\u00b9\7o\2\2\u00b9\u00ba\7r\2"+
		"\2\u00ba\u00bb\7q\2\2\u00bb\u00bc\7t\2\2\u00bc\u00bd\7v\2\2\u00bdF\3\2"+
		"\2\2\u00be\u00bf\7k\2\2\u00bf\u00c0\7u\2\2\u00c0H\3\2\2\2\u00c1\u00c2"+
		"\7k\2\2\u00c2\u00c3\7h\2\2\u00c3J\3\2\2\2\u00c4\u00c5\7g\2\2\u00c5\u00c6"+
		"\7n\2\2\u00c6\u00c7\7u\2\2\u00c7\u00c8\7g\2\2\u00c8L\3\2\2\2\u00c9\u00ca"+
		"\7o\2\2\u00ca\u00cb\7q\2\2\u00cb\u00cc\7f\2\2\u00cc\u00cd\7w\2\2\u00cd"+
		"\u00ce\7n\2\2\u00ce\u00cf\7g\2\2\u00cfN\3\2\2\2\u00d0\u00d1\7f\2\2\u00d1"+
		"\u00d2\7q\2\2\u00d2P\3\2\2\2\u00d3\u00d5\t\2\2\2\u00d4\u00d3\3\2\2\2\u00d5"+
		"\u00d6\3\2\2\2\u00d6\u00d4\3\2\2\2\u00d6\u00d7\3\2\2\2\u00d7\u00de\3\2"+
		"\2\2\u00d8\u00da\7\60\2\2\u00d9\u00db\t\2\2\2\u00da\u00d9\3\2\2\2\u00db"+
		"\u00dc\3\2\2\2\u00dc\u00da\3\2\2\2\u00dc\u00dd\3\2\2\2\u00dd\u00df\3\2"+
		"\2\2\u00de\u00d8\3\2\2\2\u00de\u00df\3\2\2\2\u00dfR\3\2\2\2\u00e0\u00e6"+
		"\7$\2\2\u00e1\u00e5\n\3\2\2\u00e2\u00e3\7^\2\2\u00e3\u00e5\13\2\2\2\u00e4"+
		"\u00e1\3\2\2\2\u00e4\u00e2\3\2\2\2\u00e5\u00e8\3\2\2\2\u00e6\u00e4\3\2"+
		"\2\2\u00e6\u00e7\3\2\2\2\u00e7\u00e9\3\2\2\2\u00e8\u00e6\3\2\2\2\u00e9"+
		"\u00f5\7$\2\2\u00ea\u00f0\7)\2\2\u00eb\u00ef\n\4\2\2\u00ec\u00ed\7^\2"+
		"\2\u00ed\u00ef\13\2\2\2\u00ee\u00eb\3\2\2\2\u00ee\u00ec\3\2\2\2\u00ef"+
		"\u00f2\3\2\2\2\u00f0\u00ee\3\2\2\2\u00f0\u00f1\3\2\2\2\u00f1\u00f3\3\2"+
		"\2\2\u00f2\u00f0\3\2\2\2\u00f3\u00f5\7)\2\2\u00f4\u00e0\3\2\2\2\u00f4"+
		"\u00ea\3\2\2\2\u00f5T\3\2\2\2\u00f6\u00f7\7\60\2\2\u00f7V\3\2\2\2\u00f8"+
		"\u00f9\7\61\2\2\u00f9\u00fa\7\61\2\2\u00fa\u00fe\3\2\2\2\u00fb\u00fd\n"+
		"\5\2\2\u00fc\u00fb\3\2\2\2\u00fd\u0100\3\2\2\2\u00fe\u00fc\3\2\2\2\u00fe"+
		"\u00ff\3\2\2\2\u00ff\u0101\3\2\2\2\u0100\u00fe\3\2\2\2\u0101\u0102\b,"+
		"\2\2\u0102X\3\2\2\2\u0103\u0104\7\61\2\2\u0104\u0105\7,\2\2\u0105\u0109"+
		"\3\2\2\2\u0106\u0108\13\2\2\2\u0107\u0106\3\2\2\2\u0108\u010b\3\2\2\2"+
		"\u0109\u010a\3\2\2\2\u0109\u0107\3\2\2\2\u010a\u010c\3\2\2\2\u010b\u0109"+
		"\3\2\2\2\u010c\u010d\7,\2\2\u010d\u010e\7\61\2\2\u010e\u010f\3\2\2\2\u010f"+
		"\u0110\b-\2\2\u0110Z\3\2\2\2\u0111\u0115\t\6\2\2\u0112\u0114\t\7\2\2\u0113"+
		"\u0112\3\2\2\2\u0114\u0117\3\2\2\2\u0115\u0113\3\2\2\2\u0115\u0116\3\2"+
		"\2\2\u0116\\\3\2\2\2\u0117\u0115\3\2\2\2\u0118\u011a\t\b\2\2\u0119\u0118"+
		"\3\2\2\2\u011a\u011b\3\2\2\2\u011b\u0119\3\2\2\2\u011b\u011c\3\2\2\2\u011c"+
		"\u011d\3\2\2\2\u011d\u011e\b/\2\2\u011e^\3\2\2\2\17\2\u00d6\u00dc\u00de"+
		"\u00e4\u00e6\u00ee\u00f0\u00f4\u00fe\u0109\u0115\u011b\3\2\3\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}
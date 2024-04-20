// Generated from SQL.g4 by ANTLR 4.13.1
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class SQLParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.13.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		SCOL=1, DOT=2, OPEN_PAR=3, CLOSE_PAR=4, COMMA=5, ASSIGN=6, STAR=7, PLUS=8, 
		MINUS=9, TILDE=10, PIPE2=11, DIV=12, MOD=13, LT2=14, GT2=15, AMP=16, PIPE=17, 
		LT=18, LT_EQ=19, GT=20, GT_EQ=21, EQ=22, NOT_EQ1=23, NOT_EQ2=24, K_ABORT=25, 
		K_ACTION=26, K_ADD=27, K_AFTER=28, K_ALL=29, K_ALTER=30, K_ANALYZE=31, 
		K_AND=32, K_AS=33, K_ASC=34, K_ATTACH=35, K_AUTOINCREMENT=36, K_BEFORE=37, 
		K_BEGIN=38, K_BETWEEN=39, K_BY=40, K_CASCADE=41, K_CASE=42, K_CAST=43, 
		K_CHECK=44, K_COLLATE=45, K_COLUMN=46, K_COMMIT=47, K_CONFLICT=48, K_CONSTRAINT=49, 
		K_CREATE=50, K_CROSS=51, K_CURRENT_DATE=52, K_CURRENT_TIME=53, K_CURRENT_TIMESTAMP=54, 
		K_DATABASE=55, K_DEFAULT=56, K_DEFERRABLE=57, K_DEFERRED=58, K_DELETE=59, 
		K_DESC=60, K_DETACH=61, K_DISTINCT=62, K_DROP=63, K_EACH=64, K_ELSE=65, 
		K_END=66, K_ESCAPE=67, K_EXCEPT=68, K_EXCLUSIVE=69, K_EXISTS=70, K_EXPLAIN=71, 
		K_FAIL=72, K_FOR=73, K_FOREIGN=74, K_FROM=75, K_FULL=76, K_GLOB=77, K_GROUP=78, 
		K_HAVING=79, K_IF=80, K_IGNORE=81, K_IMMEDIATE=82, K_IN=83, K_INDEX=84, 
		K_INDEXED=85, K_INITIALLY=86, K_INNER=87, K_INSERT=88, K_INSTEAD=89, K_INTERSECT=90, 
		K_INTO=91, K_IS=92, K_ISNULL=93, K_JOIN=94, K_KEY=95, K_LEFT=96, K_LIKE=97, 
		K_LIMIT=98, K_MATCH=99, K_NATURAL=100, K_NO=101, K_NOT=102, K_NOTNULL=103, 
		K_NULL=104, K_OF=105, K_OFFSET=106, K_ON=107, K_OR=108, K_ORDER=109, K_OUTER=110, 
		K_PLAN=111, K_PRAGMA=112, K_PRIMARY=113, K_QUERY=114, K_RAISE=115, K_RECURSIVE=116, 
		K_REFERENCES=117, K_REGEXP=118, K_REINDEX=119, K_RELEASE=120, K_RENAME=121, 
		K_REPLACE=122, K_RESTRICT=123, K_RIGHT=124, K_ROLLBACK=125, K_ROW=126, 
		K_SAVEPOINT=127, K_SELECT=128, K_SET=129, K_TABLE=130, K_TEMP=131, K_TEMPORARY=132, 
		K_THEN=133, K_TO=134, K_TRANSACTION=135, K_TRIGGER=136, K_UNION=137, K_UNIQUE=138, 
		K_UPDATE=139, K_USING=140, K_VACUUM=141, K_VALUES=142, K_VIEW=143, K_VIRTUAL=144, 
		K_WHEN=145, K_WHERE=146, K_WITH=147, K_WITHOUT=148, IDENTIFIER=149, NUMERIC_LITERAL=150, 
		BIND_PARAMETER=151, STRING_LITERAL=152, BLOB_LITERAL=153, SINGLE_LINE_COMMENT=154, 
		MULTILINE_COMMENT=155, SPACES=156, UNEXPECTED_CHAR=157;
	public static final int
		RULE_parse = 0, RULE_error = 1, RULE_sql_stmt_list = 2, RULE_sql_stmt = 3, 
		RULE_alter_table_stmt = 4, RULE_analyze_stmt = 5, RULE_attach_stmt = 6, 
		RULE_begin_stmt = 7, RULE_commit_stmt = 8, RULE_compound_select_stmt = 9, 
		RULE_create_index_stmt = 10, RULE_create_table_stmt = 11, RULE_create_trigger_stmt = 12, 
		RULE_create_view_stmt = 13, RULE_create_virtual_table_stmt = 14, RULE_delete_stmt = 15, 
		RULE_delete_stmt_limited = 16, RULE_detach_stmt = 17, RULE_drop_index_stmt = 18, 
		RULE_drop_table_stmt = 19, RULE_drop_trigger_stmt = 20, RULE_drop_view_stmt = 21, 
		RULE_factored_select_stmt = 22, RULE_insert_stmt = 23, RULE_pragma_stmt = 24, 
		RULE_reindex_stmt = 25, RULE_release_stmt = 26, RULE_rollback_stmt = 27, 
		RULE_savepoint_stmt = 28, RULE_simple_select_stmt = 29, RULE_select_stmt = 30, 
		RULE_select_or_values = 31, RULE_update_stmt = 32, RULE_update_stmt_limited = 33, 
		RULE_vacuum_stmt = 34, RULE_column_def = 35, RULE_type_name = 36, RULE_column_constraint = 37, 
		RULE_conflict_clause = 38, RULE_expr = 39, RULE_foreign_key_clause = 40, 
		RULE_raise_function = 41, RULE_indexed_column = 42, RULE_table_constraint = 43, 
		RULE_with_clause = 44, RULE_qualified_table_name = 45, RULE_ordering_term = 46, 
		RULE_pragma_value = 47, RULE_common_table_expression = 48, RULE_result_column = 49, 
		RULE_table_or_subquery = 50, RULE_join_clause = 51, RULE_join_operator = 52, 
		RULE_join_constraint = 53, RULE_select_core = 54, RULE_compound_operator = 55, 
		RULE_cte_table_name = 56, RULE_signed_number = 57, RULE_literal_value = 58, 
		RULE_unary_operator = 59, RULE_error_message = 60, RULE_module_argument = 61, 
		RULE_column_alias = 62, RULE_keyword = 63, RULE_name = 64, RULE_function_name = 65, 
		RULE_database_name = 66, RULE_table_name = 67, RULE_table_or_index_name = 68, 
		RULE_new_table_name = 69, RULE_column_name = 70, RULE_collation_name = 71, 
		RULE_foreign_table = 72, RULE_index_name = 73, RULE_trigger_name = 74, 
		RULE_view_name = 75, RULE_module_name = 76, RULE_pragma_name = 77, RULE_savepoint_name = 78, 
		RULE_table_alias = 79, RULE_transaction_name = 80, RULE_any_name = 81;
	private static String[] makeRuleNames() {
		return new String[] {
			"parse", "error", "sql_stmt_list", "sql_stmt", "alter_table_stmt", "analyze_stmt", 
			"attach_stmt", "begin_stmt", "commit_stmt", "compound_select_stmt", "create_index_stmt", 
			"create_table_stmt", "create_trigger_stmt", "create_view_stmt", "create_virtual_table_stmt", 
			"delete_stmt", "delete_stmt_limited", "detach_stmt", "drop_index_stmt", 
			"drop_table_stmt", "drop_trigger_stmt", "drop_view_stmt", "factored_select_stmt", 
			"insert_stmt", "pragma_stmt", "reindex_stmt", "release_stmt", "rollback_stmt", 
			"savepoint_stmt", "simple_select_stmt", "select_stmt", "select_or_values", 
			"update_stmt", "update_stmt_limited", "vacuum_stmt", "column_def", "type_name", 
			"column_constraint", "conflict_clause", "expr", "foreign_key_clause", 
			"raise_function", "indexed_column", "table_constraint", "with_clause", 
			"qualified_table_name", "ordering_term", "pragma_value", "common_table_expression", 
			"result_column", "table_or_subquery", "join_clause", "join_operator", 
			"join_constraint", "select_core", "compound_operator", "cte_table_name", 
			"signed_number", "literal_value", "unary_operator", "error_message", 
			"module_argument", "column_alias", "keyword", "name", "function_name", 
			"database_name", "table_name", "table_or_index_name", "new_table_name", 
			"column_name", "collation_name", "foreign_table", "index_name", "trigger_name", 
			"view_name", "module_name", "pragma_name", "savepoint_name", "table_alias", 
			"transaction_name", "any_name"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "';'", "'.'", "'('", "')'", "','", "'='", "'*'", "'+'", "'-'", 
			"'~'", "'||'", "'/'", "'%'", "'<<'", "'>>'", "'&'", "'|'", "'<'", "'<='", 
			"'>'", "'>='", "'=='", "'!='", "'<>'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "SCOL", "DOT", "OPEN_PAR", "CLOSE_PAR", "COMMA", "ASSIGN", "STAR", 
			"PLUS", "MINUS", "TILDE", "PIPE2", "DIV", "MOD", "LT2", "GT2", "AMP", 
			"PIPE", "LT", "LT_EQ", "GT", "GT_EQ", "EQ", "NOT_EQ1", "NOT_EQ2", "K_ABORT", 
			"K_ACTION", "K_ADD", "K_AFTER", "K_ALL", "K_ALTER", "K_ANALYZE", "K_AND", 
			"K_AS", "K_ASC", "K_ATTACH", "K_AUTOINCREMENT", "K_BEFORE", "K_BEGIN", 
			"K_BETWEEN", "K_BY", "K_CASCADE", "K_CASE", "K_CAST", "K_CHECK", "K_COLLATE", 
			"K_COLUMN", "K_COMMIT", "K_CONFLICT", "K_CONSTRAINT", "K_CREATE", "K_CROSS", 
			"K_CURRENT_DATE", "K_CURRENT_TIME", "K_CURRENT_TIMESTAMP", "K_DATABASE", 
			"K_DEFAULT", "K_DEFERRABLE", "K_DEFERRED", "K_DELETE", "K_DESC", "K_DETACH", 
			"K_DISTINCT", "K_DROP", "K_EACH", "K_ELSE", "K_END", "K_ESCAPE", "K_EXCEPT", 
			"K_EXCLUSIVE", "K_EXISTS", "K_EXPLAIN", "K_FAIL", "K_FOR", "K_FOREIGN", 
			"K_FROM", "K_FULL", "K_GLOB", "K_GROUP", "K_HAVING", "K_IF", "K_IGNORE", 
			"K_IMMEDIATE", "K_IN", "K_INDEX", "K_INDEXED", "K_INITIALLY", "K_INNER", 
			"K_INSERT", "K_INSTEAD", "K_INTERSECT", "K_INTO", "K_IS", "K_ISNULL", 
			"K_JOIN", "K_KEY", "K_LEFT", "K_LIKE", "K_LIMIT", "K_MATCH", "K_NATURAL", 
			"K_NO", "K_NOT", "K_NOTNULL", "K_NULL", "K_OF", "K_OFFSET", "K_ON", "K_OR", 
			"K_ORDER", "K_OUTER", "K_PLAN", "K_PRAGMA", "K_PRIMARY", "K_QUERY", "K_RAISE", 
			"K_RECURSIVE", "K_REFERENCES", "K_REGEXP", "K_REINDEX", "K_RELEASE", 
			"K_RENAME", "K_REPLACE", "K_RESTRICT", "K_RIGHT", "K_ROLLBACK", "K_ROW", 
			"K_SAVEPOINT", "K_SELECT", "K_SET", "K_TABLE", "K_TEMP", "K_TEMPORARY", 
			"K_THEN", "K_TO", "K_TRANSACTION", "K_TRIGGER", "K_UNION", "K_UNIQUE", 
			"K_UPDATE", "K_USING", "K_VACUUM", "K_VALUES", "K_VIEW", "K_VIRTUAL", 
			"K_WHEN", "K_WHERE", "K_WITH", "K_WITHOUT", "IDENTIFIER", "NUMERIC_LITERAL", 
			"BIND_PARAMETER", "STRING_LITERAL", "BLOB_LITERAL", "SINGLE_LINE_COMMENT", 
			"MULTILINE_COMMENT", "SPACES", "UNEXPECTED_CHAR"
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
	public String getGrammarFileName() { return "SQL.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public SQLParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ParseContext extends ParserRuleContext {
		public TerminalNode EOF() { return getToken(SQLParser.EOF, 0); }
		public List<Sql_stmt_listContext> sql_stmt_list() {
			return getRuleContexts(Sql_stmt_listContext.class);
		}
		public Sql_stmt_listContext sql_stmt_list(int i) {
			return getRuleContext(Sql_stmt_listContext.class,i);
		}
		public List<ErrorContext> error() {
			return getRuleContexts(ErrorContext.class);
		}
		public ErrorContext error(int i) {
			return getRuleContext(ErrorContext.class,i);
		}
		public ParseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parse; }
	}

	public final ParseContext parse() throws RecognitionException {
		ParseContext _localctx = new ParseContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_parse);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(168);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & -6339801325483589630L) != 0) || ((((_la - 66)) & ~0x3f) == 0 && ((1L << (_la - 66)) & 7593139340495028257L) != 0) || ((((_la - 139)) & ~0x3f) == 0 && ((1L << (_la - 139)) & 262413L) != 0)) {
				{
				setState(166);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case SCOL:
				case K_ALTER:
				case K_ANALYZE:
				case K_ATTACH:
				case K_BEGIN:
				case K_COMMIT:
				case K_CREATE:
				case K_DELETE:
				case K_DETACH:
				case K_DROP:
				case K_END:
				case K_EXPLAIN:
				case K_INSERT:
				case K_PRAGMA:
				case K_REINDEX:
				case K_RELEASE:
				case K_REPLACE:
				case K_ROLLBACK:
				case K_SAVEPOINT:
				case K_SELECT:
				case K_UPDATE:
				case K_VACUUM:
				case K_VALUES:
				case K_WITH:
					{
					setState(164);
					sql_stmt_list();
					}
					break;
				case UNEXPECTED_CHAR:
					{
					setState(165);
					error();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(170);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(171);
			match(EOF);
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
		public Token UNEXPECTED_CHAR;
		public TerminalNode UNEXPECTED_CHAR() { return getToken(SQLParser.UNEXPECTED_CHAR, 0); }
		public ErrorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_error; }
	}

	public final ErrorContext error() throws RecognitionException {
		ErrorContext _localctx = new ErrorContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_error);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(173);
			((ErrorContext)_localctx).UNEXPECTED_CHAR = match(UNEXPECTED_CHAR);
			 
			     throw new RuntimeException("UNEXPECTED_CHAR=" + (((ErrorContext)_localctx).UNEXPECTED_CHAR!=null?((ErrorContext)_localctx).UNEXPECTED_CHAR.getText():null)); 
			   
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
	public static class Sql_stmt_listContext extends ParserRuleContext {
		public List<Sql_stmtContext> sql_stmt() {
			return getRuleContexts(Sql_stmtContext.class);
		}
		public Sql_stmtContext sql_stmt(int i) {
			return getRuleContext(Sql_stmtContext.class,i);
		}
		public List<TerminalNode> SCOL() { return getTokens(SQLParser.SCOL); }
		public TerminalNode SCOL(int i) {
			return getToken(SQLParser.SCOL, i);
		}
		public Sql_stmt_listContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sql_stmt_list; }
	}

	public final Sql_stmt_listContext sql_stmt_list() throws RecognitionException {
		Sql_stmt_listContext _localctx = new Sql_stmt_listContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_sql_stmt_list);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(179);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==SCOL) {
				{
				{
				setState(176);
				match(SCOL);
				}
				}
				setState(181);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(182);
			sql_stmt();
			setState(191);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,4,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(184); 
					_errHandler.sync(this);
					_la = _input.LA(1);
					do {
						{
						{
						setState(183);
						match(SCOL);
						}
						}
						setState(186); 
						_errHandler.sync(this);
						_la = _input.LA(1);
					} while ( _la==SCOL );
					setState(188);
					sql_stmt();
					}
					} 
				}
				setState(193);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,4,_ctx);
			}
			setState(197);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,5,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(194);
					match(SCOL);
					}
					} 
				}
				setState(199);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,5,_ctx);
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
	public static class Sql_stmtContext extends ParserRuleContext {
		public Alter_table_stmtContext alter_table_stmt() {
			return getRuleContext(Alter_table_stmtContext.class,0);
		}
		public Analyze_stmtContext analyze_stmt() {
			return getRuleContext(Analyze_stmtContext.class,0);
		}
		public Attach_stmtContext attach_stmt() {
			return getRuleContext(Attach_stmtContext.class,0);
		}
		public Begin_stmtContext begin_stmt() {
			return getRuleContext(Begin_stmtContext.class,0);
		}
		public Commit_stmtContext commit_stmt() {
			return getRuleContext(Commit_stmtContext.class,0);
		}
		public Compound_select_stmtContext compound_select_stmt() {
			return getRuleContext(Compound_select_stmtContext.class,0);
		}
		public Create_index_stmtContext create_index_stmt() {
			return getRuleContext(Create_index_stmtContext.class,0);
		}
		public Create_table_stmtContext create_table_stmt() {
			return getRuleContext(Create_table_stmtContext.class,0);
		}
		public Create_trigger_stmtContext create_trigger_stmt() {
			return getRuleContext(Create_trigger_stmtContext.class,0);
		}
		public Create_view_stmtContext create_view_stmt() {
			return getRuleContext(Create_view_stmtContext.class,0);
		}
		public Create_virtual_table_stmtContext create_virtual_table_stmt() {
			return getRuleContext(Create_virtual_table_stmtContext.class,0);
		}
		public Delete_stmtContext delete_stmt() {
			return getRuleContext(Delete_stmtContext.class,0);
		}
		public Delete_stmt_limitedContext delete_stmt_limited() {
			return getRuleContext(Delete_stmt_limitedContext.class,0);
		}
		public Detach_stmtContext detach_stmt() {
			return getRuleContext(Detach_stmtContext.class,0);
		}
		public Drop_index_stmtContext drop_index_stmt() {
			return getRuleContext(Drop_index_stmtContext.class,0);
		}
		public Drop_table_stmtContext drop_table_stmt() {
			return getRuleContext(Drop_table_stmtContext.class,0);
		}
		public Drop_trigger_stmtContext drop_trigger_stmt() {
			return getRuleContext(Drop_trigger_stmtContext.class,0);
		}
		public Drop_view_stmtContext drop_view_stmt() {
			return getRuleContext(Drop_view_stmtContext.class,0);
		}
		public Factored_select_stmtContext factored_select_stmt() {
			return getRuleContext(Factored_select_stmtContext.class,0);
		}
		public Insert_stmtContext insert_stmt() {
			return getRuleContext(Insert_stmtContext.class,0);
		}
		public Pragma_stmtContext pragma_stmt() {
			return getRuleContext(Pragma_stmtContext.class,0);
		}
		public Reindex_stmtContext reindex_stmt() {
			return getRuleContext(Reindex_stmtContext.class,0);
		}
		public Release_stmtContext release_stmt() {
			return getRuleContext(Release_stmtContext.class,0);
		}
		public Rollback_stmtContext rollback_stmt() {
			return getRuleContext(Rollback_stmtContext.class,0);
		}
		public Savepoint_stmtContext savepoint_stmt() {
			return getRuleContext(Savepoint_stmtContext.class,0);
		}
		public Simple_select_stmtContext simple_select_stmt() {
			return getRuleContext(Simple_select_stmtContext.class,0);
		}
		public Select_stmtContext select_stmt() {
			return getRuleContext(Select_stmtContext.class,0);
		}
		public Update_stmtContext update_stmt() {
			return getRuleContext(Update_stmtContext.class,0);
		}
		public Update_stmt_limitedContext update_stmt_limited() {
			return getRuleContext(Update_stmt_limitedContext.class,0);
		}
		public Vacuum_stmtContext vacuum_stmt() {
			return getRuleContext(Vacuum_stmtContext.class,0);
		}
		public TerminalNode K_EXPLAIN() { return getToken(SQLParser.K_EXPLAIN, 0); }
		public TerminalNode K_QUERY() { return getToken(SQLParser.K_QUERY, 0); }
		public TerminalNode K_PLAN() { return getToken(SQLParser.K_PLAN, 0); }
		public Sql_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sql_stmt; }
	}

	public final Sql_stmtContext sql_stmt() throws RecognitionException {
		Sql_stmtContext _localctx = new Sql_stmtContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_sql_stmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(205);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==K_EXPLAIN) {
				{
				setState(200);
				match(K_EXPLAIN);
				setState(203);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==K_QUERY) {
					{
					setState(201);
					match(K_QUERY);
					setState(202);
					match(K_PLAN);
					}
				}

				}
			}

			setState(237);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
			case 1:
				{
				setState(207);
				alter_table_stmt();
				}
				break;
			case 2:
				{
				setState(208);
				analyze_stmt();
				}
				break;
			case 3:
				{
				setState(209);
				attach_stmt();
				}
				break;
			case 4:
				{
				setState(210);
				begin_stmt();
				}
				break;
			case 5:
				{
				setState(211);
				commit_stmt();
				}
				break;
			case 6:
				{
				setState(212);
				compound_select_stmt();
				}
				break;
			case 7:
				{
				setState(213);
				create_index_stmt();
				}
				break;
			case 8:
				{
				setState(214);
				create_table_stmt();
				}
				break;
			case 9:
				{
				setState(215);
				create_trigger_stmt();
				}
				break;
			case 10:
				{
				setState(216);
				create_view_stmt();
				}
				break;
			case 11:
				{
				setState(217);
				create_virtual_table_stmt();
				}
				break;
			case 12:
				{
				setState(218);
				delete_stmt();
				}
				break;
			case 13:
				{
				setState(219);
				delete_stmt_limited();
				}
				break;
			case 14:
				{
				setState(220);
				detach_stmt();
				}
				break;
			case 15:
				{
				setState(221);
				drop_index_stmt();
				}
				break;
			case 16:
				{
				setState(222);
				drop_table_stmt();
				}
				break;
			case 17:
				{
				setState(223);
				drop_trigger_stmt();
				}
				break;
			case 18:
				{
				setState(224);
				drop_view_stmt();
				}
				break;
			case 19:
				{
				setState(225);
				factored_select_stmt();
				}
				break;
			case 20:
				{
				setState(226);
				insert_stmt();
				}
				break;
			case 21:
				{
				setState(227);
				pragma_stmt();
				}
				break;
			case 22:
				{
				setState(228);
				reindex_stmt();
				}
				break;
			case 23:
				{
				setState(229);
				release_stmt();
				}
				break;
			case 24:
				{
				setState(230);
				rollback_stmt();
				}
				break;
			case 25:
				{
				setState(231);
				savepoint_stmt();
				}
				break;
			case 26:
				{
				setState(232);
				simple_select_stmt();
				}
				break;
			case 27:
				{
				setState(233);
				select_stmt();
				}
				break;
			case 28:
				{
				setState(234);
				update_stmt();
				}
				break;
			case 29:
				{
				setState(235);
				update_stmt_limited();
				}
				break;
			case 30:
				{
				setState(236);
				vacuum_stmt();
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
	public static class Alter_table_stmtContext extends ParserRuleContext {
		public TerminalNode K_ALTER() { return getToken(SQLParser.K_ALTER, 0); }
		public TerminalNode K_TABLE() { return getToken(SQLParser.K_TABLE, 0); }
		public Table_nameContext table_name() {
			return getRuleContext(Table_nameContext.class,0);
		}
		public TerminalNode K_RENAME() { return getToken(SQLParser.K_RENAME, 0); }
		public TerminalNode K_TO() { return getToken(SQLParser.K_TO, 0); }
		public New_table_nameContext new_table_name() {
			return getRuleContext(New_table_nameContext.class,0);
		}
		public TerminalNode K_ADD() { return getToken(SQLParser.K_ADD, 0); }
		public Column_defContext column_def() {
			return getRuleContext(Column_defContext.class,0);
		}
		public Database_nameContext database_name() {
			return getRuleContext(Database_nameContext.class,0);
		}
		public TerminalNode DOT() { return getToken(SQLParser.DOT, 0); }
		public TerminalNode K_COLUMN() { return getToken(SQLParser.K_COLUMN, 0); }
		public Alter_table_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_alter_table_stmt; }
	}

	public final Alter_table_stmtContext alter_table_stmt() throws RecognitionException {
		Alter_table_stmtContext _localctx = new Alter_table_stmtContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_alter_table_stmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(239);
			match(K_ALTER);
			setState(240);
			match(K_TABLE);
			setState(244);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
			case 1:
				{
				setState(241);
				database_name();
				setState(242);
				match(DOT);
				}
				break;
			}
			setState(246);
			table_name();
			setState(255);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case K_RENAME:
				{
				setState(247);
				match(K_RENAME);
				setState(248);
				match(K_TO);
				setState(249);
				new_table_name();
				}
				break;
			case K_ADD:
				{
				setState(250);
				match(K_ADD);
				setState(252);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,10,_ctx) ) {
				case 1:
					{
					setState(251);
					match(K_COLUMN);
					}
					break;
				}
				setState(254);
				column_def();
				}
				break;
			default:
				throw new NoViableAltException(this);
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
	public static class Analyze_stmtContext extends ParserRuleContext {
		public TerminalNode K_ANALYZE() { return getToken(SQLParser.K_ANALYZE, 0); }
		public Database_nameContext database_name() {
			return getRuleContext(Database_nameContext.class,0);
		}
		public Table_or_index_nameContext table_or_index_name() {
			return getRuleContext(Table_or_index_nameContext.class,0);
		}
		public TerminalNode DOT() { return getToken(SQLParser.DOT, 0); }
		public Analyze_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_analyze_stmt; }
	}

	public final Analyze_stmtContext analyze_stmt() throws RecognitionException {
		Analyze_stmtContext _localctx = new Analyze_stmtContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_analyze_stmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(257);
			match(K_ANALYZE);
			setState(264);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,12,_ctx) ) {
			case 1:
				{
				setState(258);
				database_name();
				}
				break;
			case 2:
				{
				setState(259);
				table_or_index_name();
				}
				break;
			case 3:
				{
				setState(260);
				database_name();
				setState(261);
				match(DOT);
				setState(262);
				table_or_index_name();
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
	public static class Attach_stmtContext extends ParserRuleContext {
		public TerminalNode K_ATTACH() { return getToken(SQLParser.K_ATTACH, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode K_AS() { return getToken(SQLParser.K_AS, 0); }
		public Database_nameContext database_name() {
			return getRuleContext(Database_nameContext.class,0);
		}
		public TerminalNode K_DATABASE() { return getToken(SQLParser.K_DATABASE, 0); }
		public Attach_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_attach_stmt; }
	}

	public final Attach_stmtContext attach_stmt() throws RecognitionException {
		Attach_stmtContext _localctx = new Attach_stmtContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_attach_stmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(266);
			match(K_ATTACH);
			setState(268);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,13,_ctx) ) {
			case 1:
				{
				setState(267);
				match(K_DATABASE);
				}
				break;
			}
			setState(270);
			expr(0);
			setState(271);
			match(K_AS);
			setState(272);
			database_name();
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
	public static class Begin_stmtContext extends ParserRuleContext {
		public TerminalNode K_BEGIN() { return getToken(SQLParser.K_BEGIN, 0); }
		public TerminalNode K_TRANSACTION() { return getToken(SQLParser.K_TRANSACTION, 0); }
		public TerminalNode K_DEFERRED() { return getToken(SQLParser.K_DEFERRED, 0); }
		public TerminalNode K_IMMEDIATE() { return getToken(SQLParser.K_IMMEDIATE, 0); }
		public TerminalNode K_EXCLUSIVE() { return getToken(SQLParser.K_EXCLUSIVE, 0); }
		public Transaction_nameContext transaction_name() {
			return getRuleContext(Transaction_nameContext.class,0);
		}
		public Begin_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_begin_stmt; }
	}

	public final Begin_stmtContext begin_stmt() throws RecognitionException {
		Begin_stmtContext _localctx = new Begin_stmtContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_begin_stmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(274);
			match(K_BEGIN);
			setState(276);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (((((_la - 58)) & ~0x3f) == 0 && ((1L << (_la - 58)) & 16779265L) != 0)) {
				{
				setState(275);
				_la = _input.LA(1);
				if ( !(((((_la - 58)) & ~0x3f) == 0 && ((1L << (_la - 58)) & 16779265L) != 0)) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				}
			}

			setState(282);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==K_TRANSACTION) {
				{
				setState(278);
				match(K_TRANSACTION);
				setState(280);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,15,_ctx) ) {
				case 1:
					{
					setState(279);
					transaction_name();
					}
					break;
				}
				}
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
	public static class Commit_stmtContext extends ParserRuleContext {
		public TerminalNode K_COMMIT() { return getToken(SQLParser.K_COMMIT, 0); }
		public TerminalNode K_END() { return getToken(SQLParser.K_END, 0); }
		public TerminalNode K_TRANSACTION() { return getToken(SQLParser.K_TRANSACTION, 0); }
		public Transaction_nameContext transaction_name() {
			return getRuleContext(Transaction_nameContext.class,0);
		}
		public Commit_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_commit_stmt; }
	}

	public final Commit_stmtContext commit_stmt() throws RecognitionException {
		Commit_stmtContext _localctx = new Commit_stmtContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_commit_stmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(284);
			_la = _input.LA(1);
			if ( !(_la==K_COMMIT || _la==K_END) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(289);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==K_TRANSACTION) {
				{
				setState(285);
				match(K_TRANSACTION);
				setState(287);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,17,_ctx) ) {
				case 1:
					{
					setState(286);
					transaction_name();
					}
					break;
				}
				}
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
	public static class Compound_select_stmtContext extends ParserRuleContext {
		public List<Select_coreContext> select_core() {
			return getRuleContexts(Select_coreContext.class);
		}
		public Select_coreContext select_core(int i) {
			return getRuleContext(Select_coreContext.class,i);
		}
		public TerminalNode K_WITH() { return getToken(SQLParser.K_WITH, 0); }
		public List<Common_table_expressionContext> common_table_expression() {
			return getRuleContexts(Common_table_expressionContext.class);
		}
		public Common_table_expressionContext common_table_expression(int i) {
			return getRuleContext(Common_table_expressionContext.class,i);
		}
		public TerminalNode K_ORDER() { return getToken(SQLParser.K_ORDER, 0); }
		public TerminalNode K_BY() { return getToken(SQLParser.K_BY, 0); }
		public List<Ordering_termContext> ordering_term() {
			return getRuleContexts(Ordering_termContext.class);
		}
		public Ordering_termContext ordering_term(int i) {
			return getRuleContext(Ordering_termContext.class,i);
		}
		public TerminalNode K_LIMIT() { return getToken(SQLParser.K_LIMIT, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public List<TerminalNode> K_UNION() { return getTokens(SQLParser.K_UNION); }
		public TerminalNode K_UNION(int i) {
			return getToken(SQLParser.K_UNION, i);
		}
		public List<TerminalNode> K_INTERSECT() { return getTokens(SQLParser.K_INTERSECT); }
		public TerminalNode K_INTERSECT(int i) {
			return getToken(SQLParser.K_INTERSECT, i);
		}
		public List<TerminalNode> K_EXCEPT() { return getTokens(SQLParser.K_EXCEPT); }
		public TerminalNode K_EXCEPT(int i) {
			return getToken(SQLParser.K_EXCEPT, i);
		}
		public TerminalNode K_RECURSIVE() { return getToken(SQLParser.K_RECURSIVE, 0); }
		public List<TerminalNode> COMMA() { return getTokens(SQLParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(SQLParser.COMMA, i);
		}
		public TerminalNode K_OFFSET() { return getToken(SQLParser.K_OFFSET, 0); }
		public List<TerminalNode> K_ALL() { return getTokens(SQLParser.K_ALL); }
		public TerminalNode K_ALL(int i) {
			return getToken(SQLParser.K_ALL, i);
		}
		public Compound_select_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_compound_select_stmt; }
	}

	public final Compound_select_stmtContext compound_select_stmt() throws RecognitionException {
		Compound_select_stmtContext _localctx = new Compound_select_stmtContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_compound_select_stmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(303);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==K_WITH) {
				{
				setState(291);
				match(K_WITH);
				setState(293);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,19,_ctx) ) {
				case 1:
					{
					setState(292);
					match(K_RECURSIVE);
					}
					break;
				}
				setState(295);
				common_table_expression();
				setState(300);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(296);
					match(COMMA);
					setState(297);
					common_table_expression();
					}
					}
					setState(302);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(305);
			select_core();
			setState(315); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(312);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case K_UNION:
					{
					setState(306);
					match(K_UNION);
					setState(308);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==K_ALL) {
						{
						setState(307);
						match(K_ALL);
						}
					}

					}
					break;
				case K_INTERSECT:
					{
					setState(310);
					match(K_INTERSECT);
					}
					break;
				case K_EXCEPT:
					{
					setState(311);
					match(K_EXCEPT);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(314);
				select_core();
				}
				}
				setState(317); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==K_EXCEPT || _la==K_INTERSECT || _la==K_UNION );
			setState(329);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==K_ORDER) {
				{
				setState(319);
				match(K_ORDER);
				setState(320);
				match(K_BY);
				setState(321);
				ordering_term();
				setState(326);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(322);
					match(COMMA);
					setState(323);
					ordering_term();
					}
					}
					setState(328);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(337);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==K_LIMIT) {
				{
				setState(331);
				match(K_LIMIT);
				setState(332);
				expr(0);
				setState(335);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==COMMA || _la==K_OFFSET) {
					{
					setState(333);
					_la = _input.LA(1);
					if ( !(_la==COMMA || _la==K_OFFSET) ) {
					_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					setState(334);
					expr(0);
					}
				}

				}
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
	public static class Create_index_stmtContext extends ParserRuleContext {
		public TerminalNode K_CREATE() { return getToken(SQLParser.K_CREATE, 0); }
		public TerminalNode K_INDEX() { return getToken(SQLParser.K_INDEX, 0); }
		public Index_nameContext index_name() {
			return getRuleContext(Index_nameContext.class,0);
		}
		public TerminalNode K_ON() { return getToken(SQLParser.K_ON, 0); }
		public Table_nameContext table_name() {
			return getRuleContext(Table_nameContext.class,0);
		}
		public TerminalNode OPEN_PAR() { return getToken(SQLParser.OPEN_PAR, 0); }
		public List<Indexed_columnContext> indexed_column() {
			return getRuleContexts(Indexed_columnContext.class);
		}
		public Indexed_columnContext indexed_column(int i) {
			return getRuleContext(Indexed_columnContext.class,i);
		}
		public TerminalNode CLOSE_PAR() { return getToken(SQLParser.CLOSE_PAR, 0); }
		public TerminalNode K_UNIQUE() { return getToken(SQLParser.K_UNIQUE, 0); }
		public TerminalNode K_IF() { return getToken(SQLParser.K_IF, 0); }
		public TerminalNode K_NOT() { return getToken(SQLParser.K_NOT, 0); }
		public TerminalNode K_EXISTS() { return getToken(SQLParser.K_EXISTS, 0); }
		public Database_nameContext database_name() {
			return getRuleContext(Database_nameContext.class,0);
		}
		public TerminalNode DOT() { return getToken(SQLParser.DOT, 0); }
		public List<TerminalNode> COMMA() { return getTokens(SQLParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(SQLParser.COMMA, i);
		}
		public TerminalNode K_WHERE() { return getToken(SQLParser.K_WHERE, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public Create_index_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_create_index_stmt; }
	}

	public final Create_index_stmtContext create_index_stmt() throws RecognitionException {
		Create_index_stmtContext _localctx = new Create_index_stmtContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_create_index_stmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(339);
			match(K_CREATE);
			setState(341);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==K_UNIQUE) {
				{
				setState(340);
				match(K_UNIQUE);
				}
			}

			setState(343);
			match(K_INDEX);
			setState(347);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,30,_ctx) ) {
			case 1:
				{
				setState(344);
				match(K_IF);
				setState(345);
				match(K_NOT);
				setState(346);
				match(K_EXISTS);
				}
				break;
			}
			setState(352);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,31,_ctx) ) {
			case 1:
				{
				setState(349);
				database_name();
				setState(350);
				match(DOT);
				}
				break;
			}
			setState(354);
			index_name();
			setState(355);
			match(K_ON);
			setState(356);
			table_name();
			setState(357);
			match(OPEN_PAR);
			setState(358);
			indexed_column();
			setState(363);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(359);
				match(COMMA);
				setState(360);
				indexed_column();
				}
				}
				setState(365);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(366);
			match(CLOSE_PAR);
			setState(369);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==K_WHERE) {
				{
				setState(367);
				match(K_WHERE);
				setState(368);
				expr(0);
				}
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
	public static class Create_table_stmtContext extends ParserRuleContext {
		public TerminalNode K_CREATE() { return getToken(SQLParser.K_CREATE, 0); }
		public TerminalNode K_TABLE() { return getToken(SQLParser.K_TABLE, 0); }
		public Table_nameContext table_name() {
			return getRuleContext(Table_nameContext.class,0);
		}
		public TerminalNode OPEN_PAR() { return getToken(SQLParser.OPEN_PAR, 0); }
		public List<Column_defContext> column_def() {
			return getRuleContexts(Column_defContext.class);
		}
		public Column_defContext column_def(int i) {
			return getRuleContext(Column_defContext.class,i);
		}
		public TerminalNode CLOSE_PAR() { return getToken(SQLParser.CLOSE_PAR, 0); }
		public TerminalNode K_AS() { return getToken(SQLParser.K_AS, 0); }
		public Select_stmtContext select_stmt() {
			return getRuleContext(Select_stmtContext.class,0);
		}
		public TerminalNode K_IF() { return getToken(SQLParser.K_IF, 0); }
		public TerminalNode K_NOT() { return getToken(SQLParser.K_NOT, 0); }
		public TerminalNode K_EXISTS() { return getToken(SQLParser.K_EXISTS, 0); }
		public Database_nameContext database_name() {
			return getRuleContext(Database_nameContext.class,0);
		}
		public TerminalNode DOT() { return getToken(SQLParser.DOT, 0); }
		public TerminalNode K_TEMP() { return getToken(SQLParser.K_TEMP, 0); }
		public TerminalNode K_TEMPORARY() { return getToken(SQLParser.K_TEMPORARY, 0); }
		public List<TerminalNode> COMMA() { return getTokens(SQLParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(SQLParser.COMMA, i);
		}
		public List<Table_constraintContext> table_constraint() {
			return getRuleContexts(Table_constraintContext.class);
		}
		public Table_constraintContext table_constraint(int i) {
			return getRuleContext(Table_constraintContext.class,i);
		}
		public TerminalNode K_WITHOUT() { return getToken(SQLParser.K_WITHOUT, 0); }
		public TerminalNode IDENTIFIER() { return getToken(SQLParser.IDENTIFIER, 0); }
		public Create_table_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_create_table_stmt; }
	}

	public final Create_table_stmtContext create_table_stmt() throws RecognitionException {
		Create_table_stmtContext _localctx = new Create_table_stmtContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_create_table_stmt);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(371);
			match(K_CREATE);
			setState(373);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==K_TEMP || _la==K_TEMPORARY) {
				{
				setState(372);
				_la = _input.LA(1);
				if ( !(_la==K_TEMP || _la==K_TEMPORARY) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				}
			}

			setState(375);
			match(K_TABLE);
			setState(379);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,35,_ctx) ) {
			case 1:
				{
				setState(376);
				match(K_IF);
				setState(377);
				match(K_NOT);
				setState(378);
				match(K_EXISTS);
				}
				break;
			}
			setState(384);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,36,_ctx) ) {
			case 1:
				{
				setState(381);
				database_name();
				setState(382);
				match(DOT);
				}
				break;
			}
			setState(386);
			table_name();
			setState(410);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case OPEN_PAR:
				{
				setState(387);
				match(OPEN_PAR);
				setState(388);
				column_def();
				setState(393);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,37,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(389);
						match(COMMA);
						setState(390);
						column_def();
						}
						} 
					}
					setState(395);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,37,_ctx);
				}
				setState(400);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(396);
					match(COMMA);
					setState(397);
					table_constraint();
					}
					}
					setState(402);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(403);
				match(CLOSE_PAR);
				setState(406);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==K_WITHOUT) {
					{
					setState(404);
					match(K_WITHOUT);
					setState(405);
					match(IDENTIFIER);
					}
				}

				}
				break;
			case K_AS:
				{
				setState(408);
				match(K_AS);
				setState(409);
				select_stmt();
				}
				break;
			default:
				throw new NoViableAltException(this);
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
	public static class Create_trigger_stmtContext extends ParserRuleContext {
		public TerminalNode K_CREATE() { return getToken(SQLParser.K_CREATE, 0); }
		public TerminalNode K_TRIGGER() { return getToken(SQLParser.K_TRIGGER, 0); }
		public Trigger_nameContext trigger_name() {
			return getRuleContext(Trigger_nameContext.class,0);
		}
		public TerminalNode K_ON() { return getToken(SQLParser.K_ON, 0); }
		public Table_nameContext table_name() {
			return getRuleContext(Table_nameContext.class,0);
		}
		public TerminalNode K_BEGIN() { return getToken(SQLParser.K_BEGIN, 0); }
		public TerminalNode K_END() { return getToken(SQLParser.K_END, 0); }
		public TerminalNode K_DELETE() { return getToken(SQLParser.K_DELETE, 0); }
		public TerminalNode K_INSERT() { return getToken(SQLParser.K_INSERT, 0); }
		public TerminalNode K_UPDATE() { return getToken(SQLParser.K_UPDATE, 0); }
		public TerminalNode K_IF() { return getToken(SQLParser.K_IF, 0); }
		public TerminalNode K_NOT() { return getToken(SQLParser.K_NOT, 0); }
		public TerminalNode K_EXISTS() { return getToken(SQLParser.K_EXISTS, 0); }
		public List<Database_nameContext> database_name() {
			return getRuleContexts(Database_nameContext.class);
		}
		public Database_nameContext database_name(int i) {
			return getRuleContext(Database_nameContext.class,i);
		}
		public List<TerminalNode> DOT() { return getTokens(SQLParser.DOT); }
		public TerminalNode DOT(int i) {
			return getToken(SQLParser.DOT, i);
		}
		public TerminalNode K_BEFORE() { return getToken(SQLParser.K_BEFORE, 0); }
		public TerminalNode K_AFTER() { return getToken(SQLParser.K_AFTER, 0); }
		public TerminalNode K_INSTEAD() { return getToken(SQLParser.K_INSTEAD, 0); }
		public List<TerminalNode> K_OF() { return getTokens(SQLParser.K_OF); }
		public TerminalNode K_OF(int i) {
			return getToken(SQLParser.K_OF, i);
		}
		public TerminalNode K_FOR() { return getToken(SQLParser.K_FOR, 0); }
		public TerminalNode K_EACH() { return getToken(SQLParser.K_EACH, 0); }
		public TerminalNode K_ROW() { return getToken(SQLParser.K_ROW, 0); }
		public TerminalNode K_WHEN() { return getToken(SQLParser.K_WHEN, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public List<TerminalNode> SCOL() { return getTokens(SQLParser.SCOL); }
		public TerminalNode SCOL(int i) {
			return getToken(SQLParser.SCOL, i);
		}
		public TerminalNode K_TEMP() { return getToken(SQLParser.K_TEMP, 0); }
		public TerminalNode K_TEMPORARY() { return getToken(SQLParser.K_TEMPORARY, 0); }
		public List<Column_nameContext> column_name() {
			return getRuleContexts(Column_nameContext.class);
		}
		public Column_nameContext column_name(int i) {
			return getRuleContext(Column_nameContext.class,i);
		}
		public List<Update_stmtContext> update_stmt() {
			return getRuleContexts(Update_stmtContext.class);
		}
		public Update_stmtContext update_stmt(int i) {
			return getRuleContext(Update_stmtContext.class,i);
		}
		public List<Insert_stmtContext> insert_stmt() {
			return getRuleContexts(Insert_stmtContext.class);
		}
		public Insert_stmtContext insert_stmt(int i) {
			return getRuleContext(Insert_stmtContext.class,i);
		}
		public List<Delete_stmtContext> delete_stmt() {
			return getRuleContexts(Delete_stmtContext.class);
		}
		public Delete_stmtContext delete_stmt(int i) {
			return getRuleContext(Delete_stmtContext.class,i);
		}
		public List<Select_stmtContext> select_stmt() {
			return getRuleContexts(Select_stmtContext.class);
		}
		public Select_stmtContext select_stmt(int i) {
			return getRuleContext(Select_stmtContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(SQLParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(SQLParser.COMMA, i);
		}
		public Create_trigger_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_create_trigger_stmt; }
	}

	public final Create_trigger_stmtContext create_trigger_stmt() throws RecognitionException {
		Create_trigger_stmtContext _localctx = new Create_trigger_stmtContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_create_trigger_stmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(412);
			match(K_CREATE);
			setState(414);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==K_TEMP || _la==K_TEMPORARY) {
				{
				setState(413);
				_la = _input.LA(1);
				if ( !(_la==K_TEMP || _la==K_TEMPORARY) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				}
			}

			setState(416);
			match(K_TRIGGER);
			setState(420);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,42,_ctx) ) {
			case 1:
				{
				setState(417);
				match(K_IF);
				setState(418);
				match(K_NOT);
				setState(419);
				match(K_EXISTS);
				}
				break;
			}
			setState(425);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,43,_ctx) ) {
			case 1:
				{
				setState(422);
				database_name();
				setState(423);
				match(DOT);
				}
				break;
			}
			setState(427);
			trigger_name();
			setState(432);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case K_BEFORE:
				{
				setState(428);
				match(K_BEFORE);
				}
				break;
			case K_AFTER:
				{
				setState(429);
				match(K_AFTER);
				}
				break;
			case K_INSTEAD:
				{
				setState(430);
				match(K_INSTEAD);
				setState(431);
				match(K_OF);
				}
				break;
			case K_DELETE:
			case K_INSERT:
			case K_UPDATE:
				break;
			default:
				break;
			}
			setState(448);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case K_DELETE:
				{
				setState(434);
				match(K_DELETE);
				}
				break;
			case K_INSERT:
				{
				setState(435);
				match(K_INSERT);
				}
				break;
			case K_UPDATE:
				{
				setState(436);
				match(K_UPDATE);
				setState(446);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==K_OF) {
					{
					setState(437);
					match(K_OF);
					setState(438);
					column_name();
					setState(443);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==COMMA) {
						{
						{
						setState(439);
						match(COMMA);
						setState(440);
						column_name();
						}
						}
						setState(445);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(450);
			match(K_ON);
			setState(454);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,48,_ctx) ) {
			case 1:
				{
				setState(451);
				database_name();
				setState(452);
				match(DOT);
				}
				break;
			}
			setState(456);
			table_name();
			setState(460);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==K_FOR) {
				{
				setState(457);
				match(K_FOR);
				setState(458);
				match(K_EACH);
				setState(459);
				match(K_ROW);
				}
			}

			setState(464);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==K_WHEN) {
				{
				setState(462);
				match(K_WHEN);
				setState(463);
				expr(0);
				}
			}

			setState(466);
			match(K_BEGIN);
			setState(475); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(471);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,51,_ctx) ) {
				case 1:
					{
					setState(467);
					update_stmt();
					}
					break;
				case 2:
					{
					setState(468);
					insert_stmt();
					}
					break;
				case 3:
					{
					setState(469);
					delete_stmt();
					}
					break;
				case 4:
					{
					setState(470);
					select_stmt();
					}
					break;
				}
				setState(473);
				match(SCOL);
				}
				}
				setState(477); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==K_DELETE || ((((_la - 88)) & ~0x3f) == 0 && ((1L << (_la - 88)) & 596728067318087681L) != 0) );
			setState(479);
			match(K_END);
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
	public static class Create_view_stmtContext extends ParserRuleContext {
		public TerminalNode K_CREATE() { return getToken(SQLParser.K_CREATE, 0); }
		public TerminalNode K_VIEW() { return getToken(SQLParser.K_VIEW, 0); }
		public View_nameContext view_name() {
			return getRuleContext(View_nameContext.class,0);
		}
		public TerminalNode K_AS() { return getToken(SQLParser.K_AS, 0); }
		public Select_stmtContext select_stmt() {
			return getRuleContext(Select_stmtContext.class,0);
		}
		public TerminalNode K_IF() { return getToken(SQLParser.K_IF, 0); }
		public TerminalNode K_NOT() { return getToken(SQLParser.K_NOT, 0); }
		public TerminalNode K_EXISTS() { return getToken(SQLParser.K_EXISTS, 0); }
		public Database_nameContext database_name() {
			return getRuleContext(Database_nameContext.class,0);
		}
		public TerminalNode DOT() { return getToken(SQLParser.DOT, 0); }
		public TerminalNode K_TEMP() { return getToken(SQLParser.K_TEMP, 0); }
		public TerminalNode K_TEMPORARY() { return getToken(SQLParser.K_TEMPORARY, 0); }
		public Create_view_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_create_view_stmt; }
	}

	public final Create_view_stmtContext create_view_stmt() throws RecognitionException {
		Create_view_stmtContext _localctx = new Create_view_stmtContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_create_view_stmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(481);
			match(K_CREATE);
			setState(483);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==K_TEMP || _la==K_TEMPORARY) {
				{
				setState(482);
				_la = _input.LA(1);
				if ( !(_la==K_TEMP || _la==K_TEMPORARY) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				}
			}

			setState(485);
			match(K_VIEW);
			setState(489);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,54,_ctx) ) {
			case 1:
				{
				setState(486);
				match(K_IF);
				setState(487);
				match(K_NOT);
				setState(488);
				match(K_EXISTS);
				}
				break;
			}
			setState(494);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,55,_ctx) ) {
			case 1:
				{
				setState(491);
				database_name();
				setState(492);
				match(DOT);
				}
				break;
			}
			setState(496);
			view_name();
			setState(497);
			match(K_AS);
			setState(498);
			select_stmt();
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
	public static class Create_virtual_table_stmtContext extends ParserRuleContext {
		public TerminalNode K_CREATE() { return getToken(SQLParser.K_CREATE, 0); }
		public TerminalNode K_VIRTUAL() { return getToken(SQLParser.K_VIRTUAL, 0); }
		public TerminalNode K_TABLE() { return getToken(SQLParser.K_TABLE, 0); }
		public Table_nameContext table_name() {
			return getRuleContext(Table_nameContext.class,0);
		}
		public TerminalNode K_USING() { return getToken(SQLParser.K_USING, 0); }
		public Module_nameContext module_name() {
			return getRuleContext(Module_nameContext.class,0);
		}
		public TerminalNode K_IF() { return getToken(SQLParser.K_IF, 0); }
		public TerminalNode K_NOT() { return getToken(SQLParser.K_NOT, 0); }
		public TerminalNode K_EXISTS() { return getToken(SQLParser.K_EXISTS, 0); }
		public Database_nameContext database_name() {
			return getRuleContext(Database_nameContext.class,0);
		}
		public TerminalNode DOT() { return getToken(SQLParser.DOT, 0); }
		public TerminalNode OPEN_PAR() { return getToken(SQLParser.OPEN_PAR, 0); }
		public List<Module_argumentContext> module_argument() {
			return getRuleContexts(Module_argumentContext.class);
		}
		public Module_argumentContext module_argument(int i) {
			return getRuleContext(Module_argumentContext.class,i);
		}
		public TerminalNode CLOSE_PAR() { return getToken(SQLParser.CLOSE_PAR, 0); }
		public List<TerminalNode> COMMA() { return getTokens(SQLParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(SQLParser.COMMA, i);
		}
		public Create_virtual_table_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_create_virtual_table_stmt; }
	}

	public final Create_virtual_table_stmtContext create_virtual_table_stmt() throws RecognitionException {
		Create_virtual_table_stmtContext _localctx = new Create_virtual_table_stmtContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_create_virtual_table_stmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(500);
			match(K_CREATE);
			setState(501);
			match(K_VIRTUAL);
			setState(502);
			match(K_TABLE);
			setState(506);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,56,_ctx) ) {
			case 1:
				{
				setState(503);
				match(K_IF);
				setState(504);
				match(K_NOT);
				setState(505);
				match(K_EXISTS);
				}
				break;
			}
			setState(511);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,57,_ctx) ) {
			case 1:
				{
				setState(508);
				database_name();
				setState(509);
				match(DOT);
				}
				break;
			}
			setState(513);
			table_name();
			setState(514);
			match(K_USING);
			setState(515);
			module_name();
			setState(527);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==OPEN_PAR) {
				{
				setState(516);
				match(OPEN_PAR);
				setState(517);
				module_argument();
				setState(522);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(518);
					match(COMMA);
					setState(519);
					module_argument();
					}
					}
					setState(524);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(525);
				match(CLOSE_PAR);
				}
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
	public static class Delete_stmtContext extends ParserRuleContext {
		public TerminalNode K_DELETE() { return getToken(SQLParser.K_DELETE, 0); }
		public TerminalNode K_FROM() { return getToken(SQLParser.K_FROM, 0); }
		public Qualified_table_nameContext qualified_table_name() {
			return getRuleContext(Qualified_table_nameContext.class,0);
		}
		public With_clauseContext with_clause() {
			return getRuleContext(With_clauseContext.class,0);
		}
		public TerminalNode K_WHERE() { return getToken(SQLParser.K_WHERE, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public Delete_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_delete_stmt; }
	}

	public final Delete_stmtContext delete_stmt() throws RecognitionException {
		Delete_stmtContext _localctx = new Delete_stmtContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_delete_stmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(530);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==K_WITH) {
				{
				setState(529);
				with_clause();
				}
			}

			setState(532);
			match(K_DELETE);
			setState(533);
			match(K_FROM);
			setState(534);
			qualified_table_name();
			setState(537);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==K_WHERE) {
				{
				setState(535);
				match(K_WHERE);
				setState(536);
				expr(0);
				}
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
	public static class Delete_stmt_limitedContext extends ParserRuleContext {
		public TerminalNode K_DELETE() { return getToken(SQLParser.K_DELETE, 0); }
		public TerminalNode K_FROM() { return getToken(SQLParser.K_FROM, 0); }
		public Qualified_table_nameContext qualified_table_name() {
			return getRuleContext(Qualified_table_nameContext.class,0);
		}
		public With_clauseContext with_clause() {
			return getRuleContext(With_clauseContext.class,0);
		}
		public TerminalNode K_WHERE() { return getToken(SQLParser.K_WHERE, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode K_LIMIT() { return getToken(SQLParser.K_LIMIT, 0); }
		public TerminalNode K_ORDER() { return getToken(SQLParser.K_ORDER, 0); }
		public TerminalNode K_BY() { return getToken(SQLParser.K_BY, 0); }
		public List<Ordering_termContext> ordering_term() {
			return getRuleContexts(Ordering_termContext.class);
		}
		public Ordering_termContext ordering_term(int i) {
			return getRuleContext(Ordering_termContext.class,i);
		}
		public TerminalNode K_OFFSET() { return getToken(SQLParser.K_OFFSET, 0); }
		public List<TerminalNode> COMMA() { return getTokens(SQLParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(SQLParser.COMMA, i);
		}
		public Delete_stmt_limitedContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_delete_stmt_limited; }
	}

	public final Delete_stmt_limitedContext delete_stmt_limited() throws RecognitionException {
		Delete_stmt_limitedContext _localctx = new Delete_stmt_limitedContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_delete_stmt_limited);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(540);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==K_WITH) {
				{
				setState(539);
				with_clause();
				}
			}

			setState(542);
			match(K_DELETE);
			setState(543);
			match(K_FROM);
			setState(544);
			qualified_table_name();
			setState(547);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==K_WHERE) {
				{
				setState(545);
				match(K_WHERE);
				setState(546);
				expr(0);
				}
			}

			setState(567);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==K_LIMIT || _la==K_ORDER) {
				{
				setState(559);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==K_ORDER) {
					{
					setState(549);
					match(K_ORDER);
					setState(550);
					match(K_BY);
					setState(551);
					ordering_term();
					setState(556);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==COMMA) {
						{
						{
						setState(552);
						match(COMMA);
						setState(553);
						ordering_term();
						}
						}
						setState(558);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(561);
				match(K_LIMIT);
				setState(562);
				expr(0);
				setState(565);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==COMMA || _la==K_OFFSET) {
					{
					setState(563);
					_la = _input.LA(1);
					if ( !(_la==COMMA || _la==K_OFFSET) ) {
					_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					setState(564);
					expr(0);
					}
				}

				}
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
	public static class Detach_stmtContext extends ParserRuleContext {
		public TerminalNode K_DETACH() { return getToken(SQLParser.K_DETACH, 0); }
		public Database_nameContext database_name() {
			return getRuleContext(Database_nameContext.class,0);
		}
		public TerminalNode K_DATABASE() { return getToken(SQLParser.K_DATABASE, 0); }
		public Detach_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_detach_stmt; }
	}

	public final Detach_stmtContext detach_stmt() throws RecognitionException {
		Detach_stmtContext _localctx = new Detach_stmtContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_detach_stmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(569);
			match(K_DETACH);
			setState(571);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,68,_ctx) ) {
			case 1:
				{
				setState(570);
				match(K_DATABASE);
				}
				break;
			}
			setState(573);
			database_name();
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
	public static class Drop_index_stmtContext extends ParserRuleContext {
		public TerminalNode K_DROP() { return getToken(SQLParser.K_DROP, 0); }
		public TerminalNode K_INDEX() { return getToken(SQLParser.K_INDEX, 0); }
		public Index_nameContext index_name() {
			return getRuleContext(Index_nameContext.class,0);
		}
		public TerminalNode K_IF() { return getToken(SQLParser.K_IF, 0); }
		public TerminalNode K_EXISTS() { return getToken(SQLParser.K_EXISTS, 0); }
		public Database_nameContext database_name() {
			return getRuleContext(Database_nameContext.class,0);
		}
		public TerminalNode DOT() { return getToken(SQLParser.DOT, 0); }
		public Drop_index_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_drop_index_stmt; }
	}

	public final Drop_index_stmtContext drop_index_stmt() throws RecognitionException {
		Drop_index_stmtContext _localctx = new Drop_index_stmtContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_drop_index_stmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(575);
			match(K_DROP);
			setState(576);
			match(K_INDEX);
			setState(579);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,69,_ctx) ) {
			case 1:
				{
				setState(577);
				match(K_IF);
				setState(578);
				match(K_EXISTS);
				}
				break;
			}
			setState(584);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,70,_ctx) ) {
			case 1:
				{
				setState(581);
				database_name();
				setState(582);
				match(DOT);
				}
				break;
			}
			setState(586);
			index_name();
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
	public static class Drop_table_stmtContext extends ParserRuleContext {
		public TerminalNode K_DROP() { return getToken(SQLParser.K_DROP, 0); }
		public TerminalNode K_TABLE() { return getToken(SQLParser.K_TABLE, 0); }
		public Table_nameContext table_name() {
			return getRuleContext(Table_nameContext.class,0);
		}
		public TerminalNode K_IF() { return getToken(SQLParser.K_IF, 0); }
		public TerminalNode K_EXISTS() { return getToken(SQLParser.K_EXISTS, 0); }
		public Database_nameContext database_name() {
			return getRuleContext(Database_nameContext.class,0);
		}
		public TerminalNode DOT() { return getToken(SQLParser.DOT, 0); }
		public Drop_table_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_drop_table_stmt; }
	}

	public final Drop_table_stmtContext drop_table_stmt() throws RecognitionException {
		Drop_table_stmtContext _localctx = new Drop_table_stmtContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_drop_table_stmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(588);
			match(K_DROP);
			setState(589);
			match(K_TABLE);
			setState(592);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,71,_ctx) ) {
			case 1:
				{
				setState(590);
				match(K_IF);
				setState(591);
				match(K_EXISTS);
				}
				break;
			}
			setState(597);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,72,_ctx) ) {
			case 1:
				{
				setState(594);
				database_name();
				setState(595);
				match(DOT);
				}
				break;
			}
			setState(599);
			table_name();
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
	public static class Drop_trigger_stmtContext extends ParserRuleContext {
		public TerminalNode K_DROP() { return getToken(SQLParser.K_DROP, 0); }
		public TerminalNode K_TRIGGER() { return getToken(SQLParser.K_TRIGGER, 0); }
		public Trigger_nameContext trigger_name() {
			return getRuleContext(Trigger_nameContext.class,0);
		}
		public TerminalNode K_IF() { return getToken(SQLParser.K_IF, 0); }
		public TerminalNode K_EXISTS() { return getToken(SQLParser.K_EXISTS, 0); }
		public Database_nameContext database_name() {
			return getRuleContext(Database_nameContext.class,0);
		}
		public TerminalNode DOT() { return getToken(SQLParser.DOT, 0); }
		public Drop_trigger_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_drop_trigger_stmt; }
	}

	public final Drop_trigger_stmtContext drop_trigger_stmt() throws RecognitionException {
		Drop_trigger_stmtContext _localctx = new Drop_trigger_stmtContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_drop_trigger_stmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(601);
			match(K_DROP);
			setState(602);
			match(K_TRIGGER);
			setState(605);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,73,_ctx) ) {
			case 1:
				{
				setState(603);
				match(K_IF);
				setState(604);
				match(K_EXISTS);
				}
				break;
			}
			setState(610);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,74,_ctx) ) {
			case 1:
				{
				setState(607);
				database_name();
				setState(608);
				match(DOT);
				}
				break;
			}
			setState(612);
			trigger_name();
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
	public static class Drop_view_stmtContext extends ParserRuleContext {
		public TerminalNode K_DROP() { return getToken(SQLParser.K_DROP, 0); }
		public TerminalNode K_VIEW() { return getToken(SQLParser.K_VIEW, 0); }
		public View_nameContext view_name() {
			return getRuleContext(View_nameContext.class,0);
		}
		public TerminalNode K_IF() { return getToken(SQLParser.K_IF, 0); }
		public TerminalNode K_EXISTS() { return getToken(SQLParser.K_EXISTS, 0); }
		public Database_nameContext database_name() {
			return getRuleContext(Database_nameContext.class,0);
		}
		public TerminalNode DOT() { return getToken(SQLParser.DOT, 0); }
		public Drop_view_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_drop_view_stmt; }
	}

	public final Drop_view_stmtContext drop_view_stmt() throws RecognitionException {
		Drop_view_stmtContext _localctx = new Drop_view_stmtContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_drop_view_stmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(614);
			match(K_DROP);
			setState(615);
			match(K_VIEW);
			setState(618);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,75,_ctx) ) {
			case 1:
				{
				setState(616);
				match(K_IF);
				setState(617);
				match(K_EXISTS);
				}
				break;
			}
			setState(623);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,76,_ctx) ) {
			case 1:
				{
				setState(620);
				database_name();
				setState(621);
				match(DOT);
				}
				break;
			}
			setState(625);
			view_name();
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
	public static class Factored_select_stmtContext extends ParserRuleContext {
		public List<Select_coreContext> select_core() {
			return getRuleContexts(Select_coreContext.class);
		}
		public Select_coreContext select_core(int i) {
			return getRuleContext(Select_coreContext.class,i);
		}
		public TerminalNode K_WITH() { return getToken(SQLParser.K_WITH, 0); }
		public List<Common_table_expressionContext> common_table_expression() {
			return getRuleContexts(Common_table_expressionContext.class);
		}
		public Common_table_expressionContext common_table_expression(int i) {
			return getRuleContext(Common_table_expressionContext.class,i);
		}
		public List<Compound_operatorContext> compound_operator() {
			return getRuleContexts(Compound_operatorContext.class);
		}
		public Compound_operatorContext compound_operator(int i) {
			return getRuleContext(Compound_operatorContext.class,i);
		}
		public TerminalNode K_ORDER() { return getToken(SQLParser.K_ORDER, 0); }
		public TerminalNode K_BY() { return getToken(SQLParser.K_BY, 0); }
		public List<Ordering_termContext> ordering_term() {
			return getRuleContexts(Ordering_termContext.class);
		}
		public Ordering_termContext ordering_term(int i) {
			return getRuleContext(Ordering_termContext.class,i);
		}
		public TerminalNode K_LIMIT() { return getToken(SQLParser.K_LIMIT, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode K_RECURSIVE() { return getToken(SQLParser.K_RECURSIVE, 0); }
		public List<TerminalNode> COMMA() { return getTokens(SQLParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(SQLParser.COMMA, i);
		}
		public TerminalNode K_OFFSET() { return getToken(SQLParser.K_OFFSET, 0); }
		public Factored_select_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_factored_select_stmt; }
	}

	public final Factored_select_stmtContext factored_select_stmt() throws RecognitionException {
		Factored_select_stmtContext _localctx = new Factored_select_stmtContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_factored_select_stmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(639);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==K_WITH) {
				{
				setState(627);
				match(K_WITH);
				setState(629);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,77,_ctx) ) {
				case 1:
					{
					setState(628);
					match(K_RECURSIVE);
					}
					break;
				}
				setState(631);
				common_table_expression();
				setState(636);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(632);
					match(COMMA);
					setState(633);
					common_table_expression();
					}
					}
					setState(638);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(641);
			select_core();
			setState(647);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==K_EXCEPT || _la==K_INTERSECT || _la==K_UNION) {
				{
				{
				setState(642);
				compound_operator();
				setState(643);
				select_core();
				}
				}
				setState(649);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(660);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==K_ORDER) {
				{
				setState(650);
				match(K_ORDER);
				setState(651);
				match(K_BY);
				setState(652);
				ordering_term();
				setState(657);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(653);
					match(COMMA);
					setState(654);
					ordering_term();
					}
					}
					setState(659);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(668);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==K_LIMIT) {
				{
				setState(662);
				match(K_LIMIT);
				setState(663);
				expr(0);
				setState(666);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==COMMA || _la==K_OFFSET) {
					{
					setState(664);
					_la = _input.LA(1);
					if ( !(_la==COMMA || _la==K_OFFSET) ) {
					_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					setState(665);
					expr(0);
					}
				}

				}
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
	public static class Insert_stmtContext extends ParserRuleContext {
		public TerminalNode K_INTO() { return getToken(SQLParser.K_INTO, 0); }
		public Table_nameContext table_name() {
			return getRuleContext(Table_nameContext.class,0);
		}
		public TerminalNode K_INSERT() { return getToken(SQLParser.K_INSERT, 0); }
		public TerminalNode K_REPLACE() { return getToken(SQLParser.K_REPLACE, 0); }
		public TerminalNode K_OR() { return getToken(SQLParser.K_OR, 0); }
		public TerminalNode K_ROLLBACK() { return getToken(SQLParser.K_ROLLBACK, 0); }
		public TerminalNode K_ABORT() { return getToken(SQLParser.K_ABORT, 0); }
		public TerminalNode K_FAIL() { return getToken(SQLParser.K_FAIL, 0); }
		public TerminalNode K_IGNORE() { return getToken(SQLParser.K_IGNORE, 0); }
		public TerminalNode K_VALUES() { return getToken(SQLParser.K_VALUES, 0); }
		public List<TerminalNode> OPEN_PAR() { return getTokens(SQLParser.OPEN_PAR); }
		public TerminalNode OPEN_PAR(int i) {
			return getToken(SQLParser.OPEN_PAR, i);
		}
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public List<TerminalNode> CLOSE_PAR() { return getTokens(SQLParser.CLOSE_PAR); }
		public TerminalNode CLOSE_PAR(int i) {
			return getToken(SQLParser.CLOSE_PAR, i);
		}
		public Select_stmtContext select_stmt() {
			return getRuleContext(Select_stmtContext.class,0);
		}
		public TerminalNode K_DEFAULT() { return getToken(SQLParser.K_DEFAULT, 0); }
		public With_clauseContext with_clause() {
			return getRuleContext(With_clauseContext.class,0);
		}
		public Database_nameContext database_name() {
			return getRuleContext(Database_nameContext.class,0);
		}
		public TerminalNode DOT() { return getToken(SQLParser.DOT, 0); }
		public List<Column_nameContext> column_name() {
			return getRuleContexts(Column_nameContext.class);
		}
		public Column_nameContext column_name(int i) {
			return getRuleContext(Column_nameContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(SQLParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(SQLParser.COMMA, i);
		}
		public Insert_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_insert_stmt; }
	}

	public final Insert_stmtContext insert_stmt() throws RecognitionException {
		Insert_stmtContext _localctx = new Insert_stmtContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_insert_stmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(671);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==K_WITH) {
				{
				setState(670);
				with_clause();
				}
			}

			setState(690);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,86,_ctx) ) {
			case 1:
				{
				setState(673);
				match(K_INSERT);
				}
				break;
			case 2:
				{
				setState(674);
				match(K_REPLACE);
				}
				break;
			case 3:
				{
				setState(675);
				match(K_INSERT);
				setState(676);
				match(K_OR);
				setState(677);
				match(K_REPLACE);
				}
				break;
			case 4:
				{
				setState(678);
				match(K_INSERT);
				setState(679);
				match(K_OR);
				setState(680);
				match(K_ROLLBACK);
				}
				break;
			case 5:
				{
				setState(681);
				match(K_INSERT);
				setState(682);
				match(K_OR);
				setState(683);
				match(K_ABORT);
				}
				break;
			case 6:
				{
				setState(684);
				match(K_INSERT);
				setState(685);
				match(K_OR);
				setState(686);
				match(K_FAIL);
				}
				break;
			case 7:
				{
				setState(687);
				match(K_INSERT);
				setState(688);
				match(K_OR);
				setState(689);
				match(K_IGNORE);
				}
				break;
			}
			setState(692);
			match(K_INTO);
			setState(696);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,87,_ctx) ) {
			case 1:
				{
				setState(693);
				database_name();
				setState(694);
				match(DOT);
				}
				break;
			}
			setState(698);
			table_name();
			setState(710);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==OPEN_PAR) {
				{
				setState(699);
				match(OPEN_PAR);
				setState(700);
				column_name();
				setState(705);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(701);
					match(COMMA);
					setState(702);
					column_name();
					}
					}
					setState(707);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(708);
				match(CLOSE_PAR);
				}
			}

			setState(743);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,93,_ctx) ) {
			case 1:
				{
				setState(712);
				match(K_VALUES);
				setState(713);
				match(OPEN_PAR);
				setState(714);
				expr(0);
				setState(719);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(715);
					match(COMMA);
					setState(716);
					expr(0);
					}
					}
					setState(721);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(722);
				match(CLOSE_PAR);
				setState(737);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(723);
					match(COMMA);
					setState(724);
					match(OPEN_PAR);
					setState(725);
					expr(0);
					setState(730);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==COMMA) {
						{
						{
						setState(726);
						match(COMMA);
						setState(727);
						expr(0);
						}
						}
						setState(732);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(733);
					match(CLOSE_PAR);
					}
					}
					setState(739);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			case 2:
				{
				setState(740);
				select_stmt();
				}
				break;
			case 3:
				{
				setState(741);
				match(K_DEFAULT);
				setState(742);
				match(K_VALUES);
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
	public static class Pragma_stmtContext extends ParserRuleContext {
		public TerminalNode K_PRAGMA() { return getToken(SQLParser.K_PRAGMA, 0); }
		public Pragma_nameContext pragma_name() {
			return getRuleContext(Pragma_nameContext.class,0);
		}
		public Database_nameContext database_name() {
			return getRuleContext(Database_nameContext.class,0);
		}
		public TerminalNode DOT() { return getToken(SQLParser.DOT, 0); }
		public TerminalNode ASSIGN() { return getToken(SQLParser.ASSIGN, 0); }
		public Pragma_valueContext pragma_value() {
			return getRuleContext(Pragma_valueContext.class,0);
		}
		public TerminalNode OPEN_PAR() { return getToken(SQLParser.OPEN_PAR, 0); }
		public TerminalNode CLOSE_PAR() { return getToken(SQLParser.CLOSE_PAR, 0); }
		public Pragma_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pragma_stmt; }
	}

	public final Pragma_stmtContext pragma_stmt() throws RecognitionException {
		Pragma_stmtContext _localctx = new Pragma_stmtContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_pragma_stmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(745);
			match(K_PRAGMA);
			setState(749);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,94,_ctx) ) {
			case 1:
				{
				setState(746);
				database_name();
				setState(747);
				match(DOT);
				}
				break;
			}
			setState(751);
			pragma_name();
			setState(758);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ASSIGN:
				{
				setState(752);
				match(ASSIGN);
				setState(753);
				pragma_value();
				}
				break;
			case OPEN_PAR:
				{
				setState(754);
				match(OPEN_PAR);
				setState(755);
				pragma_value();
				setState(756);
				match(CLOSE_PAR);
				}
				break;
			case EOF:
			case SCOL:
			case K_ALTER:
			case K_ANALYZE:
			case K_ATTACH:
			case K_BEGIN:
			case K_COMMIT:
			case K_CREATE:
			case K_DELETE:
			case K_DETACH:
			case K_DROP:
			case K_END:
			case K_EXPLAIN:
			case K_INSERT:
			case K_PRAGMA:
			case K_REINDEX:
			case K_RELEASE:
			case K_REPLACE:
			case K_ROLLBACK:
			case K_SAVEPOINT:
			case K_SELECT:
			case K_UPDATE:
			case K_VACUUM:
			case K_VALUES:
			case K_WITH:
			case UNEXPECTED_CHAR:
				break;
			default:
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
	public static class Reindex_stmtContext extends ParserRuleContext {
		public TerminalNode K_REINDEX() { return getToken(SQLParser.K_REINDEX, 0); }
		public Collation_nameContext collation_name() {
			return getRuleContext(Collation_nameContext.class,0);
		}
		public Table_nameContext table_name() {
			return getRuleContext(Table_nameContext.class,0);
		}
		public Index_nameContext index_name() {
			return getRuleContext(Index_nameContext.class,0);
		}
		public Database_nameContext database_name() {
			return getRuleContext(Database_nameContext.class,0);
		}
		public TerminalNode DOT() { return getToken(SQLParser.DOT, 0); }
		public Reindex_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_reindex_stmt; }
	}

	public final Reindex_stmtContext reindex_stmt() throws RecognitionException {
		Reindex_stmtContext _localctx = new Reindex_stmtContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_reindex_stmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(760);
			match(K_REINDEX);
			setState(771);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,98,_ctx) ) {
			case 1:
				{
				setState(761);
				collation_name();
				}
				break;
			case 2:
				{
				setState(765);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,96,_ctx) ) {
				case 1:
					{
					setState(762);
					database_name();
					setState(763);
					match(DOT);
					}
					break;
				}
				setState(769);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,97,_ctx) ) {
				case 1:
					{
					setState(767);
					table_name();
					}
					break;
				case 2:
					{
					setState(768);
					index_name();
					}
					break;
				}
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
	public static class Release_stmtContext extends ParserRuleContext {
		public TerminalNode K_RELEASE() { return getToken(SQLParser.K_RELEASE, 0); }
		public Savepoint_nameContext savepoint_name() {
			return getRuleContext(Savepoint_nameContext.class,0);
		}
		public TerminalNode K_SAVEPOINT() { return getToken(SQLParser.K_SAVEPOINT, 0); }
		public Release_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_release_stmt; }
	}

	public final Release_stmtContext release_stmt() throws RecognitionException {
		Release_stmtContext _localctx = new Release_stmtContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_release_stmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(773);
			match(K_RELEASE);
			setState(775);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,99,_ctx) ) {
			case 1:
				{
				setState(774);
				match(K_SAVEPOINT);
				}
				break;
			}
			setState(777);
			savepoint_name();
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
	public static class Rollback_stmtContext extends ParserRuleContext {
		public TerminalNode K_ROLLBACK() { return getToken(SQLParser.K_ROLLBACK, 0); }
		public TerminalNode K_TRANSACTION() { return getToken(SQLParser.K_TRANSACTION, 0); }
		public TerminalNode K_TO() { return getToken(SQLParser.K_TO, 0); }
		public Savepoint_nameContext savepoint_name() {
			return getRuleContext(Savepoint_nameContext.class,0);
		}
		public Transaction_nameContext transaction_name() {
			return getRuleContext(Transaction_nameContext.class,0);
		}
		public TerminalNode K_SAVEPOINT() { return getToken(SQLParser.K_SAVEPOINT, 0); }
		public Rollback_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_rollback_stmt; }
	}

	public final Rollback_stmtContext rollback_stmt() throws RecognitionException {
		Rollback_stmtContext _localctx = new Rollback_stmtContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_rollback_stmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(779);
			match(K_ROLLBACK);
			setState(784);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==K_TRANSACTION) {
				{
				setState(780);
				match(K_TRANSACTION);
				setState(782);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,100,_ctx) ) {
				case 1:
					{
					setState(781);
					transaction_name();
					}
					break;
				}
				}
			}

			setState(791);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==K_TO) {
				{
				setState(786);
				match(K_TO);
				setState(788);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,102,_ctx) ) {
				case 1:
					{
					setState(787);
					match(K_SAVEPOINT);
					}
					break;
				}
				setState(790);
				savepoint_name();
				}
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
	public static class Savepoint_stmtContext extends ParserRuleContext {
		public TerminalNode K_SAVEPOINT() { return getToken(SQLParser.K_SAVEPOINT, 0); }
		public Savepoint_nameContext savepoint_name() {
			return getRuleContext(Savepoint_nameContext.class,0);
		}
		public Savepoint_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_savepoint_stmt; }
	}

	public final Savepoint_stmtContext savepoint_stmt() throws RecognitionException {
		Savepoint_stmtContext _localctx = new Savepoint_stmtContext(_ctx, getState());
		enterRule(_localctx, 56, RULE_savepoint_stmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(793);
			match(K_SAVEPOINT);
			setState(794);
			savepoint_name();
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
	public static class Simple_select_stmtContext extends ParserRuleContext {
		public Select_coreContext select_core() {
			return getRuleContext(Select_coreContext.class,0);
		}
		public TerminalNode K_WITH() { return getToken(SQLParser.K_WITH, 0); }
		public List<Common_table_expressionContext> common_table_expression() {
			return getRuleContexts(Common_table_expressionContext.class);
		}
		public Common_table_expressionContext common_table_expression(int i) {
			return getRuleContext(Common_table_expressionContext.class,i);
		}
		public TerminalNode K_ORDER() { return getToken(SQLParser.K_ORDER, 0); }
		public TerminalNode K_BY() { return getToken(SQLParser.K_BY, 0); }
		public List<Ordering_termContext> ordering_term() {
			return getRuleContexts(Ordering_termContext.class);
		}
		public Ordering_termContext ordering_term(int i) {
			return getRuleContext(Ordering_termContext.class,i);
		}
		public TerminalNode K_LIMIT() { return getToken(SQLParser.K_LIMIT, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode K_RECURSIVE() { return getToken(SQLParser.K_RECURSIVE, 0); }
		public List<TerminalNode> COMMA() { return getTokens(SQLParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(SQLParser.COMMA, i);
		}
		public TerminalNode K_OFFSET() { return getToken(SQLParser.K_OFFSET, 0); }
		public Simple_select_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_simple_select_stmt; }
	}

	public final Simple_select_stmtContext simple_select_stmt() throws RecognitionException {
		Simple_select_stmtContext _localctx = new Simple_select_stmtContext(_ctx, getState());
		enterRule(_localctx, 58, RULE_simple_select_stmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(808);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==K_WITH) {
				{
				setState(796);
				match(K_WITH);
				setState(798);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,104,_ctx) ) {
				case 1:
					{
					setState(797);
					match(K_RECURSIVE);
					}
					break;
				}
				setState(800);
				common_table_expression();
				setState(805);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(801);
					match(COMMA);
					setState(802);
					common_table_expression();
					}
					}
					setState(807);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(810);
			select_core();
			setState(821);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==K_ORDER) {
				{
				setState(811);
				match(K_ORDER);
				setState(812);
				match(K_BY);
				setState(813);
				ordering_term();
				setState(818);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(814);
					match(COMMA);
					setState(815);
					ordering_term();
					}
					}
					setState(820);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(829);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==K_LIMIT) {
				{
				setState(823);
				match(K_LIMIT);
				setState(824);
				expr(0);
				setState(827);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==COMMA || _la==K_OFFSET) {
					{
					setState(825);
					_la = _input.LA(1);
					if ( !(_la==COMMA || _la==K_OFFSET) ) {
					_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					setState(826);
					expr(0);
					}
				}

				}
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
	public static class Select_stmtContext extends ParserRuleContext {
		public List<Select_or_valuesContext> select_or_values() {
			return getRuleContexts(Select_or_valuesContext.class);
		}
		public Select_or_valuesContext select_or_values(int i) {
			return getRuleContext(Select_or_valuesContext.class,i);
		}
		public TerminalNode K_WITH() { return getToken(SQLParser.K_WITH, 0); }
		public List<Common_table_expressionContext> common_table_expression() {
			return getRuleContexts(Common_table_expressionContext.class);
		}
		public Common_table_expressionContext common_table_expression(int i) {
			return getRuleContext(Common_table_expressionContext.class,i);
		}
		public List<Compound_operatorContext> compound_operator() {
			return getRuleContexts(Compound_operatorContext.class);
		}
		public Compound_operatorContext compound_operator(int i) {
			return getRuleContext(Compound_operatorContext.class,i);
		}
		public TerminalNode K_ORDER() { return getToken(SQLParser.K_ORDER, 0); }
		public TerminalNode K_BY() { return getToken(SQLParser.K_BY, 0); }
		public List<Ordering_termContext> ordering_term() {
			return getRuleContexts(Ordering_termContext.class);
		}
		public Ordering_termContext ordering_term(int i) {
			return getRuleContext(Ordering_termContext.class,i);
		}
		public TerminalNode K_LIMIT() { return getToken(SQLParser.K_LIMIT, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode K_RECURSIVE() { return getToken(SQLParser.K_RECURSIVE, 0); }
		public List<TerminalNode> COMMA() { return getTokens(SQLParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(SQLParser.COMMA, i);
		}
		public TerminalNode K_OFFSET() { return getToken(SQLParser.K_OFFSET, 0); }
		public Select_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_select_stmt; }
	}

	public final Select_stmtContext select_stmt() throws RecognitionException {
		Select_stmtContext _localctx = new Select_stmtContext(_ctx, getState());
		enterRule(_localctx, 60, RULE_select_stmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(843);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==K_WITH) {
				{
				setState(831);
				match(K_WITH);
				setState(833);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,111,_ctx) ) {
				case 1:
					{
					setState(832);
					match(K_RECURSIVE);
					}
					break;
				}
				setState(835);
				common_table_expression();
				setState(840);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(836);
					match(COMMA);
					setState(837);
					common_table_expression();
					}
					}
					setState(842);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(845);
			select_or_values();
			setState(851);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==K_EXCEPT || _la==K_INTERSECT || _la==K_UNION) {
				{
				{
				setState(846);
				compound_operator();
				setState(847);
				select_or_values();
				}
				}
				setState(853);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(864);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==K_ORDER) {
				{
				setState(854);
				match(K_ORDER);
				setState(855);
				match(K_BY);
				setState(856);
				ordering_term();
				setState(861);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(857);
					match(COMMA);
					setState(858);
					ordering_term();
					}
					}
					setState(863);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(872);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==K_LIMIT) {
				{
				setState(866);
				match(K_LIMIT);
				setState(867);
				expr(0);
				setState(870);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==COMMA || _la==K_OFFSET) {
					{
					setState(868);
					_la = _input.LA(1);
					if ( !(_la==COMMA || _la==K_OFFSET) ) {
					_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					setState(869);
					expr(0);
					}
				}

				}
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
	public static class Select_or_valuesContext extends ParserRuleContext {
		public TerminalNode K_SELECT() { return getToken(SQLParser.K_SELECT, 0); }
		public List<Result_columnContext> result_column() {
			return getRuleContexts(Result_columnContext.class);
		}
		public Result_columnContext result_column(int i) {
			return getRuleContext(Result_columnContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(SQLParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(SQLParser.COMMA, i);
		}
		public TerminalNode K_FROM() { return getToken(SQLParser.K_FROM, 0); }
		public TerminalNode K_WHERE() { return getToken(SQLParser.K_WHERE, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode K_GROUP() { return getToken(SQLParser.K_GROUP, 0); }
		public TerminalNode K_BY() { return getToken(SQLParser.K_BY, 0); }
		public TerminalNode K_DISTINCT() { return getToken(SQLParser.K_DISTINCT, 0); }
		public TerminalNode K_ALL() { return getToken(SQLParser.K_ALL, 0); }
		public List<Table_or_subqueryContext> table_or_subquery() {
			return getRuleContexts(Table_or_subqueryContext.class);
		}
		public Table_or_subqueryContext table_or_subquery(int i) {
			return getRuleContext(Table_or_subqueryContext.class,i);
		}
		public Join_clauseContext join_clause() {
			return getRuleContext(Join_clauseContext.class,0);
		}
		public TerminalNode K_HAVING() { return getToken(SQLParser.K_HAVING, 0); }
		public TerminalNode K_VALUES() { return getToken(SQLParser.K_VALUES, 0); }
		public List<TerminalNode> OPEN_PAR() { return getTokens(SQLParser.OPEN_PAR); }
		public TerminalNode OPEN_PAR(int i) {
			return getToken(SQLParser.OPEN_PAR, i);
		}
		public List<TerminalNode> CLOSE_PAR() { return getTokens(SQLParser.CLOSE_PAR); }
		public TerminalNode CLOSE_PAR(int i) {
			return getToken(SQLParser.CLOSE_PAR, i);
		}
		public Select_or_valuesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_select_or_values; }
	}

	public final Select_or_valuesContext select_or_values() throws RecognitionException {
		Select_or_valuesContext _localctx = new Select_or_valuesContext(_ctx, getState());
		enterRule(_localctx, 62, RULE_select_or_values);
		int _la;
		try {
			setState(948);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case K_SELECT:
				enterOuterAlt(_localctx, 1);
				{
				setState(874);
				match(K_SELECT);
				setState(876);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,119,_ctx) ) {
				case 1:
					{
					setState(875);
					_la = _input.LA(1);
					if ( !(_la==K_ALL || _la==K_DISTINCT) ) {
					_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					}
					break;
				}
				setState(878);
				result_column();
				setState(883);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(879);
					match(COMMA);
					setState(880);
					result_column();
					}
					}
					setState(885);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(898);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==K_FROM) {
					{
					setState(886);
					match(K_FROM);
					setState(896);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,122,_ctx) ) {
					case 1:
						{
						setState(887);
						table_or_subquery();
						setState(892);
						_errHandler.sync(this);
						_la = _input.LA(1);
						while (_la==COMMA) {
							{
							{
							setState(888);
							match(COMMA);
							setState(889);
							table_or_subquery();
							}
							}
							setState(894);
							_errHandler.sync(this);
							_la = _input.LA(1);
						}
						}
						break;
					case 2:
						{
						setState(895);
						join_clause();
						}
						break;
					}
					}
				}

				setState(902);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==K_WHERE) {
					{
					setState(900);
					match(K_WHERE);
					setState(901);
					expr(0);
					}
				}

				setState(918);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==K_GROUP) {
					{
					setState(904);
					match(K_GROUP);
					setState(905);
					match(K_BY);
					setState(906);
					expr(0);
					setState(911);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==COMMA) {
						{
						{
						setState(907);
						match(COMMA);
						setState(908);
						expr(0);
						}
						}
						setState(913);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(916);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==K_HAVING) {
						{
						setState(914);
						match(K_HAVING);
						setState(915);
						expr(0);
						}
					}

					}
				}

				}
				break;
			case K_VALUES:
				enterOuterAlt(_localctx, 2);
				{
				setState(920);
				match(K_VALUES);
				setState(921);
				match(OPEN_PAR);
				setState(922);
				expr(0);
				setState(927);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(923);
					match(COMMA);
					setState(924);
					expr(0);
					}
					}
					setState(929);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(930);
				match(CLOSE_PAR);
				setState(945);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(931);
					match(COMMA);
					setState(932);
					match(OPEN_PAR);
					setState(933);
					expr(0);
					setState(938);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==COMMA) {
						{
						{
						setState(934);
						match(COMMA);
						setState(935);
						expr(0);
						}
						}
						setState(940);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(941);
					match(CLOSE_PAR);
					}
					}
					setState(947);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			default:
				throw new NoViableAltException(this);
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
	public static class Update_stmtContext extends ParserRuleContext {
		public TerminalNode K_UPDATE() { return getToken(SQLParser.K_UPDATE, 0); }
		public Qualified_table_nameContext qualified_table_name() {
			return getRuleContext(Qualified_table_nameContext.class,0);
		}
		public TerminalNode K_SET() { return getToken(SQLParser.K_SET, 0); }
		public List<Column_nameContext> column_name() {
			return getRuleContexts(Column_nameContext.class);
		}
		public Column_nameContext column_name(int i) {
			return getRuleContext(Column_nameContext.class,i);
		}
		public List<TerminalNode> ASSIGN() { return getTokens(SQLParser.ASSIGN); }
		public TerminalNode ASSIGN(int i) {
			return getToken(SQLParser.ASSIGN, i);
		}
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public With_clauseContext with_clause() {
			return getRuleContext(With_clauseContext.class,0);
		}
		public TerminalNode K_OR() { return getToken(SQLParser.K_OR, 0); }
		public TerminalNode K_ROLLBACK() { return getToken(SQLParser.K_ROLLBACK, 0); }
		public TerminalNode K_ABORT() { return getToken(SQLParser.K_ABORT, 0); }
		public TerminalNode K_REPLACE() { return getToken(SQLParser.K_REPLACE, 0); }
		public TerminalNode K_FAIL() { return getToken(SQLParser.K_FAIL, 0); }
		public TerminalNode K_IGNORE() { return getToken(SQLParser.K_IGNORE, 0); }
		public List<TerminalNode> COMMA() { return getTokens(SQLParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(SQLParser.COMMA, i);
		}
		public TerminalNode K_WHERE() { return getToken(SQLParser.K_WHERE, 0); }
		public Update_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_update_stmt; }
	}

	public final Update_stmtContext update_stmt() throws RecognitionException {
		Update_stmtContext _localctx = new Update_stmtContext(_ctx, getState());
		enterRule(_localctx, 64, RULE_update_stmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(951);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==K_WITH) {
				{
				setState(950);
				with_clause();
				}
			}

			setState(953);
			match(K_UPDATE);
			setState(964);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,133,_ctx) ) {
			case 1:
				{
				setState(954);
				match(K_OR);
				setState(955);
				match(K_ROLLBACK);
				}
				break;
			case 2:
				{
				setState(956);
				match(K_OR);
				setState(957);
				match(K_ABORT);
				}
				break;
			case 3:
				{
				setState(958);
				match(K_OR);
				setState(959);
				match(K_REPLACE);
				}
				break;
			case 4:
				{
				setState(960);
				match(K_OR);
				setState(961);
				match(K_FAIL);
				}
				break;
			case 5:
				{
				setState(962);
				match(K_OR);
				setState(963);
				match(K_IGNORE);
				}
				break;
			}
			setState(966);
			qualified_table_name();
			setState(967);
			match(K_SET);
			setState(968);
			column_name();
			setState(969);
			match(ASSIGN);
			setState(970);
			expr(0);
			setState(978);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(971);
				match(COMMA);
				setState(972);
				column_name();
				setState(973);
				match(ASSIGN);
				setState(974);
				expr(0);
				}
				}
				setState(980);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(983);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==K_WHERE) {
				{
				setState(981);
				match(K_WHERE);
				setState(982);
				expr(0);
				}
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
	public static class Update_stmt_limitedContext extends ParserRuleContext {
		public TerminalNode K_UPDATE() { return getToken(SQLParser.K_UPDATE, 0); }
		public Qualified_table_nameContext qualified_table_name() {
			return getRuleContext(Qualified_table_nameContext.class,0);
		}
		public TerminalNode K_SET() { return getToken(SQLParser.K_SET, 0); }
		public List<Column_nameContext> column_name() {
			return getRuleContexts(Column_nameContext.class);
		}
		public Column_nameContext column_name(int i) {
			return getRuleContext(Column_nameContext.class,i);
		}
		public List<TerminalNode> ASSIGN() { return getTokens(SQLParser.ASSIGN); }
		public TerminalNode ASSIGN(int i) {
			return getToken(SQLParser.ASSIGN, i);
		}
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public With_clauseContext with_clause() {
			return getRuleContext(With_clauseContext.class,0);
		}
		public TerminalNode K_OR() { return getToken(SQLParser.K_OR, 0); }
		public TerminalNode K_ROLLBACK() { return getToken(SQLParser.K_ROLLBACK, 0); }
		public TerminalNode K_ABORT() { return getToken(SQLParser.K_ABORT, 0); }
		public TerminalNode K_REPLACE() { return getToken(SQLParser.K_REPLACE, 0); }
		public TerminalNode K_FAIL() { return getToken(SQLParser.K_FAIL, 0); }
		public TerminalNode K_IGNORE() { return getToken(SQLParser.K_IGNORE, 0); }
		public List<TerminalNode> COMMA() { return getTokens(SQLParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(SQLParser.COMMA, i);
		}
		public TerminalNode K_WHERE() { return getToken(SQLParser.K_WHERE, 0); }
		public TerminalNode K_LIMIT() { return getToken(SQLParser.K_LIMIT, 0); }
		public TerminalNode K_ORDER() { return getToken(SQLParser.K_ORDER, 0); }
		public TerminalNode K_BY() { return getToken(SQLParser.K_BY, 0); }
		public List<Ordering_termContext> ordering_term() {
			return getRuleContexts(Ordering_termContext.class);
		}
		public Ordering_termContext ordering_term(int i) {
			return getRuleContext(Ordering_termContext.class,i);
		}
		public TerminalNode K_OFFSET() { return getToken(SQLParser.K_OFFSET, 0); }
		public Update_stmt_limitedContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_update_stmt_limited; }
	}

	public final Update_stmt_limitedContext update_stmt_limited() throws RecognitionException {
		Update_stmt_limitedContext _localctx = new Update_stmt_limitedContext(_ctx, getState());
		enterRule(_localctx, 66, RULE_update_stmt_limited);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(986);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==K_WITH) {
				{
				setState(985);
				with_clause();
				}
			}

			setState(988);
			match(K_UPDATE);
			setState(999);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,137,_ctx) ) {
			case 1:
				{
				setState(989);
				match(K_OR);
				setState(990);
				match(K_ROLLBACK);
				}
				break;
			case 2:
				{
				setState(991);
				match(K_OR);
				setState(992);
				match(K_ABORT);
				}
				break;
			case 3:
				{
				setState(993);
				match(K_OR);
				setState(994);
				match(K_REPLACE);
				}
				break;
			case 4:
				{
				setState(995);
				match(K_OR);
				setState(996);
				match(K_FAIL);
				}
				break;
			case 5:
				{
				setState(997);
				match(K_OR);
				setState(998);
				match(K_IGNORE);
				}
				break;
			}
			setState(1001);
			qualified_table_name();
			setState(1002);
			match(K_SET);
			setState(1003);
			column_name();
			setState(1004);
			match(ASSIGN);
			setState(1005);
			expr(0);
			setState(1013);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(1006);
				match(COMMA);
				setState(1007);
				column_name();
				setState(1008);
				match(ASSIGN);
				setState(1009);
				expr(0);
				}
				}
				setState(1015);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(1018);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==K_WHERE) {
				{
				setState(1016);
				match(K_WHERE);
				setState(1017);
				expr(0);
				}
			}

			setState(1038);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==K_LIMIT || _la==K_ORDER) {
				{
				setState(1030);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==K_ORDER) {
					{
					setState(1020);
					match(K_ORDER);
					setState(1021);
					match(K_BY);
					setState(1022);
					ordering_term();
					setState(1027);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==COMMA) {
						{
						{
						setState(1023);
						match(COMMA);
						setState(1024);
						ordering_term();
						}
						}
						setState(1029);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(1032);
				match(K_LIMIT);
				setState(1033);
				expr(0);
				setState(1036);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==COMMA || _la==K_OFFSET) {
					{
					setState(1034);
					_la = _input.LA(1);
					if ( !(_la==COMMA || _la==K_OFFSET) ) {
					_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					setState(1035);
					expr(0);
					}
				}

				}
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
	public static class Vacuum_stmtContext extends ParserRuleContext {
		public TerminalNode K_VACUUM() { return getToken(SQLParser.K_VACUUM, 0); }
		public Vacuum_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_vacuum_stmt; }
	}

	public final Vacuum_stmtContext vacuum_stmt() throws RecognitionException {
		Vacuum_stmtContext _localctx = new Vacuum_stmtContext(_ctx, getState());
		enterRule(_localctx, 68, RULE_vacuum_stmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1040);
			match(K_VACUUM);
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
	public static class Column_defContext extends ParserRuleContext {
		public Column_nameContext column_name() {
			return getRuleContext(Column_nameContext.class,0);
		}
		public Type_nameContext type_name() {
			return getRuleContext(Type_nameContext.class,0);
		}
		public List<Column_constraintContext> column_constraint() {
			return getRuleContexts(Column_constraintContext.class);
		}
		public Column_constraintContext column_constraint(int i) {
			return getRuleContext(Column_constraintContext.class,i);
		}
		public Column_defContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_column_def; }
	}

	public final Column_defContext column_def() throws RecognitionException {
		Column_defContext _localctx = new Column_defContext(_ctx, getState());
		enterRule(_localctx, 70, RULE_column_def);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1042);
			column_name();
			setState(1044);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,144,_ctx) ) {
			case 1:
				{
				setState(1043);
				type_name();
				}
				break;
			}
			setState(1049);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 72673320549482496L) != 0) || ((((_la - 102)) & ~0x3f) == 0 && ((1L << (_la - 102)) & 68719511557L) != 0)) {
				{
				{
				setState(1046);
				column_constraint();
				}
				}
				setState(1051);
				_errHandler.sync(this);
				_la = _input.LA(1);
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
	public static class Type_nameContext extends ParserRuleContext {
		public List<NameContext> name() {
			return getRuleContexts(NameContext.class);
		}
		public NameContext name(int i) {
			return getRuleContext(NameContext.class,i);
		}
		public TerminalNode OPEN_PAR() { return getToken(SQLParser.OPEN_PAR, 0); }
		public List<Signed_numberContext> signed_number() {
			return getRuleContexts(Signed_numberContext.class);
		}
		public Signed_numberContext signed_number(int i) {
			return getRuleContext(Signed_numberContext.class,i);
		}
		public TerminalNode CLOSE_PAR() { return getToken(SQLParser.CLOSE_PAR, 0); }
		public TerminalNode COMMA() { return getToken(SQLParser.COMMA, 0); }
		public Type_nameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type_name; }
	}

	public final Type_nameContext type_name() throws RecognitionException {
		Type_nameContext _localctx = new Type_nameContext(_ctx, getState());
		enterRule(_localctx, 72, RULE_type_name);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(1053); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(1052);
					name();
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(1055); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,146,_ctx);
			} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
			setState(1067);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,147,_ctx) ) {
			case 1:
				{
				setState(1057);
				match(OPEN_PAR);
				setState(1058);
				signed_number();
				setState(1059);
				match(CLOSE_PAR);
				}
				break;
			case 2:
				{
				setState(1061);
				match(OPEN_PAR);
				setState(1062);
				signed_number();
				setState(1063);
				match(COMMA);
				setState(1064);
				signed_number();
				setState(1065);
				match(CLOSE_PAR);
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
	public static class Column_constraintContext extends ParserRuleContext {
		public TerminalNode K_PRIMARY() { return getToken(SQLParser.K_PRIMARY, 0); }
		public TerminalNode K_KEY() { return getToken(SQLParser.K_KEY, 0); }
		public Conflict_clauseContext conflict_clause() {
			return getRuleContext(Conflict_clauseContext.class,0);
		}
		public TerminalNode K_NULL() { return getToken(SQLParser.K_NULL, 0); }
		public TerminalNode K_UNIQUE() { return getToken(SQLParser.K_UNIQUE, 0); }
		public TerminalNode K_CHECK() { return getToken(SQLParser.K_CHECK, 0); }
		public TerminalNode OPEN_PAR() { return getToken(SQLParser.OPEN_PAR, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode CLOSE_PAR() { return getToken(SQLParser.CLOSE_PAR, 0); }
		public TerminalNode K_DEFAULT() { return getToken(SQLParser.K_DEFAULT, 0); }
		public TerminalNode K_COLLATE() { return getToken(SQLParser.K_COLLATE, 0); }
		public Collation_nameContext collation_name() {
			return getRuleContext(Collation_nameContext.class,0);
		}
		public Foreign_key_clauseContext foreign_key_clause() {
			return getRuleContext(Foreign_key_clauseContext.class,0);
		}
		public TerminalNode K_CONSTRAINT() { return getToken(SQLParser.K_CONSTRAINT, 0); }
		public NameContext name() {
			return getRuleContext(NameContext.class,0);
		}
		public Signed_numberContext signed_number() {
			return getRuleContext(Signed_numberContext.class,0);
		}
		public Literal_valueContext literal_value() {
			return getRuleContext(Literal_valueContext.class,0);
		}
		public TerminalNode K_AUTOINCREMENT() { return getToken(SQLParser.K_AUTOINCREMENT, 0); }
		public TerminalNode K_NOT() { return getToken(SQLParser.K_NOT, 0); }
		public TerminalNode K_ASC() { return getToken(SQLParser.K_ASC, 0); }
		public TerminalNode K_DESC() { return getToken(SQLParser.K_DESC, 0); }
		public Column_constraintContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_column_constraint; }
	}

	public final Column_constraintContext column_constraint() throws RecognitionException {
		Column_constraintContext _localctx = new Column_constraintContext(_ctx, getState());
		enterRule(_localctx, 74, RULE_column_constraint);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1071);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==K_CONSTRAINT) {
				{
				setState(1069);
				match(K_CONSTRAINT);
				setState(1070);
				name();
				}
			}

			setState(1106);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case K_PRIMARY:
				{
				setState(1073);
				match(K_PRIMARY);
				setState(1074);
				match(K_KEY);
				setState(1076);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==K_ASC || _la==K_DESC) {
					{
					setState(1075);
					_la = _input.LA(1);
					if ( !(_la==K_ASC || _la==K_DESC) ) {
					_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					}
				}

				setState(1078);
				conflict_clause();
				setState(1080);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==K_AUTOINCREMENT) {
					{
					setState(1079);
					match(K_AUTOINCREMENT);
					}
				}

				}
				break;
			case K_NOT:
			case K_NULL:
				{
				setState(1083);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==K_NOT) {
					{
					setState(1082);
					match(K_NOT);
					}
				}

				setState(1085);
				match(K_NULL);
				setState(1086);
				conflict_clause();
				}
				break;
			case K_UNIQUE:
				{
				setState(1087);
				match(K_UNIQUE);
				setState(1088);
				conflict_clause();
				}
				break;
			case K_CHECK:
				{
				setState(1089);
				match(K_CHECK);
				setState(1090);
				match(OPEN_PAR);
				setState(1091);
				expr(0);
				setState(1092);
				match(CLOSE_PAR);
				}
				break;
			case K_DEFAULT:
				{
				setState(1094);
				match(K_DEFAULT);
				setState(1101);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,152,_ctx) ) {
				case 1:
					{
					setState(1095);
					signed_number();
					}
					break;
				case 2:
					{
					setState(1096);
					literal_value();
					}
					break;
				case 3:
					{
					setState(1097);
					match(OPEN_PAR);
					setState(1098);
					expr(0);
					setState(1099);
					match(CLOSE_PAR);
					}
					break;
				}
				}
				break;
			case K_COLLATE:
				{
				setState(1103);
				match(K_COLLATE);
				setState(1104);
				collation_name();
				}
				break;
			case K_REFERENCES:
				{
				setState(1105);
				foreign_key_clause();
				}
				break;
			default:
				throw new NoViableAltException(this);
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
	public static class Conflict_clauseContext extends ParserRuleContext {
		public TerminalNode K_ON() { return getToken(SQLParser.K_ON, 0); }
		public TerminalNode K_CONFLICT() { return getToken(SQLParser.K_CONFLICT, 0); }
		public TerminalNode K_ROLLBACK() { return getToken(SQLParser.K_ROLLBACK, 0); }
		public TerminalNode K_ABORT() { return getToken(SQLParser.K_ABORT, 0); }
		public TerminalNode K_FAIL() { return getToken(SQLParser.K_FAIL, 0); }
		public TerminalNode K_IGNORE() { return getToken(SQLParser.K_IGNORE, 0); }
		public TerminalNode K_REPLACE() { return getToken(SQLParser.K_REPLACE, 0); }
		public Conflict_clauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_conflict_clause; }
	}

	public final Conflict_clauseContext conflict_clause() throws RecognitionException {
		Conflict_clauseContext _localctx = new Conflict_clauseContext(_ctx, getState());
		enterRule(_localctx, 76, RULE_conflict_clause);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1111);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==K_ON) {
				{
				setState(1108);
				match(K_ON);
				setState(1109);
				match(K_CONFLICT);
				setState(1110);
				_la = _input.LA(1);
				if ( !(_la==K_ABORT || ((((_la - 72)) & ~0x3f) == 0 && ((1L << (_la - 72)) & 10133099161584129L) != 0)) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				}
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
	public static class ExprContext extends ParserRuleContext {
		public Literal_valueContext literal_value() {
			return getRuleContext(Literal_valueContext.class,0);
		}
		public TerminalNode BIND_PARAMETER() { return getToken(SQLParser.BIND_PARAMETER, 0); }
		public Column_nameContext column_name() {
			return getRuleContext(Column_nameContext.class,0);
		}
		public Table_nameContext table_name() {
			return getRuleContext(Table_nameContext.class,0);
		}
		public List<TerminalNode> DOT() { return getTokens(SQLParser.DOT); }
		public TerminalNode DOT(int i) {
			return getToken(SQLParser.DOT, i);
		}
		public Database_nameContext database_name() {
			return getRuleContext(Database_nameContext.class,0);
		}
		public Unary_operatorContext unary_operator() {
			return getRuleContext(Unary_operatorContext.class,0);
		}
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public Function_nameContext function_name() {
			return getRuleContext(Function_nameContext.class,0);
		}
		public TerminalNode OPEN_PAR() { return getToken(SQLParser.OPEN_PAR, 0); }
		public TerminalNode CLOSE_PAR() { return getToken(SQLParser.CLOSE_PAR, 0); }
		public TerminalNode STAR() { return getToken(SQLParser.STAR, 0); }
		public TerminalNode K_DISTINCT() { return getToken(SQLParser.K_DISTINCT, 0); }
		public List<TerminalNode> COMMA() { return getTokens(SQLParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(SQLParser.COMMA, i);
		}
		public TerminalNode K_CAST() { return getToken(SQLParser.K_CAST, 0); }
		public TerminalNode K_AS() { return getToken(SQLParser.K_AS, 0); }
		public Type_nameContext type_name() {
			return getRuleContext(Type_nameContext.class,0);
		}
		public Select_stmtContext select_stmt() {
			return getRuleContext(Select_stmtContext.class,0);
		}
		public TerminalNode K_EXISTS() { return getToken(SQLParser.K_EXISTS, 0); }
		public TerminalNode K_NOT() { return getToken(SQLParser.K_NOT, 0); }
		public TerminalNode K_CASE() { return getToken(SQLParser.K_CASE, 0); }
		public TerminalNode K_END() { return getToken(SQLParser.K_END, 0); }
		public List<TerminalNode> K_WHEN() { return getTokens(SQLParser.K_WHEN); }
		public TerminalNode K_WHEN(int i) {
			return getToken(SQLParser.K_WHEN, i);
		}
		public List<TerminalNode> K_THEN() { return getTokens(SQLParser.K_THEN); }
		public TerminalNode K_THEN(int i) {
			return getToken(SQLParser.K_THEN, i);
		}
		public TerminalNode K_ELSE() { return getToken(SQLParser.K_ELSE, 0); }
		public Raise_functionContext raise_function() {
			return getRuleContext(Raise_functionContext.class,0);
		}
		public TerminalNode PIPE2() { return getToken(SQLParser.PIPE2, 0); }
		public TerminalNode DIV() { return getToken(SQLParser.DIV, 0); }
		public TerminalNode MOD() { return getToken(SQLParser.MOD, 0); }
		public TerminalNode PLUS() { return getToken(SQLParser.PLUS, 0); }
		public TerminalNode MINUS() { return getToken(SQLParser.MINUS, 0); }
		public TerminalNode LT2() { return getToken(SQLParser.LT2, 0); }
		public TerminalNode GT2() { return getToken(SQLParser.GT2, 0); }
		public TerminalNode AMP() { return getToken(SQLParser.AMP, 0); }
		public TerminalNode PIPE() { return getToken(SQLParser.PIPE, 0); }
		public TerminalNode LT() { return getToken(SQLParser.LT, 0); }
		public TerminalNode LT_EQ() { return getToken(SQLParser.LT_EQ, 0); }
		public TerminalNode GT() { return getToken(SQLParser.GT, 0); }
		public TerminalNode GT_EQ() { return getToken(SQLParser.GT_EQ, 0); }
		public TerminalNode ASSIGN() { return getToken(SQLParser.ASSIGN, 0); }
		public TerminalNode EQ() { return getToken(SQLParser.EQ, 0); }
		public TerminalNode NOT_EQ1() { return getToken(SQLParser.NOT_EQ1, 0); }
		public TerminalNode NOT_EQ2() { return getToken(SQLParser.NOT_EQ2, 0); }
		public TerminalNode K_IS() { return getToken(SQLParser.K_IS, 0); }
		public TerminalNode K_IN() { return getToken(SQLParser.K_IN, 0); }
		public TerminalNode K_LIKE() { return getToken(SQLParser.K_LIKE, 0); }
		public TerminalNode K_GLOB() { return getToken(SQLParser.K_GLOB, 0); }
		public TerminalNode K_MATCH() { return getToken(SQLParser.K_MATCH, 0); }
		public TerminalNode K_REGEXP() { return getToken(SQLParser.K_REGEXP, 0); }
		public TerminalNode K_AND() { return getToken(SQLParser.K_AND, 0); }
		public TerminalNode K_OR() { return getToken(SQLParser.K_OR, 0); }
		public TerminalNode K_BETWEEN() { return getToken(SQLParser.K_BETWEEN, 0); }
		public TerminalNode K_COLLATE() { return getToken(SQLParser.K_COLLATE, 0); }
		public Collation_nameContext collation_name() {
			return getRuleContext(Collation_nameContext.class,0);
		}
		public TerminalNode K_ESCAPE() { return getToken(SQLParser.K_ESCAPE, 0); }
		public TerminalNode K_ISNULL() { return getToken(SQLParser.K_ISNULL, 0); }
		public TerminalNode K_NOTNULL() { return getToken(SQLParser.K_NOTNULL, 0); }
		public TerminalNode K_NULL() { return getToken(SQLParser.K_NULL, 0); }
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
	}

	public final ExprContext expr() throws RecognitionException {
		return expr(0);
	}

	private ExprContext expr(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExprContext _localctx = new ExprContext(_ctx, _parentState);
		ExprContext _prevctx = _localctx;
		int _startState = 78;
		enterRecursionRule(_localctx, 78, RULE_expr, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(1189);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,165,_ctx) ) {
			case 1:
				{
				setState(1114);
				literal_value();
				}
				break;
			case 2:
				{
				setState(1115);
				match(BIND_PARAMETER);
				}
				break;
			case 3:
				{
				setState(1124);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,156,_ctx) ) {
				case 1:
					{
					setState(1119);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,155,_ctx) ) {
					case 1:
						{
						setState(1116);
						database_name();
						setState(1117);
						match(DOT);
						}
						break;
					}
					setState(1121);
					table_name();
					setState(1122);
					match(DOT);
					}
					break;
				}
				setState(1126);
				column_name();
				}
				break;
			case 4:
				{
				setState(1127);
				unary_operator();
				setState(1128);
				expr(21);
				}
				break;
			case 5:
				{
				setState(1130);
				function_name();
				setState(1131);
				match(OPEN_PAR);
				setState(1144);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case OPEN_PAR:
				case PLUS:
				case MINUS:
				case TILDE:
				case K_ABORT:
				case K_ACTION:
				case K_ADD:
				case K_AFTER:
				case K_ALL:
				case K_ALTER:
				case K_ANALYZE:
				case K_AND:
				case K_AS:
				case K_ASC:
				case K_ATTACH:
				case K_AUTOINCREMENT:
				case K_BEFORE:
				case K_BEGIN:
				case K_BETWEEN:
				case K_BY:
				case K_CASCADE:
				case K_CASE:
				case K_CAST:
				case K_CHECK:
				case K_COLLATE:
				case K_COLUMN:
				case K_COMMIT:
				case K_CONFLICT:
				case K_CONSTRAINT:
				case K_CREATE:
				case K_CROSS:
				case K_CURRENT_DATE:
				case K_CURRENT_TIME:
				case K_CURRENT_TIMESTAMP:
				case K_DATABASE:
				case K_DEFAULT:
				case K_DEFERRABLE:
				case K_DEFERRED:
				case K_DELETE:
				case K_DESC:
				case K_DETACH:
				case K_DISTINCT:
				case K_DROP:
				case K_EACH:
				case K_ELSE:
				case K_END:
				case K_ESCAPE:
				case K_EXCEPT:
				case K_EXCLUSIVE:
				case K_EXISTS:
				case K_EXPLAIN:
				case K_FAIL:
				case K_FOR:
				case K_FOREIGN:
				case K_FROM:
				case K_FULL:
				case K_GLOB:
				case K_GROUP:
				case K_HAVING:
				case K_IF:
				case K_IGNORE:
				case K_IMMEDIATE:
				case K_IN:
				case K_INDEX:
				case K_INDEXED:
				case K_INITIALLY:
				case K_INNER:
				case K_INSERT:
				case K_INSTEAD:
				case K_INTERSECT:
				case K_INTO:
				case K_IS:
				case K_ISNULL:
				case K_JOIN:
				case K_KEY:
				case K_LEFT:
				case K_LIKE:
				case K_LIMIT:
				case K_MATCH:
				case K_NATURAL:
				case K_NO:
				case K_NOT:
				case K_NOTNULL:
				case K_NULL:
				case K_OF:
				case K_OFFSET:
				case K_ON:
				case K_OR:
				case K_ORDER:
				case K_OUTER:
				case K_PLAN:
				case K_PRAGMA:
				case K_PRIMARY:
				case K_QUERY:
				case K_RAISE:
				case K_RECURSIVE:
				case K_REFERENCES:
				case K_REGEXP:
				case K_REINDEX:
				case K_RELEASE:
				case K_RENAME:
				case K_REPLACE:
				case K_RESTRICT:
				case K_RIGHT:
				case K_ROLLBACK:
				case K_ROW:
				case K_SAVEPOINT:
				case K_SELECT:
				case K_SET:
				case K_TABLE:
				case K_TEMP:
				case K_TEMPORARY:
				case K_THEN:
				case K_TO:
				case K_TRANSACTION:
				case K_TRIGGER:
				case K_UNION:
				case K_UNIQUE:
				case K_UPDATE:
				case K_USING:
				case K_VACUUM:
				case K_VALUES:
				case K_VIEW:
				case K_VIRTUAL:
				case K_WHEN:
				case K_WHERE:
				case K_WITH:
				case K_WITHOUT:
				case IDENTIFIER:
				case NUMERIC_LITERAL:
				case BIND_PARAMETER:
				case STRING_LITERAL:
				case BLOB_LITERAL:
					{
					setState(1133);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,157,_ctx) ) {
					case 1:
						{
						setState(1132);
						match(K_DISTINCT);
						}
						break;
					}
					setState(1135);
					expr(0);
					setState(1140);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==COMMA) {
						{
						{
						setState(1136);
						match(COMMA);
						setState(1137);
						expr(0);
						}
						}
						setState(1142);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
					break;
				case STAR:
					{
					setState(1143);
					match(STAR);
					}
					break;
				case CLOSE_PAR:
					break;
				default:
					break;
				}
				setState(1146);
				match(CLOSE_PAR);
				}
				break;
			case 6:
				{
				setState(1148);
				match(OPEN_PAR);
				setState(1149);
				expr(0);
				setState(1150);
				match(CLOSE_PAR);
				}
				break;
			case 7:
				{
				setState(1152);
				match(K_CAST);
				setState(1153);
				match(OPEN_PAR);
				setState(1154);
				expr(0);
				setState(1155);
				match(K_AS);
				setState(1156);
				type_name();
				setState(1157);
				match(CLOSE_PAR);
				}
				break;
			case 8:
				{
				setState(1163);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==K_EXISTS || _la==K_NOT) {
					{
					setState(1160);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==K_NOT) {
						{
						setState(1159);
						match(K_NOT);
						}
					}

					setState(1162);
					match(K_EXISTS);
					}
				}

				setState(1165);
				match(OPEN_PAR);
				setState(1166);
				select_stmt();
				setState(1167);
				match(CLOSE_PAR);
				}
				break;
			case 9:
				{
				setState(1169);
				match(K_CASE);
				setState(1171);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,162,_ctx) ) {
				case 1:
					{
					setState(1170);
					expr(0);
					}
					break;
				}
				setState(1178); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(1173);
					match(K_WHEN);
					setState(1174);
					expr(0);
					setState(1175);
					match(K_THEN);
					setState(1176);
					expr(0);
					}
					}
					setState(1180); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==K_WHEN );
				setState(1184);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==K_ELSE) {
					{
					setState(1182);
					match(K_ELSE);
					setState(1183);
					expr(0);
					}
				}

				setState(1186);
				match(K_END);
				}
				break;
			case 10:
				{
				setState(1188);
				raise_function();
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(1291);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,178,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(1289);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,177,_ctx) ) {
					case 1:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(1191);
						if (!(precpred(_ctx, 20))) throw new FailedPredicateException(this, "precpred(_ctx, 20)");
						setState(1192);
						match(PIPE2);
						setState(1193);
						expr(21);
						}
						break;
					case 2:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(1194);
						if (!(precpred(_ctx, 19))) throw new FailedPredicateException(this, "precpred(_ctx, 19)");
						setState(1195);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 12416L) != 0)) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(1196);
						expr(20);
						}
						break;
					case 3:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(1197);
						if (!(precpred(_ctx, 18))) throw new FailedPredicateException(this, "precpred(_ctx, 18)");
						setState(1198);
						_la = _input.LA(1);
						if ( !(_la==PLUS || _la==MINUS) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(1199);
						expr(19);
						}
						break;
					case 4:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(1200);
						if (!(precpred(_ctx, 17))) throw new FailedPredicateException(this, "precpred(_ctx, 17)");
						setState(1201);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 245760L) != 0)) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(1202);
						expr(18);
						}
						break;
					case 5:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(1203);
						if (!(precpred(_ctx, 16))) throw new FailedPredicateException(this, "precpred(_ctx, 16)");
						setState(1204);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 3932160L) != 0)) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(1205);
						expr(17);
						}
						break;
					case 6:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(1206);
						if (!(precpred(_ctx, 15))) throw new FailedPredicateException(this, "precpred(_ctx, 15)");
						setState(1219);
						_errHandler.sync(this);
						switch ( getInterpreter().adaptivePredict(_input,166,_ctx) ) {
						case 1:
							{
							setState(1207);
							match(ASSIGN);
							}
							break;
						case 2:
							{
							setState(1208);
							match(EQ);
							}
							break;
						case 3:
							{
							setState(1209);
							match(NOT_EQ1);
							}
							break;
						case 4:
							{
							setState(1210);
							match(NOT_EQ2);
							}
							break;
						case 5:
							{
							setState(1211);
							match(K_IS);
							}
							break;
						case 6:
							{
							setState(1212);
							match(K_IS);
							setState(1213);
							match(K_NOT);
							}
							break;
						case 7:
							{
							setState(1214);
							match(K_IN);
							}
							break;
						case 8:
							{
							setState(1215);
							match(K_LIKE);
							}
							break;
						case 9:
							{
							setState(1216);
							match(K_GLOB);
							}
							break;
						case 10:
							{
							setState(1217);
							match(K_MATCH);
							}
							break;
						case 11:
							{
							setState(1218);
							match(K_REGEXP);
							}
							break;
						}
						setState(1221);
						expr(16);
						}
						break;
					case 7:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(1222);
						if (!(precpred(_ctx, 14))) throw new FailedPredicateException(this, "precpred(_ctx, 14)");
						setState(1223);
						match(K_AND);
						setState(1224);
						expr(15);
						}
						break;
					case 8:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(1225);
						if (!(precpred(_ctx, 13))) throw new FailedPredicateException(this, "precpred(_ctx, 13)");
						setState(1226);
						match(K_OR);
						setState(1227);
						expr(14);
						}
						break;
					case 9:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(1228);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(1229);
						match(K_IS);
						setState(1231);
						_errHandler.sync(this);
						switch ( getInterpreter().adaptivePredict(_input,167,_ctx) ) {
						case 1:
							{
							setState(1230);
							match(K_NOT);
							}
							break;
						}
						setState(1233);
						expr(7);
						}
						break;
					case 10:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(1234);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(1236);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if (_la==K_NOT) {
							{
							setState(1235);
							match(K_NOT);
							}
						}

						setState(1238);
						match(K_BETWEEN);
						setState(1239);
						expr(0);
						setState(1240);
						match(K_AND);
						setState(1241);
						expr(6);
						}
						break;
					case 11:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(1243);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(1244);
						match(K_COLLATE);
						setState(1245);
						collation_name();
						}
						break;
					case 12:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(1246);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(1248);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if (_la==K_NOT) {
							{
							setState(1247);
							match(K_NOT);
							}
						}

						setState(1250);
						_la = _input.LA(1);
						if ( !(((((_la - 77)) & ~0x3f) == 0 && ((1L << (_la - 77)) & 2199028498433L) != 0)) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(1251);
						expr(0);
						setState(1254);
						_errHandler.sync(this);
						switch ( getInterpreter().adaptivePredict(_input,170,_ctx) ) {
						case 1:
							{
							setState(1252);
							match(K_ESCAPE);
							setState(1253);
							expr(0);
							}
							break;
						}
						}
						break;
					case 13:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(1256);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(1261);
						_errHandler.sync(this);
						switch (_input.LA(1)) {
						case K_ISNULL:
							{
							setState(1257);
							match(K_ISNULL);
							}
							break;
						case K_NOTNULL:
							{
							setState(1258);
							match(K_NOTNULL);
							}
							break;
						case K_NOT:
							{
							setState(1259);
							match(K_NOT);
							setState(1260);
							match(K_NULL);
							}
							break;
						default:
							throw new NoViableAltException(this);
						}
						}
						break;
					case 14:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(1263);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(1265);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if (_la==K_NOT) {
							{
							setState(1264);
							match(K_NOT);
							}
						}

						setState(1267);
						match(K_IN);
						setState(1287);
						_errHandler.sync(this);
						switch ( getInterpreter().adaptivePredict(_input,176,_ctx) ) {
						case 1:
							{
							setState(1268);
							match(OPEN_PAR);
							setState(1278);
							_errHandler.sync(this);
							switch ( getInterpreter().adaptivePredict(_input,174,_ctx) ) {
							case 1:
								{
								setState(1269);
								select_stmt();
								}
								break;
							case 2:
								{
								setState(1270);
								expr(0);
								setState(1275);
								_errHandler.sync(this);
								_la = _input.LA(1);
								while (_la==COMMA) {
									{
									{
									setState(1271);
									match(COMMA);
									setState(1272);
									expr(0);
									}
									}
									setState(1277);
									_errHandler.sync(this);
									_la = _input.LA(1);
								}
								}
								break;
							}
							setState(1280);
							match(CLOSE_PAR);
							}
							break;
						case 2:
							{
							setState(1284);
							_errHandler.sync(this);
							switch ( getInterpreter().adaptivePredict(_input,175,_ctx) ) {
							case 1:
								{
								setState(1281);
								database_name();
								setState(1282);
								match(DOT);
								}
								break;
							}
							setState(1286);
							table_name();
							}
							break;
						}
						}
						break;
					}
					} 
				}
				setState(1293);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,178,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Foreign_key_clauseContext extends ParserRuleContext {
		public TerminalNode K_REFERENCES() { return getToken(SQLParser.K_REFERENCES, 0); }
		public Foreign_tableContext foreign_table() {
			return getRuleContext(Foreign_tableContext.class,0);
		}
		public TerminalNode OPEN_PAR() { return getToken(SQLParser.OPEN_PAR, 0); }
		public List<Column_nameContext> column_name() {
			return getRuleContexts(Column_nameContext.class);
		}
		public Column_nameContext column_name(int i) {
			return getRuleContext(Column_nameContext.class,i);
		}
		public TerminalNode CLOSE_PAR() { return getToken(SQLParser.CLOSE_PAR, 0); }
		public TerminalNode K_DEFERRABLE() { return getToken(SQLParser.K_DEFERRABLE, 0); }
		public List<TerminalNode> K_ON() { return getTokens(SQLParser.K_ON); }
		public TerminalNode K_ON(int i) {
			return getToken(SQLParser.K_ON, i);
		}
		public List<TerminalNode> K_MATCH() { return getTokens(SQLParser.K_MATCH); }
		public TerminalNode K_MATCH(int i) {
			return getToken(SQLParser.K_MATCH, i);
		}
		public List<NameContext> name() {
			return getRuleContexts(NameContext.class);
		}
		public NameContext name(int i) {
			return getRuleContext(NameContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(SQLParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(SQLParser.COMMA, i);
		}
		public List<TerminalNode> K_DELETE() { return getTokens(SQLParser.K_DELETE); }
		public TerminalNode K_DELETE(int i) {
			return getToken(SQLParser.K_DELETE, i);
		}
		public List<TerminalNode> K_UPDATE() { return getTokens(SQLParser.K_UPDATE); }
		public TerminalNode K_UPDATE(int i) {
			return getToken(SQLParser.K_UPDATE, i);
		}
		public TerminalNode K_NOT() { return getToken(SQLParser.K_NOT, 0); }
		public TerminalNode K_INITIALLY() { return getToken(SQLParser.K_INITIALLY, 0); }
		public TerminalNode K_DEFERRED() { return getToken(SQLParser.K_DEFERRED, 0); }
		public TerminalNode K_IMMEDIATE() { return getToken(SQLParser.K_IMMEDIATE, 0); }
		public List<TerminalNode> K_SET() { return getTokens(SQLParser.K_SET); }
		public TerminalNode K_SET(int i) {
			return getToken(SQLParser.K_SET, i);
		}
		public List<TerminalNode> K_NULL() { return getTokens(SQLParser.K_NULL); }
		public TerminalNode K_NULL(int i) {
			return getToken(SQLParser.K_NULL, i);
		}
		public List<TerminalNode> K_DEFAULT() { return getTokens(SQLParser.K_DEFAULT); }
		public TerminalNode K_DEFAULT(int i) {
			return getToken(SQLParser.K_DEFAULT, i);
		}
		public List<TerminalNode> K_CASCADE() { return getTokens(SQLParser.K_CASCADE); }
		public TerminalNode K_CASCADE(int i) {
			return getToken(SQLParser.K_CASCADE, i);
		}
		public List<TerminalNode> K_RESTRICT() { return getTokens(SQLParser.K_RESTRICT); }
		public TerminalNode K_RESTRICT(int i) {
			return getToken(SQLParser.K_RESTRICT, i);
		}
		public List<TerminalNode> K_NO() { return getTokens(SQLParser.K_NO); }
		public TerminalNode K_NO(int i) {
			return getToken(SQLParser.K_NO, i);
		}
		public List<TerminalNode> K_ACTION() { return getTokens(SQLParser.K_ACTION); }
		public TerminalNode K_ACTION(int i) {
			return getToken(SQLParser.K_ACTION, i);
		}
		public Foreign_key_clauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_foreign_key_clause; }
	}

	public final Foreign_key_clauseContext foreign_key_clause() throws RecognitionException {
		Foreign_key_clauseContext _localctx = new Foreign_key_clauseContext(_ctx, getState());
		enterRule(_localctx, 80, RULE_foreign_key_clause);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1294);
			match(K_REFERENCES);
			setState(1295);
			foreign_table();
			setState(1307);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==OPEN_PAR) {
				{
				setState(1296);
				match(OPEN_PAR);
				setState(1297);
				column_name();
				setState(1302);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(1298);
					match(COMMA);
					setState(1299);
					column_name();
					}
					}
					setState(1304);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(1305);
				match(CLOSE_PAR);
				}
			}

			setState(1327);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==K_MATCH || _la==K_ON) {
				{
				{
				setState(1323);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case K_ON:
					{
					setState(1309);
					match(K_ON);
					setState(1310);
					_la = _input.LA(1);
					if ( !(_la==K_DELETE || _la==K_UPDATE) ) {
					_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					setState(1319);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,181,_ctx) ) {
					case 1:
						{
						setState(1311);
						match(K_SET);
						setState(1312);
						match(K_NULL);
						}
						break;
					case 2:
						{
						setState(1313);
						match(K_SET);
						setState(1314);
						match(K_DEFAULT);
						}
						break;
					case 3:
						{
						setState(1315);
						match(K_CASCADE);
						}
						break;
					case 4:
						{
						setState(1316);
						match(K_RESTRICT);
						}
						break;
					case 5:
						{
						setState(1317);
						match(K_NO);
						setState(1318);
						match(K_ACTION);
						}
						break;
					}
					}
					break;
				case K_MATCH:
					{
					setState(1321);
					match(K_MATCH);
					setState(1322);
					name();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				}
				setState(1329);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(1340);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,186,_ctx) ) {
			case 1:
				{
				setState(1331);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==K_NOT) {
					{
					setState(1330);
					match(K_NOT);
					}
				}

				setState(1333);
				match(K_DEFERRABLE);
				setState(1338);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,185,_ctx) ) {
				case 1:
					{
					setState(1334);
					match(K_INITIALLY);
					setState(1335);
					match(K_DEFERRED);
					}
					break;
				case 2:
					{
					setState(1336);
					match(K_INITIALLY);
					setState(1337);
					match(K_IMMEDIATE);
					}
					break;
				}
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
	public static class Raise_functionContext extends ParserRuleContext {
		public TerminalNode K_RAISE() { return getToken(SQLParser.K_RAISE, 0); }
		public TerminalNode OPEN_PAR() { return getToken(SQLParser.OPEN_PAR, 0); }
		public TerminalNode CLOSE_PAR() { return getToken(SQLParser.CLOSE_PAR, 0); }
		public TerminalNode K_IGNORE() { return getToken(SQLParser.K_IGNORE, 0); }
		public TerminalNode COMMA() { return getToken(SQLParser.COMMA, 0); }
		public Error_messageContext error_message() {
			return getRuleContext(Error_messageContext.class,0);
		}
		public TerminalNode K_ROLLBACK() { return getToken(SQLParser.K_ROLLBACK, 0); }
		public TerminalNode K_ABORT() { return getToken(SQLParser.K_ABORT, 0); }
		public TerminalNode K_FAIL() { return getToken(SQLParser.K_FAIL, 0); }
		public Raise_functionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_raise_function; }
	}

	public final Raise_functionContext raise_function() throws RecognitionException {
		Raise_functionContext _localctx = new Raise_functionContext(_ctx, getState());
		enterRule(_localctx, 82, RULE_raise_function);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1342);
			match(K_RAISE);
			setState(1343);
			match(OPEN_PAR);
			setState(1348);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case K_IGNORE:
				{
				setState(1344);
				match(K_IGNORE);
				}
				break;
			case K_ABORT:
			case K_FAIL:
			case K_ROLLBACK:
				{
				setState(1345);
				_la = _input.LA(1);
				if ( !(_la==K_ABORT || _la==K_FAIL || _la==K_ROLLBACK) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(1346);
				match(COMMA);
				setState(1347);
				error_message();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(1350);
			match(CLOSE_PAR);
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
	public static class Indexed_columnContext extends ParserRuleContext {
		public Column_nameContext column_name() {
			return getRuleContext(Column_nameContext.class,0);
		}
		public TerminalNode K_COLLATE() { return getToken(SQLParser.K_COLLATE, 0); }
		public Collation_nameContext collation_name() {
			return getRuleContext(Collation_nameContext.class,0);
		}
		public TerminalNode K_ASC() { return getToken(SQLParser.K_ASC, 0); }
		public TerminalNode K_DESC() { return getToken(SQLParser.K_DESC, 0); }
		public Indexed_columnContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_indexed_column; }
	}

	public final Indexed_columnContext indexed_column() throws RecognitionException {
		Indexed_columnContext _localctx = new Indexed_columnContext(_ctx, getState());
		enterRule(_localctx, 84, RULE_indexed_column);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1352);
			column_name();
			setState(1355);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==K_COLLATE) {
				{
				setState(1353);
				match(K_COLLATE);
				setState(1354);
				collation_name();
				}
			}

			setState(1358);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==K_ASC || _la==K_DESC) {
				{
				setState(1357);
				_la = _input.LA(1);
				if ( !(_la==K_ASC || _la==K_DESC) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				}
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
	public static class Table_constraintContext extends ParserRuleContext {
		public TerminalNode OPEN_PAR() { return getToken(SQLParser.OPEN_PAR, 0); }
		public List<Indexed_columnContext> indexed_column() {
			return getRuleContexts(Indexed_columnContext.class);
		}
		public Indexed_columnContext indexed_column(int i) {
			return getRuleContext(Indexed_columnContext.class,i);
		}
		public TerminalNode CLOSE_PAR() { return getToken(SQLParser.CLOSE_PAR, 0); }
		public Conflict_clauseContext conflict_clause() {
			return getRuleContext(Conflict_clauseContext.class,0);
		}
		public TerminalNode K_CHECK() { return getToken(SQLParser.K_CHECK, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode K_FOREIGN() { return getToken(SQLParser.K_FOREIGN, 0); }
		public TerminalNode K_KEY() { return getToken(SQLParser.K_KEY, 0); }
		public List<Column_nameContext> column_name() {
			return getRuleContexts(Column_nameContext.class);
		}
		public Column_nameContext column_name(int i) {
			return getRuleContext(Column_nameContext.class,i);
		}
		public Foreign_key_clauseContext foreign_key_clause() {
			return getRuleContext(Foreign_key_clauseContext.class,0);
		}
		public TerminalNode K_CONSTRAINT() { return getToken(SQLParser.K_CONSTRAINT, 0); }
		public NameContext name() {
			return getRuleContext(NameContext.class,0);
		}
		public TerminalNode K_PRIMARY() { return getToken(SQLParser.K_PRIMARY, 0); }
		public TerminalNode K_UNIQUE() { return getToken(SQLParser.K_UNIQUE, 0); }
		public List<TerminalNode> COMMA() { return getTokens(SQLParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(SQLParser.COMMA, i);
		}
		public Table_constraintContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_table_constraint; }
	}

	public final Table_constraintContext table_constraint() throws RecognitionException {
		Table_constraintContext _localctx = new Table_constraintContext(_ctx, getState());
		enterRule(_localctx, 86, RULE_table_constraint);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1362);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==K_CONSTRAINT) {
				{
				setState(1360);
				match(K_CONSTRAINT);
				setState(1361);
				name();
				}
			}

			setState(1400);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case K_PRIMARY:
			case K_UNIQUE:
				{
				setState(1367);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case K_PRIMARY:
					{
					setState(1364);
					match(K_PRIMARY);
					setState(1365);
					match(K_KEY);
					}
					break;
				case K_UNIQUE:
					{
					setState(1366);
					match(K_UNIQUE);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(1369);
				match(OPEN_PAR);
				setState(1370);
				indexed_column();
				setState(1375);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(1371);
					match(COMMA);
					setState(1372);
					indexed_column();
					}
					}
					setState(1377);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(1378);
				match(CLOSE_PAR);
				setState(1379);
				conflict_clause();
				}
				break;
			case K_CHECK:
				{
				setState(1381);
				match(K_CHECK);
				setState(1382);
				match(OPEN_PAR);
				setState(1383);
				expr(0);
				setState(1384);
				match(CLOSE_PAR);
				}
				break;
			case K_FOREIGN:
				{
				setState(1386);
				match(K_FOREIGN);
				setState(1387);
				match(K_KEY);
				setState(1388);
				match(OPEN_PAR);
				setState(1389);
				column_name();
				setState(1394);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(1390);
					match(COMMA);
					setState(1391);
					column_name();
					}
					}
					setState(1396);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(1397);
				match(CLOSE_PAR);
				setState(1398);
				foreign_key_clause();
				}
				break;
			default:
				throw new NoViableAltException(this);
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
	public static class With_clauseContext extends ParserRuleContext {
		public TerminalNode K_WITH() { return getToken(SQLParser.K_WITH, 0); }
		public List<Cte_table_nameContext> cte_table_name() {
			return getRuleContexts(Cte_table_nameContext.class);
		}
		public Cte_table_nameContext cte_table_name(int i) {
			return getRuleContext(Cte_table_nameContext.class,i);
		}
		public List<TerminalNode> K_AS() { return getTokens(SQLParser.K_AS); }
		public TerminalNode K_AS(int i) {
			return getToken(SQLParser.K_AS, i);
		}
		public List<TerminalNode> OPEN_PAR() { return getTokens(SQLParser.OPEN_PAR); }
		public TerminalNode OPEN_PAR(int i) {
			return getToken(SQLParser.OPEN_PAR, i);
		}
		public List<Select_stmtContext> select_stmt() {
			return getRuleContexts(Select_stmtContext.class);
		}
		public Select_stmtContext select_stmt(int i) {
			return getRuleContext(Select_stmtContext.class,i);
		}
		public List<TerminalNode> CLOSE_PAR() { return getTokens(SQLParser.CLOSE_PAR); }
		public TerminalNode CLOSE_PAR(int i) {
			return getToken(SQLParser.CLOSE_PAR, i);
		}
		public TerminalNode K_RECURSIVE() { return getToken(SQLParser.K_RECURSIVE, 0); }
		public List<TerminalNode> COMMA() { return getTokens(SQLParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(SQLParser.COMMA, i);
		}
		public With_clauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_with_clause; }
	}

	public final With_clauseContext with_clause() throws RecognitionException {
		With_clauseContext _localctx = new With_clauseContext(_ctx, getState());
		enterRule(_localctx, 88, RULE_with_clause);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1402);
			match(K_WITH);
			setState(1404);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,195,_ctx) ) {
			case 1:
				{
				setState(1403);
				match(K_RECURSIVE);
				}
				break;
			}
			setState(1406);
			cte_table_name();
			setState(1407);
			match(K_AS);
			setState(1408);
			match(OPEN_PAR);
			setState(1409);
			select_stmt();
			setState(1410);
			match(CLOSE_PAR);
			setState(1420);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(1411);
				match(COMMA);
				setState(1412);
				cte_table_name();
				setState(1413);
				match(K_AS);
				setState(1414);
				match(OPEN_PAR);
				setState(1415);
				select_stmt();
				setState(1416);
				match(CLOSE_PAR);
				}
				}
				setState(1422);
				_errHandler.sync(this);
				_la = _input.LA(1);
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
	public static class Qualified_table_nameContext extends ParserRuleContext {
		public Table_nameContext table_name() {
			return getRuleContext(Table_nameContext.class,0);
		}
		public Database_nameContext database_name() {
			return getRuleContext(Database_nameContext.class,0);
		}
		public TerminalNode DOT() { return getToken(SQLParser.DOT, 0); }
		public TerminalNode K_INDEXED() { return getToken(SQLParser.K_INDEXED, 0); }
		public TerminalNode K_BY() { return getToken(SQLParser.K_BY, 0); }
		public Index_nameContext index_name() {
			return getRuleContext(Index_nameContext.class,0);
		}
		public TerminalNode K_NOT() { return getToken(SQLParser.K_NOT, 0); }
		public Qualified_table_nameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_qualified_table_name; }
	}

	public final Qualified_table_nameContext qualified_table_name() throws RecognitionException {
		Qualified_table_nameContext _localctx = new Qualified_table_nameContext(_ctx, getState());
		enterRule(_localctx, 90, RULE_qualified_table_name);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1426);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,197,_ctx) ) {
			case 1:
				{
				setState(1423);
				database_name();
				setState(1424);
				match(DOT);
				}
				break;
			}
			setState(1428);
			table_name();
			setState(1434);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case K_INDEXED:
				{
				setState(1429);
				match(K_INDEXED);
				setState(1430);
				match(K_BY);
				setState(1431);
				index_name();
				}
				break;
			case K_NOT:
				{
				setState(1432);
				match(K_NOT);
				setState(1433);
				match(K_INDEXED);
				}
				break;
			case EOF:
			case SCOL:
			case K_ALTER:
			case K_ANALYZE:
			case K_ATTACH:
			case K_BEGIN:
			case K_COMMIT:
			case K_CREATE:
			case K_DELETE:
			case K_DETACH:
			case K_DROP:
			case K_END:
			case K_EXPLAIN:
			case K_INSERT:
			case K_LIMIT:
			case K_ORDER:
			case K_PRAGMA:
			case K_REINDEX:
			case K_RELEASE:
			case K_REPLACE:
			case K_ROLLBACK:
			case K_SAVEPOINT:
			case K_SELECT:
			case K_SET:
			case K_UPDATE:
			case K_VACUUM:
			case K_VALUES:
			case K_WHERE:
			case K_WITH:
			case UNEXPECTED_CHAR:
				break;
			default:
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
	public static class Ordering_termContext extends ParserRuleContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode K_COLLATE() { return getToken(SQLParser.K_COLLATE, 0); }
		public Collation_nameContext collation_name() {
			return getRuleContext(Collation_nameContext.class,0);
		}
		public TerminalNode K_ASC() { return getToken(SQLParser.K_ASC, 0); }
		public TerminalNode K_DESC() { return getToken(SQLParser.K_DESC, 0); }
		public Ordering_termContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ordering_term; }
	}

	public final Ordering_termContext ordering_term() throws RecognitionException {
		Ordering_termContext _localctx = new Ordering_termContext(_ctx, getState());
		enterRule(_localctx, 92, RULE_ordering_term);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1436);
			expr(0);
			setState(1439);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==K_COLLATE) {
				{
				setState(1437);
				match(K_COLLATE);
				setState(1438);
				collation_name();
				}
			}

			setState(1442);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==K_ASC || _la==K_DESC) {
				{
				setState(1441);
				_la = _input.LA(1);
				if ( !(_la==K_ASC || _la==K_DESC) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				}
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
	public static class Pragma_valueContext extends ParserRuleContext {
		public Signed_numberContext signed_number() {
			return getRuleContext(Signed_numberContext.class,0);
		}
		public NameContext name() {
			return getRuleContext(NameContext.class,0);
		}
		public TerminalNode STRING_LITERAL() { return getToken(SQLParser.STRING_LITERAL, 0); }
		public Pragma_valueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pragma_value; }
	}

	public final Pragma_valueContext pragma_value() throws RecognitionException {
		Pragma_valueContext _localctx = new Pragma_valueContext(_ctx, getState());
		enterRule(_localctx, 94, RULE_pragma_value);
		try {
			setState(1447);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,201,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1444);
				signed_number();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1445);
				name();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(1446);
				match(STRING_LITERAL);
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
	public static class Common_table_expressionContext extends ParserRuleContext {
		public Table_nameContext table_name() {
			return getRuleContext(Table_nameContext.class,0);
		}
		public TerminalNode K_AS() { return getToken(SQLParser.K_AS, 0); }
		public List<TerminalNode> OPEN_PAR() { return getTokens(SQLParser.OPEN_PAR); }
		public TerminalNode OPEN_PAR(int i) {
			return getToken(SQLParser.OPEN_PAR, i);
		}
		public Select_stmtContext select_stmt() {
			return getRuleContext(Select_stmtContext.class,0);
		}
		public List<TerminalNode> CLOSE_PAR() { return getTokens(SQLParser.CLOSE_PAR); }
		public TerminalNode CLOSE_PAR(int i) {
			return getToken(SQLParser.CLOSE_PAR, i);
		}
		public List<Column_nameContext> column_name() {
			return getRuleContexts(Column_nameContext.class);
		}
		public Column_nameContext column_name(int i) {
			return getRuleContext(Column_nameContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(SQLParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(SQLParser.COMMA, i);
		}
		public Common_table_expressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_common_table_expression; }
	}

	public final Common_table_expressionContext common_table_expression() throws RecognitionException {
		Common_table_expressionContext _localctx = new Common_table_expressionContext(_ctx, getState());
		enterRule(_localctx, 96, RULE_common_table_expression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1449);
			table_name();
			setState(1461);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==OPEN_PAR) {
				{
				setState(1450);
				match(OPEN_PAR);
				setState(1451);
				column_name();
				setState(1456);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(1452);
					match(COMMA);
					setState(1453);
					column_name();
					}
					}
					setState(1458);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(1459);
				match(CLOSE_PAR);
				}
			}

			setState(1463);
			match(K_AS);
			setState(1464);
			match(OPEN_PAR);
			setState(1465);
			select_stmt();
			setState(1466);
			match(CLOSE_PAR);
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
	public static class Result_columnContext extends ParserRuleContext {
		public TerminalNode STAR() { return getToken(SQLParser.STAR, 0); }
		public Table_nameContext table_name() {
			return getRuleContext(Table_nameContext.class,0);
		}
		public TerminalNode DOT() { return getToken(SQLParser.DOT, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public Column_aliasContext column_alias() {
			return getRuleContext(Column_aliasContext.class,0);
		}
		public TerminalNode K_AS() { return getToken(SQLParser.K_AS, 0); }
		public Result_columnContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_result_column; }
	}

	public final Result_columnContext result_column() throws RecognitionException {
		Result_columnContext _localctx = new Result_columnContext(_ctx, getState());
		enterRule(_localctx, 98, RULE_result_column);
		int _la;
		try {
			setState(1480);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,206,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1468);
				match(STAR);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1469);
				table_name();
				setState(1470);
				match(DOT);
				setState(1471);
				match(STAR);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(1473);
				expr(0);
				setState(1478);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==K_AS || _la==IDENTIFIER || _la==STRING_LITERAL) {
					{
					setState(1475);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==K_AS) {
						{
						setState(1474);
						match(K_AS);
						}
					}

					setState(1477);
					column_alias();
					}
				}

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
	public static class Table_or_subqueryContext extends ParserRuleContext {
		public Table_nameContext table_name() {
			return getRuleContext(Table_nameContext.class,0);
		}
		public Database_nameContext database_name() {
			return getRuleContext(Database_nameContext.class,0);
		}
		public TerminalNode DOT() { return getToken(SQLParser.DOT, 0); }
		public Table_aliasContext table_alias() {
			return getRuleContext(Table_aliasContext.class,0);
		}
		public TerminalNode K_INDEXED() { return getToken(SQLParser.K_INDEXED, 0); }
		public TerminalNode K_BY() { return getToken(SQLParser.K_BY, 0); }
		public Index_nameContext index_name() {
			return getRuleContext(Index_nameContext.class,0);
		}
		public TerminalNode K_NOT() { return getToken(SQLParser.K_NOT, 0); }
		public TerminalNode K_AS() { return getToken(SQLParser.K_AS, 0); }
		public TerminalNode OPEN_PAR() { return getToken(SQLParser.OPEN_PAR, 0); }
		public TerminalNode CLOSE_PAR() { return getToken(SQLParser.CLOSE_PAR, 0); }
		public List<Table_or_subqueryContext> table_or_subquery() {
			return getRuleContexts(Table_or_subqueryContext.class);
		}
		public Table_or_subqueryContext table_or_subquery(int i) {
			return getRuleContext(Table_or_subqueryContext.class,i);
		}
		public Join_clauseContext join_clause() {
			return getRuleContext(Join_clauseContext.class,0);
		}
		public List<TerminalNode> COMMA() { return getTokens(SQLParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(SQLParser.COMMA, i);
		}
		public Select_stmtContext select_stmt() {
			return getRuleContext(Select_stmtContext.class,0);
		}
		public Table_or_subqueryContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_table_or_subquery; }
	}

	public final Table_or_subqueryContext table_or_subquery() throws RecognitionException {
		Table_or_subqueryContext _localctx = new Table_or_subqueryContext(_ctx, getState());
		enterRule(_localctx, 100, RULE_table_or_subquery);
		int _la;
		try {
			setState(1529);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,217,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1485);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,207,_ctx) ) {
				case 1:
					{
					setState(1482);
					database_name();
					setState(1483);
					match(DOT);
					}
					break;
				}
				setState(1487);
				table_name();
				setState(1492);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==OPEN_PAR || _la==K_AS || _la==IDENTIFIER || _la==STRING_LITERAL) {
					{
					setState(1489);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==K_AS) {
						{
						setState(1488);
						match(K_AS);
						}
					}

					setState(1491);
					table_alias();
					}
				}

				setState(1499);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case K_INDEXED:
					{
					setState(1494);
					match(K_INDEXED);
					setState(1495);
					match(K_BY);
					setState(1496);
					index_name();
					}
					break;
				case K_NOT:
					{
					setState(1497);
					match(K_NOT);
					setState(1498);
					match(K_INDEXED);
					}
					break;
				case EOF:
				case SCOL:
				case CLOSE_PAR:
				case COMMA:
				case K_ALTER:
				case K_ANALYZE:
				case K_ATTACH:
				case K_BEGIN:
				case K_COMMIT:
				case K_CREATE:
				case K_CROSS:
				case K_DELETE:
				case K_DETACH:
				case K_DROP:
				case K_END:
				case K_EXCEPT:
				case K_EXPLAIN:
				case K_GROUP:
				case K_INNER:
				case K_INSERT:
				case K_INTERSECT:
				case K_JOIN:
				case K_LEFT:
				case K_LIMIT:
				case K_NATURAL:
				case K_ON:
				case K_ORDER:
				case K_PRAGMA:
				case K_REINDEX:
				case K_RELEASE:
				case K_REPLACE:
				case K_ROLLBACK:
				case K_SAVEPOINT:
				case K_SELECT:
				case K_UNION:
				case K_UPDATE:
				case K_USING:
				case K_VACUUM:
				case K_VALUES:
				case K_WHERE:
				case K_WITH:
				case UNEXPECTED_CHAR:
					break;
				default:
					break;
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1501);
				match(OPEN_PAR);
				setState(1511);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,212,_ctx) ) {
				case 1:
					{
					setState(1502);
					table_or_subquery();
					setState(1507);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==COMMA) {
						{
						{
						setState(1503);
						match(COMMA);
						setState(1504);
						table_or_subquery();
						}
						}
						setState(1509);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
					break;
				case 2:
					{
					setState(1510);
					join_clause();
					}
					break;
				}
				setState(1513);
				match(CLOSE_PAR);
				setState(1518);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==OPEN_PAR || _la==K_AS || _la==IDENTIFIER || _la==STRING_LITERAL) {
					{
					setState(1515);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==K_AS) {
						{
						setState(1514);
						match(K_AS);
						}
					}

					setState(1517);
					table_alias();
					}
				}

				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(1520);
				match(OPEN_PAR);
				setState(1521);
				select_stmt();
				setState(1522);
				match(CLOSE_PAR);
				setState(1527);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==OPEN_PAR || _la==K_AS || _la==IDENTIFIER || _la==STRING_LITERAL) {
					{
					setState(1524);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==K_AS) {
						{
						setState(1523);
						match(K_AS);
						}
					}

					setState(1526);
					table_alias();
					}
				}

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
	public static class Join_clauseContext extends ParserRuleContext {
		public List<Table_or_subqueryContext> table_or_subquery() {
			return getRuleContexts(Table_or_subqueryContext.class);
		}
		public Table_or_subqueryContext table_or_subquery(int i) {
			return getRuleContext(Table_or_subqueryContext.class,i);
		}
		public List<Join_operatorContext> join_operator() {
			return getRuleContexts(Join_operatorContext.class);
		}
		public Join_operatorContext join_operator(int i) {
			return getRuleContext(Join_operatorContext.class,i);
		}
		public List<Join_constraintContext> join_constraint() {
			return getRuleContexts(Join_constraintContext.class);
		}
		public Join_constraintContext join_constraint(int i) {
			return getRuleContext(Join_constraintContext.class,i);
		}
		public Join_clauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_join_clause; }
	}

	public final Join_clauseContext join_clause() throws RecognitionException {
		Join_clauseContext _localctx = new Join_clauseContext(_ctx, getState());
		enterRule(_localctx, 102, RULE_join_clause);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1531);
			table_or_subquery();
			setState(1538);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA || _la==K_CROSS || ((((_la - 87)) & ~0x3f) == 0 && ((1L << (_la - 87)) & 8833L) != 0)) {
				{
				{
				setState(1532);
				join_operator();
				setState(1533);
				table_or_subquery();
				setState(1534);
				join_constraint();
				}
				}
				setState(1540);
				_errHandler.sync(this);
				_la = _input.LA(1);
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
	public static class Join_operatorContext extends ParserRuleContext {
		public TerminalNode COMMA() { return getToken(SQLParser.COMMA, 0); }
		public TerminalNode K_JOIN() { return getToken(SQLParser.K_JOIN, 0); }
		public TerminalNode K_NATURAL() { return getToken(SQLParser.K_NATURAL, 0); }
		public TerminalNode K_LEFT() { return getToken(SQLParser.K_LEFT, 0); }
		public TerminalNode K_INNER() { return getToken(SQLParser.K_INNER, 0); }
		public TerminalNode K_CROSS() { return getToken(SQLParser.K_CROSS, 0); }
		public TerminalNode K_OUTER() { return getToken(SQLParser.K_OUTER, 0); }
		public Join_operatorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_join_operator; }
	}

	public final Join_operatorContext join_operator() throws RecognitionException {
		Join_operatorContext _localctx = new Join_operatorContext(_ctx, getState());
		enterRule(_localctx, 104, RULE_join_operator);
		int _la;
		try {
			setState(1554);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case COMMA:
				enterOuterAlt(_localctx, 1);
				{
				setState(1541);
				match(COMMA);
				}
				break;
			case K_CROSS:
			case K_INNER:
			case K_JOIN:
			case K_LEFT:
			case K_NATURAL:
				enterOuterAlt(_localctx, 2);
				{
				setState(1543);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==K_NATURAL) {
					{
					setState(1542);
					match(K_NATURAL);
					}
				}

				setState(1551);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case K_LEFT:
					{
					setState(1545);
					match(K_LEFT);
					setState(1547);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==K_OUTER) {
						{
						setState(1546);
						match(K_OUTER);
						}
					}

					}
					break;
				case K_INNER:
					{
					setState(1549);
					match(K_INNER);
					}
					break;
				case K_CROSS:
					{
					setState(1550);
					match(K_CROSS);
					}
					break;
				case K_JOIN:
					break;
				default:
					break;
				}
				setState(1553);
				match(K_JOIN);
				}
				break;
			default:
				throw new NoViableAltException(this);
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
	public static class Join_constraintContext extends ParserRuleContext {
		public TerminalNode K_ON() { return getToken(SQLParser.K_ON, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode K_USING() { return getToken(SQLParser.K_USING, 0); }
		public TerminalNode OPEN_PAR() { return getToken(SQLParser.OPEN_PAR, 0); }
		public List<Column_nameContext> column_name() {
			return getRuleContexts(Column_nameContext.class);
		}
		public Column_nameContext column_name(int i) {
			return getRuleContext(Column_nameContext.class,i);
		}
		public TerminalNode CLOSE_PAR() { return getToken(SQLParser.CLOSE_PAR, 0); }
		public List<TerminalNode> COMMA() { return getTokens(SQLParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(SQLParser.COMMA, i);
		}
		public Join_constraintContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_join_constraint; }
	}

	public final Join_constraintContext join_constraint() throws RecognitionException {
		Join_constraintContext _localctx = new Join_constraintContext(_ctx, getState());
		enterRule(_localctx, 106, RULE_join_constraint);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1570);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case K_ON:
				{
				setState(1556);
				match(K_ON);
				setState(1557);
				expr(0);
				}
				break;
			case K_USING:
				{
				setState(1558);
				match(K_USING);
				setState(1559);
				match(OPEN_PAR);
				setState(1560);
				column_name();
				setState(1565);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(1561);
					match(COMMA);
					setState(1562);
					column_name();
					}
					}
					setState(1567);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(1568);
				match(CLOSE_PAR);
				}
				break;
			case EOF:
			case SCOL:
			case CLOSE_PAR:
			case COMMA:
			case K_ALTER:
			case K_ANALYZE:
			case K_ATTACH:
			case K_BEGIN:
			case K_COMMIT:
			case K_CREATE:
			case K_CROSS:
			case K_DELETE:
			case K_DETACH:
			case K_DROP:
			case K_END:
			case K_EXCEPT:
			case K_EXPLAIN:
			case K_GROUP:
			case K_INNER:
			case K_INSERT:
			case K_INTERSECT:
			case K_JOIN:
			case K_LEFT:
			case K_LIMIT:
			case K_NATURAL:
			case K_ORDER:
			case K_PRAGMA:
			case K_REINDEX:
			case K_RELEASE:
			case K_REPLACE:
			case K_ROLLBACK:
			case K_SAVEPOINT:
			case K_SELECT:
			case K_UNION:
			case K_UPDATE:
			case K_VACUUM:
			case K_VALUES:
			case K_WHERE:
			case K_WITH:
			case UNEXPECTED_CHAR:
				break;
			default:
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
	public static class Select_coreContext extends ParserRuleContext {
		public TerminalNode K_SELECT() { return getToken(SQLParser.K_SELECT, 0); }
		public List<Result_columnContext> result_column() {
			return getRuleContexts(Result_columnContext.class);
		}
		public Result_columnContext result_column(int i) {
			return getRuleContext(Result_columnContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(SQLParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(SQLParser.COMMA, i);
		}
		public TerminalNode K_FROM() { return getToken(SQLParser.K_FROM, 0); }
		public TerminalNode K_WHERE() { return getToken(SQLParser.K_WHERE, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode K_GROUP() { return getToken(SQLParser.K_GROUP, 0); }
		public TerminalNode K_BY() { return getToken(SQLParser.K_BY, 0); }
		public TerminalNode K_DISTINCT() { return getToken(SQLParser.K_DISTINCT, 0); }
		public TerminalNode K_ALL() { return getToken(SQLParser.K_ALL, 0); }
		public List<Table_or_subqueryContext> table_or_subquery() {
			return getRuleContexts(Table_or_subqueryContext.class);
		}
		public Table_or_subqueryContext table_or_subquery(int i) {
			return getRuleContext(Table_or_subqueryContext.class,i);
		}
		public Join_clauseContext join_clause() {
			return getRuleContext(Join_clauseContext.class,0);
		}
		public TerminalNode K_HAVING() { return getToken(SQLParser.K_HAVING, 0); }
		public TerminalNode K_VALUES() { return getToken(SQLParser.K_VALUES, 0); }
		public List<TerminalNode> OPEN_PAR() { return getTokens(SQLParser.OPEN_PAR); }
		public TerminalNode OPEN_PAR(int i) {
			return getToken(SQLParser.OPEN_PAR, i);
		}
		public List<TerminalNode> CLOSE_PAR() { return getTokens(SQLParser.CLOSE_PAR); }
		public TerminalNode CLOSE_PAR(int i) {
			return getToken(SQLParser.CLOSE_PAR, i);
		}
		public Select_coreContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_select_core; }
	}

	public final Select_coreContext select_core() throws RecognitionException {
		Select_coreContext _localctx = new Select_coreContext(_ctx, getState());
		enterRule(_localctx, 108, RULE_select_core);
		int _la;
		try {
			setState(1646);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case K_SELECT:
				enterOuterAlt(_localctx, 1);
				{
				setState(1572);
				match(K_SELECT);
				setState(1574);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,225,_ctx) ) {
				case 1:
					{
					setState(1573);
					_la = _input.LA(1);
					if ( !(_la==K_ALL || _la==K_DISTINCT) ) {
					_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					}
					break;
				}
				setState(1576);
				result_column();
				setState(1581);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(1577);
					match(COMMA);
					setState(1578);
					result_column();
					}
					}
					setState(1583);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(1596);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==K_FROM) {
					{
					setState(1584);
					match(K_FROM);
					setState(1594);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,228,_ctx) ) {
					case 1:
						{
						setState(1585);
						table_or_subquery();
						setState(1590);
						_errHandler.sync(this);
						_la = _input.LA(1);
						while (_la==COMMA) {
							{
							{
							setState(1586);
							match(COMMA);
							setState(1587);
							table_or_subquery();
							}
							}
							setState(1592);
							_errHandler.sync(this);
							_la = _input.LA(1);
						}
						}
						break;
					case 2:
						{
						setState(1593);
						join_clause();
						}
						break;
					}
					}
				}

				setState(1600);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==K_WHERE) {
					{
					setState(1598);
					match(K_WHERE);
					setState(1599);
					expr(0);
					}
				}

				setState(1616);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==K_GROUP) {
					{
					setState(1602);
					match(K_GROUP);
					setState(1603);
					match(K_BY);
					setState(1604);
					expr(0);
					setState(1609);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==COMMA) {
						{
						{
						setState(1605);
						match(COMMA);
						setState(1606);
						expr(0);
						}
						}
						setState(1611);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(1614);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==K_HAVING) {
						{
						setState(1612);
						match(K_HAVING);
						setState(1613);
						expr(0);
						}
					}

					}
				}

				}
				break;
			case K_VALUES:
				enterOuterAlt(_localctx, 2);
				{
				setState(1618);
				match(K_VALUES);
				setState(1619);
				match(OPEN_PAR);
				setState(1620);
				expr(0);
				setState(1625);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(1621);
					match(COMMA);
					setState(1622);
					expr(0);
					}
					}
					setState(1627);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(1628);
				match(CLOSE_PAR);
				setState(1643);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(1629);
					match(COMMA);
					setState(1630);
					match(OPEN_PAR);
					setState(1631);
					expr(0);
					setState(1636);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==COMMA) {
						{
						{
						setState(1632);
						match(COMMA);
						setState(1633);
						expr(0);
						}
						}
						setState(1638);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(1639);
					match(CLOSE_PAR);
					}
					}
					setState(1645);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			default:
				throw new NoViableAltException(this);
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
	public static class Compound_operatorContext extends ParserRuleContext {
		public TerminalNode K_UNION() { return getToken(SQLParser.K_UNION, 0); }
		public TerminalNode K_ALL() { return getToken(SQLParser.K_ALL, 0); }
		public TerminalNode K_INTERSECT() { return getToken(SQLParser.K_INTERSECT, 0); }
		public TerminalNode K_EXCEPT() { return getToken(SQLParser.K_EXCEPT, 0); }
		public Compound_operatorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_compound_operator; }
	}

	public final Compound_operatorContext compound_operator() throws RecognitionException {
		Compound_operatorContext _localctx = new Compound_operatorContext(_ctx, getState());
		enterRule(_localctx, 110, RULE_compound_operator);
		try {
			setState(1653);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,238,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1648);
				match(K_UNION);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1649);
				match(K_UNION);
				setState(1650);
				match(K_ALL);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(1651);
				match(K_INTERSECT);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(1652);
				match(K_EXCEPT);
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
	public static class Cte_table_nameContext extends ParserRuleContext {
		public Table_nameContext table_name() {
			return getRuleContext(Table_nameContext.class,0);
		}
		public TerminalNode OPEN_PAR() { return getToken(SQLParser.OPEN_PAR, 0); }
		public List<Column_nameContext> column_name() {
			return getRuleContexts(Column_nameContext.class);
		}
		public Column_nameContext column_name(int i) {
			return getRuleContext(Column_nameContext.class,i);
		}
		public TerminalNode CLOSE_PAR() { return getToken(SQLParser.CLOSE_PAR, 0); }
		public List<TerminalNode> COMMA() { return getTokens(SQLParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(SQLParser.COMMA, i);
		}
		public Cte_table_nameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cte_table_name; }
	}

	public final Cte_table_nameContext cte_table_name() throws RecognitionException {
		Cte_table_nameContext _localctx = new Cte_table_nameContext(_ctx, getState());
		enterRule(_localctx, 112, RULE_cte_table_name);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1655);
			table_name();
			setState(1667);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==OPEN_PAR) {
				{
				setState(1656);
				match(OPEN_PAR);
				setState(1657);
				column_name();
				setState(1662);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(1658);
					match(COMMA);
					setState(1659);
					column_name();
					}
					}
					setState(1664);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(1665);
				match(CLOSE_PAR);
				}
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
	public static class Signed_numberContext extends ParserRuleContext {
		public TerminalNode NUMERIC_LITERAL() { return getToken(SQLParser.NUMERIC_LITERAL, 0); }
		public TerminalNode PLUS() { return getToken(SQLParser.PLUS, 0); }
		public TerminalNode MINUS() { return getToken(SQLParser.MINUS, 0); }
		public Signed_numberContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_signed_number; }
	}

	public final Signed_numberContext signed_number() throws RecognitionException {
		Signed_numberContext _localctx = new Signed_numberContext(_ctx, getState());
		enterRule(_localctx, 114, RULE_signed_number);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1670);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==PLUS || _la==MINUS) {
				{
				setState(1669);
				_la = _input.LA(1);
				if ( !(_la==PLUS || _la==MINUS) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				}
			}

			setState(1672);
			match(NUMERIC_LITERAL);
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
	public static class Literal_valueContext extends ParserRuleContext {
		public TerminalNode NUMERIC_LITERAL() { return getToken(SQLParser.NUMERIC_LITERAL, 0); }
		public TerminalNode STRING_LITERAL() { return getToken(SQLParser.STRING_LITERAL, 0); }
		public TerminalNode BLOB_LITERAL() { return getToken(SQLParser.BLOB_LITERAL, 0); }
		public TerminalNode K_NULL() { return getToken(SQLParser.K_NULL, 0); }
		public TerminalNode K_CURRENT_TIME() { return getToken(SQLParser.K_CURRENT_TIME, 0); }
		public TerminalNode K_CURRENT_DATE() { return getToken(SQLParser.K_CURRENT_DATE, 0); }
		public TerminalNode K_CURRENT_TIMESTAMP() { return getToken(SQLParser.K_CURRENT_TIMESTAMP, 0); }
		public Literal_valueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_literal_value; }
	}

	public final Literal_valueContext literal_value() throws RecognitionException {
		Literal_valueContext _localctx = new Literal_valueContext(_ctx, getState());
		enterRule(_localctx, 116, RULE_literal_value);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1674);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 31525197391593472L) != 0) || ((((_la - 104)) & ~0x3f) == 0 && ((1L << (_la - 104)) & 914793674309633L) != 0)) ) {
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
	public static class Unary_operatorContext extends ParserRuleContext {
		public TerminalNode MINUS() { return getToken(SQLParser.MINUS, 0); }
		public TerminalNode PLUS() { return getToken(SQLParser.PLUS, 0); }
		public TerminalNode TILDE() { return getToken(SQLParser.TILDE, 0); }
		public TerminalNode K_NOT() { return getToken(SQLParser.K_NOT, 0); }
		public Unary_operatorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_unary_operator; }
	}

	public final Unary_operatorContext unary_operator() throws RecognitionException {
		Unary_operatorContext _localctx = new Unary_operatorContext(_ctx, getState());
		enterRule(_localctx, 118, RULE_unary_operator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1676);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 1792L) != 0) || _la==K_NOT) ) {
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
	public static class Error_messageContext extends ParserRuleContext {
		public TerminalNode STRING_LITERAL() { return getToken(SQLParser.STRING_LITERAL, 0); }
		public Error_messageContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_error_message; }
	}

	public final Error_messageContext error_message() throws RecognitionException {
		Error_messageContext _localctx = new Error_messageContext(_ctx, getState());
		enterRule(_localctx, 120, RULE_error_message);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1678);
			match(STRING_LITERAL);
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
	public static class Module_argumentContext extends ParserRuleContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public Column_defContext column_def() {
			return getRuleContext(Column_defContext.class,0);
		}
		public Module_argumentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_module_argument; }
	}

	public final Module_argumentContext module_argument() throws RecognitionException {
		Module_argumentContext _localctx = new Module_argumentContext(_ctx, getState());
		enterRule(_localctx, 122, RULE_module_argument);
		try {
			setState(1682);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,242,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1680);
				expr(0);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1681);
				column_def();
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
	public static class Column_aliasContext extends ParserRuleContext {
		public TerminalNode IDENTIFIER() { return getToken(SQLParser.IDENTIFIER, 0); }
		public TerminalNode STRING_LITERAL() { return getToken(SQLParser.STRING_LITERAL, 0); }
		public Column_aliasContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_column_alias; }
	}

	public final Column_aliasContext column_alias() throws RecognitionException {
		Column_aliasContext _localctx = new Column_aliasContext(_ctx, getState());
		enterRule(_localctx, 124, RULE_column_alias);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1684);
			_la = _input.LA(1);
			if ( !(_la==IDENTIFIER || _la==STRING_LITERAL) ) {
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
	public static class KeywordContext extends ParserRuleContext {
		public TerminalNode K_ABORT() { return getToken(SQLParser.K_ABORT, 0); }
		public TerminalNode K_ACTION() { return getToken(SQLParser.K_ACTION, 0); }
		public TerminalNode K_ADD() { return getToken(SQLParser.K_ADD, 0); }
		public TerminalNode K_AFTER() { return getToken(SQLParser.K_AFTER, 0); }
		public TerminalNode K_ALL() { return getToken(SQLParser.K_ALL, 0); }
		public TerminalNode K_ALTER() { return getToken(SQLParser.K_ALTER, 0); }
		public TerminalNode K_ANALYZE() { return getToken(SQLParser.K_ANALYZE, 0); }
		public TerminalNode K_AND() { return getToken(SQLParser.K_AND, 0); }
		public TerminalNode K_AS() { return getToken(SQLParser.K_AS, 0); }
		public TerminalNode K_ASC() { return getToken(SQLParser.K_ASC, 0); }
		public TerminalNode K_ATTACH() { return getToken(SQLParser.K_ATTACH, 0); }
		public TerminalNode K_AUTOINCREMENT() { return getToken(SQLParser.K_AUTOINCREMENT, 0); }
		public TerminalNode K_BEFORE() { return getToken(SQLParser.K_BEFORE, 0); }
		public TerminalNode K_BEGIN() { return getToken(SQLParser.K_BEGIN, 0); }
		public TerminalNode K_BETWEEN() { return getToken(SQLParser.K_BETWEEN, 0); }
		public TerminalNode K_BY() { return getToken(SQLParser.K_BY, 0); }
		public TerminalNode K_CASCADE() { return getToken(SQLParser.K_CASCADE, 0); }
		public TerminalNode K_CASE() { return getToken(SQLParser.K_CASE, 0); }
		public TerminalNode K_CAST() { return getToken(SQLParser.K_CAST, 0); }
		public TerminalNode K_CHECK() { return getToken(SQLParser.K_CHECK, 0); }
		public TerminalNode K_COLLATE() { return getToken(SQLParser.K_COLLATE, 0); }
		public TerminalNode K_COLUMN() { return getToken(SQLParser.K_COLUMN, 0); }
		public TerminalNode K_COMMIT() { return getToken(SQLParser.K_COMMIT, 0); }
		public TerminalNode K_CONFLICT() { return getToken(SQLParser.K_CONFLICT, 0); }
		public TerminalNode K_CONSTRAINT() { return getToken(SQLParser.K_CONSTRAINT, 0); }
		public TerminalNode K_CREATE() { return getToken(SQLParser.K_CREATE, 0); }
		public TerminalNode K_CROSS() { return getToken(SQLParser.K_CROSS, 0); }
		public TerminalNode K_CURRENT_DATE() { return getToken(SQLParser.K_CURRENT_DATE, 0); }
		public TerminalNode K_CURRENT_TIME() { return getToken(SQLParser.K_CURRENT_TIME, 0); }
		public TerminalNode K_CURRENT_TIMESTAMP() { return getToken(SQLParser.K_CURRENT_TIMESTAMP, 0); }
		public TerminalNode K_DATABASE() { return getToken(SQLParser.K_DATABASE, 0); }
		public TerminalNode K_DEFAULT() { return getToken(SQLParser.K_DEFAULT, 0); }
		public TerminalNode K_DEFERRABLE() { return getToken(SQLParser.K_DEFERRABLE, 0); }
		public TerminalNode K_DEFERRED() { return getToken(SQLParser.K_DEFERRED, 0); }
		public TerminalNode K_DELETE() { return getToken(SQLParser.K_DELETE, 0); }
		public TerminalNode K_DESC() { return getToken(SQLParser.K_DESC, 0); }
		public TerminalNode K_DETACH() { return getToken(SQLParser.K_DETACH, 0); }
		public TerminalNode K_DISTINCT() { return getToken(SQLParser.K_DISTINCT, 0); }
		public TerminalNode K_DROP() { return getToken(SQLParser.K_DROP, 0); }
		public TerminalNode K_EACH() { return getToken(SQLParser.K_EACH, 0); }
		public TerminalNode K_ELSE() { return getToken(SQLParser.K_ELSE, 0); }
		public TerminalNode K_END() { return getToken(SQLParser.K_END, 0); }
		public TerminalNode K_ESCAPE() { return getToken(SQLParser.K_ESCAPE, 0); }
		public TerminalNode K_EXCEPT() { return getToken(SQLParser.K_EXCEPT, 0); }
		public TerminalNode K_EXCLUSIVE() { return getToken(SQLParser.K_EXCLUSIVE, 0); }
		public TerminalNode K_EXISTS() { return getToken(SQLParser.K_EXISTS, 0); }
		public TerminalNode K_EXPLAIN() { return getToken(SQLParser.K_EXPLAIN, 0); }
		public TerminalNode K_FAIL() { return getToken(SQLParser.K_FAIL, 0); }
		public TerminalNode K_FOR() { return getToken(SQLParser.K_FOR, 0); }
		public TerminalNode K_FOREIGN() { return getToken(SQLParser.K_FOREIGN, 0); }
		public TerminalNode K_FROM() { return getToken(SQLParser.K_FROM, 0); }
		public TerminalNode K_FULL() { return getToken(SQLParser.K_FULL, 0); }
		public TerminalNode K_GLOB() { return getToken(SQLParser.K_GLOB, 0); }
		public TerminalNode K_GROUP() { return getToken(SQLParser.K_GROUP, 0); }
		public TerminalNode K_HAVING() { return getToken(SQLParser.K_HAVING, 0); }
		public TerminalNode K_IF() { return getToken(SQLParser.K_IF, 0); }
		public TerminalNode K_IGNORE() { return getToken(SQLParser.K_IGNORE, 0); }
		public TerminalNode K_IMMEDIATE() { return getToken(SQLParser.K_IMMEDIATE, 0); }
		public TerminalNode K_IN() { return getToken(SQLParser.K_IN, 0); }
		public TerminalNode K_INDEX() { return getToken(SQLParser.K_INDEX, 0); }
		public TerminalNode K_INDEXED() { return getToken(SQLParser.K_INDEXED, 0); }
		public TerminalNode K_INITIALLY() { return getToken(SQLParser.K_INITIALLY, 0); }
		public TerminalNode K_INNER() { return getToken(SQLParser.K_INNER, 0); }
		public TerminalNode K_INSERT() { return getToken(SQLParser.K_INSERT, 0); }
		public TerminalNode K_INSTEAD() { return getToken(SQLParser.K_INSTEAD, 0); }
		public TerminalNode K_INTERSECT() { return getToken(SQLParser.K_INTERSECT, 0); }
		public TerminalNode K_INTO() { return getToken(SQLParser.K_INTO, 0); }
		public TerminalNode K_IS() { return getToken(SQLParser.K_IS, 0); }
		public TerminalNode K_ISNULL() { return getToken(SQLParser.K_ISNULL, 0); }
		public TerminalNode K_JOIN() { return getToken(SQLParser.K_JOIN, 0); }
		public TerminalNode K_KEY() { return getToken(SQLParser.K_KEY, 0); }
		public TerminalNode K_LEFT() { return getToken(SQLParser.K_LEFT, 0); }
		public TerminalNode K_LIKE() { return getToken(SQLParser.K_LIKE, 0); }
		public TerminalNode K_LIMIT() { return getToken(SQLParser.K_LIMIT, 0); }
		public TerminalNode K_MATCH() { return getToken(SQLParser.K_MATCH, 0); }
		public TerminalNode K_NATURAL() { return getToken(SQLParser.K_NATURAL, 0); }
		public TerminalNode K_NO() { return getToken(SQLParser.K_NO, 0); }
		public TerminalNode K_NOT() { return getToken(SQLParser.K_NOT, 0); }
		public TerminalNode K_NOTNULL() { return getToken(SQLParser.K_NOTNULL, 0); }
		public TerminalNode K_NULL() { return getToken(SQLParser.K_NULL, 0); }
		public TerminalNode K_OF() { return getToken(SQLParser.K_OF, 0); }
		public TerminalNode K_OFFSET() { return getToken(SQLParser.K_OFFSET, 0); }
		public TerminalNode K_ON() { return getToken(SQLParser.K_ON, 0); }
		public TerminalNode K_OR() { return getToken(SQLParser.K_OR, 0); }
		public TerminalNode K_ORDER() { return getToken(SQLParser.K_ORDER, 0); }
		public TerminalNode K_OUTER() { return getToken(SQLParser.K_OUTER, 0); }
		public TerminalNode K_PLAN() { return getToken(SQLParser.K_PLAN, 0); }
		public TerminalNode K_PRAGMA() { return getToken(SQLParser.K_PRAGMA, 0); }
		public TerminalNode K_PRIMARY() { return getToken(SQLParser.K_PRIMARY, 0); }
		public TerminalNode K_QUERY() { return getToken(SQLParser.K_QUERY, 0); }
		public TerminalNode K_RAISE() { return getToken(SQLParser.K_RAISE, 0); }
		public TerminalNode K_RECURSIVE() { return getToken(SQLParser.K_RECURSIVE, 0); }
		public TerminalNode K_REFERENCES() { return getToken(SQLParser.K_REFERENCES, 0); }
		public TerminalNode K_REGEXP() { return getToken(SQLParser.K_REGEXP, 0); }
		public TerminalNode K_REINDEX() { return getToken(SQLParser.K_REINDEX, 0); }
		public TerminalNode K_RELEASE() { return getToken(SQLParser.K_RELEASE, 0); }
		public TerminalNode K_RENAME() { return getToken(SQLParser.K_RENAME, 0); }
		public TerminalNode K_REPLACE() { return getToken(SQLParser.K_REPLACE, 0); }
		public TerminalNode K_RESTRICT() { return getToken(SQLParser.K_RESTRICT, 0); }
		public TerminalNode K_RIGHT() { return getToken(SQLParser.K_RIGHT, 0); }
		public TerminalNode K_ROLLBACK() { return getToken(SQLParser.K_ROLLBACK, 0); }
		public TerminalNode K_ROW() { return getToken(SQLParser.K_ROW, 0); }
		public TerminalNode K_SAVEPOINT() { return getToken(SQLParser.K_SAVEPOINT, 0); }
		public TerminalNode K_SELECT() { return getToken(SQLParser.K_SELECT, 0); }
		public TerminalNode K_SET() { return getToken(SQLParser.K_SET, 0); }
		public TerminalNode K_TABLE() { return getToken(SQLParser.K_TABLE, 0); }
		public TerminalNode K_TEMP() { return getToken(SQLParser.K_TEMP, 0); }
		public TerminalNode K_TEMPORARY() { return getToken(SQLParser.K_TEMPORARY, 0); }
		public TerminalNode K_THEN() { return getToken(SQLParser.K_THEN, 0); }
		public TerminalNode K_TO() { return getToken(SQLParser.K_TO, 0); }
		public TerminalNode K_TRANSACTION() { return getToken(SQLParser.K_TRANSACTION, 0); }
		public TerminalNode K_TRIGGER() { return getToken(SQLParser.K_TRIGGER, 0); }
		public TerminalNode K_UNION() { return getToken(SQLParser.K_UNION, 0); }
		public TerminalNode K_UNIQUE() { return getToken(SQLParser.K_UNIQUE, 0); }
		public TerminalNode K_UPDATE() { return getToken(SQLParser.K_UPDATE, 0); }
		public TerminalNode K_USING() { return getToken(SQLParser.K_USING, 0); }
		public TerminalNode K_VACUUM() { return getToken(SQLParser.K_VACUUM, 0); }
		public TerminalNode K_VALUES() { return getToken(SQLParser.K_VALUES, 0); }
		public TerminalNode K_VIEW() { return getToken(SQLParser.K_VIEW, 0); }
		public TerminalNode K_VIRTUAL() { return getToken(SQLParser.K_VIRTUAL, 0); }
		public TerminalNode K_WHEN() { return getToken(SQLParser.K_WHEN, 0); }
		public TerminalNode K_WHERE() { return getToken(SQLParser.K_WHERE, 0); }
		public TerminalNode K_WITH() { return getToken(SQLParser.K_WITH, 0); }
		public TerminalNode K_WITHOUT() { return getToken(SQLParser.K_WITHOUT, 0); }
		public KeywordContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_keyword; }
	}

	public final KeywordContext keyword() throws RecognitionException {
		KeywordContext _localctx = new KeywordContext(_ctx, getState());
		enterRule(_localctx, 126, RULE_keyword);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1686);
			_la = _input.LA(1);
			if ( !(((((_la - 25)) & ~0x3f) == 0 && ((1L << (_la - 25)) & -1L) != 0) || ((((_la - 89)) & ~0x3f) == 0 && ((1L << (_la - 89)) & 1152921504606846975L) != 0)) ) {
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
	public static class NameContext extends ParserRuleContext {
		public Any_nameContext any_name() {
			return getRuleContext(Any_nameContext.class,0);
		}
		public NameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_name; }
	}

	public final NameContext name() throws RecognitionException {
		NameContext _localctx = new NameContext(_ctx, getState());
		enterRule(_localctx, 128, RULE_name);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1688);
			any_name();
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
	public static class Function_nameContext extends ParserRuleContext {
		public Any_nameContext any_name() {
			return getRuleContext(Any_nameContext.class,0);
		}
		public Function_nameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_function_name; }
	}

	public final Function_nameContext function_name() throws RecognitionException {
		Function_nameContext _localctx = new Function_nameContext(_ctx, getState());
		enterRule(_localctx, 130, RULE_function_name);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1690);
			any_name();
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
	public static class Database_nameContext extends ParserRuleContext {
		public Any_nameContext any_name() {
			return getRuleContext(Any_nameContext.class,0);
		}
		public Database_nameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_database_name; }
	}

	public final Database_nameContext database_name() throws RecognitionException {
		Database_nameContext _localctx = new Database_nameContext(_ctx, getState());
		enterRule(_localctx, 132, RULE_database_name);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1692);
			any_name();
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
	public static class Table_nameContext extends ParserRuleContext {
		public Any_nameContext any_name() {
			return getRuleContext(Any_nameContext.class,0);
		}
		public Table_nameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_table_name; }
	}

	public final Table_nameContext table_name() throws RecognitionException {
		Table_nameContext _localctx = new Table_nameContext(_ctx, getState());
		enterRule(_localctx, 134, RULE_table_name);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1694);
			any_name();
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
	public static class Table_or_index_nameContext extends ParserRuleContext {
		public Any_nameContext any_name() {
			return getRuleContext(Any_nameContext.class,0);
		}
		public Table_or_index_nameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_table_or_index_name; }
	}

	public final Table_or_index_nameContext table_or_index_name() throws RecognitionException {
		Table_or_index_nameContext _localctx = new Table_or_index_nameContext(_ctx, getState());
		enterRule(_localctx, 136, RULE_table_or_index_name);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1696);
			any_name();
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
	public static class New_table_nameContext extends ParserRuleContext {
		public Any_nameContext any_name() {
			return getRuleContext(Any_nameContext.class,0);
		}
		public New_table_nameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_new_table_name; }
	}

	public final New_table_nameContext new_table_name() throws RecognitionException {
		New_table_nameContext _localctx = new New_table_nameContext(_ctx, getState());
		enterRule(_localctx, 138, RULE_new_table_name);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1698);
			any_name();
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
	public static class Column_nameContext extends ParserRuleContext {
		public Any_nameContext any_name() {
			return getRuleContext(Any_nameContext.class,0);
		}
		public Column_nameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_column_name; }
	}

	public final Column_nameContext column_name() throws RecognitionException {
		Column_nameContext _localctx = new Column_nameContext(_ctx, getState());
		enterRule(_localctx, 140, RULE_column_name);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1700);
			any_name();
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
	public static class Collation_nameContext extends ParserRuleContext {
		public Any_nameContext any_name() {
			return getRuleContext(Any_nameContext.class,0);
		}
		public Collation_nameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_collation_name; }
	}

	public final Collation_nameContext collation_name() throws RecognitionException {
		Collation_nameContext _localctx = new Collation_nameContext(_ctx, getState());
		enterRule(_localctx, 142, RULE_collation_name);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1702);
			any_name();
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
	public static class Foreign_tableContext extends ParserRuleContext {
		public Any_nameContext any_name() {
			return getRuleContext(Any_nameContext.class,0);
		}
		public Foreign_tableContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_foreign_table; }
	}

	public final Foreign_tableContext foreign_table() throws RecognitionException {
		Foreign_tableContext _localctx = new Foreign_tableContext(_ctx, getState());
		enterRule(_localctx, 144, RULE_foreign_table);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1704);
			any_name();
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
	public static class Index_nameContext extends ParserRuleContext {
		public Any_nameContext any_name() {
			return getRuleContext(Any_nameContext.class,0);
		}
		public Index_nameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_index_name; }
	}

	public final Index_nameContext index_name() throws RecognitionException {
		Index_nameContext _localctx = new Index_nameContext(_ctx, getState());
		enterRule(_localctx, 146, RULE_index_name);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1706);
			any_name();
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
	public static class Trigger_nameContext extends ParserRuleContext {
		public Any_nameContext any_name() {
			return getRuleContext(Any_nameContext.class,0);
		}
		public Trigger_nameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_trigger_name; }
	}

	public final Trigger_nameContext trigger_name() throws RecognitionException {
		Trigger_nameContext _localctx = new Trigger_nameContext(_ctx, getState());
		enterRule(_localctx, 148, RULE_trigger_name);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1708);
			any_name();
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
	public static class View_nameContext extends ParserRuleContext {
		public Any_nameContext any_name() {
			return getRuleContext(Any_nameContext.class,0);
		}
		public View_nameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_view_name; }
	}

	public final View_nameContext view_name() throws RecognitionException {
		View_nameContext _localctx = new View_nameContext(_ctx, getState());
		enterRule(_localctx, 150, RULE_view_name);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1710);
			any_name();
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
	public static class Module_nameContext extends ParserRuleContext {
		public Any_nameContext any_name() {
			return getRuleContext(Any_nameContext.class,0);
		}
		public Module_nameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_module_name; }
	}

	public final Module_nameContext module_name() throws RecognitionException {
		Module_nameContext _localctx = new Module_nameContext(_ctx, getState());
		enterRule(_localctx, 152, RULE_module_name);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1712);
			any_name();
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
	public static class Pragma_nameContext extends ParserRuleContext {
		public Any_nameContext any_name() {
			return getRuleContext(Any_nameContext.class,0);
		}
		public Pragma_nameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pragma_name; }
	}

	public final Pragma_nameContext pragma_name() throws RecognitionException {
		Pragma_nameContext _localctx = new Pragma_nameContext(_ctx, getState());
		enterRule(_localctx, 154, RULE_pragma_name);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1714);
			any_name();
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
	public static class Savepoint_nameContext extends ParserRuleContext {
		public Any_nameContext any_name() {
			return getRuleContext(Any_nameContext.class,0);
		}
		public Savepoint_nameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_savepoint_name; }
	}

	public final Savepoint_nameContext savepoint_name() throws RecognitionException {
		Savepoint_nameContext _localctx = new Savepoint_nameContext(_ctx, getState());
		enterRule(_localctx, 156, RULE_savepoint_name);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1716);
			any_name();
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
	public static class Table_aliasContext extends ParserRuleContext {
		public TerminalNode IDENTIFIER() { return getToken(SQLParser.IDENTIFIER, 0); }
		public TerminalNode STRING_LITERAL() { return getToken(SQLParser.STRING_LITERAL, 0); }
		public TerminalNode OPEN_PAR() { return getToken(SQLParser.OPEN_PAR, 0); }
		public Table_aliasContext table_alias() {
			return getRuleContext(Table_aliasContext.class,0);
		}
		public TerminalNode CLOSE_PAR() { return getToken(SQLParser.CLOSE_PAR, 0); }
		public Table_aliasContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_table_alias; }
	}

	public final Table_aliasContext table_alias() throws RecognitionException {
		Table_aliasContext _localctx = new Table_aliasContext(_ctx, getState());
		enterRule(_localctx, 158, RULE_table_alias);
		try {
			setState(1724);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case IDENTIFIER:
				enterOuterAlt(_localctx, 1);
				{
				setState(1718);
				match(IDENTIFIER);
				}
				break;
			case STRING_LITERAL:
				enterOuterAlt(_localctx, 2);
				{
				setState(1719);
				match(STRING_LITERAL);
				}
				break;
			case OPEN_PAR:
				enterOuterAlt(_localctx, 3);
				{
				setState(1720);
				match(OPEN_PAR);
				setState(1721);
				table_alias();
				setState(1722);
				match(CLOSE_PAR);
				}
				break;
			default:
				throw new NoViableAltException(this);
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
	public static class Transaction_nameContext extends ParserRuleContext {
		public Any_nameContext any_name() {
			return getRuleContext(Any_nameContext.class,0);
		}
		public Transaction_nameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_transaction_name; }
	}

	public final Transaction_nameContext transaction_name() throws RecognitionException {
		Transaction_nameContext _localctx = new Transaction_nameContext(_ctx, getState());
		enterRule(_localctx, 160, RULE_transaction_name);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1726);
			any_name();
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
	public static class Any_nameContext extends ParserRuleContext {
		public TerminalNode IDENTIFIER() { return getToken(SQLParser.IDENTIFIER, 0); }
		public KeywordContext keyword() {
			return getRuleContext(KeywordContext.class,0);
		}
		public TerminalNode STRING_LITERAL() { return getToken(SQLParser.STRING_LITERAL, 0); }
		public TerminalNode OPEN_PAR() { return getToken(SQLParser.OPEN_PAR, 0); }
		public Any_nameContext any_name() {
			return getRuleContext(Any_nameContext.class,0);
		}
		public TerminalNode CLOSE_PAR() { return getToken(SQLParser.CLOSE_PAR, 0); }
		public Any_nameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_any_name; }
	}

	public final Any_nameContext any_name() throws RecognitionException {
		Any_nameContext _localctx = new Any_nameContext(_ctx, getState());
		enterRule(_localctx, 162, RULE_any_name);
		try {
			setState(1735);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case IDENTIFIER:
				enterOuterAlt(_localctx, 1);
				{
				setState(1728);
				match(IDENTIFIER);
				}
				break;
			case K_ABORT:
			case K_ACTION:
			case K_ADD:
			case K_AFTER:
			case K_ALL:
			case K_ALTER:
			case K_ANALYZE:
			case K_AND:
			case K_AS:
			case K_ASC:
			case K_ATTACH:
			case K_AUTOINCREMENT:
			case K_BEFORE:
			case K_BEGIN:
			case K_BETWEEN:
			case K_BY:
			case K_CASCADE:
			case K_CASE:
			case K_CAST:
			case K_CHECK:
			case K_COLLATE:
			case K_COLUMN:
			case K_COMMIT:
			case K_CONFLICT:
			case K_CONSTRAINT:
			case K_CREATE:
			case K_CROSS:
			case K_CURRENT_DATE:
			case K_CURRENT_TIME:
			case K_CURRENT_TIMESTAMP:
			case K_DATABASE:
			case K_DEFAULT:
			case K_DEFERRABLE:
			case K_DEFERRED:
			case K_DELETE:
			case K_DESC:
			case K_DETACH:
			case K_DISTINCT:
			case K_DROP:
			case K_EACH:
			case K_ELSE:
			case K_END:
			case K_ESCAPE:
			case K_EXCEPT:
			case K_EXCLUSIVE:
			case K_EXISTS:
			case K_EXPLAIN:
			case K_FAIL:
			case K_FOR:
			case K_FOREIGN:
			case K_FROM:
			case K_FULL:
			case K_GLOB:
			case K_GROUP:
			case K_HAVING:
			case K_IF:
			case K_IGNORE:
			case K_IMMEDIATE:
			case K_IN:
			case K_INDEX:
			case K_INDEXED:
			case K_INITIALLY:
			case K_INNER:
			case K_INSERT:
			case K_INSTEAD:
			case K_INTERSECT:
			case K_INTO:
			case K_IS:
			case K_ISNULL:
			case K_JOIN:
			case K_KEY:
			case K_LEFT:
			case K_LIKE:
			case K_LIMIT:
			case K_MATCH:
			case K_NATURAL:
			case K_NO:
			case K_NOT:
			case K_NOTNULL:
			case K_NULL:
			case K_OF:
			case K_OFFSET:
			case K_ON:
			case K_OR:
			case K_ORDER:
			case K_OUTER:
			case K_PLAN:
			case K_PRAGMA:
			case K_PRIMARY:
			case K_QUERY:
			case K_RAISE:
			case K_RECURSIVE:
			case K_REFERENCES:
			case K_REGEXP:
			case K_REINDEX:
			case K_RELEASE:
			case K_RENAME:
			case K_REPLACE:
			case K_RESTRICT:
			case K_RIGHT:
			case K_ROLLBACK:
			case K_ROW:
			case K_SAVEPOINT:
			case K_SELECT:
			case K_SET:
			case K_TABLE:
			case K_TEMP:
			case K_TEMPORARY:
			case K_THEN:
			case K_TO:
			case K_TRANSACTION:
			case K_TRIGGER:
			case K_UNION:
			case K_UNIQUE:
			case K_UPDATE:
			case K_USING:
			case K_VACUUM:
			case K_VALUES:
			case K_VIEW:
			case K_VIRTUAL:
			case K_WHEN:
			case K_WHERE:
			case K_WITH:
			case K_WITHOUT:
				enterOuterAlt(_localctx, 2);
				{
				setState(1729);
				keyword();
				}
				break;
			case STRING_LITERAL:
				enterOuterAlt(_localctx, 3);
				{
				setState(1730);
				match(STRING_LITERAL);
				}
				break;
			case OPEN_PAR:
				enterOuterAlt(_localctx, 4);
				{
				setState(1731);
				match(OPEN_PAR);
				setState(1732);
				any_name();
				setState(1733);
				match(CLOSE_PAR);
				}
				break;
			default:
				throw new NoViableAltException(this);
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
		case 39:
			return expr_sempred((ExprContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expr_sempred(ExprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 20);
		case 1:
			return precpred(_ctx, 19);
		case 2:
			return precpred(_ctx, 18);
		case 3:
			return precpred(_ctx, 17);
		case 4:
			return precpred(_ctx, 16);
		case 5:
			return precpred(_ctx, 15);
		case 6:
			return precpred(_ctx, 14);
		case 7:
			return precpred(_ctx, 13);
		case 8:
			return precpred(_ctx, 6);
		case 9:
			return precpred(_ctx, 5);
		case 10:
			return precpred(_ctx, 9);
		case 11:
			return precpred(_ctx, 8);
		case 12:
			return precpred(_ctx, 7);
		case 13:
			return precpred(_ctx, 4);
		}
		return true;
	}

	public static final String _serializedATN =
		"\u0004\u0001\u009d\u06ca\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001"+
		"\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004"+
		"\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007"+
		"\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b"+
		"\u0002\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007"+
		"\u000f\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0002\u0012\u0007"+
		"\u0012\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014\u0002\u0015\u0007"+
		"\u0015\u0002\u0016\u0007\u0016\u0002\u0017\u0007\u0017\u0002\u0018\u0007"+
		"\u0018\u0002\u0019\u0007\u0019\u0002\u001a\u0007\u001a\u0002\u001b\u0007"+
		"\u001b\u0002\u001c\u0007\u001c\u0002\u001d\u0007\u001d\u0002\u001e\u0007"+
		"\u001e\u0002\u001f\u0007\u001f\u0002 \u0007 \u0002!\u0007!\u0002\"\u0007"+
		"\"\u0002#\u0007#\u0002$\u0007$\u0002%\u0007%\u0002&\u0007&\u0002\'\u0007"+
		"\'\u0002(\u0007(\u0002)\u0007)\u0002*\u0007*\u0002+\u0007+\u0002,\u0007"+
		",\u0002-\u0007-\u0002.\u0007.\u0002/\u0007/\u00020\u00070\u00021\u0007"+
		"1\u00022\u00072\u00023\u00073\u00024\u00074\u00025\u00075\u00026\u0007"+
		"6\u00027\u00077\u00028\u00078\u00029\u00079\u0002:\u0007:\u0002;\u0007"+
		";\u0002<\u0007<\u0002=\u0007=\u0002>\u0007>\u0002?\u0007?\u0002@\u0007"+
		"@\u0002A\u0007A\u0002B\u0007B\u0002C\u0007C\u0002D\u0007D\u0002E\u0007"+
		"E\u0002F\u0007F\u0002G\u0007G\u0002H\u0007H\u0002I\u0007I\u0002J\u0007"+
		"J\u0002K\u0007K\u0002L\u0007L\u0002M\u0007M\u0002N\u0007N\u0002O\u0007"+
		"O\u0002P\u0007P\u0002Q\u0007Q\u0001\u0000\u0001\u0000\u0005\u0000\u00a7"+
		"\b\u0000\n\u0000\f\u0000\u00aa\t\u0000\u0001\u0000\u0001\u0000\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0002\u0005\u0002\u00b2\b\u0002\n\u0002"+
		"\f\u0002\u00b5\t\u0002\u0001\u0002\u0001\u0002\u0004\u0002\u00b9\b\u0002"+
		"\u000b\u0002\f\u0002\u00ba\u0001\u0002\u0005\u0002\u00be\b\u0002\n\u0002"+
		"\f\u0002\u00c1\t\u0002\u0001\u0002\u0005\u0002\u00c4\b\u0002\n\u0002\f"+
		"\u0002\u00c7\t\u0002\u0001\u0003\u0001\u0003\u0001\u0003\u0003\u0003\u00cc"+
		"\b\u0003\u0003\u0003\u00ce\b\u0003\u0001\u0003\u0001\u0003\u0001\u0003"+
		"\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003"+
		"\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003"+
		"\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003"+
		"\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003"+
		"\u0001\u0003\u0001\u0003\u0001\u0003\u0003\u0003\u00ee\b\u0003\u0001\u0004"+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0003\u0004\u00f5\b\u0004"+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0003\u0004\u00fd\b\u0004\u0001\u0004\u0003\u0004\u0100\b\u0004\u0001"+
		"\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001"+
		"\u0005\u0003\u0005\u0109\b\u0005\u0001\u0006\u0001\u0006\u0003\u0006\u010d"+
		"\b\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0007\u0001"+
		"\u0007\u0003\u0007\u0115\b\u0007\u0001\u0007\u0001\u0007\u0003\u0007\u0119"+
		"\b\u0007\u0003\u0007\u011b\b\u0007\u0001\b\u0001\b\u0001\b\u0003\b\u0120"+
		"\b\b\u0003\b\u0122\b\b\u0001\t\u0001\t\u0003\t\u0126\b\t\u0001\t\u0001"+
		"\t\u0001\t\u0005\t\u012b\b\t\n\t\f\t\u012e\t\t\u0003\t\u0130\b\t\u0001"+
		"\t\u0001\t\u0001\t\u0003\t\u0135\b\t\u0001\t\u0001\t\u0003\t\u0139\b\t"+
		"\u0001\t\u0004\t\u013c\b\t\u000b\t\f\t\u013d\u0001\t\u0001\t\u0001\t\u0001"+
		"\t\u0001\t\u0005\t\u0145\b\t\n\t\f\t\u0148\t\t\u0003\t\u014a\b\t\u0001"+
		"\t\u0001\t\u0001\t\u0001\t\u0003\t\u0150\b\t\u0003\t\u0152\b\t\u0001\n"+
		"\u0001\n\u0003\n\u0156\b\n\u0001\n\u0001\n\u0001\n\u0001\n\u0003\n\u015c"+
		"\b\n\u0001\n\u0001\n\u0001\n\u0003\n\u0161\b\n\u0001\n\u0001\n\u0001\n"+
		"\u0001\n\u0001\n\u0001\n\u0001\n\u0005\n\u016a\b\n\n\n\f\n\u016d\t\n\u0001"+
		"\n\u0001\n\u0001\n\u0003\n\u0172\b\n\u0001\u000b\u0001\u000b\u0003\u000b"+
		"\u0176\b\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0003\u000b"+
		"\u017c\b\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0003\u000b\u0181\b"+
		"\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0005"+
		"\u000b\u0188\b\u000b\n\u000b\f\u000b\u018b\t\u000b\u0001\u000b\u0001\u000b"+
		"\u0005\u000b\u018f\b\u000b\n\u000b\f\u000b\u0192\t\u000b\u0001\u000b\u0001"+
		"\u000b\u0001\u000b\u0003\u000b\u0197\b\u000b\u0001\u000b\u0001\u000b\u0003"+
		"\u000b\u019b\b\u000b\u0001\f\u0001\f\u0003\f\u019f\b\f\u0001\f\u0001\f"+
		"\u0001\f\u0001\f\u0003\f\u01a5\b\f\u0001\f\u0001\f\u0001\f\u0003\f\u01aa"+
		"\b\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0003\f\u01b1\b\f\u0001\f"+
		"\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0005\f\u01ba\b\f\n\f"+
		"\f\f\u01bd\t\f\u0003\f\u01bf\b\f\u0003\f\u01c1\b\f\u0001\f\u0001\f\u0001"+
		"\f\u0001\f\u0003\f\u01c7\b\f\u0001\f\u0001\f\u0001\f\u0001\f\u0003\f\u01cd"+
		"\b\f\u0001\f\u0001\f\u0003\f\u01d1\b\f\u0001\f\u0001\f\u0001\f\u0001\f"+
		"\u0001\f\u0003\f\u01d8\b\f\u0001\f\u0001\f\u0004\f\u01dc\b\f\u000b\f\f"+
		"\f\u01dd\u0001\f\u0001\f\u0001\r\u0001\r\u0003\r\u01e4\b\r\u0001\r\u0001"+
		"\r\u0001\r\u0001\r\u0003\r\u01ea\b\r\u0001\r\u0001\r\u0001\r\u0003\r\u01ef"+
		"\b\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\u000e\u0001\u000e\u0001\u000e"+
		"\u0001\u000e\u0001\u000e\u0001\u000e\u0003\u000e\u01fb\b\u000e\u0001\u000e"+
		"\u0001\u000e\u0001\u000e\u0003\u000e\u0200\b\u000e\u0001\u000e\u0001\u000e"+
		"\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0005\u000e"+
		"\u0209\b\u000e\n\u000e\f\u000e\u020c\t\u000e\u0001\u000e\u0001\u000e\u0003"+
		"\u000e\u0210\b\u000e\u0001\u000f\u0003\u000f\u0213\b\u000f\u0001\u000f"+
		"\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0003\u000f\u021a\b\u000f"+
		"\u0001\u0010\u0003\u0010\u021d\b\u0010\u0001\u0010\u0001\u0010\u0001\u0010"+
		"\u0001\u0010\u0001\u0010\u0003\u0010\u0224\b\u0010\u0001\u0010\u0001\u0010"+
		"\u0001\u0010\u0001\u0010\u0001\u0010\u0005\u0010\u022b\b\u0010\n\u0010"+
		"\f\u0010\u022e\t\u0010\u0003\u0010\u0230\b\u0010\u0001\u0010\u0001\u0010"+
		"\u0001\u0010\u0001\u0010\u0003\u0010\u0236\b\u0010\u0003\u0010\u0238\b"+
		"\u0010\u0001\u0011\u0001\u0011\u0003\u0011\u023c\b\u0011\u0001\u0011\u0001"+
		"\u0011\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0003\u0012\u0244"+
		"\b\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0003\u0012\u0249\b\u0012"+
		"\u0001\u0012\u0001\u0012\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013"+
		"\u0003\u0013\u0251\b\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0003\u0013"+
		"\u0256\b\u0013\u0001\u0013\u0001\u0013\u0001\u0014\u0001\u0014\u0001\u0014"+
		"\u0001\u0014\u0003\u0014\u025e\b\u0014\u0001\u0014\u0001\u0014\u0001\u0014"+
		"\u0003\u0014\u0263\b\u0014\u0001\u0014\u0001\u0014\u0001\u0015\u0001\u0015"+
		"\u0001\u0015\u0001\u0015\u0003\u0015\u026b\b\u0015\u0001\u0015\u0001\u0015"+
		"\u0001\u0015\u0003\u0015\u0270\b\u0015\u0001\u0015\u0001\u0015\u0001\u0016"+
		"\u0001\u0016\u0003\u0016\u0276\b\u0016\u0001\u0016\u0001\u0016\u0001\u0016"+
		"\u0005\u0016\u027b\b\u0016\n\u0016\f\u0016\u027e\t\u0016\u0003\u0016\u0280"+
		"\b\u0016\u0001\u0016\u0001\u0016\u0001\u0016\u0001\u0016\u0005\u0016\u0286"+
		"\b\u0016\n\u0016\f\u0016\u0289\t\u0016\u0001\u0016\u0001\u0016\u0001\u0016"+
		"\u0001\u0016\u0001\u0016\u0005\u0016\u0290\b\u0016\n\u0016\f\u0016\u0293"+
		"\t\u0016\u0003\u0016\u0295\b\u0016\u0001\u0016\u0001\u0016\u0001\u0016"+
		"\u0001\u0016\u0003\u0016\u029b\b\u0016\u0003\u0016\u029d\b\u0016\u0001"+
		"\u0017\u0003\u0017\u02a0\b\u0017\u0001\u0017\u0001\u0017\u0001\u0017\u0001"+
		"\u0017\u0001\u0017\u0001\u0017\u0001\u0017\u0001\u0017\u0001\u0017\u0001"+
		"\u0017\u0001\u0017\u0001\u0017\u0001\u0017\u0001\u0017\u0001\u0017\u0001"+
		"\u0017\u0001\u0017\u0003\u0017\u02b3\b\u0017\u0001\u0017\u0001\u0017\u0001"+
		"\u0017\u0001\u0017\u0003\u0017\u02b9\b\u0017\u0001\u0017\u0001\u0017\u0001"+
		"\u0017\u0001\u0017\u0001\u0017\u0005\u0017\u02c0\b\u0017\n\u0017\f\u0017"+
		"\u02c3\t\u0017\u0001\u0017\u0001\u0017\u0003\u0017\u02c7\b\u0017\u0001"+
		"\u0017\u0001\u0017\u0001\u0017\u0001\u0017\u0001\u0017\u0005\u0017\u02ce"+
		"\b\u0017\n\u0017\f\u0017\u02d1\t\u0017\u0001\u0017\u0001\u0017\u0001\u0017"+
		"\u0001\u0017\u0001\u0017\u0001\u0017\u0005\u0017\u02d9\b\u0017\n\u0017"+
		"\f\u0017\u02dc\t\u0017\u0001\u0017\u0001\u0017\u0005\u0017\u02e0\b\u0017"+
		"\n\u0017\f\u0017\u02e3\t\u0017\u0001\u0017\u0001\u0017\u0001\u0017\u0003"+
		"\u0017\u02e8\b\u0017\u0001\u0018\u0001\u0018\u0001\u0018\u0001\u0018\u0003"+
		"\u0018\u02ee\b\u0018\u0001\u0018\u0001\u0018\u0001\u0018\u0001\u0018\u0001"+
		"\u0018\u0001\u0018\u0001\u0018\u0003\u0018\u02f7\b\u0018\u0001\u0019\u0001"+
		"\u0019\u0001\u0019\u0001\u0019\u0001\u0019\u0003\u0019\u02fe\b\u0019\u0001"+
		"\u0019\u0001\u0019\u0003\u0019\u0302\b\u0019\u0003\u0019\u0304\b\u0019"+
		"\u0001\u001a\u0001\u001a\u0003\u001a\u0308\b\u001a\u0001\u001a\u0001\u001a"+
		"\u0001\u001b\u0001\u001b\u0001\u001b\u0003\u001b\u030f\b\u001b\u0003\u001b"+
		"\u0311\b\u001b\u0001\u001b\u0001\u001b\u0003\u001b\u0315\b\u001b\u0001"+
		"\u001b\u0003\u001b\u0318\b\u001b\u0001\u001c\u0001\u001c\u0001\u001c\u0001"+
		"\u001d\u0001\u001d\u0003\u001d\u031f\b\u001d\u0001\u001d\u0001\u001d\u0001"+
		"\u001d\u0005\u001d\u0324\b\u001d\n\u001d\f\u001d\u0327\t\u001d\u0003\u001d"+
		"\u0329\b\u001d\u0001\u001d\u0001\u001d\u0001\u001d\u0001\u001d\u0001\u001d"+
		"\u0001\u001d\u0005\u001d\u0331\b\u001d\n\u001d\f\u001d\u0334\t\u001d\u0003"+
		"\u001d\u0336\b\u001d\u0001\u001d\u0001\u001d\u0001\u001d\u0001\u001d\u0003"+
		"\u001d\u033c\b\u001d\u0003\u001d\u033e\b\u001d\u0001\u001e\u0001\u001e"+
		"\u0003\u001e\u0342\b\u001e\u0001\u001e\u0001\u001e\u0001\u001e\u0005\u001e"+
		"\u0347\b\u001e\n\u001e\f\u001e\u034a\t\u001e\u0003\u001e\u034c\b\u001e"+
		"\u0001\u001e\u0001\u001e\u0001\u001e\u0001\u001e\u0005\u001e\u0352\b\u001e"+
		"\n\u001e\f\u001e\u0355\t\u001e\u0001\u001e\u0001\u001e\u0001\u001e\u0001"+
		"\u001e\u0001\u001e\u0005\u001e\u035c\b\u001e\n\u001e\f\u001e\u035f\t\u001e"+
		"\u0003\u001e\u0361\b\u001e\u0001\u001e\u0001\u001e\u0001\u001e\u0001\u001e"+
		"\u0003\u001e\u0367\b\u001e\u0003\u001e\u0369\b\u001e\u0001\u001f\u0001"+
		"\u001f\u0003\u001f\u036d\b\u001f\u0001\u001f\u0001\u001f\u0001\u001f\u0005"+
		"\u001f\u0372\b\u001f\n\u001f\f\u001f\u0375\t\u001f\u0001\u001f\u0001\u001f"+
		"\u0001\u001f\u0001\u001f\u0005\u001f\u037b\b\u001f\n\u001f\f\u001f\u037e"+
		"\t\u001f\u0001\u001f\u0003\u001f\u0381\b\u001f\u0003\u001f\u0383\b\u001f"+
		"\u0001\u001f\u0001\u001f\u0003\u001f\u0387\b\u001f\u0001\u001f\u0001\u001f"+
		"\u0001\u001f\u0001\u001f\u0001\u001f\u0005\u001f\u038e\b\u001f\n\u001f"+
		"\f\u001f\u0391\t\u001f\u0001\u001f\u0001\u001f\u0003\u001f\u0395\b\u001f"+
		"\u0003\u001f\u0397\b\u001f\u0001\u001f\u0001\u001f\u0001\u001f\u0001\u001f"+
		"\u0001\u001f\u0005\u001f\u039e\b\u001f\n\u001f\f\u001f\u03a1\t\u001f\u0001"+
		"\u001f\u0001\u001f\u0001\u001f\u0001\u001f\u0001\u001f\u0001\u001f\u0005"+
		"\u001f\u03a9\b\u001f\n\u001f\f\u001f\u03ac\t\u001f\u0001\u001f\u0001\u001f"+
		"\u0005\u001f\u03b0\b\u001f\n\u001f\f\u001f\u03b3\t\u001f\u0003\u001f\u03b5"+
		"\b\u001f\u0001 \u0003 \u03b8\b \u0001 \u0001 \u0001 \u0001 \u0001 \u0001"+
		" \u0001 \u0001 \u0001 \u0001 \u0001 \u0003 \u03c5\b \u0001 \u0001 \u0001"+
		" \u0001 \u0001 \u0001 \u0001 \u0001 \u0001 \u0001 \u0005 \u03d1\b \n "+
		"\f \u03d4\t \u0001 \u0001 \u0003 \u03d8\b \u0001!\u0003!\u03db\b!\u0001"+
		"!\u0001!\u0001!\u0001!\u0001!\u0001!\u0001!\u0001!\u0001!\u0001!\u0001"+
		"!\u0003!\u03e8\b!\u0001!\u0001!\u0001!\u0001!\u0001!\u0001!\u0001!\u0001"+
		"!\u0001!\u0001!\u0005!\u03f4\b!\n!\f!\u03f7\t!\u0001!\u0001!\u0003!\u03fb"+
		"\b!\u0001!\u0001!\u0001!\u0001!\u0001!\u0005!\u0402\b!\n!\f!\u0405\t!"+
		"\u0003!\u0407\b!\u0001!\u0001!\u0001!\u0001!\u0003!\u040d\b!\u0003!\u040f"+
		"\b!\u0001\"\u0001\"\u0001#\u0001#\u0003#\u0415\b#\u0001#\u0005#\u0418"+
		"\b#\n#\f#\u041b\t#\u0001$\u0004$\u041e\b$\u000b$\f$\u041f\u0001$\u0001"+
		"$\u0001$\u0001$\u0001$\u0001$\u0001$\u0001$\u0001$\u0001$\u0003$\u042c"+
		"\b$\u0001%\u0001%\u0003%\u0430\b%\u0001%\u0001%\u0001%\u0003%\u0435\b"+
		"%\u0001%\u0001%\u0003%\u0439\b%\u0001%\u0003%\u043c\b%\u0001%\u0001%\u0001"+
		"%\u0001%\u0001%\u0001%\u0001%\u0001%\u0001%\u0001%\u0001%\u0001%\u0001"+
		"%\u0001%\u0001%\u0001%\u0003%\u044e\b%\u0001%\u0001%\u0001%\u0003%\u0453"+
		"\b%\u0001&\u0001&\u0001&\u0003&\u0458\b&\u0001\'\u0001\'\u0001\'\u0001"+
		"\'\u0001\'\u0001\'\u0003\'\u0460\b\'\u0001\'\u0001\'\u0001\'\u0003\'\u0465"+
		"\b\'\u0001\'\u0001\'\u0001\'\u0001\'\u0001\'\u0001\'\u0001\'\u0003\'\u046e"+
		"\b\'\u0001\'\u0001\'\u0001\'\u0005\'\u0473\b\'\n\'\f\'\u0476\t\'\u0001"+
		"\'\u0003\'\u0479\b\'\u0001\'\u0001\'\u0001\'\u0001\'\u0001\'\u0001\'\u0001"+
		"\'\u0001\'\u0001\'\u0001\'\u0001\'\u0001\'\u0001\'\u0001\'\u0003\'\u0489"+
		"\b\'\u0001\'\u0003\'\u048c\b\'\u0001\'\u0001\'\u0001\'\u0001\'\u0001\'"+
		"\u0001\'\u0003\'\u0494\b\'\u0001\'\u0001\'\u0001\'\u0001\'\u0001\'\u0004"+
		"\'\u049b\b\'\u000b\'\f\'\u049c\u0001\'\u0001\'\u0003\'\u04a1\b\'\u0001"+
		"\'\u0001\'\u0001\'\u0003\'\u04a6\b\'\u0001\'\u0001\'\u0001\'\u0001\'\u0001"+
		"\'\u0001\'\u0001\'\u0001\'\u0001\'\u0001\'\u0001\'\u0001\'\u0001\'\u0001"+
		"\'\u0001\'\u0001\'\u0001\'\u0001\'\u0001\'\u0001\'\u0001\'\u0001\'\u0001"+
		"\'\u0001\'\u0001\'\u0001\'\u0001\'\u0001\'\u0003\'\u04c4\b\'\u0001\'\u0001"+
		"\'\u0001\'\u0001\'\u0001\'\u0001\'\u0001\'\u0001\'\u0001\'\u0001\'\u0003"+
		"\'\u04d0\b\'\u0001\'\u0001\'\u0001\'\u0003\'\u04d5\b\'\u0001\'\u0001\'"+
		"\u0001\'\u0001\'\u0001\'\u0001\'\u0001\'\u0001\'\u0001\'\u0001\'\u0003"+
		"\'\u04e1\b\'\u0001\'\u0001\'\u0001\'\u0001\'\u0003\'\u04e7\b\'\u0001\'"+
		"\u0001\'\u0001\'\u0001\'\u0001\'\u0003\'\u04ee\b\'\u0001\'\u0001\'\u0003"+
		"\'\u04f2\b\'\u0001\'\u0001\'\u0001\'\u0001\'\u0001\'\u0001\'\u0005\'\u04fa"+
		"\b\'\n\'\f\'\u04fd\t\'\u0003\'\u04ff\b\'\u0001\'\u0001\'\u0001\'\u0001"+
		"\'\u0003\'\u0505\b\'\u0001\'\u0003\'\u0508\b\'\u0005\'\u050a\b\'\n\'\f"+
		"\'\u050d\t\'\u0001(\u0001(\u0001(\u0001(\u0001(\u0001(\u0005(\u0515\b"+
		"(\n(\f(\u0518\t(\u0001(\u0001(\u0003(\u051c\b(\u0001(\u0001(\u0001(\u0001"+
		"(\u0001(\u0001(\u0001(\u0001(\u0001(\u0001(\u0003(\u0528\b(\u0001(\u0001"+
		"(\u0003(\u052c\b(\u0005(\u052e\b(\n(\f(\u0531\t(\u0001(\u0003(\u0534\b"+
		"(\u0001(\u0001(\u0001(\u0001(\u0001(\u0003(\u053b\b(\u0003(\u053d\b(\u0001"+
		")\u0001)\u0001)\u0001)\u0001)\u0001)\u0003)\u0545\b)\u0001)\u0001)\u0001"+
		"*\u0001*\u0001*\u0003*\u054c\b*\u0001*\u0003*\u054f\b*\u0001+\u0001+\u0003"+
		"+\u0553\b+\u0001+\u0001+\u0001+\u0003+\u0558\b+\u0001+\u0001+\u0001+\u0001"+
		"+\u0005+\u055e\b+\n+\f+\u0561\t+\u0001+\u0001+\u0001+\u0001+\u0001+\u0001"+
		"+\u0001+\u0001+\u0001+\u0001+\u0001+\u0001+\u0001+\u0001+\u0005+\u0571"+
		"\b+\n+\f+\u0574\t+\u0001+\u0001+\u0001+\u0003+\u0579\b+\u0001,\u0001,"+
		"\u0003,\u057d\b,\u0001,\u0001,\u0001,\u0001,\u0001,\u0001,\u0001,\u0001"+
		",\u0001,\u0001,\u0001,\u0001,\u0005,\u058b\b,\n,\f,\u058e\t,\u0001-\u0001"+
		"-\u0001-\u0003-\u0593\b-\u0001-\u0001-\u0001-\u0001-\u0001-\u0001-\u0003"+
		"-\u059b\b-\u0001.\u0001.\u0001.\u0003.\u05a0\b.\u0001.\u0003.\u05a3\b"+
		".\u0001/\u0001/\u0001/\u0003/\u05a8\b/\u00010\u00010\u00010\u00010\u0001"+
		"0\u00050\u05af\b0\n0\f0\u05b2\t0\u00010\u00010\u00030\u05b6\b0\u00010"+
		"\u00010\u00010\u00010\u00010\u00011\u00011\u00011\u00011\u00011\u0001"+
		"1\u00011\u00031\u05c4\b1\u00011\u00031\u05c7\b1\u00031\u05c9\b1\u0001"+
		"2\u00012\u00012\u00032\u05ce\b2\u00012\u00012\u00032\u05d2\b2\u00012\u0003"+
		"2\u05d5\b2\u00012\u00012\u00012\u00012\u00012\u00032\u05dc\b2\u00012\u0001"+
		"2\u00012\u00012\u00052\u05e2\b2\n2\f2\u05e5\t2\u00012\u00032\u05e8\b2"+
		"\u00012\u00012\u00032\u05ec\b2\u00012\u00032\u05ef\b2\u00012\u00012\u0001"+
		"2\u00012\u00032\u05f5\b2\u00012\u00032\u05f8\b2\u00032\u05fa\b2\u0001"+
		"3\u00013\u00013\u00013\u00013\u00053\u0601\b3\n3\f3\u0604\t3\u00014\u0001"+
		"4\u00034\u0608\b4\u00014\u00014\u00034\u060c\b4\u00014\u00014\u00034\u0610"+
		"\b4\u00014\u00034\u0613\b4\u00015\u00015\u00015\u00015\u00015\u00015\u0001"+
		"5\u00055\u061c\b5\n5\f5\u061f\t5\u00015\u00015\u00035\u0623\b5\u00016"+
		"\u00016\u00036\u0627\b6\u00016\u00016\u00016\u00056\u062c\b6\n6\f6\u062f"+
		"\t6\u00016\u00016\u00016\u00016\u00056\u0635\b6\n6\f6\u0638\t6\u00016"+
		"\u00036\u063b\b6\u00036\u063d\b6\u00016\u00016\u00036\u0641\b6\u00016"+
		"\u00016\u00016\u00016\u00016\u00056\u0648\b6\n6\f6\u064b\t6\u00016\u0001"+
		"6\u00036\u064f\b6\u00036\u0651\b6\u00016\u00016\u00016\u00016\u00016\u0005"+
		"6\u0658\b6\n6\f6\u065b\t6\u00016\u00016\u00016\u00016\u00016\u00016\u0005"+
		"6\u0663\b6\n6\f6\u0666\t6\u00016\u00016\u00056\u066a\b6\n6\f6\u066d\t"+
		"6\u00036\u066f\b6\u00017\u00017\u00017\u00017\u00017\u00037\u0676\b7\u0001"+
		"8\u00018\u00018\u00018\u00018\u00058\u067d\b8\n8\f8\u0680\t8\u00018\u0001"+
		"8\u00038\u0684\b8\u00019\u00039\u0687\b9\u00019\u00019\u0001:\u0001:\u0001"+
		";\u0001;\u0001<\u0001<\u0001=\u0001=\u0003=\u0693\b=\u0001>\u0001>\u0001"+
		"?\u0001?\u0001@\u0001@\u0001A\u0001A\u0001B\u0001B\u0001C\u0001C\u0001"+
		"D\u0001D\u0001E\u0001E\u0001F\u0001F\u0001G\u0001G\u0001H\u0001H\u0001"+
		"I\u0001I\u0001J\u0001J\u0001K\u0001K\u0001L\u0001L\u0001M\u0001M\u0001"+
		"N\u0001N\u0001O\u0001O\u0001O\u0001O\u0001O\u0001O\u0003O\u06bd\bO\u0001"+
		"P\u0001P\u0001Q\u0001Q\u0001Q\u0001Q\u0001Q\u0001Q\u0001Q\u0003Q\u06c8"+
		"\bQ\u0001Q\u0000\u0001NR\u0000\u0002\u0004\u0006\b\n\f\u000e\u0010\u0012"+
		"\u0014\u0016\u0018\u001a\u001c\u001e \"$&(*,.02468:<>@BDFHJLNPRTVXZ\\"+
		"^`bdfhjlnprtvxz|~\u0080\u0082\u0084\u0086\u0088\u008a\u008c\u008e\u0090"+
		"\u0092\u0094\u0096\u0098\u009a\u009c\u009e\u00a0\u00a2\u0000\u0012\u0003"+
		"\u0000::EERR\u0002\u0000//BB\u0002\u0000\u0005\u0005jj\u0001\u0000\u0083"+
		"\u0084\u0002\u0000\u001d\u001d>>\u0002\u0000\"\"<<\u0005\u0000\u0019\u0019"+
		"HHQQzz}}\u0002\u0000\u0007\u0007\f\r\u0001\u0000\b\t\u0001\u0000\u000e"+
		"\u0011\u0001\u0000\u0012\u0015\u0004\u0000MMaaccvv\u0002\u0000;;\u008b"+
		"\u008b\u0003\u0000\u0019\u0019HH}}\u0004\u000046hh\u0096\u0096\u0098\u0099"+
		"\u0002\u0000\b\nff\u0002\u0000\u0095\u0095\u0098\u0098\u0001\u0000\u0019"+
		"\u0094\u07d9\u0000\u00a8\u0001\u0000\u0000\u0000\u0002\u00ad\u0001\u0000"+
		"\u0000\u0000\u0004\u00b3\u0001\u0000\u0000\u0000\u0006\u00cd\u0001\u0000"+
		"\u0000\u0000\b\u00ef\u0001\u0000\u0000\u0000\n\u0101\u0001\u0000\u0000"+
		"\u0000\f\u010a\u0001\u0000\u0000\u0000\u000e\u0112\u0001\u0000\u0000\u0000"+
		"\u0010\u011c\u0001\u0000\u0000\u0000\u0012\u012f\u0001\u0000\u0000\u0000"+
		"\u0014\u0153\u0001\u0000\u0000\u0000\u0016\u0173\u0001\u0000\u0000\u0000"+
		"\u0018\u019c\u0001\u0000\u0000\u0000\u001a\u01e1\u0001\u0000\u0000\u0000"+
		"\u001c\u01f4\u0001\u0000\u0000\u0000\u001e\u0212\u0001\u0000\u0000\u0000"+
		" \u021c\u0001\u0000\u0000\u0000\"\u0239\u0001\u0000\u0000\u0000$\u023f"+
		"\u0001\u0000\u0000\u0000&\u024c\u0001\u0000\u0000\u0000(\u0259\u0001\u0000"+
		"\u0000\u0000*\u0266\u0001\u0000\u0000\u0000,\u027f\u0001\u0000\u0000\u0000"+
		".\u029f\u0001\u0000\u0000\u00000\u02e9\u0001\u0000\u0000\u00002\u02f8"+
		"\u0001\u0000\u0000\u00004\u0305\u0001\u0000\u0000\u00006\u030b\u0001\u0000"+
		"\u0000\u00008\u0319\u0001\u0000\u0000\u0000:\u0328\u0001\u0000\u0000\u0000"+
		"<\u034b\u0001\u0000\u0000\u0000>\u03b4\u0001\u0000\u0000\u0000@\u03b7"+
		"\u0001\u0000\u0000\u0000B\u03da\u0001\u0000\u0000\u0000D\u0410\u0001\u0000"+
		"\u0000\u0000F\u0412\u0001\u0000\u0000\u0000H\u041d\u0001\u0000\u0000\u0000"+
		"J\u042f\u0001\u0000\u0000\u0000L\u0457\u0001\u0000\u0000\u0000N\u04a5"+
		"\u0001\u0000\u0000\u0000P\u050e\u0001\u0000\u0000\u0000R\u053e\u0001\u0000"+
		"\u0000\u0000T\u0548\u0001\u0000\u0000\u0000V\u0552\u0001\u0000\u0000\u0000"+
		"X\u057a\u0001\u0000\u0000\u0000Z\u0592\u0001\u0000\u0000\u0000\\\u059c"+
		"\u0001\u0000\u0000\u0000^\u05a7\u0001\u0000\u0000\u0000`\u05a9\u0001\u0000"+
		"\u0000\u0000b\u05c8\u0001\u0000\u0000\u0000d\u05f9\u0001\u0000\u0000\u0000"+
		"f\u05fb\u0001\u0000\u0000\u0000h\u0612\u0001\u0000\u0000\u0000j\u0622"+
		"\u0001\u0000\u0000\u0000l\u066e\u0001\u0000\u0000\u0000n\u0675\u0001\u0000"+
		"\u0000\u0000p\u0677\u0001\u0000\u0000\u0000r\u0686\u0001\u0000\u0000\u0000"+
		"t\u068a\u0001\u0000\u0000\u0000v\u068c\u0001\u0000\u0000\u0000x\u068e"+
		"\u0001\u0000\u0000\u0000z\u0692\u0001\u0000\u0000\u0000|\u0694\u0001\u0000"+
		"\u0000\u0000~\u0696\u0001\u0000\u0000\u0000\u0080\u0698\u0001\u0000\u0000"+
		"\u0000\u0082\u069a\u0001\u0000\u0000\u0000\u0084\u069c\u0001\u0000\u0000"+
		"\u0000\u0086\u069e\u0001\u0000\u0000\u0000\u0088\u06a0\u0001\u0000\u0000"+
		"\u0000\u008a\u06a2\u0001\u0000\u0000\u0000\u008c\u06a4\u0001\u0000\u0000"+
		"\u0000\u008e\u06a6\u0001\u0000\u0000\u0000\u0090\u06a8\u0001\u0000\u0000"+
		"\u0000\u0092\u06aa\u0001\u0000\u0000\u0000\u0094\u06ac\u0001\u0000\u0000"+
		"\u0000\u0096\u06ae\u0001\u0000\u0000\u0000\u0098\u06b0\u0001\u0000\u0000"+
		"\u0000\u009a\u06b2\u0001\u0000\u0000\u0000\u009c\u06b4\u0001\u0000\u0000"+
		"\u0000\u009e\u06bc\u0001\u0000\u0000\u0000\u00a0\u06be\u0001\u0000\u0000"+
		"\u0000\u00a2\u06c7\u0001\u0000\u0000\u0000\u00a4\u00a7\u0003\u0004\u0002"+
		"\u0000\u00a5\u00a7\u0003\u0002\u0001\u0000\u00a6\u00a4\u0001\u0000\u0000"+
		"\u0000\u00a6\u00a5\u0001\u0000\u0000\u0000\u00a7\u00aa\u0001\u0000\u0000"+
		"\u0000\u00a8\u00a6\u0001\u0000\u0000\u0000\u00a8\u00a9\u0001\u0000\u0000"+
		"\u0000\u00a9\u00ab\u0001\u0000\u0000\u0000\u00aa\u00a8\u0001\u0000\u0000"+
		"\u0000\u00ab\u00ac\u0005\u0000\u0000\u0001\u00ac\u0001\u0001\u0000\u0000"+
		"\u0000\u00ad\u00ae\u0005\u009d\u0000\u0000\u00ae\u00af\u0006\u0001\uffff"+
		"\uffff\u0000\u00af\u0003\u0001\u0000\u0000\u0000\u00b0\u00b2\u0005\u0001"+
		"\u0000\u0000\u00b1\u00b0\u0001\u0000\u0000\u0000\u00b2\u00b5\u0001\u0000"+
		"\u0000\u0000\u00b3\u00b1\u0001\u0000\u0000\u0000\u00b3\u00b4\u0001\u0000"+
		"\u0000\u0000\u00b4\u00b6\u0001\u0000\u0000\u0000\u00b5\u00b3\u0001\u0000"+
		"\u0000\u0000\u00b6\u00bf\u0003\u0006\u0003\u0000\u00b7\u00b9\u0005\u0001"+
		"\u0000\u0000\u00b8\u00b7\u0001\u0000\u0000\u0000\u00b9\u00ba\u0001\u0000"+
		"\u0000\u0000\u00ba\u00b8\u0001\u0000\u0000\u0000\u00ba\u00bb\u0001\u0000"+
		"\u0000\u0000\u00bb\u00bc\u0001\u0000\u0000\u0000\u00bc\u00be\u0003\u0006"+
		"\u0003\u0000\u00bd\u00b8\u0001\u0000\u0000\u0000\u00be\u00c1\u0001\u0000"+
		"\u0000\u0000\u00bf\u00bd\u0001\u0000\u0000\u0000\u00bf\u00c0\u0001\u0000"+
		"\u0000\u0000\u00c0\u00c5\u0001\u0000\u0000\u0000\u00c1\u00bf\u0001\u0000"+
		"\u0000\u0000\u00c2\u00c4\u0005\u0001\u0000\u0000\u00c3\u00c2\u0001\u0000"+
		"\u0000\u0000\u00c4\u00c7\u0001\u0000\u0000\u0000\u00c5\u00c3\u0001\u0000"+
		"\u0000\u0000\u00c5\u00c6\u0001\u0000\u0000\u0000\u00c6\u0005\u0001\u0000"+
		"\u0000\u0000\u00c7\u00c5\u0001\u0000\u0000\u0000\u00c8\u00cb\u0005G\u0000"+
		"\u0000\u00c9\u00ca\u0005r\u0000\u0000\u00ca\u00cc\u0005o\u0000\u0000\u00cb"+
		"\u00c9\u0001\u0000\u0000\u0000\u00cb\u00cc\u0001\u0000\u0000\u0000\u00cc"+
		"\u00ce\u0001\u0000\u0000\u0000\u00cd\u00c8\u0001\u0000\u0000\u0000\u00cd"+
		"\u00ce\u0001\u0000\u0000\u0000\u00ce\u00ed\u0001\u0000\u0000\u0000\u00cf"+
		"\u00ee\u0003\b\u0004\u0000\u00d0\u00ee\u0003\n\u0005\u0000\u00d1\u00ee"+
		"\u0003\f\u0006\u0000\u00d2\u00ee\u0003\u000e\u0007\u0000\u00d3\u00ee\u0003"+
		"\u0010\b\u0000\u00d4\u00ee\u0003\u0012\t\u0000\u00d5\u00ee\u0003\u0014"+
		"\n\u0000\u00d6\u00ee\u0003\u0016\u000b\u0000\u00d7\u00ee\u0003\u0018\f"+
		"\u0000\u00d8\u00ee\u0003\u001a\r\u0000\u00d9\u00ee\u0003\u001c\u000e\u0000"+
		"\u00da\u00ee\u0003\u001e\u000f\u0000\u00db\u00ee\u0003 \u0010\u0000\u00dc"+
		"\u00ee\u0003\"\u0011\u0000\u00dd\u00ee\u0003$\u0012\u0000\u00de\u00ee"+
		"\u0003&\u0013\u0000\u00df\u00ee\u0003(\u0014\u0000\u00e0\u00ee\u0003*"+
		"\u0015\u0000\u00e1\u00ee\u0003,\u0016\u0000\u00e2\u00ee\u0003.\u0017\u0000"+
		"\u00e3\u00ee\u00030\u0018\u0000\u00e4\u00ee\u00032\u0019\u0000\u00e5\u00ee"+
		"\u00034\u001a\u0000\u00e6\u00ee\u00036\u001b\u0000\u00e7\u00ee\u00038"+
		"\u001c\u0000\u00e8\u00ee\u0003:\u001d\u0000\u00e9\u00ee\u0003<\u001e\u0000"+
		"\u00ea\u00ee\u0003@ \u0000\u00eb\u00ee\u0003B!\u0000\u00ec\u00ee\u0003"+
		"D\"\u0000\u00ed\u00cf\u0001\u0000\u0000\u0000\u00ed\u00d0\u0001\u0000"+
		"\u0000\u0000\u00ed\u00d1\u0001\u0000\u0000\u0000\u00ed\u00d2\u0001\u0000"+
		"\u0000\u0000\u00ed\u00d3\u0001\u0000\u0000\u0000\u00ed\u00d4\u0001\u0000"+
		"\u0000\u0000\u00ed\u00d5\u0001\u0000\u0000\u0000\u00ed\u00d6\u0001\u0000"+
		"\u0000\u0000\u00ed\u00d7\u0001\u0000\u0000\u0000\u00ed\u00d8\u0001\u0000"+
		"\u0000\u0000\u00ed\u00d9\u0001\u0000\u0000\u0000\u00ed\u00da\u0001\u0000"+
		"\u0000\u0000\u00ed\u00db\u0001\u0000\u0000\u0000\u00ed\u00dc\u0001\u0000"+
		"\u0000\u0000\u00ed\u00dd\u0001\u0000\u0000\u0000\u00ed\u00de\u0001\u0000"+
		"\u0000\u0000\u00ed\u00df\u0001\u0000\u0000\u0000\u00ed\u00e0\u0001\u0000"+
		"\u0000\u0000\u00ed\u00e1\u0001\u0000\u0000\u0000\u00ed\u00e2\u0001\u0000"+
		"\u0000\u0000\u00ed\u00e3\u0001\u0000\u0000\u0000\u00ed\u00e4\u0001\u0000"+
		"\u0000\u0000\u00ed\u00e5\u0001\u0000\u0000\u0000\u00ed\u00e6\u0001\u0000"+
		"\u0000\u0000\u00ed\u00e7\u0001\u0000\u0000\u0000\u00ed\u00e8\u0001\u0000"+
		"\u0000\u0000\u00ed\u00e9\u0001\u0000\u0000\u0000\u00ed\u00ea\u0001\u0000"+
		"\u0000\u0000\u00ed\u00eb\u0001\u0000\u0000\u0000\u00ed\u00ec\u0001\u0000"+
		"\u0000\u0000\u00ee\u0007\u0001\u0000\u0000\u0000\u00ef\u00f0\u0005\u001e"+
		"\u0000\u0000\u00f0\u00f4\u0005\u0082\u0000\u0000\u00f1\u00f2\u0003\u0084"+
		"B\u0000\u00f2\u00f3\u0005\u0002\u0000\u0000\u00f3\u00f5\u0001\u0000\u0000"+
		"\u0000\u00f4\u00f1\u0001\u0000\u0000\u0000\u00f4\u00f5\u0001\u0000\u0000"+
		"\u0000\u00f5\u00f6\u0001\u0000\u0000\u0000\u00f6\u00ff\u0003\u0086C\u0000"+
		"\u00f7\u00f8\u0005y\u0000\u0000\u00f8\u00f9\u0005\u0086\u0000\u0000\u00f9"+
		"\u0100\u0003\u008aE\u0000\u00fa\u00fc\u0005\u001b\u0000\u0000\u00fb\u00fd"+
		"\u0005.\u0000\u0000\u00fc\u00fb\u0001\u0000\u0000\u0000\u00fc\u00fd\u0001"+
		"\u0000\u0000\u0000\u00fd\u00fe\u0001\u0000\u0000\u0000\u00fe\u0100\u0003"+
		"F#\u0000\u00ff\u00f7\u0001\u0000\u0000\u0000\u00ff\u00fa\u0001\u0000\u0000"+
		"\u0000\u0100\t\u0001\u0000\u0000\u0000\u0101\u0108\u0005\u001f\u0000\u0000"+
		"\u0102\u0109\u0003\u0084B\u0000\u0103\u0109\u0003\u0088D\u0000\u0104\u0105"+
		"\u0003\u0084B\u0000\u0105\u0106\u0005\u0002\u0000\u0000\u0106\u0107\u0003"+
		"\u0088D\u0000\u0107\u0109\u0001\u0000\u0000\u0000\u0108\u0102\u0001\u0000"+
		"\u0000\u0000\u0108\u0103\u0001\u0000\u0000\u0000\u0108\u0104\u0001\u0000"+
		"\u0000\u0000\u0108\u0109\u0001\u0000\u0000\u0000\u0109\u000b\u0001\u0000"+
		"\u0000\u0000\u010a\u010c\u0005#\u0000\u0000\u010b\u010d\u00057\u0000\u0000"+
		"\u010c\u010b\u0001\u0000\u0000\u0000\u010c\u010d\u0001\u0000\u0000\u0000"+
		"\u010d\u010e\u0001\u0000\u0000\u0000\u010e\u010f\u0003N\'\u0000\u010f"+
		"\u0110\u0005!\u0000\u0000\u0110\u0111\u0003\u0084B\u0000\u0111\r\u0001"+
		"\u0000\u0000\u0000\u0112\u0114\u0005&\u0000\u0000\u0113\u0115\u0007\u0000"+
		"\u0000\u0000\u0114\u0113\u0001\u0000\u0000\u0000\u0114\u0115\u0001\u0000"+
		"\u0000\u0000\u0115\u011a\u0001\u0000\u0000\u0000\u0116\u0118\u0005\u0087"+
		"\u0000\u0000\u0117\u0119\u0003\u00a0P\u0000\u0118\u0117\u0001\u0000\u0000"+
		"\u0000\u0118\u0119\u0001\u0000\u0000\u0000\u0119\u011b\u0001\u0000\u0000"+
		"\u0000\u011a\u0116\u0001\u0000\u0000\u0000\u011a\u011b\u0001\u0000\u0000"+
		"\u0000\u011b\u000f\u0001\u0000\u0000\u0000\u011c\u0121\u0007\u0001\u0000"+
		"\u0000\u011d\u011f\u0005\u0087\u0000\u0000\u011e\u0120\u0003\u00a0P\u0000"+
		"\u011f\u011e\u0001\u0000\u0000\u0000\u011f\u0120\u0001\u0000\u0000\u0000"+
		"\u0120\u0122\u0001\u0000\u0000\u0000\u0121\u011d\u0001\u0000\u0000\u0000"+
		"\u0121\u0122\u0001\u0000\u0000\u0000\u0122\u0011\u0001\u0000\u0000\u0000"+
		"\u0123\u0125\u0005\u0093\u0000\u0000\u0124\u0126\u0005t\u0000\u0000\u0125"+
		"\u0124\u0001\u0000\u0000\u0000\u0125\u0126\u0001\u0000\u0000\u0000\u0126"+
		"\u0127\u0001\u0000\u0000\u0000\u0127\u012c\u0003`0\u0000\u0128\u0129\u0005"+
		"\u0005\u0000\u0000\u0129\u012b\u0003`0\u0000\u012a\u0128\u0001\u0000\u0000"+
		"\u0000\u012b\u012e\u0001\u0000\u0000\u0000\u012c\u012a\u0001\u0000\u0000"+
		"\u0000\u012c\u012d\u0001\u0000\u0000\u0000\u012d\u0130\u0001\u0000\u0000"+
		"\u0000\u012e\u012c\u0001\u0000\u0000\u0000\u012f\u0123\u0001\u0000\u0000"+
		"\u0000\u012f\u0130\u0001\u0000\u0000\u0000\u0130\u0131\u0001\u0000\u0000"+
		"\u0000\u0131\u013b\u0003l6\u0000\u0132\u0134\u0005\u0089\u0000\u0000\u0133"+
		"\u0135\u0005\u001d\u0000\u0000\u0134\u0133\u0001\u0000\u0000\u0000\u0134"+
		"\u0135\u0001\u0000\u0000\u0000\u0135\u0139\u0001\u0000\u0000\u0000\u0136"+
		"\u0139\u0005Z\u0000\u0000\u0137\u0139\u0005D\u0000\u0000\u0138\u0132\u0001"+
		"\u0000\u0000\u0000\u0138\u0136\u0001\u0000\u0000\u0000\u0138\u0137\u0001"+
		"\u0000\u0000\u0000\u0139\u013a\u0001\u0000\u0000\u0000\u013a\u013c\u0003"+
		"l6\u0000\u013b\u0138\u0001\u0000\u0000\u0000\u013c\u013d\u0001\u0000\u0000"+
		"\u0000\u013d\u013b\u0001\u0000\u0000\u0000\u013d\u013e\u0001\u0000\u0000"+
		"\u0000\u013e\u0149\u0001\u0000\u0000\u0000\u013f\u0140\u0005m\u0000\u0000"+
		"\u0140\u0141\u0005(\u0000\u0000\u0141\u0146\u0003\\.\u0000\u0142\u0143"+
		"\u0005\u0005\u0000\u0000\u0143\u0145\u0003\\.\u0000\u0144\u0142\u0001"+
		"\u0000\u0000\u0000\u0145\u0148\u0001\u0000\u0000\u0000\u0146\u0144\u0001"+
		"\u0000\u0000\u0000\u0146\u0147\u0001\u0000\u0000\u0000\u0147\u014a\u0001"+
		"\u0000\u0000\u0000\u0148\u0146\u0001\u0000\u0000\u0000\u0149\u013f\u0001"+
		"\u0000\u0000\u0000\u0149\u014a\u0001\u0000\u0000\u0000\u014a\u0151\u0001"+
		"\u0000\u0000\u0000\u014b\u014c\u0005b\u0000\u0000\u014c\u014f\u0003N\'"+
		"\u0000\u014d\u014e\u0007\u0002\u0000\u0000\u014e\u0150\u0003N\'\u0000"+
		"\u014f\u014d\u0001\u0000\u0000\u0000\u014f\u0150\u0001\u0000\u0000\u0000"+
		"\u0150\u0152\u0001\u0000\u0000\u0000\u0151\u014b\u0001\u0000\u0000\u0000"+
		"\u0151\u0152\u0001\u0000\u0000\u0000\u0152\u0013\u0001\u0000\u0000\u0000"+
		"\u0153\u0155\u00052\u0000\u0000\u0154\u0156\u0005\u008a\u0000\u0000\u0155"+
		"\u0154\u0001\u0000\u0000\u0000\u0155\u0156\u0001\u0000\u0000\u0000\u0156"+
		"\u0157\u0001\u0000\u0000\u0000\u0157\u015b\u0005T\u0000\u0000\u0158\u0159"+
		"\u0005P\u0000\u0000\u0159\u015a\u0005f\u0000\u0000\u015a\u015c\u0005F"+
		"\u0000\u0000\u015b\u0158\u0001\u0000\u0000\u0000\u015b\u015c\u0001\u0000"+
		"\u0000\u0000\u015c\u0160\u0001\u0000\u0000\u0000\u015d\u015e\u0003\u0084"+
		"B\u0000\u015e\u015f\u0005\u0002\u0000\u0000\u015f\u0161\u0001\u0000\u0000"+
		"\u0000\u0160\u015d\u0001\u0000\u0000\u0000\u0160\u0161\u0001\u0000\u0000"+
		"\u0000\u0161\u0162\u0001\u0000\u0000\u0000\u0162\u0163\u0003\u0092I\u0000"+
		"\u0163\u0164\u0005k\u0000\u0000\u0164\u0165\u0003\u0086C\u0000\u0165\u0166"+
		"\u0005\u0003\u0000\u0000\u0166\u016b\u0003T*\u0000\u0167\u0168\u0005\u0005"+
		"\u0000\u0000\u0168\u016a\u0003T*\u0000\u0169\u0167\u0001\u0000\u0000\u0000"+
		"\u016a\u016d\u0001\u0000\u0000\u0000\u016b\u0169\u0001\u0000\u0000\u0000"+
		"\u016b\u016c\u0001\u0000\u0000\u0000\u016c\u016e\u0001\u0000\u0000\u0000"+
		"\u016d\u016b\u0001\u0000\u0000\u0000\u016e\u0171\u0005\u0004\u0000\u0000"+
		"\u016f\u0170\u0005\u0092\u0000\u0000\u0170\u0172\u0003N\'\u0000\u0171"+
		"\u016f\u0001\u0000\u0000\u0000\u0171\u0172\u0001\u0000\u0000\u0000\u0172"+
		"\u0015\u0001\u0000\u0000\u0000\u0173\u0175\u00052\u0000\u0000\u0174\u0176"+
		"\u0007\u0003\u0000\u0000\u0175\u0174\u0001\u0000\u0000\u0000\u0175\u0176"+
		"\u0001\u0000\u0000\u0000\u0176\u0177\u0001\u0000\u0000\u0000\u0177\u017b"+
		"\u0005\u0082\u0000\u0000\u0178\u0179\u0005P\u0000\u0000\u0179\u017a\u0005"+
		"f\u0000\u0000\u017a\u017c\u0005F\u0000\u0000\u017b\u0178\u0001\u0000\u0000"+
		"\u0000\u017b\u017c\u0001\u0000\u0000\u0000\u017c\u0180\u0001\u0000\u0000"+
		"\u0000\u017d\u017e\u0003\u0084B\u0000\u017e\u017f\u0005\u0002\u0000\u0000"+
		"\u017f\u0181\u0001\u0000\u0000\u0000\u0180\u017d\u0001\u0000\u0000\u0000"+
		"\u0180\u0181\u0001\u0000\u0000\u0000\u0181\u0182\u0001\u0000\u0000\u0000"+
		"\u0182\u019a\u0003\u0086C\u0000\u0183\u0184\u0005\u0003\u0000\u0000\u0184"+
		"\u0189\u0003F#\u0000\u0185\u0186\u0005\u0005\u0000\u0000\u0186\u0188\u0003"+
		"F#\u0000\u0187\u0185\u0001\u0000\u0000\u0000\u0188\u018b\u0001\u0000\u0000"+
		"\u0000\u0189\u0187\u0001\u0000\u0000\u0000\u0189\u018a\u0001\u0000\u0000"+
		"\u0000\u018a\u0190\u0001\u0000\u0000\u0000\u018b\u0189\u0001\u0000\u0000"+
		"\u0000\u018c\u018d\u0005\u0005\u0000\u0000\u018d\u018f\u0003V+\u0000\u018e"+
		"\u018c\u0001\u0000\u0000\u0000\u018f\u0192\u0001\u0000\u0000\u0000\u0190"+
		"\u018e\u0001\u0000\u0000\u0000\u0190\u0191\u0001\u0000\u0000\u0000\u0191"+
		"\u0193\u0001\u0000\u0000\u0000\u0192\u0190\u0001\u0000\u0000\u0000\u0193"+
		"\u0196\u0005\u0004\u0000\u0000\u0194\u0195\u0005\u0094\u0000\u0000\u0195"+
		"\u0197\u0005\u0095\u0000\u0000\u0196\u0194\u0001\u0000\u0000\u0000\u0196"+
		"\u0197\u0001\u0000\u0000\u0000\u0197\u019b\u0001\u0000\u0000\u0000\u0198"+
		"\u0199\u0005!\u0000\u0000\u0199\u019b\u0003<\u001e\u0000\u019a\u0183\u0001"+
		"\u0000\u0000\u0000\u019a\u0198\u0001\u0000\u0000\u0000\u019b\u0017\u0001"+
		"\u0000\u0000\u0000\u019c\u019e\u00052\u0000\u0000\u019d\u019f\u0007\u0003"+
		"\u0000\u0000\u019e\u019d\u0001\u0000\u0000\u0000\u019e\u019f\u0001\u0000"+
		"\u0000\u0000\u019f\u01a0\u0001\u0000\u0000\u0000\u01a0\u01a4\u0005\u0088"+
		"\u0000\u0000\u01a1\u01a2\u0005P\u0000\u0000\u01a2\u01a3\u0005f\u0000\u0000"+
		"\u01a3\u01a5\u0005F\u0000\u0000\u01a4\u01a1\u0001\u0000\u0000\u0000\u01a4"+
		"\u01a5\u0001\u0000\u0000\u0000\u01a5\u01a9\u0001\u0000\u0000\u0000\u01a6"+
		"\u01a7\u0003\u0084B\u0000\u01a7\u01a8\u0005\u0002\u0000\u0000\u01a8\u01aa"+
		"\u0001\u0000\u0000\u0000\u01a9\u01a6\u0001\u0000\u0000\u0000\u01a9\u01aa"+
		"\u0001\u0000\u0000\u0000\u01aa\u01ab\u0001\u0000\u0000\u0000\u01ab\u01b0"+
		"\u0003\u0094J\u0000\u01ac\u01b1\u0005%\u0000\u0000\u01ad\u01b1\u0005\u001c"+
		"\u0000\u0000\u01ae\u01af\u0005Y\u0000\u0000\u01af\u01b1\u0005i\u0000\u0000"+
		"\u01b0\u01ac\u0001\u0000\u0000\u0000\u01b0\u01ad\u0001\u0000\u0000\u0000"+
		"\u01b0\u01ae\u0001\u0000\u0000\u0000\u01b0\u01b1\u0001\u0000\u0000\u0000"+
		"\u01b1\u01c0\u0001\u0000\u0000\u0000\u01b2\u01c1\u0005;\u0000\u0000\u01b3"+
		"\u01c1\u0005X\u0000\u0000\u01b4\u01be\u0005\u008b\u0000\u0000\u01b5\u01b6"+
		"\u0005i\u0000\u0000\u01b6\u01bb\u0003\u008cF\u0000\u01b7\u01b8\u0005\u0005"+
		"\u0000\u0000\u01b8\u01ba\u0003\u008cF\u0000\u01b9\u01b7\u0001\u0000\u0000"+
		"\u0000\u01ba\u01bd\u0001\u0000\u0000\u0000\u01bb\u01b9\u0001\u0000\u0000"+
		"\u0000\u01bb\u01bc\u0001\u0000\u0000\u0000\u01bc\u01bf\u0001\u0000\u0000"+
		"\u0000\u01bd\u01bb\u0001\u0000\u0000\u0000\u01be\u01b5\u0001\u0000\u0000"+
		"\u0000\u01be\u01bf\u0001\u0000\u0000\u0000\u01bf\u01c1\u0001\u0000\u0000"+
		"\u0000\u01c0\u01b2\u0001\u0000\u0000\u0000\u01c0\u01b3\u0001\u0000\u0000"+
		"\u0000\u01c0\u01b4\u0001\u0000\u0000\u0000\u01c1\u01c2\u0001\u0000\u0000"+
		"\u0000\u01c2\u01c6\u0005k\u0000\u0000\u01c3\u01c4\u0003\u0084B\u0000\u01c4"+
		"\u01c5\u0005\u0002\u0000\u0000\u01c5\u01c7\u0001\u0000\u0000\u0000\u01c6"+
		"\u01c3\u0001\u0000\u0000\u0000\u01c6\u01c7\u0001\u0000\u0000\u0000\u01c7"+
		"\u01c8\u0001\u0000\u0000\u0000\u01c8\u01cc\u0003\u0086C\u0000\u01c9\u01ca"+
		"\u0005I\u0000\u0000\u01ca\u01cb\u0005@\u0000\u0000\u01cb\u01cd\u0005~"+
		"\u0000\u0000\u01cc\u01c9\u0001\u0000\u0000\u0000\u01cc\u01cd\u0001\u0000"+
		"\u0000\u0000\u01cd\u01d0\u0001\u0000\u0000\u0000\u01ce\u01cf\u0005\u0091"+
		"\u0000\u0000\u01cf\u01d1\u0003N\'\u0000\u01d0\u01ce\u0001\u0000\u0000"+
		"\u0000\u01d0\u01d1\u0001\u0000\u0000\u0000\u01d1\u01d2\u0001\u0000\u0000"+
		"\u0000\u01d2\u01db\u0005&\u0000\u0000\u01d3\u01d8\u0003@ \u0000\u01d4"+
		"\u01d8\u0003.\u0017\u0000\u01d5\u01d8\u0003\u001e\u000f\u0000\u01d6\u01d8"+
		"\u0003<\u001e\u0000\u01d7\u01d3\u0001\u0000\u0000\u0000\u01d7\u01d4\u0001"+
		"\u0000\u0000\u0000\u01d7\u01d5\u0001\u0000\u0000\u0000\u01d7\u01d6\u0001"+
		"\u0000\u0000\u0000\u01d8\u01d9\u0001\u0000\u0000\u0000\u01d9\u01da\u0005"+
		"\u0001\u0000\u0000\u01da\u01dc\u0001\u0000\u0000\u0000\u01db\u01d7\u0001"+
		"\u0000\u0000\u0000\u01dc\u01dd\u0001\u0000\u0000\u0000\u01dd\u01db\u0001"+
		"\u0000\u0000\u0000\u01dd\u01de\u0001\u0000\u0000\u0000\u01de\u01df\u0001"+
		"\u0000\u0000\u0000\u01df\u01e0\u0005B\u0000\u0000\u01e0\u0019\u0001\u0000"+
		"\u0000\u0000\u01e1\u01e3\u00052\u0000\u0000\u01e2\u01e4\u0007\u0003\u0000"+
		"\u0000\u01e3\u01e2\u0001\u0000\u0000\u0000\u01e3\u01e4\u0001\u0000\u0000"+
		"\u0000\u01e4\u01e5\u0001\u0000\u0000\u0000\u01e5\u01e9\u0005\u008f\u0000"+
		"\u0000\u01e6\u01e7\u0005P\u0000\u0000\u01e7\u01e8\u0005f\u0000\u0000\u01e8"+
		"\u01ea\u0005F\u0000\u0000\u01e9\u01e6\u0001\u0000\u0000\u0000\u01e9\u01ea"+
		"\u0001\u0000\u0000\u0000\u01ea\u01ee\u0001\u0000\u0000\u0000\u01eb\u01ec"+
		"\u0003\u0084B\u0000\u01ec\u01ed\u0005\u0002\u0000\u0000\u01ed\u01ef\u0001"+
		"\u0000\u0000\u0000\u01ee\u01eb\u0001\u0000\u0000\u0000\u01ee\u01ef\u0001"+
		"\u0000\u0000\u0000\u01ef\u01f0\u0001\u0000\u0000\u0000\u01f0\u01f1\u0003"+
		"\u0096K\u0000\u01f1\u01f2\u0005!\u0000\u0000\u01f2\u01f3\u0003<\u001e"+
		"\u0000\u01f3\u001b\u0001\u0000\u0000\u0000\u01f4\u01f5\u00052\u0000\u0000"+
		"\u01f5\u01f6\u0005\u0090\u0000\u0000\u01f6\u01fa\u0005\u0082\u0000\u0000"+
		"\u01f7\u01f8\u0005P\u0000\u0000\u01f8\u01f9\u0005f\u0000\u0000\u01f9\u01fb"+
		"\u0005F\u0000\u0000\u01fa\u01f7\u0001\u0000\u0000\u0000\u01fa\u01fb\u0001"+
		"\u0000\u0000\u0000\u01fb\u01ff\u0001\u0000\u0000\u0000\u01fc\u01fd\u0003"+
		"\u0084B\u0000\u01fd\u01fe\u0005\u0002\u0000\u0000\u01fe\u0200\u0001\u0000"+
		"\u0000\u0000\u01ff\u01fc\u0001\u0000\u0000\u0000\u01ff\u0200\u0001\u0000"+
		"\u0000\u0000\u0200\u0201\u0001\u0000\u0000\u0000\u0201\u0202\u0003\u0086"+
		"C\u0000\u0202\u0203\u0005\u008c\u0000\u0000\u0203\u020f\u0003\u0098L\u0000"+
		"\u0204\u0205\u0005\u0003\u0000\u0000\u0205\u020a\u0003z=\u0000\u0206\u0207"+
		"\u0005\u0005\u0000\u0000\u0207\u0209\u0003z=\u0000\u0208\u0206\u0001\u0000"+
		"\u0000\u0000\u0209\u020c\u0001\u0000\u0000\u0000\u020a\u0208\u0001\u0000"+
		"\u0000\u0000\u020a\u020b\u0001\u0000\u0000\u0000\u020b\u020d\u0001\u0000"+
		"\u0000\u0000\u020c\u020a\u0001\u0000\u0000\u0000\u020d\u020e\u0005\u0004"+
		"\u0000\u0000\u020e\u0210\u0001\u0000\u0000\u0000\u020f\u0204\u0001\u0000"+
		"\u0000\u0000\u020f\u0210\u0001\u0000\u0000\u0000\u0210\u001d\u0001\u0000"+
		"\u0000\u0000\u0211\u0213\u0003X,\u0000\u0212\u0211\u0001\u0000\u0000\u0000"+
		"\u0212\u0213\u0001\u0000\u0000\u0000\u0213\u0214\u0001\u0000\u0000\u0000"+
		"\u0214\u0215\u0005;\u0000\u0000\u0215\u0216\u0005K\u0000\u0000\u0216\u0219"+
		"\u0003Z-\u0000\u0217\u0218\u0005\u0092\u0000\u0000\u0218\u021a\u0003N"+
		"\'\u0000\u0219\u0217\u0001\u0000\u0000\u0000\u0219\u021a\u0001\u0000\u0000"+
		"\u0000\u021a\u001f\u0001\u0000\u0000\u0000\u021b\u021d\u0003X,\u0000\u021c"+
		"\u021b\u0001\u0000\u0000\u0000\u021c\u021d\u0001\u0000\u0000\u0000\u021d"+
		"\u021e\u0001\u0000\u0000\u0000\u021e\u021f\u0005;\u0000\u0000\u021f\u0220"+
		"\u0005K\u0000\u0000\u0220\u0223\u0003Z-\u0000\u0221\u0222\u0005\u0092"+
		"\u0000\u0000\u0222\u0224\u0003N\'\u0000\u0223\u0221\u0001\u0000\u0000"+
		"\u0000\u0223\u0224\u0001\u0000\u0000\u0000\u0224\u0237\u0001\u0000\u0000"+
		"\u0000\u0225\u0226\u0005m\u0000\u0000\u0226\u0227\u0005(\u0000\u0000\u0227"+
		"\u022c\u0003\\.\u0000\u0228\u0229\u0005\u0005\u0000\u0000\u0229\u022b"+
		"\u0003\\.\u0000\u022a\u0228\u0001\u0000\u0000\u0000\u022b\u022e\u0001"+
		"\u0000\u0000\u0000\u022c\u022a\u0001\u0000\u0000\u0000\u022c\u022d\u0001"+
		"\u0000\u0000\u0000\u022d\u0230\u0001\u0000\u0000\u0000\u022e\u022c\u0001"+
		"\u0000\u0000\u0000\u022f\u0225\u0001\u0000\u0000\u0000\u022f\u0230\u0001"+
		"\u0000\u0000\u0000\u0230\u0231\u0001\u0000\u0000\u0000\u0231\u0232\u0005"+
		"b\u0000\u0000\u0232\u0235\u0003N\'\u0000\u0233\u0234\u0007\u0002\u0000"+
		"\u0000\u0234\u0236\u0003N\'\u0000\u0235\u0233\u0001\u0000\u0000\u0000"+
		"\u0235\u0236\u0001\u0000\u0000\u0000\u0236\u0238\u0001\u0000\u0000\u0000"+
		"\u0237\u022f\u0001\u0000\u0000\u0000\u0237\u0238\u0001\u0000\u0000\u0000"+
		"\u0238!\u0001\u0000\u0000\u0000\u0239\u023b\u0005=\u0000\u0000\u023a\u023c"+
		"\u00057\u0000\u0000\u023b\u023a\u0001\u0000\u0000\u0000\u023b\u023c\u0001"+
		"\u0000\u0000\u0000\u023c\u023d\u0001\u0000\u0000\u0000\u023d\u023e\u0003"+
		"\u0084B\u0000\u023e#\u0001\u0000\u0000\u0000\u023f\u0240\u0005?\u0000"+
		"\u0000\u0240\u0243\u0005T\u0000\u0000\u0241\u0242\u0005P\u0000\u0000\u0242"+
		"\u0244\u0005F\u0000\u0000\u0243\u0241\u0001\u0000\u0000\u0000\u0243\u0244"+
		"\u0001\u0000\u0000\u0000\u0244\u0248\u0001\u0000\u0000\u0000\u0245\u0246"+
		"\u0003\u0084B\u0000\u0246\u0247\u0005\u0002\u0000\u0000\u0247\u0249\u0001"+
		"\u0000\u0000\u0000\u0248\u0245\u0001\u0000\u0000\u0000\u0248\u0249\u0001"+
		"\u0000\u0000\u0000\u0249\u024a\u0001\u0000\u0000\u0000\u024a\u024b\u0003"+
		"\u0092I\u0000\u024b%\u0001\u0000\u0000\u0000\u024c\u024d\u0005?\u0000"+
		"\u0000\u024d\u0250\u0005\u0082\u0000\u0000\u024e\u024f\u0005P\u0000\u0000"+
		"\u024f\u0251\u0005F\u0000\u0000\u0250\u024e\u0001\u0000\u0000\u0000\u0250"+
		"\u0251\u0001\u0000\u0000\u0000\u0251\u0255\u0001\u0000\u0000\u0000\u0252"+
		"\u0253\u0003\u0084B\u0000\u0253\u0254\u0005\u0002\u0000\u0000\u0254\u0256"+
		"\u0001\u0000\u0000\u0000\u0255\u0252\u0001\u0000\u0000\u0000\u0255\u0256"+
		"\u0001\u0000\u0000\u0000\u0256\u0257\u0001\u0000\u0000\u0000\u0257\u0258"+
		"\u0003\u0086C\u0000\u0258\'\u0001\u0000\u0000\u0000\u0259\u025a\u0005"+
		"?\u0000\u0000\u025a\u025d\u0005\u0088\u0000\u0000\u025b\u025c\u0005P\u0000"+
		"\u0000\u025c\u025e\u0005F\u0000\u0000\u025d\u025b\u0001\u0000\u0000\u0000"+
		"\u025d\u025e\u0001\u0000\u0000\u0000\u025e\u0262\u0001\u0000\u0000\u0000"+
		"\u025f\u0260\u0003\u0084B\u0000\u0260\u0261\u0005\u0002\u0000\u0000\u0261"+
		"\u0263\u0001\u0000\u0000\u0000\u0262\u025f\u0001\u0000\u0000\u0000\u0262"+
		"\u0263\u0001\u0000\u0000\u0000\u0263\u0264\u0001\u0000\u0000\u0000\u0264"+
		"\u0265\u0003\u0094J\u0000\u0265)\u0001\u0000\u0000\u0000\u0266\u0267\u0005"+
		"?\u0000\u0000\u0267\u026a\u0005\u008f\u0000\u0000\u0268\u0269\u0005P\u0000"+
		"\u0000\u0269\u026b\u0005F\u0000\u0000\u026a\u0268\u0001\u0000\u0000\u0000"+
		"\u026a\u026b\u0001\u0000\u0000\u0000\u026b\u026f\u0001\u0000\u0000\u0000"+
		"\u026c\u026d\u0003\u0084B\u0000\u026d\u026e\u0005\u0002\u0000\u0000\u026e"+
		"\u0270\u0001\u0000\u0000\u0000\u026f\u026c\u0001\u0000\u0000\u0000\u026f"+
		"\u0270\u0001\u0000\u0000\u0000\u0270\u0271\u0001\u0000\u0000\u0000\u0271"+
		"\u0272\u0003\u0096K\u0000\u0272+\u0001\u0000\u0000\u0000\u0273\u0275\u0005"+
		"\u0093\u0000\u0000\u0274\u0276\u0005t\u0000\u0000\u0275\u0274\u0001\u0000"+
		"\u0000\u0000\u0275\u0276\u0001\u0000\u0000\u0000\u0276\u0277\u0001\u0000"+
		"\u0000\u0000\u0277\u027c\u0003`0\u0000\u0278\u0279\u0005\u0005\u0000\u0000"+
		"\u0279\u027b\u0003`0\u0000\u027a\u0278\u0001\u0000\u0000\u0000\u027b\u027e"+
		"\u0001\u0000\u0000\u0000\u027c\u027a\u0001\u0000\u0000\u0000\u027c\u027d"+
		"\u0001\u0000\u0000\u0000\u027d\u0280\u0001\u0000\u0000\u0000\u027e\u027c"+
		"\u0001\u0000\u0000\u0000\u027f\u0273\u0001\u0000\u0000\u0000\u027f\u0280"+
		"\u0001\u0000\u0000\u0000\u0280\u0281\u0001\u0000\u0000\u0000\u0281\u0287"+
		"\u0003l6\u0000\u0282\u0283\u0003n7\u0000\u0283\u0284\u0003l6\u0000\u0284"+
		"\u0286\u0001\u0000\u0000\u0000\u0285\u0282\u0001\u0000\u0000\u0000\u0286"+
		"\u0289\u0001\u0000\u0000\u0000\u0287\u0285\u0001\u0000\u0000\u0000\u0287"+
		"\u0288\u0001\u0000\u0000\u0000\u0288\u0294\u0001\u0000\u0000\u0000\u0289"+
		"\u0287\u0001\u0000\u0000\u0000\u028a\u028b\u0005m\u0000\u0000\u028b\u028c"+
		"\u0005(\u0000\u0000\u028c\u0291\u0003\\.\u0000\u028d\u028e\u0005\u0005"+
		"\u0000\u0000\u028e\u0290\u0003\\.\u0000\u028f\u028d\u0001\u0000\u0000"+
		"\u0000\u0290\u0293\u0001\u0000\u0000\u0000\u0291\u028f\u0001\u0000\u0000"+
		"\u0000\u0291\u0292\u0001\u0000\u0000\u0000\u0292\u0295\u0001\u0000\u0000"+
		"\u0000\u0293\u0291\u0001\u0000\u0000\u0000\u0294\u028a\u0001\u0000\u0000"+
		"\u0000\u0294\u0295\u0001\u0000\u0000\u0000\u0295\u029c\u0001\u0000\u0000"+
		"\u0000\u0296\u0297\u0005b\u0000\u0000\u0297\u029a\u0003N\'\u0000\u0298"+
		"\u0299\u0007\u0002\u0000\u0000\u0299\u029b\u0003N\'\u0000\u029a\u0298"+
		"\u0001\u0000\u0000\u0000\u029a\u029b\u0001\u0000\u0000\u0000\u029b\u029d"+
		"\u0001\u0000\u0000\u0000\u029c\u0296\u0001\u0000\u0000\u0000\u029c\u029d"+
		"\u0001\u0000\u0000\u0000\u029d-\u0001\u0000\u0000\u0000\u029e\u02a0\u0003"+
		"X,\u0000\u029f\u029e\u0001\u0000\u0000\u0000\u029f\u02a0\u0001\u0000\u0000"+
		"\u0000\u02a0\u02b2\u0001\u0000\u0000\u0000\u02a1\u02b3\u0005X\u0000\u0000"+
		"\u02a2\u02b3\u0005z\u0000\u0000\u02a3\u02a4\u0005X\u0000\u0000\u02a4\u02a5"+
		"\u0005l\u0000\u0000\u02a5\u02b3\u0005z\u0000\u0000\u02a6\u02a7\u0005X"+
		"\u0000\u0000\u02a7\u02a8\u0005l\u0000\u0000\u02a8\u02b3\u0005}\u0000\u0000"+
		"\u02a9\u02aa\u0005X\u0000\u0000\u02aa\u02ab\u0005l\u0000\u0000\u02ab\u02b3"+
		"\u0005\u0019\u0000\u0000\u02ac\u02ad\u0005X\u0000\u0000\u02ad\u02ae\u0005"+
		"l\u0000\u0000\u02ae\u02b3\u0005H\u0000\u0000\u02af\u02b0\u0005X\u0000"+
		"\u0000\u02b0\u02b1\u0005l\u0000\u0000\u02b1\u02b3\u0005Q\u0000\u0000\u02b2"+
		"\u02a1\u0001\u0000\u0000\u0000\u02b2\u02a2\u0001\u0000\u0000\u0000\u02b2"+
		"\u02a3\u0001\u0000\u0000\u0000\u02b2\u02a6\u0001\u0000\u0000\u0000\u02b2"+
		"\u02a9\u0001\u0000\u0000\u0000\u02b2\u02ac\u0001\u0000\u0000\u0000\u02b2"+
		"\u02af\u0001\u0000\u0000\u0000\u02b3\u02b4\u0001\u0000\u0000\u0000\u02b4"+
		"\u02b8\u0005[\u0000\u0000\u02b5\u02b6\u0003\u0084B\u0000\u02b6\u02b7\u0005"+
		"\u0002\u0000\u0000\u02b7\u02b9\u0001\u0000\u0000\u0000\u02b8\u02b5\u0001"+
		"\u0000\u0000\u0000\u02b8\u02b9\u0001\u0000\u0000\u0000\u02b9\u02ba\u0001"+
		"\u0000\u0000\u0000\u02ba\u02c6\u0003\u0086C\u0000\u02bb\u02bc\u0005\u0003"+
		"\u0000\u0000\u02bc\u02c1\u0003\u008cF\u0000\u02bd\u02be\u0005\u0005\u0000"+
		"\u0000\u02be\u02c0\u0003\u008cF\u0000\u02bf\u02bd\u0001\u0000\u0000\u0000"+
		"\u02c0\u02c3\u0001\u0000\u0000\u0000\u02c1\u02bf\u0001\u0000\u0000\u0000"+
		"\u02c1\u02c2\u0001\u0000\u0000\u0000\u02c2\u02c4\u0001\u0000\u0000\u0000"+
		"\u02c3\u02c1\u0001\u0000\u0000\u0000\u02c4\u02c5\u0005\u0004\u0000\u0000"+
		"\u02c5\u02c7\u0001\u0000\u0000\u0000\u02c6\u02bb\u0001\u0000\u0000\u0000"+
		"\u02c6\u02c7\u0001\u0000\u0000\u0000\u02c7\u02e7\u0001\u0000\u0000\u0000"+
		"\u02c8\u02c9\u0005\u008e\u0000\u0000\u02c9\u02ca\u0005\u0003\u0000\u0000"+
		"\u02ca\u02cf\u0003N\'\u0000\u02cb\u02cc\u0005\u0005\u0000\u0000\u02cc"+
		"\u02ce\u0003N\'\u0000\u02cd\u02cb\u0001\u0000\u0000\u0000\u02ce\u02d1"+
		"\u0001\u0000\u0000\u0000\u02cf\u02cd\u0001\u0000\u0000\u0000\u02cf\u02d0"+
		"\u0001\u0000\u0000\u0000\u02d0\u02d2\u0001\u0000\u0000\u0000\u02d1\u02cf"+
		"\u0001\u0000\u0000\u0000\u02d2\u02e1\u0005\u0004\u0000\u0000\u02d3\u02d4"+
		"\u0005\u0005\u0000\u0000\u02d4\u02d5\u0005\u0003\u0000\u0000\u02d5\u02da"+
		"\u0003N\'\u0000\u02d6\u02d7\u0005\u0005\u0000\u0000\u02d7\u02d9\u0003"+
		"N\'\u0000\u02d8\u02d6\u0001\u0000\u0000\u0000\u02d9\u02dc\u0001\u0000"+
		"\u0000\u0000\u02da\u02d8\u0001\u0000\u0000\u0000\u02da\u02db\u0001\u0000"+
		"\u0000\u0000\u02db\u02dd\u0001\u0000\u0000\u0000\u02dc\u02da\u0001\u0000"+
		"\u0000\u0000\u02dd\u02de\u0005\u0004\u0000\u0000\u02de\u02e0\u0001\u0000"+
		"\u0000\u0000\u02df\u02d3\u0001\u0000\u0000\u0000\u02e0\u02e3\u0001\u0000"+
		"\u0000\u0000\u02e1\u02df\u0001\u0000\u0000\u0000\u02e1\u02e2\u0001\u0000"+
		"\u0000\u0000\u02e2\u02e8\u0001\u0000\u0000\u0000\u02e3\u02e1\u0001\u0000"+
		"\u0000\u0000\u02e4\u02e8\u0003<\u001e\u0000\u02e5\u02e6\u00058\u0000\u0000"+
		"\u02e6\u02e8\u0005\u008e\u0000\u0000\u02e7\u02c8\u0001\u0000\u0000\u0000"+
		"\u02e7\u02e4\u0001\u0000\u0000\u0000\u02e7\u02e5\u0001\u0000\u0000\u0000"+
		"\u02e8/\u0001\u0000\u0000\u0000\u02e9\u02ed\u0005p\u0000\u0000\u02ea\u02eb"+
		"\u0003\u0084B\u0000\u02eb\u02ec\u0005\u0002\u0000\u0000\u02ec\u02ee\u0001"+
		"\u0000\u0000\u0000\u02ed\u02ea\u0001\u0000\u0000\u0000\u02ed\u02ee\u0001"+
		"\u0000\u0000\u0000\u02ee\u02ef\u0001\u0000\u0000\u0000\u02ef\u02f6\u0003"+
		"\u009aM\u0000\u02f0\u02f1\u0005\u0006\u0000\u0000\u02f1\u02f7\u0003^/"+
		"\u0000\u02f2\u02f3\u0005\u0003\u0000\u0000\u02f3\u02f4\u0003^/\u0000\u02f4"+
		"\u02f5\u0005\u0004\u0000\u0000\u02f5\u02f7\u0001\u0000\u0000\u0000\u02f6"+
		"\u02f0\u0001\u0000\u0000\u0000\u02f6\u02f2\u0001\u0000\u0000\u0000\u02f6"+
		"\u02f7\u0001\u0000\u0000\u0000\u02f71\u0001\u0000\u0000\u0000\u02f8\u0303"+
		"\u0005w\u0000\u0000\u02f9\u0304\u0003\u008eG\u0000\u02fa\u02fb\u0003\u0084"+
		"B\u0000\u02fb\u02fc\u0005\u0002\u0000\u0000\u02fc\u02fe\u0001\u0000\u0000"+
		"\u0000\u02fd\u02fa\u0001\u0000\u0000\u0000\u02fd\u02fe\u0001\u0000\u0000"+
		"\u0000\u02fe\u0301\u0001\u0000\u0000\u0000\u02ff\u0302\u0003\u0086C\u0000"+
		"\u0300\u0302\u0003\u0092I\u0000\u0301\u02ff\u0001\u0000\u0000\u0000\u0301"+
		"\u0300\u0001\u0000\u0000\u0000\u0302\u0304\u0001\u0000\u0000\u0000\u0303"+
		"\u02f9\u0001\u0000\u0000\u0000\u0303\u02fd\u0001\u0000\u0000\u0000\u0303"+
		"\u0304\u0001\u0000\u0000\u0000\u03043\u0001\u0000\u0000\u0000\u0305\u0307"+
		"\u0005x\u0000\u0000\u0306\u0308\u0005\u007f\u0000\u0000\u0307\u0306\u0001"+
		"\u0000\u0000\u0000\u0307\u0308\u0001\u0000\u0000\u0000\u0308\u0309\u0001"+
		"\u0000\u0000\u0000\u0309\u030a\u0003\u009cN\u0000\u030a5\u0001\u0000\u0000"+
		"\u0000\u030b\u0310\u0005}\u0000\u0000\u030c\u030e\u0005\u0087\u0000\u0000"+
		"\u030d\u030f\u0003\u00a0P\u0000\u030e\u030d\u0001\u0000\u0000\u0000\u030e"+
		"\u030f\u0001\u0000\u0000\u0000\u030f\u0311\u0001\u0000\u0000\u0000\u0310"+
		"\u030c\u0001\u0000\u0000\u0000\u0310\u0311\u0001\u0000\u0000\u0000\u0311"+
		"\u0317\u0001\u0000\u0000\u0000\u0312\u0314\u0005\u0086\u0000\u0000\u0313"+
		"\u0315\u0005\u007f\u0000\u0000\u0314\u0313\u0001\u0000\u0000\u0000\u0314"+
		"\u0315\u0001\u0000\u0000\u0000\u0315\u0316\u0001\u0000\u0000\u0000\u0316"+
		"\u0318\u0003\u009cN\u0000\u0317\u0312\u0001\u0000\u0000\u0000\u0317\u0318"+
		"\u0001\u0000\u0000\u0000\u03187\u0001\u0000\u0000\u0000\u0319\u031a\u0005"+
		"\u007f\u0000\u0000\u031a\u031b\u0003\u009cN\u0000\u031b9\u0001\u0000\u0000"+
		"\u0000\u031c\u031e\u0005\u0093\u0000\u0000\u031d\u031f\u0005t\u0000\u0000"+
		"\u031e\u031d\u0001\u0000\u0000\u0000\u031e\u031f\u0001\u0000\u0000\u0000"+
		"\u031f\u0320\u0001\u0000\u0000\u0000\u0320\u0325\u0003`0\u0000\u0321\u0322"+
		"\u0005\u0005\u0000\u0000\u0322\u0324\u0003`0\u0000\u0323\u0321\u0001\u0000"+
		"\u0000\u0000\u0324\u0327\u0001\u0000\u0000\u0000\u0325\u0323\u0001\u0000"+
		"\u0000\u0000\u0325\u0326\u0001\u0000\u0000\u0000\u0326\u0329\u0001\u0000"+
		"\u0000\u0000\u0327\u0325\u0001\u0000\u0000\u0000\u0328\u031c\u0001\u0000"+
		"\u0000\u0000\u0328\u0329\u0001\u0000\u0000\u0000\u0329\u032a\u0001\u0000"+
		"\u0000\u0000\u032a\u0335\u0003l6\u0000\u032b\u032c\u0005m\u0000\u0000"+
		"\u032c\u032d\u0005(\u0000\u0000\u032d\u0332\u0003\\.\u0000\u032e\u032f"+
		"\u0005\u0005\u0000\u0000\u032f\u0331\u0003\\.\u0000\u0330\u032e\u0001"+
		"\u0000\u0000\u0000\u0331\u0334\u0001\u0000\u0000\u0000\u0332\u0330\u0001"+
		"\u0000\u0000\u0000\u0332\u0333\u0001\u0000\u0000\u0000\u0333\u0336\u0001"+
		"\u0000\u0000\u0000\u0334\u0332\u0001\u0000\u0000\u0000\u0335\u032b\u0001"+
		"\u0000\u0000\u0000\u0335\u0336\u0001\u0000\u0000\u0000\u0336\u033d\u0001"+
		"\u0000\u0000\u0000\u0337\u0338\u0005b\u0000\u0000\u0338\u033b\u0003N\'"+
		"\u0000\u0339\u033a\u0007\u0002\u0000\u0000\u033a\u033c\u0003N\'\u0000"+
		"\u033b\u0339\u0001\u0000\u0000\u0000\u033b\u033c\u0001\u0000\u0000\u0000"+
		"\u033c\u033e\u0001\u0000\u0000\u0000\u033d\u0337\u0001\u0000\u0000\u0000"+
		"\u033d\u033e\u0001\u0000\u0000\u0000\u033e;\u0001\u0000\u0000\u0000\u033f"+
		"\u0341\u0005\u0093\u0000\u0000\u0340\u0342\u0005t\u0000\u0000\u0341\u0340"+
		"\u0001\u0000\u0000\u0000\u0341\u0342\u0001\u0000\u0000\u0000\u0342\u0343"+
		"\u0001\u0000\u0000\u0000\u0343\u0348\u0003`0\u0000\u0344\u0345\u0005\u0005"+
		"\u0000\u0000\u0345\u0347\u0003`0\u0000\u0346\u0344\u0001\u0000\u0000\u0000"+
		"\u0347\u034a\u0001\u0000\u0000\u0000\u0348\u0346\u0001\u0000\u0000\u0000"+
		"\u0348\u0349\u0001\u0000\u0000\u0000\u0349\u034c\u0001\u0000\u0000\u0000"+
		"\u034a\u0348\u0001\u0000\u0000\u0000\u034b\u033f\u0001\u0000\u0000\u0000"+
		"\u034b\u034c\u0001\u0000\u0000\u0000\u034c\u034d\u0001\u0000\u0000\u0000"+
		"\u034d\u0353\u0003>\u001f\u0000\u034e\u034f\u0003n7\u0000\u034f\u0350"+
		"\u0003>\u001f\u0000\u0350\u0352\u0001\u0000\u0000\u0000\u0351\u034e\u0001"+
		"\u0000\u0000\u0000\u0352\u0355\u0001\u0000\u0000\u0000\u0353\u0351\u0001"+
		"\u0000\u0000\u0000\u0353\u0354\u0001\u0000\u0000\u0000\u0354\u0360\u0001"+
		"\u0000\u0000\u0000\u0355\u0353\u0001\u0000\u0000\u0000\u0356\u0357\u0005"+
		"m\u0000\u0000\u0357\u0358\u0005(\u0000\u0000\u0358\u035d\u0003\\.\u0000"+
		"\u0359\u035a\u0005\u0005\u0000\u0000\u035a\u035c\u0003\\.\u0000\u035b"+
		"\u0359\u0001\u0000\u0000\u0000\u035c\u035f\u0001\u0000\u0000\u0000\u035d"+
		"\u035b\u0001\u0000\u0000\u0000\u035d\u035e\u0001\u0000\u0000\u0000\u035e"+
		"\u0361\u0001\u0000\u0000\u0000\u035f\u035d\u0001\u0000\u0000\u0000\u0360"+
		"\u0356\u0001\u0000\u0000\u0000\u0360\u0361\u0001\u0000\u0000\u0000\u0361"+
		"\u0368\u0001\u0000\u0000\u0000\u0362\u0363\u0005b\u0000\u0000\u0363\u0366"+
		"\u0003N\'\u0000\u0364\u0365\u0007\u0002\u0000\u0000\u0365\u0367\u0003"+
		"N\'\u0000\u0366\u0364\u0001\u0000\u0000\u0000\u0366\u0367\u0001\u0000"+
		"\u0000\u0000\u0367\u0369\u0001\u0000\u0000\u0000\u0368\u0362\u0001\u0000"+
		"\u0000\u0000\u0368\u0369\u0001\u0000\u0000\u0000\u0369=\u0001\u0000\u0000"+
		"\u0000\u036a\u036c\u0005\u0080\u0000\u0000\u036b\u036d\u0007\u0004\u0000"+
		"\u0000\u036c\u036b\u0001\u0000\u0000\u0000\u036c\u036d\u0001\u0000\u0000"+
		"\u0000\u036d\u036e\u0001\u0000\u0000\u0000\u036e\u0373\u0003b1\u0000\u036f"+
		"\u0370\u0005\u0005\u0000\u0000\u0370\u0372\u0003b1\u0000\u0371\u036f\u0001"+
		"\u0000\u0000\u0000\u0372\u0375\u0001\u0000\u0000\u0000\u0373\u0371\u0001"+
		"\u0000\u0000\u0000\u0373\u0374\u0001\u0000\u0000\u0000\u0374\u0382\u0001"+
		"\u0000\u0000\u0000\u0375\u0373\u0001\u0000\u0000\u0000\u0376\u0380\u0005"+
		"K\u0000\u0000\u0377\u037c\u0003d2\u0000\u0378\u0379\u0005\u0005\u0000"+
		"\u0000\u0379\u037b\u0003d2\u0000\u037a\u0378\u0001\u0000\u0000\u0000\u037b"+
		"\u037e\u0001\u0000\u0000\u0000\u037c\u037a\u0001\u0000\u0000\u0000\u037c"+
		"\u037d\u0001\u0000\u0000\u0000\u037d\u0381\u0001\u0000\u0000\u0000\u037e"+
		"\u037c\u0001\u0000\u0000\u0000\u037f\u0381\u0003f3\u0000\u0380\u0377\u0001"+
		"\u0000\u0000\u0000\u0380\u037f\u0001\u0000\u0000\u0000\u0381\u0383\u0001"+
		"\u0000\u0000\u0000\u0382\u0376\u0001\u0000\u0000\u0000\u0382\u0383\u0001"+
		"\u0000\u0000\u0000\u0383\u0386\u0001\u0000\u0000\u0000\u0384\u0385\u0005"+
		"\u0092\u0000\u0000\u0385\u0387\u0003N\'\u0000\u0386\u0384\u0001\u0000"+
		"\u0000\u0000\u0386\u0387\u0001\u0000\u0000\u0000\u0387\u0396\u0001\u0000"+
		"\u0000\u0000\u0388\u0389\u0005N\u0000\u0000\u0389\u038a\u0005(\u0000\u0000"+
		"\u038a\u038f\u0003N\'\u0000\u038b\u038c\u0005\u0005\u0000\u0000\u038c"+
		"\u038e\u0003N\'\u0000\u038d\u038b\u0001\u0000\u0000\u0000\u038e\u0391"+
		"\u0001\u0000\u0000\u0000\u038f\u038d\u0001\u0000\u0000\u0000\u038f\u0390"+
		"\u0001\u0000\u0000\u0000\u0390\u0394\u0001\u0000\u0000\u0000\u0391\u038f"+
		"\u0001\u0000\u0000\u0000\u0392\u0393\u0005O\u0000\u0000\u0393\u0395\u0003"+
		"N\'\u0000\u0394\u0392\u0001\u0000\u0000\u0000\u0394\u0395\u0001\u0000"+
		"\u0000\u0000\u0395\u0397\u0001\u0000\u0000\u0000\u0396\u0388\u0001\u0000"+
		"\u0000\u0000\u0396\u0397\u0001\u0000\u0000\u0000\u0397\u03b5\u0001\u0000"+
		"\u0000\u0000\u0398\u0399\u0005\u008e\u0000\u0000\u0399\u039a\u0005\u0003"+
		"\u0000\u0000\u039a\u039f\u0003N\'\u0000\u039b\u039c\u0005\u0005\u0000"+
		"\u0000\u039c\u039e\u0003N\'\u0000\u039d\u039b\u0001\u0000\u0000\u0000"+
		"\u039e\u03a1\u0001\u0000\u0000\u0000\u039f\u039d\u0001\u0000\u0000\u0000"+
		"\u039f\u03a0\u0001\u0000\u0000\u0000\u03a0\u03a2\u0001\u0000\u0000\u0000"+
		"\u03a1\u039f\u0001\u0000\u0000\u0000\u03a2\u03b1\u0005\u0004\u0000\u0000"+
		"\u03a3\u03a4\u0005\u0005\u0000\u0000\u03a4\u03a5\u0005\u0003\u0000\u0000"+
		"\u03a5\u03aa\u0003N\'\u0000\u03a6\u03a7\u0005\u0005\u0000\u0000\u03a7"+
		"\u03a9\u0003N\'\u0000\u03a8\u03a6\u0001\u0000\u0000\u0000\u03a9\u03ac"+
		"\u0001\u0000\u0000\u0000\u03aa\u03a8\u0001\u0000\u0000\u0000\u03aa\u03ab"+
		"\u0001\u0000\u0000\u0000\u03ab\u03ad\u0001\u0000\u0000\u0000\u03ac\u03aa"+
		"\u0001\u0000\u0000\u0000\u03ad\u03ae\u0005\u0004\u0000\u0000\u03ae\u03b0"+
		"\u0001\u0000\u0000\u0000\u03af\u03a3\u0001\u0000\u0000\u0000\u03b0\u03b3"+
		"\u0001\u0000\u0000\u0000\u03b1\u03af\u0001\u0000\u0000\u0000\u03b1\u03b2"+
		"\u0001\u0000\u0000\u0000\u03b2\u03b5\u0001\u0000\u0000\u0000\u03b3\u03b1"+
		"\u0001\u0000\u0000\u0000\u03b4\u036a\u0001\u0000\u0000\u0000\u03b4\u0398"+
		"\u0001\u0000\u0000\u0000\u03b5?\u0001\u0000\u0000\u0000\u03b6\u03b8\u0003"+
		"X,\u0000\u03b7\u03b6\u0001\u0000\u0000\u0000\u03b7\u03b8\u0001\u0000\u0000"+
		"\u0000\u03b8\u03b9\u0001\u0000\u0000\u0000\u03b9\u03c4\u0005\u008b\u0000"+
		"\u0000\u03ba\u03bb\u0005l\u0000\u0000\u03bb\u03c5\u0005}\u0000\u0000\u03bc"+
		"\u03bd\u0005l\u0000\u0000\u03bd\u03c5\u0005\u0019\u0000\u0000\u03be\u03bf"+
		"\u0005l\u0000\u0000\u03bf\u03c5\u0005z\u0000\u0000\u03c0\u03c1\u0005l"+
		"\u0000\u0000\u03c1\u03c5\u0005H\u0000\u0000\u03c2\u03c3\u0005l\u0000\u0000"+
		"\u03c3\u03c5\u0005Q\u0000\u0000\u03c4\u03ba\u0001\u0000\u0000\u0000\u03c4"+
		"\u03bc\u0001\u0000\u0000\u0000\u03c4\u03be\u0001\u0000\u0000\u0000\u03c4"+
		"\u03c0\u0001\u0000\u0000\u0000\u03c4\u03c2\u0001\u0000\u0000\u0000\u03c4"+
		"\u03c5\u0001\u0000\u0000\u0000\u03c5\u03c6\u0001\u0000\u0000\u0000\u03c6"+
		"\u03c7\u0003Z-\u0000\u03c7\u03c8\u0005\u0081\u0000\u0000\u03c8\u03c9\u0003"+
		"\u008cF\u0000\u03c9\u03ca\u0005\u0006\u0000\u0000\u03ca\u03d2\u0003N\'"+
		"\u0000\u03cb\u03cc\u0005\u0005\u0000\u0000\u03cc\u03cd\u0003\u008cF\u0000"+
		"\u03cd\u03ce\u0005\u0006\u0000\u0000\u03ce\u03cf\u0003N\'\u0000\u03cf"+
		"\u03d1\u0001\u0000\u0000\u0000\u03d0\u03cb\u0001\u0000\u0000\u0000\u03d1"+
		"\u03d4\u0001\u0000\u0000\u0000\u03d2\u03d0\u0001\u0000\u0000\u0000\u03d2"+
		"\u03d3\u0001\u0000\u0000\u0000\u03d3\u03d7\u0001\u0000\u0000\u0000\u03d4"+
		"\u03d2\u0001\u0000\u0000\u0000\u03d5\u03d6\u0005\u0092\u0000\u0000\u03d6"+
		"\u03d8\u0003N\'\u0000\u03d7\u03d5\u0001\u0000\u0000\u0000\u03d7\u03d8"+
		"\u0001\u0000\u0000\u0000\u03d8A\u0001\u0000\u0000\u0000\u03d9\u03db\u0003"+
		"X,\u0000\u03da\u03d9\u0001\u0000\u0000\u0000\u03da\u03db\u0001\u0000\u0000"+
		"\u0000\u03db\u03dc\u0001\u0000\u0000\u0000\u03dc\u03e7\u0005\u008b\u0000"+
		"\u0000\u03dd\u03de\u0005l\u0000\u0000\u03de\u03e8\u0005}\u0000\u0000\u03df"+
		"\u03e0\u0005l\u0000\u0000\u03e0\u03e8\u0005\u0019\u0000\u0000\u03e1\u03e2"+
		"\u0005l\u0000\u0000\u03e2\u03e8\u0005z\u0000\u0000\u03e3\u03e4\u0005l"+
		"\u0000\u0000\u03e4\u03e8\u0005H\u0000\u0000\u03e5\u03e6\u0005l\u0000\u0000"+
		"\u03e6\u03e8\u0005Q\u0000\u0000\u03e7\u03dd\u0001\u0000\u0000\u0000\u03e7"+
		"\u03df\u0001\u0000\u0000\u0000\u03e7\u03e1\u0001\u0000\u0000\u0000\u03e7"+
		"\u03e3\u0001\u0000\u0000\u0000\u03e7\u03e5\u0001\u0000\u0000\u0000\u03e7"+
		"\u03e8\u0001\u0000\u0000\u0000\u03e8\u03e9\u0001\u0000\u0000\u0000\u03e9"+
		"\u03ea\u0003Z-\u0000\u03ea\u03eb\u0005\u0081\u0000\u0000\u03eb\u03ec\u0003"+
		"\u008cF\u0000\u03ec\u03ed\u0005\u0006\u0000\u0000\u03ed\u03f5\u0003N\'"+
		"\u0000\u03ee\u03ef\u0005\u0005\u0000\u0000\u03ef\u03f0\u0003\u008cF\u0000"+
		"\u03f0\u03f1\u0005\u0006\u0000\u0000\u03f1\u03f2\u0003N\'\u0000\u03f2"+
		"\u03f4\u0001\u0000\u0000\u0000\u03f3\u03ee\u0001\u0000\u0000\u0000\u03f4"+
		"\u03f7\u0001\u0000\u0000\u0000\u03f5\u03f3\u0001\u0000\u0000\u0000\u03f5"+
		"\u03f6\u0001\u0000\u0000\u0000\u03f6\u03fa\u0001\u0000\u0000\u0000\u03f7"+
		"\u03f5\u0001\u0000\u0000\u0000\u03f8\u03f9\u0005\u0092\u0000\u0000\u03f9"+
		"\u03fb\u0003N\'\u0000\u03fa\u03f8\u0001\u0000\u0000\u0000\u03fa\u03fb"+
		"\u0001\u0000\u0000\u0000\u03fb\u040e\u0001\u0000\u0000\u0000\u03fc\u03fd"+
		"\u0005m\u0000\u0000\u03fd\u03fe\u0005(\u0000\u0000\u03fe\u0403\u0003\\"+
		".\u0000\u03ff\u0400\u0005\u0005\u0000\u0000\u0400\u0402\u0003\\.\u0000"+
		"\u0401\u03ff\u0001\u0000\u0000\u0000\u0402\u0405\u0001\u0000\u0000\u0000"+
		"\u0403\u0401\u0001\u0000\u0000\u0000\u0403\u0404\u0001\u0000\u0000\u0000"+
		"\u0404\u0407\u0001\u0000\u0000\u0000\u0405\u0403\u0001\u0000\u0000\u0000"+
		"\u0406\u03fc\u0001\u0000\u0000\u0000\u0406\u0407\u0001\u0000\u0000\u0000"+
		"\u0407\u0408\u0001\u0000\u0000\u0000\u0408\u0409\u0005b\u0000\u0000\u0409"+
		"\u040c\u0003N\'\u0000\u040a\u040b\u0007\u0002\u0000\u0000\u040b\u040d"+
		"\u0003N\'\u0000\u040c\u040a\u0001\u0000\u0000\u0000\u040c\u040d\u0001"+
		"\u0000\u0000\u0000\u040d\u040f\u0001\u0000\u0000\u0000\u040e\u0406\u0001"+
		"\u0000\u0000\u0000\u040e\u040f\u0001\u0000\u0000\u0000\u040fC\u0001\u0000"+
		"\u0000\u0000\u0410\u0411\u0005\u008d\u0000\u0000\u0411E\u0001\u0000\u0000"+
		"\u0000\u0412\u0414\u0003\u008cF\u0000\u0413\u0415\u0003H$\u0000\u0414"+
		"\u0413\u0001\u0000\u0000\u0000\u0414\u0415\u0001\u0000\u0000\u0000\u0415"+
		"\u0419\u0001\u0000\u0000\u0000\u0416\u0418\u0003J%\u0000\u0417\u0416\u0001"+
		"\u0000\u0000\u0000\u0418\u041b\u0001\u0000\u0000\u0000\u0419\u0417\u0001"+
		"\u0000\u0000\u0000\u0419\u041a\u0001\u0000\u0000\u0000\u041aG\u0001\u0000"+
		"\u0000\u0000\u041b\u0419\u0001\u0000\u0000\u0000\u041c\u041e\u0003\u0080"+
		"@\u0000\u041d\u041c\u0001\u0000\u0000\u0000\u041e\u041f\u0001\u0000\u0000"+
		"\u0000\u041f\u041d\u0001\u0000\u0000\u0000\u041f\u0420\u0001\u0000\u0000"+
		"\u0000\u0420\u042b\u0001\u0000\u0000\u0000\u0421\u0422\u0005\u0003\u0000"+
		"\u0000\u0422\u0423\u0003r9\u0000\u0423\u0424\u0005\u0004\u0000\u0000\u0424"+
		"\u042c\u0001\u0000\u0000\u0000\u0425\u0426\u0005\u0003\u0000\u0000\u0426"+
		"\u0427\u0003r9\u0000\u0427\u0428\u0005\u0005\u0000\u0000\u0428\u0429\u0003"+
		"r9\u0000\u0429\u042a\u0005\u0004\u0000\u0000\u042a\u042c\u0001\u0000\u0000"+
		"\u0000\u042b\u0421\u0001\u0000\u0000\u0000\u042b\u0425\u0001\u0000\u0000"+
		"\u0000\u042b\u042c\u0001\u0000\u0000\u0000\u042cI\u0001\u0000\u0000\u0000"+
		"\u042d\u042e\u00051\u0000\u0000\u042e\u0430\u0003\u0080@\u0000\u042f\u042d"+
		"\u0001\u0000\u0000\u0000\u042f\u0430\u0001\u0000\u0000\u0000\u0430\u0452"+
		"\u0001\u0000\u0000\u0000\u0431\u0432\u0005q\u0000\u0000\u0432\u0434\u0005"+
		"_\u0000\u0000\u0433\u0435\u0007\u0005\u0000\u0000\u0434\u0433\u0001\u0000"+
		"\u0000\u0000\u0434\u0435\u0001\u0000\u0000\u0000\u0435\u0436\u0001\u0000"+
		"\u0000\u0000\u0436\u0438\u0003L&\u0000\u0437\u0439\u0005$\u0000\u0000"+
		"\u0438\u0437\u0001\u0000\u0000\u0000\u0438\u0439\u0001\u0000\u0000\u0000"+
		"\u0439\u0453\u0001\u0000\u0000\u0000\u043a\u043c\u0005f\u0000\u0000\u043b"+
		"\u043a\u0001\u0000\u0000\u0000\u043b\u043c\u0001\u0000\u0000\u0000\u043c"+
		"\u043d\u0001\u0000\u0000\u0000\u043d\u043e\u0005h\u0000\u0000\u043e\u0453"+
		"\u0003L&\u0000\u043f\u0440\u0005\u008a\u0000\u0000\u0440\u0453\u0003L"+
		"&\u0000\u0441\u0442\u0005,\u0000\u0000\u0442\u0443\u0005\u0003\u0000\u0000"+
		"\u0443\u0444\u0003N\'\u0000\u0444\u0445\u0005\u0004\u0000\u0000\u0445"+
		"\u0453\u0001\u0000\u0000\u0000\u0446\u044d\u00058\u0000\u0000\u0447\u044e"+
		"\u0003r9\u0000\u0448\u044e\u0003t:\u0000\u0449\u044a\u0005\u0003\u0000"+
		"\u0000\u044a\u044b\u0003N\'\u0000\u044b\u044c\u0005\u0004\u0000\u0000"+
		"\u044c\u044e\u0001\u0000\u0000\u0000\u044d\u0447\u0001\u0000\u0000\u0000"+
		"\u044d\u0448\u0001\u0000\u0000\u0000\u044d\u0449\u0001\u0000\u0000\u0000"+
		"\u044e\u0453\u0001\u0000\u0000\u0000\u044f\u0450\u0005-\u0000\u0000\u0450"+
		"\u0453\u0003\u008eG\u0000\u0451\u0453\u0003P(\u0000\u0452\u0431\u0001"+
		"\u0000\u0000\u0000\u0452\u043b\u0001\u0000\u0000\u0000\u0452\u043f\u0001"+
		"\u0000\u0000\u0000\u0452\u0441\u0001\u0000\u0000\u0000\u0452\u0446\u0001"+
		"\u0000\u0000\u0000\u0452\u044f\u0001\u0000\u0000\u0000\u0452\u0451\u0001"+
		"\u0000\u0000\u0000\u0453K\u0001\u0000\u0000\u0000\u0454\u0455\u0005k\u0000"+
		"\u0000\u0455\u0456\u00050\u0000\u0000\u0456\u0458\u0007\u0006\u0000\u0000"+
		"\u0457\u0454\u0001\u0000\u0000\u0000\u0457\u0458\u0001\u0000\u0000\u0000"+
		"\u0458M\u0001\u0000\u0000\u0000\u0459\u045a\u0006\'\uffff\uffff\u0000"+
		"\u045a\u04a6\u0003t:\u0000\u045b\u04a6\u0005\u0097\u0000\u0000\u045c\u045d"+
		"\u0003\u0084B\u0000\u045d\u045e\u0005\u0002\u0000\u0000\u045e\u0460\u0001"+
		"\u0000\u0000\u0000\u045f\u045c\u0001\u0000\u0000\u0000\u045f\u0460\u0001"+
		"\u0000\u0000\u0000\u0460\u0461\u0001\u0000\u0000\u0000\u0461\u0462\u0003"+
		"\u0086C\u0000\u0462\u0463\u0005\u0002\u0000\u0000\u0463\u0465\u0001\u0000"+
		"\u0000\u0000\u0464\u045f\u0001\u0000\u0000\u0000\u0464\u0465\u0001\u0000"+
		"\u0000\u0000\u0465\u0466\u0001\u0000\u0000\u0000\u0466\u04a6\u0003\u008c"+
		"F\u0000\u0467\u0468\u0003v;\u0000\u0468\u0469\u0003N\'\u0015\u0469\u04a6"+
		"\u0001\u0000\u0000\u0000\u046a\u046b\u0003\u0082A\u0000\u046b\u0478\u0005"+
		"\u0003\u0000\u0000\u046c\u046e\u0005>\u0000\u0000\u046d\u046c\u0001\u0000"+
		"\u0000\u0000\u046d\u046e\u0001\u0000\u0000\u0000\u046e\u046f\u0001\u0000"+
		"\u0000\u0000\u046f\u0474\u0003N\'\u0000\u0470\u0471\u0005\u0005\u0000"+
		"\u0000\u0471\u0473\u0003N\'\u0000\u0472\u0470\u0001\u0000\u0000\u0000"+
		"\u0473\u0476\u0001\u0000\u0000\u0000\u0474\u0472\u0001\u0000\u0000\u0000"+
		"\u0474\u0475\u0001\u0000\u0000\u0000\u0475\u0479\u0001\u0000\u0000\u0000"+
		"\u0476\u0474\u0001\u0000\u0000\u0000\u0477\u0479\u0005\u0007\u0000\u0000"+
		"\u0478\u046d\u0001\u0000\u0000\u0000\u0478\u0477\u0001\u0000\u0000\u0000"+
		"\u0478\u0479\u0001\u0000\u0000\u0000\u0479\u047a\u0001\u0000\u0000\u0000"+
		"\u047a\u047b\u0005\u0004\u0000\u0000\u047b\u04a6\u0001\u0000\u0000\u0000"+
		"\u047c\u047d\u0005\u0003\u0000\u0000\u047d\u047e\u0003N\'\u0000\u047e"+
		"\u047f\u0005\u0004\u0000\u0000\u047f\u04a6\u0001\u0000\u0000\u0000\u0480"+
		"\u0481\u0005+\u0000\u0000\u0481\u0482\u0005\u0003\u0000\u0000\u0482\u0483"+
		"\u0003N\'\u0000\u0483\u0484\u0005!\u0000\u0000\u0484\u0485\u0003H$\u0000"+
		"\u0485\u0486\u0005\u0004\u0000\u0000\u0486\u04a6\u0001\u0000\u0000\u0000"+
		"\u0487\u0489\u0005f\u0000\u0000\u0488\u0487\u0001\u0000\u0000\u0000\u0488"+
		"\u0489\u0001\u0000\u0000\u0000\u0489\u048a\u0001\u0000\u0000\u0000\u048a"+
		"\u048c\u0005F\u0000\u0000\u048b\u0488\u0001\u0000\u0000\u0000\u048b\u048c"+
		"\u0001\u0000\u0000\u0000\u048c\u048d\u0001\u0000\u0000\u0000\u048d\u048e"+
		"\u0005\u0003\u0000\u0000\u048e\u048f\u0003<\u001e\u0000\u048f\u0490\u0005"+
		"\u0004\u0000\u0000\u0490\u04a6\u0001\u0000\u0000\u0000\u0491\u0493\u0005"+
		"*\u0000\u0000\u0492\u0494\u0003N\'\u0000\u0493\u0492\u0001\u0000\u0000"+
		"\u0000\u0493\u0494\u0001\u0000\u0000\u0000\u0494\u049a\u0001\u0000\u0000"+
		"\u0000\u0495\u0496\u0005\u0091\u0000\u0000\u0496\u0497\u0003N\'\u0000"+
		"\u0497\u0498\u0005\u0085\u0000\u0000\u0498\u0499\u0003N\'\u0000\u0499"+
		"\u049b\u0001\u0000\u0000\u0000\u049a\u0495\u0001\u0000\u0000\u0000\u049b"+
		"\u049c\u0001\u0000\u0000\u0000\u049c\u049a\u0001\u0000\u0000\u0000\u049c"+
		"\u049d\u0001\u0000\u0000\u0000\u049d\u04a0\u0001\u0000\u0000\u0000\u049e"+
		"\u049f\u0005A\u0000\u0000\u049f\u04a1\u0003N\'\u0000\u04a0\u049e\u0001"+
		"\u0000\u0000\u0000\u04a0\u04a1\u0001\u0000\u0000\u0000\u04a1\u04a2\u0001"+
		"\u0000\u0000\u0000\u04a2\u04a3\u0005B\u0000\u0000\u04a3\u04a6\u0001\u0000"+
		"\u0000\u0000\u04a4\u04a6\u0003R)\u0000\u04a5\u0459\u0001\u0000\u0000\u0000"+
		"\u04a5\u045b\u0001\u0000\u0000\u0000\u04a5\u0464\u0001\u0000\u0000\u0000"+
		"\u04a5\u0467\u0001\u0000\u0000\u0000\u04a5\u046a\u0001\u0000\u0000\u0000"+
		"\u04a5\u047c\u0001\u0000\u0000\u0000\u04a5\u0480\u0001\u0000\u0000\u0000"+
		"\u04a5\u048b\u0001\u0000\u0000\u0000\u04a5\u0491\u0001\u0000\u0000\u0000"+
		"\u04a5\u04a4\u0001\u0000\u0000\u0000\u04a6\u050b\u0001\u0000\u0000\u0000"+
		"\u04a7\u04a8\n\u0014\u0000\u0000\u04a8\u04a9\u0005\u000b\u0000\u0000\u04a9"+
		"\u050a\u0003N\'\u0015\u04aa\u04ab\n\u0013\u0000\u0000\u04ab\u04ac\u0007"+
		"\u0007\u0000\u0000\u04ac\u050a\u0003N\'\u0014\u04ad\u04ae\n\u0012\u0000"+
		"\u0000\u04ae\u04af\u0007\b\u0000\u0000\u04af\u050a\u0003N\'\u0013\u04b0"+
		"\u04b1\n\u0011\u0000\u0000\u04b1\u04b2\u0007\t\u0000\u0000\u04b2\u050a"+
		"\u0003N\'\u0012\u04b3\u04b4\n\u0010\u0000\u0000\u04b4\u04b5\u0007\n\u0000"+
		"\u0000\u04b5\u050a\u0003N\'\u0011\u04b6\u04c3\n\u000f\u0000\u0000\u04b7"+
		"\u04c4\u0005\u0006\u0000\u0000\u04b8\u04c4\u0005\u0016\u0000\u0000\u04b9"+
		"\u04c4\u0005\u0017\u0000\u0000\u04ba\u04c4\u0005\u0018\u0000\u0000\u04bb"+
		"\u04c4\u0005\\\u0000\u0000\u04bc\u04bd\u0005\\\u0000\u0000\u04bd\u04c4"+
		"\u0005f\u0000\u0000\u04be\u04c4\u0005S\u0000\u0000\u04bf\u04c4\u0005a"+
		"\u0000\u0000\u04c0\u04c4\u0005M\u0000\u0000\u04c1\u04c4\u0005c\u0000\u0000"+
		"\u04c2\u04c4\u0005v\u0000\u0000\u04c3\u04b7\u0001\u0000\u0000\u0000\u04c3"+
		"\u04b8\u0001\u0000\u0000\u0000\u04c3\u04b9\u0001\u0000\u0000\u0000\u04c3"+
		"\u04ba\u0001\u0000\u0000\u0000\u04c3\u04bb\u0001\u0000\u0000\u0000\u04c3"+
		"\u04bc\u0001\u0000\u0000\u0000\u04c3\u04be\u0001\u0000\u0000\u0000\u04c3"+
		"\u04bf\u0001\u0000\u0000\u0000\u04c3\u04c0\u0001\u0000\u0000\u0000\u04c3"+
		"\u04c1\u0001\u0000\u0000\u0000\u04c3\u04c2\u0001\u0000\u0000\u0000\u04c4"+
		"\u04c5\u0001\u0000\u0000\u0000\u04c5\u050a\u0003N\'\u0010\u04c6\u04c7"+
		"\n\u000e\u0000\u0000\u04c7\u04c8\u0005 \u0000\u0000\u04c8\u050a\u0003"+
		"N\'\u000f\u04c9\u04ca\n\r\u0000\u0000\u04ca\u04cb\u0005l\u0000\u0000\u04cb"+
		"\u050a\u0003N\'\u000e\u04cc\u04cd\n\u0006\u0000\u0000\u04cd\u04cf\u0005"+
		"\\\u0000\u0000\u04ce\u04d0\u0005f\u0000\u0000\u04cf\u04ce\u0001\u0000"+
		"\u0000\u0000\u04cf\u04d0\u0001\u0000\u0000\u0000\u04d0\u04d1\u0001\u0000"+
		"\u0000\u0000\u04d1\u050a\u0003N\'\u0007\u04d2\u04d4\n\u0005\u0000\u0000"+
		"\u04d3\u04d5\u0005f\u0000\u0000\u04d4\u04d3\u0001\u0000\u0000\u0000\u04d4"+
		"\u04d5\u0001\u0000\u0000\u0000\u04d5\u04d6\u0001\u0000\u0000\u0000\u04d6"+
		"\u04d7\u0005\'\u0000\u0000\u04d7\u04d8\u0003N\'\u0000\u04d8\u04d9\u0005"+
		" \u0000\u0000\u04d9\u04da\u0003N\'\u0006\u04da\u050a\u0001\u0000\u0000"+
		"\u0000\u04db\u04dc\n\t\u0000\u0000\u04dc\u04dd\u0005-\u0000\u0000\u04dd"+
		"\u050a\u0003\u008eG\u0000\u04de\u04e0\n\b\u0000\u0000\u04df\u04e1\u0005"+
		"f\u0000\u0000\u04e0\u04df\u0001\u0000\u0000\u0000\u04e0\u04e1\u0001\u0000"+
		"\u0000\u0000\u04e1\u04e2\u0001\u0000\u0000\u0000\u04e2\u04e3\u0007\u000b"+
		"\u0000\u0000\u04e3\u04e6\u0003N\'\u0000\u04e4\u04e5\u0005C\u0000\u0000"+
		"\u04e5\u04e7\u0003N\'\u0000\u04e6\u04e4\u0001\u0000\u0000\u0000\u04e6"+
		"\u04e7\u0001\u0000\u0000\u0000\u04e7\u050a\u0001\u0000\u0000\u0000\u04e8"+
		"\u04ed\n\u0007\u0000\u0000\u04e9\u04ee\u0005]\u0000\u0000\u04ea\u04ee"+
		"\u0005g\u0000\u0000\u04eb\u04ec\u0005f\u0000\u0000\u04ec\u04ee\u0005h"+
		"\u0000\u0000\u04ed\u04e9\u0001\u0000\u0000\u0000\u04ed\u04ea\u0001\u0000"+
		"\u0000\u0000\u04ed\u04eb\u0001\u0000\u0000\u0000\u04ee\u050a\u0001\u0000"+
		"\u0000\u0000\u04ef\u04f1\n\u0004\u0000\u0000\u04f0\u04f2\u0005f\u0000"+
		"\u0000\u04f1\u04f0\u0001\u0000\u0000\u0000\u04f1\u04f2\u0001\u0000\u0000"+
		"\u0000\u04f2\u04f3\u0001\u0000\u0000\u0000\u04f3\u0507\u0005S\u0000\u0000"+
		"\u04f4\u04fe\u0005\u0003\u0000\u0000\u04f5\u04ff\u0003<\u001e\u0000\u04f6"+
		"\u04fb\u0003N\'\u0000\u04f7\u04f8\u0005\u0005\u0000\u0000\u04f8\u04fa"+
		"\u0003N\'\u0000\u04f9\u04f7\u0001\u0000\u0000\u0000\u04fa\u04fd\u0001"+
		"\u0000\u0000\u0000\u04fb\u04f9\u0001\u0000\u0000\u0000\u04fb\u04fc\u0001"+
		"\u0000\u0000\u0000\u04fc\u04ff\u0001\u0000\u0000\u0000\u04fd\u04fb\u0001"+
		"\u0000\u0000\u0000\u04fe\u04f5\u0001\u0000\u0000\u0000\u04fe\u04f6\u0001"+
		"\u0000\u0000\u0000\u04fe\u04ff\u0001\u0000\u0000\u0000\u04ff\u0500\u0001"+
		"\u0000\u0000\u0000\u0500\u0508\u0005\u0004\u0000\u0000\u0501\u0502\u0003"+
		"\u0084B\u0000\u0502\u0503\u0005\u0002\u0000\u0000\u0503\u0505\u0001\u0000"+
		"\u0000\u0000\u0504\u0501\u0001\u0000\u0000\u0000\u0504\u0505\u0001\u0000"+
		"\u0000\u0000\u0505\u0506\u0001\u0000\u0000\u0000\u0506\u0508\u0003\u0086"+
		"C\u0000\u0507\u04f4\u0001\u0000\u0000\u0000\u0507\u0504\u0001\u0000\u0000"+
		"\u0000\u0508\u050a\u0001\u0000\u0000\u0000\u0509\u04a7\u0001\u0000\u0000"+
		"\u0000\u0509\u04aa\u0001\u0000\u0000\u0000\u0509\u04ad\u0001\u0000\u0000"+
		"\u0000\u0509\u04b0\u0001\u0000\u0000\u0000\u0509\u04b3\u0001\u0000\u0000"+
		"\u0000\u0509\u04b6\u0001\u0000\u0000\u0000\u0509\u04c6\u0001\u0000\u0000"+
		"\u0000\u0509\u04c9\u0001\u0000\u0000\u0000\u0509\u04cc\u0001\u0000\u0000"+
		"\u0000\u0509\u04d2\u0001\u0000\u0000\u0000\u0509\u04db\u0001\u0000\u0000"+
		"\u0000\u0509\u04de\u0001\u0000\u0000\u0000\u0509\u04e8\u0001\u0000\u0000"+
		"\u0000\u0509\u04ef\u0001\u0000\u0000\u0000\u050a\u050d\u0001\u0000\u0000"+
		"\u0000\u050b\u0509\u0001\u0000\u0000\u0000\u050b\u050c\u0001\u0000\u0000"+
		"\u0000\u050cO\u0001\u0000\u0000\u0000\u050d\u050b\u0001\u0000\u0000\u0000"+
		"\u050e\u050f\u0005u\u0000\u0000\u050f\u051b\u0003\u0090H\u0000\u0510\u0511"+
		"\u0005\u0003\u0000\u0000\u0511\u0516\u0003\u008cF\u0000\u0512\u0513\u0005"+
		"\u0005\u0000\u0000\u0513\u0515\u0003\u008cF\u0000\u0514\u0512\u0001\u0000"+
		"\u0000\u0000\u0515\u0518\u0001\u0000\u0000\u0000\u0516\u0514\u0001\u0000"+
		"\u0000\u0000\u0516\u0517\u0001\u0000\u0000\u0000\u0517\u0519\u0001\u0000"+
		"\u0000\u0000\u0518\u0516\u0001\u0000\u0000\u0000\u0519\u051a\u0005\u0004"+
		"\u0000\u0000\u051a\u051c\u0001\u0000\u0000\u0000\u051b\u0510\u0001\u0000"+
		"\u0000\u0000\u051b\u051c\u0001\u0000\u0000\u0000\u051c\u052f\u0001\u0000"+
		"\u0000\u0000\u051d\u051e\u0005k\u0000\u0000\u051e\u0527\u0007\f\u0000"+
		"\u0000\u051f\u0520\u0005\u0081\u0000\u0000\u0520\u0528\u0005h\u0000\u0000"+
		"\u0521\u0522\u0005\u0081\u0000\u0000\u0522\u0528\u00058\u0000\u0000\u0523"+
		"\u0528\u0005)\u0000\u0000\u0524\u0528\u0005{\u0000\u0000\u0525\u0526\u0005"+
		"e\u0000\u0000\u0526\u0528\u0005\u001a\u0000\u0000\u0527\u051f\u0001\u0000"+
		"\u0000\u0000\u0527\u0521\u0001\u0000\u0000\u0000\u0527\u0523\u0001\u0000"+
		"\u0000\u0000\u0527\u0524\u0001\u0000\u0000\u0000\u0527\u0525\u0001\u0000"+
		"\u0000\u0000\u0528\u052c\u0001\u0000\u0000\u0000\u0529\u052a\u0005c\u0000"+
		"\u0000\u052a\u052c\u0003\u0080@\u0000\u052b\u051d\u0001\u0000\u0000\u0000"+
		"\u052b\u0529\u0001\u0000\u0000\u0000\u052c\u052e\u0001\u0000\u0000\u0000"+
		"\u052d\u052b\u0001\u0000\u0000\u0000\u052e\u0531\u0001\u0000\u0000\u0000"+
		"\u052f\u052d\u0001\u0000\u0000\u0000\u052f\u0530\u0001\u0000\u0000\u0000"+
		"\u0530\u053c\u0001\u0000\u0000\u0000\u0531\u052f\u0001\u0000\u0000\u0000"+
		"\u0532\u0534\u0005f\u0000\u0000\u0533\u0532\u0001\u0000\u0000\u0000\u0533"+
		"\u0534\u0001\u0000\u0000\u0000\u0534\u0535\u0001\u0000\u0000\u0000\u0535"+
		"\u053a\u00059\u0000\u0000\u0536\u0537\u0005V\u0000\u0000\u0537\u053b\u0005"+
		":\u0000\u0000\u0538\u0539\u0005V\u0000\u0000\u0539\u053b\u0005R\u0000"+
		"\u0000\u053a\u0536\u0001\u0000\u0000\u0000\u053a\u0538\u0001\u0000\u0000"+
		"\u0000\u053a\u053b\u0001\u0000\u0000\u0000\u053b\u053d\u0001\u0000\u0000"+
		"\u0000\u053c\u0533\u0001\u0000\u0000\u0000\u053c\u053d\u0001\u0000\u0000"+
		"\u0000\u053dQ\u0001\u0000\u0000\u0000\u053e\u053f\u0005s\u0000\u0000\u053f"+
		"\u0544\u0005\u0003\u0000\u0000\u0540\u0545\u0005Q\u0000\u0000\u0541\u0542"+
		"\u0007\r\u0000\u0000\u0542\u0543\u0005\u0005\u0000\u0000\u0543\u0545\u0003"+
		"x<\u0000\u0544\u0540\u0001\u0000\u0000\u0000\u0544\u0541\u0001\u0000\u0000"+
		"\u0000\u0545\u0546\u0001\u0000\u0000\u0000\u0546\u0547\u0005\u0004\u0000"+
		"\u0000\u0547S\u0001\u0000\u0000\u0000\u0548\u054b\u0003\u008cF\u0000\u0549"+
		"\u054a\u0005-\u0000\u0000\u054a\u054c\u0003\u008eG\u0000\u054b\u0549\u0001"+
		"\u0000\u0000\u0000\u054b\u054c\u0001\u0000\u0000\u0000\u054c\u054e\u0001"+
		"\u0000\u0000\u0000\u054d\u054f\u0007\u0005\u0000\u0000\u054e\u054d\u0001"+
		"\u0000\u0000\u0000\u054e\u054f\u0001\u0000\u0000\u0000\u054fU\u0001\u0000"+
		"\u0000\u0000\u0550\u0551\u00051\u0000\u0000\u0551\u0553\u0003\u0080@\u0000"+
		"\u0552\u0550\u0001\u0000\u0000\u0000\u0552\u0553\u0001\u0000\u0000\u0000"+
		"\u0553\u0578\u0001\u0000\u0000\u0000\u0554\u0555\u0005q\u0000\u0000\u0555"+
		"\u0558\u0005_\u0000\u0000\u0556\u0558\u0005\u008a\u0000\u0000\u0557\u0554"+
		"\u0001\u0000\u0000\u0000\u0557\u0556\u0001\u0000\u0000\u0000\u0558\u0559"+
		"\u0001\u0000\u0000\u0000\u0559\u055a\u0005\u0003\u0000\u0000\u055a\u055f"+
		"\u0003T*\u0000\u055b\u055c\u0005\u0005\u0000\u0000\u055c\u055e\u0003T"+
		"*\u0000\u055d\u055b\u0001\u0000\u0000\u0000\u055e\u0561\u0001\u0000\u0000"+
		"\u0000\u055f\u055d\u0001\u0000\u0000\u0000\u055f\u0560\u0001\u0000\u0000"+
		"\u0000\u0560\u0562\u0001\u0000\u0000\u0000\u0561\u055f\u0001\u0000\u0000"+
		"\u0000\u0562\u0563\u0005\u0004\u0000\u0000\u0563\u0564\u0003L&\u0000\u0564"+
		"\u0579\u0001\u0000\u0000\u0000\u0565\u0566\u0005,\u0000\u0000\u0566\u0567"+
		"\u0005\u0003\u0000\u0000\u0567\u0568\u0003N\'\u0000\u0568\u0569\u0005"+
		"\u0004\u0000\u0000\u0569\u0579\u0001\u0000\u0000\u0000\u056a\u056b\u0005"+
		"J\u0000\u0000\u056b\u056c\u0005_\u0000\u0000\u056c\u056d\u0005\u0003\u0000"+
		"\u0000\u056d\u0572\u0003\u008cF\u0000\u056e\u056f\u0005\u0005\u0000\u0000"+
		"\u056f\u0571\u0003\u008cF\u0000\u0570\u056e\u0001\u0000\u0000\u0000\u0571"+
		"\u0574\u0001\u0000\u0000\u0000\u0572\u0570\u0001\u0000\u0000\u0000\u0572"+
		"\u0573\u0001\u0000\u0000\u0000\u0573\u0575\u0001\u0000\u0000\u0000\u0574"+
		"\u0572\u0001\u0000\u0000\u0000\u0575\u0576\u0005\u0004\u0000\u0000\u0576"+
		"\u0577\u0003P(\u0000\u0577\u0579\u0001\u0000\u0000\u0000\u0578\u0557\u0001"+
		"\u0000\u0000\u0000\u0578\u0565\u0001\u0000\u0000\u0000\u0578\u056a\u0001"+
		"\u0000\u0000\u0000\u0579W\u0001\u0000\u0000\u0000\u057a\u057c\u0005\u0093"+
		"\u0000\u0000\u057b\u057d\u0005t\u0000\u0000\u057c\u057b\u0001\u0000\u0000"+
		"\u0000\u057c\u057d\u0001\u0000\u0000\u0000\u057d\u057e\u0001\u0000\u0000"+
		"\u0000\u057e\u057f\u0003p8\u0000\u057f\u0580\u0005!\u0000\u0000\u0580"+
		"\u0581\u0005\u0003\u0000\u0000\u0581\u0582\u0003<\u001e\u0000\u0582\u058c"+
		"\u0005\u0004\u0000\u0000\u0583\u0584\u0005\u0005\u0000\u0000\u0584\u0585"+
		"\u0003p8\u0000\u0585\u0586\u0005!\u0000\u0000\u0586\u0587\u0005\u0003"+
		"\u0000\u0000\u0587\u0588\u0003<\u001e\u0000\u0588\u0589\u0005\u0004\u0000"+
		"\u0000\u0589\u058b\u0001\u0000\u0000\u0000\u058a\u0583\u0001\u0000\u0000"+
		"\u0000\u058b\u058e\u0001\u0000\u0000\u0000\u058c\u058a\u0001\u0000\u0000"+
		"\u0000\u058c\u058d\u0001\u0000\u0000\u0000\u058dY\u0001\u0000\u0000\u0000"+
		"\u058e\u058c\u0001\u0000\u0000\u0000\u058f\u0590\u0003\u0084B\u0000\u0590"+
		"\u0591\u0005\u0002\u0000\u0000\u0591\u0593\u0001\u0000\u0000\u0000\u0592"+
		"\u058f\u0001\u0000\u0000\u0000\u0592\u0593\u0001\u0000\u0000\u0000\u0593"+
		"\u0594\u0001\u0000\u0000\u0000\u0594\u059a\u0003\u0086C\u0000\u0595\u0596"+
		"\u0005U\u0000\u0000\u0596\u0597\u0005(\u0000\u0000\u0597\u059b\u0003\u0092"+
		"I\u0000\u0598\u0599\u0005f\u0000\u0000\u0599\u059b\u0005U\u0000\u0000"+
		"\u059a\u0595\u0001\u0000\u0000\u0000\u059a\u0598\u0001\u0000\u0000\u0000"+
		"\u059a\u059b\u0001\u0000\u0000\u0000\u059b[\u0001\u0000\u0000\u0000\u059c"+
		"\u059f\u0003N\'\u0000\u059d\u059e\u0005-\u0000\u0000\u059e\u05a0\u0003"+
		"\u008eG\u0000\u059f\u059d\u0001\u0000\u0000\u0000\u059f\u05a0\u0001\u0000"+
		"\u0000\u0000\u05a0\u05a2\u0001\u0000\u0000\u0000\u05a1\u05a3\u0007\u0005"+
		"\u0000\u0000\u05a2\u05a1\u0001\u0000\u0000\u0000\u05a2\u05a3\u0001\u0000"+
		"\u0000\u0000\u05a3]\u0001\u0000\u0000\u0000\u05a4\u05a8\u0003r9\u0000"+
		"\u05a5\u05a8\u0003\u0080@\u0000\u05a6\u05a8\u0005\u0098\u0000\u0000\u05a7"+
		"\u05a4\u0001\u0000\u0000\u0000\u05a7\u05a5\u0001\u0000\u0000\u0000\u05a7"+
		"\u05a6\u0001\u0000\u0000\u0000\u05a8_\u0001\u0000\u0000\u0000\u05a9\u05b5"+
		"\u0003\u0086C\u0000\u05aa\u05ab\u0005\u0003\u0000\u0000\u05ab\u05b0\u0003"+
		"\u008cF\u0000\u05ac\u05ad\u0005\u0005\u0000\u0000\u05ad\u05af\u0003\u008c"+
		"F\u0000\u05ae\u05ac\u0001\u0000\u0000\u0000\u05af\u05b2\u0001\u0000\u0000"+
		"\u0000\u05b0\u05ae\u0001\u0000\u0000\u0000\u05b0\u05b1\u0001\u0000\u0000"+
		"\u0000\u05b1\u05b3\u0001\u0000\u0000\u0000\u05b2\u05b0\u0001\u0000\u0000"+
		"\u0000\u05b3\u05b4\u0005\u0004\u0000\u0000\u05b4\u05b6\u0001\u0000\u0000"+
		"\u0000\u05b5\u05aa\u0001\u0000\u0000\u0000\u05b5\u05b6\u0001\u0000\u0000"+
		"\u0000\u05b6\u05b7\u0001\u0000\u0000\u0000\u05b7\u05b8\u0005!\u0000\u0000"+
		"\u05b8\u05b9\u0005\u0003\u0000\u0000\u05b9\u05ba\u0003<\u001e\u0000\u05ba"+
		"\u05bb\u0005\u0004\u0000\u0000\u05bba\u0001\u0000\u0000\u0000\u05bc\u05c9"+
		"\u0005\u0007\u0000\u0000\u05bd\u05be\u0003\u0086C\u0000\u05be\u05bf\u0005"+
		"\u0002\u0000\u0000\u05bf\u05c0\u0005\u0007\u0000\u0000\u05c0\u05c9\u0001"+
		"\u0000\u0000\u0000\u05c1\u05c6\u0003N\'\u0000\u05c2\u05c4\u0005!\u0000"+
		"\u0000\u05c3\u05c2\u0001\u0000\u0000\u0000\u05c3\u05c4\u0001\u0000\u0000"+
		"\u0000\u05c4\u05c5\u0001\u0000\u0000\u0000\u05c5\u05c7\u0003|>\u0000\u05c6"+
		"\u05c3\u0001\u0000\u0000\u0000\u05c6\u05c7\u0001\u0000\u0000\u0000\u05c7"+
		"\u05c9\u0001\u0000\u0000\u0000\u05c8\u05bc\u0001\u0000\u0000\u0000\u05c8"+
		"\u05bd\u0001\u0000\u0000\u0000\u05c8\u05c1\u0001\u0000\u0000\u0000\u05c9"+
		"c\u0001\u0000\u0000\u0000\u05ca\u05cb\u0003\u0084B\u0000\u05cb\u05cc\u0005"+
		"\u0002\u0000\u0000\u05cc\u05ce\u0001\u0000\u0000\u0000\u05cd\u05ca\u0001"+
		"\u0000\u0000\u0000\u05cd\u05ce\u0001\u0000\u0000\u0000\u05ce\u05cf\u0001"+
		"\u0000\u0000\u0000\u05cf\u05d4\u0003\u0086C\u0000\u05d0\u05d2\u0005!\u0000"+
		"\u0000\u05d1\u05d0\u0001\u0000\u0000\u0000\u05d1\u05d2\u0001\u0000\u0000"+
		"\u0000\u05d2\u05d3\u0001\u0000\u0000\u0000\u05d3\u05d5\u0003\u009eO\u0000"+
		"\u05d4\u05d1\u0001\u0000\u0000\u0000\u05d4\u05d5\u0001\u0000\u0000\u0000"+
		"\u05d5\u05db\u0001\u0000\u0000\u0000\u05d6\u05d7\u0005U\u0000\u0000\u05d7"+
		"\u05d8\u0005(\u0000\u0000\u05d8\u05dc\u0003\u0092I\u0000\u05d9\u05da\u0005"+
		"f\u0000\u0000\u05da\u05dc\u0005U\u0000\u0000\u05db\u05d6\u0001\u0000\u0000"+
		"\u0000\u05db\u05d9\u0001\u0000\u0000\u0000\u05db\u05dc\u0001\u0000\u0000"+
		"\u0000\u05dc\u05fa\u0001\u0000\u0000\u0000\u05dd\u05e7\u0005\u0003\u0000"+
		"\u0000\u05de\u05e3\u0003d2\u0000\u05df\u05e0\u0005\u0005\u0000\u0000\u05e0"+
		"\u05e2\u0003d2\u0000\u05e1\u05df\u0001\u0000\u0000\u0000\u05e2\u05e5\u0001"+
		"\u0000\u0000\u0000\u05e3\u05e1\u0001\u0000\u0000\u0000\u05e3\u05e4\u0001"+
		"\u0000\u0000\u0000\u05e4\u05e8\u0001\u0000\u0000\u0000\u05e5\u05e3\u0001"+
		"\u0000\u0000\u0000\u05e6\u05e8\u0003f3\u0000\u05e7\u05de\u0001\u0000\u0000"+
		"\u0000\u05e7\u05e6\u0001\u0000\u0000\u0000\u05e8\u05e9\u0001\u0000\u0000"+
		"\u0000\u05e9\u05ee\u0005\u0004\u0000\u0000\u05ea\u05ec\u0005!\u0000\u0000"+
		"\u05eb\u05ea\u0001\u0000\u0000\u0000\u05eb\u05ec\u0001\u0000\u0000\u0000"+
		"\u05ec\u05ed\u0001\u0000\u0000\u0000\u05ed\u05ef\u0003\u009eO\u0000\u05ee"+
		"\u05eb\u0001\u0000\u0000\u0000\u05ee\u05ef\u0001\u0000\u0000\u0000\u05ef"+
		"\u05fa\u0001\u0000\u0000\u0000\u05f0\u05f1\u0005\u0003\u0000\u0000\u05f1"+
		"\u05f2\u0003<\u001e\u0000\u05f2\u05f7\u0005\u0004\u0000\u0000\u05f3\u05f5"+
		"\u0005!\u0000\u0000\u05f4\u05f3\u0001\u0000\u0000\u0000\u05f4\u05f5\u0001"+
		"\u0000\u0000\u0000\u05f5\u05f6\u0001\u0000\u0000\u0000\u05f6\u05f8\u0003"+
		"\u009eO\u0000\u05f7\u05f4\u0001\u0000\u0000\u0000\u05f7\u05f8\u0001\u0000"+
		"\u0000\u0000\u05f8\u05fa\u0001\u0000\u0000\u0000\u05f9\u05cd\u0001\u0000"+
		"\u0000\u0000\u05f9\u05dd\u0001\u0000\u0000\u0000\u05f9\u05f0\u0001\u0000"+
		"\u0000\u0000\u05fae\u0001\u0000\u0000\u0000\u05fb\u0602\u0003d2\u0000"+
		"\u05fc\u05fd\u0003h4\u0000\u05fd\u05fe\u0003d2\u0000\u05fe\u05ff\u0003"+
		"j5\u0000\u05ff\u0601\u0001\u0000\u0000\u0000\u0600\u05fc\u0001\u0000\u0000"+
		"\u0000\u0601\u0604\u0001\u0000\u0000\u0000\u0602\u0600\u0001\u0000\u0000"+
		"\u0000\u0602\u0603\u0001\u0000\u0000\u0000\u0603g\u0001\u0000\u0000\u0000"+
		"\u0604\u0602\u0001\u0000\u0000\u0000\u0605\u0613\u0005\u0005\u0000\u0000"+
		"\u0606\u0608\u0005d\u0000\u0000\u0607\u0606\u0001\u0000\u0000\u0000\u0607"+
		"\u0608\u0001\u0000\u0000\u0000\u0608\u060f\u0001\u0000\u0000\u0000\u0609"+
		"\u060b\u0005`\u0000\u0000\u060a\u060c\u0005n\u0000\u0000\u060b\u060a\u0001"+
		"\u0000\u0000\u0000\u060b\u060c\u0001\u0000\u0000\u0000\u060c\u0610\u0001"+
		"\u0000\u0000\u0000\u060d\u0610\u0005W\u0000\u0000\u060e\u0610\u00053\u0000"+
		"\u0000\u060f\u0609\u0001\u0000\u0000\u0000\u060f\u060d\u0001\u0000\u0000"+
		"\u0000\u060f\u060e\u0001\u0000\u0000\u0000\u060f\u0610\u0001\u0000\u0000"+
		"\u0000\u0610\u0611\u0001\u0000\u0000\u0000\u0611\u0613\u0005^\u0000\u0000"+
		"\u0612\u0605\u0001\u0000\u0000\u0000\u0612\u0607\u0001\u0000\u0000\u0000"+
		"\u0613i\u0001\u0000\u0000\u0000\u0614\u0615\u0005k\u0000\u0000\u0615\u0623"+
		"\u0003N\'\u0000\u0616\u0617\u0005\u008c\u0000\u0000\u0617\u0618\u0005"+
		"\u0003\u0000\u0000\u0618\u061d\u0003\u008cF\u0000\u0619\u061a\u0005\u0005"+
		"\u0000\u0000\u061a\u061c\u0003\u008cF\u0000\u061b\u0619\u0001\u0000\u0000"+
		"\u0000\u061c\u061f\u0001\u0000\u0000\u0000\u061d\u061b\u0001\u0000\u0000"+
		"\u0000\u061d\u061e\u0001\u0000\u0000\u0000\u061e\u0620\u0001\u0000\u0000"+
		"\u0000\u061f\u061d\u0001\u0000\u0000\u0000\u0620\u0621\u0005\u0004\u0000"+
		"\u0000\u0621\u0623\u0001\u0000\u0000\u0000\u0622\u0614\u0001\u0000\u0000"+
		"\u0000\u0622\u0616\u0001\u0000\u0000\u0000\u0622\u0623\u0001\u0000\u0000"+
		"\u0000\u0623k\u0001\u0000\u0000\u0000\u0624\u0626\u0005\u0080\u0000\u0000"+
		"\u0625\u0627\u0007\u0004\u0000\u0000\u0626\u0625\u0001\u0000\u0000\u0000"+
		"\u0626\u0627\u0001\u0000\u0000\u0000\u0627\u0628\u0001\u0000\u0000\u0000"+
		"\u0628\u062d\u0003b1\u0000\u0629\u062a\u0005\u0005\u0000\u0000\u062a\u062c"+
		"\u0003b1\u0000\u062b\u0629\u0001\u0000\u0000\u0000\u062c\u062f\u0001\u0000"+
		"\u0000\u0000\u062d\u062b\u0001\u0000\u0000\u0000\u062d\u062e\u0001\u0000"+
		"\u0000\u0000\u062e\u063c\u0001\u0000\u0000\u0000\u062f\u062d\u0001\u0000"+
		"\u0000\u0000\u0630\u063a\u0005K\u0000\u0000\u0631\u0636\u0003d2\u0000"+
		"\u0632\u0633\u0005\u0005\u0000\u0000\u0633\u0635\u0003d2\u0000\u0634\u0632"+
		"\u0001\u0000\u0000\u0000\u0635\u0638\u0001\u0000\u0000\u0000\u0636\u0634"+
		"\u0001\u0000\u0000\u0000\u0636\u0637\u0001\u0000\u0000\u0000\u0637\u063b"+
		"\u0001\u0000\u0000\u0000\u0638\u0636\u0001\u0000\u0000\u0000\u0639\u063b"+
		"\u0003f3\u0000\u063a\u0631\u0001\u0000\u0000\u0000\u063a\u0639\u0001\u0000"+
		"\u0000\u0000\u063b\u063d\u0001\u0000\u0000\u0000\u063c\u0630\u0001\u0000"+
		"\u0000\u0000\u063c\u063d\u0001\u0000\u0000\u0000\u063d\u0640\u0001\u0000"+
		"\u0000\u0000\u063e\u063f\u0005\u0092\u0000\u0000\u063f\u0641\u0003N\'"+
		"\u0000\u0640\u063e\u0001\u0000\u0000\u0000\u0640\u0641\u0001\u0000\u0000"+
		"\u0000\u0641\u0650\u0001\u0000\u0000\u0000\u0642\u0643\u0005N\u0000\u0000"+
		"\u0643\u0644\u0005(\u0000\u0000\u0644\u0649\u0003N\'\u0000\u0645\u0646"+
		"\u0005\u0005\u0000\u0000\u0646\u0648\u0003N\'\u0000\u0647\u0645\u0001"+
		"\u0000\u0000\u0000\u0648\u064b\u0001\u0000\u0000\u0000\u0649\u0647\u0001"+
		"\u0000\u0000\u0000\u0649\u064a\u0001\u0000\u0000\u0000\u064a\u064e\u0001"+
		"\u0000\u0000\u0000\u064b\u0649\u0001\u0000\u0000\u0000\u064c\u064d\u0005"+
		"O\u0000\u0000\u064d\u064f\u0003N\'\u0000\u064e\u064c\u0001\u0000\u0000"+
		"\u0000\u064e\u064f\u0001\u0000\u0000\u0000\u064f\u0651\u0001\u0000\u0000"+
		"\u0000\u0650\u0642\u0001\u0000\u0000\u0000\u0650\u0651\u0001\u0000\u0000"+
		"\u0000\u0651\u066f\u0001\u0000\u0000\u0000\u0652\u0653\u0005\u008e\u0000"+
		"\u0000\u0653\u0654\u0005\u0003\u0000\u0000\u0654\u0659\u0003N\'\u0000"+
		"\u0655\u0656\u0005\u0005\u0000\u0000\u0656\u0658\u0003N\'\u0000\u0657"+
		"\u0655\u0001\u0000\u0000\u0000\u0658\u065b\u0001\u0000\u0000\u0000\u0659"+
		"\u0657\u0001\u0000\u0000\u0000\u0659\u065a\u0001\u0000\u0000\u0000\u065a"+
		"\u065c\u0001\u0000\u0000\u0000\u065b\u0659\u0001\u0000\u0000\u0000\u065c"+
		"\u066b\u0005\u0004\u0000\u0000\u065d\u065e\u0005\u0005\u0000\u0000\u065e"+
		"\u065f\u0005\u0003\u0000\u0000\u065f\u0664\u0003N\'\u0000\u0660\u0661"+
		"\u0005\u0005\u0000\u0000\u0661\u0663\u0003N\'\u0000\u0662\u0660\u0001"+
		"\u0000\u0000\u0000\u0663\u0666\u0001\u0000\u0000\u0000\u0664\u0662\u0001"+
		"\u0000\u0000\u0000\u0664\u0665\u0001\u0000\u0000\u0000\u0665\u0667\u0001"+
		"\u0000\u0000\u0000\u0666\u0664\u0001\u0000\u0000\u0000\u0667\u0668\u0005"+
		"\u0004\u0000\u0000\u0668\u066a\u0001\u0000\u0000\u0000\u0669\u065d\u0001"+
		"\u0000\u0000\u0000\u066a\u066d\u0001\u0000\u0000\u0000\u066b\u0669\u0001"+
		"\u0000\u0000\u0000\u066b\u066c\u0001\u0000\u0000\u0000\u066c\u066f\u0001"+
		"\u0000\u0000\u0000\u066d\u066b\u0001\u0000\u0000\u0000\u066e\u0624\u0001"+
		"\u0000\u0000\u0000\u066e\u0652\u0001\u0000\u0000\u0000\u066fm\u0001\u0000"+
		"\u0000\u0000\u0670\u0676\u0005\u0089\u0000\u0000\u0671\u0672\u0005\u0089"+
		"\u0000\u0000\u0672\u0676\u0005\u001d\u0000\u0000\u0673\u0676\u0005Z\u0000"+
		"\u0000\u0674\u0676\u0005D\u0000\u0000\u0675\u0670\u0001\u0000\u0000\u0000"+
		"\u0675\u0671\u0001\u0000\u0000\u0000\u0675\u0673\u0001\u0000\u0000\u0000"+
		"\u0675\u0674\u0001\u0000\u0000\u0000\u0676o\u0001\u0000\u0000\u0000\u0677"+
		"\u0683\u0003\u0086C\u0000\u0678\u0679\u0005\u0003\u0000\u0000\u0679\u067e"+
		"\u0003\u008cF\u0000\u067a\u067b\u0005\u0005\u0000\u0000\u067b\u067d\u0003"+
		"\u008cF\u0000\u067c\u067a\u0001\u0000\u0000\u0000\u067d\u0680\u0001\u0000"+
		"\u0000\u0000\u067e\u067c\u0001\u0000\u0000\u0000\u067e\u067f\u0001\u0000"+
		"\u0000\u0000\u067f\u0681\u0001\u0000\u0000\u0000\u0680\u067e\u0001\u0000"+
		"\u0000\u0000\u0681\u0682\u0005\u0004\u0000\u0000\u0682\u0684\u0001\u0000"+
		"\u0000\u0000\u0683\u0678\u0001\u0000\u0000\u0000\u0683\u0684\u0001\u0000"+
		"\u0000\u0000\u0684q\u0001\u0000\u0000\u0000\u0685\u0687\u0007\b\u0000"+
		"\u0000\u0686\u0685\u0001\u0000\u0000\u0000\u0686\u0687\u0001\u0000\u0000"+
		"\u0000\u0687\u0688\u0001\u0000\u0000\u0000\u0688\u0689\u0005\u0096\u0000"+
		"\u0000\u0689s\u0001\u0000\u0000\u0000\u068a\u068b\u0007\u000e\u0000\u0000"+
		"\u068bu\u0001\u0000\u0000\u0000\u068c\u068d\u0007\u000f\u0000\u0000\u068d"+
		"w\u0001\u0000\u0000\u0000\u068e\u068f\u0005\u0098\u0000\u0000\u068fy\u0001"+
		"\u0000\u0000\u0000\u0690\u0693\u0003N\'\u0000\u0691\u0693\u0003F#\u0000"+
		"\u0692\u0690\u0001\u0000\u0000\u0000\u0692\u0691\u0001\u0000\u0000\u0000"+
		"\u0693{\u0001\u0000\u0000\u0000\u0694\u0695\u0007\u0010\u0000\u0000\u0695"+
		"}\u0001\u0000\u0000\u0000\u0696\u0697\u0007\u0011\u0000\u0000\u0697\u007f"+
		"\u0001\u0000\u0000\u0000\u0698\u0699\u0003\u00a2Q\u0000\u0699\u0081\u0001"+
		"\u0000\u0000\u0000\u069a\u069b\u0003\u00a2Q\u0000\u069b\u0083\u0001\u0000"+
		"\u0000\u0000\u069c\u069d\u0003\u00a2Q\u0000\u069d\u0085\u0001\u0000\u0000"+
		"\u0000\u069e\u069f\u0003\u00a2Q\u0000\u069f\u0087\u0001\u0000\u0000\u0000"+
		"\u06a0\u06a1\u0003\u00a2Q\u0000\u06a1\u0089\u0001\u0000\u0000\u0000\u06a2"+
		"\u06a3\u0003\u00a2Q\u0000\u06a3\u008b\u0001\u0000\u0000\u0000\u06a4\u06a5"+
		"\u0003\u00a2Q\u0000\u06a5\u008d\u0001\u0000\u0000\u0000\u06a6\u06a7\u0003"+
		"\u00a2Q\u0000\u06a7\u008f\u0001\u0000\u0000\u0000\u06a8\u06a9\u0003\u00a2"+
		"Q\u0000\u06a9\u0091\u0001\u0000\u0000\u0000\u06aa\u06ab\u0003\u00a2Q\u0000"+
		"\u06ab\u0093\u0001\u0000\u0000\u0000\u06ac\u06ad\u0003\u00a2Q\u0000\u06ad"+
		"\u0095\u0001\u0000\u0000\u0000\u06ae\u06af\u0003\u00a2Q\u0000\u06af\u0097"+
		"\u0001\u0000\u0000\u0000\u06b0\u06b1\u0003\u00a2Q\u0000\u06b1\u0099\u0001"+
		"\u0000\u0000\u0000\u06b2\u06b3\u0003\u00a2Q\u0000\u06b3\u009b\u0001\u0000"+
		"\u0000\u0000\u06b4\u06b5\u0003\u00a2Q\u0000\u06b5\u009d\u0001\u0000\u0000"+
		"\u0000\u06b6\u06bd\u0005\u0095\u0000\u0000\u06b7\u06bd\u0005\u0098\u0000"+
		"\u0000\u06b8\u06b9\u0005\u0003\u0000\u0000\u06b9\u06ba\u0003\u009eO\u0000"+
		"\u06ba\u06bb\u0005\u0004\u0000\u0000\u06bb\u06bd\u0001\u0000\u0000\u0000"+
		"\u06bc\u06b6\u0001\u0000\u0000\u0000\u06bc\u06b7\u0001\u0000\u0000\u0000"+
		"\u06bc\u06b8\u0001\u0000\u0000\u0000\u06bd\u009f\u0001\u0000\u0000\u0000"+
		"\u06be\u06bf\u0003\u00a2Q\u0000\u06bf\u00a1\u0001\u0000\u0000\u0000\u06c0"+
		"\u06c8\u0005\u0095\u0000\u0000\u06c1\u06c8\u0003~?\u0000\u06c2\u06c8\u0005"+
		"\u0098\u0000\u0000\u06c3\u06c4\u0005\u0003\u0000\u0000\u06c4\u06c5\u0003"+
		"\u00a2Q\u0000\u06c5\u06c6\u0005\u0004\u0000\u0000\u06c6\u06c8\u0001\u0000"+
		"\u0000\u0000\u06c7\u06c0\u0001\u0000\u0000\u0000\u06c7\u06c1\u0001\u0000"+
		"\u0000\u0000\u06c7\u06c2\u0001\u0000\u0000\u0000\u06c7\u06c3\u0001\u0000"+
		"\u0000\u0000\u06c8\u00a3\u0001\u0000\u0000\u0000\u00f5\u00a6\u00a8\u00b3"+
		"\u00ba\u00bf\u00c5\u00cb\u00cd\u00ed\u00f4\u00fc\u00ff\u0108\u010c\u0114"+
		"\u0118\u011a\u011f\u0121\u0125\u012c\u012f\u0134\u0138\u013d\u0146\u0149"+
		"\u014f\u0151\u0155\u015b\u0160\u016b\u0171\u0175\u017b\u0180\u0189\u0190"+
		"\u0196\u019a\u019e\u01a4\u01a9\u01b0\u01bb\u01be\u01c0\u01c6\u01cc\u01d0"+
		"\u01d7\u01dd\u01e3\u01e9\u01ee\u01fa\u01ff\u020a\u020f\u0212\u0219\u021c"+
		"\u0223\u022c\u022f\u0235\u0237\u023b\u0243\u0248\u0250\u0255\u025d\u0262"+
		"\u026a\u026f\u0275\u027c\u027f\u0287\u0291\u0294\u029a\u029c\u029f\u02b2"+
		"\u02b8\u02c1\u02c6\u02cf\u02da\u02e1\u02e7\u02ed\u02f6\u02fd\u0301\u0303"+
		"\u0307\u030e\u0310\u0314\u0317\u031e\u0325\u0328\u0332\u0335\u033b\u033d"+
		"\u0341\u0348\u034b\u0353\u035d\u0360\u0366\u0368\u036c\u0373\u037c\u0380"+
		"\u0382\u0386\u038f\u0394\u0396\u039f\u03aa\u03b1\u03b4\u03b7\u03c4\u03d2"+
		"\u03d7\u03da\u03e7\u03f5\u03fa\u0403\u0406\u040c\u040e\u0414\u0419\u041f"+
		"\u042b\u042f\u0434\u0438\u043b\u044d\u0452\u0457\u045f\u0464\u046d\u0474"+
		"\u0478\u0488\u048b\u0493\u049c\u04a0\u04a5\u04c3\u04cf\u04d4\u04e0\u04e6"+
		"\u04ed\u04f1\u04fb\u04fe\u0504\u0507\u0509\u050b\u0516\u051b\u0527\u052b"+
		"\u052f\u0533\u053a\u053c\u0544\u054b\u054e\u0552\u0557\u055f\u0572\u0578"+
		"\u057c\u058c\u0592\u059a\u059f\u05a2\u05a7\u05b0\u05b5\u05c3\u05c6\u05c8"+
		"\u05cd\u05d1\u05d4\u05db\u05e3\u05e7\u05eb\u05ee\u05f4\u05f7\u05f9\u0602"+
		"\u0607\u060b\u060f\u0612\u061d\u0622\u0626\u062d\u0636\u063a\u063c\u0640"+
		"\u0649\u064e\u0650\u0659\u0664\u066b\u066e\u0675\u067e\u0683\u0686\u0692"+
		"\u06bc\u06c7";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}
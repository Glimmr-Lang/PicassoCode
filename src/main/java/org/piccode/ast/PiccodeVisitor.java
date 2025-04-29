package org.piccode.ast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.antlr.v4.runtime.tree.TerminalNode;
import org.piccode.antlr4.PiccodeScriptBaseVisitor;
import org.piccode.antlr4.PiccodeScriptParser.*;

/**
 *
 * @author hexaredecimal
 */
public class PiccodeVisitor extends PiccodeScriptBaseVisitor<Ast> {

	@Override
	public Ast visitVar_decl(Var_declContext var_decl) {
		var tok = var_decl.ID().getSymbol();
		var name = tok.getText();
		var expr = visitExpr(var_decl.expr());
		var result = new VarDecl(name, expr);
		result.column = tok.getStartIndex();
		result.line = tok.getLine();
		return result;
	}

	@Override
	public Ast visitStmts(StmtsContext ctx) {
		var stmts = new ArrayList<Ast>();
		for (var stmt : ctx.stmt()) {
			stmts.add(visitStmt(stmt));
		}
		return new StatementList(stmts);
	}

	@Override
	public Ast visitFunc(FuncContext ctx) {
		var tok = ctx.ID().getSymbol();
		var name = tok.getText();
		var args = visitFuncArgs(ctx.func_args());
		var body = visitExpr(ctx.expr());

		if (args.isEmpty()) {
			return new FunctionAst(name, null, body);
		}

		int i = args.size();
		while (i > 1) {
			int index = i - 1;
			var arg = args.get(index);
			body = new ClosureAst(arg, body);
			i--;
		}

		return new FunctionAst(name, args.getFirst(), body);
	}

	public List<Arg> visitFuncArgs(Func_argsContext ctx) {
		var args = new ArrayList<Arg>();
		
		if (ctx.arg_list() == null) {
			return args;
		}

		for (var arg : ctx.arg_list().arg()) {
			var _arg = (Arg) visitArg(arg);
			args.add(_arg);
		}
		return args;
	}

	@Override
	public Ast visitArg(ArgContext ctx) {
		var name = ctx.ID().getText();
		if (ctx.ASSIGN() != null) {
			var value = visitLiteral_expr(ctx.literal_expr());
			return new Arg(name, value);
		}

		return new Arg(name);
	}

	@Override
	public Ast visitLiteral_expr(Literal_exprContext ctx) {
		if (ctx.NUMBER() != null) {
			return visitNumber(ctx.NUMBER());
		}

		if (ctx.STRING() != null) {
			return visitString(ctx.STRING());
		}

		if (ctx.array() != null) {
			return visitArray(ctx.array());
		}
		if (ctx.tuple() != null) {
			return visitTuple(ctx.tuple());
		}
		if (ctx.object() != null) {
			return visitObject(ctx.object());
		}

		return null;
	}

	@Override
	public Ast visitStmt(StmtContext ctx) {
		if (ctx.expr_stmt()!= null) {
			return visitExpr(ctx.expr_stmt().expr());
		}

		if (ctx.func() != null) {
			return visitFunc(ctx.func());
		}

		if (ctx.module() != null) {
			return visitModule(ctx.module());
		}

		if (ctx.import_module() != null) {
			return visitImport_module(ctx.import_module());
		}

		return null;
	}

	@Override
	public Ast visitImport_module(Import_moduleContext ctx) {
		var pkg = ctx.ID().getFirst().getText();
		var module = ctx.ID().getLast().getText();

		return new ImportAst(pkg, module);
	}
	
	@Override
	public Ast visitModule(ModuleContext ctx) {
		var name = ctx.ID().getText();
		if (ctx.module_stmts() != null) {
			var nodes = visitModuleStmts(ctx.module_stmts());
			return new ModuleAst(name, nodes);
		}
		return new ModuleAst(name, List.of());
	}

	public List<Ast> visitModuleStmts (Module_stmtsContext ctx) {
		var list = new ArrayList<Ast>();
		for (var stmt: ctx.module_stmt()) {
			list.add(visitModuleStmt(stmt));
		}
		return list;
	}

	private Ast visitModuleStmt(Module_stmtContext stmt) {
		if (stmt.func() != null) {
			return visitFunc(stmt.func());
		}

		if (stmt.var_decl() != null) {
			return visitVar_decl(stmt.var_decl());
		}

		if (stmt.module() != null) {
			return visitModule(stmt.module());
		}
		return null;
	}
	
	@Override
	public Ast visitWhen_expr(When_exprContext ctx) {
		var expr = visitExpr(ctx.expr());
		var cases = visitWhenCases(ctx.when_cases());
		if (ctx.else_case() != null) {
			var elze = visitExpr(ctx.else_case().expr());
			return new WhenAst(expr, cases, elze);
		}
		return new WhenAst(expr, cases, null);
	}

	private List<WhenCase> visitWhenCases(When_casesContext whens) {
		var cases = new ArrayList<WhenCase>();
		for (var _case: whens.when_case()) {
			var match = visitExprlist(_case.expr_list());
			var value = visitExpr(_case.expr());
			cases.add(new WhenCase(match, value));
		}
		return cases;
	}

	@Override
	public Ast visitExpr(ExprContext expr) {
		if (expr.var_decl() != null) {
			return visitVar_decl(expr.var_decl());
		}

		if (expr.when_expr() != null) {
			return visitWhen_expr(expr.when_expr());
		}

		if (expr.NUMBER() != null) {
			return visitNumber(expr.NUMBER());
		}

		if (expr.STRING() != null) {
			return visitString(expr.STRING());
		}

		if (expr.ADD() != null) {
			return visitBinOp("+", expr);
		}

		if (expr.SUB() != null) {
			return visitBinOp("-", expr);
		}

		if (expr.MUL() != null) {
			return visitBinOp("*", expr);
		}

		if (expr.DIV() != null) {
			return visitBinOp("/", expr);
		}

		if (expr.DOT() != null) {
			return visitDotOperation(expr);
		}

		if (expr.array() != null) {
			return visitArray(expr.array());
		}

		if (expr.tuple() != null) {
			return visitTuple(expr.tuple());
		}

		if (expr.object() != null) {
			return visitObject(expr.object());
		}

		if (expr.ID() != null) {
			return visitId(expr.ID());
		}

		if (!expr.expr().isEmpty() && expr.call_expr_list() == null) {
			return visitCall(expr, expr.call_expr_list());
		}

		if (!expr.expr().isEmpty() && expr.call_expr_list() != null) {
			return visitCall(expr.expr().getFirst(), expr.call_expr_list());
		}

		return null;
	}

	public Ast visitCall(ExprContext expr, Call_expr_listContext exprList) {
		var value = visitExpr(expr);
		if (exprList == null) {
			return new CallAst(value, List.of());
		}

		var args = visitCallExprList(exprList);
		return new CallAst(value, args);
	}

	private List<Ast> visitCallExprList(Call_expr_listContext ctx) {
		var nodes = new ArrayList<Ast>();
		for (var call_expr: ctx.call_expr()) {
			nodes.add(visitCallExpr(call_expr));
		}
		return nodes;
	}
	
	public Ast visitCallExpr(Call_exprContext ctx) {
		if (ctx.ASSIGN() != null) {
			var id = ctx.ID().getText();
			var value = visitExpr(ctx.expr());
			return new NamedCallArg(id, value);
		}
		
		return visitExpr(ctx.expr());
	}

	
	@Override
	public Ast visitObject(ObjectContext ctx) {
		var kvs = visitKeyValuePairs(ctx.key_val_pairs());
		return new ObjectAst(kvs);
	}

	private HashMap<String, Ast> visitKeyValuePairs(Key_val_pairsContext key_val_pairs) {
		var obj = new HashMap<String, Ast>();
		for (var kv : key_val_pairs.key_val_pair()) {
			obj.put(kv.ID().getText(), visitExpr(kv.expr()));
		}
		return obj;
	}

	@Override
	public Ast visitTuple(TupleContext ctx) {
		var exprs = visitExprlist(ctx.expr_list());
		if (exprs.size() == 1) {
			return exprs.getFirst();
		}

		return new TupleAst(exprs);
	}

	@Override
	public Ast visitArray(ArrayContext ctx) {
		if (ctx.expr_list() != null) {
			return new ArrayAst(visitExprlist(ctx.expr_list()));
		}
		return new ArrayAst(List.of());
	}

	private List<Ast> visitExprlist(Expr_listContext ctx) {
		return ctx
						.expr()
						.stream()
						.map(this::visitExpr)
						.toList();
	}

	private Ast visitNumber(TerminalNode NUMBER) {
		var number = new NumberAst(NUMBER.getText());
		var line = NUMBER.getSymbol().getLine();
		var col = NUMBER.getSymbol().getStartIndex();
		number.line = line;
		number.column = col;
		return number;
	}

	private Ast visitString(TerminalNode STRING) {
		var string = new StringAst(STRING.getText());
		var line = STRING.getSymbol().getLine();
		var col = STRING.getSymbol().getStartIndex();
		string.line = line;
		string.column = col;
		return string;
	}

	private Ast visitBinOp(String op, ExprContext expr) {
		var lhs = visitExpr(expr.expr().getFirst());
		var rhs = visitExpr(expr.expr().getLast());
		return new BinOpAst(lhs, op, rhs);
	}

	private Ast visitDotOperation(ExprContext expr) {
		var lhs = visitExpr(expr.expr().getFirst());
		var rhs = visitExpr(expr.expr().getLast());
		return new DotOperationAst(lhs, rhs);
	}

	private Ast visitId(TerminalNode ID) {
		String id = ID.getText();
		return new IdentifierAst(id);
	}
}

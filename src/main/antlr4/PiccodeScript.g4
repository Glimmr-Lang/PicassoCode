grammar PiccodeScript;

options {
  language = Java;
}

@header {
	package org.piccode.antlr4;
}

stmts: stmt*
	| EOF;

stmt:
	import_module
	| func
	| module
	| expr_stmt;

import_module:
	IMPORT ID ':' ID;

module: 
	MODULE ID '{' module_stmts '}';

module_stmts:
	module_stmt*;

module_stmt:
	func
	| var_decl
	| module;

func: FUNCTION ID func_args ASSIGN expr ;

func_args: '(' arg_list? ')' ;

arg_list: arg (',' arg)* ;

arg: ID (ASSIGN literal_expr)? ; // only allow literals in default values


literal_expr :
	NUMBER                           
	| STRING                           
	|array
	| tuple
	| object
	;

expr_stmt: expr;
	// parser rules
expr
	: expr MUL expr      
  | expr DIV expr      
	| expr ADD expr      
	| expr SUB expr
	| expr DOT expr
	| expr '(' call_expr_list? ')'
	| array
	| tuple
	| object
	| var_decl
	| when_expr
	| ID
	| NUMBER                           
	| STRING                           
	;

when_expr: 
 WHEN expr '{' when_cases else_case? '}'; 
	
when_cases: when_case*;

when_case: IS expr_list '->' expr;

else_case: ELSE '->' expr;

var_decl: LET ID ASSIGN expr;
tuple: '(' expr_list ')';
array: '[' expr_list? ']'; 
object: '{' key_val_pairs '}';

expr_list: expr (',' expr)*;
call_expr_list: call_expr (',' call_expr)*;

call_expr: ID (ASSIGN expr)? 
	| expr;

key_val_pair: ID ':' expr;
key_val_pairs: key_val_pair (',' key_val_pair)*;


	// lexer rules
ADD: '+';
SUB: '-';
MUL: '*';
DIV: '/';

ASSIGN: '=';

LET: 'let';
FUNCTION: 'function';
WHEN: 'when';
IMPORT: 'import';
IS: 'is';
IF: 'if';
ELSE: 'else';
MODULE: 'module';

// Matches both integers and floats (e.g., 123, 45.67)
NUMBER: [0-9]+ ('.' [0-9]+)?;

// Matches strings like "hello world" or 'hello world'
// Handles basic escaped quotes
STRING: '"' (~["\\] | '\\' .)* '"'
| '\'' (~['\\] | '\\' .)* '\'';

DOT: '.';

LINE_COMMENT: '//' ~[\r\n]* -> skip;
BLOCK_COMMENT: '/*' .*? '*/' -> skip;


ID: [a-zA-Z_][a-zA-Z_0-9]* ;
WS: [ \t\r\n]+ -> skip;

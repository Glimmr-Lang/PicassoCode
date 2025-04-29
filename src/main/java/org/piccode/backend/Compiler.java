package org.piccode.backend;

import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.piccode.antlr4.PiccodeScriptLexer;
import org.piccode.antlr4.PiccodeScriptParser;
import org.piccode.ast.PiccodeVisitor;
import org.piccode.piccode.ErrorListerner;

/**
 *
 * @author hexaredecimal
 */
public class Compiler {
	public static void compile() {
			var code = 
					"""
import pkg:math
import pkg:resource
import pkg:render
import pkg:image

function fact(x=0) = 
	when x {
		is 0,1 -> 1
		else -> x * fact(x - 1)
	} 

let image = Resource.loadPaintResource(src="./images/image.png")

Render.drawImage(
  paint = image.id,
	size = Image.size(40, 50)
)

function addVec(l={x: 0, y:0}, r={x: 0, y: 0}) = l + r

module Render {
	function drawImage(paint = 1, size=[20, 20]) = 0
}
          """;
			var lexer = new PiccodeScriptLexer(CharStreams.fromString(code));
			var parser = new PiccodeScriptParser(new CommonTokenStream(lexer));
			parser.removeErrorListeners();
			parser.addErrorListener(new ErrorListerner());

			var visitor = new PiccodeVisitor();
    
			var result = visitor.visit(parser.stmts());
			System.out.println("" + result);
	}
}

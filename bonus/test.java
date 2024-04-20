import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import java.io.IOException;
// grammer is named SQL

public class test {
	public static void main(String[] args) throws IOException {
		CharStream input = CharStreams.fromFileName("test.txt");
		SQLLexer lexer = new SQLLexer(input); // create a lexer that feeds off of input CharStream
		CommonTokenStream tokens = new CommonTokenStream(lexer); // create a buffer of tokens pulled from the lexer
		SQLParser parser = new SQLParser(tokens); // create a parser that feeds off the tokens buffer
												 
		ParseTree tree = parser.parse(); // begin parsing at init rule
		System.out.println(tree.toStringTree(parser)); // print LISP-style tree
		
	}
}

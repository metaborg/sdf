package SampleGrammars.strategies;

import java.io.BufferedReader;
import java.io.IOException;

import org.spoofax.interpreter.library.IOAgent;
import org.spoofax.interpreter.library.ssl.SSLLibrary;
import org.spoofax.interpreter.terms.IStrategoString;
import org.spoofax.jsglr.client.ParseTable;
import org.spoofax.jsglr.shared.SGLRException;
import org.spoofax.interpreter.terms.IStrategoTerm;
import org.spoofax.interpreter.terms.ITermFactory;
import org.strategoxt.lang.Context;
import org.strategoxt.lang.Strategy;
import org.spoofax.interpreter.core.IContext;
import org.spoofax.interpreter.core.InterpreterException;
import org.spoofax.interpreter.core.Tools;
import org.spoofax.interpreter.terms.IStrategoAppl;
import org.spoofax.jsglr.client.Asfix2TreeBuilder;
import org.spoofax.jsglr.client.Disambiguator;
import org.spoofax.jsglr.client.FilterException;
import org.spoofax.jsglr.client.ITreeBuilder;
import org.spoofax.jsglr.client.InvalidParseTableException;
import org.spoofax.jsglr.client.ParseException;
import org.spoofax.jsglr.client.SGLR;
import org.spoofax.jsglr.shared.BadTokenException;
import org.spoofax.jsglr.shared.TokenExpectedException;

/**
 * Example Java strategy implementation.
 *
 * This strategy can be used by editor services and can be called in Stratego
 * modules by declaring it as an external strategy as follows:
 *
 * <code>
 *  external java-strategy(|)
 * </code>
 *
 * @see InteropRegisterer This class registers java_strategy_0_0 for use.
 */
public class parse_to_pt_0_2 extends Strategy {

	public static parse_to_pt_0_2 instance = new parse_to_pt_0_2();
	
	@Override
	  public IStrategoTerm invoke(Context context, IStrategoTerm current) {
	    context.getIOAgent().printError("Input for java-strategy: " + current);
	    ITermFactory factory = context.getFactory();
	    
	    
	    return factory.makeString("Regards from java-strategy");
	  }

//	@Override
//	public IStrategoTerm invoke(Context context, IStrategoTerm current,
//			IStrategoTerm t1, IStrategoTerm t2) {
//		context.getIOAgent().printError(
//				"Input for parse-pt: " + current + " and parameters " + t1 + "\n" + t2);
//
//		ITermFactory factory = context.getFactory();
//		
//		if (!Tools.isTermInt(current))
//			return factory.makeString("failed");
//		
//		String text;
//		try {
//			text = readFile(context.getIOAgent(), Tools.asJavaInt(current)).trim();
//		} catch (IOException e) {
//			// FIXME add more structure;
//			IStrategoTerm errorTerm = context.getFactory().makeString(e.getMessage());
//			return errorTerm;
//		}
//		
//		try {
//			ParseTable table = new ParseTable(t1, factory);
//			SGLR parser = new SGLR(new Asfix2TreeBuilder(factory), table);
//			String path = Tools.asJavaString(t2);
//			context.getIOAgent().printError("to parse " + text + " in path " + path);
//			return (IStrategoTerm) parser.parse(text);
//
//			
//
//		} catch (InvalidParseTableException | SGLRException | InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//			return factory.makeString("Exception Thrown");
//
//		}
//
//	}
//	
//	private String readFile(IOAgent io, int fd) throws IOException {
//		BufferedReader br = new BufferedReader(io.getReader(fd));
//		StringBuilder sb = new StringBuilder();
//		do {
//			sb.append(br.readLine());
//			sb.append('\n');
//		} while(br.ready());
//		return sb.toString();
//	}

}

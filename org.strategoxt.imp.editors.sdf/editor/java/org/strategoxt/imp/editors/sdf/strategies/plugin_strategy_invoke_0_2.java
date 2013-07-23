package org.strategoxt.imp.editors.sdf.strategies;

import static org.spoofax.interpreter.core.Tools.asJavaString;
import static org.spoofax.interpreter.core.Tools.isTermAppl;
import static org.spoofax.interpreter.core.Tools.termAt;

import org.spoofax.interpreter.core.InterpreterException;
import org.spoofax.interpreter.terms.IStrategoAppl;
import org.spoofax.interpreter.terms.IStrategoTerm;
import org.spoofax.interpreter.terms.ITermFactory;
import org.strategoxt.imp.runtime.Environment;
import org.strategoxt.imp.runtime.dynamicloading.BadDescriptorException;
import org.strategoxt.imp.runtime.services.StrategoObserver;
import org.strategoxt.imp.runtime.stratego.EditorIOAgent;
import org.strategoxt.lang.Context;
import org.strategoxt.lang.MissingStrategyException;
import org.strategoxt.lang.Strategy;


/**
 * Evaluate a strategy in a stratego instance belonging to a language plugin.
 * 
 * @author Lennart Kats <lennart add lclnet.nl>
 */
public class plugin_strategy_invoke_0_2 extends Strategy {

	public static plugin_strategy_invoke_0_2 instance = new plugin_strategy_invoke_0_2();

	/**
	 * @return Fail(trace) for strategy failure, Error(message) a string for errors, 
	 *         or Some(term) for success.
	 */
	@Override
	public IStrategoTerm invoke(Context context, IStrategoTerm current, IStrategoTerm languageName, IStrategoTerm strategy) {
		ITermFactory factory = context.getFactory();
		try {
			String dir = ((EditorIOAgent) context.getIOAgent()).getProjectPath();
			StrategoObserver observer = ObserverCache.getInstance().getObserver(asJavaString(languageName), dir);
			observer.getRuntime().setCurrent(current);
			if (isTermAppl(strategy) && ((IStrategoAppl) strategy).getName().equals("Strategy"))
				strategy = termAt(strategy, 0);
			if (observer.getRuntime().invoke(asJavaString(strategy))) {
				current = observer.getRuntime().current();
				current = factory.makeAppl(factory.makeConstructor("Some", 1), current);
				return current;
			} else {
				Context foreignContext = observer.getRuntime().getCompiledContext();
				String trace = "rewriting failed\n"
						+ (foreignContext != null ? foreignContext.getTraceString() : "");
				observer.getRuntime().getIOAgent().printError(trace);
				return factory.makeAppl(factory.makeConstructor("Fail", 1), factory.makeString(trace));
			}
		} catch (MissingStrategyException e) {
			return factory.makeAppl(factory.makeConstructor("Error", 1),
					factory.makeString("Problem loading descriptor for testing: " + e.getLocalizedMessage()));
		} catch (BadDescriptorException e) {
			Environment.logException("Problem loading descriptor for testing", e);
			return factory.makeAppl(factory.makeConstructor("Error", 1),
					factory.makeString("Problem loading descriptor for testing: " + e.getLocalizedMessage()));
		} catch (InterpreterException e) {
			Environment.logException("Problem executing strategy for testing: " + strategy, e);
			return factory.makeAppl(factory.makeConstructor("Error", 1),
					factory.makeString(e.getLocalizedMessage()));
		} catch (RuntimeException e) {
			Environment.logException("Problem executing strategy for testing: " + strategy, e);
			return factory.makeAppl(factory.makeConstructor("Error", 1),
					factory.makeString(e.getClass().getName() + ": " + e.getLocalizedMessage() + " (see error log)"));
		}
	}

}

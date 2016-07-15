package org.metaborg.sdf2table.grammar;

import org.spoofax.interpreter.terms.IStrategoTerm;

/**
 * An object that can be exported to an Aterm.
 */
public interface Exportable {
	
	/**
	 * @return An Aterm.
	 */
	public IStrategoTerm toATerm();
}

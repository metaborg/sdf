package org.strategoxt.imp.editors.template.generated;

import org.strategoxt.stratego_lib.*;
import org.strategoxt.stratego_lib.*;
import org.strategoxt.stratego_sglr.*;
import org.strategoxt.stratego_gpp.*;
import org.strategoxt.stratego_xtc.*;
import org.strategoxt.stratego_aterm.*;
import org.strategoxt.stratego_sdf.*;
import org.strategoxt.strc.*;
import org.strategoxt.imp.editors.template.generated.*;
import org.strategoxt.java_front.*;
import org.strategoxt.lang.*;
import org.spoofax.interpreter.terms.*;
import static org.strategoxt.lang.Term.*;
import org.spoofax.interpreter.library.AbstractPrimitive;
import java.util.ArrayList;
import java.lang.ref.WeakReference;

@SuppressWarnings("all") public class $Placeholder_1_0 extends Strategy 
{ 
  public static $Placeholder_1_0 instance = new $Placeholder_1_0();

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term, Strategy y_32789)
  { 
    ITermFactory termFactory = context.getFactory();
    context.push("Placeholder_1_0");
    Fail1248:
    { 
      IStrategoTerm m_32964 = null;
      IStrategoTerm l_32964 = null;
      if(term.getTermType() != IStrategoTerm.APPL || Main._consPlaceholder_1 != ((IStrategoAppl)term).getConstructor())
        break Fail1248;
      l_32964 = term.getSubterm(0);
      IStrategoList annos37 = term.getAnnotations();
      m_32964 = annos37;
      term = y_32789.invoke(context, l_32964);
      if(term == null)
        break Fail1248;
      term = termFactory.annotateTerm(termFactory.makeAppl(Main._consPlaceholder_1, new IStrategoTerm[]{term}), checkListAnnos(termFactory, m_32964));
      context.popOnSuccess();
      if(true)
        return term;
    }
    context.popOnFailure();
    return null;
  }
}
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

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term, Strategy p_9751)
  { 
    ITermFactory termFactory = context.getFactory();
    context.push("Placeholder_1_0");
    Fail428:
    { 
      IStrategoTerm d_9926 = null;
      IStrategoTerm c_9926 = null;
      if(term.getTermType() != IStrategoTerm.APPL || Main._consPlaceholder_1 != ((IStrategoAppl)term).getConstructor())
        break Fail428;
      c_9926 = term.getSubterm(0);
      IStrategoList annos19 = term.getAnnotations();
      d_9926 = annos19;
      term = p_9751.invoke(context, c_9926);
      if(term == null)
        break Fail428;
      term = termFactory.annotateTerm(termFactory.makeAppl(Main._consPlaceholder_1, new IStrategoTerm[]{term}), checkListAnnos(termFactory, d_9926));
      context.popOnSuccess();
      if(true)
        return term;
    }
    context.popOnFailure();
    return null;
  }
}
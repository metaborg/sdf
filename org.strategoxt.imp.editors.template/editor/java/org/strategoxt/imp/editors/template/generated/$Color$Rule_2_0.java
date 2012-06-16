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

@SuppressWarnings("all") public class $Color$Rule_2_0 extends Strategy 
{ 
  public static $Color$Rule_2_0 instance = new $Color$Rule_2_0();

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term, Strategy i_9752, Strategy j_9752)
  { 
    ITermFactory termFactory = context.getFactory();
    context.push("ColorRule_2_0");
    Fail454:
    { 
      IStrategoTerm a_9928 = null;
      IStrategoTerm y_9927 = null;
      IStrategoTerm z_9927 = null;
      IStrategoTerm b_9928 = null;
      if(term.getTermType() != IStrategoTerm.APPL || Main._consColorRule_2 != ((IStrategoAppl)term).getConstructor())
        break Fail454;
      y_9927 = term.getSubterm(0);
      z_9927 = term.getSubterm(1);
      IStrategoList annos29 = term.getAnnotations();
      a_9928 = annos29;
      term = i_9752.invoke(context, y_9927);
      if(term == null)
        break Fail454;
      b_9928 = term;
      term = j_9752.invoke(context, z_9927);
      if(term == null)
        break Fail454;
      term = termFactory.annotateTerm(termFactory.makeAppl(Main._consColorRule_2, new IStrategoTerm[]{b_9928, term}), checkListAnnos(termFactory, a_9928));
      context.popOnSuccess();
      if(true)
        return term;
    }
    context.popOnFailure();
    return null;
  }
}
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

@SuppressWarnings("all") public class $Placeholder$With$Sort_2_0 extends Strategy 
{ 
  public static $Placeholder$With$Sort_2_0 instance = new $Placeholder$With$Sort_2_0();

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term, Strategy n_9751, Strategy o_9751)
  { 
    ITermFactory termFactory = context.getFactory();
    context.push("PlaceholderWithSort_2_0");
    Fail427:
    { 
      IStrategoTerm z_9925 = null;
      IStrategoTerm x_9925 = null;
      IStrategoTerm y_9925 = null;
      IStrategoTerm a_9926 = null;
      if(term.getTermType() != IStrategoTerm.APPL || Main._consPlaceholderWithSort_2 != ((IStrategoAppl)term).getConstructor())
        break Fail427;
      x_9925 = term.getSubterm(0);
      y_9925 = term.getSubterm(1);
      IStrategoList annos18 = term.getAnnotations();
      z_9925 = annos18;
      term = n_9751.invoke(context, x_9925);
      if(term == null)
        break Fail427;
      a_9926 = term;
      term = o_9751.invoke(context, y_9925);
      if(term == null)
        break Fail427;
      term = termFactory.annotateTerm(termFactory.makeAppl(Main._consPlaceholderWithSort_2, new IStrategoTerm[]{a_9926, term}), checkListAnnos(termFactory, z_9925));
      context.popOnSuccess();
      if(true)
        return term;
    }
    context.popOnFailure();
    return null;
  }
}
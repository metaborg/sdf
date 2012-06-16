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

@SuppressWarnings("all") public class $On$Save_2_0 extends Strategy 
{ 
  public static $On$Save_2_0 instance = new $On$Save_2_0();

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term, Strategy q_9755, Strategy r_9755)
  { 
    ITermFactory termFactory = context.getFactory();
    context.push("OnSave_2_0");
    Fail507:
    { 
      IStrategoTerm p_9936 = null;
      IStrategoTerm n_9936 = null;
      IStrategoTerm o_9936 = null;
      IStrategoTerm q_9936 = null;
      if(term.getTermType() != IStrategoTerm.APPL || Main._consOnSave_2 != ((IStrategoAppl)term).getConstructor())
        break Fail507;
      n_9936 = term.getSubterm(0);
      o_9936 = term.getSubterm(1);
      IStrategoList annos80 = term.getAnnotations();
      p_9936 = annos80;
      term = q_9755.invoke(context, n_9936);
      if(term == null)
        break Fail507;
      q_9936 = term;
      term = r_9755.invoke(context, o_9936);
      if(term == null)
        break Fail507;
      term = termFactory.annotateTerm(termFactory.makeAppl(Main._consOnSave_2, new IStrategoTerm[]{q_9936, term}), checkListAnnos(termFactory, p_9936));
      context.popOnSuccess();
      if(true)
        return term;
    }
    context.popOnFailure();
    return null;
  }
}
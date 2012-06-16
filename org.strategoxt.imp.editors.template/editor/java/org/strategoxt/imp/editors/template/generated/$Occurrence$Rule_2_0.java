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

@SuppressWarnings("all") public class $Occurrence$Rule_2_0 extends Strategy 
{ 
  public static $Occurrence$Rule_2_0 instance = new $Occurrence$Rule_2_0();

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term, Strategy h_9755, Strategy i_9755)
  { 
    ITermFactory termFactory = context.getFactory();
    context.push("OccurrenceRule_2_0");
    Fail503:
    { 
      IStrategoTerm t_9935 = null;
      IStrategoTerm r_9935 = null;
      IStrategoTerm s_9935 = null;
      IStrategoTerm u_9935 = null;
      if(term.getTermType() != IStrategoTerm.APPL || Main._consOccurrenceRule_2 != ((IStrategoAppl)term).getConstructor())
        break Fail503;
      r_9935 = term.getSubterm(0);
      s_9935 = term.getSubterm(1);
      IStrategoList annos76 = term.getAnnotations();
      t_9935 = annos76;
      term = h_9755.invoke(context, r_9935);
      if(term == null)
        break Fail503;
      u_9935 = term;
      term = i_9755.invoke(context, s_9935);
      if(term == null)
        break Fail503;
      term = termFactory.annotateTerm(termFactory.makeAppl(Main._consOccurrenceRule_2, new IStrategoTerm[]{u_9935, term}), checkListAnnos(termFactory, t_9935));
      context.popOnSuccess();
      if(true)
        return term;
    }
    context.popOnFailure();
    return null;
  }
}
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

@SuppressWarnings("all") public class $Reference$Hover$Rule_3_0 extends Strategy 
{ 
  public static $Reference$Hover$Rule_3_0 instance = new $Reference$Hover$Rule_3_0();

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term, Strategy w_32793, Strategy x_32793, Strategy y_32793)
  { 
    ITermFactory termFactory = context.getFactory();
    context.push("ReferenceHoverRule_3_0");
    Fail1326:
    { 
      IStrategoTerm s_32974 = null;
      IStrategoTerm p_32974 = null;
      IStrategoTerm q_32974 = null;
      IStrategoTerm r_32974 = null;
      IStrategoTerm t_32974 = null;
      IStrategoTerm u_32974 = null;
      if(term.getTermType() != IStrategoTerm.APPL || Main._consReferenceHoverRule_3 != ((IStrategoAppl)term).getConstructor())
        break Fail1326;
      p_32974 = term.getSubterm(0);
      q_32974 = term.getSubterm(1);
      r_32974 = term.getSubterm(2);
      IStrategoList annos97 = term.getAnnotations();
      s_32974 = annos97;
      term = w_32793.invoke(context, p_32974);
      if(term == null)
        break Fail1326;
      t_32974 = term;
      term = x_32793.invoke(context, q_32974);
      if(term == null)
        break Fail1326;
      u_32974 = term;
      term = y_32793.invoke(context, r_32974);
      if(term == null)
        break Fail1326;
      term = termFactory.annotateTerm(termFactory.makeAppl(Main._consReferenceHoverRule_3, new IStrategoTerm[]{t_32974, u_32974, term}), checkListAnnos(termFactory, s_32974));
      context.popOnSuccess();
      if(true)
        return term;
    }
    context.popOnFailure();
    return null;
  }
}
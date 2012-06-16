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

@SuppressWarnings("all") public class $Reference$Rule_2_0 extends Strategy 
{ 
  public static $Reference$Rule_2_0 instance = new $Reference$Rule_2_0();

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term, Strategy l_9755, Strategy m_9755)
  { 
    ITermFactory termFactory = context.getFactory();
    context.push("ReferenceRule_2_0");
    Fail505:
    { 
      IStrategoTerm d_9936 = null;
      IStrategoTerm b_9936 = null;
      IStrategoTerm c_9936 = null;
      IStrategoTerm e_9936 = null;
      if(term.getTermType() != IStrategoTerm.APPL || Main._consReferenceRule_2 != ((IStrategoAppl)term).getConstructor())
        break Fail505;
      b_9936 = term.getSubterm(0);
      c_9936 = term.getSubterm(1);
      IStrategoList annos78 = term.getAnnotations();
      d_9936 = annos78;
      term = l_9755.invoke(context, b_9936);
      if(term == null)
        break Fail505;
      e_9936 = term;
      term = m_9755.invoke(context, c_9936);
      if(term == null)
        break Fail505;
      term = termFactory.annotateTerm(termFactory.makeAppl(Main._consReferenceRule_2, new IStrategoTerm[]{e_9936, term}), checkListAnnos(termFactory, d_9936));
      context.popOnSuccess();
      if(true)
        return term;
    }
    context.popOnFailure();
    return null;
  }
}
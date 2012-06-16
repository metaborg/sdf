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

@SuppressWarnings("all") final class lifted194 extends Strategy 
{ 
  TermReference o_9946;

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term)
  { 
    ITermFactory termFactory = context.getFactory();
    Fail809:
    { 
      IStrategoTerm p_9946 = null;
      IStrategoTerm q_9946 = null;
      IStrategoTerm r_9946 = null;
      IStrategoTerm s_9946 = null;
      IStrategoTerm t_9946 = null;
      if(term.getTermType() != IStrategoTerm.LIST || ((IStrategoList)term).isEmpty())
        break Fail809;
      p_9946 = ((IStrategoList)term).head();
      q_9946 = ((IStrategoList)term).tail();
      IStrategoList annos12 = term.getAnnotations();
      t_9946 = annos12;
      term = p_9946;
      lifted195 lifted1950 = new lifted195();
      lifted1950.o_9946 = o_9946;
      term = templatelang_origin_track_forced_1_0.instance.invoke(context, term, lifted1950);
      if(term == null)
        break Fail809;
      r_9946 = term;
      term = q_9946;
      s_9946 = q_9946;
      IStrategoList list25;
      list25 = checkListTail(s_9946);
      if(list25 == null)
        break Fail809;
      term = termFactory.annotateTerm((IStrategoTerm)termFactory.makeListCons(r_9946, list25), checkListAnnos(termFactory, t_9946));
      if(true)
        return term;
    }
    return null;
  }
}
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

@SuppressWarnings("all") final class lifted336 extends Strategy 
{ 
  public static final lifted336 instance = new lifted336();

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term)
  { 
    ITermFactory termFactory = context.getFactory();
    Fail1676:
    { 
      IStrategoTerm m_32762 = null;
      IStrategoTerm n_32762 = null;
      IStrategoTerm o_32762 = null;
      IStrategoTerm p_32762 = null;
      IStrategoTerm q_32762 = null;
      if(term.getTermType() != IStrategoTerm.LIST || ((IStrategoList)term).isEmpty())
        break Fail1676;
      m_32762 = ((IStrategoList)term).head();
      n_32762 = ((IStrategoList)term).tail();
      IStrategoList annos22 = term.getAnnotations();
      q_32762 = annos22;
      term = $String_1_0.instance.invoke(context, m_32762, lifted337.instance);
      if(term == null)
        break Fail1676;
      o_32762 = term;
      term = n_32762;
      p_32762 = n_32762;
      IStrategoList list9;
      list9 = checkListTail(p_32762);
      if(list9 == null)
        break Fail1676;
      term = termFactory.annotateTerm((IStrategoTerm)termFactory.makeListCons(o_32762, list9), checkListAnnos(termFactory, q_32762));
      if(true)
        return term;
    }
    return null;
  }
}
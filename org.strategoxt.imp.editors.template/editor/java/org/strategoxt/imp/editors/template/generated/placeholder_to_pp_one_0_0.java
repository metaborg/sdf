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

@SuppressWarnings("all") public class placeholder_to_pp_one_0_0 extends Strategy 
{ 
  public static placeholder_to_pp_one_0_0 instance = new placeholder_to_pp_one_0_0();

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term)
  { 
    ITermFactory termFactory = context.getFactory();
    context.push("placeholder_to_pp_one_0_0");
    Fail888:
    { 
      TermReference k_32752 = new TermReference();
      TermReference l_32752 = new TermReference();
      TermReference m_32752 = new TermReference();
      TermReference n_32752 = new TermReference();
      IStrategoTerm i_32753 = null;
      if(term.getTermType() != IStrategoTerm.APPL || Main._consPlaceholder_4 != ((IStrategoAppl)term).getConstructor())
        break Fail888;
      IStrategoTerm arg212 = term.getSubterm(1);
      if(arg212.getTermType() != IStrategoTerm.APPL || Main._conssort_1 != ((IStrategoAppl)arg212).getConstructor())
        break Fail888;
      if(m_32752.value == null)
        m_32752.value = arg212.getSubterm(0);
      else
        if(m_32752.value != arg212.getSubterm(0) && !m_32752.value.match(arg212.getSubterm(0)))
          break Fail888;
      if(k_32752.value == null)
        k_32752.value = term.getSubterm(3);
      else
        if(k_32752.value != term.getSubterm(3) && !k_32752.value.match(term.getSubterm(3)))
          break Fail888;
      i_32753 = term;
      lifted247 lifted2470 = new lifted247();
      lifted2470.k_32752 = k_32752;
      lifted2470.l_32752 = l_32752;
      lifted2470.m_32752 = m_32752;
      lifted2470.n_32752 = n_32752;
      term = with_spxverify_2_0.instance.invoke(context, term, lifted2470, lifted249.instance);
      if(term == null)
        break Fail888;
      term = i_32753;
      if(l_32752.value == null || n_32752.value == null)
        break Fail888;
      term = termFactory.makeAppl(Main._consCall_2, new IStrategoTerm[]{l_32752.value, (IStrategoTerm)termFactory.makeListCons(n_32752.value, (IStrategoList)generated.constNil3)});
      context.popOnSuccess();
      if(true)
        return term;
    }
    context.popOnFailure();
    return null;
  }
}
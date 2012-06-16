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

@SuppressWarnings("all") public class rename_template_line_0_0 extends Strategy 
{ 
  public static rename_template_line_0_0 instance = new rename_template_line_0_0();

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term)
  { 
    ITermFactory termFactory = context.getFactory();
    context.push("rename_template_line_0_0");
    Fail52:
    { 
      TermReference j_9710 = new TermReference();
      TermReference k_9710 = new TermReference();
      TermReference l_9710 = new TermReference();
      TermReference m_9710 = new TermReference();
      IStrategoTerm n_9710 = null;
      if(term.getTermType() != IStrategoTerm.TUPLE || term.getSubtermCount() != 2)
        break Fail52;
      IStrategoTerm arg32 = term.getSubterm(0);
      if(arg32.getTermType() != IStrategoTerm.APPL || Main._consLine_1 != ((IStrategoAppl)arg32).getConstructor())
        break Fail52;
      if(j_9710.value == null)
        j_9710.value = arg32.getSubterm(0);
      else
        if(j_9710.value != arg32.getSubterm(0) && !j_9710.value.match(arg32.getSubterm(0)))
          break Fail52;
      if(k_9710.value == null)
        k_9710.value = term.getSubterm(1);
      else
        if(k_9710.value != term.getSubterm(1) && !k_9710.value.match(term.getSubterm(1)))
          break Fail52;
      n_9710 = term;
      lifted28 lifted2810 = new lifted28();
      lifted2810.j_9710 = j_9710;
      lifted2810.k_9710 = k_9710;
      lifted2810.l_9710 = l_9710;
      lifted2810.m_9710 = m_9710;
      term = with_spxverify_2_0.instance.invoke(context, term, lifted2810, lifted31.instance);
      if(term == null)
        break Fail52;
      term = n_9710;
      if(l_9710.value == null || m_9710.value == null)
        break Fail52;
      term = termFactory.makeTuple(termFactory.makeAppl(Main._consLine_1, new IStrategoTerm[]{l_9710.value}), m_9710.value);
      context.popOnSuccess();
      if(true)
        return term;
    }
    context.popOnFailure();
    return null;
  }
}
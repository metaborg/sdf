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

@SuppressWarnings("all") public class template_section_to_stratego_0_0 extends Strategy 
{ 
  public static template_section_to_stratego_0_0 instance = new template_section_to_stratego_0_0();

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term)
  { 
    ITermFactory termFactory = context.getFactory();
    context.push("template_section_to_stratego_0_0");
    Fail836:
    { 
      IStrategoTerm term270 = term;
      Success268:
      { 
        Fail837:
        { 
          TermReference o_32744 = new TermReference();
          TermReference p_32744 = new TermReference();
          IStrategoTerm q_32744 = null;
          if(term.getTermType() != IStrategoTerm.APPL || Main._consTemplateSection_1 != ((IStrategoAppl)term).getConstructor())
            break Fail837;
          if(o_32744.value == null)
            o_32744.value = term.getSubterm(0);
          else
            if(o_32744.value != term.getSubterm(0) && !o_32744.value.match(term.getSubterm(0)))
              break Fail837;
          q_32744 = term;
          lifted215 lifted2150 = new lifted215();
          lifted2150.o_32744 = o_32744;
          lifted2150.p_32744 = p_32744;
          term = with_spxverify_2_0.instance.invoke(context, term, lifted2150, lifted217.instance);
          if(term == null)
            break Fail837;
          term = q_32744;
          if(p_32744.value == null)
            break Fail837;
          term = termFactory.makeAppl(Main._consStrategies_1, new IStrategoTerm[]{p_32744.value});
          if(true)
            break Success268;
        }
        term = term270;
        TermReference k_32744 = new TermReference();
        TermReference l_32744 = new TermReference();
        TermReference m_32744 = new TermReference();
        IStrategoTerm n_32744 = null;
        if(term.getTermType() != IStrategoTerm.APPL || Main._consSDFSection_1 != ((IStrategoAppl)term).getConstructor())
          break Fail836;
        IStrategoTerm arg162 = term.getSubterm(0);
        if(arg162.getTermType() != IStrategoTerm.APPL || Main._conslexical_syntax_1 != ((IStrategoAppl)arg162).getConstructor())
          break Fail836;
        if(k_32744.value == null)
          k_32744.value = arg162.getSubterm(0);
        else
          if(k_32744.value != arg162.getSubterm(0) && !k_32744.value.match(arg162.getSubterm(0)))
            break Fail836;
        n_32744 = term;
        lifted218 lifted2180 = new lifted218();
        lifted2180.k_32744 = k_32744;
        lifted2180.l_32744 = l_32744;
        lifted2180.m_32744 = m_32744;
        term = with_spxverify_2_0.instance.invoke(context, term, lifted2180, lifted221.instance);
        if(term == null)
          break Fail836;
        term = n_32744;
        if(m_32744.value == null)
          break Fail836;
        term = termFactory.makeAppl(Main._consStrategies_1, new IStrategoTerm[]{m_32744.value});
      }
      context.popOnSuccess();
      if(true)
        return term;
    }
    context.popOnFailure();
    return null;
  }
}
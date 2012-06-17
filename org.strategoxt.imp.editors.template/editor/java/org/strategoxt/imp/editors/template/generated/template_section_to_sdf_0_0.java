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

@SuppressWarnings("all") public class template_section_to_sdf_0_0 extends Strategy 
{ 
  public static template_section_to_sdf_0_0 instance = new template_section_to_sdf_0_0();

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term)
  { 
    ITermFactory termFactory = context.getFactory();
    context.push("template_section_to_sdf_0_0");
    Fail903:
    { 
      IStrategoTerm term344 = term;
      Success317:
      { 
        Fail904:
        { 
          TermReference d_32755 = new TermReference();
          TermReference e_32755 = new TermReference();
          TermReference f_32755 = new TermReference();
          TermReference g_32755 = new TermReference();
          TermReference h_32755 = new TermReference();
          TermReference i_32755 = new TermReference();
          TermReference j_32755 = new TermReference();
          IStrategoTerm q_32755 = null;
          IStrategoTerm t_32755 = null;
          IStrategoTerm u_32755 = null;
          if(term.getTermType() != IStrategoTerm.APPL || Main._consTemplateSection_1 != ((IStrategoAppl)term).getConstructor())
            break Fail904;
          if(g_32755.value == null)
            g_32755.value = term.getSubterm(0);
          else
            if(g_32755.value != term.getSubterm(0) && !g_32755.value.match(term.getSubterm(0)))
              break Fail904;
          q_32755 = term;
          lifted260 lifted2600 = new lifted260();
          lifted2600.d_32755 = d_32755;
          lifted2600.e_32755 = e_32755;
          lifted2600.f_32755 = f_32755;
          lifted2600.g_32755 = g_32755;
          lifted2600.h_32755 = h_32755;
          lifted2600.i_32755 = i_32755;
          lifted2600.j_32755 = j_32755;
          term = with_spxverify_2_0.instance.invoke(context, term, lifted2600, lifted267.instance);
          if(term == null)
            break Fail904;
          term = q_32755;
          u_32755 = q_32755;
          if(f_32755.value == null || j_32755.value == null)
            break Fail904;
          term = termFactory.makeTuple(f_32755.value, termFactory.annotateTerm(j_32755.value, checkListAnnos(termFactory, generated.constNil3)));
          term = make$Conc_0_0.instance.invoke(context, term);
          if(term == null)
            break Fail904;
          t_32755 = term;
          term = u_32755;
          if(d_32755.value == null)
            break Fail904;
          IStrategoList list5;
          list5 = checkListTail(t_32755);
          if(list5 == null)
            break Fail904;
          term = (IStrategoTerm)termFactory.makeListCons(termFactory.makeAppl(Main._conscontext_free_syntax_1, new IStrategoTerm[]{d_32755.value}), list5);
          if(true)
            break Success317;
        }
        term = term344;
        IStrategoTerm c_32755 = null;
        if(term.getTermType() != IStrategoTerm.APPL || Main._consSDFSection_1 != ((IStrategoAppl)term).getConstructor())
          break Fail903;
        c_32755 = term.getSubterm(0);
        term = (IStrategoTerm)termFactory.makeListCons(c_32755, (IStrategoList)generated.constNil3);
      }
      context.popOnSuccess();
      if(true)
        return term;
    }
    context.popOnFailure();
    return null;
  }
}
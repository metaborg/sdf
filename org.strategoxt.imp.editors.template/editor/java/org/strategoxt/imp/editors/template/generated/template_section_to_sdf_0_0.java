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
    Fail84:
    { 
      IStrategoTerm term89 = term;
      Success62:
      { 
        Fail85:
        { 
          TermReference v_9716 = new TermReference();
          TermReference w_9716 = new TermReference();
          TermReference x_9716 = new TermReference();
          TermReference y_9716 = new TermReference();
          TermReference z_9716 = new TermReference();
          TermReference a_9717 = new TermReference();
          TermReference b_9717 = new TermReference();
          IStrategoTerm i_9717 = null;
          IStrategoTerm l_9717 = null;
          IStrategoTerm m_9717 = null;
          if(term.getTermType() != IStrategoTerm.APPL || Main._consTemplateSection_1 != ((IStrategoAppl)term).getConstructor())
            break Fail85;
          if(y_9716.value == null)
            y_9716.value = term.getSubterm(0);
          else
            if(y_9716.value != term.getSubterm(0) && !y_9716.value.match(term.getSubterm(0)))
              break Fail85;
          i_9717 = term;
          lifted61 lifted610 = new lifted61();
          lifted610.v_9716 = v_9716;
          lifted610.w_9716 = w_9716;
          lifted610.x_9716 = x_9716;
          lifted610.y_9716 = y_9716;
          lifted610.z_9716 = z_9716;
          lifted610.a_9717 = a_9717;
          lifted610.b_9717 = b_9717;
          term = with_spxverify_2_0.instance.invoke(context, term, lifted610, lifted68.instance);
          if(term == null)
            break Fail85;
          term = i_9717;
          m_9717 = i_9717;
          if(x_9716.value == null || b_9717.value == null)
            break Fail85;
          term = termFactory.makeTuple(x_9716.value, termFactory.annotateTerm(b_9717.value, checkListAnnos(termFactory, generated.constNil0)));
          term = make$Conc_0_0.instance.invoke(context, term);
          if(term == null)
            break Fail85;
          l_9717 = term;
          term = m_9717;
          if(v_9716.value == null)
            break Fail85;
          IStrategoList list2;
          list2 = checkListTail(l_9717);
          if(list2 == null)
            break Fail85;
          term = (IStrategoTerm)termFactory.makeListCons(termFactory.makeAppl(Main._conscontext_free_syntax_1, new IStrategoTerm[]{v_9716.value}), list2);
          if(true)
            break Success62;
        }
        term = term89;
        IStrategoTerm u_9716 = null;
        if(term.getTermType() != IStrategoTerm.APPL || Main._consSDFSection_1 != ((IStrategoAppl)term).getConstructor())
          break Fail84;
        u_9716 = term.getSubterm(0);
        term = (IStrategoTerm)termFactory.makeListCons(u_9716, (IStrategoList)generated.constNil0);
      }
      context.popOnSuccess();
      if(true)
        return term;
    }
    context.popOnFailure();
    return null;
  }
}
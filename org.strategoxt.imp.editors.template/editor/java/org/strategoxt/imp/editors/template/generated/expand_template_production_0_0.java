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

@SuppressWarnings("all") public class expand_template_production_0_0 extends Strategy 
{ 
  public static expand_template_production_0_0 instance = new expand_template_production_0_0();

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term)
  { 
    ITermFactory termFactory = context.getFactory();
    context.push("expand_template_production_0_0");
    Fail194:
    { 
      IStrategoTerm m_9728 = null;
      IStrategoTerm n_9728 = null;
      IStrategoTerm o_9728 = null;
      if(term.getTermType() != IStrategoTerm.APPL || Main._consTemplateProduction_3 != ((IStrategoAppl)term).getConstructor())
        break Fail194;
      m_9728 = term.getSubterm(1);
      o_9728 = term.getSubterm(2);
      term = o_9728;
      IStrategoTerm term192 = term;
      Success140:
      { 
        Fail195:
        { 
          term = is_reject_0_0.instance.invoke(context, term);
          if(term == null)
            break Fail195;
          { 
            if(true)
              break Fail194;
            if(true)
              break Success140;
          }
        }
        term = term192;
      }
      term = expand_template_0_0.instance.invoke(context, m_9728);
      if(term == null)
        break Fail194;
      n_9728 = term;
      term = determine_score_0_0.instance.invoke(context, o_9728);
      if(term == null)
        break Fail194;
      term = termFactory.annotateTerm(n_9728, checkListAnnos(termFactory, (IStrategoTerm)termFactory.makeListCons(term, (IStrategoList)generated.constNil0)));
      context.popOnSuccess();
      if(true)
        return term;
    }
    context.popOnFailure();
    return null;
  }
}
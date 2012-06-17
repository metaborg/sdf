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
    Fail1014:
    { 
      IStrategoTerm v_32766 = null;
      IStrategoTerm w_32766 = null;
      IStrategoTerm x_32766 = null;
      if(term.getTermType() != IStrategoTerm.APPL || Main._consTemplateProduction_3 != ((IStrategoAppl)term).getConstructor())
        break Fail1014;
      v_32766 = term.getSubterm(1);
      x_32766 = term.getSubterm(2);
      term = x_32766;
      IStrategoTerm term448 = term;
      Success396:
      { 
        Fail1015:
        { 
          term = is_reject_0_0.instance.invoke(context, term);
          if(term == null)
            break Fail1015;
          { 
            if(true)
              break Fail1014;
            if(true)
              break Success396;
          }
        }
        term = term448;
      }
      term = expand_template_0_0.instance.invoke(context, v_32766);
      if(term == null)
        break Fail1014;
      w_32766 = term;
      term = determine_score_0_0.instance.invoke(context, x_32766);
      if(term == null)
        break Fail1014;
      term = termFactory.annotateTerm(w_32766, checkListAnnos(termFactory, (IStrategoTerm)termFactory.makeListCons(term, (IStrategoList)generated.constNil3)));
      context.popOnSuccess();
      if(true)
        return term;
    }
    context.popOnFailure();
    return null;
  }
}
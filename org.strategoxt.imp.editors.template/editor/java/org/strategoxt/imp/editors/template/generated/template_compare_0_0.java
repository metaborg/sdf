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

@SuppressWarnings("all") public class template_compare_0_0 extends Strategy 
{ 
  public static template_compare_0_0 instance = new template_compare_0_0();

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term)
  { 
    ITermFactory termFactory = context.getFactory();
    context.push("template_compare_0_0");
    Fail243:
    { 
      IStrategoTerm v_9732 = null;
      IStrategoTerm w_9732 = null;
      IStrategoTerm x_9732 = null;
      IStrategoTerm y_9732 = null;
      IStrategoTerm z_9732 = null;
      if(term.getTermType() != IStrategoTerm.TUPLE || term.getSubtermCount() != 2)
        break Fail243;
      IStrategoTerm arg329 = term.getSubterm(0);
      x_9732 = arg329;
      IStrategoList annos10 = arg329.getAnnotations();
      if(annos10.getTermType() != IStrategoTerm.LIST || ((IStrategoList)annos10).isEmpty())
        break Fail243;
      v_9732 = ((IStrategoList)annos10).head();
      IStrategoTerm arg330 = ((IStrategoList)annos10).tail();
      if(arg330.getTermType() != IStrategoTerm.LIST || !((IStrategoList)arg330).isEmpty())
        break Fail243;
      IStrategoTerm arg331 = term.getSubterm(1);
      y_9732 = arg331;
      IStrategoList annos11 = arg331.getAnnotations();
      if(annos11.getTermType() != IStrategoTerm.LIST || ((IStrategoList)annos11).isEmpty())
        break Fail243;
      w_9732 = ((IStrategoList)annos11).head();
      IStrategoTerm arg332 = ((IStrategoList)annos11).tail();
      if(arg332.getTermType() != IStrategoTerm.LIST || !((IStrategoList)arg332).isEmpty())
        break Fail243;
      z_9732 = term;
      Success180:
      { 
        Fail244:
        { 
          term = termFactory.makeTuple(v_9732, w_9732);
          term = gti_0_0.instance.invoke(context, term);
          if(term == null)
            break Fail244;
          if(true)
            break Success180;
        }
        IStrategoTerm a_9733 = null;
        term = termFactory.makeTuple(v_9732, w_9732);
        term = eq_0_0.instance.invoke(context, term);
        if(term == null)
          break Fail243;
        term = template_character_count_0_0.instance.invoke(context, x_9732);
        if(term == null)
          break Fail243;
        a_9733 = term;
        term = template_character_count_0_0.instance.invoke(context, y_9732);
        if(term == null)
          break Fail243;
        term = termFactory.makeTuple(a_9733, term);
        term = lti_0_0.instance.invoke(context, term);
        if(term == null)
          break Fail243;
      }
      term = z_9732;
      context.popOnSuccess();
      if(true)
        return term;
    }
    context.popOnFailure();
    return null;
  }
}
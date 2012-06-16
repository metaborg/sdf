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

@SuppressWarnings("all") public class $Builder_3_0 extends Strategy 
{ 
  public static $Builder_3_0 instance = new $Builder_3_0();

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term, Strategy n_9754, Strategy o_9754, Strategy p_9754)
  { 
    ITermFactory termFactory = context.getFactory();
    context.push("Builder_3_0");
    Fail495:
    { 
      IStrategoTerm y_9933 = null;
      IStrategoTerm v_9933 = null;
      IStrategoTerm w_9933 = null;
      IStrategoTerm x_9933 = null;
      IStrategoTerm z_9933 = null;
      IStrategoTerm a_9934 = null;
      if(term.getTermType() != IStrategoTerm.APPL || Main._consBuilder_3 != ((IStrategoAppl)term).getConstructor())
        break Fail495;
      v_9933 = term.getSubterm(0);
      w_9933 = term.getSubterm(1);
      x_9933 = term.getSubterm(2);
      IStrategoList annos68 = term.getAnnotations();
      y_9933 = annos68;
      term = n_9754.invoke(context, v_9933);
      if(term == null)
        break Fail495;
      z_9933 = term;
      term = o_9754.invoke(context, w_9933);
      if(term == null)
        break Fail495;
      a_9934 = term;
      term = p_9754.invoke(context, x_9933);
      if(term == null)
        break Fail495;
      term = termFactory.annotateTerm(termFactory.makeAppl(Main._consBuilder_3, new IStrategoTerm[]{z_9933, a_9934, term}), checkListAnnos(termFactory, y_9933));
      context.popOnSuccess();
      if(true)
        return term;
    }
    context.popOnFailure();
    return null;
  }
}
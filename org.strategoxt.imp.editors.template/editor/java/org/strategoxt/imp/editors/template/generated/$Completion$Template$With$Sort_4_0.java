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

@SuppressWarnings("all") public class $Completion$Template$With$Sort_4_0 extends Strategy 
{ 
  public static $Completion$Template$With$Sort_4_0 instance = new $Completion$Template$With$Sort_4_0();

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term, Strategy x_9754, Strategy y_9754, Strategy z_9754, Strategy a_9755)
  { 
    ITermFactory termFactory = context.getFactory();
    context.push("CompletionTemplateWithSort_4_0");
    Fail499:
    { 
      IStrategoTerm x_9934 = null;
      IStrategoTerm t_9934 = null;
      IStrategoTerm u_9934 = null;
      IStrategoTerm v_9934 = null;
      IStrategoTerm w_9934 = null;
      IStrategoTerm y_9934 = null;
      IStrategoTerm z_9934 = null;
      IStrategoTerm a_9935 = null;
      if(term.getTermType() != IStrategoTerm.APPL || Main._consCompletionTemplateWithSort_4 != ((IStrategoAppl)term).getConstructor())
        break Fail499;
      t_9934 = term.getSubterm(0);
      u_9934 = term.getSubterm(1);
      v_9934 = term.getSubterm(2);
      w_9934 = term.getSubterm(3);
      IStrategoList annos72 = term.getAnnotations();
      x_9934 = annos72;
      term = x_9754.invoke(context, t_9934);
      if(term == null)
        break Fail499;
      y_9934 = term;
      term = y_9754.invoke(context, u_9934);
      if(term == null)
        break Fail499;
      z_9934 = term;
      term = z_9754.invoke(context, v_9934);
      if(term == null)
        break Fail499;
      a_9935 = term;
      term = a_9755.invoke(context, w_9934);
      if(term == null)
        break Fail499;
      term = termFactory.annotateTerm(termFactory.makeAppl(Main._consCompletionTemplateWithSort_4, new IStrategoTerm[]{y_9934, z_9934, a_9935, term}), checkListAnnos(termFactory, x_9934));
      context.popOnSuccess();
      if(true)
        return term;
    }
    context.popOnFailure();
    return null;
  }
}
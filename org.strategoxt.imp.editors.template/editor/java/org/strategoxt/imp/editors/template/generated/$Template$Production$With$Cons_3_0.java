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

@SuppressWarnings("all") public class $Template$Production$With$Cons_3_0 extends Strategy 
{ 
  public static $Template$Production$With$Cons_3_0 instance = new $Template$Production$With$Cons_3_0();

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term, Strategy g_9757, Strategy h_9757, Strategy i_9757)
  { 
    ITermFactory termFactory = context.getFactory();
    context.push("TemplateProductionWithCons_3_0");
    Fail548:
    { 
      IStrategoTerm b_9941 = null;
      IStrategoTerm y_9940 = null;
      IStrategoTerm z_9940 = null;
      IStrategoTerm a_9941 = null;
      IStrategoTerm c_9941 = null;
      IStrategoTerm d_9941 = null;
      if(term.getTermType() != IStrategoTerm.APPL || Main._consTemplateProductionWithCons_3 != ((IStrategoAppl)term).getConstructor())
        break Fail548;
      y_9940 = term.getSubterm(0);
      z_9940 = term.getSubterm(1);
      a_9941 = term.getSubterm(2);
      IStrategoList annos111 = term.getAnnotations();
      b_9941 = annos111;
      term = g_9757.invoke(context, y_9940);
      if(term == null)
        break Fail548;
      c_9941 = term;
      term = h_9757.invoke(context, z_9940);
      if(term == null)
        break Fail548;
      d_9941 = term;
      term = i_9757.invoke(context, a_9941);
      if(term == null)
        break Fail548;
      term = termFactory.annotateTerm(termFactory.makeAppl(Main._consTemplateProductionWithCons_3, new IStrategoTerm[]{c_9941, d_9941, term}), checkListAnnos(termFactory, b_9941));
      context.popOnSuccess();
      if(true)
        return term;
    }
    context.popOnFailure();
    return null;
  }
}
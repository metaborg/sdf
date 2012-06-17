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

@SuppressWarnings("all") public class $Color$R$G$B_3_0 extends Strategy 
{ 
  public static $Color$R$G$B_3_0 instance = new $Color$R$G$B_3_0();

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term, Strategy a_32790, Strategy b_32790, Strategy c_32790)
  { 
    ITermFactory termFactory = context.getFactory();
    context.push("ColorRGB_3_0");
    Fail1252:
    { 
      IStrategoTerm u_32964 = null;
      IStrategoTerm r_32964 = null;
      IStrategoTerm s_32964 = null;
      IStrategoTerm t_32964 = null;
      IStrategoTerm v_32964 = null;
      IStrategoTerm w_32964 = null;
      if(term.getTermType() != IStrategoTerm.APPL || Main._consColorRGB_3 != ((IStrategoAppl)term).getConstructor())
        break Fail1252;
      r_32964 = term.getSubterm(0);
      s_32964 = term.getSubterm(1);
      t_32964 = term.getSubterm(2);
      IStrategoList annos39 = term.getAnnotations();
      u_32964 = annos39;
      term = a_32790.invoke(context, r_32964);
      if(term == null)
        break Fail1252;
      v_32964 = term;
      term = b_32790.invoke(context, s_32964);
      if(term == null)
        break Fail1252;
      w_32964 = term;
      term = c_32790.invoke(context, t_32964);
      if(term == null)
        break Fail1252;
      term = termFactory.annotateTerm(termFactory.makeAppl(Main._consColorRGB_3, new IStrategoTerm[]{v_32964, w_32964, term}), checkListAnnos(termFactory, u_32964));
      context.popOnSuccess();
      if(true)
        return term;
    }
    context.popOnFailure();
    return null;
  }
}
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

@SuppressWarnings("all") public class $Module_3_0 extends Strategy 
{ 
  public static $Module_3_0 instance = new $Module_3_0();

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term, Strategy t_32789, Strategy u_32789, Strategy v_32789)
  { 
    ITermFactory termFactory = context.getFactory();
    context.push("Module_3_0");
    Fail1237:
    { 
      IStrategoTerm c_32964 = null;
      IStrategoTerm z_32963 = null;
      IStrategoTerm a_32964 = null;
      IStrategoTerm b_32964 = null;
      IStrategoTerm d_32964 = null;
      IStrategoTerm e_32964 = null;
      if(term.getTermType() != IStrategoTerm.APPL || Main._consModule_3 != ((IStrategoAppl)term).getConstructor())
        break Fail1237;
      z_32963 = term.getSubterm(0);
      a_32964 = term.getSubterm(1);
      b_32964 = term.getSubterm(2);
      IStrategoList annos35 = term.getAnnotations();
      c_32964 = annos35;
      term = t_32789.invoke(context, z_32963);
      if(term == null)
        break Fail1237;
      d_32964 = term;
      term = u_32789.invoke(context, a_32964);
      if(term == null)
        break Fail1237;
      e_32964 = term;
      term = v_32789.invoke(context, b_32964);
      if(term == null)
        break Fail1237;
      term = termFactory.annotateTerm(termFactory.makeAppl(Main._consModule_3, new IStrategoTerm[]{d_32964, e_32964, term}), checkListAnnos(termFactory, c_32964));
      context.popOnSuccess();
      if(true)
        return term;
    }
    context.popOnFailure();
    return null;
  }
}
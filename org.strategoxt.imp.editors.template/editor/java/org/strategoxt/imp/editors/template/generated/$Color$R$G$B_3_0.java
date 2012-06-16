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

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term, Strategy r_9751, Strategy s_9751, Strategy t_9751)
  { 
    ITermFactory termFactory = context.getFactory();
    context.push("ColorRGB_3_0");
    Fail432:
    { 
      IStrategoTerm l_9926 = null;
      IStrategoTerm i_9926 = null;
      IStrategoTerm j_9926 = null;
      IStrategoTerm k_9926 = null;
      IStrategoTerm m_9926 = null;
      IStrategoTerm n_9926 = null;
      if(term.getTermType() != IStrategoTerm.APPL || Main._consColorRGB_3 != ((IStrategoAppl)term).getConstructor())
        break Fail432;
      i_9926 = term.getSubterm(0);
      j_9926 = term.getSubterm(1);
      k_9926 = term.getSubterm(2);
      IStrategoList annos21 = term.getAnnotations();
      l_9926 = annos21;
      term = r_9751.invoke(context, i_9926);
      if(term == null)
        break Fail432;
      m_9926 = term;
      term = s_9751.invoke(context, j_9926);
      if(term == null)
        break Fail432;
      n_9926 = term;
      term = t_9751.invoke(context, k_9926);
      if(term == null)
        break Fail432;
      term = termFactory.annotateTerm(termFactory.makeAppl(Main._consColorRGB_3, new IStrategoTerm[]{m_9926, n_9926, term}), checkListAnnos(termFactory, l_9926));
      context.popOnSuccess();
      if(true)
        return term;
    }
    context.popOnFailure();
    return null;
  }
}
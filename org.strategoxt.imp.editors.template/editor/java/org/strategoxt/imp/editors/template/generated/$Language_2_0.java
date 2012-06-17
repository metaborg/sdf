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

@SuppressWarnings("all") public class $Language_2_0 extends Strategy 
{ 
  public static $Language_2_0 instance = new $Language_2_0();

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term, Strategy l_32792, Strategy m_32792)
  { 
    ITermFactory termFactory = context.getFactory();
    context.push("Language_2_0");
    Fail1308:
    { 
      IStrategoTerm d_32971 = null;
      IStrategoTerm b_32971 = null;
      IStrategoTerm c_32971 = null;
      IStrategoTerm e_32971 = null;
      if(term.getTermType() != IStrategoTerm.APPL || Main._consLanguage_2 != ((IStrategoAppl)term).getConstructor())
        break Fail1308;
      b_32971 = term.getSubterm(0);
      c_32971 = term.getSubterm(1);
      IStrategoList annos79 = term.getAnnotations();
      d_32971 = annos79;
      term = l_32792.invoke(context, b_32971);
      if(term == null)
        break Fail1308;
      e_32971 = term;
      term = m_32792.invoke(context, c_32971);
      if(term == null)
        break Fail1308;
      term = termFactory.annotateTerm(termFactory.makeAppl(Main._consLanguage_2, new IStrategoTerm[]{e_32971, term}), checkListAnnos(termFactory, d_32971));
      context.popOnSuccess();
      if(true)
        return term;
    }
    context.popOnFailure();
    return null;
  }
}
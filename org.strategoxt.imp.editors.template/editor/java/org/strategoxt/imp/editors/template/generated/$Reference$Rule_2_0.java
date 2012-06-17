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

@SuppressWarnings("all") public class $Reference$Rule_2_0 extends Strategy 
{ 
  public static $Reference$Rule_2_0 instance = new $Reference$Rule_2_0();

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term, Strategy u_32793, Strategy v_32793)
  { 
    ITermFactory termFactory = context.getFactory();
    context.push("ReferenceRule_2_0");
    Fail1325:
    { 
      IStrategoTerm m_32974 = null;
      IStrategoTerm k_32974 = null;
      IStrategoTerm l_32974 = null;
      IStrategoTerm n_32974 = null;
      if(term.getTermType() != IStrategoTerm.APPL || Main._consReferenceRule_2 != ((IStrategoAppl)term).getConstructor())
        break Fail1325;
      k_32974 = term.getSubterm(0);
      l_32974 = term.getSubterm(1);
      IStrategoList annos96 = term.getAnnotations();
      m_32974 = annos96;
      term = u_32793.invoke(context, k_32974);
      if(term == null)
        break Fail1325;
      n_32974 = term;
      term = v_32793.invoke(context, l_32974);
      if(term == null)
        break Fail1325;
      term = termFactory.annotateTerm(termFactory.makeAppl(Main._consReferenceRule_2, new IStrategoTerm[]{n_32974, term}), checkListAnnos(termFactory, m_32974));
      context.popOnSuccess();
      if(true)
        return term;
    }
    context.popOnFailure();
    return null;
  }
}
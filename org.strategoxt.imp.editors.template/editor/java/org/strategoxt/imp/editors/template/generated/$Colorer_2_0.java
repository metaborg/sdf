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

@SuppressWarnings("all") public class $Colorer_2_0 extends Strategy 
{ 
  public static $Colorer_2_0 instance = new $Colorer_2_0();

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term, Strategy f_32792, Strategy g_32792)
  { 
    ITermFactory termFactory = context.getFactory();
    context.push("Colorer_2_0");
    Fail1305:
    { 
      IStrategoTerm o_32970 = null;
      IStrategoTerm m_32970 = null;
      IStrategoTerm n_32970 = null;
      IStrategoTerm p_32970 = null;
      if(term.getTermType() != IStrategoTerm.APPL || Main._consColorer_2 != ((IStrategoAppl)term).getConstructor())
        break Fail1305;
      m_32970 = term.getSubterm(0);
      n_32970 = term.getSubterm(1);
      IStrategoList annos76 = term.getAnnotations();
      o_32970 = annos76;
      term = f_32792.invoke(context, m_32970);
      if(term == null)
        break Fail1305;
      p_32970 = term;
      term = g_32792.invoke(context, n_32970);
      if(term == null)
        break Fail1305;
      term = termFactory.annotateTerm(termFactory.makeAppl(Main._consColorer_2, new IStrategoTerm[]{p_32970, term}), checkListAnnos(termFactory, o_32970));
      context.popOnSuccess();
      if(true)
        return term;
    }
    context.popOnFailure();
    return null;
  }
}
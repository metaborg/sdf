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

@SuppressWarnings("all") public class $Attribute_3_0 extends Strategy 
{ 
  public static $Attribute_3_0 instance = new $Attribute_3_0();

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term, Strategy g_32790, Strategy h_32790, Strategy i_32790)
  { 
    ITermFactory termFactory = context.getFactory();
    context.push("Attribute_3_0");
    Fail1270:
    { 
      IStrategoTerm k_32965 = null;
      IStrategoTerm h_32965 = null;
      IStrategoTerm i_32965 = null;
      IStrategoTerm j_32965 = null;
      IStrategoTerm l_32965 = null;
      IStrategoTerm m_32965 = null;
      if(term.getTermType() != IStrategoTerm.APPL || Main._consAttribute_3 != ((IStrategoAppl)term).getConstructor())
        break Fail1270;
      h_32965 = term.getSubterm(0);
      i_32965 = term.getSubterm(1);
      j_32965 = term.getSubterm(2);
      IStrategoList annos43 = term.getAnnotations();
      k_32965 = annos43;
      term = g_32790.invoke(context, h_32965);
      if(term == null)
        break Fail1270;
      l_32965 = term;
      term = h_32790.invoke(context, i_32965);
      if(term == null)
        break Fail1270;
      m_32965 = term;
      term = i_32790.invoke(context, j_32965);
      if(term == null)
        break Fail1270;
      term = termFactory.annotateTerm(termFactory.makeAppl(Main._consAttribute_3, new IStrategoTerm[]{l_32965, m_32965, term}), checkListAnnos(termFactory, k_32965));
      context.popOnSuccess();
      if(true)
        return term;
    }
    context.popOnFailure();
    return null;
  }
}
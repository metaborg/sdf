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

@SuppressWarnings("all") public class $Line_1_0 extends Strategy 
{ 
  public static $Line_1_0 instance = new $Line_1_0();

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term, Strategy m_32794)
  { 
    ITermFactory termFactory = context.getFactory();
    context.push("Line_1_0");
    Fail1338:
    { 
      IStrategoTerm i_32976 = null;
      IStrategoTerm h_32976 = null;
      if(term.getTermType() != IStrategoTerm.APPL || Main._consLine_1 != ((IStrategoAppl)term).getConstructor())
        break Fail1338;
      h_32976 = term.getSubterm(0);
      IStrategoList annos109 = term.getAnnotations();
      i_32976 = annos109;
      term = m_32794.invoke(context, h_32976);
      if(term == null)
        break Fail1338;
      term = termFactory.annotateTerm(termFactory.makeAppl(Main._consLine_1, new IStrategoTerm[]{term}), checkListAnnos(termFactory, i_32976));
      context.popOnSuccess();
      if(true)
        return term;
    }
    context.popOnFailure();
    return null;
  }
}
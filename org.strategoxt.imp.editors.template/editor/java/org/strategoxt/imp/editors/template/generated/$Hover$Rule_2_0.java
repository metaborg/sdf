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

@SuppressWarnings("all") public class $Hover$Rule_2_0 extends Strategy 
{ 
  public static $Hover$Rule_2_0 instance = new $Hover$Rule_2_0();

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term, Strategy s_32793, Strategy t_32793)
  { 
    ITermFactory termFactory = context.getFactory();
    context.push("HoverRule_2_0");
    Fail1324:
    { 
      IStrategoTerm h_32974 = null;
      IStrategoTerm f_32974 = null;
      IStrategoTerm g_32974 = null;
      IStrategoTerm i_32974 = null;
      if(term.getTermType() != IStrategoTerm.APPL || Main._consHoverRule_2 != ((IStrategoAppl)term).getConstructor())
        break Fail1324;
      f_32974 = term.getSubterm(0);
      g_32974 = term.getSubterm(1);
      IStrategoList annos95 = term.getAnnotations();
      h_32974 = annos95;
      term = s_32793.invoke(context, f_32974);
      if(term == null)
        break Fail1324;
      i_32974 = term;
      term = t_32793.invoke(context, g_32974);
      if(term == null)
        break Fail1324;
      term = termFactory.annotateTerm(termFactory.makeAppl(Main._consHoverRule_2, new IStrategoTerm[]{i_32974, term}), checkListAnnos(termFactory, h_32974));
      context.popOnSuccess();
      if(true)
        return term;
    }
    context.popOnFailure();
    return null;
  }
}
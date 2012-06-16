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

@SuppressWarnings("all") public class $Color$Def_2_0 extends Strategy 
{ 
  public static $Color$Def_2_0 instance = new $Color$Def_2_0();

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term, Strategy a_9752, Strategy b_9752)
  { 
    ITermFactory termFactory = context.getFactory();
    context.push("ColorDef_2_0");
    Fail451:
    { 
      IStrategoTerm h_9927 = null;
      IStrategoTerm f_9927 = null;
      IStrategoTerm g_9927 = null;
      IStrategoTerm i_9927 = null;
      if(term.getTermType() != IStrategoTerm.APPL || Main._consColorDef_2 != ((IStrategoAppl)term).getConstructor())
        break Fail451;
      f_9927 = term.getSubterm(0);
      g_9927 = term.getSubterm(1);
      IStrategoList annos26 = term.getAnnotations();
      h_9927 = annos26;
      term = a_9752.invoke(context, f_9927);
      if(term == null)
        break Fail451;
      i_9927 = term;
      term = b_9752.invoke(context, g_9927);
      if(term == null)
        break Fail451;
      term = termFactory.annotateTerm(termFactory.makeAppl(Main._consColorDef_2, new IStrategoTerm[]{i_9927, term}), checkListAnnos(termFactory, h_9927));
      context.popOnSuccess();
      if(true)
        return term;
    }
    context.popOnFailure();
    return null;
  }
}
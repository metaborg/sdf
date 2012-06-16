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

@SuppressWarnings("all") public class $Fence$Def_2_0 extends Strategy 
{ 
  public static $Fence$Def_2_0 instance = new $Fence$Def_2_0();

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term, Strategy s_9752, Strategy t_9752)
  { 
    ITermFactory termFactory = context.getFactory();
    context.push("FenceDef_2_0");
    Fail461:
    { 
      IStrategoTerm a_9929 = null;
      IStrategoTerm y_9928 = null;
      IStrategoTerm z_9928 = null;
      IStrategoTerm b_9929 = null;
      if(term.getTermType() != IStrategoTerm.APPL || Main._consFenceDef_2 != ((IStrategoAppl)term).getConstructor())
        break Fail461;
      y_9928 = term.getSubterm(0);
      z_9928 = term.getSubterm(1);
      IStrategoList annos35 = term.getAnnotations();
      a_9929 = annos35;
      term = s_9752.invoke(context, y_9928);
      if(term == null)
        break Fail461;
      b_9929 = term;
      term = t_9752.invoke(context, z_9928);
      if(term == null)
        break Fail461;
      term = termFactory.annotateTerm(termFactory.makeAppl(Main._consFenceDef_2, new IStrategoTerm[]{b_9929, term}), checkListAnnos(termFactory, a_9929));
      context.popOnSuccess();
      if(true)
        return term;
    }
    context.popOnFailure();
    return null;
  }
}
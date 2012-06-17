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

@SuppressWarnings("all") public class $Outliner_2_0 extends Strategy 
{ 
  public static $Outliner_2_0 instance = new $Outliner_2_0();

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term, Strategy h_32792, Strategy i_32792)
  { 
    ITermFactory termFactory = context.getFactory();
    context.push("Outliner_2_0");
    Fail1306:
    { 
      IStrategoTerm t_32970 = null;
      IStrategoTerm r_32970 = null;
      IStrategoTerm s_32970 = null;
      IStrategoTerm u_32970 = null;
      if(term.getTermType() != IStrategoTerm.APPL || Main._consOutliner_2 != ((IStrategoAppl)term).getConstructor())
        break Fail1306;
      r_32970 = term.getSubterm(0);
      s_32970 = term.getSubterm(1);
      IStrategoList annos77 = term.getAnnotations();
      t_32970 = annos77;
      term = h_32792.invoke(context, r_32970);
      if(term == null)
        break Fail1306;
      u_32970 = term;
      term = i_32792.invoke(context, s_32970);
      if(term == null)
        break Fail1306;
      term = termFactory.annotateTerm(termFactory.makeAppl(Main._consOutliner_2, new IStrategoTerm[]{u_32970, term}), checkListAnnos(termFactory, t_32970));
      context.popOnSuccess();
      if(true)
        return term;
    }
    context.popOnFailure();
    return null;
  }
}
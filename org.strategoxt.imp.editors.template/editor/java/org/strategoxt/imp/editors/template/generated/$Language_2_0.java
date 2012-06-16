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

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term, Strategy c_9754, Strategy d_9754)
  { 
    ITermFactory termFactory = context.getFactory();
    context.push("Language_2_0");
    Fail488:
    { 
      IStrategoTerm u_9932 = null;
      IStrategoTerm s_9932 = null;
      IStrategoTerm t_9932 = null;
      IStrategoTerm v_9932 = null;
      if(term.getTermType() != IStrategoTerm.APPL || Main._consLanguage_2 != ((IStrategoAppl)term).getConstructor())
        break Fail488;
      s_9932 = term.getSubterm(0);
      t_9932 = term.getSubterm(1);
      IStrategoList annos61 = term.getAnnotations();
      u_9932 = annos61;
      term = c_9754.invoke(context, s_9932);
      if(term == null)
        break Fail488;
      v_9932 = term;
      term = d_9754.invoke(context, t_9932);
      if(term == null)
        break Fail488;
      term = termFactory.annotateTerm(termFactory.makeAppl(Main._consLanguage_2, new IStrategoTerm[]{v_9932, term}), checkListAnnos(termFactory, u_9932));
      context.popOnSuccess();
      if(true)
        return term;
    }
    context.popOnFailure();
    return null;
  }
}